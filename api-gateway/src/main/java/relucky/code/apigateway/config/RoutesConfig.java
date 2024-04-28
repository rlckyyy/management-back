package relucky.code.apigateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// sXRqCbOkJ21mxfeZ7QCjXfDTZfYC6irE
@Configuration
public class RoutesConfig {
    @Value("${spring.cloud.gateway.routes.company-service-url}")
    private String companyServiceUrl;
    @Value("${spring.cloud.gateway.routes.user-service-url}")
    private String userServiceUrl;
    @Value("${spring.cloud.gateway.routes.storage-service-url}")
    private String storageServiceUrl;
    @Value("${spring.cloud.gateway.routes.mail-service-url}")
    private String mailServiceUrl;

    @Bean
    RouteLocator routeLocator(
            RouteLocatorBuilder locatorBuilder
    ) {
        return locatorBuilder.routes()
                .route("company-service", r -> r.path("/api/v1/company/**").uri(companyServiceUrl))
                .route("user-service", r -> r.path("/api/v1/user/**").uri(userServiceUrl))
                .route("storage-service", r -> r.path("/api/v1/storage/**").uri(storageServiceUrl))
                .route("mail-service", r -> r.path("/api/v1/mail/**").uri(mailServiceUrl))
                .build();
    }
}
