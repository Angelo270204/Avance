
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

    private Connection connection;

    public EmpleadoDao(Connection connection) {
        this.connection = connection;
    }

 public List<Empleado> listarEmpleados() throws SQLException {
    String query = """
        SELECT e.id_empleado, e.nombre, e.apellido, e.dni, e.edad, e.id_sexo, e.celular, 
               e.direccion, e.correo, s.descripcion AS nombreSexo, 
               r.id_tipo, r.nombre_rol
        FROM empleado e
        INNER JOIN rol r ON e.id_rol = r.id_tipo
        INNER JOIN sexo s ON e.id_sexo = s.id_sexo
    """;

    List<Empleado> empleados = new ArrayList<>();
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(rs.getInt("id_empleado"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setApellido(rs.getString("apellido"));
            empleado.setDni(rs.getString("dni"));
            empleado.setEdad(rs.getInt("edad")); // Asegúrate de que este tipo coincida con tu tabla
            empleado.setCelular(rs.getString("celular"));
            empleado.setDireccion(rs.getString("direccion"));
            empleado.setCorreo(rs.getString("correo"));

            // Asignar Sexo
            Sexo sexo = new Sexo();
            sexo.setIdSexo(rs.getInt("id_sexo")); // Asegúrate de que esto esté correcto
            sexo.setDescripcion(rs.getString("nombreSexo")); 
            empleado.setSexo(sexo);

            // Asignar Rol
            Rol rol = new Rol();
            rol.setIdTipo(rs.getInt("id_tipo")); // Cambia aquí si usabas idTipo
            rol.setNombreRol(rs.getString("nombre_rol")); 
            empleado.setRol(rol);

            empleados.add(empleado);
        }
    }
    return empleados;
}


    // Método para agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) throws SQLException {
        String query = """
            INSERT INTO empleado (nombre, apellido, dni, edad, celular, direccion, correo, id_sexo, id_rol)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
        """;
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getDni());
            pstmt.setInt(4, empleado.getEdad());
            pstmt.setString(5, empleado.getCelular());
            pstmt.setString(6, empleado.getDireccion());
            pstmt.setString(7, empleado.getCorreo());
            pstmt.setInt(8, empleado.getSexo().getIdSexo());
            pstmt.setInt(9, empleado.getRol().getIdTipo());

            pstmt.executeUpdate();
        }
    }
}


