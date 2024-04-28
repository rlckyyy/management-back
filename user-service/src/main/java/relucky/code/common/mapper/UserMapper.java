package relucky.code.common.mapper;

import org.mapstruct.Mapper;
import relucky.code.model.dto.UserDto;
import relucky.code.model.entity.User;

@Mapper
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toDto(User user);
}
