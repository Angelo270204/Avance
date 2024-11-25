package dao;

import modelo.OrdenCompra;
import modelo.Producto;
import modelo.Proveedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdenCompraDao {

    private final Connection connection;

    public OrdenCompraDao(Connection connection) {
        this.connection = connection;
    }

    public boolean registrarOrdenCompra(OrdenCompra orden) {
        String sql = "INSERT INTO ordencompra (id_producto, id_proveedor, cantidad, precio_compra, fecha_compra) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, orden.getProducto().getIdProducto());
            ps.setInt(2, orden.getProveedor().getIdProveedor());
            ps.setInt(3, orden.getCantidad());
            ps.setDouble(4, orden.getPrecioCompra());
            ps.setDate(5, new Date(orden.getFechaCompra().getTime()));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<OrdenCompra> obtenerOrdenesCompra() {
        List<OrdenCompra> ordenes = new ArrayList<>();
        String sql = """
            SELECT oc.id_orden, oc.cantidad, oc.precio_compra, oc.fecha_compra,
                   p.id_producto, p.nombre AS nombre_producto,
                   pr.id_proveedor, pr.nombre AS nombre_proveedor
            FROM ordencompra oc
            JOIN producto p ON oc.id_producto = p.id_producto
            JOIN proveedor pr ON oc.id_proveedor = pr.id_proveedor
        """;
        try (PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                OrdenCompra orden = new OrdenCompra();
                orden.setIdOrden(rs.getInt("id_orden"));
                
                // Obtener el objeto Producto
                Producto producto = new Producto();
                producto.setIdProducto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre_producto"));
                orden.setProducto(producto);
                
                // Obtener el objeto Proveedor
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre_proveedor"));
                orden.setProveedor(proveedor);
                
                orden.setCantidad(rs.getInt("cantidad"));
                orden.setPrecioCompra(rs.getDouble("precio_compra"));
                orden.setFechaCompra(rs.getDate("fecha_compra"));
                ordenes.add(orden);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordenes;
    }

    public boolean actualizarOrdenCompra(OrdenCompra orden) {
        String sql = "UPDATE ordencompra SET id_producto = ?, id_proveedor = ?, cantidad = ?, precio_compra = ?, fecha_compra = ? WHERE id_orden = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, orden.getProducto().getIdProducto());
            ps.setInt(2, orden.getProveedor().getIdProveedor());
            ps.setInt(3, orden.getCantidad());
            ps.setDouble(4, orden.getPrecioCompra());
            ps.setDate(5, new Date(orden.getFechaCompra().getTime()));
            ps.setInt(6, orden.getIdOrden());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarOrdenCompra(int idOrden) {
        String sql = "DELETE FROM ordencompra WHERE id_orden = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idOrden);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<OrdenCompra> obtenerOrdenesCompraPorNombre(String nombreProveedor) {
        List<OrdenCompra> ordenes = new ArrayList<>();
        String sql = """
            SELECT oc.id_orden, oc.cantidad, oc.precio_compra, oc.fecha_compra,
                   p.id_producto, p.nombre AS nombre_producto,
                   pr.id_proveedor, pr.nombre AS nombre_proveedor
            FROM ordencompra oc
            JOIN producto p ON oc.id_producto = p.id_producto
            JOIN proveedor pr ON oc.id_proveedor = pr.id_proveedor
            WHERE pr.nombre LIKE ?
        """;
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + nombreProveedor + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrdenCompra orden = new OrdenCompra();
                    orden.setIdOrden(rs.getInt("id_orden"));
                    
                    // Obtener el objeto Producto
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("id_producto"));
                    producto.setNombre(rs.getString("nombre_producto"));
                    orden.setProducto(producto);
                    
                    // Obtener el objeto Proveedor
                    Proveedor proveedor = new Proveedor();
                    proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                    proveedor.setNombre(rs.getString("nombre_proveedor"));
                    orden.setProveedor(proveedor);
                    
                    orden.setCantidad(rs.getInt("cantidad"));
                    orden.setPrecioCompra(rs.getDouble("precio_compra"));
                    orden.setFechaCompra(rs.getDate("fecha_compra"));
                    ordenes.add(orden);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordenes;
    }
}
