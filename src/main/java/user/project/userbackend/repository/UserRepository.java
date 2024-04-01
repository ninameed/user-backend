package user.project.userbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.project.userbackend.entity.User;

// The repository interface extends JPA repository interface which gives the
// repository CRUD methods to perform CRUD database operations
// on the User JPA entity
public interface UserRepository extends JpaRepository<User, Long> { }
