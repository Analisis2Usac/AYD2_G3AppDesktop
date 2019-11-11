/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fotos;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    
    public  static String LISTAR = "SELECT * FROM foto ORDER BY id_foto";       
    public static String ELIMINAR = "DELETE FROM foto WHERE id_foto=? ";
    
     public static String ACTUALIZAR = "UPDATE foto SET "
            + "id_empleado=? ,"
            + "ruta=? "
            + "WHERE id_foto=?";
    
    private int idFoto;
    private String ruta;
    private int idEmpleado;

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
    
    
    
    
    
    
}
