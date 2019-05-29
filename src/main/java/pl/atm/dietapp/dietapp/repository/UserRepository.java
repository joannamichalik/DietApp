package pl.atm.dietapp.dietapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.atm.dietapp.dietapp.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
