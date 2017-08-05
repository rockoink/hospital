/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sony
 */
public class Autenticacion {
    
     List<Usuario> usuarios;
    public Autenticacion(){
        usuarios=new ArrayList<>();
        MedicoResponsable medicoResponsable=new MedicoResponsable();
        Usuario u=new Usuario();
       medicoResponsable.setRol();
        
       MedicoInterno medicoInterno=new MedicoInterno();
        medicoInterno.setRol();
       
        Enfermera enfermera=new Enfermera();
        enfermera.setRol();
        
        PersonalAdministrativo personalAdmin=new PersonalAdministrativo();
        personalAdmin.setRol();
        
    usuarios.add(medicoResponsable);
       usuarios.add(medicoInterno);
      usuarios.add(enfermera);
    usuarios.add(personalAdmin);
    }
    
    public void autenticar(){
        
        for(Usuario u:usuarios){
        if(u.getRol().equals(Usuario.Rol.MEDICORESPONSABLE)){
            System.out.println("Autenticado como medico responsable. Si eres "+u.getRol());
        }else{
             System.out.println("NO autenticado eres "+u.getRol());
        }
       
        }
    }
    
    
}
