
package com.usa.ciclo3.service;

import com.usa.ciclo3.entities.Admin;
import com.usa.ciclo3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service

public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll() {
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin) {
        if(admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        }
        else {
            Optional<Admin> e = adminRepository.getAdmin(admin.getIdAdmin());
            if(e.isEmpty()) {
                return adminRepository.save(admin);
            }
            else {
                return admin;
            }
        }
    }
            
    public Admin update(Admin admin) {
        if(admin.getIdAdmin() != null) {
            Optional<Admin> e = adminRepository.getAdmin(admin.getIdAdmin());
            if(!e.isEmpty()) {
                if(admin.getName() != null) {
                    e.get().setName(admin.getName());
                }
                if(admin.getEmail()!= null) {
                    e.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword() != null) {
                    e.get().setPassword(admin.getPassword());
                }
                             
                adminRepository.save(e.get());
                return e.get();       
            }
            else {
                return admin;
            }
        }
        else{
            return admin;
        }
    }
    
   public boolean deleteAdmin(int id) {
        Boolean aBoolean = getAdmin(id).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false); //   (false);
        return aBoolean;
    }
    
    /*
    public boolean delete(int id){
        boolean flag=false;
        Optional<Costume>p= costumeRepository.getCostume(id);
        if(p.isPresent()){
            costumeRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }*/
        
}

        
        
            
  
    

