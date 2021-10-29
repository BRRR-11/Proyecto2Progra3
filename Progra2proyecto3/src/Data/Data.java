/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlRootElement;
import sistema.logico.Cliente;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class Data {
   private List<Cliente> clientes;
   
   public Data(){
       clientes = new ArrayList();
   }
   public List<Cliente> getClientes() {
        return clientes;
   }
   
   public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
   }

    
    
}

