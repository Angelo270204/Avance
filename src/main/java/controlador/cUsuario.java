package controlador;

import modelo.Usuario;
import dao.UsuarioDao;

public class cUsuario {
    private final UsuarioDao usuarioDao;

    public cUsuario() {
        this.usuarioDao = new UsuarioDao();
    }

    public boolean registrarUsuario(Usuario usuario) {
        return usuarioDao.crear(usuario);
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
