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
import modelos.calificacion;
import modelos.comentario;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlCalificacion {
    
    
     public boolean registrar(int cali,int idContrato){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL caliAddOrEdit (?,?,?)");

            proc.setInt("_id_calificacion", id);
            proc.setInt("_calificacion", cali);
            proc.setInt("_id_contrato", idContrato);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,int cali,int idContrato) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
            CallableStatement proc = con.prepareCall(" CALL caliAddOrEdit (?,?,?)");

            proc.setInt("_id_calificacion", id);
            proc.setInt("_calificacion", cali);
            proc.setInt("_id_contrato", idContrato);
            
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
            String sql = "DELETE FROM calificacion WHERE id_calificacion = "+id;
            
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
    
    
    public List<calificacion> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM calificacion ORDER BY id_calificacion";
            List<calificacion> list = new ArrayList<calificacion>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               calificacion ca = new calificacion();
               ca.setIdCalificacion(rs.getInt(1));
               ca.setCalificacion(rs.getInt(2));
               ca.setIdContrato(rs.getInt(3));
               
               list.add(ca);
            }
            
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("Error: no se puede listar municipios");
                ex.printStackTrace();
            
        }
        
            return list;
    }
    
    
    
    
    
    
    
    
}
