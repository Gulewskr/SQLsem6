package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Equipment;

import java.util.List;

public interface IEquipmentService {
    Equipment add(Equipment equipment);
    Equipment getById(long id);
    List<Equipment> getAll();
    Equipment update(Equipment equipment);
    void deleteById(long id);
}
