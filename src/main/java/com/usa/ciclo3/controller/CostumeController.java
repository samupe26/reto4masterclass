
package com.usa.ciclo3.controller;

import com.usa.ciclo3.entities.Costume;
import com.usa.ciclo3.service.CostumeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/api/Costume")

public class CostumeController {
    
    @Autowired
    private CostumeService costumeService;
    
    @GetMapping("/all")
    public List<Costume> getCostume() {
        return costumeService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Costume> getCostume(@PathVariable("id") int Id) {
        return costumeService.getCostume(Id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume save(@RequestBody Costume costume) {
        return costumeService.save(costume);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Costume update(@RequestBody Costume costume) {
        return costumeService.update(costume);
    }
    
    /*
    @DeleteMapping("/delete")
    public Costume delete(@RequestBody Costume costume) {
        return costumeService.update(costume);
    }*/
    
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return costumeService.deleteCostume(id);
    }
    
       
}
