/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

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

    
    
    public static int eliminar(String correo) {
        int rsu = 0;
        String sql = usuarios.Sentencias.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, correo);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static void listar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) usuarios.VUsuario.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = usuarios.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM usuario WHERE (email LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%') "
                    + "ORDER BY email";
        }
        String datos[] = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                datos[0] = rs.getString("dpi");
                datos[1] = rs.getString("email");
                datos[2] = rs.getString("nombre");
                datos[3] = rs.getString("apellido");
                datos[4] = rs.getString("direccion");
                datos[5] = rs.getString("telefono");
                datos[6] = Integer.toString(rs.getInt("zona"));
                datos[7] = Double.toString(rs.getDouble("latitud"));
                datos[8] = Double.toString(rs.getDouble("longitud"));
                datos[9] = Double.toString(rs.getDouble("id_municipio"));

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<usuario> obtener(){
        
        ArrayList<usuario> listado = new ArrayList<>();
        
        try {
            String sql = usuarios.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                usuario emp = new usuario(rs.getString(1),rs.getString(4));
                listado.add(emp);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_servicio) FROM servicio";

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
