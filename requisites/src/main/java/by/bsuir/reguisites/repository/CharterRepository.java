package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.CharterEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CharterRepository extends MongoRepository<CharterEntity, String> {
}
