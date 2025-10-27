package com.example.jpa_version_update.jpa.repository;

import com.example.jpa_version_update.core.model.Entity;
import com.example.jpa_version_update.core.model.Config;
import com.example.jpa_version_update.core.model.UserConfiguration;
import com.example.jpa_version_update.core.ports.IEntityRepository;
import com.example.jpa_version_update.core.ports.IConfigurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class EntityRepository implements IEntityRepository {

    private final IConfigurationRepository configurationRepository;

    @Override
    @Transactional
    public Entity saveEntityInsideNewConfiguration(final Entity entityToPersist) {
        createConfigurationWithEntity(entityToPersist);
        return entityToPersist;
    }

    private void createConfigurationWithEntity(Entity entityToPersist) {
        var userConfiguration = new UserConfiguration();
        var config = new Config();
        config.setUserEntities(List.of(entityToPersist));
        userConfiguration.setConfiguration(config);

        final var savedConfiguration = configurationRepository.save(userConfiguration);
        // the API users use the id and version information, so returning them inside the payload is mandatory.
        // commenting these lines shouldn't change the original behavior
        entityToPersist.setId(savedConfiguration.getId());
        entityToPersist.setVersion(savedConfiguration.getVersion());
    }
}
