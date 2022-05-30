package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.User;
import gulewskr.rentcarapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User add(User account) {
        return usersRepository.save(account);
    }

    @Override
    public User getById(long id) {
        return usersRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return usersRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public User updateAccount(User account)
    {
        return usersRepository.findById(account.getId())
                .map(old -> {
                    old.setType(account.getType());
                    old.setSurname(account.getSurname());
                    old.setPassword(account.getPassword());
                    old.setLogin(account.getLogin());
                    old.setPhone(account.getPhone());
                    old.setFirstname(account.getFirstname());
                    old.setEmail(account.getEmail());
                    return usersRepository.save(old);
                })
                .orElseGet(
                        () -> usersRepository.save(account)
                );
    }
}
