package com.example.jpa_version_update.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserConfiguration extends AbstractConfiguration {
    private Config configuration;
    private ConfigurationType type = ConfigurationType.DEFAULT;
}
