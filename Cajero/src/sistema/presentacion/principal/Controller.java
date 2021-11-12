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
        Aplicacion.INICIO.show();
    }
    public void consultarShow(){
        this.hide();
        Aplicacion.CONSULTAR.show();
    }
     public void retirarShow(){
        this.hide();
        Aplicacion.RETIRO.show();
    }
     public void cambioShow(){
        this.hide();
        Aplicacion.CAMBIO.show();
    }
    public void exit(){
        this.view.setVisible(false);
    }
    public void logout(){
        try{
            Service.instance().logout();
        }
        catch(Exception ex){
             System.out.println("No pudo hacer logout");
        }
        
    }
}
