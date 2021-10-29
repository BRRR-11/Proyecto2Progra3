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
    String cedula;
    String nombre;
    String password;

    String canton;
  
    String distrito;
    
    public Cliente(){
        cedula = "";
        nombre = "";
        password = "";
        canton = "";
        distrito = "";
    }
   /* 
    public Cliente(String ced, String nom){
        cedula = ced;
        nombre = nom;
        password = new Password();
        canton = new Canton();
        distrito = new Distrito();
    }*/
   public Cliente(String ced, String nom, String prov, String cant, String dis)
   {
        cedula = ced;
        nombre = nom;
        password=prov;
        canton= cant;
        distrito = dis;
   }

    public String getNombre(){
        return nombre;
    }
    public String getCedula(){
        return cedula;
    }
    public String getPassword(){
        return password;
    }
    
    public void setNombre(String nom){
        nombre = nom;
    }
    public void setCedula(String ced){
        cedula = ced;
    }
    public void setPassword(String pass){
        password = pass;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cedula);
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
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "cedula=" + cedula + ", nombre=" + nombre + ", password=" + password + ", canton=" + canton + ", distrito=" + distrito + '}';
    }

    
   
   
    
    
}
