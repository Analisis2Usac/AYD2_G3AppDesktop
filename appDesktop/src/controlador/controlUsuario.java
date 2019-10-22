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
import modelos.usuario;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlUsuario {
    
    
    public boolean registrar(String email,String password,String dpi,String nombre,String apellido,String direccion,String telefono,int zona,double latitud,double longitud,int idmunicipio) {
        
            boolean registrar =false;
            Connection con = null;
            int id = 0;
            
            try{
                con = conexion.conectar();
                CallableStatement proc = con.prepareCall(" CALL usuAdd(?,?,?,?,?,?,?,?,?,?,?) ");
                proc.setString("_email", email);
                proc.setString("_contrasenia", password);
                proc.setString("_dpi",dpi);
                proc.setString("_nombre", nombre);
                proc.setString("_apellido",apellido);
                proc.setString("_direccion", direccion);
                proc.setString("_telefono", telefono);
                proc.setInt("_zona",zona);
                proc.setDouble("_latitud", latitud);
                proc.setDouble("_longitud", longitud);
                proc.setInt("_id_municipio", idmunicipio);
                proc.execute();
                
            }catch(Exception e){
                
                System.err.println(e);
            }
            
           return registrar;
    }
   

    public boolean actualizar(String email,String password,String dpi,String nombre,String apellido,String direccion,String telefono,int zona,double latitud,double longitud,int idmunicipio) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                CallableStatement proc = con.prepareCall(" CALL usuAddOrEdit(?,?,?,?,?,?,?,?,?,?,?) ");
                
                proc.setString("_email", email);
                proc.setString("_contrasenia", password);
                proc.setString("_dpi",dpi);
                proc.setString("_nombre", nombre);
                proc.setString("_apellido",apellido);
                proc.setString("_direccion", direccion);
                proc.setString("_telefono", telefono);
                proc.setInt("_zona",zona);
                proc.setDouble("_latitud", latitud);
                proc.setDouble("_longitud", longitud);
                proc.setInt("_id_municipio", idmunicipio);
               
                proc.execute();
                actualizar = true;
                
        } catch (SQLException ex) {
                System.out.println("Error: Clase municipio, no se puede actualizar");
                ex.printStackTrace();
        }
        
        return actualizar;
        
    }
    
    public boolean eliminar (String email) {
        
            Connection con = null;
            Statement stm = null;
            
            boolean eliminar = false;
            String sql = "DELETE FROM usuario WHERE email = "+"'"+ email + "'";
            
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
    
    
    public List<usuario> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT* FROM usuario ORDER BY nombre";
            List<usuario> listUsua = new ArrayList<usuario>();
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
               
               usuario usu = new usuario();
               
               usu.setEmail(rs.getString(1));
               usu.setPassword(rs.getString(2));
               usu.setDpi(rs.getString(3));
               usu.setNombre(rs.getString(4));
               usu.setApellido(rs.getString(5));
               usu.setDireccion(rs.getString(6));
               usu.setTelefono(rs.getString(7));
               usu.setZona(rs.getInt(8));
               usu.setLatitud(rs.getDouble(9));
               usu.setLongitud(rs.getDouble(10));
               usu.setId_municipio(rs.getInt(11));
               listUsua.add(usu);
               
               
            }
            
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("Error: no se puede listar municipios");
                ex.printStackTrace();
            
        }
        
            return listUsua;
    }
    
    
       public boolean verificarInsercion(String email) {
        
            Connection con = null;
            Statement stm = null;
            ResultSet valor = null;
            
            boolean verificar = false;
            String sql = "SELECT* FROM usuario where email = "+"'"+email+"'";
   
            
            try{
            
             con = conexion.conectar();
            stm = con.createStatement();
            valor = stm.executeQuery(sql);
            
            if(valor.equals(null)){
                return true;
            }
            
        } catch (SQLException ex) {
                System.out.println("Error: no se puedo elminar el registro");
                ex.printStackTrace();
        }
        
        return verificar;
        
    }
    
    
    
    
    
}
