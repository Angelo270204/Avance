
package modelo;

import java.util.Date;

public class Usuario {
    private int idUsuario;
    private Empleado empleado;
    private String username;
    private String password;
    private Rol rol;
    private Date fechaUltimoAcceso;

    public Usuario() {
    }

    public Usuario(int idUsuario, Empleado empleado, String username, String password, Rol rol, Date fechaUltimoAcceso) {
        this.idUsuario = idUsuario;
        this.empleado = empleado;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

 
}
