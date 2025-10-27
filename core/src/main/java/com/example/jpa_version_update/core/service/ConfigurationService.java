package com.example.jpa_version_update.core.service;

import com.example.jpa_version_update.core.model.DataSource;
import com.example.jpa_version_update.core.model.Entity;
import com.example.jpa_version_update.core.model.FaultyDataSource;
import com.example.jpa_version_update.core.ports.IEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final IEntityRepository entityRepository;

    public Entity faultyCreate(final Entity createEntity) {
        if (createEntity == null) {
            throw new IllegalArgumentException("Payload is required");
        }
        if (createEntity.getDatasource() != null) {
            throw new IllegalArgumentException("DataSource is read only");
        }

        createEntity.setFaultyDataSource(faultyDatasource());

        return entityRepository.saveEntityInsideNewConfiguration(createEntity);
    }

    public Entity create(final Entity createEntity) {
        if (createEntity == null) {
            throw new IllegalArgumentException("Payload is required");
        }
        if (createEntity.getDatasource() != null) {
            throw new IllegalArgumentException("DataSource is read only");
        }

        createEntity.setDatasource(standardDatasource());

        return entityRepository.saveEntityInsideNewConfiguration(createEntity);
    }

    private static DataSource standardDatasource() {
        final DataSource dataSource = new DataSource();
        dataSource.setId("1");
        dataSource.setUrl("url");
        dataSource.setName("name");
        return dataSource;
    }

    private static FaultyDataSource faultyDatasource() {
        final FaultyDataSource dataSource = new FaultyDataSource();
        dataSource.setId(1L); // Supposed cause
        dataSource.setUrl("url");
        dataSource.setName("name");
        return dataSource;
    }
}
