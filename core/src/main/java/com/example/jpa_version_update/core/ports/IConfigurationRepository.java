package com.example.jpa_version_update.core.ports;

import com.example.jpa_version_update.core.model.IConfiguration;

public interface IConfigurationRepository {
    IConfiguration save(IConfiguration configuration);
}
