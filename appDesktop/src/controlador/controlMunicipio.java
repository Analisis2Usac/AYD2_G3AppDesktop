/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import modelos.implementarMunicipio;
import modelos.metodoMunicipio;
import modelos.municipio;
import vista.viewMunicipio;

/**
 *
 * @author luismiguel
 */
public class controlMunicipio {
    
    private viewMunicipio vista = new viewMunicipio();
    
    public controlMunicipio(){
        
    }
    
    public void registrar(municipio muni){
        metodoMunicipio m = new implementarMunicipio();
        m.registrar(muni);
    }
    
    public void actualizar(municipio muni){
        metodoMunicipio m = new implementarMunicipio();
        m.actualizar(muni);
    }
    
    public void eliminar(municipio muni){
        metodoMunicipio m = new implementarMunicipio();
        m.eliminar(muni);
    }
    
    public void listarMunicipio(){
        List<municipio> muni = new ArrayList<municipio>();
        metodoMunicipio m = new implementarMunicipio();
        muni = m.obtener();
        vista.verMunicipios(muni);
        
        
    }
    
    
    
    
    
    
}
