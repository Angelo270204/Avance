package modelo;

/**
 * Clase que representa a un empleado en el sistema.
 */
public class Empleado {
    
    // Identificador único del empleado.
    private int idEmpleado;
    
    // Nombre del empleado.
    private String nombre;
    
    // Apellido del empleado.
    private String apellido;
    
    // Documento Nacional de Identidad del empleado.
    private String dni;
    
    // Edad del empleado.
    private int edad;
    
    // Sexo del empleado, representado como un objeto de la clase Sexo.
    private Sexo sexo;
    
    // Número de celular del empleado.
    private String celular;
    
    // Dirección del empleado.
    private String direccion;
    
    // Correo electrónico del empleado.
    private String correo;
    
    // Rol del empleado en el sistema, representado como un objeto de la clase Rol.
    private Rol rol;

    /**
     * Constructor vacío de la clase Empleado.
     */
    public Empleado() {
    }

    /**
     * Constructor de la clase Empleado con parámetros.
     *
     * @param idEmpleado  El identificador único del empleado.
     * @param nombre      El nombre del empleado.
     * @param apellido    El apellido del empleado.
     * @param dni         El DNI del empleado.
     * @param edad        La edad del empleado.
     * @param sexo        El sexo del empleado.
     * @param celular     El número de celular del empleado.
     * @param direccion   La dirección del empleado.
     * @param correo      El correo electrónico del empleado.
     * @param rol        El rol del empleado.
     */
    public Empleado(int idEmpleado, String nombre, String apellido, String dni, int edad, Sexo sexo, String celular, String direccion, String correo, Rol rol) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.sexo = sexo;
        this.celular = celular;
        this.direccion = direccion;
        this.correo = correo;
        this.rol = rol;
    }

    /**
     * Obtiene el identificador del empleado.
     *
     * @return El identificador del empleado.
     */
    public int getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * Establece el identificador del empleado.
     *
     * @param idEmpleado El nuevo identificador del empleado.
     */
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return El nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre El nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del empleado.
     *
     * @return El apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del empleado.
     *
     * @param apellido El nuevo apellido del empleado.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el DNI del empleado.
     *
     * @return El DNI del empleado.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del empleado.
     *
     * @param dni El nuevo DNI del empleado.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene la edad del empleado.
     *
     * @return La edad del empleado.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del empleado.
     *
     * @param edad La nueva edad del empleado.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el sexo del empleado.
     *
     * @return El objeto Sexo que representa el sexo del empleado.
     */
    public Sexo getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del empleado.
     *
     * @param sexo El nuevo objeto Sexo del empleado.
     */
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    /**
     * Obtiene el número de celular del empleado.
     *
     * @return El número de celular del empleado.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del empleado.
     *
     * @param celular El nuevo número de celular del empleado.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtiene la dirección del empleado.
     *
     * @return La dirección del empleado.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del empleado.
     *
     * @param direccion La nueva dirección del empleado.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el correo electrónico del empleado.
     *
     * @return El correo electrónico del empleado.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del empleado.
     *
     * @param correo El nuevo correo electrónico del empleado.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el rol del empleado.
     *
     * @return El objeto Rol que representa el rol del empleado.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol del empleado.
     *
     * @param rol El nuevo objeto Rol del empleado.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
