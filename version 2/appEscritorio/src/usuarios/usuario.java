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
public class usuario {
    
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
    
    public usuario(String email,String nombre){
        this.email = email;
        this.nombre = nombre;
    }

    public usuario(String email, String password, String dpi, String nombre, String apellido, String direccion, String telefono, int zona, double latitud, double longitud, int idmunicipio) {
        this.email = email;
        this.password = password;
        this.dpi = dpi;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.zona = zona;
        this.latitud = latitud;
        this.longitud = longitud;
        this.idmunicipio = idmunicipio;
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
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
    
    
}
