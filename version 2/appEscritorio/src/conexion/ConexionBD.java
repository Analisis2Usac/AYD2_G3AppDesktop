package conexion;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Sony
 */

public class ConexionBD {

    Connection conect = null;
    
      //  String password = "remote";
      //  String usuario = "remote";
      //  String url = "jdbc:mysql://35.222.148.179:3306/sis_db?user="+usuario+"&password="+password;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //conect = DriverManager.getConnection("jdbc:mysql://35.222.148.179:3306/botanasplebes", "remote", "remote"); 
            //conect = DriverManager.getConnection("jdbc:mysql://34.68.85.90:3306/sis_db", "remote", "remote");
            conect = DriverManager.getConnection("jdbc:mysql://mysql-4291-0.cloudclusters.net:10017/sis_db", "root_ayd2", "ayd2_g3");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }   
//    
//     public Connection Desconectar() {
//        try {
//            conect.close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
//        }
//        return conect;
//    }   
}
