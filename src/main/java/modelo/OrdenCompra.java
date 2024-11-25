package modelo;

import java.util.Date;

/**
 * Clase que representa una orden de compra en el sistema.
 */
public class OrdenCompra {
    
    private int idOrden;
    private Producto producto;
    private Proveedor proveedor;
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
     * @param producto     El producto asociado a la orden.
     * @param proveedor    El proveedor de la orden.
     * @param cantidad     La cantidad de productos solicitados en la orden.
     * @param precioCompra El precio de compra del producto.
     * @param fechaCompra  La fecha en que se realizó la compra.
     */
    public OrdenCompra(int idOrden, Producto producto, Proveedor proveedor, int cantidad, double precioCompra, Date fechaCompra) {
        this.idOrden = idOrden;
        this.producto = producto;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = fechaCompra;
    }

    // Getters y Setters

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}