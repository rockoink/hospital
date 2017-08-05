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
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.FooterCell;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rocko
 *         /*
            //rocko
        Label label=new Label("SISTEMA PARA UNIDADES MEDICAS");
       tabInicio.addComponent(label);
       
       Button boton=new Button("Ingresar",FontAwesome.KEY);
       tabInicio.addComponent(boton);
        setContent(tabInicio);
    */

 
@SpringUI
@Theme("valo")
public class MiUI {
/*
     VerticalLayout tabInicio;
    HorizontalLayout pantallaSuperior;
    VerticalLayout pantallaInferior;
    Button botonLogin;
    Button botonAdministracion;
    Button botonInicio;
    
    
    @Autowired
    RepositorioUsuario repositorioUsuario;
    public static ArrayList<Usuario> usuarios;

    public MiUI() {
    }
    
    
    
    
    protected void init(VaadinRequest request){this.prueba();}
      
        public void prueba() {
      
 TabSheet tabito = new TabSheet();
        this.tabInicio = new VerticalLayout();
        this.pantallaSuperior = new HorizontalLayout();
        this.pantallaInferior = new VerticalLayout();   
 Label labelPrincipal = new Label("Bienvenidos al proyecto final de Ingenieria de software, presiona el boton para cntinuar");
        labelPrincipal.setStyleName("h1");
        labelPrincipal.setWidth("100%");
        this.pantallaInferior.addComponent(labelPrincipal);           
    this.botonInicio=new Button("Inicio",FontAwesome.AMBULANCE);
    this.pantallaSuperior.addComponent(this.botonInicio);
        this.tabInicio.addComponent(this.pantallaSuperior);
        this.tabInicio.addComponent(this.pantallaInferior);
        
        this.botonInicio.addStyleName("friendly");

        //abrir una ventana despues de hacer lick en el boton de inicio
        Window subWindowLogin = new Window("Login");
        subWindowLogin.setClosable(false);
        VerticalLayout subContentLogin = new VerticalLayout();
        subWindowLogin.setContent(subContentLogin);
        this.botonInicio.addClickListener((xxx) -> {
        subWindowLogin.center();
            subWindowLogin.setWidth("350px");
            //this.addWindow(subWindowLogin);
        
            usuarios = (ArrayList)this.repositorioUsuario.findAll();
            tabito.removeComponent(this.tabInicio);
            ComboBox<Usuario> select = new ComboBox();
            select.setPlaceholder("Escribe tu nombre aquí");
            select.setItems(usuarios);
            select.setWidth("100%");
            //select.setItemCaptionGenerator(Usuario::getMiUsuario);
            
            Label labelExamen = new Label("Bienvenido!!");
            subContentLogin.addComponent(labelExamen);
            PasswordField textoPassword = new PasswordField();
             textoPassword.setPlaceholder("Introduce tu contraseña");
             subContentLogin.addComponent(select);
             subContentLogin.addComponent(textoPassword);
             
             //boton login
             Button botonLogin = new Button("Ingresar", FontAwesome.LOCK);
            botonLogin.addStyleName("primary");
            subContentLogin.addComponent(botonLogin);
            
            Button botonAdministracion=new Button("Ingresar",FontAwesome.WRENCH);
            this.botonAdministracion.addStyleName("primary");
            subContentLogin.addComponent(this.botonAdministracion);
            
            botonLogin.addClickListener((ingresar) -> {
                //autenticar usuarios
               /*
                ALUMNO_INGRESADO = new Alumno();
                ALUMNO_INGRESADO = (Alumno)select.getValue();
                System.out.println(ALUMNO_INGRESADO);
                if(this.repositorioAlumno.findByNombre(ALUMNO_INGRESADO.getNombre()).getCuenta().equals(textoPasswordExamen.getValue().toLowerCase()) && selectTema.getSelectedItem().isPresent()) {
                    String sesionId = VaadinSession.getCurrent().getSession().getId();
                    VaadinSession.getCurrent().setAttribute("nombre", ALUMNO_INGRESADO.getNombre());
                    VaadinSession.getCurrent().setAttribute("paterno", ALUMNO_INGRESADO.getPaterno());
                    VaadinSession.getCurrent().setAttribute("cuenta", ALUMNO_INGRESADO.getCuenta());
                    VaadinSession.getCurrent().setAttribute("tema", ((Tema)selectTema.getValue()).getNombre());
                    VaadinSession.getCurrent().setAttribute("preguntas", this.repositorioPregunta.findByTema(((Tema)selectTema.getValue()).getNombre()));
                    subWindowExamen.close();
                    tabito.addTab(tabExamen, "EXAMEN", FontAwesome.BOOK);
                } else {
                    labelExamen.addStyleName("failure");
                    labelExamen.setValue("DATOS INCORRECTOS");
                }

            });
        });
            
                Window subWindowAdministracion = new Window("Administración");
        VerticalLayout subContentAdministracion = new VerticalLayout();
        subWindowAdministracion.setContent(subContentAdministracion);
       this.botonAdministracion.addClickListener((ingresar) -> {
            subWindowAdministracion.center();
            this.addWindow(subWindowAdministracion);
            tabito.removeComponent(this.tabInicio);
        });
         Label labelAdmin = new Label("Bienvenido. Introduce tus datos");
        subContentAdministracion.addComponent(labelAdmin);
        TextField textoLoginAdministracion = new TextField();
        textoLoginAdministracion.setPlaceholder("Login");
        PasswordField textoPasswordAdministracion = new PasswordField();
        textoPasswordAdministracion.setPlaceholder("password");
        Button botonAutenticarAdministracion = new Button("Ingresar", FontAwesome.LOCK);
        botonAutenticarAdministracion.addStyleName("primary");
        botonAutenticarAdministracion.addClickListener((algo) -> {
                if(textoLoginAdministracion.getValue().equals("rocko") && textoPasswordAdministracion.getValue().equals("rocko1")) {
                subWindowAdministracion.close();
                 } else {
                labelAdmin.setValue("DATOS INCORRECTOS");
            }
                });
        subContentAdministracion.addComponent(textoLoginAdministracion);
        subContentAdministracion.addComponent(textoPasswordAdministracion);
        subContentAdministracion.addComponent(botonAutenticarAdministracion);
        tabito.addTab(this.tabInicio, "Inicio", FontAwesome.HOME);
        this.setContent(tabito);
            }
        */
        }
