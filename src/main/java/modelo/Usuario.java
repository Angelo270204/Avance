package modelo;

import java.util.Date;

/**
 * Clase que representa un usuario en el sistema.
 */
public class Usuario {
    private int idUsuario; // Identificador del usuario
    private Empleado empleado; // Empleado asociado al usuario
    private String username; // Nombre de usuario
    private String password; // Contraseña del usuario
    private Rol rol; // Rol del usuario en el sistema
    private Date fechaUltimoAcceso; // Fecha del último acceso del usuario

    /**
     * Constructor vacío de la clase Usuario.
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario con parámetros.
     *
     * @param idUsuario         El identificador del usuario.
     * @param empleado          El empleado asociado al usuario.
     * @param username          El nombre de usuario.
     * @param password          La contraseña del usuario.
     * @param rol               El rol del usuario en el sistema.
     * @param fechaUltimoAcceso La fecha del último acceso del usuario.
     */
    public Usuario(int idUsuario, Empleado empleado, String username, String password, Rol rol, Date fechaUltimoAcceso) {
        this.idUsuario = idUsuario;
        this.empleado = empleado;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    /**
     * Obtiene el identificador del usuario.
     *
     * @return El identificador del usuario.
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el identificador del usuario.
     *
     * @param idUsuario El nuevo identificador del usuario.
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el empleado asociado al usuario.
     *
     * @return El empleado asociado al usuario.
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * Establece el empleado asociado al usuario.
     *
     * @param empleado El nuevo empleado asociado al usuario.
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * Obtiene el nombre de usuario.
     *
     * @return El nombre de usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param username El nuevo nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password La nueva contraseña del usuario.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el rol del usuario en el sistema.
     *
     * @return El rol del usuario.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol del usuario en el sistema.
     *
     * @param rol El nuevo rol del usuario.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }

    /**
     * Obtiene la fecha del último acceso del usuario.
     *
     * @return La fecha del último acceso del usuario.
     */
    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    /**
     * Establece la fecha del último acceso del usuario.
     *
     * @param fechaUltimoAcceso La nueva fecha del último acceso del usuario.
     */
    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }
}
