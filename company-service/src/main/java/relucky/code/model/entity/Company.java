package relucky.code.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Company {
    @Id
    private Long id;
    private String name;
    private String description;
}
