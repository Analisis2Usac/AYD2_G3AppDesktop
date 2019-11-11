/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suscripciones;

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
    
    
      public static int registrar(suscripciones.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = suscripciones.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, uc.getTotal());
            ps.setString(3, uc.getFechaInicio());
            ps.setString(4, uc.getFechaFin());
            ps.setInt(5, uc.getLimite());
            ps.setInt(6, uc.getIdEmpresa());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(suscripciones.Sentencias uc) {
        int rsu = 0;
        String sql = suscripciones.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setInt(1,uc.getTotal());
            ps.setString(2, uc.getFechaInicio());
            ps.setString(3, uc.getFechaFin());
            ps.setInt(4, uc.getLimite());
            ps.setInt(5, uc.getIdEmpresa());
            ps.setInt(6, uc.getSuscripcion());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = suscripciones.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) suscripciones.VSuscripcion.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = suscripciones.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM suscripcion WHERE (id_suscripcion LIKE'" + busca + "%' OR "
                    + "total LIKE'" + busca + "%') "
                    + "ORDER BY id_suscripcion";
        }
        String datos[] = new String[6];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.toString(rs.getInt("id_suscripcion"));
                datos[1] = rs.getString("fecha_inicio");
                datos[2] = rs.getString("fecha_final");
                datos[3] = Integer.toString(rs.getInt("limite_servicios"));
                datos[4] = Integer.toString(rs.getInt("id_empresa"));
                datos[5] = Integer.toString(rs.getInt("total"));
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_suscripcion) FROM suscripcion";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(servicios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(servicios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(servicios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(servicios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
