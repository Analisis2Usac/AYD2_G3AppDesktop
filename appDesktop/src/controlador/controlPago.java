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
import modelos.pago;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlPago {
    
    
     public boolean registrar(String forma){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            CallableStatement proc = con.prepareCall(" CALL formaAddOrEdit (?,?)");
            proc.setInt("_id_pago", id);
            proc.setString("_forma", forma);
            proc.execute();
            
        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int id,String forma) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                CallableStatement proc = con.prepareCall(" CALL formaAddOrEdit (?,?) ");
                proc.setInt("_id_pago", id);
                proc.setString("_forma", forma);
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
            String sql = "DELETE FROM forma_pago WHERE id_pago = "+id;
            
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
    
    
    public List<pago> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM forma_pago ORDER BY id_pago";
            List<pago> listPago = new ArrayList<pago>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
               pago ca = new pago();
               ca.setIdpago(rs.getInt(1));
               ca.setForma(rs.getString(2));
               listPago.add(ca);
            }
            
            stm.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
                System.out.println("Error: no se puede listar municipios");
                ex.printStackTrace();
            
        }
        
            return listPago;
    }
    
    
    

    
    
}
