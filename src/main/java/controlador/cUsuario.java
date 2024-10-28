package controlador;

import modelo.Usuario;
import dao.UsuarioDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class cUsuario {
    
    private UsuarioDao usuarioDao;

    public cUsuario(UsuarioDao usuarioDAO) {
        this.usuarioDao = usuarioDAO;
    }

    
    
    // Método para validar credenciales
    public Usuario validarCredenciales(String username, String password) {
        // Lógica para validar credenciales usando usuarioDao
        Usuario user = usuarioDao.validarCredenciales(username, password);
        return user; // Devuelve el usuario encontrado
    }
    
    public Usuario crearUsuario(Usuario usuario) throws Exception {
        return usuarioDao.crear(usuario);
    }
    
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        return usuarioDao.actualizar(usuario);
    }
    
    public void eliminarUsuario(int idUsuario) throws Exception {
        usuarioDao.eliminar(idUsuario);
    }
    
    public Usuario buscarUsuarioPorId(int idUsuario) throws Exception {
        return usuarioDao.buscarPorId(idUsuario);
    }
    
    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioDao.listarTodos();
    }

    public Usuario buscarPorUsername(String username) throws Exception {
        return usuarioDao.buscarPorUsername(username);
    }
    
}
