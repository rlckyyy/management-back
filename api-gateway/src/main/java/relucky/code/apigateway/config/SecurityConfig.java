package relucky.code.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String oidcIssuerLocation;
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http)  {
        return http.authorizeExchange(authorize -> authorize.anyExchange().authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .build();
    }
    @Bean
    JwtDecoder jwtDecoder() {
        return JwtDecoders.fromIssuerLocation(oidcIssuerLocation);
    }
}