package gulewskr.rentcarapp.controllers;

import gulewskr.rentcarapp.data.control.ResponseHandler;
import gulewskr.rentcarapp.data.domain.mark.CreateMark;
import gulewskr.rentcarapp.entities.Mark;
import gulewskr.rentcarapp.services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("mark")
public class MarksController {

    @Autowired
    MarksService service;

    @GetMapping
    public ResponseEntity<Object> GetAll()
    {
        List<Mark> marks = service.getAll();
        return ResponseHandler.generateResponse("", HttpStatus.OK, marks);
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> GetById(@PathVariable long id)
    {
        Mark mark = service.getById(id);
        return ResponseHandler.generateResponse("", HttpStatus.OK, mark);
    }

    @PostMapping()
    public ResponseEntity<Object> Create(@RequestBody CreateMark _mark)
    {
        Mark mark = new Mark();

        mark.setName(_mark.getName());
        mark.setLogoSrc(_mark.getLogoSrc());

        mark = service.add(mark);
        return ResponseHandler.generateResponse("", HttpStatus.OK, mark);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> Edit(@PathVariable long id, @RequestBody CreateMark _mark)
    {
        Mark mark = service.getById(id);
        if(mark != null )
        {
            mark.setName(_mark.getName());
            mark.setLogoSrc(_mark.getLogoSrc());
            mark = service.Edit(mark);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, mark);
        }else{
            return ResponseHandler.generateResponse("Error", HttpStatus.BAD_REQUEST, null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> Delete(@PathVariable long id)
    {
        service.deleteById(id);
        return ResponseHandler.generateResponse("Deleted", HttpStatus.OK, null);
    }
}
