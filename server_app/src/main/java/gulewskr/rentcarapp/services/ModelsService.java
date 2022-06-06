package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Model;
import gulewskr.rentcarapp.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelsService implements IModelService {

    @Autowired
    ModelRepository repository;

    @Override
    public Model add(Model model) {
        return null;
    }

    @Override
    public List<Model> getAll() {
        return repository.findAll();
    }

    @Override
    public Model getById(long id) {
        return repository.getById(id);
    }

    @Override
    public Model update(Model model) {
        return repository.findById(model.getId())
                .map(old -> {
                    old.setMark(model.getMark());
                    old.setName(model.getName());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(model));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Model> getByMarkID(long markId) {
        return null;
    }

    @Override
    public List<Model> getByMarkIDs(long[] markId) {

        return null;
    }
}
