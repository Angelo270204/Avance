package modelo;

/**
 * Clase que representa un proveedor en el sistema.
 */
public class Proveedor {
    
    private int idProveedor;
    private String nombre;
    private String ruc;
    private String correo;
    private String celular;
    private String direccion;
    private String pais;

    /**
     * Constructor vacío de la clase Proveedor.
     */
    public Proveedor() {
    }

    /**
     * Constructor de la clase Proveedor con parámetros.
     *
     * @param idProveedor  El identificador único del proveedor.
     * @param nombre       El nombre del proveedor.
     * @param ruc          El RUC (Registro Único de Contribuyentes) del proveedor.
     * @param correo       El correo electrónico del proveedor.
     * @param celular      El número de celular del proveedor.
     * @param direccion    La dirección del proveedor.
     * @param pais        El país del proveedor.
     */
    public Proveedor(int idProveedor, String nombre, String ruc, String correo, String celular, String direccion, String pais) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.ruc = ruc;
        this.correo = correo;
        this.celular = celular;
        this.direccion = direccion;
        this.pais = pais;
    }

    /**
     * Obtiene el identificador del proveedor.
     *
     * @return El identificador del proveedor.
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * Establece el identificador del proveedor.
     *
     * @param idProveedor El nuevo identificador del proveedor.
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return El nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre El nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el RUC del proveedor.
     *
     * @return El RUC del proveedor.
     */
    public String getRuc() {
        return ruc;
    }

    /**
     * Establece el RUC del proveedor.
     *
     * @param ruc El nuevo RUC del proveedor.
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     * Obtiene el correo electrónico del proveedor.
     *
     * @return El correo del proveedor.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del proveedor.
     *
     * @param correo El nuevo correo del proveedor.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene el número de celular del proveedor.
     *
     * @return El celular del proveedor.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular del proveedor.
     *
     * @param celular El nuevo número de celular del proveedor.
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtiene la dirección del proveedor.
     *
     * @return La dirección del proveedor.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del proveedor.
     *
     * @param direccion La nueva dirección del proveedor.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el país del proveedor.
     *
     * @return El país del proveedor.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el país del proveedor.
     *
     * @param pais El nuevo país del proveedor.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}
