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
public class GeneracionEspecialidad {

    public GeneracionEspecialidad() {
    }
    
    public static List<Especialidad> generaEspecialidades(){

    Especialidad e1=new Especialidad("Ginecologia");
    Especialidad e2=new Especialidad("Traumatologia");
    Especialidad e3=new Especialidad("Pediatria");
    
    List <Especialidad> especialidad=new ArrayList();

    especialidad.add(e1);
    especialidad.add(e2);
    especialidad.add(e3);
    
    return especialidad;
        
}
    
}
