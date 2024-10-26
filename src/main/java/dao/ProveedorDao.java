package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDao {
    private final Connection connection;

    public ProveedorDao(Connection connection) {
        this.connection = connection;
    }

    public List<Proveedor> getAllProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT id_proveedor, nombre, ruc, correo, celular, direccion, pais FROM proveedor";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setRuc(rs.getString("ruc"));
                proveedor.setCorreo(rs.getString("correo"));
                proveedor.setCelular(rs.getString("celular"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setPais(rs.getString("pais"));
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
        return proveedores;
    }

    public void addProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedor (nombre, ruc, correo, celular, direccion, pais) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getCelular());
            ps.setString(5, proveedor.getDireccion());
            ps.setString(6, proveedor.getPais());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
    }

    public boolean updateProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedor SET nombre = ?, ruc = ?, correo = ?, celular = ?, direccion = ?, pais = ? WHERE id_proveedor = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getCelular());
            ps.setString(5, proveedor.getDireccion());
            ps.setString(6, proveedor.getPais());
            ps.setInt(7, proveedor.getIdProveedor());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
            return false;
        }
    }

    public boolean deleteProveedor(int id) {
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
            return false;
        }
    }
}
