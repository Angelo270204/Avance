package vista;

import controlador.cEmpleado;
import controlador.cRol;
import controlador.cUsuario;
import dao.UsuarioDao;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Rol;
import modelo.Usuario;
import util.DataSource;

public class RegistroFrm extends javax.swing.JFrame {

    // Lista de empleados y controlador para la gestión de empleados.
    private final List<Empleado> lstEmpleados;
    cEmpleado controlEmp = new cEmpleado(DataSource.obtenerConexion());

    // Lista de roles y controlador para la gestión de roles.
    private final List<Rol> lstRol;
    cRol controlRol = new cRol(DataSource.obtenerConexion());

    // Configuración de conexión a la base de datos.
    DataSource conexion = new DataSource();
    UsuarioDao usuarioDao = new UsuarioDao(conexion.obtenerConexion());
    cUsuario controlador = new cUsuario(usuarioDao);

    // Constructor del formulario de registro.
    public RegistroFrm() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Carga la lista de empleados y los añade al ComboBox.
        lstEmpleados = controlEmp.listarEmpleados();
        
        for (Empleado aux : lstEmpleados) {
            // Formatea la información del empleado para mostrarla en el ComboBox.
            String cat = aux.getIdEmpleado() + "|" + aux.getNombre() + "|" + aux.getApellido();
            this.cmbEmpleado.addItem(cat);
        }

        // Carga la lista de roles y los añade al ComboBox.
        lstRol = controlRol.listarRoles();

        for (Rol aux : lstRol) {
            // Formatea la información del rol para mostrarla en el ComboBox.
            String cat = aux.getId_tipo() + "|" + aux.getNombre_rol();
            this.cmbRol.addItem(cat);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbEmpleado = new javax.swing.JComboBox<>();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        cmbRol = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE USUARIO");

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel2.setText("Empleado:");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel4.setText("Contraseña:");

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jLabel5.setText("Rol:");

        btnRegistrar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbEmpleado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUsuario)
                                .addComponent(txtContraseña)
                                .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            // Validar que los campos no estén vacíos
            if (txtUsuario.getText().trim().isEmpty() || txtContraseña.getText().trim().isEmpty()
                    || cmbEmpleado.getSelectedIndex() == -1 || cmbRol.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios",
                        "Error de validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario user = new Usuario();

            // Procesar empleado seleccionado
            String empleadoSeleccionado = (String) cmbEmpleado.getSelectedItem();
            String[] partesEmpleado = empleadoSeleccionado.split("\\|");
            if (partesEmpleado.length < 3) {
                JOptionPane.showMessageDialog(this, "Error en el formato del empleado seleccionado",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear y establecer el empleado
            Empleado emp = new Empleado();
            emp.setIdEmpleado(Integer.parseInt(partesEmpleado[0].trim()));
            emp.setNombre(partesEmpleado[1].trim());
            emp.setApellido(partesEmpleado[2].trim());
            user.setEmpleado(emp);

            // Establecer username y password
            user.setUsername(txtUsuario.getText().trim());
            user.setPassword(txtContraseña.getText().trim());

            // Procesar rol seleccionado
            String rolSeleccionado = (String) cmbRol.getSelectedItem();
            String[] partesRol = rolSeleccionado.split("\\|");
            if (partesRol.length < 2) {
                JOptionPane.showMessageDialog(this, "Error en el formato del rol seleccionado",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear y establecer el rol
            Rol rol = new Rol();
            rol.setId_tipo(Integer.parseInt(partesRol[0].trim()));
            rol.setNombre_rol(partesRol[1].trim());
            user.setRol(rol);

            // Establecer la fecha de acceso como la fecha actual
            user.setFechaUltimoAcceso(new Date());

            // Intentar crear el usuario
            Usuario usuarioCreado = controlador.crearUsuario(user);

            if (usuarioCreado != null && usuarioCreado.getIdUsuario() > 0) {
                JOptionPane.showMessageDialog(this,
                        "Usuario registrado exitosamente",
                        "Registro exitoso",
                        JOptionPane.INFORMATION_MESSAGE);

                // Limpiar los campos del formulario
                limpiarCampos();

            } else {
                JOptionPane.showMessageDialog(this,
                        "No se pudo registrar el usuario",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al procesar los datos numéricos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al registrar el usuario: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtContraseña.setText("");
        cmbEmpleado.setSelectedIndex(0);
        cmbRol.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbEmpleado;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
