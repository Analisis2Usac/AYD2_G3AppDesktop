/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luismiguel
 */
public class conexion {
    
   public static Connection con = null;
   
    public static Connection conectar(){        
        //String password = "mago";
        //String usuario = "mago";
        //String url = "jdbc:mysql://35.224.248.152:3306/sis_db?user="+usuario+"&password="+password;
        
        String password = "remote";
        String usuario = "remote";
        String url = "jdbc:mysql://35.222.148.179:3306/sis_db?user="+usuario+"&password="+password;
        
        try {
            con = (Connection) DriverManager.getConnection(url);
            if(con != null){
            System.out.println("Conectado");
        }
            
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar a la base de datos");
            ex.printStackTrace();
        }
        
        return con;
        
    }
    
    public static void cerrarCnx(){
        if(con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    
    
    

    
}
