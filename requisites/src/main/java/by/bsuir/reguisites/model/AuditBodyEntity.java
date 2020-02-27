package by.bsuir.reguisites.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "audit_body")
public class AuditBodyEntity {
}
