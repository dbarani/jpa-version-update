package com.example.jpa_version_update.core.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FaultyDataSource extends BaseModel implements AbstractDatasource {

    private String name;

    private String url;
}
