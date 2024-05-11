package relucky.code.authserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import relucky.code.authserver.dto.RegistrationRequest;
import relucky.code.authserver.service.AuthService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    void register(
            @RequestBody @Validated RegistrationRequest request
    ) {
        authService.register(request);
    }
}
