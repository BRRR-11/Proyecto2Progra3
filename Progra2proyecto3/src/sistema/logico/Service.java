/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;

import Data.Database;
//import data.XmlPersister;
import java.util.List;
import java.util.stream.Collectors;

//_ArianaQuesada_PabloChavarria_DanielBarrientos

import java.util.List;
import Data.ClienteDao;
//import Data.FacturaDao;

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
      //FacturaDao fDao ;
      ClienteDao cDao;
    

    
    // Service methods
    public Cliente clienteGet(String cedula) throws Exception{
        return cDao.read(cedula);
    }
    
    /*public List<Cliente> clienteSearch(String cedula){
        return cDao.findByCedula(cedula);       
    }
    
    public List<Cliente> clienteAll(){
        return cDao.findAll();
    }*/
    
    public void clienteAdd(Cliente cliente) throws Exception{
        cDao.create(cliente);
    }    

//---------------
    /*public Factura facturaGet(String numero) throws Exception{
        return fDao.read(numero);
    }
    
    public List<Factura> facturaSearch(String numero){
        return fDao.findByNumero(numero);       
    }
    
    public void facturaAdd(Factura factura) throws Exception{
        fDao.create(factura);
    }    */
     
    public Service() {
        try{
              //fDao = new FacturaDao();
              cDao= new ClienteDao();
        }
        catch(Exception e){

        }

    }
    
}
