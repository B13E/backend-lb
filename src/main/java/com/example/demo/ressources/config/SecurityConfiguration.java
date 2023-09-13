/*
package com.example.demo.ressources;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .httpBasic().disable()
                .authorizeHttpRequests((authz) -> authz
                authz.requestMatchers("/auth/login").permitAll()
                    .requestMatchers("/swagger-ui/index.html").permitAll()
                    .requestMatchers("/swagger-ui/*").permitAll()
                    .requestMatchers("/v3/api-docs").permitAll()
                    .requestMatchers("/v3/api-docs/swagger-config").permitAll()
                    .anyRequest().authenticated()

                );
        return http.build();
    }
}
*/