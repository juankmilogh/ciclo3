/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Controller;

import com.Ciclo3Backend.Ciclo3Backend.Models.Machine;
import com.Ciclo3Backend.Ciclo3Backend.Services.MachineServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manager
 */
@RestController
@RequestMapping("api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MachineController {
    @Autowired
    private MachineServices machineServices;
    
    @GetMapping("/all")
    public List <Machine> getMachineAll(){
        return machineServices.getMachineAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Machine> getOneMachine(@PathVariable("id") int id){
        return machineServices.getOneMachine(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine saveMachine(@RequestBody Machine m){
        return machineServices.saveMachine(m);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine updateMachine(@RequestBody Machine m){
        return machineServices.updateMachine(m);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteMachine(@PathVariable("id") int id){
        return machineServices.deleteMachine(id);
    }
    
}
