package dao;

import modelo.Usuario;
import util.DataSource;
import java.sql.*;

public class UsuarioDao {
    private final DataSource dataSource;

    public UsuarioDao() {
        this.dataSource = new DataSource();
    }

    //Lo modificas acorde a la bd
    
   /* public boolean crear(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, password, rol_id) VALUES (?, ?, ?, ?)";
        try (Connection conn =DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            /*            (            pstmt.setInt(4, usuario.getRol().getId()));
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public Usuario leer(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                // Asignar otros atributos...
                return usuario;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, email = ?, password = ?, rol_id = ? WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getPassword());
            /*            pstmt.setInt(4, usuario.getRol().getId());
            pstmt.setInt(5, usuario.getId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try (Connection conn = DataSource.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
*/
}
