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
import java.awt.Frame;
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
public class frm_ModificarUsuario extends javax.swing.JDialog {

    ctrlUsuarios cont = new ctrlUsuarios();
    private boolean ModifContra = false;

    public frm_ModificarUsuario(Frame parent) {
        super(parent, "Modificar Usuario", true);
        initComponents();
        setLocationRelativeTo(parent);
        
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

        btnCambioContra.addActionListener(new ActionListener() {
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
     * @param rol
     * @param est
     * @param ID
     */
    public void RecibirDatos(String nom, String rol, String est, String ID) {
        txtNombre.setText(nom);
        
        if ("Gerente".equalsIgnoreCase(rol)) {
            cmb_Rol.addItem("Gerente");
            cmb_Rol.addItem("Vendedor");
        } else {
            cmb_Rol.addItem("Vendedor");
            cmb_Rol.addItem("Gerente");
        }
        cmb_Rol.setSelectedItem(rol);

        txtIdentidad.setText(ID);

        ctrlUsuarios ctrlUser = new ctrlUsuarios();

        txtCorreo.setText(ctrlUser.obtenerCorreoPorID(ID));

        if ("Activo".equals(est)) 
            cmbEstado.setSelectedIndex(0);
        else 
            cmbEstado.setSelectedIndex(1);

        txtPassword.setText(ctrlUser.obtenerPasswordModif(ID));
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
        btnRegresar = new javax.swing.JButton();
        txtPasswordRepet = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        imgAdvertencia = new javax.swing.JLabel();
        btnCambioContra = new javax.swing.JButton();
        lbl_Correo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cmb_Rol = new javax.swing.JComboBox<>();
        lbl_Rol = new javax.swing.JLabel();

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
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 360, -1, -1));

        jLabel4.setText("Contraseña");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        txtPassword.setEnabled(false);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 270, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivado" }));
        cmbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbEstadoMousePressed(evt);
            }
        });
        cmbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jLabel8.setText("Estado");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        txtIdentidad.setEditable(false);
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
        jPanel1.add(chkMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        txtPasswordRepet.setEnabled(false);
        txtPasswordRepet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordRepetKeyTyped(evt);
            }
        });
        jPanel1.add(txtPasswordRepet, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 270, -1));

        jLabel6.setText("Repetir Contraseña");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        imgAdvertencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/advertencia.png"))); // NOI18N
        jPanel1.add(imgAdvertencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, -1));

        btnCambioContra.setText("Cambiar Contraseña");
        btnCambioContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioContraActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambioContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        lbl_Correo.setText("Correo Electrónico:");
        jPanel1.add(lbl_Correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        jPanel1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 270, -1));

        cmb_Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Vendedor" }));
        cmb_Rol.setEnabled(false);
        jPanel1.add(cmb_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 90, -1));

        lbl_Rol.setText("Rol:");
        jPanel1.add(lbl_Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

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
        if (txtNombre.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtPassword.getPassword().length == 0 || txtPasswordRepet.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos requeridos.");
            return;
        }

        String password = new String(txtPassword.getPassword());
        String repetirPassword = new String(txtPasswordRepet.getPassword());

        // Si se activó el cambio de contraseña, se valida
        if (ModifContra && !validarPassword(password)) {
            JOptionPane.showMessageDialog(this, "La contraseña no cumple con los requisitos.");
            return;
        }

        // Validar que las contraseñas coincidan
        if (!password.equals(repetirPassword) && ModifContra) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden.");
            return;
        }

        // Crear el usuario
        clsUsuario user = new clsUsuario();
        user.setIdUsuario(txtIdentidad.getText());
        user.setNombre(txtNombre.getText());
        user.setCorreo(txtCorreo.getText());
        user.setContrasenia(password); // ya validado
        user.setRol(cmb_Rol.getSelectedItem().toString());
        user.setEstado(cmbEstado.getSelectedItem().toString());

        ctrlUsuarios control = new ctrlUsuarios();
        control.setIdUsuario(txtIdentidad.getText());
        control.setNombre(txtNombre.getText());
        control.setCorreo(txtCorreo.getText());
        control.setContrasenia(txtPassword.getText());
        control.setRol(cmb_Rol.getSelectedItem().toString());
        control.setEstado(cmbEstado.getSelectedItem().toString());


        if (control.modificar()) {
            JOptionPane.showMessageDialog(this, "Usuario modificado correctamente.");
            paneluser.cargaTablaUser(); // Recarga la tabla principal
            this.dispose(); // Cierra el formulario
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar el usuario.");
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCambioContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioContraActionPerformed
        JPasswordField passwordField = new JPasswordField();
        Object[] message = {
            "Ingresa la contraseña de usuario para continuar:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(
                null,
                message,
                "Confirmar cambio de contraseña",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (option == JOptionPane.OK_OPTION) {
            String codigoIngresado = new String(passwordField.getPassword()).trim();

            ctrlUsuarios cont = new ctrlUsuarios();
            cont.setEnUso(txtIdentidad.getText()); // Asegura que el ID esté asignado

            String passwordBD = cont.obtenerPassword().trim();

            if (codigoIngresado.equals(passwordBD)) {
                System.out.println("Contraseña válida");
                ModifContra = true;

                txtPassword.setEnabled(true);
                txtPasswordRepet.setEnabled(true);
                chkMostrar.setEnabled(true);
                btnCambioContra.setVisible(false);
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
        
    }//GEN-LAST:event_btnCambioContraActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        if (txtNombre.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
        if (txtCorreo.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

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
    
    private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

    /* Create and display the form */
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambioContra;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmb_Rol;
    private javax.swing.JLabel imgAdvertencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Correo;
    private javax.swing.JLabel lbl_Rol;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JPasswordField txtPasswordRepet;
    // End of variables declaration//GEN-END:variables


}
