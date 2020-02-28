package by.bsuir.rest.requisite.controller;

import by.bsuir.reguisites.model.OrganizationEntity;
import by.bsuir.reguisites.service.OrganizationService;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.requisite.dto.OrganizationDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/organization",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController
        extends CrudController<OrganizationService, OrganizationDto, OrganizationEntity> {

    public OrganizationController(OrganizationService organizationService,
                                  EntityMapper<OrganizationDto, OrganizationEntity> entityMapper) {
        super(organizationService, entityMapper);
    }
}
