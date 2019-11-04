/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas;

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

    public static int registrar(Empresas.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = Empresas.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, uc.getNit());
            ps.setString(3, uc.getNombre());
            ps.setString(4, uc.getDireccion());
            ps.setString(5, uc.getTelefono());
            ps.setInt(6, uc.getZona());
            ps.setDouble(7, uc.getLatitud());
            ps.setDouble(8, uc.getLongitud());
            ps.setInt(9, uc.getId_municipio());
            ps.setString(10, uc.getEmail());
            ps.setString(11, uc.getPassword());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(Empresas.Sentencias uc) {
        int rsu = 0;
        String sql = Empresas.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setInt(11, uc.getIdEmpresa());
            ps.setInt(1, uc.getNit());
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getDireccion());
            ps.setString(4, uc.getTelefono());
            ps.setInt(5, uc.getZona());
            ps.setDouble(6, uc.getLatitud());
            ps.setDouble(7, uc.getLongitud());
            ps.setInt(8, uc.getId_municipio());
            ps.setString(9, uc.getEmail());
            ps.setString(10, uc.getPassword());

            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Empresas.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) Empresas.vEmpresa.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Empresas.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM empresa WHERE (id_empresa LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%') "
                    + "ORDER BY id_empresa";
        }
        String datos[] = new String[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                datos[0] = Integer.toString(rs.getInt("id_empresa"));
                datos[1] = Integer.toString(rs.getInt("nit"));
                datos[2] = rs.getString("nombre");
                datos[3] = rs.getString("direccion");
                datos[4] = rs.getString("telefono");
                datos[5] = Integer.toString(rs.getInt("zona"));
                datos[6] = Double.toString(rs.getDouble("latitud"));
                datos[7] = Double.toString(rs.getDouble("longitud"));
                datos[8] = Integer.toString(rs.getInt("id_municipio"));
                datos[9] = rs.getString("email");
                datos[10] = rs.getString("password");
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_empresa) FROM empresa";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
