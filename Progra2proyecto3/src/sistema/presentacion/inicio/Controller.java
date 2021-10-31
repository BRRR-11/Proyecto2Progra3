/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.inicio;


import java.io.IOException;
import sistema.logico.Cliente;
import java.util.ArrayList;
import sistema.principal.Aplicacion;

public class Controller {
     Model model;
     inicio view;

    public Controller(Model model, inicio view) {
        this.model = model;
        this.view = view;
       
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
    }
    
    public void exit(){
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    /*public void clientesShow(){
        this.hide();
        Application.CLIENTES.show();
    }
    
    public void facturasShow(){
        this.hide();
        //Application.FACTURAS.show();
    } */
    
}