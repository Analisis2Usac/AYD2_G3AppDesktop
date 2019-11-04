/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipios;

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

    public static int registrar(municipios.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = municipios.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, uc.getNombre());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(municipios.Sentencias uc) {
        int rsu = 0;
        String sql = municipios.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(2, uc.getIdmunicipio());
            ps.setString(1, uc.getNombre());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = municipios.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) municipios.municipio.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = municipios.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM municipio WHERE (id_municipio LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%') "
                    + "ORDER BY id_municipio";
        }
        String datos[] = new String[2];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = Integer.toString(rs.getInt("id_municipio"));
                datos[1] = rs.getString("nombre");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static String nombreMunicipio(int id){
        
         String nombre = "";
         String sql = "SELECT * FROM municipio where id_municipio = "+id;
         
        try {

            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                nombre = rs.getString("nombre");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nombre;
        
    }
    
    
    public static int idMunicipio(String nombre){
        
         int id = 0;
         String sql = "SELECT * FROM municipio where nombre = "+"'"+nombre+"'";
         
        try {

            Statement st =  cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                id = rs.getInt("id_empresa");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
        
    }
    
    
    public static ArrayList<municipios.Listar> obtener(){
        
        ArrayList<municipios.Listar> listado = new ArrayList<>();
        
        try {
            String sql = municipios.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                municipios.Listar mun = new municipios.Listar(rs.getInt(1),rs.getString(2));
                listado.add(mun);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(categorias.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
    }
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_municipio) FROM municipio";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
}
