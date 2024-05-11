package relucky.code.authserver.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record RegistrationRequest(
        @NotEmpty String username,
        @Email String email,
        @NotEmpty @Size(min = 6) String password
) {
}
