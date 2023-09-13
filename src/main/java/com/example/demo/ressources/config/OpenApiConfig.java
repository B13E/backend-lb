/*
package com.example.demo.ressources;

public class OpenApiConfig {
    @Configuration
    public class OpenApiConfig {

        @Bean
        public OpenAPI customOpenAPI() {
            final String securitySchemeName = "bearerAuth";
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
}
*/