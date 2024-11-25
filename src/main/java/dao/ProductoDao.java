package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;

public class ProductoDao {

    // Conexión a la base de datos
    private final Connection connection;

    // Constructor que recibe la conexión
    public ProductoDao(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener todos los productos
    public List<Producto> getAllProductos() {
        List<Producto> productos = new ArrayList<>();
        // Consulta SQL para obtener productos junto con su categoría
        String sql = """
        SELECT p.id_producto, p.nombre, p.descripcion, p.cantidad_stock, 
               p.precio, c.id_categoria, c.nombre_categoria 
        FROM producto p 
        INNER JOIN categoria c ON p.id_categoria = c.id_categoria
        """;

        // Ejecución de la consulta
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Creación de un objeto Producto y asignación de atributos
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

                // Asignar la categoría al producto
                producto.setCategoria(categoria); 
                productos.add(producto); // Agregar producto a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
        return productos; // Retornar la lista de productos
    }

    // Método para agregar un nuevo producto
    public boolean addProducto(Producto producto) {
        // Consulta SQL para insertar un nuevo producto
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
            return false; // Retornar false si ocurre un error
        }
    }

    // Método para leer un producto por ID
    public Producto leer(int id) {
        Producto producto = null;
        String sql = "SELECT * FROM producto WHERE id_producto = ?"; // Consulta para obtener un producto
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id); // Asignar ID del producto
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto(); // Crear objeto Producto
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
        return producto; // Retornar el producto encontrado
    }

    // Método para actualizar un producto
    public boolean actualizar(Producto producto) {
        // Consulta SQL para actualizar un producto existente
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
            return false; // Retornar false si ocurre un error
        }
    }

    // Método para eliminar un producto por ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id_producto = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para contar el total de productos en stock
    public int contarProductos() throws SQLException {
        String query = "SELECT SUM(cantidad_stock) AS total FROM producto"; 
        int total = 0;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                total = rs.getInt("total"); // Obtener total de la consulta
            }
        }
        return total; // Retornar total de productos
    }
    
    // Método para contar productos que están bajo stock
    public int contarProductosBajoStock() throws SQLException {
        String query = "SELECT COUNT(*) AS total FROM producto WHERE cantidad_stock <= 2"; 
        int total = 0;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                total = rs.getInt("total"); // Obtener total de productos bajo stock
            }
        }
        return total; // Retornar total de productos bajo stock
    }

    public List<Producto> buscarProductosPorNombre(String nombre) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE nombre LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setNombre(rs.getString("nombre"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setCantidadStock(rs.getInt("cantidad_stock"));
                    producto.setPrecio(rs.getDouble("precio"));
                    // Asumiendo que tienes un método para obtener la categoría por ID
                    // producto.setCategoria(obtenerCategoriaPorId(rs.getInt("id_categoria")));
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
