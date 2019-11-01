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
public class calificacion {
    
    
    private int idCalificacion;
    private int calificacion;
    private int idContrato;
    
    public calificacion(){
        this.idCalificacion = 0;
        this.calificacion = 0;
        this.idContrato = 0;
    }

    public calificacion(int idCalificacion, int calificacion, int idContrato) {
        this.idCalificacion = idCalificacion;
        this.calificacion = calificacion;
        this.idContrato = idContrato;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }
    
    
    
    
    
            
    
    
    
    
}
