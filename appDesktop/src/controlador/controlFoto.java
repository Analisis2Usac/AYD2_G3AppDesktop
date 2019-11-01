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
import servicios.conexion;

/**
 *
 * @author luismiguel
 */
public class controlFoto {
    
    
    public boolean registrar(String ruta,int idEmpleado){
        boolean registrar = false;
        Connection con = null;
        int id = 0;
        
        try{
            con = conexion.conectar();
            
            CallableStatement proc = con.prepareCall(" CALL fotoAddOrEdit (?,?,?)");

            proc.setInt("_id_foto", id);
            proc.setString("_ruta", ruta);
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
                
            CallableStatement proc = con.prepareCall(" CALL fotoAddOrEdit (?,?,?)");

            proc.setInt("_id_foto", id);
            proc.setString("_ruta", ruta);
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
            String sql = "DELETE FROM foto WHERE id_foto = "+id;
            
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
    
    
    public List<foto> obtener() {
        
        
            Connection con = null;
            Statement stm = null;
            ResultSet rs = null;
            
            String sql = "SELECT * FROM foto ORDER BY id_foto";
            List<foto> list = new ArrayList<foto>();
            
            
            try{
            
            con = conexion.conectar();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){

               foto f = new foto();
               f.setIdFoto(rs.getInt(1));
               f.setRuta(rs.getString(2));
               f.setIdEmpleado(rs.getInt(3));
               
               list.add(f);
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
