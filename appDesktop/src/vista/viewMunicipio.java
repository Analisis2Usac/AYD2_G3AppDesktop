/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;


import java.util.List;
import modelos.municipio;

/**
 *
 * @author luismiguel
 */
public class viewMunicipio {
    
    public void verMunicipio( municipio muni){
        System.out.println("Datos del municipio ");
    }
    
    public void verMunicipios( List<municipio> muni){
        for(municipio item : muni){
            System.out.println("Datos del cliente : " + item);
        }
        
        
    }
    
    
    
}
