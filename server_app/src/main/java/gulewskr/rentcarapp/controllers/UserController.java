package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.user.CreateUser;
import gulewskr.rentcarapp.entities.User;
import gulewskr.rentcarapp.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UsersService service;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers()
    {
        List<User> d = service.getAll();
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @GetMapping("{userId}")
    public ResponseEntity<Object> getUserById(@PathVariable Long userId)
    {
        User d = service.getById(userId);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PutMapping("{userId}")
    public ResponseEntity<Object> updateDescriptionById(@RequestBody CreateUser user, @PathVariable Long userId)
    {
        User updatedUser = service.getById(userId);
        if(updatedUser == null)
        {
            return ResponseHandler.generateResponse("User with ID=" + userId + " not found"  , HttpStatus.BAD_REQUEST, null);
        }
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setLogin(user.getLogin());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setType(user.getType());
        service.updateAccount(updatedUser);
        return ResponseHandler.generateResponse("", HttpStatus.OK, updatedUser);
    }

    @PostMapping()
    public ResponseEntity<Object> addNewDescription(@RequestBody CreateUser user)
    {
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setFirstname(user.getFirstname());
        newUser.setPhone(user.getPhone());
        newUser.setLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        newUser.setSurname(user.getSurname());
        newUser.setType(user.getType());
        User addedUser = service.add(newUser);
        return ResponseHandler.generateResponse("Updated Description", HttpStatus.OK, addedUser);
    }
}
