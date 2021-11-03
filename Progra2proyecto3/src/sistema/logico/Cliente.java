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
    String id;        
    String nombre;
    String contraseña;
    double saldo;

    public Cliente() {
        this.id = "";
        this.nombre = "";
        this.contraseña = "";
        this.saldo = 0;
    }

    public Cliente(String id,String nombre, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
    }
    public Cliente(String id,String nombre, String contraseña, double saldo) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
  
}
