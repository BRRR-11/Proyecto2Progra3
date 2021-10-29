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
    
    public void showPrestamoCliente(String cli)
    {
      this.hide();
      Aplicacion.PRESTAMO.show();
      //sistema.presentacion.prestamo.View.cedText.setText(ced);
      //Aplicacion.PRESTAMO.setearCed(ced);
      Aplicacion.PRESTAMO.setearCed(cli);
      Aplicacion.PRESTAMO.setearNombre(cli);
    }
    
    
   /* public void buscar(String provincia) 
    {
        try{
            model.buscar(provincia);
        }
        catch (Exception ex) 
        {
            model.setCantones(new ArrayList<>());
            model.commit();
        }
    }
    
    public void consultar(String cedula){
         try {
             model.consultar(cedula);
            
         } catch (Exception ex) {
            model.setCliente(new Cliente());
            model.commit();
         }
    }
  
*/
    private void hide() {
        this.view.setVisible(false);
    }

    void cargarCantones(String provincia) {
       try{
            //model.buscar(provincia);
        }
        catch (Exception ex) 
        {
           // model.setCantones(new ArrayList<>());
            model.commit();
        }
    }

   /* void guardar(String id, String nombre, String provincia, String canton, String distrito ) {
       try{
           Cliente cli = new Cliente(id, nombre, provincia, canton, distrito);
          model.crearCliente(cli);      
        }
        catch (Exception exi){
           model.setCliente(new Cliente());       
        }
    }*/
    
   /* public void cargarDistritos(Canton canton){
        if(canton != null){
            model.setDistritos(canton.getDistrito());
            model.commit();
        }
    }

    void guardarDatos() {
        model.guardarDatos();
    }
    
    public void generarPDFclientes() throws IOException{
        model.clientesPDF();
    }*/
    
    
    
 
    
}