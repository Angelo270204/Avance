package vista;

import controlador.cProveedor;
import dao.ProveedorDao;
import java.sql.Connection;
import java.util.List;
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
        txtBuscarPedido1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jButton1.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton1.setText("Editar");

        jButton2.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        jButton2.setText("Eliminar");

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
                        .addGap(347, 347, 347)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(17, 17, 17)
                        .addComponent(txtBuscarPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscarProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(107, 107, 107)
                        .addComponent(btnAgregarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
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
                    .addComponent(txtBuscarPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnBuscarProveedores)
                    .addComponent(cmbProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProveedorActionPerformed
        AgrProveedorFRM agrProveedor = new AgrProveedorFRM();
        agrProveedor.setVisible(true);
    }//GEN-LAST:event_btnAgregarProveedorActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProveedor;
    private javax.swing.JButton btnBuscarProveedores;
    private javax.swing.JComboBox<String> cmbProveedores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtBuscarPedido1;
    // End of variables declaration//GEN-END:variables
}
