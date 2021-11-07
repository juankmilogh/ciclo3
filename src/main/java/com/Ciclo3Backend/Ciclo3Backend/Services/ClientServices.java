/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Client;
import com.Ciclo3Backend.Ciclo3Backend.Repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getClientAll(){
        return clientRepository.getClientAll();
    }
    
    public Optional<Client> getOneClient(int id){
        return clientRepository.getOneClient(id);
    }
    
    public Client saveClient(Client cl){
        if(cl.getIdClient() == null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return clientRepository.saveClient(cl);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Client> clientEvento = clientRepository.getOneClient(cl.getIdClient());
            if(clientEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return clientRepository.saveClient(cl);
            }else{  // SI NO LO MANDA A RETORNAR
                return cl;
            }
        }
    } 
}
