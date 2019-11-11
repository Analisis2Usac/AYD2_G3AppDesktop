/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import videos.video;

/**
 *
 * @author luismiguel
 */
public class Opciones {
    
    
     static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    
      public static int registrar(empleados.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = empleados.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, uc.getIdEmpresa());
            ps.setString(3, uc.getEmail());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(empleados.Sentencias uc) {
        int rsu = 0;
        String sql = empleados.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setInt(1,uc.getIdEmpresa());
            ps.setString(2, uc.getEmail());
            ps.setInt(3,uc.getIdEmpeado());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = empleados.Sentencias.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) empleados.VEmpleado.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = empleados.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM trabajador WHERE (id_empleado LIKE'" + busca + "%' OR "
                    + "id_empresa LIKE'" + busca + "%') "
                    + "ORDER BY id_empleado";
        }
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.toString(rs.getInt("id_empleado"));
                datos[1] = Integer.toString(rs.getInt("id_empresa"));
                datos[2] = rs.getString("email");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<trabajador> obtener(){
        
        ArrayList<trabajador> listado = new ArrayList<>();
        
        try {
            String sql = empleados.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                trabajador tra = new trabajador(rs.getInt(1),rs.getInt(2),rs.getString(3));
                listado.add(tra);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(empleados.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_empleado) FROM trabajador";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
