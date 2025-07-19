package Vistas;

import Controladores.ctrlUsuarios;
import Vistas.Paneles.jPanelFacturacion;
import Vistas.Paneles.jPanelHistorial;

import Vistas.Paneles.jpanelClientes;

import Vistas.Paneles.jpanelInicio;

import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu_Vendedor extends javax.swing.JFrame {



    public Menu_Vendedor() {
        initComponents();
        
        this.setLocationRelativeTo(null);

        
        //Abrir el panel del inicio
        jpanelInicio inicio = new jpanelInicio();
        abrirPanel(inicio); //Funcion para abrir los paneles
        
        ctrlUsuarios control = new ctrlUsuarios();
        lblnombreUsuario.setText(control.IdentificadorNombre());
    }
    

    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        btnInicio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCliente = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnAdminVent = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnReportVent = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();
        Encabezado = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblnombreUsuario = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PuntoVenta");
        setExtendedState(6);

        Menu.setBackground(new java.awt.Color(33, 44, 50));

        btnInicio.setBackground(new java.awt.Color(69, 93, 105));
        btnInicio.setPreferredSize(new java.awt.Dimension(151, 82));
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInicioMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicio");

        javax.swing.GroupLayout btnInicioLayout = new javax.swing.GroupLayout(btnInicio);
        btnInicio.setLayout(btnInicioLayout);
        btnInicioLayout.setHorizontalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(49, 49, 49))
        );
        btnInicioLayout.setVerticalGroup(
            btnInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnInicioLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        btnCliente.setBackground(new java.awt.Color(33, 44, 50));
        btnCliente.setPreferredSize(new java.awt.Dimension(151, 82));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClienteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnClienteMousePressed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Clientes");

        javax.swing.GroupLayout btnClienteLayout = new javax.swing.GroupLayout(btnCliente);
        btnCliente.setLayout(btnClienteLayout);
        btnClienteLayout.setHorizontalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnClienteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(39, 39, 39))
        );
        btnClienteLayout.setVerticalGroup(
            btnClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnClienteLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        btnAdminVent.setBackground(new java.awt.Color(33, 44, 50));
        btnAdminVent.setPreferredSize(new java.awt.Dimension(151, 82));
        btnAdminVent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAdminVentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAdminVentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAdminVentMousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Historial");

        javax.swing.GroupLayout btnAdminVentLayout = new javax.swing.GroupLayout(btnAdminVent);
        btnAdminVent.setLayout(btnAdminVentLayout);
        btnAdminVentLayout.setHorizontalGroup(
            btnAdminVentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnAdminVentLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(42, 42, 42))
        );
        btnAdminVentLayout.setVerticalGroup(
            btnAdminVentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAdminVentLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel11)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btnReportVent.setBackground(new java.awt.Color(33, 44, 50));
        btnReportVent.setPreferredSize(new java.awt.Dimension(151, 82));
        btnReportVent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportVentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportVentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnReportVentMousePressed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Facturar");

        javax.swing.GroupLayout btnReportVentLayout = new javax.swing.GroupLayout(btnReportVent);
        btnReportVent.setLayout(btnReportVentLayout);
        btnReportVentLayout.setHorizontalGroup(
            btnReportVentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnReportVentLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(42, 42, 42))
        );
        btnReportVentLayout.setVerticalGroup(
            btnReportVentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnReportVentLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdminVent, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(btnCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(btnReportVent, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(btnInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnReportVent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdminVent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
        );

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setLayout(new java.awt.BorderLayout());

        Encabezado.setBackground(new java.awt.Color(51, 136, 191));

        jPanel3.setBackground(new java.awt.Color(48, 122, 169));
        jPanel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPanel3KeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblnombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblnombreUsuario.setText("Nombre Usuario");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jLabel2.setText("Cerrar Sesión");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout EncabezadoLayout = new javax.swing.GroupLayout(Encabezado);
        Encabezado.setLayout(EncabezadoLayout);
        EncabezadoLayout.setHorizontalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblnombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(141, 141, 141))
        );
        EncabezadoLayout.setVerticalGroup(
            EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(EncabezadoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(EncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblnombreUsuario))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Encabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Encabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportVentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportVentMousePressed
        jPanelFacturacion fact = new jPanelFacturacion();
        abrirPanel(fact);
        this.colorpress(btnAdminVent,  btnInicio,  btnCliente, btnReportVent);
    }//GEN-LAST:event_btnReportVentMousePressed

    private void btnReportVentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportVentMouseExited
        this.resetColorPass(btnAdminVent,  btnInicio, btnCliente, btnReportVent);
    }//GEN-LAST:event_btnReportVentMouseExited

    private void btnReportVentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportVentMouseEntered
        insertarColorPass(btnReportVent);
    }//GEN-LAST:event_btnReportVentMouseEntered

    private void btnAdminVentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminVentMousePressed

        this.colorpress(btnCliente,  btnInicio,  btnReportVent, btnAdminVent);
        jPanelHistorial his = new jPanelHistorial();
        abrirPanel(his);
    }//GEN-LAST:event_btnAdminVentMousePressed

    private void btnAdminVentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminVentMouseExited
        this.resetColorPass(btnCliente,  btnInicio, btnReportVent, btnAdminVent);
    }//GEN-LAST:event_btnAdminVentMouseExited

    private void btnAdminVentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdminVentMouseEntered
        insertarColorPass(btnAdminVent);
    }//GEN-LAST:event_btnAdminVentMouseEntered

    private void btnClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMousePressed
        this.colorpress(btnAdminVent,  btnInicio, btnReportVent, btnCliente);
        jpanelClientes clien = new jpanelClientes();
        abrirPanel(clien);
    }//GEN-LAST:event_btnClienteMousePressed

    private void btnClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseExited
        this.resetColorPass(btnAdminVent,  btnInicio,  btnReportVent, btnCliente);
    }//GEN-LAST:event_btnClienteMouseExited

    private void btnClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseEntered
        insertarColorPass(btnCliente);
    }//GEN-LAST:event_btnClienteMouseEntered

    //Asignarle el color de manera permanente cuando se le seleccionar
    //OJO el ultimo parametro es para cambiarle el color al seleccionado y los demas para resetearlo
    private void btnInicioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMousePressed
        this.colorpress(btnAdminVent,  btnCliente, btnReportVent, btnInicio);

        jpanelInicio inicio = new jpanelInicio();
        abrirPanel(inicio);
    }//GEN-LAST:event_btnInicioMousePressed

    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited
        this.resetColorPass(btnAdminVent, btnCliente, btnReportVent, btnInicio);
    }//GEN-LAST:event_btnInicioMouseExited

    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered
        insertarColorPass(btnInicio);
    }//GEN-LAST:event_btnInicioMouseEntered

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        int respuesta = JOptionPane.showConfirmDialog(
            null, // Componente padre (null para centrado en pantalla)
            "¿Deseas Cerrar secion?", // Mensaje
            "Confirmación", // Título de la ventana
            JOptionPane.YES_NO_OPTION // Tipo de opciones
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        if (Menu.isVisible()) {
            new Thread(() -> {
                Animacion.Animacion.mover_izquierda(0, -264, 2, 2, Menu);
                try {
                    Thread.sleep(300); // duracion de espera para animacion
                } catch (InterruptedException e) {
                }
                Menu.setVisible(false);
            }).start();
        } else {
            Menu.setVisible(true);
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, Menu);
        }

    }//GEN-LAST:event_jLabel9MousePressed

    private void jPanel3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3KeyPressed

    
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
            java.util.logging.Logger.getLogger(Menu_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Vendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel Encabezado;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel btnAdminVent;
    private javax.swing.JPanel btnCliente;
    private javax.swing.JPanel btnInicio;
    private javax.swing.JPanel btnReportVent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblnombreUsuario;
    // End of variables declaration//GEN-END:variables

    private Color colorDefault = new Color(33, 44, 50); //Color predeterminado de los botones de menu lateral izquiero (paneles)
    private Color colorSelect = new Color(69, 93, 105); //Color al pasar o seleccionar  el mouse  de los botones de menu lateral izquiero (paneles)
    
    //Funcion para verificar el color y luego cambiarlo del jpanel (boton)
    private void insertarColorPass(JPanel panel) {
        if (panel.getBackground().equals(colorDefault)) {
            insertarColor(panel);
        }
    }

        
    private void resetColorPass(JPanel panel1, JPanel panel2, JPanel panel3, JPanel panelR) {
        if (!panel1.getBackground().equals(colorDefault)
                || !panel2.getBackground().equals(colorDefault)
                
                || !panel3.getBackground().equals(colorDefault)
) {
            
            resetColor(panelR);

        }
        
       
    }
    
    
    //Funcion para asignarle el color nuevo si se le da click y se le pone el default a los demas
    private void colorpress(JPanel panel1, JPanel panel2, JPanel panel3,JPanel panelselect){
        this.insertarColor(panelselect);
    
        this.resetColor(panel3);
        this.resetColor(panel2);
        this.resetColor(panel1);
    }

    //Funcion para cambiar el color del boton (jpanel)
    private void insertarColor(JPanel panel) {
        panel.setBackground(colorSelect);
    }

    private void resetColor(JPanel panel) {
        panel.setBackground(colorDefault);
    }
    
    
    
    
   //Funcion para abrir los JPaneles
    private void abrirPanel(JPanel panelvista){
        
        
        panelvista.setLocation(0,0); //Locacion del panel (se pone 0 porque despues lo vamos meter adentro del panel contenido
        
        Contenido.removeAll(); //Eliminamos todo lo que hay en el panel de contenido
        Contenido.add(panelvista, BorderLayout.CENTER); //añadimos el panel adentro del contenido
        Contenido.revalidate(); //Revalidamos
        Contenido.repaint(); //y refrescamos pantalla
    }
}
