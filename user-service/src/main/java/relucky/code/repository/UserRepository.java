package relucky.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import relucky.code.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
