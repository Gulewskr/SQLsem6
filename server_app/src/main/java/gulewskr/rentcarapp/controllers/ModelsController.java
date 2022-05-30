package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.model.CreateModel;
import gulewskr.rentcarapp.entities.Model;
import gulewskr.rentcarapp.entities.User;
import gulewskr.rentcarapp.services.MarksService;
import gulewskr.rentcarapp.services.ModelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
public class ModelsController {
    @Autowired
    ModelsService service;
    @Autowired
    MarksService marksService;

    @GetMapping()
    public ResponseEntity<Object> getAll()
    {
        List<Model> d = service.getAll();
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> GetByID(@PathVariable Long id)
    {
        Model d = service.getById(id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, d);
    }

    @PostMapping
    public ResponseEntity<Object> Add(@RequestBody CreateModel d)
    {
        Model m = new Model();
        m.setName(d.getName());
        m.setMark(marksService.getById(d.getMark()));
        m = service.add(m);
        return ResponseHandler.generateResponse("Created ...", HttpStatus.OK, m);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> Update(@PathVariable Long id, @RequestBody CreateModel d)
    {
        Model m = service.getById(id);
        m.setName(d.getName());
        m.setMark(marksService.getById(d.getMark()));
        return ResponseHandler.generateResponse("Updated ...", HttpStatus.OK, m);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> DeleteById(@PathVariable Long id)
    {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, null);
    }

    @GetMapping("{ids}")
    public ResponseEntity<Object> GetByMarkID(@PathVariable Long[] ids)
    {
        List<Model> d = new LinkedList<Model>();
        for ( Long id : ids )
        {
            d.addAll( service.getByMarkID(id) );
        }
        return ResponseHandler.generateResponse("Deleted ...", HttpStatus.OK, d);
    }
}
