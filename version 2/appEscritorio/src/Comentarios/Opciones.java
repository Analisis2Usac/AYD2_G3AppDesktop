/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comentarios;

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

//    public static int registrar(Empresas.Sentencias uc) {
//        int rsu = 0;
//        int codigo = 0;
//        String sql = Empresas.Sentencias.REGISTRAR;
//        try {
//            ps = cn.prepareStatement(sql);
//            ps.setInt(1, codigo);
//            ps.setInt(2, uc.getNit());
//            ps.setString(3, uc.getNombre());
//            ps.setString(4, uc.getDireccion());
//            ps.setString(5, uc.getTelefono());
//            ps.setInt(6, uc.getZona());
//            ps.setDouble(7, uc.getLatitud());
//            ps.setDouble(8, uc.getLongitud());
//            ps.setInt(9, uc.getId_municipio());
//            ps.setString(10, uc.getEmail());
//            ps.setString(11, uc.getPassword());
//            
//            rsu = ps.executeUpdate();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null,ex);
//        }
//        return rsu;
//    }
//
    public static int actualizar(Comentarios.Sentencias uc) {
        int rsu = 0;
        String sql = Comentarios.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, uc.getComentario());
            ps.setInt(2, uc.getIdComentario());

            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = Comentarios.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) Comentarios.VComentario.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = Comentarios.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM comentario WHERE (id_comentario LIKE'" + busca + "%' OR "
                    + "id_contrato LIKE'" + busca + "%') "
                    + "ORDER BY id_comentario";
        }
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                datos[0] = Integer.toString(rs.getInt("id_comentario"));
                datos[1] = rs.getString("comentario");
                datos[2] = Integer.toString(rs.getInt("id_contrato"));

                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Comentarios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
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
    
 
}
