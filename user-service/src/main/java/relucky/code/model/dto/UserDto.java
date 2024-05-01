package relucky.code.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import relucky.code.model.enums.Gender;

import java.time.LocalDate;

@Data
public class UserDto {
    private String email;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registeredAt;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
