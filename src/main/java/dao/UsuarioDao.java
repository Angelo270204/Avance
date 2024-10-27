package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;
import modelo.Usuario;
import util.DataSource;

public class UsuarioDao {

    private Connection conexion;

    public UsuarioDao() {
        conexion=DataSource.obtenerConexion();
    }

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id_usuario, id_empleado, username, password, id_rol, fecha_acceso FROM usuario";

        try (PreparedStatement ps = conexion.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setIdEmpleado(rs.getInt("id_empleado"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaUltimoAcceso(rs.getDate("fecha_acceso"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return usuarios;
    }

    public void addUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (id_empleado, username, password, id_rol, fecha_acceso) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuario.getIdEmpleado());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdRol());

            // Convertir la fecha si es necesario
            if (usuario.getFechaUltimoAcceso() != null) {
                java.sql.Date sqlDate = new java.sql.Date(usuario.getFechaUltimoAcceso().getTime());
                ps.setDate(5, sqlDate);
            } else {
                ps.setNull(5, java.sql.Types.DATE); // Si no hay fecha, establecer NULL
            }

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
    }

    public Usuario leer(int id) {
        Usuario usuario = null;
        String sql = "SELECT id_usuario, id_empleado, username, password, id_tipo, fecha_acceso FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setIdEmpleado(rs.getInt("id_empleado"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setIdRol(rs.getInt("id_rol"));
                usuario.setFechaUltimoAcceso(rs.getDate("fecha_acceso"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
        }
        return usuario;
    }

    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE usuario SET id_empleado = ?, username = ?, password = ?, id_rol = ?, fecha_acceso = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, usuario.getIdEmpleado());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getIdRol());
            // Convertir la fecha si es necesario
            if (usuario.getFechaUltimoAcceso() != null) {
                java.sql.Date sqlDate = new java.sql.Date(usuario.getFechaUltimoAcceso().getTime());
                ps.setDate(5, sqlDate);
            } else {
                ps.setNull(5, java.sql.Types.DATE); // Si no hay fecha, establecer NULL
            }
            ps.setInt(6, usuario.getIdUsuario());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepciones
            return false;
        }
    }
    
    public Usuario validarCredenciales(String username,String password){
        
        // Lógica para consultar la base de datos y validar las credenciales
        Usuario usuario = null;

        // Supongamos que tienes una consulta SQL para obtener el usuario
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Crea un nuevo objeto Usuario con los datos obtenidos
                usuario = new Usuario();
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                // Establece otros campos de Usuario según sea necesario
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
