/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariqq
 */
public class Service {
    
    // Singleton implementation
    private static Service theInstance;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static Socket s;
    public static final String SERVER = "localhost";
    public static final int PORT = 1234; 
    
    
    private Service() {
     try{
            s = new Socket(SERVER,PORT);
            out = new ObjectOutputStream(s.getOutputStream() );
            in = new ObjectInputStream(s.getInputStream());
           
        } catch (IOException ex) {
            System.out.println("Error de comunicación");
            System.exit(0);
        }
    }

    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }  
        return theInstance;
    }
    
    // Service methods
    public Cliente clienteGet(String nombre) throws Exception{ 
        out.writeObject("clienteGet@"+nombre);
        out.flush();
        Cliente respuesta=(Cliente) in.readObject();
        if(respuesta==null){
            throw new Exception("Error no se pudo encontrar el cliente");
        }
        return respuesta;
    }
    
    public List<Cliente> clienteSearch(String cedula) {
        try {
            List<Cliente> lista = new ArrayList<>();
            lista.add(clienteGet(cedula));
            return lista;
        } catch (IOException ex) {
           return new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            return new ArrayList<>();
        } catch (Exception ex) {
            return new ArrayList<>();
        }
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
    
    public boolean validarUsuario(String usuario, String contrasena) throws Exception{
        
        out.writeObject("login@"+usuario+"@"+contrasena);
        out.flush();
        String respuesta=(String) in.readObject();
        return "OK".equals(respuesta);
    }
    
    
    public void modificarContraseña(String usuario, String contrasena)throws Exception{
       // cDao.modificarContraseña(usuario, contraseña);
        out.writeObject("passwordSet@"+usuario+"@"+contrasena);
        out.flush();
        String respuesta=(String) in.readObject();
        if("ERROR".equals(respuesta)){
            throw new Exception("Error no se pudo modificar");
        }
    }
    
    public void modificarSaldo(String usuario,String saldo)throws Exception
    {
       // cDao.modificarSaldo(usuario, saldo);
        out.writeObject("saldoSet@"+usuario+"@"+saldo);
        out.flush();
        String respuesta=(String) in.readObject();
        if("ERROR".equals(respuesta)){
            throw new Exception("Error no se pudo modificar");
        }
    }
    
    
}