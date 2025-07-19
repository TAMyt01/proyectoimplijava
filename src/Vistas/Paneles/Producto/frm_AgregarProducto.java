package Vistas.Paneles.Producto;

import Conexion.clsConexion;
import Controladores.ctrlProducto;
import Formatos.formato_Precio;
import Modelos.clsProducto;
import Vistas.Paneles.jpanelProductos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.text.AbstractDocument;
import Formatos.formato_NumerosNaturales;


/**
 *
 * @author JManu
 */
public class frm_AgregarProducto extends javax.swing.JFrame {

    private static jpanelProductos panelprodc;

    public frm_AgregarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Agregar Producto");
        CargarCMB();
        AutoCompleteDecorator.decorate(cmbCategoria);
        
        ((AbstractDocument) txtCantidad.getDocument()).setDocumentFilter(new formato_NumerosNaturales());
         ((AbstractDocument) txtPrec.getDocument()).setDocumentFilter(new formato_Precio());

    }

    public static void SetPanelagregar(jpanelProductos panel) {
        panelprodc = panel; // Asignar la referencia del panel
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
        txtCantidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrec = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(51, 136, 191));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nuevo Producto");
        fondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 6, -1, -1));

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

        txtNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNomKeyTyped(evt);
            }
        });
        fondo.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 89, 206, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad");
        fondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 127, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        fondo.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 123, 206, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Precio de venta");
        fondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 164, -1, -1));

        txtPrec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecKeyTyped(evt);
            }
        });
        fondo.add(txtPrec, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 162, 206, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Descripcion");
        fondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 207, -1, -1));

        txtDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescKeyTyped(evt);
            }
        });
        fondo.add(txtDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 202, 206, -1));

        cmbCategoria.setEditable(true);
        cmbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbCategoriaKeyTyped(evt);
            }
        });
        fondo.add(cmbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 244, 206, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nombre de Categoria");
        fondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 246, -1, -1));

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        fondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        fondo.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtCantidad.getText().isEmpty() || txtCod.getText().isEmpty() || txtPrec.getText().isEmpty() || cmbCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos necesarios");
        } else {
            ctrlProducto ctrlprod = new ctrlProducto();

            if (!ctrlprod.existeProducto(txtCod.getText(), txtNom.getText(), "Agregar")) {
                clsProducto prodc = new clsProducto();
                prodc.setCantidad(Integer.parseInt(txtCantidad.getText()));
                prodc.setDescripcion(txtDesc.getText());
                prodc.setID_Producto(txtCod.getText());
                prodc.setCategoria(cmbCategoria.getSelectedItem().toString());
                prodc.setNombre(txtNom.getText());
                prodc.setPrecio_venta(Double.parseDouble(txtPrec.getText()));

                if (ctrlprod.guardar()) {
                    JOptionPane.showMessageDialog(null, "Se guardo exitosamente");
                    panelprodc.cargaTablaCategoria();
                } else {
                    JOptionPane.showMessageDialog(null, "Hubo un error al guardar Producto");
                }

            } else {

                JOptionPane.showMessageDialog(null, ctrlprod.mens);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
       
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtPrecKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecKeyReleased
        
    }//GEN-LAST:event_txtPrecKeyReleased

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodKeyTyped
        // TODO add your handling code here:
        if (txtCod.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCodKeyTyped

    private void txtNomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomKeyTyped
        // TODO add your handling code here:
        if (txtNom.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNomKeyTyped

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        // TODO add your handling code here:
        if (txtCantidad.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtPrecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecKeyTyped
        // TODO add your handling code here:
        if (txtPrec.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecKeyTyped

    private void txtDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescKeyTyped
        // TODO add your handling code here:
        if (txtDesc.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescKeyTyped

    private void cmbCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbCategoriaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriaKeyTyped

    private void CargarCMB() {
        Connection cn = clsConexion.conectar();
        String sql = "select nombre from tb_categoria where estado='Activo'";
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            cmbCategoria.removeAllItems();
            cmbCategoria.addItem("Ingrese la categoria: ");
            while (rs.next()) {
                cmbCategoria.addItem(rs.getString("nombre"));
            }

            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error en actualizar tabla categoria" + ex);
        }
    }

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
            java.util.logging.Logger.getLogger(frm_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_AgregarProducto().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtPrec;
    // End of variables declaration//GEN-END:variables

}
