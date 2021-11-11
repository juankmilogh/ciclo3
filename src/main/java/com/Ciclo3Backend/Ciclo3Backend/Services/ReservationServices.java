/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Reservation;
import com.Ciclo3Backend.Ciclo3Backend.Repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class ReservationServices {
   @Autowired 
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getReservationAll(){
        return reservationRepository.getReservationAll();
    }
    
    public Optional<Reservation> getOneReservation(int id){
        return reservationRepository.getOneReservation(id);
    }
    
    public Reservation saveReservation(Reservation r){
        if(r.getIdReservation() == null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return reservationRepository.saveReservation(r);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Reservation> reservationEvento = reservationRepository.getOneReservation(r.getIdReservation());
            if(reservationEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return reservationRepository.saveReservation(r);
            }else{  // SI NO LO MANDA A RETORNAR
                return r;
            }
        }
    }
     public Reservation updateReservation(Reservation r){
        if(r.getIdReservation() != null){
            Optional<Reservation> reservationEvento = reservationRepository.getOneReservation(r.getIdReservation());
            if(!reservationEvento.isEmpty()){
                if(r.getStartDate() != null){
                    reservationEvento.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate() != null){
                    reservationEvento.get().setDevolutionDate(r.getDevolutionDate());
                }
                return reservationRepository.saveReservation(reservationEvento.get());

            }
        }
        return r;   
    }
    public boolean deleteReservation(int id){
        boolean deleteR = getOneReservation(id).map(r -> {
            reservationRepository.deleteReservation(r);
            return true;
        }).orElse(false);
        return deleteR;
    }
}
