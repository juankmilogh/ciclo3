/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;

import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.MessageCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
   
    public List<Message> getMessageAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Message>)messageCrudRepository.findAll();
    }
      public Optional<Message> getOneMessage(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return messageCrudRepository.findById(id);
    }
    
    public Message saveMessage(Message ms){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return messageCrudRepository.save(ms);
        
    }
     public void deleteMessage(Message ms){
       messageCrudRepository.delete(ms);
    }
    
}
