/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipios;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM municipio ORDER BY id_municipio";
           
    public static String REGISTRAR = "INSERT INTO municipio(id_municipio,nombre) "
            + "VALUES(?,?)";

    public static String ACTUALIZAR = "UPDATE municipio SET "
            + "nombre=? "
            + "WHERE id_municipio=?";

    public static String ELIMINAR = "DELETE FROM municipio WHERE id_municipio = ?";

    
    
    private int idmunicipio;
    private String nombre;

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    

    
    
    
    
}
