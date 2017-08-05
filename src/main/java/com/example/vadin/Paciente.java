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
public class Paciente {
    String nombre;
    String paterno;
    String materno;
    String estado;

    public Paciente() {
    }

    public Paciente(String nombre, String paterno, String materno, String estado) {
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
