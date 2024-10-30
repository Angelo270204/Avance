package vista;

import controlador.cProveedor;
import dao.ProveedorDao;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedor;
import util.DataSource;

public class ListaProveedores extends javax.swing.JFrame {

    // Obtener la conexión a la base de datos
    Connection conexion = DataSource.obtenerConexion();

    // Crear instancia de ProveedorDao con la conexión
    ProveedorDao proveedorDao = new ProveedorDao(conexion);

    // Crear instancia del controlador con el DAO
    cProveedor controlador = new cProveedor(proveedorDao);

    DefaultTableModel modelo;

    public ListaProveedores() {
        initComponents();
        setLocationRelativeTo(null);

        modelo = (DefaultTableModel) tblProveedores.getModel();
        llenarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        btnAgregarProveedor = new javax.swing.JButton();
        cmbProveedores = new javax.swing.JComboBox<>();
        btnBuscarProveedores = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Gill Sans MT", 1, 16)); // NOI18N
        jLabel8.setText("LISTA DE PROVEEDORES");

        btnAgregarProveedor.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnAgregarProveedor.setText("Agregar Proveedor");
        btnAgregarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProveedorActionPerformed(evt);
            }
        });

        cmbProveedores.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar Por" }));

        btnBuscarProveedores.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnBuscarProveedores.setText("Buscar");
        btnBuscarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedoresActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel7.setText("Buscar:");

        tblProveedores.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "RUC", "Correo", "Teléfono", "Dirección", "País"
            }
        ));
        tblProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblProveedores);
        if (tblProveedores.getColumnModel().getColumnCount() > 0) {
            tblProveedores.getColumnModel().getColumn(0).setMinWidth(45);
            tblProveedores.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblProveedores.getColumnModel().getColumn(0).setMaxWidth(45);
            tblProveedores.getColumnModel().getColumn(1).setMinWidth(135);
            tblProveedores.getColumnModel().getColumn(1).setPreferredWidth(135);
            tblProveedores.getColumnModel().getColumn(1).setMaxWidth(135);
            tblProveedores.getColumnModel().getColumn(2).setMinWidth(120);
            tblProveedores.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblProveedores.getColumnModel().getColumn(2).setMaxWidth(120);
            tblProveedores.getColumnModel().getColumn(4).setMinWidth(110);
            tblProveedores.getColumnModel().getColumn(4).setPreferredWidth(110);
            tblProveedores.getColumnModel().getColumn(4).setMaxWidth(110);
            tblProveedores.getColumnModel().getColumn(6).setMinWidth(110);
            tblProveedores.getColumnModel().getColumn(6).setPreferredWidth(110);
            tblProveedores.getColumnModel().getColumn(6).setMaxWidth(110);
        }

        btnEditar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(17, 17, 17)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(107, 107, 107)
                        .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(btnAgregarProveedor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnBuscarProveedores)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        AgrProveedorFRM agrProveedor = new AgrProveedorFRM();
        this.dispose();
        agrProveedor.setVisible(true);
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       MainFRM main=new MainFRM();
       main.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
       int selectedRow=tblProveedores.getSelectedRow();
       
       if(selectedRow!=-1){
           int idProveedor=(int)modelo.getValueAt(selectedRow, 0);
           controlador.eliminarProveedor(idProveedor);
           modelo.removeRow(selectedRow);
           JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente");
       }else{
           JOptionPane.showMessageDialog(this, "Seleccione un proveedor para eliminar.");
       }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        abrirVentanaEdicion();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedoresActionPerformed
        buscarProveedores();
    }//GEN-LAST:event_btnBuscarProveedoresActionPerformed

    private void llenarTabla() {

        // Obtener la lista de proveedores del controlador
        List<Proveedor> proveedores = controlador.listarProveedores();

        // Limpiar las filas existentes en la tabla
        modelo.setRowCount(0);

        // Agregar los proveedores al modelo de la tabla
        for (Proveedor p : proveedores) {
            modelo.addRow(new Object[]{
                p.getIdProveedor(),
                p.getNombre(),
                p.getRuc(),
                p.getCorreo(),
                p.getCelular(),
                p.getDireccion(),
                p.getPais()
            });
        }
    }
    
    // Método para abrir la ventana de edición con los datos del proveedor seleccionado
    private void abrirVentanaEdicion() {
        int filaSeleccionada = tblProveedores.getSelectedRow();
        if (filaSeleccionada != -1) {
            // Obtener los datos del proveedor seleccionado
            int id = (int) modelo.getValueAt(filaSeleccionada, 0);
            String nombre = (String) modelo.getValueAt(filaSeleccionada, 1);
            String ruc = (String) modelo.getValueAt(filaSeleccionada, 2);
            String correo = (String) modelo.getValueAt(filaSeleccionada, 3);
            String celular = (String) modelo.getValueAt(filaSeleccionada, 4);
            String direccion = (String) modelo.getValueAt(filaSeleccionada, 5);
            String pais = (String) modelo.getValueAt(filaSeleccionada, 6);

            // Crear el proveedor y abrir la ventana de edición
            Proveedor proveedor = new Proveedor(id, nombre, ruc, correo, celular, direccion, pais);
            EdicionProveedor ventanaEdicion = new EdicionProveedor(proveedor, this);
            ventanaEdicion.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor para editar.");
        }
    }

    // Método para actualizar la tabla después de editar un proveedor
    public void actualizarProveedorEnTabla(Proveedor proveedor) {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if ((int) modelo.getValueAt(i, 0) == proveedor.getIdProveedor()) {
                modelo.setValueAt(proveedor.getNombre(), i, 1);
                modelo.setValueAt(proveedor.getRuc(), i, 2);
                modelo.setValueAt(proveedor.getCorreo(), i, 3);
                modelo.setValueAt(proveedor.getCelular(), i, 4);
                modelo.setValueAt(proveedor.getDireccion(), i, 5);
                modelo.setValueAt(proveedor.getPais(), i, 6);
                break;
            }
        }
    }
    
    // Método para buscar y actualizar la tabla con los resultados
    private void buscarProveedores() {
        String nombre = txtBuscar.getText();
        List<Proveedor> proveedores = controlador.buscarProveedor(nombre);
        actualizarTabla(proveedores);
    }
    
    // Método para actualizar los datos en la tabla
    private void actualizarTabla(List<Proveedor> proveedores) {
        modelo.setRowCount(0);  // Limpiar la tabla
        for (Proveedor p : proveedores) {
            modelo.addRow(new Object[]{
                p.getIdProveedor(), p.getNombre(), p.getRuc(), p.getCorreo(),
                p.getCelular(), p.getDireccion(), p.getPais()
            });
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnBuscarProveedores;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
