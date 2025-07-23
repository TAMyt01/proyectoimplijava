/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Paneles;

import Conexion.clsConexion;
import Vistas.Paneles.Producto.frm_ActualizarStock;
import Vistas.Paneles.Producto.frm_AgregarProducto;
import Vistas.Paneles.Producto.frm_ModificarProducto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author JManu
 */
public class jpanelProductos extends javax.swing.JPanel {

    /**
     * Creates new form jpanelProductos
     */
    public jpanelProductos() {
        initComponents();

        cargaTablaCategoria();
        frm_AgregarProducto.SetPanelagregar(this);
        frm_ModificarProducto.SetPanelmodf(this);
        frm_ActualizarStock.SetPanelActualizar(this);

    }

    private frm_AgregarProducto agreg;
    private frm_ModificarProducto Mprod;
    private frm_ActualizarStock ActStock;
    private String ID = "", nombre = "", descripcion = "", cate = "";
    private String estado = "";
    private double prec = 0;
    private int cant = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        btnModif = new javax.swing.JButton();
        ScrollProdc = new javax.swing.JScrollPane();
        tablaProdc = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        btnActualizarStock = new javax.swing.JButton();
        cmbFiltro = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Productos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 6, 0, 0);
        add(jLabel1, gridBagConstraints);

        btnModif.setBackground(new java.awt.Color(55, 116, 209));
        btnModif.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModif.setForeground(new java.awt.Color(255, 255, 255));
        btnModif.setText("Modificar Producto");
        btnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 6, 0, 0);
        add(btnModif, gridBagConstraints);

        tablaProdc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio venta", "Cantidad", "Categoria", "estado", "Ultima modificacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaProdc.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaProdc.setMaximumSize(new java.awt.Dimension(600, 80));
        tablaProdc.setMinimumSize(new java.awt.Dimension(600, 80));
        tablaProdc.setName(""); // NOI18N
        tablaProdc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaProdcMousePressed(evt);
            }
        });
        ScrollProdc.setViewportView(tablaProdc);
        if (tablaProdc.getColumnModel().getColumnCount() > 0) {
            tablaProdc.getColumnModel().getColumn(0).setResizable(false);
            tablaProdc.getColumnModel().getColumn(0).setPreferredWidth(150);
            tablaProdc.getColumnModel().getColumn(1).setResizable(false);
            tablaProdc.getColumnModel().getColumn(1).setPreferredWidth(300);
            tablaProdc.getColumnModel().getColumn(2).setResizable(false);
            tablaProdc.getColumnModel().getColumn(2).setPreferredWidth(500);
            tablaProdc.getColumnModel().getColumn(3).setResizable(false);
            tablaProdc.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaProdc.getColumnModel().getColumn(4).setResizable(false);
            tablaProdc.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablaProdc.getColumnModel().getColumn(5).setResizable(false);
            tablaProdc.getColumnModel().getColumn(5).setPreferredWidth(200);
            tablaProdc.getColumnModel().getColumn(6).setResizable(false);
            tablaProdc.getColumnModel().getColumn(6).setPreferredWidth(70);
            tablaProdc.getColumnModel().getColumn(7).setResizable(false);
            tablaProdc.getColumnModel().getColumn(7).setPreferredWidth(180);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 31;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 746;
        gridBagConstraints.ipady = 436;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 25, 6, 38);
        add(ScrollProdc, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 12, 0, 0);
        add(jLabel2, gridBagConstraints);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 21;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 79;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 6, 0, 0);
        add(txtBuscar, gridBagConstraints);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activas", "Desactivadas", "Todos" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 0);
        add(cmbEstado, gridBagConstraints);

        jLabel3.setText("Mostrar productos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 6, 0, 0);
        add(jLabel3, gridBagConstraints);

        btnAgregarProducto.setBackground(new java.awt.Color(55, 116, 209));
        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setText("Agregar Productos");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 0, 0, 0);
        add(btnAgregarProducto, gridBagConstraints);

        btnActualizarStock.setBackground(new java.awt.Color(55, 116, 209));
        btnActualizarStock.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizarStock.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizarStock.setText("Actualizar Stock");
        btnActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarStockActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 18, 0, 0);
        add(btnActualizarStock, gridBagConstraints);

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Categoria" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 6, 0, 0);
        add(cmbFiltro, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        if (agreg == null || !agreg.isVisible()) {
            agreg = new frm_AgregarProducto();
            agreg.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Connection cn = clsConexion.conectar();

        String where;

        switch (cmbFiltro.getSelectedItem().toString()) {
            case "ID":
                where = "WHERE p.ID_Producto LIKE ?";
                break;
            case "Nombre":
                where = "WHERE p.nombre LIKE ?";
                break;
            default:
                where = "WHERE c.nombre LIKE ?";
                break;
        }

        String SQL = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio_venta, p.cantidad, c.nombre, p.estado, p.fecha_creacion_modificacion "
                        + "FROM tb_producto p "
                        + "JOIN tb_categoria c ON p.ID_categoria = c.ID_categoria " + where;

        try {
            if (txtBuscar.getText().isEmpty()) {
                this.cargaTablaCategoria();
            } else {
                PreparedStatement consulta = cn.prepareStatement(SQL);

                consulta.setString(1, "%" + txtBuscar.getText() + "%");

                ResultSet rs = consulta.executeQuery();
                rellenarTabla(rs);
            }

        } catch (SQLException ex) {
            System.out.println("Error al buscar" + ex);
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void cmbFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFiltroActionPerformed
        txtBuscar.setText("");
        this.cargaTablaCategoria();
    }//GEN-LAST:event_cmbFiltroActionPerformed

    private void btnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifActionPerformed
        if (ID == "") {
            JOptionPane.showMessageDialog(null, "Seleccione el producto");
        } else if (Mprod == null || !Mprod.isVisible()) {
            Mprod = new frm_ModificarProducto();
            Mprod.RecibirDatos(ID, nombre, descripcion, prec, cant, cate, estado);
            Mprod.setVisible(true);
            //ID = "";
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }
    }//GEN-LAST:event_btnModifActionPerformed

    private void tablaProdcMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProdcMousePressed
        int seleccion = tablaProdc.rowAtPoint(evt.getPoint());
        ID = String.valueOf(tablaProdc.getValueAt(seleccion, 0));
        nombre = String.valueOf(tablaProdc.getValueAt(seleccion, 1));
        descripcion = String.valueOf(tablaProdc.getValueAt(seleccion, 2));
        prec = Double.parseDouble(tablaProdc.getValueAt(seleccion, 3).toString());
        cant = Integer.parseInt(tablaProdc.getValueAt(seleccion, 4).toString());
        cate = String.valueOf(tablaProdc.getValueAt(seleccion, 5));
        estado = String.valueOf(tablaProdc.getValueAt(seleccion, 6));

        System.out.println(""+estado);
        if (estado == "Activo") {
            btnActualizarStock.setEnabled(true);
        } else {
            btnActualizarStock.setEnabled(false);
        }
    }//GEN-LAST:event_tablaProdcMousePressed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        cargaTablaCategoria();
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void btnActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarStockActionPerformed
        if (ID == "") {
            JOptionPane.showMessageDialog(null, "Seleccione el producto");
        } else if (ActStock == null || !ActStock.isVisible()) {
            ActStock = new frm_ActualizarStock();
            ActStock.RecibirDatos(ID, nombre, cant);
            ActStock.setVisible(true);
            ID = "";
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }
    }//GEN-LAST:event_btnActualizarStockActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        if (txtBuscar.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrollProdc;
    private javax.swing.JButton btnActualizarStock;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnModif;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTable tablaProdc;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    public void cargaTablaCategoria() {
        Connection cn = clsConexion.conectar();
        String sql;

        switch (cmbEstado.getSelectedIndex()) {
            case 0:
                sql = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio_venta, p.cantidad, c.nombre, p.estado, p.fecha_creacion_modificacion "
                        + "FROM tb_producto p "
                        + "JOIN tb_categoria c ON p.ID_categoria = c.ID_categoria "
                        + "where p.estado = 'Activo'";
                break;
            case 1:
                sql = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio_venta, p.cantidad, c.nombre, p.estado, p.fecha_creacion_modificacion "
                        + "FROM tb_producto p "
                        + "JOIN tb_categoria c ON p.ID_categoria = c.ID_categoria "
                        + "where p.estado = 'Desactivado'";
                break;
            default:
                sql = "SELECT p.ID_Producto, p.nombre, p.descripcion, p.precio_venta, p.cantidad, c.nombre, p.estado, p.fecha_creacion_modificacion "
                        + "FROM tb_producto p "
                        + "JOIN tb_categoria c ON p.ID_categoria = c.ID_categoria";
        }

        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rellenarTabla(rs);
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error en actualizar tabla categoria" + ex);
        }

    }

    private void rellenarTabla(ResultSet rs) throws SQLException {
        DefaultTableModel model = (DefaultTableModel) tablaProdc.getModel();  // Obtenemos el modelo de la tabla para manipular los datos
        model.setRowCount(0); // Limpia la tabla antes de actualizar

        while (rs.next()) {
            Object fila[] = new Object[8];
            for (int i = 0; i < 8; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }
    }

}
