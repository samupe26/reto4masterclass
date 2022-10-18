
package com.usa.ciclo3.repository;

import com.usa.ciclo3.entities.Client;
import com.usa.ciclo3.repository.crudrepository.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client save(Client category){
        return clientCrudRepository.save(category);
    }
    
    public void delete(Client category){
        clientCrudRepository.delete(category);
    }

}
