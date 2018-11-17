package pl.dietician.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dietician.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
