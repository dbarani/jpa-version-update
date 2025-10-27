package com.example.jpa_version_update.rest.endpoints;

import com.example.jpa_version_update.core.model.Entity;
import com.example.jpa_version_update.core.service.ConfigurationService;
import com.example.jpa_version_update.rest.dto.UserEntityDto;
import com.example.jpa_version_update.rest.dto.UserEntityCreate;
import com.example.jpa_version_update.rest.mapper.RestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final RestMapper restMapper;
    private final ConfigurationService configurationService;

    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/configurations/user-entity/faulty"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    public ResponseEntity<UserEntityDto> createUserEntityNotWorkingAsExpected(
            @RequestBody UserEntityCreate userEntityCreate) {
        logCreateRequest(userEntityCreate);
        var entity = configurationService.faultyCreate(restMapper.mapEntityIn(userEntityCreate));
        return returnCreatedConfiguration(entity);
    }

    @RequestMapping(
        method = {RequestMethod.POST},
        value = {"/configurations/user-entity/working"},
        produces = {"application/json"},
        consumes = {"application/json"}
    )
    public ResponseEntity<UserEntityDto> createUserEntity(@RequestBody UserEntityCreate userEntityCreate) {
        logCreateRequest(userEntityCreate);
        var entity = configurationService.create(restMapper.mapEntityIn(userEntityCreate));
        return returnCreatedConfiguration(entity);
    }

    private static void logCreateRequest(UserEntityCreate userEntityCreate) {
        log.info("Creating user entity: {}", userEntityCreate);
    }

    private ResponseEntity<UserEntityDto> returnCreatedConfiguration(Entity entity) {
        var createdEntity = restMapper.mapEntityOut(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntity);
    }
}
