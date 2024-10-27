package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;

public class ProductoDao {

    private final Connection connection;

    public ProductoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = """
        SELECT p.id_producto, p.nombre, p.descripcion, p.cantidad_stock, 
               p.precio, c.id_categoria, c.nombre_categoria 
        FROM producto p 
        INNER JOIN categoria c ON p.id_categoria = c.id_categoria
    """;

        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidadStock(rs.getInt("cantidad_stock"));
                producto.setPrecio(rs.getDouble("precio"));

                // Crear objeto Categoria y asignarlo al producto
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombreCategoria(rs.getString("nombre_categoria"));

                producto.setCategoria(categoria); // Asignar la categoría al producto
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
        return productos;
    }

    public boolean addProducto(Producto producto) {
        String sql = "INSERT INTO producto (nombre, id_categoria, descripcion, cantidad_stock, precio) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getCategoria().getIdCategoria()); // Usar el objeto Categoria
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidadStock());
            ps.setDouble(5, producto.getPrecio());
            return ps.executeUpdate() > 0; // Retorna true si se insertó correctamente
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción mejorado
            return false;
        }
    }

    public Producto leer(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));

                // Crear un objeto Categoria
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria")); // Asignar ID de la categoría
                producto.setCategoria(categoria); // Asignar el objeto Categoria al producto

                producto.setDescripcion(rs.getString("descripcion"));
                producto.setCantidadStock(rs.getInt("cantidad_stock"));
                producto.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción mejorado
        }
        return producto;
    }

    public boolean actualizar(Producto producto) {
        String sql = "UPDATE producto SET nombre = ?, id_categoria = ?, descripcion = ?, cantidad_stock = ?, precio = ? WHERE id_producto = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getCategoria().getIdCategoria()); // Usar el objeto Categoria
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidadStock());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getIdProducto());
            return ps.executeUpdate() > 0; // Retorna true si la actualización fue exitosa
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción mejorado
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0; // Retorna true si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción mejorado
            return false;
        }
    }
}
