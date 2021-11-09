/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Consultar;

/**
 *
 * @author XPC
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Aplicacion;
import sistema.logico.Cliente;
import sistema.logico.Service;

public class Controller {
    Model model;
    ViewConsultar view;

    public Controller(Model model, ViewConsultar view) {
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
        Aplicacion.PRINCIPAL.show();
    }  
    public void setearUsuarioConsulta(String usuario){
        this.view.usuarioConsulText.setText(usuario);
    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void clienteGet(String nombre){
        try {
            Cliente cliente = Service.instance().clienteGet(nombre);
            model.setCliente(cliente);
            //model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.setClientes(new ArrayList<>());
            model.commit();
        }
    }
    
    public void  clienteSearch(String nombre){
        List<Cliente> clientes= Service.instance().clienteSearch(nombre);
        model.setCliente(new Cliente(nombre,""));
        model.setClientes(clientes);
        model.commit();
    }
    
    public void clienteEdit(int row){
        Cliente cliente = model.getClientes().get(row);
        model.setCliente(cliente);
        model.commit();
    }
}
