/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.clsConexion;
import Controladores.ctrlUsuarios;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import Modelos.Usuario;


import Formato.IdentidadFilter;
import javax.swing.text.AbstractDocument;




public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        this.setTitle("Login");
        this.setSize(new Dimension(1020, 640));
        this.setLocationRelativeTo(null);
        this.setFocusable(true);//para que no me haga focus a los txt
        System.out.println("" + clsConexion.conectar()); //Validamos si se conecta a la base
        ((AbstractDocument) txtIdentidad.getDocument()).setDocumentFilter(new IdentidadFilter(txtIdentidad));


        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        PanelLogin = new javax.swing.JPanel();
        placeholderPassword = new javax.swing.JLabel();
        placeholderUser = new javax.swing.JLabel();
        labelIngresarSistema = new javax.swing.JLabel();
        txtIdentidad = new javax.swing.JTextField();
        btnInicio = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        ErrorPassword = new javax.swing.JLabel();
        ErrorUser1 = new javax.swing.JLabel();
        chkMostrar = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        setSize(new java.awt.Dimension(0, 0));
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(3, 13, 22));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        PanelLogin.setBackground(new java.awt.Color(255, 255, 255));
        PanelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        placeholderPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        placeholderPassword.setForeground(new java.awt.Color(235, 234, 234));
        placeholderPassword.setText("Password");
        PanelLogin.add(placeholderPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));

        placeholderUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        placeholderUser.setForeground(new java.awt.Color(235, 234, 234));
        placeholderUser.setText("Identidad");
        PanelLogin.add(placeholderUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        labelIngresarSistema.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelIngresarSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIngresarSistema.setText("Ingresar al sistema");
        labelIngresarSistema.setToolTipText("");
        PanelLogin.add(labelIngresarSistema, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 613, -1));

        txtIdentidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtIdentidad.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdentidadFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdentidadFocusLost(evt);
            }
        });
        txtIdentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdentidadActionPerformed(evt);
            }
        });
        txtIdentidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIdentidadKeyReleased(evt);
            }
        });
        PanelLogin.add(txtIdentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 613, 39));

        btnInicio.setBackground(new java.awt.Color(73, 142, 190));
        btnInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Ingresar");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });
        PanelLogin.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 613, 38));

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPasswordFocusLost(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        PanelLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 613, 39));

        ErrorPassword.setForeground(new java.awt.Color(255, 0, 0));
        ErrorPassword.setText(" ");
        PanelLogin.add(ErrorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 13, -1));

        ErrorUser1.setForeground(new java.awt.Color(255, 0, 0));
        ErrorUser1.setText(" ");
        PanelLogin.add(ErrorUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 13, -1));

        chkMostrar.setText("Mostrar contraseña");
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });
        PanelLogin.add(chkMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Contraseña");
        PanelLogin.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Identidad");
        PanelLogin.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\kenne\\Desktop\\5_26_225\\5_26_225\\PuntoVenta\\img\\log.jpg")); // NOI18N
        PanelLogin.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 33;
        gridBagConstraints.ipady = 23;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(180, 160, 149, 164);
        jPanel2.add(PanelLogin, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusLost

        if (txtPassword.getText().isEmpty())
            placeholderPassword.setText("Password");
    }//GEN-LAST:event_txtPasswordFocusLost

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained

        placeholderPassword.setText(" ");
       txtPassword.selectAll();

    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtIdentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdentidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdentidadActionPerformed

    private void txtIdentidadFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentidadFocusLost

        if (txtIdentidad.getText().isEmpty()) {
            placeholderUser.setText("Identidad");
        }

    }//GEN-LAST:event_txtIdentidadFocusLost

    private void txtIdentidadFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdentidadFocusGained

        placeholderUser.setText(" ");
        txtIdentidad.selectAll();
        
    }//GEN-LAST:event_txtIdentidadFocusGained

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:

    }//GEN-LAST:event_formComponentResized

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed

        this.login();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void login() {

        if (txtIdentidad.getText().isEmpty() || txtPassword.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            ErrorUser1.setText(txtIdentidad.getText().isEmpty() ? "*" : " "); //Es un if de manera simplificada es decir si esta vacio muestra el "*" sino es " "
            ErrorPassword.setText(txtPassword.getText().isEmpty() ? "*" : " ");//Lo mismo que arriba
        } else {

            ctrlUsuarios controlUsuario = new ctrlUsuarios();
            Usuario.setIdUsuario(txtIdentidad.getText());
            Usuario.setContrasenia(txtPassword.getText());
            Usuario.setEnUso(txtIdentidad.getText());

            
            if (controlUsuario.loginUser()) {
                
                
                if (controlUsuario.IdentificadorRol().equals("Gerente")) {
                Menu_Gerente InicioGerente = new Menu_Gerente();
                InicioGerente.setVisible(true);
                this.dispose();
                
                } else if (controlUsuario.IdentificadorRol().equals("Vendedor")) {
                    Menu_Vendedor InicioVendedor = new Menu_Vendedor();
              
                InicioVendedor.setVisible(true);
                this.dispose();
                }
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrecta");
            }

        }
    }

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded


    }//GEN-LAST:event_formComponentAdded

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved

    }//GEN-LAST:event_formComponentRemoved

    private void txtIdentidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //Preuntamos si preciona enter
            txtPassword.grabFocus(); // redireccionamos al password
        }
    }//GEN-LAST:event_txtIdentidadKeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //Preuntamos si preciona enter
            this.login(); // redireccionamos al password
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        if (chkMostrar.isSelected()) {
            txtPassword.setEchoChar((char) 0);
        } else {
            txtPassword.setEchoChar('*');
        }
    }//GEN-LAST:event_chkMostrarActionPerformed

    private void txtIdentidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdentidadKeyReleased
        
    }//GEN-LAST:event_txtIdentidadKeyReleased

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorPassword;
    private javax.swing.JLabel ErrorUser1;
    private javax.swing.JPanel PanelLogin;
    private javax.swing.JButton btnInicio;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelIngresarSistema;
    private javax.swing.JLabel placeholderPassword;
    private javax.swing.JLabel placeholderUser;
    private javax.swing.JTextField txtIdentidad;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
