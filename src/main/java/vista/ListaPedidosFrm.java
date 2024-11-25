package vista;

import controlador.cOrdenCompra;
import modelo.OrdenCompra;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ListaPedidosFrm extends javax.swing.JFrame {

    private final cOrdenCompra controlador;
    private DefaultTableModel modelo;

    public ListaPedidosFrm() {
        initComponents();
        setLocationRelativeTo(null);
        controlador = new cOrdenCompra();
        modelo = (DefaultTableModel) tblPedidos.getModel();
        llenarTabla();
    }

    private void llenarTabla() {
        List<OrdenCompra> pedidos = controlador.obtenerOrdenesCompra();
        modelo.setRowCount(0); // Limpiar la tabla
        for (OrdenCompra pedido : pedidos) {
            modelo.addRow(new Object[]{
                pedido.getIdOrden(),
                pedido.getProducto().getIdProducto(),
                pedido.getProveedor().getIdProveedor(),
                pedido.getCantidad(),
                pedido.getPrecioCompra(),
                pedido.getFechaCompra()
            });
        }
    }

    private void buscarPedido(String nombre) {
        List<OrdenCompra> pedidos = controlador.buscarPedidos(nombre);
        modelo.setRowCount(0); // Limpiar la tabla
        for (OrdenCompra pedido : pedidos) {
            modelo.addRow(new Object[]{
                pedido.getIdOrden(),
                pedido.getProducto().getIdProducto(),
                pedido.getProveedor().getIdProveedor(),
                pedido.getCantidad(),
                pedido.getPrecioCompra(),
                pedido.getFechaCompra()
            });
        }
    }

    private void editarPedido(int idPedido, OrdenCompra nuevoPedido) {
        boolean exito = controlador.actualizarOrdenCompra(nuevoPedido);
        if (exito) {
            llenarTabla();
            JOptionPane.showMessageDialog(this, "Pedido editado con éxito");
        } else {
            JOptionPane.showMessageDialog(this, "Error al editar el pedido");
        }
    }

    private void eliminarPedido(int idPedido) {
        boolean exito = controlador.eliminarOrdenCompra(idPedido);
        if (exito) {
            llenarTabla();
            JOptionPane.showMessageDialog(this, "Pedido eliminado con éxito");
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el pedido");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnAggPedido = new javax.swing.JButton();
        btnBuscarPedido = new javax.swing.JButton();
        btnEditarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();
        txtBuscarPedido = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setText("Lista de Pedidos");

        btnAggPedido.setText("Agregar Pedido");
        btnAggPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggPedidoActionPerformed(evt);
            }
        });

        btnBuscarPedido.setText("Buscar");
        btnBuscarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPedidoActionPerformed(evt);
            }
        });

        btnEditarPedido.setText("Editar");
        btnEditarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPedidoActionPerformed(evt);
            }
        });

        btnEliminarPedido.setText("Eliminar");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Orden", "ID Producto", "ID Proveedor", "Cantidad", "Precio Compra", "Fecha Compra"
            }
        ));
        jScrollPane3.setViewportView(tblPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAggPedido)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPedido)
                    .addComponent(btnEditarPedido)
                    .addComponent(btnEliminarPedido))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAggPedido)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        // Acción para agregar pedido
    }

    private void btnBuscarPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        buscarPedido(txtBuscarPedido.getText());
    }

    private void btnEditarPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblPedidos.getSelectedRow();
        if (selectedRow != -1) {
            int idPedido = (int) modelo.getValueAt(selectedRow, 0);
            // Obtener los nuevos datos del pedido y crear un objeto OrdenCompra
            OrdenCompra nuevoPedido = new OrdenCompra();
            // Llenar nuevoPedido con los datos editados
            editarPedido(idPedido, nuevoPedido);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un pedido para editar");
        }
    }

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblPedidos.getSelectedRow();
        if (selectedRow != -1) {
            int idPedido = (int) modelo.getValueAt(selectedRow, 0);
            eliminarPedido(idPedido);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un pedido para eliminar");
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        // Acción al cerrar la ventana
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggPedido;
    private javax.swing.JButton btnBuscarPedido;
    private javax.swing.JButton btnEditarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscarPedido;
    // End of variables declaration//GEN-END:variables
}
