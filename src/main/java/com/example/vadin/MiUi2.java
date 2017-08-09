/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.vadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author 
 */
@SpringUI
@Theme("valo")
public class MiUi2 extends UI{
Button botonAutenticar;
Button botonAdministrar;

@Autowired
    RepositorioUsuario repositorioUsuario;
RepositorioPaciente repositorioPaciente;
    public static ArrayList<Usuario> usuarios;

    @Override
    protected void init(VaadinRequest request) {
     //intento de tab fallido
        //TabSheet tabs = new TabSheet();
        //TabGeneral tabGeneral = new TabGeneral(this.repositorioUsuario,this.repositorioPaciente);
        
        Window autenticar=new Window();
             autenticar.setClosable(false);
         VerticalLayout vl=new VerticalLayout();
         Label labelHola=new Label("Bienvenido, Ingrese sus datos");
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
             vl.addComponent(labelHola);
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
        Label labelBienvenido=new Label("Proyecto final de Ingenieria de software");
        labelBienvenido.setStyleName(ValoTheme.LABEL_H1);
        labelBienvenido.setWidth("100%");
        layoutPrincipal.addComponent(labelBienvenido);
        
        Label labelError=new Label();
        
        botonAutenticar.addClickListener((ingresar) -> {
            //autenticar usuarios
            Usuario USUARIO_INGRESADO = new Usuario();
                USUARIO_INGRESADO = (Usuario)select.getValue();
                System.out.println(USUARIO_INGRESADO);
                //con el toString
                if(this.repositorioUsuario.findByNombre(USUARIO_INGRESADO.getNombre()).getPassword().equals(textoPassword.getValue().toLowerCase())) {
                    String sesionId = VaadinSession.getCurrent().getSession().getId();
                    VaadinSession.getCurrent().setAttribute("nombre", USUARIO_INGRESADO.getNombre());
                    VaadinSession.getCurrent().setAttribute("paterno", USUARIO_INGRESADO.getPaterno());
                    VaadinSession.getCurrent().setAttribute("password", USUARIO_INGRESADO.getPassword());
                    autenticar.close();
                    //tabs.addTab(tabGeneral, "Empleados", FontAwesome.KEY);
                    
                } else {
                    labelError.addStyleName("failure");
                    labelError.setValue("DATOS INCORRECTOS");
                }

            });
        
  ///ventana despues de ingresar con datos correctos      
        
        
        
////ventana administracion        
  Window subWindowAdministracion = new Window("Administración");
        VerticalLayout subContentAdministracion = new VerticalLayout();
        subWindowAdministracion.setContent(subContentAdministracion);
        this.botonAdministrar.addClickListener((ingresar) -> {
            subWindowAdministracion.center();
            this.addWindow(subWindowAdministracion);
            autenticar.close();
        });       
        Label labelAdmin = new Label("Bienvenido Administrador. Introduce tus datos");
        subContentAdministracion.addComponent(labelAdmin);
        TextField textoLoginAdministracion = new TextField();
        textoLoginAdministracion.setPlaceholder("Login");
        PasswordField textoPasswordAdministracion = new PasswordField();
        textoPasswordAdministracion.setPlaceholder("password");
        Button botonAutenticarAdministracion = new Button("Ingresar", FontAwesome.LOCK);
        botonAutenticarAdministracion.addStyleName("primary");
        botonAutenticarAdministracion.addClickListener((ingresar) -> {
            if(textoLoginAdministracion.getValue().equals("rocko") && textoPasswordAdministracion.getValue().equals("rocko")) {
                subWindowAdministracion.close();
               
            } else {
                labelAdmin.setValue("DATOS INCORRECTOS");
            }

        });

        
        //ya quedo solo falta ahora la vista de pacientes
        //ventaana despues de hacer click en administracion
       
        Window empleados= new Window("Empleados");
        empleados.setClosable(false);
        VerticalLayout vlEmpleados= new VerticalLayout();
        empleados.setContent(vlEmpleados);
        botonAutenticarAdministracion.addClickListener((entrar) -> {
            empleados.center();
            addWindow(empleados);
            subWindowAdministracion.close();
        });       
        
         Label label = new Label("LLENE EL FORMULARIO CON LOS DATOS SOLICITADOS PARA EMPLEADOS");
        Label labelExplicacion = new Label("");
        label.addStyleName("h3");
        label.setWidth("110%");
        labelExplicacion.setWidth("110%");
         //ingresar nombre      
        TextField textoNombre = new TextField();
        textoNombre.setPlaceholder("Ingrese su nombre");
        //ingresar apellido
        TextField textoPaterno = new TextField();
        textoPaterno.setPlaceholder("Ingrese su apellido");
        //ingresar fecha
        DateField date=new DateField();
        date.setValue(LocalDate.now());
        //INGRESAR ESPECIALIDAD
        ComboBox<Especialidad> selectEspecialidad = new ComboBox();
            selectEspecialidad.setPlaceholder("Selecciona una Especialidad");
        List<Especialidad> especialidades = new ArrayList();
        especialidades.add(new Especialidad("Traumatologia"));
        especialidades.add(new Especialidad("Ginecologia"));
        especialidades.add(new Especialidad("Pediatria"));
         selectEspecialidad.setItems(especialidades);
            selectEspecialidad.setItemCaptionGenerator(Especialidad::getNombre);
            selectEspecialidad.setWidth("100%");
            
            //ingresar puesto
        ComboBox<Puesto> selectPuesto = new ComboBox();
            selectPuesto.setPlaceholder("Selecciona un Cargo");
        List<Puesto> puestos = new ArrayList();
        puestos.add(new Puesto("Medico responsable"));
        puestos.add(new Puesto("medico interno"));
        puestos.add(new Puesto("enfermera"));
         selectPuesto.setItems(puestos);
            selectPuesto.setItemCaptionGenerator(Puesto::getNombre);
            selectPuesto.setWidth("100%");
        //boton para guardar empleados
        Button botonGuardarEmpleados=new Button("Guardar Empleado",FontAwesome.AMBULANCE);
        botonGuardarEmpleados.addClickListener(hola->{
           Usuario u=new Usuario();
           u.setNombre(textoNombre.getValue());
           u.setPaterno(textoPaterno.getValue());
           u.setFechaIngerso(new Date(date.getDateFormat()));
          repositorioUsuario.save(u);
         //selectPuesto.getSelectedItem().get().getNombre();
        
    });
        
        //añadir componentess
        vlEmpleados.addComponent(textoNombre);
        vlEmpleados.addComponent(textoPaterno);
        vlEmpleados.addComponent(date);
        vlEmpleados.addComponent(selectEspecialidad);
        vlEmpleados.addComponent(selectPuesto);
        vlEmpleados.addComponent(botonGuardarEmpleados);
        
           
            
            
        empleados.setContent(vlEmpleados);
         empleados.setWidth(500,Unit.PIXELS);
           empleados.setHeight(400,Unit.PIXELS);
         empleados.center();
        //addWindow(empleados);
        
        //hasta aqui
        
        //ventaana despues de hacer click en pacientes
       
        Window ventanaPacientes= new Window("Paciente");
        ventanaPacientes.setClosable(false);
        VerticalLayout vlPacientes= new VerticalLayout();
        ventanaPacientes.setContent(vlPacientes);
        botonAutenticar.addClickListener((entrar) -> {
            ventanaPacientes.center();
            addWindow(ventanaPacientes);
            autenticar.close();
        });       
        
         Label labelPacientes = new Label("LLENE EL FORMULARIO CON LOS DATOS SOLICITADOS PARA PACIENTES");
        //Label labelExplicacion = new Label("");
        label.addStyleName("h3");
        label.setWidth("110%");
        labelExplicacion.setWidth("110%");
         //ingresar nombre      
        TextField textoNombrePaciente = new TextField();
        textoNombrePaciente.setPlaceholder("Ingrese su nombre");
        //ingresar apellido
        TextField textoPaternoPaciente = new TextField();
        textoPaternoPaciente.setPlaceholder("Ingrese su apellido");
        //ingresar fecha
        DateField datePaciente=new DateField();
        datePaciente.setValue(LocalDate.now());
        //INGRESAR ESPECIALIDAD
        ComboBox<Especialidad> selectEspecialidadPaciente = new ComboBox();
            selectEspecialidadPaciente.setPlaceholder("Selecciona una Especialidad");
        List<Especialidad> especialidadesPaciente = new ArrayList();
        especialidadesPaciente.add(new Especialidad("Traumatologia"));
        especialidadesPaciente.add(new Especialidad("Ginecologia"));
        especialidadesPaciente.add(new Especialidad("Pediatria"));
         selectEspecialidadPaciente.setItems(especialidadesPaciente);
            selectEspecialidadPaciente.setItemCaptionGenerator(Especialidad::getNombre);
            selectEspecialidadPaciente.setWidth("100%");
            
            //ingresar puesto, en esta caso no lo ocuparemos pero lo dejamos
        //ComboBox<Puesto> selectPuesto = new ComboBox();
          //  selectPuesto.setPlaceholder("Selecciona un Cargo");
       // List<Puesto> puestos = new ArrayList();
       // puestos.add(new Puesto("Medico responsable"));
        //puestos.add(new Puesto("medico interno"));
        //puestos.add(new Puesto("enfermera"));
         //selectPuesto.setItems(puestos);
            //selectPuesto.setItemCaptionGenerator(Puesto::getNombre);
          //  selectPuesto.setWidth("100%");
        //boton para guardar empleados
        
        Button botonGuardarPaciente=new Button("Guardar Paciente",FontAwesome.STETHOSCOPE);
        
        
        //añadir componentess
        vlPacientes.addComponent(textoNombrePaciente);
        vlPacientes.addComponent(textoPaternoPaciente);
        vlPacientes.addComponent(datePaciente);
        vlPacientes.addComponent(selectEspecialidadPaciente);
        //vlEmpleados.addComponent(selectPuesto);
        vlPacientes.addComponent(botonGuardarPaciente);
        
           
            
            
        ventanaPacientes.setContent(vlPacientes);
         ventanaPacientes.setWidth(500,Unit.PIXELS);
           ventanaPacientes.setHeight(400,Unit.PIXELS);
         ventanaPacientes.center();
        //addWindow(empleados);
        
        //hasta aqui
        
        
        
        
        
        
        
        
        
        
        subContentAdministracion.addComponent(textoLoginAdministracion);
        subContentAdministracion.addComponent(textoPasswordAdministracion);
        subContentAdministracion.addComponent(botonAutenticarAdministracion);
         setContent(layoutPrincipal);
         
        
    }
    
}
