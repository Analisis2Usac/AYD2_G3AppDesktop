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
public class Sentencias {
    
     public static String ACTUALIZAR = "UPDATE comentario SET "
            + "comentario=? "
            + "WHERE id_comentario=?";
    
    public  static String LISTAR = "SELECT * FROM comentario ORDER BY id_comentario";
    public static String ELIMINAR = "DELETE FROM comentario WHERE id_comentario= ?";
    
    private int idComentario;
    private String comentario;
    private int id_contrato;

    public static String getLISTAR() {
        return LISTAR;
    }

    public static void setLISTAR(String LISTAR) {
        Sentencias.LISTAR = LISTAR;
    }

    public static String getELIMINAR() {
        return ELIMINAR;
    }

    public static void setELIMINAR(String ELIMINAR) {
        Sentencias.ELIMINAR = ELIMINAR;
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
