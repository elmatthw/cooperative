package by.bsuir.reguisites.repository;

import by.bsuir.reguisites.model.SupervisorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface SupervisorRepository extends MongoRepository<SupervisorEntity, String> {
}
