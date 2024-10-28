package modelo;

/**
 * Clase que representa el sexo en el sistema.
 */
public class Sexo {
    private int idSexo; // Identificador del sexo
    private String descripcion; // Descripción del sexo

    /**
     * Constructor vacío de la clase Sexo.
     */
    public Sexo() {
    }

    /**
     * Constructor de la clase Sexo con parámetros.
     *
     * @param idSexo    El identificador del sexo.
     * @param descripcion La descripción del sexo.
     */
    public Sexo(int idSexo, String descripcion) {
        this.idSexo = idSexo;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador del sexo.
     *
     * @return El identificador del sexo.
     */
    public int getIdSexo() {
        return idSexo;
    }

    /**
     * Establece el identificador del sexo.
     *
     * @param idSexo El nuevo identificador del sexo.
     */
    public void setIdSexo(int idSexo) {
        this.idSexo = idSexo;
    }

    /**
     * Obtiene la descripción del sexo.
     *
     * @return La descripción del sexo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del sexo.
     *
     * @param descripcion La nueva descripción del sexo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
