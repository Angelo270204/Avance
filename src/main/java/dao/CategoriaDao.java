package dao;

import modelo.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private final Connection connection; // Conexión a la base de datos

    // Constructor que inicializa la conexión
    public CategoriaDao(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener todas las categorías
    public List<Categoria> getAllCategorias() {
        List<Categoria> categorias = new ArrayList<>(); // Lista para almacenar categorías
        String sql = "SELECT id_categoria, nombre_categoria, descripcion FROM categoria"; // Consulta SQL

        // Uso de try-with-resources para cerrar automáticamente los recursos
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Iterar sobre el resultado de la consulta
            while (rs.next()) {
                Categoria categoria = new Categoria(); // Crear nueva instancia de Categoria
                categoria.setIdCategoria(rs.getInt("id_categoria")); // Obtener y establecer el ID
                categoria.setNombreCategoria(rs.getString("nombre_categoria")); // Obtener y establecer el nombre
                categoria.setDescripcion(rs.getString("descripcion")); // Obtener y establecer la descripción
                categorias.add(categoria); // Agregar la categoría a la lista
            }
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Imprimir el error en consola
        }
        return categorias; // Retornar la lista de categorías
    }

    // Método para agregar una nueva categoría
    public void addCategoria(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre_categoria, descripcion) VALUES (?, ?)"; // Consulta SQL

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria()); // Establecer el nombre de la categoría
            ps.setString(2, categoria.getDescripcion()); // Establecer la descripción de la categoría
            ps.executeUpdate(); // Ejecutar la consulta
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Imprimir el error en consola
        }
    }

    // Método para leer una categoría por su ID
    public Categoria leer(int id) {
        Categoria categoria = null; // Inicializar la categoría como null
        String sql = "SELECT id_categoria, nombre_categoria, descripcion FROM categoria WHERE id_categoria = ?"; // Consulta SQL

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id); // Establecer el ID de la categoría a leer
            ResultSet rs = ps.executeQuery(); // Ejecutar la consulta

            // Si se encuentra la categoría
            if (rs.next()) {
                categoria = new Categoria(); // Crear nueva instancia de Categoria
                categoria.setIdCategoria(rs.getInt("id_categoria")); // Obtener y establecer el ID
                categoria.setNombreCategoria(rs.getString("nombre_categoria")); // Obtener y establecer el nombre
                categoria.setDescripcion(rs.getString("descripcion")); // Obtener y establecer la descripción
            }
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Imprimir el error en consola
        }
        return categoria; // Retornar la categoría encontrada (o null si no se encontró)
    }

    // Método para actualizar una categoría existente
    public boolean actualizar(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre_categoria = ?, descripcion = ? WHERE id_categoria = ?"; // Consulta SQL

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria()); // Establecer el nombre
            ps.setString(2, categoria.getDescripcion()); // Establecer la descripción
            ps.setInt(3, categoria.getIdCategoria()); // Establecer el ID de la categoría a actualizar
            return ps.executeUpdate() > 0; // Retornar verdadero si la actualización fue exitosa
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Imprimir el error en consola
            return false; // Retornar falso si ocurrió un error
        }
    }

    // Método para eliminar una categoría por su ID
    public boolean eliminar(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?"; // Consulta SQL

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id); // Establecer el ID de la categoría a eliminar
            return ps.executeUpdate() > 0; // Retornar verdadero si la eliminación fue exitosa
        } catch (SQLException e) {
            // Manejo de errores
            e.printStackTrace(); // Imprimir el error en consola
            return false; // Retornar falso si ocurrió un error
        }
    }
}
