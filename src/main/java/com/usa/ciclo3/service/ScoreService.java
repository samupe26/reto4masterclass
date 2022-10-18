
package com.usa.ciclo3.service;

import com.usa.ciclo3.entities.Score;
import com.usa.ciclo3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service

public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getAll() {
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score score) {
        if(score.getId() == null) {
            return scoreRepository.save(score);
        }
        else {
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if(e.isEmpty()) {
                return scoreRepository.save(score);
            }
            else {
                return score;
            }
        }
    }
            
    public Score update(Score score) {
        if(score.getId() != null) {
            Optional<Score> e = scoreRepository.getScore(score.getId());
            if(!e.isEmpty()) {
                if(score.getMessageText() != null) {
                    e.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!= null) {
                    e.get().setStars(score.getStars());
                }
                             
                scoreRepository.save(e.get());
                return e.get();       
            }
            else {
                return score;
            }
        }
        else{
            return score;
        }
    }
    
    public boolean deleteScore(int id) {
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.delete(score);
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

        
        
            
  
    

