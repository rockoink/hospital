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
public class GeneracionPuesto {

    public GeneracionPuesto() {
    }
    
     public static List<Puesto> generaPuestos(){

    Puesto p1=new Puesto("medico responsable");
    Puesto p2=new Puesto("medico interno");
    Puesto p3=new Puesto("enfermera");
    
    List <Puesto> puestos=new ArrayList();

    puestos.add(p1);
    puestos.add(p2);
    puestos.add(p3);
    
    return puestos;
        
}
    
}
