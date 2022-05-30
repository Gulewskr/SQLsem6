package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.client.CreateClient;
import gulewskr.rentcarapp.entities.Client;
import gulewskr.rentcarapp.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {
    @Autowired
    ClientService service;

    @GetMapping()
    public ResponseEntity<Object> getAll()
    {
        List<Client> x = service.getAll();
        return ResponseHandler.generateResponse("GetAll ...", HttpStatus.OK, x);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable long id)
    {
        Client x = service.getById(id);
        return ResponseHandler.generateResponse("GetSingle ...", HttpStatus.OK, x);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateClient d)
    {
        Client m = new Client();
        m.setName(d.getName());
        m.setSurname(d.getSurname());
        m.setEmail(d.getEmail());
        m.setBorndate(d.getBorndate());
        m.setPhonenumber(d.getPhonenumber());
        m.setPesel(d.getPesel());
        service.add(m);
        return ResponseHandler.generateResponse("Created ...", HttpStatus.OK, null);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody CreateClient d)
    {
        Client m = service.getById(id);
        m.setName(d.getName());
        m.setSurname(d.getSurname());
        m.setEmail(d.getEmail());
        m.setBorndate(d.getBorndate());
        m.setPhonenumber(d.getPhonenumber());
        m.setPesel(d.getPesel());
        service.update(m);
        return ResponseHandler.generateResponse("Updated ...", HttpStatus.OK, m);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id)
    {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, null);
    }
}
