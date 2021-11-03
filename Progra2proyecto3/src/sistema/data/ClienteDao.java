/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.data;

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
        String sql="insert into cliente (id, nombre, password, saldo) "+
                "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getId());
        stm.setString(2, c.getNombre());
        stm.setString(3, c.getContraseña());
        stm.setDouble(4, c.getSaldo());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente ya existe");
        }
    }
    
    public Cliente read(String id) throws Exception{
        String sql="select * from Cliente c where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, id);
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
        String sql="update cliente set nombre=?, password=?, saldo=?"+
                "where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getNombre());
        stm.setString(2, c.getContraseña());
        stm.setDouble(3, c.getSaldo());
        stm.setString(4, c.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente no existe");
        }        
    }

    public void delete(Cliente c) throws Exception{
        String sql="delete from cliente where id=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getId());
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente no existe");
        }
    }
    
    
    public List<Cliente> findAll(){
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

    public List<Cliente> findByUsuario(String id){
        List<Cliente> resultado = new ArrayList<>();
        try {
            String sql="select * from cliente c "+
                    "where c.id like ?";            
            PreparedStatement stm = db.prepareStatement(sql);
            stm.setString(1, id+"%");
            ResultSet rs =  db.executeQuery(stm); 
            Cliente c;
            while (rs.next()) {
                c = from(rs, "c"); 
                resultado.add(c);
            }
        } catch (SQLException ex) {  }
        return resultado;
    }
    
    public Cliente from(ResultSet rs, String alias){
        try {
            Cliente c= new Cliente();
            c.setId(rs.getString(alias+".id"));
            c.setNombre(rs.getString(alias+".nombre"));
            c.setContraseña(rs.getString(alias+".contraseña"));
            c.setSaldo(0); //Revisar
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }   
    
    public boolean validarUsuario(String usuario, String contraseña) throws Exception{
        String sql = "select id, nombre from cliente c where nombre=?, password=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, usuario);
        stm.setString(2, contraseña);
        ResultSet rs =  db.executeQuery(stm);
        if (rs.next()) {
            Cliente c = from(rs, "c"); 
            return true;
        }
        else{
            return false;
           // throw new Exception ("Cliente no Existe");
        }        
    }
}
