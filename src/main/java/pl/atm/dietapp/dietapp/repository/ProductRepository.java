package pl.atm.dietapp.dietapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.atm.dietapp.dietapp.entity.Product;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);
}
