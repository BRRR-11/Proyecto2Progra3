/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Principal;

/**
 *
 * @author ariqq
 */
import sistema.Aplicacion;
import sistema.logico.Service;

public class Controller {
    Model model;
    ViewPrincipal view;

    public Controller(Model model, ViewPrincipal view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
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
    
    /*public void principalShow(){
        this.hide();
        Aplicacion.PRINCIPAL.show();
    }*/
    
    /*public void facturasShow(){
        this.hide();
        Aplicacion.FACTURAS.show();
    } */   
}
