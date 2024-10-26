package dao;

import modelo.Producto;
import util.DataSource;
import java.sql.*;

public class ProductoDao {
    private final DataSource dataSource;

    public ProductoDao() {
        this.dataSource = new DataSource();
    }

    public boolean crear(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, categoria_id) VALUES (?, ?, ?)";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            /*           pstmt.setInt(3, producto.getCategoria().getId());*/
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public Producto leer(int id) {
        String sql = "SELECT * FROM productos WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                // Asignar otros atributos...
                return producto;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            /*            pstmt.setInt(3, producto.getCategoria().getId());*/
            pstmt.setInt(4, producto.getIdProducto());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
