/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas.Paneles.Usuario;

import Controladores.ctrlUsuarios;

import Modelos.clsUsuario;
import Vistas.Paneles.jpanelUsuarios;
import Formatos.formato_Identidad;
import Formatos.formato_Password;
import Formatos.validar_Password;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;


/**
 *
 * @author JManu
 */
public class frm_ActualizarUsuario extends javax.swing.JFrame {

    ctrlUsuarios cont = new ctrlUsuarios();
    private boolean ModifContra = false;

    public frm_ActualizarUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);

        imgAdvertencia.setVisible(false);
        imgAdvertencia.setToolTipText("<html>"
                + "<b>Requisitos de la contraseña:</b><br>"
                + "- 8-16 caracteres<br>"
                + "- Al menos 1 mayúscula<br>"
                + "- Al menos 1 minúscula<br>"
                + "- Al menos 1 número<br>"
                + "- Al menos 1 símbolo permitido (@#$%^&+=!_*-)<br>"
                + "- Sin espacios"
                + "</html>");

        //Filtro identidad
        ((AbstractDocument) txtIdentidad.getDocument()).setDocumentFilter(new formato_Identidad(txtIdentidad));

        // Aplicar filtro para contraseña
        ((AbstractDocument) txtPassword.getDocument()).setDocumentFilter(new formato_Password());
         ((AbstractDocument) txtPasswordRepet.getDocument()).setDocumentFilter(new formato_Password());
        
        imgAdvertencia.setVisible(false);

        btnCambio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activarValidacionDePassword(); // Activa el DocumentListener
            }
        });

    }

    private void activarValidacionDePassword() {
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                actualizar();
            }

            public void removeUpdate(DocumentEvent e) {
                actualizar();
            }

            public void changedUpdate(DocumentEvent e) {
                actualizar();
            }

            private void actualizar() {
                String pass = new String(txtPassword.getPassword());

                if (validar_Password.validarPassword(pass)) {
                    txtPassword.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 128, 0), 2)); // Verde
                    imgAdvertencia.setVisible(false);
                    txtPassword.setToolTipText(null); // Quitar tooltip si es válido
                } else {
                    txtPassword.setBorder(BorderFactory.createLineBorder(new java.awt.Color(174, 0, 0), 2)); // Rojo
                    imgAdvertencia.setVisible(true);
                    txtPassword.setToolTipText("<html>La contraseña debe tener:<br>"
                            + "- 8-16 caracteres<br>"
                            + "- Al menos 1 mayúscula<br>"
                            + "- Al menos 1 minúscula<br>"
                            + "- Al menos 1 número<br>"
                            + "- Al menos 1 símbolo permitido (@#$%^&+=!_*-)<br>"
                            + "- Sin espacios</html>");
                }
            }
        });
    }

    private jpanelUsuarios paneluser;

    public void SetPanelModif(jpanelUsuarios panel) {
        paneluser = panel; // Asignar la referencia del panel
    }

    /**
     *
     * @param nom
     * @param correo
     * @param est
     * @param ID
     */
    public void RecibirDatos(String nom, String correo, String est, String ID) {
        txtNombre.setText(nom);

        if (est.equals("Activo")) {
            cmbEstado.setSelectedIndex(0);
        } else {
            cmbEstado.setSelectedIndex(1);
        }
        txt_Correo.setText(correo);
        txtIdentidad.setText(ID);

        ctrlUsuarios ctrlUser = new ctrlUsuarios();

        txtPassword.setText(cont.obtenerPasswordModif(txtIdentidad.getText()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cmbEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        chkMostrar = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        txtPasswordRepet = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        imgAdvertencia = new javax.swing.JLabel();
        btnCambio = new javax.swing.JButton();
        lbl_Correo = new javax.swing.JLabel();
        txt_Correo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 136, 191));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Modificar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 270, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        txtPassword.setEnabled(false);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 270, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivado" }));
        cmbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbEstadoMousePressed(evt);
            }
        });
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        jLabel8.setText("Estado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        txtIdentidad.setEnabled(false);
        jPanel1.add(txtIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 270, -1));

        jLabel5.setText("Identidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        chkMostrar.setText("Mostrar contraseña");
        chkMostrar.setEnabled(false);
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(chkMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, -1, -1));

        txtPasswordRepet.setEnabled(false);
        txtPasswordRepet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordRepetKeyTyped(evt);
            }
        });
        jPanel1.add(txtPasswordRepet, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 270, -1));

        jLabel6.setText("Repetir Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        imgAdvertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        jPanel1.add(imgAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        btnCambio.setText("Cambiar Contraseña");
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, -1));

        lbl_Correo.setText("Correo Electrónico:");
        jPanel1.add(lbl_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        txt_Correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_CorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtNombre.getText().isEmpty() || txtPassword.getText().isEmpty()) 
            JOptionPane.showMessageDialog(null, "rellene todos los campos");
        else {

            String password = new String(txtPassword.getPassword());

            if (ModifContra) {
                if (!validarPassword(password)) {
                    JOptionPane.showMessageDialog(this, "La contraseña no cumple con los requisitos.");
                    return;
                }
            }

            if (txtPassword.getText().equals(txtPasswordRepet.getText()) || !ModifContra) {
                ctrlUsuarios controlUsuario = new ctrlUsuarios();

                clsUsuario user = new clsUsuario();
                user.setIdUsuario(txtIdentidad.getText());
                user.setNombre(txtNombre.getText());
                user.setCorreo(txt_Correo.getText());
                
                user.setContrasenia(txtPassword.getText());
                user.setEstado(cmbEstado.getSelectedItem().toString());

                if (controlUsuario.modificar()) {
                    JOptionPane.showMessageDialog(null, "Registro modificado");
                    paneluser.cargaTablaUser();//Actualizamos tabla del panel principal de la categoria
                } else 
                    JOptionPane.showMessageDialog(null, "Error al Modificar");
                

                txtNombre.setText("");
                txtPassword.setText("");
                
                this.dispose();

            }else
                JOptionPane.showMessageDialog(null, "La contraseña no coenciden");
            
        }


    }//GEN-LAST:event_btnGuardarActionPerformed
    public boolean validarPassword(String password) {
        if (password == null) 
            return false;
        
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!_\\*-])[A-Za-z\\d@#$%^&+=!_\\*-]{8,16}$");
    }
    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        if (chkMostrar.isSelected()) 
            txtPassword.setEchoChar((char) 0);
        else 
            txtPassword.setEchoChar('*');
        
    }//GEN-LAST:event_chkMostrarActionPerformed

    private void cmbEstadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEstadoMousePressed
        
    }//GEN-LAST:event_cmbEstadoMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
            "Ingresa la contraseña de usuario para continuar:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(
                null,
                message,
                "Confirmar cierre de sesión",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            String codigoIngresado = new String(passwordField.getPassword());

            if (cont.obtenerPassword().equals(codigoIngresado)) {
                System.out.println("Contraseña valida");
                ModifContra = true;
                txtPassword.setEnabled(true);
                txtPasswordRepet.setEnabled(true);
                chkMostrar.setEnabled(true);
                btnCambio.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Contraseña incorrecta.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        } else 
            System.out.println("Cancelado por el usuario.");
        


    }//GEN-LAST:event_btnCambioActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txt_CorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_CorreoKeyTyped
        // TODO add your handling code here:
        /*if (txtCorreo.getText().length() >= 100) {
            evt.consume();
        }*/
    }//GEN-LAST:event_txt_CorreoKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:
        if (txtPassword.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtPasswordRepetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordRepetKeyTyped
        // TODO add your handling code here:
        if (txtPasswordRepet.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPasswordRepetKeyTyped

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
            java.util.logging.Logger.getLogger(frm_ActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frm_ActualizarUsuario().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambio;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel imgAdvertencia;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Correo;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordRepet;
    private javax.swing.JTextField txt_Correo;
    // End of variables declaration//GEN-END:variables

    public void RecibirDatos(String nombre, String rol, String correo, String est, String ID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
