
package com.usa.ciclo3.repository;



import com.usa.ciclo3.entities.Admin;
import com.usa.ciclo3.repository.crudrepository.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;






@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin save(Admin c){
        return adminCrudRepository.save(c);
    }
    public void delete(Admin c){
        adminCrudRepository.delete(c);
    }

}
