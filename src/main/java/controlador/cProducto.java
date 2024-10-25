package controlador;

import modelo.Producto;
import dao.ProductoDao;

public class cProducto {
    private final ProductoDao productoDao;

    public cProducto() {
        this.productoDao = new ProductoDao();
    }

    public boolean registrarProducto(Producto producto) {
        return productoDao.crear(producto);
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
