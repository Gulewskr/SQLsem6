package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Equipment;
import gulewskr.rentcarapp.repositories.EquipementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipementService implements IEquipmentService {

    @Autowired
    EquipementRepository repository;

    @Override
    public Equipment add(Equipment equipment) {
        return repository.save(equipment);
    }

    @Override
    public Equipment getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Equipment> getAll() {
        return repository.findAll();
    }

    @Override
    public Equipment update(Equipment equipment) {
        return repository.findById(equipment.getId())
                .map(old -> {
                    old.setShortname(equipment.getShortname());
                    old.setPriceCoeff(equipment.getPriceCoeff());
                    old.setPrice(equipment.getPrice());
                    old.setDescription(equipment.getDescription());
                    old.setName(equipment.getName());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(equipment));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
