/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author luismiguel
 */
public class servicio {
   
    private int id;
    private String nombre;
    private int id_categoria;

    public servicio() {
        
       this.id = 0;
       this.nombre = null;
       this.id_categoria = 0;
    }

    public servicio(int id, String nombre, int id_categoria) {
        this.id = id;
        this.nombre = nombre;
        this.id_categoria = id_categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
