/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formapago;

import Empresas.empresa;
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

/**
 *
 * @author luismiguel
 */
public class Opciones {
    
    static ConexionBD cc = new ConexionBD();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;

    public static int registrar(formapago.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = formapago.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, uc.getForma());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(formapago.Sentencias uc) {
        int rsu = 0;
        String sql = formapago.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, uc.getForma());
            ps.setInt(2, uc.getIdPago());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = formapago.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) formapago.VFPago.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = formapago.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM forma_pago WHERE (id_pago LIKE'" + busca + "%' OR "
                    + "forma LIKE'" + busca + "%') "
                    + "ORDER BY id_pago";
        }
        String datos[] = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.toString(rs.getInt("id_pago"));
                datos[1] = rs.getString("forma");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(formapago.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<fpago> obtener(){
        
        ArrayList<fpago> listado = new ArrayList<>();
        
        try {
            String sql = formapago.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                fpago fp = new fpago(rs.getInt(1),rs.getString(2));
                listado.add(fp);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
    }
    
    public static String getNombre(int id){
        String nombre="";
         try {
             String sql = "SELECT forma FROM forma_pago where id_pago = "+id;
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 nombre= rs.getString(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return nombre;
    }
    
    
    
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_pago) FROM forma_pago";

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
