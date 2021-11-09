/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.presentacion.Inicial;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import sistema.Aplicacion;
import sistema.logico.Cliente;
import sistema.logico.Service;
/**
 *
 * @author ariqq
 */
public class Controller {
    Model model;
    ViewInicio view;

    public Controller(Model model, ViewInicio view) {
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
        //Aplicacion.INICIO.show();
    }   
    public void principalShow(String usuario){
        this.hide();
        Aplicacion.PRINCIPAL.show();
        Aplicacion.CAMBIO.setearUsuario(usuario);
        Aplicacion.CONSULTAR.setearUsuarioConsulta(usuario);
        Aplicacion.RETIRO.usuarioRetiro(usuario);
        Aplicacion.RETIRO.clienteGet(usuario);
    }
    
    public String contraseñaText(){
        String actual = this.view.passText.getText();
        return actual;
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
    
    public void clienteAdd(Cliente cliente){
     /*   try {
            Service.instance().clienteAdd(cliente);
            model.setCliente(new Cliente("",""));
            model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Mensaje");
        }*/
        
    }
    
    public boolean verficarContra(){
        try{
            if(Service.instance().verificaContraseña(String.valueOf(this.view.passText.getPassword())) == true){
                Service.instance().verificaContraseña(String.valueOf(this.view.passText.getPassword()));
                //model.setCliente(new Cliente("","",String.valueOf(this.view.passText.getPassword())));
                //model.setClientes(Arrays.asList(cliente));
                model.commit();
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"La contraseña no es segura");
                return false;
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"La contraseña no es segura");
            return false;
        }
    }
    public boolean validarUsuario(String usuario, String contraseña){
        try{
            if(Service.instance().validarUsuario(usuario, contraseña) == true){
                //Service.instance().validarUsuario(usuario, contraseña);
                model.setCliente(new Cliente(usuario, contraseña));
                model.commit();
                return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"La contraseña o usuario es incorrecta");
                return false;
            }
            
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"La contraseña o usuario es incorrecta");
            return false;
        }
    }
    
}

