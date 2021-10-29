/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;

import Data.Data;
//import data.XmlPersister;
import java.util.List;
import java.util.stream.Collectors;

//_ArianaQuesada_PabloChavarria_DanielBarrientos

public class Service {
    // Singleton implementation
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    // Service data
    
    private Data data;
    
    public List<Cliente> clienteAll(){
        return data.getClientes();       
    }
    public List<Cliente> getCliente(){
        return data.getClientes();
    }
    
    
    public Cliente clienteGet(String cedula) throws Exception{
        Cliente result=data.getClientes().stream().filter(c->c.getCedula().equals(cedula)).findFirst().orElse(null);
        if (result!=null) return result;
        else throw new Exception("Cliente no existe");   
    }
    
     public List<Cliente> clienteSearch(String cedula){
        List<Cliente> result=data.getClientes().stream().filter(c->c.getCedula().startsWith(cedula)).collect(Collectors.toList());
       return result;        
    }
     
     public void creandoCliente(Cliente cli) throws Exception {
        Cliente resul = data.getClientes().stream().filter(c->c.getCedula().equals(cli.getCedula())).findFirst().orElse(null);
        if(resul == null)data.getClientes().add(cli); 
        else throw new Exception("Cliente ya existe");
    }
  
     public void store(){
        try {
            //XmlPersister.instance().store(data);
        } catch (Exception ex) {
        }
    }
    public Service() {
        try{
           // data = XmlPersister.instance().load();
        }
        catch(Exception e){
            data =  new Data();
        }
    }

}
