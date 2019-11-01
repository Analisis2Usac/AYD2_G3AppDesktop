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
public class video {
    
    private int idVideo;
    private String ruta;
    private int idEmpleado;
    
    public video(){
        this.idVideo = 0;
        this.ruta = "";
        this.idEmpleado = 0;
    }

    public video(int idVideo, String ruta, int idEmpleado) {
        this.idVideo = idVideo;
        this.ruta = ruta;
        this.idEmpleado = idEmpleado;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(int idVideo) {
        this.idVideo = idVideo;
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
