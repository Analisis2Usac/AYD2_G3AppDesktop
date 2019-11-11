/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formapago;

/**
 *
 * @author luismiguel
 */
public class fpago {
    
     private int idPago;
     private String forma;

  
    public fpago(int idPago, String forma) {
        this.idPago = idPago;
        this.forma = forma;
    }
    
      public int getIdPago() {
        return idPago;
    }
      
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }
     
     
    
    
     @Override
    public String toString(){
        return this.forma;
    }
    
}
