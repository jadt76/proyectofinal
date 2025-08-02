package com.shaddai.proyectofinal.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI ecommerceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("E-Commerce API")
                        .description("API para tienda de indumentaria deportiva")
                        .version("v1.0")
                        .license(new License().name("Apache 2.0").url("https://shaddai.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación completa")
                        .url("https://shaddai.com/docs"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-apis")
                .pathsToMatch("/api/**")
                .build();
    }
}
