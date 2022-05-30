package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Hire;
import gulewskr.rentcarapp.repositories.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireService implements IHireService {

    @Autowired
    HireRepository repository;

    @Override
    public Hire add(Hire hire) {
        return null;
    }

    @Override
    public Hire getById(long id) {
        return null;
    }

    @Override
    public List<Hire> getAll() {
        return null;
    }

    @Override
    public Hire update(Hire hire) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public List<Hire> getByClientId(long id) {
        return null;
    }

    @Override
    public List<Hire> getByAutoId(long id) {
        return null;
    }
}
