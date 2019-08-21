/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class implementarMunicipio implements metodoMunicipio {

    @Override
    public boolean registrar(municipio muni) {
        
      
            boolean registrar =false;
            
            Statement stm = null;
            Connection con = null;
            
            String sql = "INSERT INTO municipio VALUES ( NULL,'"+muni.getNombre()+"')";
            
           try{ 
            con = conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException ex) {
               System.out.println("Erro: clase municipio, no se pudo registrar ");
               ex.printStackTrace();
        }
           
           return registrar;
    }

    @Override
    public boolean actualizar(municipio muni) {
        
       
            Connection con = null;
            Statement stm = null;
            
            boolean actualizar =false;
            String sql = "UPDATE municipio SET nombre ='"+muni.getNombre()+"'"+" WHERE id_municipio = "+ muni.getId();
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException ex) {
                System.out.println("Error: Clase municipio, no se puede actualizar");
                ex.printStackTrace();
        }
        
        return actualizar;
        
    }

    @Override
    public boolean eliminar(municipio muni) {
        
            Connection con = null;
            Statement stm = null;
            
            boolean eliminar = false;
            String sql = "DELETE FROM municipio WHERE id_municipio = "+muni.getId();
            
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

    @Override
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
