/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados;

/**
 *
 * @author luismiguel
 */
public class trabajador {
    
    private int idEmpeado;
    private int idEmpresa;
    private String email;

    public trabajador(int idEmpeado, int idEmpresa, String email) {
        this.idEmpeado = idEmpeado;
        this.idEmpresa = idEmpresa;
        this.email = email;
    }

    public int getIdEmpeado() {
        return idEmpeado;
    }

    public void setIdEmpeado(int idEmpeado) {
        this.idEmpeado = idEmpeado;
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
    
    
    @Override
    public String toString(){
        return Integer.toString(this.idEmpeado);
    }
    
    
    
}
