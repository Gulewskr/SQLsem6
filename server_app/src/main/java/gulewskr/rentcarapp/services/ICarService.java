package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Car;

import java.util.List;

public interface ICarService {
    Car add(Car car);
    List<Car> getAll();
    Car getById(long id);
    Car update(Car car);
    void deleteById(long id);

    List<Car>  getByMarkId(long id);
    List<Car>  getByMarkIds(long[] ids);
    List<Car>  getByModelId(long id);
    List<Car>  getByModelIds(long[] ids);

}
