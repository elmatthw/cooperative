package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.StateRegistrationOfLegalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StateRegistrationOfLegalEntityRepository
        extends MongoRepository<StateRegistrationOfLegalEntity, String> {
}
