package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Hire;

import java.util.List;

public interface IHireService {
    Hire add(Hire hire);
    Hire getById(long id);
    List<Hire> getAll();
    Hire update(Hire hire);
    void deleteById(long id);

    List<Hire> getByClientId(long id);
    List<Hire> getByAutoId(long id);
}
