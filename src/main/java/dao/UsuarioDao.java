package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Usuario;

public class UsuarioDao {
    private final Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, id_empleado, username, password, id_tipo, fecha_acceso FROM usuario";

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setIdEmpleado(rs.getInt("id_empleado"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdTipo(rs.getInt("id_tipo"));
                usuario.setFechaAcceso(rs.getDate("fecha_acceso"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (id_empleado, username, password, id_tipo, fecha_acceso) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, usuario.getIdEmpleado());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdTipo());
            ps.setDate(5, usuario.getFechaAcceso());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public Usuario leer(int id) {
        Usuario usuario = null;
        String sql = "SELECT id_usuario, id_empleado, username, password, id_tipo, fecha_acceso FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setIdEmpleado(rs.getInt("id_empleado"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdTipo(rs.getInt("id_tipo"));
                usuario.setFechaAcceso(rs.getDate("fecha_acceso"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return usuario;
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET id_empleado = ?, username = ?, password = ?, id_tipo = ?, fecha_acceso = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, usuario.getIdEmpleado());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdTipo());
            ps.setDate(5, usuario.getFechaAcceso());
            ps.setInt(6, usuario.getIdUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }
}
