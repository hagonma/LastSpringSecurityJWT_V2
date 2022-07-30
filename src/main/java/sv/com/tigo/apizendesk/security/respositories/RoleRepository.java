package sv.com.tigo.apizendesk.security.respositories;

import java.util.Optional;

import sv.com.tigo.apizendesk.security.entities.Role;
import sv.com.tigo.apizendesk.security.enums.RoleList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
    Optional<Role> findByRoleName(RoleList roleName);
    
}
