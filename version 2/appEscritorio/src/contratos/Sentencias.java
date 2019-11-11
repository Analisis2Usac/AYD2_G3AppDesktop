/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contratos;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    
     public static String REGISTRAR = "INSERT INTO detalle_contrato(id_contrato,fecha,id_empresa,id_servicio,id_pago,email) "
            + "VALUES(?,?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE detalle_contrato SET "
            + "fecha=? "
            + "WHERE id_contrato=? ";
    
    public  static String LISTAR = "SELECT * FROM detalle_contrato ORDER BY id_contrato";
    public static String ELIMINAR = "DELETE FROM detalle_contrato WHERE id_contrato =? ";
    
    private int id_contrato;
    private String fecha;
    private int id_empresa;
    private int id_servicio;
    private int id_pago;
    private String email;

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
    
    
}
