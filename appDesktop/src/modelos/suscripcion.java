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
public class suscripcion {
    
     private int id;
     private int total;
     private String inicioFecha;
     private String finFecha;
     private int limiteServicio;
     private int idEmpresa;
     
     
     public suscripcion(){
      this.id = 0;
      this.total = 0;
      this.inicioFecha = "";
      this.finFecha = "";
      this.limiteServicio = 0;
      this.idEmpresa = 0;
      
     }

    public suscripcion(int id, int total, String inicioFecha, String finFecha, int limiteServicio, int idEmpresa) {
        this.id = id;
        this.total = total;
        this.inicioFecha = inicioFecha;
        this.finFecha = finFecha;
        this.limiteServicio = limiteServicio;
        this.idEmpresa = idEmpresa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getInicioFecha() {
        return inicioFecha;
    }

    public void setInicioFecha(String inicioFecha) {
        this.inicioFecha = inicioFecha;
    }

    public String getFinFecha() {
        return finFecha;
    }

    public void setFinFecha(String finFecha) {
        this.finFecha = finFecha;
    }

    public int getLimiteServicio() {
        return limiteServicio;
    }

    public void setLimiteServicio(int limiteServicio) {
        this.limiteServicio = limiteServicio;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
}
