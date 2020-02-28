package by.bsuir.reguisites.service;

import by.bsuir.reguisites.exception.DataManipulateException;
import by.bsuir.reguisites.model.OrganizationEntity;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface OrganizationService extends CrudService<OrganizationEntity> {
    OrganizationEntity update(OrganizationEntity organization) throws DataManipulateException;
}