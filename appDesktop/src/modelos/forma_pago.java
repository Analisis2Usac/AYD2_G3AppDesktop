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
public class forma_pago {
    
    private int id_pago;
    private String forma;

    public forma_pago() {
        this.id_pago = 0;
        this.forma = null;
    }

    public forma_pago(int id_pago, String forma) {
        this.id_pago = id_pago;
        this.forma = forma;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
    
    
    
    
    
    
    
    
}
