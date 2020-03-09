package by.bsuir.reguisites.service.impl;

import by.bsuir.reguisites.exception.DataManipulateException;
import by.bsuir.reguisites.model.OrganizationEntity;
import by.bsuir.reguisites.repository.OrganizationRepository;
import by.bsuir.reguisites.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.ParametersAreNonnullByDefault;

@Service
@ParametersAreNonnullByDefault
public class OrganizationServiceImpl extends CrudServiceImpl<OrganizationRepository, OrganizationEntity>
        implements OrganizationService {

    public OrganizationServiceImpl(OrganizationRepository repository) {
        super(repository);
    }

    @Override
    public OrganizationEntity update(OrganizationEntity organization) {
        if (repository.findById(organization.getId()).isPresent()) {
            return repository.save(organization);
        }
        throw new DataManipulateException();
    }
}
