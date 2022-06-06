package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Car;
import gulewskr.rentcarapp.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsService implements ICarService{

    @Autowired
    CarsRepository repository;

    @Override
    public Car add(Car car) {
        return repository.save(car);
    }

    @Override
    public List<Car> getAll() {
        return repository.findAll();
    }

    @Override
    public Car getById(long id) {
        return repository.getById(id);
    }

    @Override
    public Car update(Car car) {
        return repository.findById(car.getId())
                .map(old -> {
                    old.setBasicPrice(car.getBasicPrice());
                    old.setColor(car.getColor());
                    old.setEquipementList(car.getEquipementList());
                    old.setModel(car.getModel());
                    old.setPlate(car.getPlate());
                    old.setYearCar(car.getYearCar());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(car));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Car> getByMarkId(long id) {
        return null;
    }

    @Override
    public List<Car> getByMarkIds(long[] ids) {
        return null;
    }

    @Override
    public List<Car> getByModelId(long id) {
        return null;
    }

    @Override
    public List<Car> getByModelIds(long[] ids) {
        return null;
    }
}
