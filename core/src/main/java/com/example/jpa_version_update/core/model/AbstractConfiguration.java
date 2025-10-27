package com.example.jpa_version_update.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class AbstractConfiguration extends BaseModel implements IConfiguration {
    private Instant createdAt;
    private Instant validFrom;
    private Instant validTo;
    private Object configuration;
}
