/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;

import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.MachineCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class MachineRepository {
    @Autowired
    private MachineCrudRepository machineCrudRepository;    // LLAMAMOS A NUESTRA INTERFAZ QUE GUARDA TODOS LOS METODOS DEL CRUD
   
    
    public List<Machine> getMachineAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Machine>) machineCrudRepository.findAll();
    }
    
    public Optional<Machine> getOneMachine(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return machineCrudRepository.findById(id);
    }
    
    public Machine saveMachine(Machine m){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return machineCrudRepository.save(m);
        
    }
    public void deleteMachine(Machine m){
       machineCrudRepository.delete(m);
    }
}
