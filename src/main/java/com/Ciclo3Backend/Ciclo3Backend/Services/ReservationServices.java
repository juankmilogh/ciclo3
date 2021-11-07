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
}
