/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suscripciones;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM suscripcion ORDER BY id_suscripcion";     
    public static String ELIMINAR = "DELETE FROM suscripcion WHERE id_suscripcion = ?";
    
    private int suscripcion;
    private int total;
    private String fechaInicio;
    private String fechaFin;
    private int limite;
    private int idEmpresa;

    public int getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(int suscripcion) {
        this.suscripcion = suscripcion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    
    
    
    
    
}
