/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author ariqq
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sistema.logico.Cliente;

public class ClienteDao {
    Database db;
    
    public ClienteDao(){
        db= Database.instance();
    }

    public void create(Cliente c) throws Exception{
        String sql="insert into cliente (nombre, password) "+
                "values(?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        stm.setString(2, c.getPassword());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente ya existe");
        }
    }
    
    public Cliente read(String nombre) throws Exception{
        String sql="select * from Cliente c where nombre=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, nombre);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cliente c = from(rs, "c"); 
            return c;
        }
        else{
            throw new Exception ("Cliente no Existe");
        }
    }
    public void update(Cliente c) throws Exception{
        String sql="update cliente set password=? "+
                "where nombre=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getPassword());
        stm.setString(2, c.getNombre());    
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente no existe");
        }        
    }

    public void delete(Cliente c) throws Exception{
        String sql="delete from cliente where cedula=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente no existe");
        }
    }
    
    
   /* public List<Cliente> findAll(){
        List<Cliente> resultado=new ArrayList<>();
        try {
            String sql="select * from Cliente c";
            PreparedStatement stm = db.prepareStatement(sql);
            ResultSet rs =  db.executeQuery(stm);
            Cliente c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) { }
        return resultado;        
    }

    public List<Cliente> findByCedula(String cedula){
        List<Cliente> resultado = new ArrayList<>();
        try {
            String sql="select * from cliente c "+
                    "where c.cedula like ?";            
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, cedula+"%");
            ResultSet rs =  db.executeQuery(stm); 
            Cliente c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }*/
    
    public Cliente from(ResultSet rs, String alias){
        try {
            Cliente c= new Cliente();
            c.setNombre(rs.getString(alias+".nombre"));
            c.setPassword(rs.getString(alias+".password"));
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }    
}
