package com.example.jpa_version_update.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class DataSource implements AbstractDatasource {

    private String id;

    private int version;

    private String url;

    private String name;

}
