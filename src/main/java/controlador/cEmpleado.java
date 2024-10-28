
package controlador;

import dao.EmpleadoDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.Empleado;

public class cEmpleado {
    private EmpleadoDao empleadoDao;

    public cEmpleado(Connection connection) {
        this.empleadoDao = new EmpleadoDao(connection);
    }

    // Método para listar empleados
    public List<Empleado> listarEmpleados() {
        try {
            return empleadoDao.listarEmpleados();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para agregar un empleado
    public void agregarEmpleado(Empleado empleado) {
        try {
            empleadoDao.agregarEmpleado(empleado);
            System.out.println("Empleado agregado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
