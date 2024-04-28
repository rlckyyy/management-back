package relucky.code.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import relucky.code.common.mapper.UserMapper;
import relucky.code.model.dto.UserDto;
import relucky.code.repository.UserRepository;
import relucky.code.service.UserService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void save(UserDto userDto) {
        userDto.setRegisteredAt(LocalDate.now());
        userRepository.save(userMapper.toEntity(userDto));
    }

}
