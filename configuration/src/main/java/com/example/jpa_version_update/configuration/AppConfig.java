package com.example.jpa_version_update.configuration;

import com.example.jpa_version_update.configuration.serializer.BigDecimalPlainSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.math.BigDecimal;

@Configuration
@EnableAsync
public class AppConfig {

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer bigDecimalPlainCustomizer() {
        return builder -> builder.serializerByType(BigDecimal.class, new BigDecimalPlainSerializer());
    }

}
