/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.inicio;


import java.io.IOException;
import sistema.logico.Cliente;
import java.util.ArrayList;
import java.util.Arrays;
import sistema.principal.Aplicacion;
import java.util.Random;
import javax.swing.JOptionPane;
import sistema.logico.Service;

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
     public void principalShow(){
        this.hide();
        Aplicacion.PRINCIPAL.show();
    }
    
    public void verificaContraseña()
    {
        try{
            Service.instance().verificaContraseña(String.valueOf(this.view.passText.getPassword()));
            model.setCliente(new Cliente("",""));
            //model.setClientes(Arrays.asList(cliente));
            model.commit();
            
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Contraseña Incorrecta");
        }
    }
    /* public void clienteAdd(Cliente cliente){
        try {
            Service.instance().clienteAdd(cliente);
            model.setCliente(new Cliente("","",""));
            model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
*/
    
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