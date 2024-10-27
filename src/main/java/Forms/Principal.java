
package Forms;

import controlador.cUsuario;
import vista.LoginFrm;

public class Principal {
    public static void main(String[] args) {
        // Crea la vista de Login
        LoginFrm vista = new LoginFrm();
        // Crea el controlador y pasa la vista
        cUsuario controlador = new cUsuario(vista);
        // Inicializa la vista (esto se hace en el constructor de LoginFrm)
        vista.setVisible(true);
    }
}
