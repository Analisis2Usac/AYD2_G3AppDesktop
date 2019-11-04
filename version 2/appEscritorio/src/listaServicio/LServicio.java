/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaServicio;

/**
 *
 * @author luismiguel
 */
public class LServicio {
    
    private int idEmpresa;
    private int idServicio;
    private double precio;

    public LServicio(int idEmpresa, int idServicio, double precio) {
        this.idEmpresa = idEmpresa;
        this.idServicio = idServicio;
        this.precio = precio;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
    
    
    
    
    
    
}
