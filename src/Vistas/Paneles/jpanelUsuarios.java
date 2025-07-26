/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Paneles;

import Conexion.clsConexion;
import Controladores.ctrlUsuarios;

import Vistas.Paneles.Usuario.frm_AgregarUsuario;
import Vistas.Paneles.Usuario.frm_ModificarUsuario;
import java.awt.Frame;
import java.awt.Window;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

public class jpanelUsuarios extends javax.swing.JPanel {

    public jpanelUsuarios() {
        initComponents();
        
        this.cargaTablaUser();
        frm_AgregarUsuario.SetPanelagregar(this);
    }

    private frm_ModificarUsuario modf;
    private frm_AgregarUsuario agreg;
    private String nombre, rol, correo, est, ID;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btn_AgregarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUser = new javax.swing.JTable();
        btnModif = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        cmbFiltro = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Usuarios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Buscar");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        btn_AgregarUsuario.setBackground(new java.awt.Color(55, 116, 209));
        btn_AgregarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_AgregarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btn_AgregarUsuario.setText("Agregar Usuario");
        btn_AgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AgregarUsuarioActionPerformed(evt);
            }
        });

        tablaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Rol", "Estado", "Ultima modificacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaUser.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablaUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaUserMousePressed(evt);
            }
        });
        tablaUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablaUserKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tablaUser);
        if (tablaUser.getColumnModel().getColumnCount() > 0) {
            tablaUser.getColumnModel().getColumn(0).setResizable(false);
            tablaUser.getColumnModel().getColumn(0).setPreferredWidth(300);
            tablaUser.getColumnModel().getColumn(1).setResizable(false);
            tablaUser.getColumnModel().getColumn(1).setPreferredWidth(150);
            tablaUser.getColumnModel().getColumn(2).setResizable(false);
            tablaUser.getColumnModel().getColumn(2).setPreferredWidth(120);
            tablaUser.getColumnModel().getColumn(3).setResizable(false);
            tablaUser.getColumnModel().getColumn(3).setPreferredWidth(70);
            tablaUser.getColumnModel().getColumn(4).setResizable(false);
            tablaUser.getColumnModel().getColumn(4).setPreferredWidth(180);
        }

        btnModif.setBackground(new java.awt.Color(55, 116, 209));
        btnModif.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModif.setForeground(new java.awt.Color(255, 255, 255));
        btnModif.setText("Modificar Usuario");
        btnModif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifActionPerformed(evt);
            }
        });

        jLabel3.setText("Mostrar Usuarios:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activas", "Desactivadas", "Todos" }));
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });

        cmbFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_AgregarUsuario)
                        .addGap(12, 12, 12)
                        .addComponent(btnModif))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 788, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addComponent(cmbFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_AgregarUsuario)
                    .addComponent(btnModif))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AgregarUsuarioActionPerformed
        if (agreg == null || !agreg.isVisible()) {
            Window ventanaPadre = SwingUtilities.getWindowAncestor(this);
            if (ventanaPadre instanceof Frame) {
                agreg = new frm_AgregarUsuario((Frame) ventanaPadre);
                agreg.setVisible(true);
            } else 
                JOptionPane.showMessageDialog(this, "No se encontró la ventana principal.");
            
        } else 
            JOptionPane.showMessageDialog(this, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        
    }//GEN-LAST:event_btn_AgregarUsuarioActionPerformed

    private void btnModifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifActionPerformed

        int filaSeleccionada = tablaUser.getSelectedRow();
        if (filaSeleccionada == -1) 
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para modificar");
        else if (modf == null || !modf.isVisible()) {
            ID = tablaUser.getValueAt(filaSeleccionada, 0).toString();
            nombre = tablaUser.getValueAt(filaSeleccionada, 1).toString();
            correo = new ctrlUsuarios().obtenerCorreoPorID(ID);
            rol = tablaUser.getValueAt(filaSeleccionada, 2).toString();
            est = tablaUser.getValueAt(filaSeleccionada, 3).toString();

            Window ventanaPadre = SwingUtilities.getWindowAncestor(this);
            if (ventanaPadre instanceof Frame) {
                modf = new frm_ModificarUsuario((Frame) ventanaPadre);
                modf.SetPanelModif(this);
                modf.RecibirDatos(nombre, rol, est, ID);
                modf.setVisible(true);
            } else 
                JOptionPane.showMessageDialog(this, "No se pudo identificar la ventana principal.");
            
        } else 
            JOptionPane.showMessageDialog(this, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        
    }//GEN-LAST:event_btnModifActionPerformed

    private void tablaUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaUserKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaUserKeyReleased

    private void tablaUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaUserMousePressed
        int seleccion = tablaUser.rowAtPoint(evt.getPoint());
        ID = tablaUser.getValueAt(seleccion, 0).toString();
        nombre = String.valueOf(tablaUser.getValueAt(seleccion, 1));
        rol = String.valueOf(tablaUser.getValueAt(seleccion, 2));
        est = String.valueOf(tablaUser.getValueAt(seleccion, 3));
    }//GEN-LAST:event_tablaUserMousePressed

    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        cargaTablaUser();
    }//GEN-LAST:event_cmbEstadoActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        Connection cn = clsConexion.conectar();
        String SQL;
        if ("ID".equals(cmbFiltro.getSelectedItem().toString())) {

            SQL = switch (cmbEstado.getSelectedIndex()) {
                case 0 -> "select * from vista_usuarios_sin_password where idUsuario = ? and estado='Activo'";
                case 1 -> "select * from vista_usuarios_sin_password where idUsuario = ? and estado='Desactivado'";
                default -> "select * from vista_usuarios_sin_password where idUsuario = ?";
            };

        } else {

            SQL = switch (cmbEstado.getSelectedIndex()) {
                case 0 -> "select * from vista_usuarios_sin_password where nombre like ? and estado='Activo'";
                case 1 -> "select * from vista_usuarios_sin_password where nombre like ? and estado='Desactivado'";
                default -> "select * from vista_usuarios_sin_password where nombre like ?";
            };
        }

        try {
            if (txtBuscar.getText().isEmpty()) {
                this.cargaTablaUser();
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

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
        if (txtBuscar.getText().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    public void cargaTablaUser() {
        Connection cn = clsConexion.conectar();
        String sql;

        sql = switch (cmbEstado.getSelectedIndex()) {
            case 0 -> "select * from vista_usuarios_sin_password where estado='Activo'";
            case 1 -> "select * from vista_usuarios_sin_password where estado='Desactivado'";
            default -> "select * from vista_usuarios_sin_password";
        };

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
        DefaultTableModel model = (DefaultTableModel) tablaUser.getModel();  // Obtenemos el modelo de la tabla para manipular los datos
        model.setRowCount(0); // Limpia la tabla antes de actualizar
        while (rs.next()) {
            Object fila[] = new Object[5];
            for (int i = 0; i < 5; i++) {
                fila[i] = rs.getObject(i + 1);
            }
            model.addRow(fila);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModif;
    private javax.swing.JButton btn_AgregarUsuario;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUser;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
