/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Sony
 */
@SpringBootApplication

public class ProbarAutenticacion implements CommandLineRunner {

    @Autowired RepositorioUsuario repositorioUsuario;
    
    public static void main(String[] args) {
        
    }
        
        @Override
    public void run(String... strings) throws Exception {
 
      //  Autenticacion a = new Autenticacion();
        //a.autenticar();
        //id,nombre,password,paterno
        Usuario usu=new Usuario ("10","rodrigo nombre","rodrigo","vilches");
        Usuario guardado=repositorioUsuario.save(usu);
        System.out.println("vcbgbt "+usu);
    }
    
}
