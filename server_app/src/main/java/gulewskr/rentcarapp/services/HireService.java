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
        return repository.save(hire);
    }

    @Override
    public Hire getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Hire> getAll() {
        return repository.findAll();
    }

    @Override
    public Hire update(Hire hire) {
        return repository.findById(hire.getId())
                .map(old -> {
                    old.setCar(hire.getCar());
                    old.setClient(hire.getClient());
                    old.setDays(hire.getDays());
                    old.setPrice(hire.getPrice());
                    old.setStartDate(hire.getStartDate());
                    old.setEndDate(hire.getEndDate());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(hire));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
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
