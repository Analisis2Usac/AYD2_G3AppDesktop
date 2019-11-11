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

    
    public static int registrar(usuarios.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = usuarios.Sentencias.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getEmail());
                ps.setString(2, uc.getPassword());
                ps.setString(3, uc.getDpi());
                ps.setString(4, uc.getNombre());
                ps.setString(5, uc.getApellido());
                ps.setString(6, uc.getDireccion());
                ps.setString(7, uc.getTelefono());
                ps.setInt(8, uc.getZona());
                ps.setDouble(9, uc.getLatitud());
                ps.setDouble(10, uc.getLongitud());
                ps.setInt(11, uc.getIdmunicipio());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static int actualizar(usuarios.Sentencias uc) {
        int rsu = 0;
        int codigo = 0;
        String sql = usuarios.Sentencias.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
                ps.setString(1, uc.getPassword());
                ps.setString(2, uc.getDpi());
                ps.setString(3, uc.getNombre());
                ps.setString(4, uc.getApellido());
                ps.setString(5, uc.getDireccion());
                ps.setString(6, uc.getTelefono());
                ps.setInt(7, uc.getZona());
                ps.setDouble(8, uc.getLatitud());
                ps.setDouble(9, uc.getLongitud());
                ps.setInt(10, uc.getIdmunicipio());
                ps.setString(11, uc.getEmail());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
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
                    + "id_municipio LIKE'" + busca + "%') "
                    + "ORDER BY email";
        }
        String datos[] = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                //datos[0] = rs.getString("dpi");
                String dpi =  (rs.getString("dpi")== null) ? "vacio" : rs.getString("dpi");
                datos[0] = dpi;
                
                datos[1] = rs.getString("email");
                
                //datos[2] = rs.getString("nombre");
                String nombre =  (rs.getString("nombre")== null) ? "vacio" : rs.getString("nombre");
                datos[2] = nombre;
                
                //datos[3] = rs.getString("apellido");
                String apellido =  (rs.getString("apellido")== null) ? "vacio" : rs.getString("apellido");
                datos[3] = apellido;
                
                //datos[4] = rs.getString("direccion");
                String dir =  (rs.getString("direccion")== null) ? "vacio" : rs.getString("direccion");
                datos[4] = dir;
                
                //datos[5] = rs.getString("telefono");
                String telefono =  (rs.getString("telefono")== null) ? "vacio" : rs.getString("telefono");
                datos[5] = telefono;
                
                datos[6] = Integer.toString(rs.getInt("zona"));
                datos[7] = Double.toString(rs.getDouble("latitud"));
                datos[8] = Double.toString(rs.getDouble("longitud"));
                datos[9] = Double.toString(rs.getInt("id_municipio"));

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
        String SQL = "SELECT MAX(email) FROM usuario";

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
