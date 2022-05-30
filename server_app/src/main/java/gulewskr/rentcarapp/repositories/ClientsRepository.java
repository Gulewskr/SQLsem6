package gulewskr.rentcarapp.repositories;

import gulewskr.rentcarapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<User, Long> {
}
