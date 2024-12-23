package vista;

import controlador.cProducto;
import modelo.Producto;
import util.DataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListaProductosFRM extends javax.swing.JFrame {

    private final cProducto controlador;
    private DefaultTableModel modelo;

    public ListaProductosFRM() {
        initComponents();
        setLocationRelativeTo(null);
        setSize(800, 600);
        controlador = new cProducto(DataSource.obtenerConexion());
        modelo = (DefaultTableModel) tblProductos.getModel();
        llenarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        cmbProductos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 16)); // NOI18N
        jLabel3.setText("LISTA DE PRODUCTOS");

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel4.setText("Buscar:");

        btnBuscar.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cmbProductos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        cmbProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar Por" }));

        tblProductos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Categoria", "Descripcion", "Stock", "Precio"
            }
        ));
        jScrollPane2.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setMinWidth(50);
            tblProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProductos.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProductos.getColumnModel().getColumn(2).setMinWidth(120);
            tblProductos.getColumnModel().getColumn(2).setPreferredWidth(120);
            tblProductos.getColumnModel().getColumn(2).setMaxWidth(120);
            tblProductos.getColumnModel().getColumn(3).setMinWidth(230);
            tblProductos.getColumnModel().getColumn(3).setPreferredWidth(230);
            tblProductos.getColumnModel().getColumn(3).setMaxWidth(230);
            tblProductos.getColumnModel().getColumn(4).setMinWidth(100);
            tblProductos.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblProductos.getColumnModel().getColumn(4).setMaxWidth(100);
            tblProductos.getColumnModel().getColumn(5).setMinWidth(100);
            tblProductos.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblProductos.getColumnModel().getColumn(5).setMaxWidth(100);
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

        btnAgregar.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel4)
                        .addGap(17, 17, 17)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnBuscar)
                    .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MainFRM main = new MainFRM();
        main.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        AgrProductoFRM agrProducto = new AgrProductoFRM();
        this.dispose();
        agrProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String nombre = txtBuscar.getText();
        List<Producto> productos = controlador.buscarProductosPorNombre(nombre);
        modelo.setRowCount(0); // Limpiar la tabla
        for (Producto producto : productos) {
            modelo.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getCantidadStock(),
                producto.getPrecio()
            });
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int selectedRow = tblProductos.getSelectedRow();
        if (selectedRow != -1) { // Verifica si hay una fila seleccionada
            int idProducto = (int) modelo.getValueAt(selectedRow, 0); // Asumiendo que el ID está en la primera columna
            boolean resultado = controlador.eliminarProducto(idProducto); // Elimina el producto de la base de datos
            if (resultado) {
                modelo.removeRow(selectedRow); // Elimina la fila de la tabla
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el producto.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
            int selectedRow = tblProductos.getSelectedRow();
            if (selectedRow != -1) {
                int idProducto = (int) modelo.getValueAt(selectedRow, 0);
                Producto producto = controlador.obtenerProducto(idProducto); // Obtener el producto por ID
                AgrProductoFRM editarProducto = new AgrProductoFRM(producto);
                this.dispose();
                editarProducto.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione un producto para editar.");
            }
    }

    public void llenarTabla() {
        // Obtener la lista de productos del controlador
        List<Producto> productos = controlador.obtenerProductos();
        modelo.setRowCount(0); // Limpiar la tabla
        for (Producto producto : productos) {
            modelo.addRow(new Object[]{
                producto.getIdProducto(),
                producto.getNombre(),
                producto.getCategoria().getNombreCategoria(), // Asegúrate de obtener el nombre de la categoría
                producto.getDescripcion(), // Agregar la descripción del producto
                producto.getCantidadStock(),
                producto.getPrecio()
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
