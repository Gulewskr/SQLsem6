package gulewskr.rentcarapp.repositories;

import gulewskr.rentcarapp.entities.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
}
