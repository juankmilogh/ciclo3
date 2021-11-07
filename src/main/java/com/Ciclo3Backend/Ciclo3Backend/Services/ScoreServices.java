/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Score;
import com.Ciclo3Backend.Ciclo3Backend.Repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class ScoreServices {
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List<Score> getScoreAll(){
        return scoreRepository.getScoreAll();
    }
    
    public Optional<Score> getOneScore(int id){
        return scoreRepository.getOneScore(id);
    }
    
    public Score saveScore(Score sc){
        if(sc.getIdScore()== null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return scoreRepository.saveScore(sc);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Score> scoreEvento = scoreRepository.getOneScore(sc.getIdScore());
            if(scoreEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return scoreRepository.saveScore(sc);
            }else{  // SI NO LO MANDA A RETORNAR
                return sc;
            }
        }
    } 
    
}
