/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documento;

/**
 *
 * @author luismiguel
 */
public class documento {
    
    private int id_documento;
    private String documento;
    private int id_empleado;

    public documento(int id_documento, String documento, int id_empleado) {
        this.id_documento = id_documento;
        this.documento = documento;
        this.id_empleado = id_empleado;
    }

    public int getId_documento() {
        return id_documento;
    }

    public void setId_documento(int id_documento) {
        this.id_documento = id_documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }
    
    
    
}
