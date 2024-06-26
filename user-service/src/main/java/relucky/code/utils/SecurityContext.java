package relucky.code.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@UtilityClass
public class SecurityContext {
    public DefaultOidcUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("No authentication data available");
        }
        return (DefaultOidcUser) authentication.getPrincipal();
    }
}
