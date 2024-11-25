package modelo;

/**
 * Clase que representa un producto en el sistema.
 */
public class Producto {
    
    private int idProducto;
    private String nombre;
    private Categoria categoria;
    private String descripcion;
    private int cantidadStock;
    private double precio;

    /**
     * Constructor vacío de la clase Producto.
     */
    public Producto() {
    }

    /**
     * Constructor de la clase Producto con parámetros.
     *
     * @param idProducto     El identificador único del producto.
     * @param nombre         El nombre del producto.
     * @param categoria      La categoría a la que pertenece el producto.
     * @param descripcion    Una descripción del producto.
     * @param cantidadStock  La cantidad de producto disponible en stock.
     * @param precio         El precio del producto.
     */
    public Producto(int idProducto, String nombre, Categoria categoria, String descripcion, int cantidadStock, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.cantidadStock = cantidadStock;
        this.precio = precio;
    }

    /**
     * Obtiene la categoría del producto.
     *
     * @return La categoría del producto.
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría del producto.
     *
     * @param categoria La nueva categoría del producto.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtiene el identificador del producto.
     *
     * @return El identificador del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto.
     *
     * @param idProducto El nuevo identificador del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la cantidad de producto disponible en stock.
     *
     * @return La cantidad en stock del producto.
     */
    public int getCantidadStock() {
        return cantidadStock;
    }

    /**
     * Establece la cantidad de producto disponible en stock.
     *
     * @param cantidadStock La nueva cantidad en stock del producto.
     */
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return El precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio El nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
