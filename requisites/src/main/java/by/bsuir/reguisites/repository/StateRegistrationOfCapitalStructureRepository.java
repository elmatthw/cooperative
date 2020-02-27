package by.bsuir.reguisites.repository;

import main.java.by.bsuir.reguisites.model.StateRegistrationOfCapitalStructureEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface StateRegistrationOfCapitalStructureRepository
        extends MongoRepository<StateRegistrationOfCapitalStructureEntity, String> {
}
