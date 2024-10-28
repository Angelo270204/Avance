
package modelo;

/**
 * Clase que representa una categoría de productos en el sistema.
 */
public class Categoria {
    
    // Identificador único de la categoría.
    private int idCategoria;
    
    // Nombre de la categoría.
    private String nombreCategoria;
    
    // Descripción de la categoría.
    private String descripcion;

    /**
     * Constructor vacío de la clase Categoria.
     */
    public Categoria() {
    }

    /**
     * Constructor de la clase Categoria con parámetros.
     *
     * @param idCategoria      El identificador único de la categoría.
     * @param nombreCategoria  El nombre de la categoría.
     * @param descripcion      La descripción de la categoría.
     */
    public Categoria(int idCategoria, String nombreCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el identificador de la categoría.
     *
     * @return El identificador de la categoría.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el identificador de la categoría.
     *
     * @param idCategoria El nuevo identificador de la categoría.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el nombre de la categoría.
     *
     * @return El nombre de la categoría.
     */
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    /**
     * Establece el nombre de la categoría.
     *
     * @param nombreCategoria El nuevo nombre de la categoría.
     */
    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * Obtiene la descripción de la categoría.
     *
     * @return La descripción de la categoría.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la categoría.
     *
     * @param descripcion La nueva descripción de la categoría.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

