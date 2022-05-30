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
        return null;
    }

    @Override
    public Model getById(long id) {
        return null;
    }

    @Override
    public Model update(Model model) {
        return null;
    }

    @Override
    public void deleteById(long id) {

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
