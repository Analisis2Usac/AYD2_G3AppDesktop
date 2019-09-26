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
public class lista_servicio {
    
    private int id_empresa;
    private int id_servicio;
    private double precio;

    public lista_servicio() {
        this.id_empresa = 0;
        this.id_servicio = 0;
        this.precio = 0;
        
    }

    public lista_servicio(int id_empresa, int id_servicio, double precio) {
        this.id_empresa = id_empresa;
        this.id_servicio = id_servicio;
        this.precio = precio;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    

    
}
