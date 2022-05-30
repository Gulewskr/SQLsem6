package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.Client;

import java.util.List;

public interface IClientService {
    Client add(Client client);
    Client getById(long id);
    List<Client> getAll();
    Client update(Client client);
    void deleteById(long id);
}
