package gulewskr.rentcarapp.repositories;

import gulewskr.rentcarapp.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipment, Long> {
}
