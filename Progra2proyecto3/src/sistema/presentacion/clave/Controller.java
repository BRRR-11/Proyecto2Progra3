/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.clave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.logico.Service;
import sistema.logico.Cliente;
/**
 *
 * @author ariqq
 */
public class Controller {
     Model model;
     ViewClave view;

    public Controller(Model model, ViewClave view) {
        this.model = model;
        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setCliente(new Cliente());
        model.setClientes(new ArrayList<>());
        
        view.setModel(model);
        view.setController(this);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void hide(){
        this.view.setVisible(false);
       // Application.PRINCIPAL.show();
    }    
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void clienteGet(String cedula){
        try {
            Cliente cliente = Service.instance().clienteGet(cedula);
            model.setCliente(cliente);
            //model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.setClientes(new ArrayList<>());
            model.commit();
        }
    }
    
    /*public void  clienteSearch(String cedula){
        List<Cliente> clientes= Service.instance().clienteSearch(cedula);
        model.setCliente(new Cliente(cedula,"",""));
        model.setClientes(clientes);
        model.commit();
    }*/
    
    public void clienteEdit(int row){
        Cliente cliente = model.getClientes().get(row);
        model.setCliente(cliente);
        model.commit();
    }
    
    public void clienteAdd(Cliente cliente){
        try {
            Service.instance().clienteAdd(cliente);
            model.setCliente(new Cliente("","",""));
            model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            
        }
        
    }
    
}
