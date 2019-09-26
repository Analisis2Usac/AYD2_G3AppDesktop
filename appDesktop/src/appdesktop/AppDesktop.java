/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import controlador.controlCategoria;
import controlador.controlMunicipio;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.UIManager;
import modelos.categoria;
import modelos.municipio;
import vista.login;

/**
 *
 * @author luismiguel
 */
public class AppDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Empezar el desarrollo");
        
     //   System.out.println("Ingresar Municipio");
     //   controlMunicipio muni = new controlMunicipio();
     //   controlCategoria cat = new controlCategoria();
        
        //muni.registrar("Honduras");
        
     //   List<municipio> listaM = muni.obtener();
        
     //   for(municipio item:listaM){
     //       System.out.println("Este esto esta en la base de datos "+item.getNombre());
     //   }
        
       // cat.registrar("Enfermeria");
        
      //   List<categoria> listaC = cat.obtener();
        
      //  for(categoria item:listaC){
      //      System.out.println("Este esto esta en la base de datos "+item.getNombre());
      //  }
        
       
    
    try{
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

    }catch(Exception e){
            
    }
        
        
        
    login log = new login();
    log.setVisible(true);
    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
        
        
        
        
        
        
        
    }
    
}
