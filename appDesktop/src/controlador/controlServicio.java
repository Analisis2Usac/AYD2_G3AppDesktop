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
import modelos.municipio;
import modelos.servicio;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlServicio {



    
    public boolean registrar(String nombre,int llave){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        try{
            con = conexion.conectar();
            CallableStatement proc = con.prepareCall(" CALL serviceAddOrEdit (?,?,?)");
            proc.setInt("_id_servicio", id);
            proc.setString("_nombre_servicio", nombre);
            proc.setInt("_id_categoria", llave);
            proc.execute();
        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean Actulizar(int id,String nombre,int llave){
         
         Connection con  = null;
         boolean actualizar = false;
     
         try{
             
             con = conexion.conectar();
             CallableStatement proc = con.prepareCall(" CALL serviceAddOrEdit (?,?,?)");
             proc.setInt("_id_servicio", id);
             proc.setString("_nombre_servicio", nombre);
             proc.setInt("_id_categoria", llave);
             proc.execute();
             
         }catch(Exception e){
             System.err.println(e);
         }
         
         return actualizar;
     }
     
     
     public boolean eliminar(int id){
         
         Connection con = null;
         Statement stm = null;
         
         boolean eliminar = false;
         String  sql = "DELETE FROM servicio WHERE id_servicio = "+ id;
         
         try{
             con = conexion.conectar();
             stm = con.createStatement();
             stm.execute(sql);
             eliminar = true;
             
         }catch(Exception e){
             System.err.println(e);
             e.printStackTrace();
         }
         
         return eliminar;
     }
     
     
     public List<servicio> obtener(){
         Connection con = null;
         Statement stm = null;
         ResultSet rs = null;
         
         String sql = "SELECT* FROM servicio ORDER BY id_servicio";
         List<servicio> listaS = new ArrayList<>();
         
         try{
             con = conexion.conectar();
             stm = con.createStatement();
             rs = stm.executeQuery(sql);
             
             while(rs.next()){
                 servicio ser = new servicio();
                 ser.setId(rs.getInt(1));
                 ser.setNombre(rs.getString(2));
                 ser.setId_categoria(rs.getInt(3));
                 listaS.add(ser);
                 
             }
             stm.close();
             rs.close();
             con.close();
             
             
             
             
         }catch(Exception e){
             System.err.println(e);
         }
         return listaS;
     }
     
     
     public String nombreServicio(int id){
         Connection con  = null;
         Statement stm = null;
         ResultSet rs = null;
         String sql = "SELECT* from servicio where id_servicio = " + id;
         String nombre = "";
         
         try {
             con = conexion.conectar();
             stm = con.createStatement();
             rs = stm.executeQuery(sql);
             
            if(rs.next()){
            nombre = rs.getString(2);
            }
             
            rs.close();
            stm.close();
            con.close();
            
             
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return nombre;
     }
     
     
     public String nombreCategoria(int id){
         Connection con  = null;
         Statement stm = null;
         ResultSet rs = null;
         String sql = "SELECT* from categoria where id_categoria = " + id;
         String nombre = "";
         
         try {
             con = conexion.conectar();
             stm = con.createStatement();
             rs = stm.executeQuery(sql);
             
            if(rs.next()){
            nombre = rs.getString(2);
            }
             
            rs.close();
            stm.close();
            con.close();
            
             
             
         } catch (Exception e) {
             e.printStackTrace();
         }
         return nombre;
     }
     
     
     
     
     
     
     
     
     
    
    
    
    
    
    
    
            
    
    
    
}
