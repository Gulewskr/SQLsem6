package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.client.CreateClient;
import gulewskr.rentcarapp.data.domain.hire.CreateHire;
import gulewskr.rentcarapp.entities.Client;
import gulewskr.rentcarapp.entities.Hire;
import gulewskr.rentcarapp.services.CarsService;
import gulewskr.rentcarapp.services.ClientService;
import gulewskr.rentcarapp.services.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hire")
public class HireController {
    @Autowired
    HireService service;
    @Autowired
    CarsService carsService;
    @Autowired
    ClientService clientService;

    @GetMapping()
    public ResponseEntity<Object> getAll()
    {
        List<Hire> d = service.getAll();
        return ResponseHandler.generateResponse("GetAll ...", HttpStatus.OK, d);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable long id)
    {
        Hire d = service.getById(id);
        return ResponseHandler.generateResponse("GetSingle ...", HttpStatus.OK, d);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateHire d)
    {
        Hire m = new Hire();
        m.setCar(carsService.getById(d.getCar()));
        m.setClient(clientService.getById(d.getClient()));
        m.setDays(d.getDays());
        m.setStartDate(d.getStartDate());
        m.setEndDate(d.getEndDate());
        m.setPrice(d.getPrice());
        m = service.add(m);
        return ResponseHandler.generateResponse("Created ...", HttpStatus.OK, m);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody CreateHire d)
    {
        Hire m = service.getById(id);
        m.setCar(carsService.getById(d.getCar()));
        m.setClient(clientService.getById(d.getClient()));
        m.setDays(d.getDays());
        m.setStartDate(d.getStartDate());
        m.setEndDate(d.getEndDate());
        m.setPrice(d.getPrice());
        service.update(m);
        return ResponseHandler.generateResponse("Updated ...", HttpStatus.OK, m);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(@PathVariable long id)
    {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, null);
    }

    @GetMapping("client/{id}")
    public ResponseEntity<Object> getByClientId(@PathVariable long id)
    {
        //TODO
        Hire d = service.getById(id);
        return ResponseHandler.generateResponse("GetSingle ...", HttpStatus.OK, d);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Object> getByCarId(@PathVariable long id)
    {
        //TODO
        Hire d = service.getById(id);
        return ResponseHandler.generateResponse("GetSingle ...", HttpStatus.OK, d);
    }

}
