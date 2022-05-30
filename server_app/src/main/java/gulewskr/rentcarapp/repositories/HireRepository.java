package gulewskr.rentcarapp.repositories;

import gulewskr.rentcarapp.entities.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {
}
