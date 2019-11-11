/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comentarios;

/**
 *
 * @author luismiguel
 */
public class comentario {
    
    private int idComentario;
    private String comentario;
    private int id_contrato;

    public comentario(int idComentario, String comentario, int id_contrato) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.id_contrato = id_contrato;
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

    public int getId_contrato() {
        return id_contrato;
    }

    public void setId_contrato(int id_contrato) {
        this.id_contrato = id_contrato;
    }
    
    
    
    
    
}
