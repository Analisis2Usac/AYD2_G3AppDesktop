/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos;

import categorias.Listar;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luismiguel
 */
public class Opciones {
    
    
     static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = videos.Sentencias.ELIMINAR;

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
    
    public static int actualizar(videos.Sentencias uc) {
        int rsu = 0;
        String sql = videos.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, uc.getidEmpleado());
            ps.setString(2, uc.getruta());
            ps.setInt(3, uc.getidVideo());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) videos.VVideo.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = videos.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM video WHERE (id_video LIKE'" + busca + "%' OR "
                    + "id_empleado LIKE'" + busca + "%') "
                    + "ORDER BY id_video";
        }
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.toString(rs.getInt("id_video"));
                datos[1] = rs.getString("ruta_video");
                datos[2] = Integer.toString(rs.getInt("id_empleado"));
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_video) FROM video";

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
