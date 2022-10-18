
package com.usa.ciclo3.controller;

import com.usa.ciclo3.entities.Admin;
import com.usa.ciclo3.service.AdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping("/api/Admin")

public class AdminController {
    
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    public List<Admin> getAdmin() {
        return adminService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }
    
    @PutMapping("/update")
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
    
    @DeleteMapping("/delete")
    public Admin delete(@RequestBody Admin admin) {
        return adminService.update(admin);
    }
    
}
