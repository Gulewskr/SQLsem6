package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Mark;
import gulewskr.rentcarapp.repositories.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService implements IMarkServices {

    final
    MarkRepository repository;

    public MarksService(MarkRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mark add(Mark mark) {
        return repository.save(mark);
    }

    @Override
    public List<Mark> getAll() {
        return repository.findAll();
    }

    @Override
    public Mark getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Mark Edit(Mark mark) {
       return repository.findById(mark.getId())
                .map(old -> {
                    old.setName(mark.getName());
                    old.setLogoSrc(mark.getLogoSrc());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(mark));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
