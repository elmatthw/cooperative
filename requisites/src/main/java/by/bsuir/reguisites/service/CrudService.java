package by.bsuir.reguisites.service;

import com.mongodb.lang.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Collection;
import java.util.function.Predicate;

@ParametersAreNonnullByDefault
public interface CrudService<E> {
    @Nullable
    E find(String id);
    Collection<E> find(Collection<String> ids);
    Collection<E> find(Predicate<E> predicate);
    Collection<E> find(Predicate<E> predicate, int page, int limit);
    Collection<E> findAll();
    Collection<E> findAll(int page, int limit);
    E register(E e);
    E update(E e);
}
