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
import modelos.empresa;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlEmpresa {
   
    
     public boolean registrar(int nit,String nombre,String direccion,String tel,int zona,double latitud,double longitud,int muni,String email,String passw){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            CallableStatement proc = con.prepareCall(" CALL empresaAddOrEdit (?,?,?,?,?,?,?,?,?,?,?)");
            proc.setInt("_id_empresa", id);
            proc.setInt("_nit",nit);
            proc.setString("_nombre",nombre);
            proc.setString("_direccion",direccion);
            proc.setString("_telefono",tel);
            proc.setInt("_zona",zona);
            proc.setDouble("_latitud", latitud);
            proc.setDouble("_longitud",longitud);
            proc.setInt("_id_municipio",muni);
            proc.setString("_email",email);
            proc.setString("_password", passw);
            proc.execute();
            
        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
     
     
      public boolean actualizar(int id,int nit,String nombre,String direccion,String tel,int zona,double latitud,double longitud,int muni,String email,String passw) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
            CallableStatement proc = con.prepareCall(" CALL empresaAddOrEdit (?,?,?,?,?,?,?,?,?,?,?)");
            proc.setInt("_id_empresa", id);
            proc.setInt("_nit",nit);
            proc.setString("_nombre",nombre);
            proc.setString("_direccion",direccion);
            proc.setString("_telefono",tel);
            proc.setInt("_zona",zona);
            proc.setDouble("_latitud", latitud);
            proc.setDouble("_longitud",longitud);
            proc.setInt("_id_municipio",muni);
            proc.setString("_email",email);
            proc.setString("_password", passw);
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
            String sql = "DELETE FROM empresa WHERE id_empresa = "+id;
            
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
      
      
      public List<empresa> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM empresa ORDER BY id_empresa";
            List<empresa> list = new ArrayList<empresa>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                
               empresa e = new empresa();
               e.setId(rs.getInt(1));
               e.setNit(rs.getInt(2));
               e.setNombre(rs.getString(3));
               e.setDireccion(rs.getString(4));
               e.setTelefono(rs.getString(5));
               e.setZona(rs.getInt(6));
               e.setLatitud(rs.getDouble(7));
               e.setLongitud(rs.getDouble(8));
               e.setId_municipio(rs.getInt(9));
               e.setEmail(rs.getString(10));
               e.setPassword(rs.getString(11));
              
               list.add(e);
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
