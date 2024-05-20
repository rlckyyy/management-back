package relucky.code.apigateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.session.data.redis.ReactiveRedisSessionRepository;
import org.springframework.session.web.server.session.SpringSessionWebSessionStore;
import org.springframework.web.server.session.DefaultWebSessionManager;
import org.springframework.web.server.session.WebSessionManager;
import org.springframework.web.server.session.WebSessionStore;

import java.util.Arrays;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        var staticResources = Arrays.stream(StaticResourceLocation.values()).flatMap(StaticResourceLocation::getPatterns).toArray(String[]::new);

        return http
                .authorizeExchange(authorize -> authorize
                        .pathMatchers(staticResources).permitAll()
                        .pathMatchers("/oauth2/**").permitAll()
                        .pathMatchers("/authorization/**").permitAll()
                        .anyExchange().authenticated())
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .oauth2Login(Customizer.withDefaults())
                .build();
    }

    @Bean
    WebSessionManager webSessionManager(WebSessionStore sessionStore) {
        DefaultWebSessionManager webSessionManager = new DefaultWebSessionManager();
        webSessionManager.setSessionStore(sessionStore);
        return webSessionManager;
    }

    @Bean
    WebSessionStore sessionStore(ReactiveRedisTemplate<String, Object> reactiveRedisTemplate) {
        return new SpringSessionWebSessionStore<>(new ReactiveRedisSessionRepository(reactiveRedisTemplate));
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}