/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;
//_ArianaQuesada_PabloChavarria_DanielBarrientos
import java.util.Objects;
import java.util.logging.Logger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {
    @XmlID
    String nombre;
    String password;

    public Cliente(){
        nombre = "";
        password = "";
    }
   /* 
    public Cliente(String ced, String nom){
        cedula = ced;
        nombre = nom;
        password = new Password();
        canton = new Canton();
        distrito = new Distrito();
    }*/
   public Cliente(String ced, String nom, String passw)
   {
        nombre = nom;
        password=passw;
   }

    public String getNombre(){
        return nombre;
    }
    public String getPassword(){
        return password;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setPassword(String pass){
        password = pass;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + ", nombre=" + nombre + ", password=" + password;
    }
  
}
