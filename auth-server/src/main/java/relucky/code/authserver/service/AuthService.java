package relucky.code.authserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import relucky.code.authserver.dto.RegistrationRequest;
import relucky.code.authserver.entity.User;
import relucky.code.authserver.exception.UserAlreadyExistsException;
import relucky.code.authserver.repository.UserRepository;

@RequiredArgsConstructor
@Slf4j
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegistrationRequest request){
        if (userRepository.existsByEmail(request.email())){
            throw new UserAlreadyExistsException(request.email());
        }

        var user = new User();
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setUsername(request.username());
        userRepository.save(user);
    }

}
