/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

/**
 *
 * @author Sony
 */
public class MedicoResponsable extends Usuario {
    
     @Override
    public void setRol() {
       rol=Usuario.Rol.MEDICORESPONSABLE;
    }
    
}
