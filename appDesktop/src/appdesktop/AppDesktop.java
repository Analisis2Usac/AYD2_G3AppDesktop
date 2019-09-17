/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdesktop;

import controlador.controlCategoria;
import controlador.controlMunicipio;
import java.util.List;
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
    /*    System.out.println("Empezar el desarrollo");
        
        System.out.println("Ingresar Municipio");
        controlMunicipio muni = new controlMunicipio();
        controlCategoria cat = new controlCategoria();
        
        //muni.registrar("Honduras");
        
        List<municipio> listaM = muni.obtener();
        
        for(municipio item:listaM){
            System.out.println("Este esto esta en la base de datos "+item.getNombre());
        }
        
        cat.registrar("Enfermeria");
        
         List<categoria> listaC = cat.obtener();
        
        for(categoria item:listaC){
            System.out.println("Este esto esta en la base de datos "+item.getNombre());
        }
        
        */
    
    login log = new login();
    log.setVisible(true);
    
        
        
        
        
        
        
        
        
    }
    
}
