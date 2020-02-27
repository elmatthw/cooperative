package by.bsuir.reguisites.repository;

import main.java.by.bsuir.reguisites.model.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {
}
