package controlador;

import modelo.Producto;
import dao.ProductoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cProducto {

    private final ProductoDao productoDao;

    public cProducto(Connection connection) {
        this.productoDao = new ProductoDao(connection);
    }

    public List<Producto> obtenerProductos() {
        return productoDao.getAllProductos();
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

    // Método para obtener el total de productos
    public int obtenerTotalProductos() {
        try {
            return productoDao.contarProductos(); // Llama al método DAO
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return 0; // Devuelve 0 en caso de error
        }
    }
    
    public int obtenerBajoStock(){
        try {
            return productoDao.contarProductosBajoStock();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
