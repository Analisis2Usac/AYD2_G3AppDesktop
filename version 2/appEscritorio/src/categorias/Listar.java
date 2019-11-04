/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package categorias;

/**
 *
 * @author luismiguel
 */
public class Listar {
    
    private int idCategoria;
    private String nombre;
    private String ruta;

    public Listar(int idCategoria, String nombre, String ruta) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.ruta = ruta;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    

   
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
