
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

public class EmpleadoDao {

    private Connection connection; // Conexión a la base de datos

    // Constructor que inicializa la conexión
    public EmpleadoDao(Connection connection) {
        this.connection = connection;
    }

    // Método para listar todos los empleados
    public List<Empleado> listarEmpleados() throws SQLException {
        // Consulta SQL para obtener empleados y sus detalles
        String query = """
            SELECT e.id_empleado, e.nombre, e.apellido, e.dni, e.edad, e.id_sexo, e.celular, 
                   e.direccion, e.correo, s.descripcion AS nombreSexo, 
                   r.id_tipo, r.nombre_rol
            FROM empleado e
            INNER JOIN rol r ON e.id_rol = r.id_tipo
            INNER JOIN sexo s ON e.id_sexo = s.id_sexo
        """;

        List<Empleado> empleados = new ArrayList<>(); // Lista para almacenar empleados
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) { // Ejecutar la consulta

            // Iterar sobre los resultados
            while (rs.next()) {
                Empleado empleado = new Empleado(); // Crear nueva instancia de Empleado
                empleado.setIdEmpleado(rs.getInt("id_empleado")); // Obtener y establecer el ID
                empleado.setNombre(rs.getString("nombre")); // Obtener y establecer el nombre
                empleado.setApellido(rs.getString("apellido")); // Obtener y establecer el apellido
                empleado.setDni(rs.getString("dni")); // Obtener y establecer el DNI
                empleado.setEdad(rs.getInt("edad")); // Obtener y establecer la edad
                empleado.setCelular(rs.getString("celular")); // Obtener y establecer el celular
                empleado.setDireccion(rs.getString("direccion")); // Obtener y establecer la dirección
                empleado.setCorreo(rs.getString("correo")); // Obtener y establecer el correo

                // Asignar información del sexo
                Sexo sexo = new Sexo(); 
                sexo.setIdSexo(rs.getInt("id_sexo")); // Obtener y establecer el ID de sexo
                sexo.setDescripcion(rs.getString("nombreSexo")); // Obtener y establecer la descripción de sexo
                empleado.setSexo(sexo); // Asignar el objeto Sexo al empleado

                // Asignar información del rol
                Rol rol = new Rol();
                rol.setId_tipo(rs.getInt("id_tipo")); // Obtener y establecer el ID del rol
                rol.setNombre_rol(rs.getString("nombre_rol")); // Obtener y establecer el nombre del rol
                empleado.setRol(rol); // Asignar el objeto Rol al empleado

                empleados.add(empleado); // Agregar el empleado a la lista
            }
        }
        return empleados; // Retornar la lista de empleados
    }

    // Método para agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        // Consulta SQL para insertar un nuevo empleado
        String query = """
            INSERT INTO empleado (nombre, apellido, dni, edad, celular, direccion, correo, id_sexo, id_rol)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            // Establecer los parámetros de la consulta
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getDni());
            pstmt.setInt(4, empleado.getEdad());
            pstmt.setString(5, empleado.getCelular());
            pstmt.setString(6, empleado.getDireccion());
            pstmt.setString(7, empleado.getCorreo());
            pstmt.setInt(8, empleado.getSexo().getIdSexo()); // ID de sexo del empleado
            pstmt.setInt(9, empleado.getRol().getId_tipo()); // ID de rol del empleado

            pstmt.executeUpdate(); // Ejecutar la consulta para agregar el empleado
        }
    }

    // Método para obtener un empleado por su ID
    public Empleado obtenerEmpleadoPorId(int idEmpleado) throws SQLException {
        // Consulta SQL para obtener un empleado específico
        String query = """
            SELECT e.id_empleado, e.nombre, e.apellido, e.dni, e.edad, e.id_sexo, e.celular, 
                   e.direccion, e.correo, s.descripcion AS nombreSexo, 
                   r.id_tipo, r.nombre_rol
            FROM empleado e
            INNER JOIN rol r ON e.id_rol = r.id_tipo
            INNER JOIN sexo s ON e.id_sexo = s.id_sexo
            WHERE e.id_empleado = ?
        """;

        Empleado empleado = null; // Inicializamos como null para verificar si se encontró
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, idEmpleado); // Establecer el ID del empleado en la consulta
            try (ResultSet rs = pstmt.executeQuery()) { // Ejecutar la consulta
                if (rs.next()) { // Si hay resultados
                    empleado = new Empleado(); // Crear nueva instancia de Empleado
                    empleado.setIdEmpleado(rs.getInt("id_empleado")); // Obtener y establecer el ID
                    empleado.setNombre(rs.getString("nombre")); // Obtener y establecer el nombre
                    empleado.setApellido(rs.getString("apellido")); // Obtener y establecer el apellido
                    empleado.setDni(rs.getString("dni")); // Obtener y establecer el DNI
                    empleado.setEdad(rs.getInt("edad")); // Obtener y establecer la edad
                    empleado.setCelular(rs.getString("celular")); // Obtener y establecer el celular
                    empleado.setDireccion(rs.getString("direccion")); // Obtener y establecer la dirección
                    empleado.setCorreo(rs.getString("correo")); // Obtener y establecer el correo

                    // Asignar información del sexo
                    Sexo sexo = new Sexo(); 
                    sexo.setIdSexo(rs.getInt("id_sexo")); // Obtener y establecer el ID de sexo
                    sexo.setDescripcion(rs.getString("nombreSexo")); // Obtener y establecer la descripción de sexo
                    empleado.setSexo(sexo); // Asignar el objeto Sexo al empleado

                    // Asignar información del rol
                    Rol rol = new Rol();
                    rol.setId_tipo(rs.getInt("id_tipo")); // Obtener y establecer el ID del rol
                    rol.setNombre_rol(rs.getString("nombre_rol")); // Obtener y establecer el nombre del rol
                    empleado.setRol(rol); // Asignar el objeto Rol al empleado
                }
            }
        }
        return empleado; // Retornar el empleado encontrado o null si no se encontró
    }
}


