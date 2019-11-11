/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM video ORDER BY id_video";       
    public static String ELIMINAR = "DELETE FROM video WHERE id_video=? ";
    public static String ACTUALIZAR = "UPDATE video SET "
            + "id_empleado=? ,"
            + "ruta_video=? "
            + "WHERE id_video=?";
    
    
    private int idVideo;
    private int idEmpleado;
    private String ruta;

    public void setidVideo(int idVideo) {
        this.idVideo = idVideo;
    }

    public int getidVideo() {
        return idVideo;
    }

    public void setidEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getidEmpleado() {
        return idEmpleado;
    }

    public void setruta(String ruta) {
        this.ruta = ruta;
    }
    
    public String getruta() {
        return ruta;
    } 
    
    
    public static String getACTUALIZAR() {
        return ACTUALIZAR;
    }

    public static void setACTUALIZAR(String ACTUALIZAR) {
        Sentencias.ACTUALIZAR = ACTUALIZAR;
    }

    public static String getELIMINAR() {
        return ELIMINAR;
    }

    public static void setELIMINAR(String ELIMINAR) {
        Sentencias.ELIMINAR = ELIMINAR;
    }
    
    
    
    
    
    
}
