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
import modelos.detalleContrato;
import modelos.lista_servicio;
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlDContrato {
    
    
     public boolean registrar(String fecha,int idEmpresa,int idServicio,int idPago,String email){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL detalleAddOrEdit (?,?,?,?,?,?)");

            proc.setInt("_id_contrato", id);
            proc.setString("_fecha", fecha);
            proc.setInt("_id_empresa",idEmpresa);
            proc.setInt("_id_servicio", idServicio);
            proc.setInt("_id_pago",idPago);
            proc.setString("_email", email);
            
            proc.execute();
            

        }catch(Exception e){
            System.err.println(e);
        }
        return registrar;
    }
    
    
     public boolean actualizar(int idContrato,String fecha,int idEmpresa,int idServicio,int idPago,String email) {
        
       
            Connection con = null;
            Statement stm = null;
            boolean actualizar = false;

            try{
                con = conexion.conectar();
                
           CallableStatement proc = con.prepareCall(" CALL detalleAddOrEdit (?,?,?,?,?,?)");

            proc.setInt("_id_contrato", idContrato);
            proc.setString("_fecha", fecha);
            proc.setInt("_id_empresa",idEmpresa);
            proc.setInt("_id_servicio", idServicio);
            proc.setInt("_id_pago",idPago);
            proc.setString("_email", email);
            
            proc.execute();
            
            actualizar = true;
                
        } catch (SQLException ex) {
                System.out.println("Error: Clase municipio, no se puede actualizar");
                ex.printStackTrace();
        }
        
        return actualizar;
        
    }
    
    public boolean eliminar(int idContrato) {
        
            Connection con = null;
            Statement stm = null;
            
            boolean eliminar = false;
            String sql = "DELETE FROM detalle_contrato WHERE id_contrato = "+idContrato;
            
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
    
    
    public List<detalleContrato> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM detalle_contrato ORDER BY id_contrato";
            List<detalleContrato> list = new ArrayList<detalleContrato>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               detalleContrato ls = new detalleContrato();
               
               ls.setIdContrato(rs.getInt(1));
               ls.setFecha(rs.getString(2));
               ls.setIdEmpresa(rs.getInt(3));
               ls.setIdServicio(rs.getInt(4));
               ls.setPago(rs.getInt(5));
               ls.setEmail(rs.getString(6));
               
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
