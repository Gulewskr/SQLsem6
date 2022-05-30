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
        return null;
    }

    @Override
    public Equipment getById(long id) {
        return null;
    }

    @Override
    public List<Equipment> getAll() {
        return null;
    }

    @Override
    public Equipment update(Equipment equipment) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
