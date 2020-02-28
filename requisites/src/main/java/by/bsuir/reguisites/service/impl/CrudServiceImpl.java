package by.bsuir.reguisites.service.impl;

import by.bsuir.reguisites.exception.DataManipulateException;
import by.bsuir.reguisites.service.CrudService;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
public abstract class CrudServiceImpl<R extends MongoRepository<E, String>, E>
        implements CrudService<E> {
    private static final int FILTER_PAGE = 500;
    protected final R repository;

    public CrudServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E find(String id) throws DataManipulateException {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Collection<E> find(Collection<String> ids) throws DataManipulateException {
        return Lists.newArrayList(repository.findAllById(ids));
    }

    @Override
    public Collection<E> find(Predicate<E> predicate) throws DataManipulateException {
        ImmutableList.Builder<E> builder = ImmutableList.builder();
        int page = 0;
        Collection<E> res = findAll(page, FILTER_PAGE);
        while (!res.isEmpty()) {
            for (E e : res) {
                if (predicate.test(e)) {
                    builder.add(e);
                }
            }
            res = findAll(++page, FILTER_PAGE);
        }
        return builder.build();
    }

    @Override
    public Collection<E> find(Predicate<E> predicate, int page, int limit) throws DataManipulateException {
        Preconditions.checkArgument(limit > 0 && page >= 0);
        ImmutableList.Builder<E> builder = ImmutableList.builder();
        int localPage = 0;
        int count = 0;
        Collection<E> res = findAll(localPage, FILTER_PAGE);
        while (!res.isEmpty() || count <= limit * (page - 1) + limit) {
            for (E e : res) {
                boolean acceptable = predicate.test(e);
                if (acceptable) {
                    count++;
                }
                if (acceptable && count >= limit * (page - 1) + limit) {
                    builder.add(e);
                }
            }
            res = findAll(++localPage, FILTER_PAGE);
        }
        return builder.build();
    }

    @Override
    public Collection<E> findAll() throws DataManipulateException {
        return repository.findAll();
    }

    @Override
    public Collection<E> findAll(int page, int limit) throws DataManipulateException {
        Preconditions.checkArgument(limit > 0 && page >= 0);
        return repository.findAll(PageRequest.of(page, limit)).getContent();
    }

    @Override
    public E register(E e) throws DataManipulateException {
        return repository.insert(e);
    }
}