package sv.com.tigo.apizendesk.security.services;

import java.util.Optional;

import javax.transaction.Transactional;

import sv.com.tigo.apizendesk.security.entities.Role;
import sv.com.tigo.apizendesk.security.enums.RoleList;
import sv.com.tigo.apizendesk.security.respositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Optional<Role> getByRoleName(RoleList roleName){
        return roleRepository.findByRoleName(roleName);
    }
    
    
}
