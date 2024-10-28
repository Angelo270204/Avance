package modelo;

import java.util.Date;

/**
 * Clase que representa una orden de compra en el sistema.
 */
public class OrdenCompra {
    
    private int idOrden;
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private double precioCompra;
    private Date fechaCompra;

    /**
     * Constructor vacío de la clase OrdenCompra.
     */
    public OrdenCompra() {
    }

    /**
     * Constructor de la clase OrdenCompra con parámetros.
     *
     * @param idOrden      El identificador único de la orden de compra.
     * @param idProducto   El identificador del producto asociado a la orden.
     * @param idProveedor  El identificador del proveedor de la orden.
     * @param cantidad     La cantidad de productos solicitados en la orden.
     * @param precioCompra El precio de compra del producto.
     * @param fechaCompra  La fecha en que se realizó la compra.
     */
    public OrdenCompra(int idOrden, int idProducto, int idProveedor, int cantidad, double precioCompra, Date fechaCompra) {
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obtiene el identificador de la orden de compra.
     *
     * @return El identificador de la orden de compra.
     */
    public int getIdOrden() {
        return idOrden;
    }

    /**
     * Establece el identificador de la orden de compra.
     *
     * @param idOrden El nuevo identificador de la orden de compra.
     */
    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    /**
     * Obtiene el identificador del producto asociado a la orden de compra.
     *
     * @return El identificador del producto.
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto asociado a la orden de compra.
     *
     * @param idProducto El nuevo identificador del producto.
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el identificador del proveedor de la orden de compra.
     *
     * @return El identificador del proveedor.
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * Establece el identificador del proveedor de la orden de compra.
     *
     * @param idProveedor El nuevo identificador del proveedor.
     */
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Obtiene la cantidad de productos solicitados en la orden de compra.
     *
     * @return La cantidad de productos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos solicitados en la orden de compra.
     *
     * @param cantidad La nueva cantidad de productos.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio de compra del producto.
     *
     * @return El precio de compra.
     */
    public double getPrecioCompra() {
        return precioCompra;
    }

    /**
     * Establece el precio de compra del producto.
     *
     * @param precioCompra El nuevo precio de compra.
     */
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    /**
     * Obtiene la fecha de compra de la orden.
     *
     * @return La fecha de compra.
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Establece la fecha de compra de la orden.
     *
     * @param fechaCompra La nueva fecha de compra.
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
