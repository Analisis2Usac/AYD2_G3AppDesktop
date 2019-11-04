/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String sql = contratos.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) contratos.VContrato.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = contratos.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM detalle_contrato WHERE (id_contrato LIKE'" + busca + "%' OR "
                    + "email LIKE'" + busca + "%') "
                    + "ORDER BY id_contrato";
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                datos[0] = Integer.toString(rs.getInt("id_contrato"));
                datos[1] = rs.getString("fecha");
                datos[2] = Integer.toString(rs.getInt("id_empresa"));
                datos[3] = Integer.toString(rs.getInt("id_servicio"));
                datos[4] = Integer.toString(rs.getInt("id_pago"));
                datos[5] = rs.getString("email");
                
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_contrato) FROM detalle_contrato";

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
