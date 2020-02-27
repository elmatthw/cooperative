package by.bsuir.reguisites.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@Document(collection = "organization")
@AllArgsConstructor
public class OrganizationEntity {

    @Id
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field
    private String mailingAddress;

    @Field
    private String legalAddress;

    @Field
    private String email;

    @Field
    private String supervisorId;

    @Field
    private String auditBodyId;

    @Field
    private String collegialOrganId;

    @Field
    private List<String> stateRegistrationOfLegalEntityId;

    @Field
    private List<String> charterId;

    @Field
    private List<String> stateRegistrationOfCapitalStructureId;
}
