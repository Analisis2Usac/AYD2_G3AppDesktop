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
public class comentario {
    
    private int idComentario;
    private String comentario;
    private int idContrato;
    
    public comentario(){
        this.idComentario = 0;
        this.comentario = "";
        this.idComentario = 0;
        
    }

    public comentario(int idComentario, String comentario, int idContrato) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.idContrato = idContrato;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }
    
    
    
}
