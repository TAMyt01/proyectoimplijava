/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas;

import Conexion.clsConexion;
import Vistas.Login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author hp
 */
public class Recuperar_Password extends javax.swing.JFrame {

    /**
     * Creates new form Recuperar_Password
     */
    public Recuperar_Password() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    public class EnviarCorreo {
        
        //ENVIAR CODIGO
        public static String generarCodigo() {
            Random rand = new Random();
            int codigo = 100000 + rand.nextInt(900000); // 6 dígitos
            return String.valueOf(codigo);
        }
    
        public static boolean enviarCorreo(String destinatario, String codigo) {
            final String remitente = "correo@gmail.com";
            final String clave = "azbc mltv xlib hcpj";//Clave de Aplicacion

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");

            // Autenticación con el correo remitente
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(remitente, clave);
                }
            });

            try {
                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(remitente));
                message.setRecipients(
                    MimeMessage.RecipientType.TO,
                    InternetAddress.parse(destinatario)
                );
                message.setSubject("Código de Verificación");
                message.setText("Tu código de verificación es: " + codigo);

                Transport.send(message);
                return true;

            } catch (MessagingException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
    
        //VALIDAR QUE EL ID DE USUARIO EXISTA
        //
        public boolean usuarioExiste(String idUsuario) {
            boolean existe = false;
            String sql = "SELECT idUsuario FROM tb_usuario WHERE idUsuario = ?";

            try (Connection cn = (Connection) clsConexion.conectar();
                 PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

                pst.setString(1, idUsuario);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) 
                    existe = true;
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return existe;
        }
        //
    
        //Obtener Correo del Usuario
        public String obtenerCorreoUsuario(String idUsuario) {
            String correo = null;
            String sql = "SELECT correo FROM tb_usuario WHERE idUsuario = ?";

            try (Connection cn = (Connection) clsConexion.conectar();
                 PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

                pst.setString(1, idUsuario);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    correo = rs.getString("correo");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return correo;
        }
        //
        
        // Método para mostrar el correo parcialmente
        private void mostrarCorreoParcial(String idUsuario) {
            String correo = obtenerCorreoUsuario(idUsuario);
            String correoParcial = null;

            if (correo != null) 
                correoParcial = correo.substring(0, 3) + "******" + correo.substring(correo.indexOf("@"));
                lblCorreo.setText(correoParcial);
            
        }
        
        
        
        
        //
        
    //private LocalDateTime fechaExpiracion;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_EnviarCodigo = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_ID_Usuario = new javax.swing.JLabel();
        txt_ID_Usuario = new javax.swing.JTextField();
        lbl_Cod_Verificacion = new javax.swing.JLabel();
        txt_Cod_Verificacion = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PuntoVenta");

        jPanel1.setEnabled(false);
        jPanel1.setName(""); // NOI18N

        btn_EnviarCodigo.setText("Enviar Código");
        btn_EnviarCodigo.setName("btn_EnviarCodigo"); // NOI18N
        btn_EnviarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EnviarCodigoActionPerformed(evt);
            }
        });

        btn_Regresar.setText("Regresar");
        btn_Regresar.setName("btnRegresar"); // NOI18N
        btn_Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Recuperación de Contraseña");

        lbl_ID_Usuario.setText("ID Usuario:");

        txt_ID_Usuario.setName("txt_IDUsuario"); // NOI18N
        txt_ID_Usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ID_UsuarioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ID_UsuarioKeyTyped(evt);
            }
        });

        lbl_Cod_Verificacion.setText("Código de Verificación:");

        txt_Cod_Verificacion.setEnabled(false);
        txt_Cod_Verificacion.setName("txt_CodigoVerificacion"); // NOI18N
        txt_Cod_Verificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Cod_VerificacionKeyTyped(evt);
            }
        });

        lblCorreo.setText("Correo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btn_EnviarCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(btn_Regresar)
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_Cod_Verificacion)
                        .addGap(21, 21, 21)
                        .addComponent(txt_Cod_Verificacion))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbl_ID_Usuario)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCorreo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txt_ID_Usuario))))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ID_Usuario)
                    .addComponent(txt_ID_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorreo)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Cod_Verificacion)
                    .addComponent(txt_Cod_Verificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_EnviarCodigo)
                    .addComponent(btn_Regresar))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ID_UsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ID_UsuarioKeyTyped
        // TODO add your handling code here:
        if (txt_ID_Usuario.getText().length() >= 15) 
            evt.consume();
        
        txt_ID_Usuario.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }//GEN-LAST:event_txt_ID_UsuarioKeyTyped

    private void txt_Cod_VerificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Cod_VerificacionKeyTyped
        // TODO add your handling code here:
        if (txt_Cod_Verificacion.getText().length() >= 6) 
            evt.consume();
        
    }//GEN-LAST:event_txt_Cod_VerificacionKeyTyped

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        // TODO add your handling code here:
        // Crear y mostrar el formulario de Login
        Login login = new Login();
        login.setVisible(true);

        // Cerrar el formulario actual
        this.dispose();
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private void btn_EnviarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EnviarCodigoActionPerformed
        // TODO add your handling code here:
        String idUsuario = txt_ID_Usuario.getText().trim();
        
        if (idUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa tu ID de usuario.");
            return;
        }

        if (!usuarioExiste(idUsuario)) {
            JOptionPane.showMessageDialog(this, "El ID de usuario no existe.");
            return;
        }
        
        String correoDestino = obtenerCorreoUsuario(idUsuario);
        
        if (correoDestino == null) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el correo del usuario.");
            return;
        }
        else
            mostrarCorreoParcial(idUsuario);
        
        
        String codigo = EnviarCorreo.generarCodigo();
        boolean enviado = EnviarCorreo.enviarCorreo(correoDestino, codigo);

        if (enviado) {
            System.out.println("Correo enviado con éxito a " + correoDestino);
            JOptionPane.showMessageDialog(this, "Correo enviado correctamente.");
        } else 
            JOptionPane.showMessageDialog(this, "Error al enviar el correo.");
        
    }//GEN-LAST:event_btn_EnviarCodigoActionPerformed

    private void txt_ID_UsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ID_UsuarioKeyReleased
        // TODO add your handling code here:
        String texto = txt_ID_Usuario.getText().replaceAll("-", "");
        
        if (texto.length() > 4 && texto.length() <= 8) 
            texto = texto.substring(0, 4) + "-" + texto.substring(4);
         else if (texto.length() > 8) 
            texto = texto.substring(0, 4) + "-" + texto.substring(4, 8) + "-" + texto.substring(8, Math.min(13, texto.length()));
        
        txt_ID_Usuario.setText(texto);
    }//GEN-LAST:event_txt_ID_UsuarioKeyReleased

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
            java.util.logging.Logger.getLogger(Recuperar_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recuperar_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recuperar_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recuperar_Password.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recuperar_Password().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_EnviarCodigo;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lbl_Cod_Verificacion;
    private javax.swing.JLabel lbl_ID_Usuario;
    private javax.swing.JTextField txt_Cod_Verificacion;
    private javax.swing.JTextField txt_ID_Usuario;
    // End of variables declaration//GEN-END:variables
}
