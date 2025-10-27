package com.example.jpa_version_update.jpa.repository;

import com.example.jpa_version_update.core.model.IConfiguration;
import com.example.jpa_version_update.core.ports.IConfigurationRepository;
import com.example.jpa_version_update.jpa.entity.UserConfiguration;
import com.example.jpa_version_update.jpa.mapper.ConfigurationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Slf4j
@Repository
public class ModuleConfigurationRepository implements IConfigurationRepository {

    private final JpaConfigurationRepository repository;
    private final ConfigurationMapper configurationMapper;

    public ModuleConfigurationRepository(JpaConfigurationRepository repository,
                                         ConfigurationMapper configurationMapper) {
        this.repository = repository;
        this.configurationMapper = configurationMapper;
    }

    @Override
    public IConfiguration save(IConfiguration model) {
        UserConfiguration moduleConfiguration = configurationMapper.mapOut(model);
        moduleConfiguration.setValidFrom(Instant.now().truncatedTo(ChronoUnit.MICROS));
        moduleConfiguration = repository.saveAndFlush(moduleConfiguration);
        return configurationMapper.mapIn(moduleConfiguration);
    }
}
