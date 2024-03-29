/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Ciclo3Backend.Ciclo3Backend.Repository;
import com.Ciclo3Backend.Ciclo3Backend.CrudRepository.CategoryCrudRepository;
import com.Ciclo3Backend.Ciclo3Backend.Models.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Manager
 */
@Repository
public class CategoryRepository {
   @Autowired
   private CategoryCrudRepository categoryCrudRepository;
   
   public List<Category> getCategoryAll(){               // METODO CREADO PARA OBTENER TODOS LOS DATOS DE LA RESPECTIVA TABLA
        return (List<Category>)categoryCrudRepository.findAll();
    }
      public Optional<Category> getOneCategory(int id){     //METODO CREADO PARA OBTENER UN SOLO DATO DE LA RESPECTIVA TABLA, EL OPTIONAL SIRVE PARA TRAER LOS DATOS QUE NO SON NULOS, LO HACEMOS POR EL ID
        return categoryCrudRepository.findById(id);
    }
    
    public Category saveCategory(Category c){      // METODO CREADO PARA GUARDAR UN NUEVO DATO PARA LA RESPECTIVA TABLA
        return categoryCrudRepository.save(c);
        
    }
     public void deleteCategory(Category c){
       categoryCrudRepository.delete(c);
    }
      
}
