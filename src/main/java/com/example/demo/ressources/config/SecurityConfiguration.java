package com.example.demo.ressources.config;

import com.example.demo.ressources.auth.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Klasse zur Konfiguration der Sicherheitseinstellungen der Anwendung.
 */
@Configuration
public class SecurityConfiguration {

    // Injizieren des JWT Request Filters
    private final JwtRequestFilter jwtRequestFilter;

    @Autowired
    public SecurityConfiguration(JwtRequestFilter jwtRequestFilter) {
        this.jwtRequestFilter = jwtRequestFilter;
    }

    /**
     * Definiert die Security Filter Chain der Anwendung.
     * Hier wird festgelegt, welche Anfragen zulässig sind und wie sie verarbeitet werden sollen.
     *
     * @param http HttpSecurity-Objekt zur Konfiguration der Sicherheitseinstellungen
     * @return Konfigurierte Security Filter Chain
     * @throws Exception Bei Fehlern in der Konfiguration
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Hinzufügen des jwtRequestFilter vor dem Standard-UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        // Deaktivieren des CSRF-Schutzes, da alle Anfragen erlaubt sind
        http.csrf().disable();

        // Deaktivieren der HTTP-Basic-Authentifizierung
        http.httpBasic().disable();

        // Konfiguration der Autorisierungsanfragen
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers(
                        "/users/auth/login",
                        "/swagger-ui/index.html",
                        "/swagger-ui/*",
                        "/v3/api-docs",
                        "/v3/api-docs/swagger-config"
                ).permitAll()
                // Alle anderen Anfragen sind ebenfalls erlaubt
                .anyRequest().permitAll()
        );

        // Erstellen und Rückgabe der Security Filter Chain
        return http.build();
    }
}
