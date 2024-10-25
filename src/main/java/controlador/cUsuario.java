package controlador;

import modelo.Usuario;
import util.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cUsuario {

    public void crearUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (idEmpleado, username, password, idRol, fechaUltimoAcceso) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getIdEmpleado());
            pstmt.setString(2, usuario.getUsername());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setInt(4, usuario.getIdRol());
            pstmt.setTimestamp(5, new Timestamp(usuario.getFechaUltimoAcceso().getTime()));
            pstmt.executeUpdate();
        }
    }

    public Usuario obtenerUsuario(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("idUsuario"),
                        rs.getInt("idEmpleado"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("idRol"),
                        rs.getTimestamp("fechaUltimoAcceso")
                    );
                }
            }
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET idEmpleado = ?, username = ?, password = ?, idRol = ?, fechaUltimoAcceso = ? WHERE idUsuario = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuario.getIdEmpleado());
            pstmt.setString(2, usuario.getUsername());
            pstmt.setString(3, usuario.getPassword());
            pstmt.setInt(4, usuario.getIdRol());
            pstmt.setTimestamp(5, new Timestamp(usuario.getFechaUltimoAcceso().getTime()));
            pstmt.setInt(6, usuario.getIdUsuario());
            pstmt.executeUpdate();
        }
    }

    public void eliminarUsuario(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = DataSource.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("idUsuario"),
                    rs.getInt("idEmpleado"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("idRol"),
                    rs.getTimestamp("fechaUltimoAcceso")
                ));
            }
        }
        return usuarios;
    }
}
