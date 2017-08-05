/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Sony
 */
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
    public List<Usuario> findByNombre(String nombre);
    public List<Usuario> findByPassword (String password);
}
