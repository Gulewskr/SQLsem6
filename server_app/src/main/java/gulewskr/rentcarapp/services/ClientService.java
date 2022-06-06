package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Client;
import gulewskr.rentcarapp.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    ClientsRepository repository;

    @Override
    public Client add(Client client) {
        return repository.save(client);
    }

    @Override
    public Client getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client update(Client client) {
        return repository.findById(client.getId())
                .map(old -> {
                    old.setEmail(client.getEmail());
                    old.setBorndate(client.getBorndate());
                    old.setName(client.getName());
                    old.setPesel(client.getPesel());
                    old.setPhonenumber(client.getPhonenumber());
                    old.setSurname(client.getSurname());
                    return repository.save(old);
                })
                .orElseGet(() -> repository.save(client));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
