/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vistas.Paneles.Producto;

import Controladores.ctrlProducto;
import Modelos.clsProducto;
import Vistas.Paneles.jpanelProductos;
import javax.swing.JOptionPane;

import javax.swing.text.AbstractDocument;
import Formatos.formato_NumerosNaturales;
import java.awt.Frame;


/**
 *
 * @author JManu
 */
public class frm_ActualizarStock extends javax.swing.JDialog {

    private static jpanelProductos panelprodc;

    public frm_ActualizarStock(Frame parent) {
        super(parent, "Actualizar Stock", true);
        initComponents();
        setLocationRelativeTo(parent);
        
        ((AbstractDocument) txtAgregarCant.getDocument()).setDocumentFilter(new formato_NumerosNaturales());


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
        btnGuardar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(51, 136, 191));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Stock");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 6, -1, -1));

        txtCod.setEnabled(false);
        txtCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodKeyTyped(evt);
            }
        });
        fondo.add(txtCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 52, 206, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Codigo Producto");
        fondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 54, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        fondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 92, -1, -1));

        txtNom.setEnabled(false);
        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomKeyTyped(evt);
            }
        });
        fondo.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 89, 206, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad actual");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, -1, -1));

        txtCant.setEnabled(false);
        txtCant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantKeyTyped(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAgregarCantKeyTyped(evt);
            }
        });
        fondo.add(txtAgregarCant, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 162, 206, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        fondo.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        fondo.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

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
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyReleased

    }//GEN-LAST:event_txtCantKeyReleased

    private void txtAgregarCantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarCantKeyReleased

    }//GEN-LAST:event_txtAgregarCantKeyReleased

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtAgregarCant.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos necesarios");
        } else {

            if (txtAgregarCant.equals("0")) {
                
                JOptionPane.showMessageDialog(null, "Ingrese un numero mayor a 0");
            } else {
                ctrlProducto ctrlprod = new ctrlProducto();

                int calcular = Integer.parseInt(txtCant.getText()) + Integer.parseInt(txtAgregarCant.getText());

                clsProducto prodc = new clsProducto();
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

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        // TODO add your handling code here:
        if (txtCod.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyTyped
        // TODO add your handling code here:
        if (txtNom.getText().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomKeyTyped

    private void txtCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantKeyTyped
        // TODO add your handling code here:
        if (txtCant.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantKeyTyped

    private void txtAgregarCantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgregarCantKeyTyped
        // TODO add your handling code here:
        if (txtAgregarCant.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtAgregarCantKeyTyped

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel fondo;
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
