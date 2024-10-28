package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Proveedor;

public class ProveedorDao {
    // Conexión a la base de datos
    private final Connection connection;

    // Constructor que recibe la conexión
    public ProveedorDao(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener todos los proveedores
    public List<Proveedor> getAllProveedores() {
        List<Proveedor> proveedores = new ArrayList<>(); // Lista para almacenar proveedores
        // Consulta SQL para obtener todos los proveedores
        String sql = "SELECT id_proveedor, nombre, ruc, correo, celular, direccion, pais FROM proveedor";

        // Ejecución de la consulta
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Iterar sobre el resultado de la consulta
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(); // Crear un nuevo objeto Proveedor
                proveedor.setIdProveedor(rs.getInt("id_proveedor")); // Asignar ID del proveedor
                proveedor.setNombre(rs.getString("nombre")); // Asignar nombre del proveedor
                proveedor.setRuc(rs.getString("ruc")); // Asignar RUC del proveedor
                proveedor.setCorreo(rs.getString("correo")); // Asignar correo del proveedor
                proveedor.setCelular(rs.getString("celular")); // Asignar celular del proveedor
                proveedor.setDireccion(rs.getString("direccion")); // Asignar dirección del proveedor
                proveedor.setPais(rs.getString("pais")); // Asignar país del proveedor
                proveedores.add(proveedor); // Agregar proveedor a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
        return proveedores; // Retornar la lista de proveedores
    }

    // Método para agregar un nuevo proveedor
    public void addProveedor(Proveedor proveedor) {
        // Consulta SQL para insertar un nuevo proveedor
        String sql = "INSERT INTO proveedor (nombre, ruc, correo, celular, direccion, pais) VALUES (?, ?, ?, ?, ?, ?)";

        // Ejecución de la consulta
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Asignar parámetros para la consulta
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getCelular());
            ps.setString(5, proveedor.getDireccion());
            ps.setString(6, proveedor.getPais());
            ps.executeUpdate(); // Ejecutar la actualización
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
        }
    }

    // Método para actualizar un proveedor existente
    public boolean updateProveedor(Proveedor proveedor) {
        // Consulta SQL para actualizar un proveedor
        String sql = "UPDATE proveedor SET nombre = ?, ruc = ?, correo = ?, celular = ?, direccion = ?, pais = ? WHERE id_proveedor = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Asignar parámetros para la consulta
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRuc());
            ps.setString(3, proveedor.getCorreo());
            ps.setString(4, proveedor.getCelular());
            ps.setString(5, proveedor.getDireccion());
            ps.setString(6, proveedor.getPais());
            ps.setInt(7, proveedor.getIdProveedor()); // Asignar ID del proveedor a actualizar
            return ps.executeUpdate() > 0; // Retorna true si la actualización fue exitosa
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
            return false; // Retornar false si ocurre un error
        }
    }

    // Método para eliminar un proveedor por ID
    public boolean deleteProveedor(int id) {
        // Consulta SQL para eliminar un proveedor
        String sql = "DELETE FROM proveedor WHERE id_proveedor = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id); // Asignar ID del proveedor a eliminar
            return ps.executeUpdate() > 0; // Retorna true si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de excepción
            return false; // Retornar false si ocurre un error
        }
    }
}