package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {
}
