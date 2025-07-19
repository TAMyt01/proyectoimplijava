package Vistas.Paneles;

import Conexion.clsConexion;

import Vistas.Paneles.Categoria.frm_ModificarCategoria;
import Vistas.Paneles.Categoria.frm_AgregarCategoria;

import javax.swing.JOptionPane;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;


public class jpanelCategoria extends javax.swing.JPanel {

    private frm_AgregarCategoria cate; //Declaramos cate como  formulario
    private frm_ModificarCategoria Mcate; //lo mismo que arriba
    private String ID = "", nombre = "", descripcion = "", estado = "";

    public jpanelCategoria() {
        initComponents();
        this.cargaTablaCategoria();
        frm_ModificarCategoria.SetPanelModificar(this);
        frm_AgregarCategoria.setPanelCategoria(this); //le mandamos la informacion de este panel al frmAGREGAR para que tenga acceso a los metodos publicos
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbFiltro = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCategoria = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Categoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 17, 0, 0);
        add(jLabel1, gridBagConstraints);

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activas", "Desactivadas", "Todos" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 6, 0, 0);
        add(cmbEstado, gridBagConstraints);

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "ID" }));
        cmbFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFiltroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 6, 0, 0);
        add(cmbFiltro, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(55, 116, 209));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar Categoria");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 17, 0, 0);
        add(jButton1, gridBagConstraints);

        jLabel3.setText("Mostrar categorias:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 18, 0, 0);
        add(jLabel3, gridBagConstraints);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 6, 0, 0);
        add(txtBuscar, gridBagConstraints);

        jScrollPane2.setToolTipText("");

        tablaCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Estado", "Ultima Modificacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaCategoria.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaCategoriaMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablaCategoria);
        if (tablaCategoria.getColumnModel().getColumnCount() > 0) {
            tablaCategoria.getColumnModel().getColumn(0).setResizable(false);
            tablaCategoria.getColumnModel().getColumn(0).setPreferredWidth(300);
            tablaCategoria.getColumnModel().getColumn(1).setResizable(false);
            tablaCategoria.getColumnModel().getColumn(1).setPreferredWidth(400);
            tablaCategoria.getColumnModel().getColumn(2).setResizable(false);
            tablaCategoria.getColumnModel().getColumn(2).setPreferredWidth(500);
            tablaCategoria.getColumnModel().getColumn(3).setResizable(false);
            tablaCategoria.getColumnModel().getColumn(3).setPreferredWidth(150);
            tablaCategoria.getColumnModel().getColumn(4).setResizable(false);
            tablaCategoria.getColumnModel().getColumn(4).setPreferredWidth(305);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 733;
        gridBagConstraints.ipady = 471;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 35, 45, 41);
        add(jScrollPane2, gridBagConstraints);

        btnActualizar.setBackground(new java.awt.Color(55, 116, 209));
        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Modificar categoria");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 12, 0, 0);
        add(btnActualizar, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 18, 0, 0);
        add(jLabel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (cate == null || !cate.isVisible()) {
            cate = new frm_AgregarCategoria(); //Se declara el objeto
            cate.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (ID == "") {
            JOptionPane.showMessageDialog(null, "Seleccione la categoria");
        } else if (Mcate == null || !Mcate.isVisible()) {
            Mcate = new frm_ModificarCategoria();
            Mcate.RecibirDatos(ID, nombre, descripcion, estado);
            Mcate.setVisible(true);
            //Le quitamos la asignacion de valor a las variables seleccionada por cursorr
            ID = "";
            nombre = "";
            descripcion = "";
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Connection cn = clsConexion.conectar();
        String SQL;
        if ("ID".equals(cmbFiltro.getSelectedItem().toString())) {

            switch (cmbEstado.getSelectedIndex()) {
                case 0:
                    SQL = "select * from tb_categoria where ID_categoria = ? and estado='Activo'";
                    break;
                case 1:
                    SQL = "select * from tb_categoria where ID_categoria = ? and estado='Desactivado'";
                    break;
                default:
                    SQL = "select * from tb_categoria where ID_categoria = ?";
            }

        } else {

            switch (cmbEstado.getSelectedIndex()) {
                case 0:
                    SQL = "select * from tb_categoria where nombre like ? and estado='Activo'";
                    break;
                case 1:
                    SQL = "select * from tb_categoria where nombre like ? and estado='Desactivado'";
                    break;
                default:
                    SQL = "select * from tb_categoria where nombre like ?";
            }
        }

        try {
            if (txtBuscar.getText().isEmpty()) {
                this.cargaTablaCategoria();
            } else {
                PreparedStatement consulta = cn.prepareStatement(SQL);

                if ("ID".equals(cmbFiltro.getSelectedItem().toString())) {
                    String texto = txtBuscar.getText();
                    boolean esNumero = true;

                    // Verificar si el texto contiene solo dígitos
                    for (int i = 0; i < texto.length(); i++) {
                        if (!Character.isDigit(texto.charAt(i))) {
                            esNumero = false;
                            break;
                        }
                    }
                    if (!esNumero) {
                        // Si no es un número, mostrar mensaje de error
                        System.out.println("ERROR dato no valido para ID");
                        txtBuscar.setText("");
                        return;  // Detener la ejecución del código aquí
                    }
                    consulta.setInt(1, Integer.parseInt(txtBuscar.getText()));
                } else {
                    consulta.setString(1, "%" + txtBuscar.getText() + "%");
                }

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

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        cargaTablaCategoria();
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void tablaCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCategoriaMousePressed
        int seleccion = tablaCategoria.rowAtPoint(evt.getPoint());
        ID = String.valueOf(tablaCategoria.getValueAt(seleccion, 0));
        nombre = String.valueOf(tablaCategoria.getValueAt(seleccion, 1));
        descripcion = String.valueOf(tablaCategoria.getValueAt(seleccion, 2));
        estado = String.valueOf(tablaCategoria.getValueAt(seleccion, 3));


    }//GEN-LAST:event_tablaCategoriaMousePressed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        if (txtBuscar.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCategoria;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

//Metodo para mostarar todas las categorias registradas
    public void cargaTablaCategoria() {
        Connection cn = clsConexion.conectar();
        String sql;

        if (cmbEstado.getSelectedIndex() == 0) {
            sql = "select * from tb_categoria where estado='Activo'";
        } else if (cmbEstado.getSelectedIndex() == 1) {
            sql = "select * from tb_categoria where estado='Desactivado'";
        } else {
            sql = "select * from tb_categoria";
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
        DefaultTableModel model = (DefaultTableModel) tablaCategoria.getModel();  // Obtenemos el modelo de la tabla para manipular los datos
        model.setRowCount(0); // Limpia la tabla antes de actualizar
        while (rs.next()) {
            Object fila[] = new Object[5];
            for (int i = 0; i < 5; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }

        

       

    }

}
