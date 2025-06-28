/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas.Paneles.Producto;

import Controladores.ctrlProducto;
import Modelos.Producto;
import Vistas.Paneles.jpanelProductos;
import javax.swing.JOptionPane;

import javax.swing.text.AbstractDocument;
import filtros.NumerosNaturalesFilter;


/**
 *
 * @author JManu
 */
public class frm_ActualizarStock extends javax.swing.JFrame {

    private static jpanelProductos panelprodc;

    public frm_ActualizarStock() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Actualizar Stock");
        
        ((AbstractDocument) txtAgregarCant.getDocument()).setDocumentFilter(new NumerosNaturalesFilter());


    }

    public static void SetPanelActualizar(jpanelProductos panel) {
        panelprodc = panel; // Asignar la referencia del panel
    }

    public void RecibirDatos(String ID, String name, int cant) {
        txtCod.setText(ID);
        txtNom.setText(name);
        txtCant.setText(cant + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAgregarCant = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(51, 136, 191));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Stock");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 6, -1, -1));

        txtCod.setEnabled(false);
        fondo.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 52, 206, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Codigo Producto");
        fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 54, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 92, -1, -1));

        txtNom.setEnabled(false);
        fondo.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 89, 206, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad actual");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, -1, -1));

        txtCant.setEnabled(false);
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantKeyReleased(evt);
            }
        });
        fondo.add(txtCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 123, 206, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Cantidad a agregar");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 164, -1, -1));

        txtAgregarCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgregarCantKeyReleased(evt);
            }
        });
        fondo.add(txtAgregarCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 162, 206, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        fondo.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, -1, -1));

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        fondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyReleased

    }//GEN-LAST:event_txtCantKeyReleased

    private void txtAgregarCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarCantKeyReleased

    }//GEN-LAST:event_txtAgregarCantKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtAgregarCant.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos necesarios");
        } else {

            if (txtAgregarCant.equals("0")) {
                
                JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0");
            } else {
                ctrlProducto ctrlprod = new ctrlProducto();

                int calcular = Integer.parseInt(txtCant.getText()) + Integer.parseInt(txtAgregarCant.getText());

                Producto prodc = new Producto();
                prodc.setCantidad(calcular);
                prodc.setID_Producto(txtCod.getText());

                if (ctrlprod.ActualizarStock()) {
                    JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                    panelprodc.cargaTablaCategoria();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al Actualizar stock");
                }
                this.dispose();
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(frm_ActualizarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ActualizarStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_ActualizarStock().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtAgregarCant;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtNom;
    // End of variables declaration//GEN-END:variables
}
