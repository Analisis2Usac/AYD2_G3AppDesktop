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
public class detalleContrato {
    
    private int idContrato;
    private String fecha;
    private int idEmpresa;
    private int idServicio;
    private int pago;
    private String email;
    
    
    public detalleContrato(){
        this.idContrato = 0;
        this.fecha = "";
        this.idEmpresa = 0;
        this.idServicio = 0;
        this.pago = 0;
        this.email = "";
    }

    public detalleContrato(int idContrato, String fecha, int idEmpresa, int idServicio, int pago, String email) {
        this.idContrato = idContrato;
        this.fecha = fecha;
        this.idEmpresa = idEmpresa;
        this.idServicio = idServicio;
        this.pago = pago;
        this.email = email;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
   
    
    
    
    
    
    
    
}
