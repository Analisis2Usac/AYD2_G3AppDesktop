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
import modelos.municipio;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlMunicipio {
    
    
    
     public boolean registrar(String nombre) {
        
            boolean registrar =false;
            Connection con = null;
            int id = 0;
            
            try{
                con = conexion.conectar();
                CallableStatement proc = con.prepareCall(" CALL muniAddOrEdit(?,?) ");
                proc.setInt("_id", id);
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
                CallableStatement proc = con.prepareCall(" CALL muniAddOrEdit(?,?) ");
                proc.setInt("_id", id);
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
            String sql = "DELETE FROM municipio WHERE id_municipio = "+id;
            
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
    
    
    public List<municipio> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM municipio ORDER BY id_municipio";
            List<municipio> listMuni = new ArrayList<municipio>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                municipio mu = new municipio();
               mu.setId(rs.getInt(1));
               mu.setNombre(rs.getString(2));
               listMuni.add(mu);
            }
            
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("Error: no se puede listar municipios");
                ex.printStackTrace();
            
        }
        
            return listMuni;
    }
    
    
    
    
    
    
    
}
