/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Machine;
import com.Ciclo3Backend.Ciclo3Backend.Repository.MachineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class MachineServices {
    @Autowired
    private MachineRepository machineRepository;
    
    public List<Machine> getMachineAll(){
        return machineRepository.getMachineAll();
    }
    
    public Optional<Machine> getOneMachine(int id){
        return machineRepository.getOneMachine(id);
    }
    
    public Machine saveMachine(Machine m){
        if(m.getId() == null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return machineRepository.saveMachine(m);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Machine> machineEvento = machineRepository.getOneMachine(m.getId());
            if(machineEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return machineRepository.saveMachine(m);
            }else{  // SI NO LO MANDA A RETORNAR
                return m;
            }
        }
    }
    public Machine updateMachine(Machine m){
        if(m.getId() != null){
            Optional<Machine> machineEvento = machineRepository.getOneMachine(m.getId());
            if(!machineEvento.isEmpty()){
                if(m.getBrand() != null){
                    machineEvento.get().setBrand(m.getBrand());
                }
                if(m.getName() != null){
                    machineEvento.get().setName(m.getName());
                }
                if(m.getYear() != null){
                    machineEvento.get().setYear(m.getYear());
                }
                if(m.getDescription() != null){
                    machineEvento.get().setDescription(m.getDescription());
                }
                return machineRepository.saveMachine(machineEvento.get());
            }
        }
        return m;
        
    }
    public boolean deleteMachine(int id){
        boolean deleteM = getOneMachine(id).map(m -> {
            machineRepository.deleteMachine(m);
            return true;
        }).orElse(false);
        return deleteM;
    }
    
    
}
