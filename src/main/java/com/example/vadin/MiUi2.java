/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author campitos
 */
@SpringUI
@Theme("valo")
public class MiUi2 extends UI{
Button botonAutenticar;
Button botonAdministrar;

@Autowired
    RepositorioUsuario repositorioUsuario;
    public static ArrayList<Usuario> usuarios;

    @Override
    protected void init(VaadinRequest request) {
     
        Window autenticar=new Window();
             autenticar.setClosable(false);
         VerticalLayout vl=new VerticalLayout();
        botonAutenticar=new Button("autenticar",FontAwesome.LOCK);
        botonAdministrar = new Button("administrar",FontAwesome.WRENCH);
        
        usuarios = (ArrayList)this.repositorioUsuario.findAll();
        ComboBox<Usuario> select = new ComboBox();
            select.setPlaceholder("Escribe tu nombre aquí");
         select.setItems(usuarios);
         select.setItemCaptionGenerator(Usuario::getNombre);
            select.setWidth("100%");
            
            
        PasswordField textoPassword = new PasswordField();
             textoPassword.setPlaceholder("Introduce tu contraseña");
             vl.addComponent(select);
             vl.addComponent(textoPassword);
            vl.addComponent(botonAutenticar);
            vl.addComponent(botonAdministrar);

            
         autenticar.setContent(vl);
         autenticar.setWidth(400,Unit.PIXELS);
           autenticar.setHeight(300,Unit.PIXELS);
         autenticar.center();
        addWindow(autenticar);
        
        VerticalLayout layoutPrincipal=new VerticalLayout();
        Label labelBienvenido=new Label("Bienvenidos al proyecto final de Ingenieria de software, rodrigo Vilches");
        labelBienvenido.setStyleName(ValoTheme.LABEL_H1);
        labelBienvenido.setWidth("100%");
        layoutPrincipal.addComponent(labelBienvenido);
        
         setContent(layoutPrincipal);
         
        
    }
    
}
