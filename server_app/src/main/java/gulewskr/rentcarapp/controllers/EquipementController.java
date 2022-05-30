package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.equipement.CreateEquipement;
import gulewskr.rentcarapp.entities.Car;
import gulewskr.rentcarapp.entities.Equipment;
import gulewskr.rentcarapp.services.EquipementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipment")
public class EquipementController {

    @Autowired
    EquipementService service;

    @GetMapping()
    public ResponseEntity<Object> getAll()
    {
        List<Equipment> x = service.getAll();
        return ResponseHandler.generateResponse("GetAll ...", HttpStatus.OK, x);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable long id)
    {
        Equipment x = service.getById(id);
        return ResponseHandler.generateResponse("GetSingle ...", HttpStatus.OK, x);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CreateEquipement d)
    {
        Equipment m = new Equipment();
        m.setDescription(d.getDescription());
        m.setName(d.getName());
        m.setPrice(d.getPrice());
        m.setPriceCoeff(d.getPriceCoeff());
        m.setShortname(d.getShortname());
        service.add(m);
        return ResponseHandler.generateResponse("Created ...", HttpStatus.OK, null);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody CreateEquipement d)
    {
        Equipment m = service.getById(id);
        m.setDescription(d.getDescription());
        m.setName(d.getName());
        m.setPrice(d.getPrice());
        m.setPriceCoeff(d.getPriceCoeff());
        m.setShortname(d.getShortname());
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
