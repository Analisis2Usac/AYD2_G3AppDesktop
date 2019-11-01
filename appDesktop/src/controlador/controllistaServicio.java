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
import modelos.lista_servicio;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controllistaServicio {
    
    
    public boolean registrar(int idEmpresa,int idServicio,double precio){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL list_serviceAdd (?,?,?)");

            proc.setInt("_id_empresa", idEmpresa);
            proc.setInt("_id_servicio", idServicio);
            proc.setDouble("_precio",precio);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int idEmpresa,int idServicio,double precio) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
            CallableStatement proc = con.prepareCall(" CALL list_serviceEdit (?,?,?)");
            
            proc.setInt("_id_empresa", idEmpresa);
            proc.setInt("_id_servicio", idServicio);
            proc.setDouble("_precio",precio);
            
            proc.execute();
            
            actualizar = true;
                
        } catch (SQLException ex) {
                System.out.println("Error: Clase municipio, no se puede actualizar");
                ex.printStackTrace();
        }
        
        return actualizar;
        
    }
    
    public boolean eliminar(int idEmpresa,int idServicio) {
        
            Connection con = null;
            Statement stm = null;
            
            boolean eliminar = false;
            String sql = "DELETE FROM lista_servicio WHERE id_empresa = "+idEmpresa + " and " + "id_servicio = "+idServicio;
            
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
    
    
    public List<lista_servicio> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM lista_servicio ORDER BY id_empresa";
            List<lista_servicio> list = new ArrayList<lista_servicio>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               lista_servicio ls = new lista_servicio();
               
               ls.setId_empresa(rs.getInt(1));
               ls.setId_servicio(rs.getInt(2));
               ls.setPrecio(rs.getDouble(3));
               
               list.add(ls);
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
