/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.CrudRepository;


import com.Ciclo3Backend.Ciclo3Backend.Models.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Manager
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
