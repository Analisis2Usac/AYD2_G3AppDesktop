/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas;

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
            JOptionPane.showMessageDialog(null,ex);
        }
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
                
                //datos[2] = rs.getString("nombre");
                String nombre =  (rs.getString("nombre")== null) ? "vacio" : rs.getString("nombre");
                datos[2] = nombre;
                
                //datos[3] = rs.getString("direccion");
                String dir =  (rs.getString("direccion")== null) ? "vacio" : rs.getString("direccion");
                datos[3] = dir;
                
                //datos[4] = rs.getString("telefono");
                String tel =  (rs.getString("telefono")== null) ? "vacio" : rs.getString("telefono");
                datos[4] = tel;
                
                datos[5] = Integer.toString(rs.getInt("zona"));
                datos[6] = Double.toString(rs.getDouble("latitud"));
                datos[7] = Double.toString(rs.getDouble("longitud"));
                datos[8] = Integer.toString(rs.getInt("id_municipio"));
                
                //datos[9] = rs.getString("email");
                String email =  (rs.getString("email")== null) ? "vacio" : rs.getString("email");
                datos[9] = email;
                
                //datos[10] = rs.getString("password");
                String pass =  (rs.getString("password")== null) ? "vacio" : rs.getString("password");
                datos[10] = pass;
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String getNombre(int id){
        String nombre="";
         try {
             String sql = "SELECT nombre FROM empresa where id_empresa = "+id;
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 nombre= rs.getString(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return nombre;
    }
    
    public static int getId(String nombre){
        int id=0;
         try {
             String sql = "SELECT* FROM empresa where nombre = "+"'"+nombre+"'";
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while(rs.next()){
                 id= rs.getInt(1);
             }
         } catch (SQLException ex) {
             Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
         }
         return id;
    }
    
    public static ArrayList<empresa> obtener(){
        
        ArrayList<empresa> listado = new ArrayList<>();
        
        try {
            String sql = Empresas.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                empresa emp = new empresa(rs.getInt(1),rs.getString(3));
                listado.add(emp);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empresas.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
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
