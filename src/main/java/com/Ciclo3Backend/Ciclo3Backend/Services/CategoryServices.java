/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Services;

import com.Ciclo3Backend.Ciclo3Backend.Models.Category;
import com.Ciclo3Backend.Ciclo3Backend.Repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manager
 */
@Service
public class CategoryServices {
     @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getCategoryAll(){
        return categoryRepository.getCategoryAll();
    }
    
    public Optional<Category> getOneCategory(int id){
        return categoryRepository.getOneCategory(id);
    }
    
    public Category saveCategory(Category c){
        if(c.getId()== null){      // SI EL ID ES NULO, LO VA AA GUARDAR
            return categoryRepository.saveCategory(c);
        }else{      // EN EL CASO CONTRARIO DE QUE EL ID NO ES NULO. LLAMARA AL METODO QUE TRAE UN DATO EN ESPECIFICO
            Optional<Category> categoryEvento = categoryRepository.getOneCategory(c.getId());
            if(categoryEvento.isEmpty()){            // SI EL DATO EN ESPECIFICO TRAIDO ESTA VACIO, ENTONCES LO GUARDARA
                return categoryRepository.saveCategory(c);
            }else{  // SI NO LO MANDA A RETORNAR
                return c;
            }
        }
    } 
    public Category updateCategory(Category c){
        if(c.getId() != null){
            Optional<Category> categoryEvento = categoryRepository.getOneCategory(c.getId());
            if(!categoryEvento.isEmpty()){
                if(c.getName() != null){
                    categoryEvento.get().setName(c.getName());
                }
                if(c.getDescription() != null){
                    categoryEvento.get().setDescription(c.getDescription());
                }
                return categoryRepository.saveCategory(categoryEvento.get());
            }
        }
        return c;
        
    }
    public boolean deleteCategory(int id){
        boolean deleteC = getOneCategory(id).map(c -> {
            categoryRepository.deleteCategory(c);
            return true;
        }).orElse(false);
        return deleteC;
    }
}
