package gulewskr.rentcarapp.repositories;;

import gulewskr.rentcarapp.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepository extends JpaRepository<Car, Long> {
}
