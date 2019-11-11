/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author luismiguel
 */
public class Listar {
    
    private int idServicio;
    private String nombre;
    private int idCategoria;
    
    public Listar(int idServicio,String nombre){
        this.idServicio=idServicio;
        this.nombre = nombre;
    }
   
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    public String toString(){
        return this.nombre;
    }
}
