package com.example.jpa_version_update.jpa.repository;

import com.example.jpa_version_update.jpa.entity.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaConfigurationRepository
        extends JpaRepository<UserConfiguration, Long>, JpaSpecificationExecutor<UserConfiguration> {

}
