/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.categoria;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlPago {
    
    
     public boolean registrar(String nombre){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            CallableStatement proc = con.prepareCall(" CALL categoryAddOrEdit (?,?)");
            proc.setInt("_id_categoria", id);
            proc.setString("_nombre", nombre);
            proc.execute();
            
        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,String nombre) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                CallableStatement proc = con.prepareCall(" CALL categoryAddOrEdit(?,?) ");
                proc.setInt("_id_categoria", id);
                proc.setString("_nombre", nombre);
                proc.execute();
                actualizar = true;
                
        } catch (SQLException ex) {
                System.out.println("Error: Clase municipio, no se puede actualizar");
                ex.printStackTrace();
        }
        
        return actualizar;
        
    }
    
    public boolean eliminar(int id) {
        
            Connection con = null;
            Statement stm = null;
            
            boolean eliminar = false;
            String sql = "DELETE FROM categoria WHERE id_categoria = "+id;
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException ex) {
                System.out.println("Error: no se puedo elminar el registro");
                ex.printStackTrace();
        }
        
        return eliminar;
        
    }
    
    
    public List<categoria> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM categoria ORDER BY id_categoria";
            List<categoria> listcat = new ArrayList<categoria>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                categoria ca = new categoria();
               ca.setId(rs.getInt(1));
               ca.setNombre(rs.getString(2));
               listcat.add(ca);
            }
            
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("Error: no se puede listar municipios");
                ex.printStackTrace();
            
        }
        
            return listcat;
    }
    
    
    
    
    
    
    
    
    
}
