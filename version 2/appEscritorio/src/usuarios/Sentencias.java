/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM usuario ORDER BY email";
           
    public static String REGISTRAR = "INSERT INTO usuario(email,contrasenia,dpi,nombre,apellido,direccion,telefono,zona,latitud,longitud,id_municipio) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE usuario SET "
            + "contrasenia=? ,"
            + "dpi=? ,"
            + "nombre=? ,"
            + "apellido=? ,"
            + "direccion=? ,"
            + "telefono=? ,"
            + "zona=? ,"
            + "latitud=? ,"
            + "longitud=? ,"
            + "id_municipio=? "
            + "WHERE email=?";

    public static String ELIMINAR = "DELETE FROM usuario WHERE email= ?";
    
    private String email;
    private String password;
    private String dpi;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private int zona;
    private double latitud;
    private double longitud;
    private int idmunicipio;

    public static String getLISTAR() {
        return LISTAR;
    }

    public static void setLISTAR(String LISTAR) {
        Sentencias.LISTAR = LISTAR;
    }

    public static String getREGISTRAR() {
        return REGISTRAR;
    }

    public static void setREGISTRAR(String REGISTRAR) {
        Sentencias.REGISTRAR = REGISTRAR;
    }

    public static String getACTUALIZAR() {
        return ACTUALIZAR;
    }

    public static void setACTUALIZAR(String ACTUALIZAR) {
        Sentencias.ACTUALIZAR = ACTUALIZAR;
    }

    public static String getELIMINAR() {
        return ELIMINAR;
    }

    public static void setELIMINAR(String ELIMINAR) {
        Sentencias.ELIMINAR = ELIMINAR;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getIdmunicipio() {
        return idmunicipio;
    }

    public void setIdmunicipio(int idmunicipio) {
        this.idmunicipio = idmunicipio;
    }
    
    
    
    
    
    
    
    
    
    
}
