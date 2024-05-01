package relucky.code.model.entity;

import jakarta.persistence.*;
import lombok.*;
import relucky.code.model.enums.Gender;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registeredAt;
    private String avatar;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
