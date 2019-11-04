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
public class Sentencias {
    
    
    public  static String LISTAR = "SELECT * FROM lista_servicio ORDER BY id_empresa";
           
    public static String REGISTRAR = "INSERT INTO lista_servicio(id_empresa,id_servicio,precio) "
            + "VALUES(?,?,?)";

    public static String ACTUALIZAR = "UPDATE lista_servicio SET "
            + "precio=? "
            + "WHERE id_empresa=? AND id_servicio=?";

    public static String ELIMINAR = "DELETE FROM lista_servicio WHERE id_empresa =? AND id_servicio =?";

    private int idEmpresa;
    private int idServicio;
    private double precio;

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
