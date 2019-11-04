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
public class Sentencias {
    
     public  static String LISTAR = "SELECT * FROM forma_pago ORDER BY id_pago";
           
    public static String REGISTRAR = "INSERT INTO forma_pago(id_pago,forma) "
            + "VALUES(?,?)";

    public static String ACTUALIZAR = "UPDATE forma_pago SET "
            + "forma=? "
            + "WHERE id_pago=? ";

    public static String ELIMINAR = "DELETE FROM forma_pago WHERE id_pago =? ";
    
    private int idPago;
    private String forma;

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
    
    
    

    
}
