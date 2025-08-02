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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;


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
            final String remitente = "recuperardecontrasena@gmail.com";
            final String clave = "tkrs diqd qfph cbjm";//Clave de Aplicacion

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
        
        
        //
        // Método para guardar el código de recuperación en la base de datos
        public boolean guardarCodigoRecuperacion(String idUsuario, String codigo) {
            String sql = "UPDATE tb_usuario SET cod_recuperacion = ?, fecha_envio_codigo = ? WHERE idUsuario = ?";
            try (Connection cn = (Connection) clsConexion.conectar(); 
                 PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

                // Establecer el código de recuperación
                pst.setString(1, codigo);

                // Establecer la fecha y hora actual para la columna fecha_envio_codigo
                java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
                pst.setTimestamp(2, timestamp);  // Fecha actual como fecha de envío

                // Establecer el ID de usuario
                pst.setString(3, idUsuario);

                // Ejecutar la actualización
                int filasAfectadas = pst.executeUpdate();

                return filasAfectadas > 0;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

        //
        
        //Verificar expiración del código de recuperación
        private boolean verificarCodigoExpirado(String idUsuario) throws java.text.ParseException {
            String sql = "SELECT cod_recuperacion FROM tb_usuario WHERE idUsuario = ?";
            try (Connection cn = (Connection) clsConexion.conectar(); 
                 PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

                pst.setString(1, idUsuario);

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String codRecuperacion = rs.getString("cod_recuperacion");
                    if (codRecuperacion != null && !codRecuperacion.isEmpty()) {
                        // Separar código y fecha de expiración
                        String[] partes = codRecuperacion.split("\\|");
                        if (partes.length == 2) {
                            String fechaExpiracionStr = partes[1];
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date fechaExpiracion = sdf.parse(fechaExpiracionStr);

                            // Verificar si la fecha ha expirado
                            if (fechaExpiracion.before(new Date())) {
                                return true;  // El código ha expirado
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;  // Si no hay coincidencia o no ha expirado
        }
        //
        //Obtener la fecha de envio del codigo de recuperacion
        public long obtenerFechaEnvioCodigo(String idUsuario) {
            String query = "SELECT fecha_envio_codigo FROM tb_usuario WHERE idUsuario = ?";
            try (Connection conn = (Connection) clsConexion.conectar();
                 PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query)) {

                pst.setString(1, idUsuario);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    java.sql.Timestamp fechaEnvio = rs.getTimestamp("fecha_envio_codigo");
                    return fechaEnvio.getTime();  // Devolver la fecha como long (milisegundos)
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
        }
        //Obtener el codigo de recuperacion
        public String obtenerCodigoRecuperacion(String idUsuario) {
            String sql = "SELECT cod_recuperacion FROM tb_usuario WHERE idUsuario = ?";
            String codigo = null;

            try (Connection cn = (Connection) clsConexion.conectar(); 
                 PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

                pst.setString(1, idUsuario); // Asignar el ID de usuario al PreparedStatement

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // Si el resultado tiene una fila, obtenemos el código de recuperación
                        codigo = rs.getString("cod_recuperacion");
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return codigo;
        }

        
        
        
        
        
        //
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_EnviarCodigo = new javax.swing.JButton();
        btn_Regresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbl_ID_Usuario = new javax.swing.JLabel();
        txt_ID_Usuario = new javax.swing.JTextField();
        lbl_Cod_Verificacion = new javax.swing.JLabel();
        txt_Cod_Verificacion = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        btnConfirmarCodigo = new javax.swing.JButton();
        panelCambioContra = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCambiarContra = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        chkMostrar = new javax.swing.JCheckBox();
        txtNuevaContra = new javax.swing.JPasswordField();
        txtConfirmarContra = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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

        btnConfirmarCodigo.setText("Confirmar Código");
        btnConfirmarCodigo.setEnabled(false);
        btnConfirmarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarCodigoActionPerformed(evt);
            }
        });

        panelCambioContra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCambioContra.setEnabled(false);

        jLabel2.setText("Nueva Contraseña:");

        jLabel3.setText("Confirmar Contraseña:");

        btnCambiarContra.setText("Cambiar Contraseña");
        btnCambiarContra.setEnabled(false);
        btnCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraActionPerformed(evt);
            }
        });

        jLabel4.setText("Ingresa Nueva Contraseña");

        chkMostrar.setText("Mostrar Contraseña");
        chkMostrar.setEnabled(false);
        chkMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMostrarActionPerformed(evt);
            }
        });

        txtNuevaContra.setEnabled(false);
        txtNuevaContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevaContraKeyTyped(evt);
            }
        });

        txtConfirmarContra.setEnabled(false);
        txtConfirmarContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarContraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelCambioContraLayout = new javax.swing.GroupLayout(panelCambioContra);
        panelCambioContra.setLayout(panelCambioContraLayout);
        panelCambioContraLayout.setHorizontalGroup(
            panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCambioContraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(131, 131, 131))
            .addGroup(panelCambioContraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCambioContraLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(chkMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(btnCambiarContra))
                    .addGroup(panelCambioContraLayout.createSequentialGroup()
                        .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(28, 28, 28)
                        .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNuevaContra)
                            .addComponent(txtConfirmarContra))))
                .addGap(18, 18, 18))
        );
        panelCambioContraLayout.setVerticalGroup(
            panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCambioContraLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCambioContraLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCambioContraLayout.createSequentialGroup()
                        .addComponent(txtNuevaContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtConfirmarContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCambioContraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCambiarContra)
                    .addComponent(chkMostrar))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConfirmarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_EnviarCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(btn_Regresar)
                .addGap(75, 75, 75))
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelCambioContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ID_Usuario)
                    .addComponent(txt_ID_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorreo)
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Cod_Verificacion)
                    .addComponent(txt_Cod_Verificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_EnviarCodigo)
                    .addComponent(btn_Regresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmarCodigo)
                .addGap(46, 46, 46)
                .addComponent(panelCambioContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
        
        txt_Cod_Verificacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        
    }//GEN-LAST:event_txt_Cod_VerificacionKeyTyped

    private void btn_RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegresarActionPerformed
        // TODO add your handling code here:
        // Crear y mostrar el formulario de Login
        Login login = new Login();
        login.setVisible(true);

        // Cerrar el formulario actual
        this.dispose();
    }//GEN-LAST:event_btn_RegresarActionPerformed

    private boolean codigoEnviado = false;
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
            
            // Guardar el código de verificación en la base de datos
            if (guardarCodigoRecuperacion(idUsuario, codigo)) {
                // Habilitar el campo de código de verificación
                txt_Cod_Verificacion.setEnabled(true);
                txt_Cod_Verificacion.setText("");  // Limpiar el campo
                codigoEnviado = true;
                btn_EnviarCodigo.setEnabled(false);
                btnConfirmarCodigo.setEnabled(true);
                
                // Temporizador para reactivar el botón de Enviar Codigo después de 10 minutos
                Timer timer = new Timer(600000, e -> {
                    btn_EnviarCodigo.setEnabled(true);  // Reactivar el botón después de 10 minutos
                    codigoEnviado = false;  // Resetea
                });
                timer.setRepeats(false);  // Solo se ejecuta una vez
                timer.start();
                
            } else 
                JOptionPane.showMessageDialog(this, "Error al guardar el código de verificación.");
            
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

    private void btnConfirmarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarCodigoActionPerformed
        // TODO add your handling code here:
        String idUsuario = txt_ID_Usuario.getText().trim();
        String codigoIngresado = txt_Cod_Verificacion.getText().trim();

        if (codigoIngresado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingresa el código de verificación.");
            return;
        }

        if (!codigoEnviado) {
            JOptionPane.showMessageDialog(this, "No se ha enviado ningún código aún. Envíe un código primero.");
            return;
        }

        String codigoGuardado = obtenerCodigoRecuperacion(idUsuario);  // Método para obtener el código guardado
        if (codigoGuardado == null) {
            JOptionPane.showMessageDialog(this, "No se encontró el código de verificación.");
            return;
        }
        
        long fechaEnvio = obtenerFechaEnvioCodigo(idUsuario);  // Método para obtener la fecha en que se envió el código

        // Verificar si el código es correcto y no ha expirado
        if (codigoIngresado.equals(codigoGuardado)) {
            long tiempoTranscurrido = System.currentTimeMillis() - fechaEnvio;
            long diezMinutos = 600000;  // 10 minutos

            if (tiempoTranscurrido <= diezMinutos) {
                JOptionPane.showMessageDialog(this, "Código verificado correctamente.");
                // Proceder con la recuperación de la contraseña
                mostrarPanelCambioContra();
            } else 
                JOptionPane.showMessageDialog(this, "El código ha expirado.");
            
        } else 
            JOptionPane.showMessageDialog(this, "El código ingresado es incorrecto.");
        
        
    }//GEN-LAST:event_btnConfirmarCodigoActionPerformed

    private void btnCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraActionPerformed
        // TODO add your handling code here:
        // Obtener las contraseñas
        String nuevaContraseña = txtNuevaContra.getText().trim();
        String confirmarContraseña = txtConfirmarContra.getText().trim();

        // Verificar que las contraseñas coincidan
        if (nuevaContraseña.isEmpty() || confirmarContraseña.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa y confirma la nueva contraseña.");
            return;
        }

        if (!nuevaContraseña.equals(confirmarContraseña)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden. Por favor, inténtalo nuevamente.");
            return;
        }

        // Cambiar la contraseña en la base de datos
        String idUsuario = txt_ID_Usuario.getText().trim();
        boolean cambioExitoso = cambiarContraseña(idUsuario, nuevaContraseña);

        if (cambioExitoso) {
            JOptionPane.showMessageDialog(this, "Contraseña cambiada correctamente.");
            // Redirigir al login
            redirigirALogin();
        } else {
            JOptionPane.showMessageDialog(this, "Error al cambiar la contraseña. Inténtalo nuevamente.");
        }
        
        
    }//GEN-LAST:event_btnCambiarContraActionPerformed

    private void chkMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMostrarActionPerformed
        // TODO add your handling code here:
        if (chkMostrar.isSelected()) {
            txtNuevaContra.setEchoChar((char) 0);  // Muestra el texto sin máscara
        } else {
            txtNuevaContra.setEchoChar('*');  // Enmascara el texto con asteriscos
        }

    }//GEN-LAST:event_chkMostrarActionPerformed

    private void txtNuevaContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaContraKeyTyped
        // TODO add your handling code here:
        if (txtNuevaContra.getText().length() >= 30) 
            evt.consume();
    }//GEN-LAST:event_txtNuevaContraKeyTyped

    private void txtConfirmarContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarContraKeyTyped
        // TODO add your handling code here:
        if (txtConfirmarContra.getText().length() >= 30) 
            evt.consume();
    }//GEN-LAST:event_txtConfirmarContraKeyTyped

    private void mostrarPanelCambioContra() {
        // Mostrar panel para cambiar la contraseña
        btnConfirmarCodigo.setEnabled(false);
        chkMostrar.setEnabled(true);
        panelCambioContra.setVisible(true);  // Habilitar el panel
        txtNuevaContra.setEnabled(true);
        txtConfirmarContra.setEnabled(true);
        btnCambiarContra.setEnabled(true);
    }
    
    
    private boolean cambiarContraseña(String idUsuario, String nuevaContraseña) {
        String sql = "UPDATE tb_usuario SET password = ? WHERE idUsuario = ?";
        try (Connection cn = (Connection) clsConexion.conectar(); 
             PreparedStatement pst = (PreparedStatement) cn.prepareStatement(sql)) {

            pst.setString(1, nuevaContraseña); // Establecer la nueva contraseña
            pst.setString(2, idUsuario);  // ID del usuario

            int filasAfectadas = pst.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void redirigirALogin() {
        // Redirigir al Login (o al JFrame donde está el login)
        this.setVisible(false);  // Ocultar el panel actual
        new Login().setVisible(true);  // Mostrar el formulario de login
    }
    
    
    
    
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
    private javax.swing.JButton btnCambiarContra;
    private javax.swing.JButton btnConfirmarCodigo;
    private javax.swing.JButton btn_EnviarCodigo;
    private javax.swing.JButton btn_Regresar;
    private javax.swing.JCheckBox chkMostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lbl_Cod_Verificacion;
    private javax.swing.JLabel lbl_ID_Usuario;
    private javax.swing.JPanel panelCambioContra;
    private javax.swing.JPasswordField txtConfirmarContra;
    private javax.swing.JPasswordField txtNuevaContra;
    private javax.swing.JTextField txt_Cod_Verificacion;
    private javax.swing.JTextField txt_ID_Usuario;
    // End of variables declaration//GEN-END:variables
}
