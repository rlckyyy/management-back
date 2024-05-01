package relucky.code.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import relucky.code.common.client.StorageClient;
import relucky.code.common.exception.EmailRegisteredAlreadyException;
import relucky.code.common.exception.EntityNotFoundException;
import relucky.code.common.exception.UserWithEmailNotFoundException;
import relucky.code.common.mapper.UserMapper;
import relucky.code.model.entity.User;
import relucky.code.repository.UserRepository;
import relucky.code.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final StorageClient storageClient;

    @Override
    public User getMe() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var jwt = (Jwt) auth.getPrincipal();
        var email = jwt.getClaimAsString("email");
        return userRepository.findByEmail(email).orElseThrow(() -> new UserWithEmailNotFoundException(email));
    }

    @Override
    public User save() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var jwt = (Jwt) auth.getPrincipal();
        var email = jwt.getClaimAsString("email");
        User user = User.builder()
                .email(email)
                .build();
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(User.class, id));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
