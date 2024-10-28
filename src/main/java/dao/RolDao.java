
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
    private Connection connection;

    // Constructor que recibe una conexión
    public RolDao(Connection connection) {
        this.connection = connection;
    }

    // Método para agregar un rol
    public boolean agregarRol(Rol rol) throws SQLException {
        String query = "INSERT INTO rol (nombre_rol) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getNombreRol());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para actualizar un rol existente
    public boolean actualizarRol(Rol rol) throws SQLException {
        String query = "UPDATE rol SET nombre_rol = ? WHERE id_tipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, rol.getNombreRol());
            stmt.setInt(2, rol.getIdTipo());
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para eliminar un rol por su ID
    public boolean eliminarRol(int idTipo) throws SQLException {
        String query = "DELETE FROM rol WHERE id_tipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTipo);
            return stmt.executeUpdate() > 0;
        }
    }

    // Método para listar todos los roles
    public List<Rol> listarRoles() throws SQLException {
        List<Rol> lista = new ArrayList<>();
        String query = "SELECT * FROM rol";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Rol rol = new Rol();
                rol.setIdTipo(rs.getInt("idTipo"));
                rol.setNombreRol(rs.getString("nombreRol"));
                lista.add(rol);
            }
        }
        return lista;
    }

    // Método para obtener un rol por su ID
    public Rol obtenerRolPorId(int idTipo) throws SQLException {
        String query = "SELECT * FROM rol WHERE id_tipo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idTipo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Rol rol = new Rol();
                    rol.setIdTipo(rs.getInt("id_tipo"));
                    rol.setNombreRol(rs.getString("nombre_rol"));
                    return rol;
                }
            }
        }
        return null;
    }
}
