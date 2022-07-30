package sv.com.tigo.apizendesk.security.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.com.tigo.apizendesk.security.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserName(String userName);
    boolean existsByUserName(String userName);
    
}
