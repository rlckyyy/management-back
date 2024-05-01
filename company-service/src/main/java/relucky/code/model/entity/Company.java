package relucky.code.model.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Company {
    @Id
    private String id;
    private String name;
    private String description;
    private List<Long> employeeList;
}
