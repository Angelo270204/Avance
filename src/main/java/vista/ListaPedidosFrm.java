
package vista;

public class ListaPedidosFrm extends javax.swing.JFrame {

    public ListaPedidosFrm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        btnAggPedido = new javax.swing.JButton();
        cmbPedidos = new javax.swing.JComboBox<>();
        btnBuscarPedido = new javax.swing.JButton();
        txtBuscarPedido = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnEditarPedido = new javax.swing.JButton();
        btnEliminarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 1, 16)); // NOI18N
        jLabel5.setText("LISTA DE PEDIDOS");

        btnAggPedido.setFont(new java.awt.Font("Gill Sans MT", 0, 16)); // NOI18N
        btnAggPedido.setText("Agregar Pedido");
        btnAggPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggPedidoActionPerformed(evt);
            }
        });

        cmbPedidos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        cmbPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtrar Por" }));

        btnBuscarPedido.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnBuscarPedido.setText("Buscar");

        jLabel6.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel6.setText("Buscar:");

        tblPedidos.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Proveedor", "Cantidad", "Precio de compra", "Fecha de compra"
            }
        ));
        jScrollPane3.setViewportView(tblPedidos);
        if (tblPedidos.getColumnModel().getColumnCount() > 0) {
            tblPedidos.getColumnModel().getColumn(0).setMinWidth(45);
            tblPedidos.getColumnModel().getColumn(0).setPreferredWidth(45);
            tblPedidos.getColumnModel().getColumn(0).setMaxWidth(45);
            tblPedidos.getColumnModel().getColumn(3).setMinWidth(90);
            tblPedidos.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblPedidos.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        btnEditarPedido.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnEditarPedido.setText("Editar");

        btnEliminarPedido.setFont(new java.awt.Font("Gill Sans MT", 0, 14)); // NOI18N
        btnEliminarPedido.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(btnEditarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(17, 17, 17)
                                .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(btnBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(cmbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(606, 606, 606)
                        .addComponent(btnAggPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnAggPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnBuscarPedido)
                    .addComponent(cmbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarPedido)
                    .addComponent(btnEliminarPedido))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggPedidoActionPerformed
        AgrPedido agrPedido = new AgrPedido();
        this.dispose();
        agrPedido.setVisible(true);
    }//GEN-LAST:event_btnAggPedidoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        MainFRM main=new MainFRM();
        main.setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAggPedido;
    private javax.swing.JButton btnBuscarPedido;
    private javax.swing.JButton btnEditarPedido;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JComboBox<String> cmbPedidos;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtBuscarPedido;
    // End of variables declaration//GEN-END:variables
}
