/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Retiro;

/**
 *
 * @author ariqq
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import sistema.Aplicacion;
import sistema.logico.Cliente;
import sistema.logico.Service;

public class Controller {
    Model model;
    ViewRetiro view;

    public Controller(Model model, ViewRetiro view) {
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
    public void usuarioRetiro(String usuario){
        this.view.usuarioRetiText.setText(usuario);
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
    public void modificarSaldo(String usuario,String saldo)
    {
        try
        {
                Service.instance().modificarSaldo(usuario, saldo);
                model.setCliente(new Cliente("","",Double.valueOf(saldo)));
                model.commit();
            
        }catch (Exception ex){
            //JOptionPane.showMessageDialog(null,"El monto es superior");
        }
    }
}
