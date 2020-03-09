package by.bsuir.rest;

import by.bsuir.reguisites.model.AuditBodyEntity;
import by.bsuir.reguisites.model.CharterEntity;
import by.bsuir.reguisites.model.CollegialOrganEntity;
import by.bsuir.reguisites.model.OrganizationEntity;
import by.bsuir.reguisites.model.StateRegistrationOfCapitalStructureEntity;
import by.bsuir.reguisites.model.StateRegistrationOfLegalEntity;
import by.bsuir.reguisites.model.SupervisorEntity;
import com.google.common.collect.ImmutableList;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    private final MongoTemplate mongoTemplate;
    private final MongoMappingContext mongoMappingContext;

    public MongoConfig(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
        this.mongoTemplate = mongoTemplate;
        this.mongoMappingContext = mongoMappingContext;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        for (Class<?> aClass : ImmutableList.of(AuditBodyEntity.class,
                CharterEntity.class,
                CollegialOrganEntity.class,
                OrganizationEntity.class,
                StateRegistrationOfCapitalStructureEntity.class,
                StateRegistrationOfLegalEntity.class,
                SupervisorEntity.class)) {
            IndexOperations indexOps = mongoTemplate.indexOps(aClass);
            IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
            resolver.resolveIndexFor(aClass).forEach(indexOps::ensureIndex);
        }
    }

}