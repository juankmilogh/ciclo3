/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;

import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.ClientCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class ClientRepository {
   @Autowired
   private ClientCrudRepository clientCrudRepository;
   
   public List<Client> getClientAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Client>)clientCrudRepository.findAll();
    }
      public Optional<Client> getOneClient(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return clientCrudRepository.findById(id);
    }
    
    public Client saveClient(Client cl){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return clientCrudRepository.save(cl);
        
    }
    
}
