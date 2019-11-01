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
import modelos.foto;
import modelos.video;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlVideo {
    
    
     public boolean registrar(String ruta,int idEmpleado){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL videoAddOrEdit (?,?,?)");

            proc.setInt("_id_video", id);
            proc.setString("_ruta_video", ruta);
            proc.setInt("_id_empleado", idEmpleado);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,String ruta,int idEmpleado) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
            CallableStatement proc = con.prepareCall(" CALL videoAddOrEdit (?,?,?)");

            proc.setInt("_id_video", id);
            proc.setString("_ruta_video", ruta);
            proc.setInt("_id_empleado", idEmpleado);
            
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
            String sql = "DELETE FROM video WHERE id_video = "+id;
            
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
    
    
    public List<video> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM video ORDER BY id_video";
            List<video> list = new ArrayList<video>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               video v = new video();
               v.setIdVideo(rs.getInt(1));
               v.setRuta(rs.getString(2));
               v.setIdEmpleado(rs.getInt(3));
               
               list.add(v);
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
