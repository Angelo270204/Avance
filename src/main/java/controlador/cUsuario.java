package controlador;

import modelo.Usuario;
import dao.UsuarioDao;
import java.sql.Connection;

public class cUsuario {
    
    private final UsuarioDao usuarioDao;

    public cUsuario(Connection connection) { // Recibe la conexión como parámetro
        this.usuarioDao = new UsuarioDao(connection);
    }

    public boolean registrarUsuario(Usuario usuario) {
        try {
            usuarioDao.addUsuario(usuario);
            return true;
        } catch (Exception e) { // Manejo de excepciones
            return false;
        }
    }

    public Usuario obtenerUsuario(int id) {
        return usuarioDao.leer(id);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioDao.actualizar(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarioDao.eliminar(id);
    }
}
