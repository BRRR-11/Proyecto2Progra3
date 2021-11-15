
package sistema.comunication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import sistema.logico.Service;
import sistema.logico.Cliente;

public class Server {
    ServerSocket ss;
    public static final String SERVER = "localhost";
    public static final int PORT = 1234;
    
    public Server() throws IOException {
        ss = new ServerSocket(PORT);
        System.out.println("Servidor iniciado...");
    }
    public static boolean continuar = true;
    public void run(){
        
        String solicitud;
        Socket s;
        ObjectInputStream in;
        ObjectOutputStream out;
        while (continuar) {
            try {
                s = ss.accept();
                out = new ObjectOutputStream(s.getOutputStream() );
                in = new ObjectInputStream(s.getInputStream());                
                try {
                    solicitud=(String)in.readObject();
                    String[] datos = solicitud.split("@"); 
                    if(Service.instance().validarUsuario(datos[1], datos[2])){
                        out.writeObject("OK");
                        out.flush();
                        System.out.println("Conexion Establecida...");
                        Cliente cliente = Service.instance().clienteGet(datos[1]);
                        Worker worker = new Worker(s,in,out,cliente); 
                        worker.start();  
                    }else{
                        out.writeObject("ERROR");
                        out.flush();
                        s.close(); 
                    }   
                                     
                } catch (Exception ex) {   
                    out.writeObject("ERROR@Error interno");
                    out.flush();
                    s.close();
                }                

            } catch (IOException ex) { }
        }
    }
    public void detener(){
        continuar = false;
    }
    
}