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
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    @Override
    public Car getById(long id) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void deleteById(long id) {

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
