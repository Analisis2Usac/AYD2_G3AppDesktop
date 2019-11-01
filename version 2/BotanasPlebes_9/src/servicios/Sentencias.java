/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    
    public  static String LISTAR = "SELECT * FROM servicio ORDER BY id_servicio";
           
    public static String REGISTRAR = "INSERT INTO servicio(id_servicio,nombre_servicio,id_categoria) "
            + "VALUES(?,?,?)";

    public static String ACTUALIZAR = "UPDATE servicio SET "
            + "nombre_servicio=? ,"
            + "id_categoria=? "
            + "WHERE id_servicio=?";

    public static String ELIMINAR = "DELETE FROM servicio WHERE id_servicio = ?";
    
    
    private int idServicio;
    private String nombre;
    private int idCategoria;

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
    
}
