/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logico;

/**
 *
 * @author ariqq
 */
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class Cliente {
    @XmlID    
    String ced;        
    String usuario;
    String contraseña;
    //double cantidad;

    public Cliente() {
        this.ced = "";
        this.usuario = "";
        this.contraseña = "";
        //this.cantidad = 0;
    }

    public Cliente(String id,String nombre, String contraseña) {
        this.ced = id;
        this.usuario = nombre;
        this.contraseña = contraseña;
    }
    public Cliente(String id,String nombre, String contraseña, double saldo) {
        this.ced = id;
        this.usuario = nombre;
        this.contraseña = contraseña;
        //this.cantidad = saldo;
    }

    public String getId() {
        return ced;
    }

    public void setId(String id) {
        this.ced = id;
    }
 
    public String getNombre() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.usuario = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    /*public double getSaldo() {
        return cantidad;
    }

    public void setSaldo(double saldo) {
        this.cantidad = saldo;
    }*/

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.ced);
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
        if (!Objects.equals(this.ced, other.ced)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return usuario;
    }
  
}
