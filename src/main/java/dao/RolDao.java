
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Rol;

public class RolDao {
    private Connection connection; // Conexión a la base de datos

    // Constructor que recibe una conexión
    public RolDao(Connection connection) {
        this.connection = connection; // Inicializa la conexión
    }

    // Método para agregar un rol
    public boolean agregarRol(Rol rol) throws SQLException {
        String query = "INSERT INTO rol (nombre_rol) VALUES (?)"; // Consulta SQL para insertar un rol
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getNombre_rol()); // Asignar el nombre del rol
            return stmt.executeUpdate() > 0; // Retorna true si la inserción fue exitosa
        }
    }

    // Método para actualizar un rol existente
    public boolean actualizarRol(Rol rol) throws SQLException {
        String query = "UPDATE rol SET nombre_rol = ? WHERE id_tipo = ?"; // Consulta SQL para actualizar un rol
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getNombre_rol()); // Asignar el nuevo nombre del rol
            stmt.setInt(2, rol.getId_tipo()); // Asignar el ID del rol a actualizar
            return stmt.executeUpdate() > 0; // Retorna true si la actualización fue exitosa
        }
    }

    // Método para eliminar un rol por su ID
    public boolean eliminarRol(int id_tipo) throws SQLException {
        String query = "DELETE FROM rol WHERE id_tipo = ?"; // Consulta SQL para eliminar un rol
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id_tipo); // Asignar el ID del rol a eliminar
            return stmt.executeUpdate() > 0; // Retorna true si la eliminación fue exitosa
        }
    }

    // Método para listar todos los roles
    public List<Rol> listarRoles() throws SQLException {
        List<Rol> lista = new ArrayList<>(); // Lista para almacenar los roles
        String query = "SELECT * FROM rol"; // Consulta SQL para obtener todos los roles
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            // Iterar sobre los resultados de la consulta
            while (rs.next()) {
                Rol rol = new Rol(); // Crear un nuevo objeto Rol
                rol.setId_tipo(rs.getInt("id_tipo")); // Asignar el ID del rol
                rol.setNombre_rol(rs.getString("nombre_rol")); // Asignar el nombre del rol
                lista.add(rol); // Agregar el rol a la lista
            }
        }
        return lista; // Retornar la lista de roles
    }

    // Método para obtener un rol por su ID
    public Rol obtenerRolPorId(int id_tipo) throws SQLException {
        String query = "SELECT * FROM rol WHERE id_tipo = ?"; // Consulta SQL para obtener un rol por su ID
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id_tipo); // Asignar el ID del rol a obtener
            try (ResultSet rs = stmt.executeQuery()) {
                // Verificar si se encontró el rol
                if (rs.next()) {
                    Rol rol = new Rol(); // Crear un nuevo objeto Rol
                    rol.setId_tipo(rs.getInt("id_tipo")); // Asignar el ID del rol
                    rol.setNombre_rol(rs.getString("nombre_rol")); // Asignar el nombre del rol
                    return rol; // Retornar el rol encontrado
                }
            }
        }
        return null; // Retornar null si no se encontró el rol
    }
}

