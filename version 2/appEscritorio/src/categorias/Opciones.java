/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categorias;

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

    public static int registrar(categorias.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = categorias.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setString(2, uc.getNombre());
            ps.setString(3, uc.getRuta());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }

    public static int actualizar(categorias.Sentencias uc) {
        int rsu = 0;
        String sql = categorias.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            
            ps.setString(1, uc.getNombre());
            ps.setString(2, uc.getRuta());
            ps.setInt(3, uc.getIdCategoria());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
        }
        System.out.println(sql);
        return rsu;
    }
    
    
    public static int eliminar(int id) {
        int rsu = 0;
        String sql = categorias.Sentencias.ELIMINAR;

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
        DefaultTableModel modelo = (DefaultTableModel) categorias.categoria.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = categorias.Sentencias.LISTAR;
        } else {
            sql = "SELECT * FROM categoria WHERE (id_categoria LIKE'" + busca + "%' OR "
                    + "nombre LIKE'" + busca + "%') "
                    + "ORDER BY id_categoria";
        }
        String datos[] = new String[3];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                datos[0] = Integer.toString(rs.getInt("id_categoria"));
                //datos[1] = rs.getString("nombre");
                //datos[2] = rs.getString("ruta");
                
                String nombre =  (rs.getString("nombre")== null) ? "vacio" : rs.getString("nombre");
                datos[1] = nombre;
                String ruta = (rs.getString("ruta")== null) ? "vacio" : rs.getString("ruta");
                datos[2] = ruta;
                
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(municipios.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    
    
    
    public static ArrayList<Listar> obtener(){
        
        ArrayList<Listar> listado = new ArrayList<>();
        
        try {
            String sql = categorias.Sentencias.LISTAR;
            
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                categorias.Listar cat = new categorias.Listar(rs.getInt(1),rs.getString(2),rs.getString(3));
                listado.add(cat);                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
        
    }
    
  public static String obtenerName(int id){
        
      String sql = "SELECT * FROM categoria  where id_categoria = "+id;
      String nombre = "";
      try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                nombre = rs.getString(2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return nombre;
      
  }
  
  
  public static int obtenerId(String nombre){
      
      String sql = "SELECT * FROM categoria where nombre = " +"\'"+nombre +"'";
      int id = 0;
      
      try {
              
            Statement st = cn.createStatement();
            ResultSet rs  =  st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
      
      return id;
  }
    
    
    public static int extraerID() {
        int c = 0;
        String SQL = "SELECT MAX(id_categoria) FROM categoria";

        try {
             Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                c = rs.getInt(1);
            }
                      
        } catch (SQLException ex) {
            Logger.getLogger(categorias.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public static void iniciarTransaccion(){
        try {
            cn.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(categorias.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void finalizarTransaccion(){
        try {
            cn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(categorias.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void cancelarTransaccion(){
        try {
            cn.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(categorias.Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    
    
    
    
    
}
