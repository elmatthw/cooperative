package by.bsuir.rest.requisite.mapper;

import by.bsuir.reguisites.model.OrganizationEntity;
import by.bsuir.rest.common.mapper.CompactMapper;
import by.bsuir.rest.common.mapper.EntityMapper;
import by.bsuir.rest.requisite.dto.OrganizationDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends EntityMapper<OrganizationEntity, OrganizationDto> {
    @CompactMapper
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "mailingAddress", target = "mailingAddress"),
            @Mapping(source = "legalAddress", target = "legalAddress"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "supervisorId", target = "supervisorId"),
            @Mapping(source = "auditBodyId", target = "auditBodyId"),
            @Mapping(source = "collegialOrganId", target = "collegialOrganId"),
            @Mapping(source = "stateRegistrationOfLegalEntityId", target = "stateRegistrationOfLegalEntityId"),
            @Mapping(source = "charterId", target = "charterId"),
            @Mapping(source = "stateRegistrationOfCapitalStructureId", target = "stateRegistrationOfCapitalStructureId")
    })

    @BeanMapping(ignoreByDefault = true)
    OrganizationDto toDtoCompact(OrganizationEntity organizationEntity);
}
