/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;
import java.util.List;
import java.util.regex.Pattern;
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
    public Cliente clienteGet(String nombre) throws Exception{
        return cDao.read(nombre);
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
        int car=0;
        String str="";
        
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
          //////////////////////Especiales/////////////////////////
         for(int j=0; j<contraseña.length();j++) {
            //int asciiVal = (int) str.charAt(j);
            //char caracter= contraseña.charAt(j);
           // char a = (asciiVal >= 32);
           if((contraseña.charAt(j)>= 58 && contraseña.charAt(j)<= 64)||(contraseña.charAt(j)>= 33&&contraseña.charAt(j)<=47)||(contraseña.charAt(j)>= 91&&contraseña.charAt(j)<=96)||(contraseña.charAt(j)>= 123&&contraseña.charAt(j)<=126))
           {
               car+=1;
           }
        }

        if(cant>=1 && mayus>=1 && minus>=1 && num>=1 && car>=1)
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
    public boolean validarContraseña(String contraseña) throws Exception{
        if(cDao.validarContraseña(contraseña)==true){
            cDao.validarContraseña(contraseña);
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
    public void modificarContraseña(String usuario, String contraseña)throws Exception{
        cDao.modificarContraseña(usuario, contraseña);
    }
}