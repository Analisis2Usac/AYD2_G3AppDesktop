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
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM trabajador ORDER BY id_empleado";       
    public static String ELIMINAR = "DELETE FROM trabajador WHERE id_empleado=? ";
    
    
    private int idEmpeado;
    private int idEmpresa;
    private String email;

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
    
    
    
    
    
    
}
