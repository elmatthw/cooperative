package by.bsuir.rest.requisite.dto;

import by.bsuir.rest.requisite.IDValidationGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.List;

@Data
public class OrganizationDto {
    @Null
    @NotBlank(groups = IDValidationGroup.class)
    private String id;

    @NotBlank
    private String mailingAddress;

    @NotBlank
    private String legalAddress;

    @NotBlank
    private String email;

    @NotBlank
    private String supervisorId;

    @NotBlank
    private String auditBodyId;

    @NotBlank
    private String collegialOrganId;

    @NotBlank
    private List<String> stateRegistrationOfLegalEntityId;

    @NotBlank
    private List<String> charterId;

    @NotBlank
    private List<String> stateRegistrationOfCapitalStructureId;
}