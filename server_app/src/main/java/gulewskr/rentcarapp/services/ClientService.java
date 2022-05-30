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
        return null;
    }

    @Override
    public Client getById(long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
