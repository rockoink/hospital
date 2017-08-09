/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sony
 */
@RestController
@RequestMapping({"/"})
@CrossOrigin
public class ControladorUsuario {
    @Autowired RepositorioUsuario repositorioUsuario;
    
    public ControladorUsuario(){
        
    }
    
    @RequestMapping(
        value = {"/usuario/{id}/{login}/{nombre}/{password}/{paterno}/{edad}"},
        method = {RequestMethod.POST},
        headers = {"Accept=text/html"}
    )
    public String guardar(@PathVariable String id,@PathVariable String nombre,
            @PathVariable String password, @PathVariable String paterno) {
        this.repositorioUsuario.save(new Usuario(id,nombre,password, paterno));
        return "Usuario guardado con exito";
    }
    

//buscar todos
      @RequestMapping(value="/usuario", method = RequestMethod.GET, headers = {"Accept=Application/json"})
    public ArrayList<Usuario> getTodos(){
         
        return (ArrayList<Usuario>) repositorioUsuario.findAll();
    }
    
/*
    //gUARDAR POST usuarios
   @RequestMapping(value="/usuario", method=RequestMethod.POST,
            headers={"Accept=Application/json"})
   
   public Usuario guardarUsuario(@RequestBody String json) throws Exception {
   ObjectMapper maper=new ObjectMapper();
        
        Usuario u=maper.readValue(json, Usuario.class);
        repositorioUsuario.save(u);
         System.out.println("el id es"+u.getId()+"El nombre es: "+u.getNombre()+"password"+u.getPassword()+ " el paterno es: "+
                 u.getPaterno());
        return u;
   }
   
  */  
    
    
}
