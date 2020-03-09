package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.CollegialOrganEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CollegialOrganRepository extends MongoRepository<CollegialOrganEntity, String> {
}
