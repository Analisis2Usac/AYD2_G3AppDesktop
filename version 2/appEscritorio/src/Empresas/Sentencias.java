/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresas;

/**
 *
 * @author luismiguel
 */
public class Sentencias {
    
    public  static String LISTAR = "SELECT * FROM empresa ORDER BY id_empresa";
           
    public static String REGISTRAR = "INSERT INTO empresa(id_empresa,nit,nombre,direccion,telefono,zona,latitud,longitud,id_municipio,email,password) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    public static String ACTUALIZAR = "UPDATE empresa SET "
            + "nit=? ,"
            + "nombre=? ,"
            + "direccion=? ,"
            + "telefono=? ,"
            + "zona=? ,"
            + "latitud=? ,"
            + "longitud=? ,"
            + "id_municipio=? ,"
            + "email=? ,"
            + "password=? "
            + "WHERE id_empresa=?";

    public static String ELIMINAR = "DELETE FROM empresa WHERE id_empresa = ?";
    
    
    private int idEmpresa;
    private int nit;
    private String nombre;
    private String direccion;
    private String telefono;
    private int zona;
    private double latitud;
    private double longitud;
    private int id_municipio;
    private String email;
    private String password;

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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

    
    
    
    
    
    
    
}
