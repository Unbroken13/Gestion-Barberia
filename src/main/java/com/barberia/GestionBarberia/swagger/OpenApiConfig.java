package com.barberia.GestionBarberia.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPIPersonalizaca() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestión Barbería")
                        .version("0.2.0")
                        .description("Documentación de endpoints para el sistema de gestión de barbería")
                );
    }

}
