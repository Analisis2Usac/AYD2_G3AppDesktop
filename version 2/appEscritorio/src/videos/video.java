/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package videos;

import empleados.*;

/**
 *
 * @author luismiguel
 */
public class video {
    
    private int idVideo;
    private int idEmpleado;
    private String ruta;

    public video(int idVideo, int idEmpleado, String ruta) {
        this.idVideo = idVideo;
        this.idEmpleado = idEmpleado;
        this.ruta = ruta;
    }

    public int idVideo() {
        return idVideo;
    }

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
    
    
    
    
}
