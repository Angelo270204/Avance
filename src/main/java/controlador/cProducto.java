package controlador;

import modelo.Producto;
import dao.ProductoDao;
import java.sql.Connection;

public class cProducto {
    private final ProductoDao productoDao;

    public cProducto(Connection connection) {
        this.productoDao = new ProductoDao(connection);
    }

    public boolean registrarProducto(Producto producto) {
        return productoDao.addProducto(producto);
    }

    public Producto obtenerProducto(int id) {
        return productoDao.leer(id);
    }

    public boolean actualizarProducto(Producto producto) {
        return productoDao.actualizar(producto);
    }

    public boolean eliminarProducto(int id) {
        return productoDao.eliminar(id);
    }
}
