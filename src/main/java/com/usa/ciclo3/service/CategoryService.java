
package com.usa.ciclo3.service;

import com.usa.ciclo3.entities.Category;
import com.usa.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service

public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category category) {
        if(category.getId() == null) {
            return categoryRepository.save(category);
        }
        else {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(e.isEmpty()) {
                return categoryRepository.save(category);
            }
            else {
                return category;
            }
        }
    }
            
    public Category update(Category category) {
        if(category.getId() != null) {
            Optional<Category> e = categoryRepository.getCategory(category.getId());
            if(!e.isEmpty()) {
                if(category.getName() != null) {
                    e.get().setName(category.getName());
                }
                if(category.getDescription()!= null) {
                    e.get().setDescription(category.getDescription());
                }
                             
                categoryRepository.save(e.get());
                return e.get();       
            }
            else {
                return category;
            }
        }
        else{
            return category;
        }
    }
    
    public boolean deleteCategory(int id) {
        Boolean aBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
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

        
        
            
  
    

