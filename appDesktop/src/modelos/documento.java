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
public class documento {
    
    private int idDocumento;
    private String documento;
    private int idEmpleado;
    
    public documento(){
        this.idDocumento = 0;
        this.documento = "";
        this.idEmpleado = 0;
    }

    public documento(int idDocumento, String documento, int idEmpleado) {
        this.idDocumento = idDocumento;
        this.documento = documento;
        this.idEmpleado = idEmpleado;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    
    
}
