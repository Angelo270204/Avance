package controlador;

import modelo.Usuario;
import dao.UsuarioDao;
import java.sql.Connection;
import vista.LoginFrm;

public class cUsuario {
    
    private UsuarioDao usuarioDao;
    private LoginFrm vista;

    public cUsuario(LoginFrm vista) { 
        this.vista = vista;
        this.usuarioDao = new UsuarioDao();
        this.vista.setControlador(this); 
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
    
    // Método para validar credenciales
    public Usuario validarCredenciales(String username, String password) {
        // Lógica para validar credenciales usando usuarioDao
        Usuario user = usuarioDao.validarCredenciales(username, password);
        return user; // Devuelve el usuario encontrado
    }
    
    
}
