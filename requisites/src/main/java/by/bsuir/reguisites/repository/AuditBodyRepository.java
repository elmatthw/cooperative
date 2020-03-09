package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.AuditBodyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditBodyRepository extends MongoRepository<AuditBodyEntity, String> {
}
