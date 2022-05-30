package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Model;

import java.util.List;

public interface IModelService {
    Model add(Model model);
    List<Model> getAll();
    Model getById(long id);
    Model update(Model model);
    void deleteById(long id);

    List<Model> getByMarkID(long markId);
    List<Model> getByMarkIDs(long[] markId);
}
