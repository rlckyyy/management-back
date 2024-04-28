package relucky.code.model.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registeredAt;
    private String avatar;
}
