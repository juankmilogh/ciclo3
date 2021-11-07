/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;

import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.ScoreCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class ScoreRepository {
     @Autowired
   private ScoreCrudRepository scoreCrudRepository;
   
   public List<Score> getScoreAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Score>)scoreCrudRepository.findAll();
    }
      public Optional<Score> getOneScore(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return scoreCrudRepository.findById(id);
    }
    
    public Score saveScore(Score sc){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return scoreCrudRepository.save(sc);
        
    }
}
