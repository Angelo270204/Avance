package controlador;

import modelo.Proveedor;
import util.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cProveedor {

    public void crearProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO proveedor (nombre, ruc, correo, celular, direccion, pais) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getRuc());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getCelular());
            pstmt.setString(5, proveedor.getDireccion());
            pstmt.setString(6, proveedor.getPais());
            pstmt.executeUpdate();
        }
    }

    public Proveedor obtenerProveedor(int id) throws SQLException {
        String sql = "SELECT * FROM proveedor WHERE idProveedor = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Proveedor(
                        rs.getInt("idProveedor"),
                        rs.getString("nombre"),
                        rs.getString("ruc"),
                        rs.getString("correo"),
                        rs.getString("celular"),
                        rs.getString("direccion"),
                        rs.getString("pais")
                    );
                }
            }
        }
        return null;
    }

    public void actualizarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "UPDATE proveedor SET nombre = ?, ruc = ?, correo = ?, celular = ?, direccion = ?, pais = ? WHERE idProveedor = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getRuc());
            pstmt.setString(3, proveedor.getCorreo());
            pstmt.setString(4, proveedor.getCelular());
            pstmt.setString(5, proveedor.getDireccion());
            pstmt.setString(6, proveedor.getPais());
            pstmt.setInt(7, proveedor.getIdProveedor());
            pstmt.executeUpdate();
        }
    }

    public void eliminarProveedor(int id) throws SQLException {
        String sql = "DELETE FROM proveedor WHERE idProveedor = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public List<Proveedor> listarProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedor";
        try (Connection conn = DataSource.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                proveedores.add(new Proveedor(
                    rs.getInt("idProveedor"),
                    rs.getString("nombre"),
                    rs.getString("ruc"),
                    rs.getString("correo"),
                    rs.getString("celular"),
                    rs.getString("direccion"),
                    rs.getString("pais")
                ));
            }
        }
        return proveedores;
    }
}
