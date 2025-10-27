package com.example.jpa_version_update.core.model;

public interface IConfiguration {

    Long getId();

    void setId(Long id);

    int getVersion();

    void setVersion(int version);

    java.time.Instant getValidFrom();

    java.time.Instant getValidTo();

    Object getConfiguration();

    void setConfiguration(Object configuration);

    java.time.Instant getCreatedAt();

    void setCreatedAt(java.time.Instant createdAt);
}
