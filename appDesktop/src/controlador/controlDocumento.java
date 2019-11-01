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
import modelos.documento;
import modelos.video;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlDocumento {
    
    
    public boolean registrar(String documento,int idEmpleado){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL docAddOrEdit (?,?,?)");

            proc.setInt("_id_documento", id);
            proc.setString("_documento", documento);
            proc.setInt("_id_empleado", idEmpleado);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,String documento,int idEmpleado) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
            CallableStatement proc = con.prepareCall(" CALL docAddOrEdit (?,?,?)");

            proc.setInt("_id_documento", id);
            proc.setString("_documento", documento);
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
            String sql = "DELETE FROM documento WHERE id_documento = "+id;
            
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
    
    
    public List<documento> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM documento ORDER BY id_documento";
            List<documento> list = new ArrayList<documento>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               documento d = new documento();
               d.setIdDocumento(rs.getInt(1));
               d.setDocumento(rs.getString(2));
               d.setIdEmpleado(rs.getInt(3));
               
               list.add(d);
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
