package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Mark;

import java.util.List;

public interface IMarkServices {
    Mark add(Mark mark);
    List<Mark> getAll();
    Mark getById(long id);
    Mark Edit(Mark mark);
    void deleteById(long id);
}
