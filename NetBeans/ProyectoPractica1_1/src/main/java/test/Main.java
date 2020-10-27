/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.ArrayList;

/**
 *
 * @author axegas
 */
public class Main {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario u = new Usuario(8, "888", "888");
        u.setPassword("999");
        //dao.delete(u);
        ArrayList<Usuario> usuarios = dao.selectAll();
        usuarios.forEach(us -> System.out.println(us));

        /*
        Script SQL para hacer pruebas.
        
       
        CREATE TABLE `test`.`usuario` (
        `id_usuario` INT NOT NULL,
        `usuario` VARCHAR(45) NULL,
        `password` VARCHAR(45) NULL,
        PRIMARY KEY (`id_usuario`));
        
        insert into usuario (id_usuario,usuario,password) values (1,"111","111");
        insert into usuario (id_usuario,usuario,password) values (2,"222","222");
        insert into usuario (id_usuario,usuario,password) values (3,"333","333");
        insert into usuario (id_usuario,usuario,password) values (4,"444","444");
        insert into usuario (id_usuario,usuario,password) values (5,"555","555");
        insert into usuario (id_usuario,usuario,password) values (6,"666","666");
        insert into usuario (id_usuario,usuario,password) values (7,"777","777");
         */
    }
}
