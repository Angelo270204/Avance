
package controlador;

import dao.RolDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.Rol;

public class cRol {
    private RolDao rolDao;

    // Constructor que recibe una conexión
    public cRol(Connection connection) {
        this.rolDao = new RolDao(connection);
    }

    // Método para agregar un rol
    public String agregarRol(Rol rol) {
        try {
            boolean resultado = rolDao.agregarRol(rol);
            return resultado ? "Rol agregado exitosamente" : "Error al agregar el rol";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos: " + e.getMessage();
        }
    }

    // Método para actualizar un rol
    public String actualizarRol(Rol rol) {
        try {
            boolean resultado = rolDao.actualizarRol(rol);
            return resultado ? "Rol actualizado correctamente" : "Error al actualizar el rol";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos: " + e.getMessage();
        }
    }

    // Método para eliminar un rol
    public String eliminarRol(int idTipo) {
        try {
            boolean resultado = rolDao.eliminarRol(idTipo);
            return resultado ? "Rol eliminado correctamente" : "Error al eliminar el rol";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error en la base de datos: " + e.getMessage();
        }
    }

    // Método para listar todos los roles
    public List<Rol> listarRoles() {
        try {
            return rolDao.listarRoles();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para obtener un rol por su ID
    public Rol obtenerRolPorId(int idTipo) {
        try {
            return rolDao.obtenerRolPorId(idTipo);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
