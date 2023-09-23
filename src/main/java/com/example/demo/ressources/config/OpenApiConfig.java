package com.example.demo.ressources.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Diese Klasse konfiguriert die OpenAPI-Dokumentation für das Projekt.
 * Es setzt insbesondere einen Sicherheitsmechanismus mit Bearer-Token (JWT) für die API-Dokumentation.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Definiert und konfiguriert die OpenAPI-Dokumentation für das Projekt.
     *
     * @return Ein OpenAPI-Objekt mit den für die Dokumentation notwendigen Konfigurationen.
     */
    @Bean
    public OpenAPI customOpenAPI() {

        // Name des Sicherheitsschemas, das in der API-Dokumentation verwendet wird.
        final String securitySchemeName = "bearerAuth";

        // Erstellt und gibt ein OpenAPI-Objekt zurück, das das Sicherheitsschema und
        // andere notwendige Komponenten enthält.
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                );
    }
}
