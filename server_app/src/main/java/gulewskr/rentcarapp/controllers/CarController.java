package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.car.CreateCar;
import gulewskr.rentcarapp.data.domain.model.CreateModel;
import gulewskr.rentcarapp.entities.Car;
import gulewskr.rentcarapp.entities.Model;
import gulewskr.rentcarapp.services.CarsService;
import gulewskr.rentcarapp.services.EquipementService;
import gulewskr.rentcarapp.services.MarksService;
import gulewskr.rentcarapp.services.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gulewskr.rentcarapp.entities.Equipment;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    CarsService service;
    @Autowired
    EquipementService eqService;
    @Autowired
    ModelsService modelsService;
    @Autowired
    MarksService marksService;

    @GetMapping()
    public ResponseEntity<Object> getAll()
    {
        List<Car> d = service.getAll();
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> GetByID(@PathVariable Long id)
    {
        Car d = service.getById(id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PostMapping
    public ResponseEntity<Object> Add(@RequestBody CreateCar d)
    {
        Car m = new Car();
        m.setColor(d.getColor());
        m.setBasicPrice(d.getBasicPrice());
        List<Equipment> eqs = new ArrayList<Equipment>();
        for(int id : d.getEquipementList())
        {
            eqs.add(eqService.getById(id));
        }
        m.setEquipementList(eqs);
        m.setModel(modelsService.getById(d.getModel()));
        m.setYearCar(d.getYearCar());
        m.setPlate(d.getPlate());
        m = service.add(m);
        return ResponseHandler.generateResponse("Created ...", HttpStatus.OK, m);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> Update(@PathVariable Long id, @RequestBody CreateCar d)
    {
        Car m = service.getById(id);
        m.setColor(d.getColor());
        m.setBasicPrice(d.getBasicPrice());
        List<Equipment> eqs = new ArrayList<Equipment>();
        for(int i : d.getEquipementList())
        {
            eqs.add(eqService.getById(i));
        }
        m.setEquipementList(eqs);
        m.setModel(modelsService.getById(d.getModel()));
        m.setYearCar(d.getYearCar());
        m.setPlate(d.getPlate());
        return ResponseHandler.generateResponse("Updated ...", HttpStatus.OK, m);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id)
    {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, null);
    }

    @GetMapping("mark/{ids}")
    public ResponseEntity<Object> GetByMarkID(@PathVariable Long[] ids)
    {
        List<Car> d = new LinkedList<Car>();
        for ( Long id : ids )
        {
            //d.addAll( service.getByMarkID(id) );
        }
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, d);
    }

    @GetMapping("model/{ids}")
    public ResponseEntity<Object> GetByModelID(@PathVariable Long[] ids)
    {
        List<Car> d = new LinkedList<Car>();
        for ( Long id : ids )
        {
            //d.addAll( service.getByMarkID(id) );
        }
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, d);
    }
}
