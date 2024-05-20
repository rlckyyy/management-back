package relucky.code.config;


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
//    private String oidcIssuerLocation;
//
//    @Bean
//    SecurityFilterChain oauth2FilterChain(
//            HttpSecurity http
//    ) throws Exception {
//        http
//                .authorizeHttpRequests(
//                        auth -> {
//                            auth.requestMatchers(
//                                            "/api-docs/**",
//                                            "/swagger-ui/**",
//                                            "/swagger-ui.html"
//                                    ).permitAll()
//                                    .requestMatchers("/admin/**").hasRole("ADMIN")
//                                    .anyRequest().authenticated();
//                        }
//                )
//                .cors(Customizer.withDefaults())
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder())));
//        return http.build();
//    }
//
//    @Bean
//    JwtDecoder jwtDecoder() {
//        return JwtDecoders.fromIssuerLocation(oidcIssuerLocation);
//    }
//}
