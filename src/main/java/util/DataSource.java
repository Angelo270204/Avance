package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private static final String URL = "jdbc:mysql://localhost:3307/inventario";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "1234";
    private static Connection conexion = null;

    /**
     * Método para obtener la conexión a la base de datos.
     *
     * @return Objeto Connection
     */
    public static Connection obtenerConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
                System.out.println("Conexión establecida exitosamente.");
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }
}
