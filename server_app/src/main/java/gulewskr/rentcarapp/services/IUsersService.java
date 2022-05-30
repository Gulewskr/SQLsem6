package gulewskr.rentcarapp.services;

import gulewskr.rentcarapp.entities.User;

import java.util.List;

public interface IUsersService {
    User add(User account);
    User getById(long id);
    List<User> getAll();
    void deleteById(long id);
    User updateAccount(User account);
}
