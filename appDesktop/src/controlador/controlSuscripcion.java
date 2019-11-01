/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelos.documento;
import modelos.suscripcion;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlSuscripcion {
    
    
     public boolean registrar(int total,String finicio,String ffin,int limiteS,int idEmpresa){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL subscriptionAddOrEdit (?,?,?)");

            proc.setInt("_id_suscription",id);
            proc.setInt("_total",total);
            proc.setString("_fecha_inicio",finicio);
            proc.setString("_fecha_final", ffin);
            proc.setInt("_limite_servicios",limiteS);
            proc.setInt("_id_empresa", idEmpresa);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,int total,String finicio,String ffin,int limiteS,int idEmpresa) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
            CallableStatement proc = con.prepareCall(" CALL subscriptionAddOrEdit (?,?,?)");

            proc.setInt("_id_suscription",id);
            proc.setInt("_total",total);
            proc.setString("_fecha_inicio",finicio);
            proc.setString("_fecha_final", ffin);
            proc.setInt("_limite_servicios",limiteS);
            proc.setInt("_id_empresa", idEmpresa);
            
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
            String sql = "DELETE FROM suscripcion WHERE id_suscripcion = "+id;
            
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
    
    
    public List<suscripcion> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM suscripcion ORDER BY id_suscripcion";
            List<suscripcion> list = new ArrayList<suscripcion>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               suscripcion s = new suscripcion();
               s.setId(rs.getInt(1));
               s.setTotal(rs.getInt(2));
               s.setInicioFecha(rs.getString(3));
               s.setFinFecha(rs.getString(4));
               s.setLimiteServicio(rs.getInt(5));
               s.setIdEmpresa(rs.getInt(6));
               list.add(s);
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
