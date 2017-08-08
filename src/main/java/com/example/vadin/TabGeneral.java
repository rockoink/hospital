package com.example.vadin;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@UIScope
@SpringUI

public class TabGeneral extends VerticalLayout {
    RepositorioUsuario repositorioUsuario;
    RepositorioPaciente repositorioPaciente;
    
    
public TabGeneral(RepositorioUsuario repositorioUsuario,RepositorioPaciente repositorioPaciente){
    this.repositorioUsuario=repositorioUsuario;
    this.repositorioPaciente=repositorioPaciente;
    
    this.setMargin(true);
        this.setSpacing(true);
        Label label = new Label("LLENE EL FORMULARIO CON LOS DATOS SOLICITADOS PARA EMPLEADOS");
        Label labelExplicacion = new Label("");
        label.addStyleName("h3");
        label.setWidth("100%");
        labelExplicacion.setWidth("100%");
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
            
            this.addComponent(label);
        this.addComponent(labelExplicacion);
        this.addComponent(textoNombre);
        this.addComponent(textoPaterno);
        this.addComponent(date);
        this.addComponent(selectEspecialidad);
        this.addComponent(selectPuesto);
        Styles styles = Page.getCurrent().getStyles();
            
}    
}
