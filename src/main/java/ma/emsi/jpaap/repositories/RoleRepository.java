package ma.emsi.jpaap.repositories;

import ma.emsi.jpaap.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
    Role findByRoleName(String rolename);
}
