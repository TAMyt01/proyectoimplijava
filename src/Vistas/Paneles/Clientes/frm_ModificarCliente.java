/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas.Paneles.Clientes;

import Controladores.ctrlClientes;
import Modelos.clsClientes;
import Formatos.formato_Telefono;

import Vistas.Paneles.jpanelClientes;
import java.awt.Frame;


import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author JManu
 */
public class frm_ModificarCliente extends javax.swing.JDialog {

    /**
     * Creates new form frm_ModificarCliente
     */
    private static jpanelClientes panelcliente;

    public static void SetPanelModif(jpanelClientes panel) {
        panelcliente = panel; // Asignar la referencia del panel
    }

    public frm_ModificarCliente(Frame parent) {
        super(parent, "Modificar Cliente", true);
        initComponents();
        setLocationRelativeTo(parent);
        ((AbstractDocument) txtTelefono.getDocument()).setDocumentFilter(new formato_Telefono(txtTelefono));

    }

    public void RecibirDatos(String nomb, String tel, String direc, String est, String id) {
        txtNombre.setText(nomb);
        txtTelefono.setText(tel);
        txtDirec.setText(direc);

        if ("Activo".equals(est)) 
            cmbEstado.setSelectedIndex(0);
        else 
            cmbEstado.setSelectedIndex(1);
        
        txtIdentidad.setText(id);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbEstadi = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtDirec = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        cmbEstadi.setBackground(new java.awt.Color(51, 136, 191));
        cmbEstadi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setText("Modificar Cliente");
        cmbEstadi.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 6, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        cmbEstadi.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 206, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Nombre");
        cmbEstadi.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Telefono");
        cmbEstadi.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        cmbEstadi.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 206, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Estado");
        cmbEstadi.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        txtDirec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirecKeyTyped(evt);
            }
        });
        cmbEstadi.add(txtDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 206, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        cmbEstadi.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        cmbEstadi.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Identidad");
        cmbEstadi.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        txtIdentidad.setEnabled(false);
        txtIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyReleased(evt);
            }
        });
        cmbEstadi.add(txtIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 210, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Direccion");
        cmbEstadi.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivado" }));
        cmbEstadi.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbEstadi, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbEstadi, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty() || txtIdentidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos necesarios");
        } else {
            String telefono = txtTelefono.getText().trim();
            if (!validarTelefono(telefono)) {
                JOptionPane.showMessageDialog(this, "El número de teléfono no es válido.");
                return;
            }

            ctrlClientes ctrlclient = new ctrlClientes();

            clsClientes client = new clsClientes();
            client.setNombre(txtNombre.getText());
            client.setIdentidad(txtIdentidad.getText());
            client.setEstado(cmbEstado.getSelectedItem().toString());
            client.setTelefono(txtTelefono.getText());
            client.setDireccion(txtDirec.getText());

            if (ctrlclient.modificar()) {
                JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                panelcliente.cargaTablaCategoria();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al Modificar Producto");
            }
            this.dispose();

        }


    }//GEN-LAST:event_btnGuardarActionPerformed
    public boolean validarTelefono(String telefono) {
        if (telefono == null) {
            return false;
        }

        // Verifica el patrón: 8 dígitos en formato XXXX-XXXX
        return telefono.matches("^\\d{4}-\\d{4}$");
    }
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyReleased
        String texto = txtIdentidad.getText();
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
            System.out.println("ERROR dato no valido ");
            txtIdentidad.setText("");
        }
    }//GEN-LAST:event_txtIdentidadKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        // TODO add your handling code here:
        if (txtTelefono.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtDirecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecKeyTyped
        // TODO add your handling code here:
        if (txtDirec.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDirecKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel cmbEstadi;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JTextField txtDirec;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
