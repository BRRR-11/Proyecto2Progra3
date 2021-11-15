package sistema.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistema.logico.Service;
import sistema.logico.Cliente;


public class Worker {
    Socket s;
    ObjectInputStream in;
    ObjectOutputStream out;
    Cliente usuario;
    
    public Worker(Socket s, ObjectInputStream in,  ObjectOutputStream out, Cliente usuario) {
        this.s = s;
        this.in=in;
        this.out=out;
        this.usuario=usuario;
    }
    
    private boolean condition=false;
    
    public void start(){
        
        System.out.println("Worker "+ usuario.getNombre()+ " atendiendo peticiones...");
        Runnable tarea = new Runnable(){
            public void run(){
                while(condition){ 
                    listen();
                }
                System.out.println("Worker "+ usuario.getNombre()+ " finalizo...");
            }
        };
        Thread hilo = new Thread(tarea);
        condition=true;
        hilo.start();
    }

    public void listen(){
      
        String parameter="";
           
            try { 
                parameter = (String)in.readObject();
                String[] result= parameter.split("@");
                switch(result[0]){
                    case "clienteGet":{
                        Cliente c =  Service.instance().clienteGet(result[1]);
                        out.writeObject(c);
                        break;
                    }
                    case "passwordSet":{
                        Service.instance().modificarContraseña(result[1], result[2]);
                        out.writeObject("OK");
                        break;
                    }
                    case "saldoSet":{
                        Service.instance().modificarSaldo(result[1], result[2]);
                        out.writeObject("OK");
                        break;
                    }
                    case "logout":{
                        //s.close();
                        condition = false;
                        System.out.println("hizo logout worker");
                        
                        break;
                    }
                    default:
                        throw new Exception();
                }
            } catch (Exception ex) {
                condition = false;
            try {
                out.writeObject("ERROR");
            } catch (IOException ex1) {
                
            }
        }
    }

}
