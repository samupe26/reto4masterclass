
package com.usa.ciclo3.service;

import com.usa.ciclo3.entities.Client;
import com.usa.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service

public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll() {
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }
    
    public Client save(Client client) {
        if(client.getIdClient() == null) {
            return clientRepository.save(client);
        }
        else {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(e.isEmpty()) {
                return clientRepository.save(client);
            }
            else {
                return client;
            }
        }
    }
            
    public Client update(Client client) {
        if(client.getIdClient() != null) {
            Optional<Client> e = clientRepository.getClient(client.getIdClient());
            if(!e.isEmpty()) {
                if(client.getName() != null) {
                    e.get().setName(client.getName());
                }
                if(client.getEmail() != null) {
                    e.get().setEmail(client.getEmail());
                }
                if(client.getAge() != null) {
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword() != null) {
                    e.get().setPassword(client.getPassword());
                }  
                                
                clientRepository.save(e.get());
                return e.get();       
            }
            else {
                return client;
            }
        }
        else{
            return client;
        }
    }
    
    public boolean deleteClient(int id) {
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false); //   (false);
        return aBoolean;
    }
    
    /*
    public boolean delete(int id){
        boolean flag=false;
        Optional<Costume>p= clientRepository.getCostume(id);
        if(p.isPresent()){
            clientRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }*/
        
}

        
        
            
  
    

