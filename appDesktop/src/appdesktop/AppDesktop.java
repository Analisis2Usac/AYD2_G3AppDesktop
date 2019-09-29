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
        
    try{
        //UIManager.setLookAndFeel("com.jtattoon.plaf.acryl.AcrylLookAndFeel");

        //UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
        UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
        
    }catch(Exception e){
            
    }
        
        
    login log = new login();
    log.setVisible(true);
    log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        
        
        
        
        
        
        
        
    }
    
}
