package relucky.code.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relucky.code.model.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, String> {
    boolean existsByName(String name);
}
