package modelo;

/**
 * Clase que representa un rol en el sistema.
 */
public class Rol {
    private int id_tipo; // Identificador del tipo de rol
    private String nombre_rol; // Nombre del rol

    /**
     * Constructor vacío de la clase Rol.
     */
    public Rol() {
    }

    /**
     * Constructor de la clase Rol con parámetros.
     *
     * @param id_tipo    El identificador del tipo de rol.
     * @param nombre_rol El nombre del rol.
     */
    public Rol(int id_tipo, String nombre_rol) {
        this.id_tipo = id_tipo;
        this.nombre_rol = nombre_rol;
    }

    /**
     * Obtiene el identificador del tipo de rol.
     *
     * @return El identificador del tipo de rol.
     */
    public int getId_tipo() {
        return id_tipo;
    }

    /**
     * Establece el identificador del tipo de rol.
     *
     * @param id_tipo El nuevo identificador del tipo de rol.
     */
    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombre_rol() {
        return nombre_rol;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombre_rol El nuevo nombre del rol.
     */
    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

}

