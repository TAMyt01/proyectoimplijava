package Vistas.Paneles.Categoria;

import Controladores.ctrlCategoria;
import Modelos.clsCategoria;

import javax.swing.JOptionPane;

import Vistas.Paneles.jpanelCategoria;
import java.awt.Frame;

public class frm_ModificarCategoria extends javax.swing.JDialog {

    private static jpanelCategoria panelcategoria;
    private String NombreInicial;

    public frm_ModificarCategoria(Frame parent) {
        super(parent, "Modificar Categoría", true);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public void RecibirDatos(String Id, String nom, String desc, String est) {
        txtIdCategoria.setText(Id);
        txtNombreCategoria.setText(nom);
        txtDescripCategoria.setText(desc);
        NombreInicial=nom;
        if (est.equals("Activo")) {
            cmbEstado.setSelectedIndex(0);
        } else {
            cmbEstado.setSelectedIndex(1);
        }
        
    }

    //Para que se actualice la tabla con solo llamar la funcion de mostrar desde otro formulario
    public static void SetPanelModificar(jpanelCategoria panel) {
        panelcategoria = panel;// Asignar la referencia del panel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        txtNombreCategoria = new javax.swing.JTextField();
        txtIdCategoria = new javax.swing.JTextField();
        txtDescripCategoria = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 136, 191));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("ID Categoria");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        jLabel2.setText("Nombre Categoria");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Modificar Categoria");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel3.setText("Descripcion Categoria");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        txtNombreCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreCategoriaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 202, -1));

        txtIdCategoria.setEnabled(false);
        jPanel1.add(txtIdCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 202, -1));

        txtDescripCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripCategoriaActionPerformed(evt);
            }
        });
        txtDescripCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripCategoriaKeyTyped(evt);
            }
        });
        jPanel1.add(txtDescripCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 200, -1));

        jLabel5.setText("Estado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, -1, -1));

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Desactivado" }));
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripCategoriaActionPerformed

    }//GEN-LAST:event_txtDescripCategoriaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        if (txtNombreCategoria.getText().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        } else {

            ctrlCategoria ccontrolCategoria = new ctrlCategoria();
            if (!ccontrolCategoria.existeCategoria(txtNombreCategoria.getText()) || txtNombreCategoria.getText().equals(NombreInicial)) {
                clsCategoria cate = new clsCategoria();
                cate.setNombre(txtNombreCategoria.getText());
                cate.setDescripcion(txtDescripCategoria.getText());
                cate.setID_categoria(Integer.parseInt(txtIdCategoria.getText()));
                cate.setEstado(cmbEstado.getSelectedItem().toString());

                if (ccontrolCategoria.modificar()) {
                    JOptionPane.showMessageDialog(null, "Registro modificado");
                    panelcategoria.cargaTablaCategoria();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar");
                }
            }else{
               JOptionPane.showMessageDialog(null,ccontrolCategoria.mens);
            }

        }

        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtNombreCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCategoriaKeyTyped
        // TODO add your handling code here:
        if (txtNombreCategoria.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreCategoriaKeyTyped

    private void txtDescripCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripCategoriaKeyTyped
        // TODO add your handling code here:
        if (txtDescripCategoria.getText().length() >= 100) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDescripCategoriaKeyTyped

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
            java.util.logging.Logger.getLogger(frm_ModificarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_ModificarCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDescripCategoria;
    private javax.swing.JTextField txtIdCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
