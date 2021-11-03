/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;
import java.util.List;
import sistema.data.ClienteDao;
/**
 *
 * @author ariqq
 */
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
      ClienteDao cDao;
    

    
    // Service methods
    public Cliente clienteGet(String cedula) throws Exception{
        return cDao.read(cedula);
    }
    
    public List<Cliente> clienteSearch(String cedula){
        return cDao.findByUsuario(cedula);       
    }
    
    public List<Cliente> clienteAll(){
        return cDao.findAll();
    }
    
    public void clienteAdd(Cliente cliente) throws Exception{
        cDao.create(cliente);
    }    
     public boolean verificaContraseña(String contras) throws Exception{
        String contraseña= contras;
        int cant=0;
        int mayus = 0;
        int minus=0;
        int num=0;
    
        if(contraseña.length()>7)
        {
            cant+=1;
        }
        
        for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isUpperCase(caracter))
            {
                mayus+=1;
            }
        }
         //////////////////////////////////////////////
         for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isLowerCase(caracter))
            {
                minus+=1;
            }
        }
         ///////////////////////////////////////////////
         for(int j=0; j<contraseña.length();j++) {

            char caracter= contraseña.charAt(j);
            if(Character.isDigit(caracter))
            {
                num+=1;
            }
        }

        if(cant>=1 && mayus>=1 && minus>=1 && num>=1)
        {
            System.out.println("La contaseña es fuerte");
            return true;
        }
        else
        {
            System.out.println("La contraseña es débil");
            return false;
        }
    }
    public boolean validarUsuario(String usuario, String contraseña) throws Exception{
        if(cDao.validarUsuario(usuario, contraseña)==true){
            cDao.validarUsuario(usuario, contraseña);
            return true;
        }
        else{
            return false;
        }
            
    }
    public Service() {
        try{
            cDao= new ClienteDao();
        }
        catch(Exception e){

        }

    }
}