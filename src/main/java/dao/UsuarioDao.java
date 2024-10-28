package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;
import modelo.Rol;
import modelo.Usuario;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    // Método para listar todos los usuarios con sus empleados y roles
    public List<Usuario> listarUsuarios() throws SQLException {
        String query = """
            SELECT u.id_usuario, u.username, u.password, u.fecha_acceso, 
                   e.id_empleado, e.nombre AS nombreEmpleado, e.apellido AS apellidoEmpleado,
                   r.id_tipo, r.nombre_rol
            FROM Usuario u
            INNER JOIN empleado e ON u.id_empleado = e.id_empleado
            INNER JOIN rol r ON u.id_rol = r.id_tipo
        """;

        List<Usuario> usuarios = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setFechaUltimoAcceso(rs.getDate("fechaUltimoAcceso"));

                // Asignar Empleado
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setNombre(rs.getString("nombreEmpleado"));
                empleado.setApellido(rs.getString("apellidoEmpleado"));
                usuario.setEmpleado(empleado);

                // Asignar Rol
                Rol rol = new Rol(rs.getInt("idTipo"), rs.getString("nombreRol"));
                usuario.setRol(rol);

                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    // Método para agregar un nuevo usuario
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, id_empleado, id_rol) VALUES (?, ?, ?, ?)";
        boolean registrado = false;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setInt(3, usuario.getEmpleado().getIdEmpleado());
            ps.setInt(4, usuario.getRol().getIdTipo());

            int filasAfectadas = ps.executeUpdate();
            registrado = filasAfectadas > 0; // true si se afectó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrado;
    }

    // Método para eliminar un usuario por su ID
    public void eliminarUsuario(int idUsuario) throws SQLException {
        String query = "DELETE FROM usuario WHERE id_usuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idUsuario);
            pstmt.executeUpdate();
        }
    }

    public Usuario validarCredenciales(String username,String password){
        
        // Lógica para consultar la base de datos y validar las credenciales
        Usuario usuario = null;

        // Supongamos que tienes una consulta SQL para obtener el usuario
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
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

    
    public boolean existeUsuario(String username) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM usuario WHERE username = ?"; // Cambia "usuarios" por el nombre de tu tabla

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Si el conteo es mayor que 0, el usuario existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}
