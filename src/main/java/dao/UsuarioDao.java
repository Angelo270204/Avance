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
import modelo.Sexo;

import modelo.Usuario;

public class UsuarioDao {

    private Connection connection; // Conexión a la base de datos

    // Constructor que inicializa la conexión
    public UsuarioDao(Connection connection) {
        this.connection = connection;
    }

    // Método para validar las credenciales del usuario
    public Usuario validarCredenciales(String username, String password) {
        Usuario usuario = null; // Variable para almacenar el usuario validado
        String sql = "SELECT * FROM usuario WHERE username = ? AND password = ?"; // Consulta SQL

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username); // Establece el nombre de usuario en la consulta
            stmt.setString(2, password); // Establece la contraseña en la consulta
            ResultSet rs = stmt.executeQuery(); // Ejecuta la consulta

            // Si se encuentra un usuario, crea el objeto Usuario
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password")); // Almacena la contraseña (considera encriptar)
                // Establece otros campos de Usuario según sea necesario
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }

        return usuario; // Devuelve el usuario validado o null si no se encontró
    }

    // Método para verificar si un usuario ya existe
    public boolean existeUsuario(String username) {
        boolean existe = false; // Bandera para verificar existencia
        String sql = "SELECT COUNT(*) FROM usuario WHERE username = ?"; // Consulta SQL

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username); // Establece el nombre de usuario en la consulta
            ResultSet rs = stmt.executeQuery(); // Ejecuta la consulta
            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Comprueba si el conteo es mayor que 0
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        }

        return existe; // Devuelve true si el usuario existe, false de lo contrario
    }

    // Método para crear un nuevo usuario
    public Usuario crear(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (id_empleado, username, password, id_tipo, fecha_acceso) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null; // Para obtener el ID generado

        try {
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // Prepara la consulta para obtener el ID
            stmt.setInt(1, usuario.getEmpleado().getIdEmpleado()); // Establece el ID del empleado
            stmt.setString(2, usuario.getUsername()); // Establece el nombre de usuario
            stmt.setString(3, usuario.getPassword()); // Almacena la contraseña (considera encriptar)
            stmt.setInt(4, usuario.getRol().getId_tipo()); // Establece el tipo de rol
            stmt.setDate(5, new java.sql.Date(usuario.getFechaUltimoAcceso().getTime())); // Establece la fecha de acceso

            int affectedRows = stmt.executeUpdate(); // Ejecuta la actualización

            // Comprueba si se afectaron filas
            if (affectedRows == 0) {
                throw new SQLException("La creación del usuario falló");
            }

            generatedKeys = stmt.getGeneratedKeys(); // Obtiene las claves generadas
            if (generatedKeys.next()) {
                usuario.setIdUsuario(generatedKeys.getInt(1)); // Establece el ID del usuario
            } else {
                throw new SQLException("La creación del usuario falló, no se obtuvo el ID");
            }

            return usuario; // Devuelve el usuario creado
        } finally {
            if (generatedKeys != null) {
                generatedKeys.close(); // Cierra el ResultSet de claves generadas
            }
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    // Método para actualizar un usuario existente
    public Usuario actualizar(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET username = ?, password = ?, id_tipo = ?, fecha_acceso = ? "
                + "WHERE id_usuario = ?";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql); // Prepara la consulta
            stmt.setString(1, usuario.getUsername()); // Establece el nombre de usuario
            stmt.setString(2, usuario.getPassword()); // Almacena la contraseña (considera encriptar)
            stmt.setInt(3, usuario.getRol().getId_tipo()); // Establece el tipo de rol
            stmt.setDate(4, new java.sql.Date(usuario.getFechaUltimoAcceso().getTime())); // Establece la fecha de acceso
            stmt.setInt(5, usuario.getIdUsuario()); // Establece el ID del usuario a actualizar

            int affectedRows = stmt.executeUpdate(); // Ejecuta la actualización

            // Comprueba si se afectaron filas
            if (affectedRows == 0) {
                throw new SQLException("La actualización del usuario falló");
            }

            return usuario; // Devuelve el usuario actualizado
        } finally {
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    // Método para eliminar un usuario
    public void eliminar(int idUsuario) throws Exception {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        PreparedStatement stmt = null;

        try {
            stmt = connection.prepareStatement(sql); // Prepara la consulta
            stmt.setInt(1, idUsuario); // Establece el ID del usuario a eliminar
            stmt.executeUpdate(); // Ejecuta la eliminación
        } finally {
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    // Método para buscar un usuario por ID
    public Usuario buscarPorId(int idUsuario) throws Exception {
        String sql = "SELECT u.*, e.*, r.*, s.* FROM usuario u "
                + "JOIN empleado e ON u.id_empleado = e.id_empleado "
                + "JOIN rol r ON u.id_tipo = r.id_tipo "
                + "JOIN sexo s ON e.id_sexo = s.id_sexo "
                + "WHERE u.id_usuario = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(sql); // Prepara la consulta
            stmt.setInt(1, idUsuario); // Establece el ID del usuario
            rs = stmt.executeQuery(); // Ejecuta la consulta

            // Si se encuentra el usuario, lo mapea
            if (rs.next()) {
                return mapearUsuario(rs);
            }
            return null; // Devuelve null si no se encuentra
        } finally {
            if (rs != null) {
                rs.close(); // Cierra el ResultSet
            }
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    // Método para listar todos los usuarios
    public List<Usuario> listarTodos() throws Exception {
        List<Usuario> usuarios = new ArrayList<>(); // Lista para almacenar usuarios
        String sql = "SELECT u.*, e.*, r.*, s.* FROM usuario u "
                + "JOIN empleado e ON u.id_empleado = e.id_empleado "
                + "JOIN rol r ON u.id_tipo = r.id_tipo "
                + "JOIN sexo s ON e.id_sexo = s.id_sexo";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(sql); // Prepara la consulta
            rs = stmt.executeQuery(); // Ejecuta la consulta

            // Mapea cada usuario encontrado y lo agrega a la lista
            while (rs.next()) {
                usuarios.add(mapearUsuario(rs));
            }
            return usuarios; // Devuelve la lista de usuarios
        } finally {
            if (rs != null) {
                rs.close(); // Cierra el ResultSet
            }
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    // Método para buscar un usuario por nombre de usuario
    public Usuario buscarPorUsername(String username) throws Exception {
        String sql = "SELECT u.*, e.*, r.*, s.* FROM usuario u "
                + "JOIN empleado e ON u.id_empleado = e.id_empleado "
                + "JOIN rol r ON u.id_tipo = r.id_tipo "
                + "JOIN sexo s ON e.id_sexo = s.id_sexo "
                + "WHERE u.username = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(sql); // Prepara la consulta
            stmt.setString(1, username); // Establece el nombre de usuario
            rs = stmt.executeQuery(); // Ejecuta la consulta

            // Si se encuentra el usuario, lo mapea
            if (rs.next()) {
                return mapearUsuario(rs);
            }
            return null; // Devuelve null si no se encuentra
        } finally {
            if (rs != null) {
                rs.close(); // Cierra el ResultSet
            }
            if (stmt != null) {
                stmt.close(); // Cierra el PreparedStatement
            }
        }
    }

    private Usuario mapearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario(); //Crear un nuevo usuario
        //Establecemos sus atributos
        usuario.setIdUsuario(rs.getInt("id_usuario"));
        usuario.setUsername(rs.getString("username"));
        usuario.setPassword(rs.getString("password"));
        usuario.setFechaUltimoAcceso(rs.getDate("fecha_acceso"));

        // Mapear Rol
        Rol rol = new Rol();
        rol.setId_tipo(rs.getInt("id_tipo"));
        rol.setNombre_rol(rs.getString("nombre_rol"));
        usuario.setRol(rol);

        // Mapear Empleado
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(rs.getInt("id_empleado"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido(rs.getString("apellido"));
        empleado.setDni(rs.getString("dni"));
        empleado.setEdad(rs.getInt("edad"));
        empleado.setCelular(rs.getString("celular"));
        empleado.setDireccion(rs.getString("direccion"));
        empleado.setCorreo(rs.getString("correo"));

        // Mapear Sexo
        Sexo sexo = new Sexo();
        sexo.setIdSexo(rs.getInt("id_sexo"));
        sexo.setDescripcion(rs.getString("descripcion"));
        empleado.setSexo(sexo);

        empleado.setRol(rol);
        usuario.setEmpleado(empleado);

        return usuario;
    }

}
