
package modelo;

public class Rol {
    private int idTipo;
    private String nombreRol;

    public Rol() {
    }

    public Rol(int idTipo, String nombreRol) {
        this.idTipo = idTipo;
        this.nombreRol = nombreRol;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    
    
    
}
