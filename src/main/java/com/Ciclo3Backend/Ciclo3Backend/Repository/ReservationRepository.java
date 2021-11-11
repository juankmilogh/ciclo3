/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;

import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.ReservationCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
   
    public List<Reservation> getReservationAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
      public Optional<Reservation> getOneReservation(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation saveReservation(Reservation r){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return reservationCrudRepository.save(r);
        
    }
    public void deleteReservation(Reservation r){
      reservationCrudRepository.delete(r);
    }
    
}
