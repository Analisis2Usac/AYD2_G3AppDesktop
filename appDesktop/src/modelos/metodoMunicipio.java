/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.List;

/**
 *
 * @author luismiguel
 */
public interface metodoMunicipio {
    
    public boolean registrar(municipio muni);
    public boolean actualizar(municipio muni);
    public boolean eliminar(municipio muni);
    public List<municipio> obtener();
    
}
