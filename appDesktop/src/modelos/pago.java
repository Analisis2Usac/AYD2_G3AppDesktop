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
public class pago {
    
    private int idpago;
    private String forma;

    public pago() {
        
        this.idpago = 0;
        this.forma = null;
    }

    public pago(int idpago, String forma) {
        this.idpago = idpago;
        this.forma = forma;
    }

    public int getIdpago() {
        return idpago;
    }

    public void setIdpago(int idpago) {
        this.idpago = idpago;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    
    
    
    
    
    
}
