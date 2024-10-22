
package modelo;

import java.util.Date;

public class OrdenCompra {
    private int idOrden;
    private int idProducto;
    private int idProveedor;
    private int cantidad;
    private double precioCompra;
    private Date fechaCompra;

    public OrdenCompra() {
    }

    public OrdenCompra(int idOrden, int idProducto, int idProveedor, int cantidad, double precioCompra, Date fechaCompra) {
        this.idOrden = idOrden;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.fechaCompra = fechaCompra;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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
