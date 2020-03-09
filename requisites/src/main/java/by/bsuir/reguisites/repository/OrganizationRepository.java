package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.OrganizationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends MongoRepository<OrganizationEntity, String> {
}
