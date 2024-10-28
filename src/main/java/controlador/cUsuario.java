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

    // Método para listar usuarios
    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDao.listarUsuarios();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean registrarUsuario(Usuario usuario) {
    // Verificar que los campos requeridos no estén vacíos
    if (usuario.getUsername() == null || usuario.getUsername().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Usuario' no puede estar vacío.");
        return false; // Registro no exitoso
    }
    
    if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
        JOptionPane.showMessageDialog(null, "El campo 'Contraseña' no puede estar vacío.");
        return false; // Registro no exitoso
    }

    // Validar si el usuario ya existe en la base de datos
    if (usuarioDao.existeUsuario(usuario.getUsername())) {
        JOptionPane.showMessageDialog(null, "El usuario ya existe. Por favor elige otro nombre de usuario.");
        return false; // Registro no exitoso
    }

    // Si todas las validaciones pasan, registrar el usuario
    return usuarioDao.registrarUsuario(usuario);
}

    // Método para eliminar un usuario
    public void eliminarUsuario(int idUsuario) {
        try {
            usuarioDao.eliminarUsuario(idUsuario);
            System.out.println("Usuario eliminado con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para validar credenciales
    public Usuario validarCredenciales(String username, String password) {
        // Lógica para validar credenciales usando usuarioDao
        Usuario user = usuarioDao.validarCredenciales(username, password);
        return user; // Devuelve el usuario encontrado
    }
    
}
