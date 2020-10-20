/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.personaDAO;
import domain.Persona;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class TestManejoPersonas {
    /*
    CREATE SCHEMA `test` ;
CREATE TABLE `test`.`persona` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `edad` INT NULL,
  PRIMARY KEY (`id`));
    
    
    
    
    */
      public static void main(String[] args) {
          personaDAO dao = new personaDAO();          
          
          //dao.insert(new Persona("Axel","Perez",32));
          ArrayList<Persona> personas = dao.selectAll();
          //dao.insert(new Persona("Carlos","Perez",54));
          
          //personas.get(3).setNombre("Feder");
          //System.out.println(dao.update(personas.get(3)));
          
          //dao.delete(personas.get(3));
          //personas = dao.selectAll();
          personas.forEach(p -> System.out.println(p));
          
      }
}
