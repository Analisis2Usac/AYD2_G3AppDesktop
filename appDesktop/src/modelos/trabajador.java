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
public class trabajador {
   
    private int idEmpleado;
    private int idEmpresa;
    private String email;

    public trabajador() {
        this.idEmpleado = 0;
        this.idEmpresa = 0;
        this.email = null;
        
    }

    public trabajador(int idEmpleado, int idEmpresa, String email) {
        this.idEmpleado = idEmpleado;
        this.idEmpresa = idEmpresa;
        this.email = email;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
   
}
