/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Message;
import com.Ciclo3Backend.Ciclo3Backend.Repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class MessageServices {
      @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getMessageAll(){
        return messageRepository.getMessageAll();
    }
    
    public Optional<Message> getOneMessage(int id){
        return messageRepository.getOneMessage(id);
    }
    
    public Message saveMessage(Message ms){
        if(ms.getIdMessage() == null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return messageRepository.saveMessage(ms);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Message> messageEvento = messageRepository.getOneMessage(ms.getIdMessage());
            if(messageEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return messageRepository.saveMessage(ms);
            }else{  // SI NO LO MANDA A RETORNAR
                return ms;
            }
        }
    }
    public Message updateMessage(Message ms){
        if(ms.getIdMessage() != null){
            Optional<Message> messageEvento = messageRepository.getOneMessage(ms.getIdMessage());
            if(!messageEvento.isEmpty()){
                if(ms.getMessageText() != null){
                    messageEvento.get().setMessageText(ms.getMessageText());
                }
                return messageRepository.saveMessage(messageEvento.get());

            }
        }
        return ms;   
    }
    public boolean deleteMessage(int id){
        boolean deleteMs = getOneMessage(id).map(ms -> {
            messageRepository.deleteMessage(ms);
            return true;
        }).orElse(false);
        return deleteMs;
    }
    
}
