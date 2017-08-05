/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sony
 */
public class Usuario {
    
    public String id;
   public String login;
   public String password;
   public String nombre;
   public String paterno;
   public String edad;
   public Date fechaIngerso;
   ArrayList<Usuario> usuarios;

    public Usuario(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    Usuario(String id, String login, String password, String nombre, String paterno, String edad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Date getFechaIngerso() {
        return fechaIngerso;
    }

    public void setFechaIngerso(Date fechaIngerso) {
        this.fechaIngerso = fechaIngerso;
    }

    public Usuario(String id) {
        this.id = id;
    }

    public Usuario(String login, String password, String nombre, String paterno, String edad, Date fechaIngerso) {
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.paterno = paterno;
        this.edad = edad;
        this.fechaIngerso = fechaIngerso;
    }

    public Usuario() {
    }

    public Usuario(String id, String login, String password, String nombre, String paterno, String edad, Date fechaIngerso) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.paterno = paterno;
        this.edad = edad;
        this.fechaIngerso = fechaIngerso;
    }
   public enum Rol{
       MEDICORESPONSABLE,
       MEDICOINTERNO,
       ENFERMERA,
       PERSONALADMINISTRATIVO
   }
 public Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol() {
        
    }
    
}
