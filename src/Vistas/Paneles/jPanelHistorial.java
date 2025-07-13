/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Paneles;

import Conexion.clsConexion;
import Vistas.Paneles.Historial.frm_Historial;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author JManu
 */
public class jPanelHistorial extends javax.swing.JPanel {

    private int id=0;
    
    public jPanelHistorial() {
        initComponents();
        // Obtener el primer día del año actual
        Calendar calendario = Calendar.getInstance();
        calendario.set(Calendar.MONTH, Calendar.JANUARY);
        calendario.set(Calendar.DAY_OF_MONTH, 1);

        // Establecer la fecha en el JDateChooser
        jdcFechaInicio.setDate(calendario.getTime());


        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Establecer la fecha actual en el JDateChooser
        jdcFechaFinal.setDate(fechaActual);

                cargaTabla();
    }

    public void cargaTabla() {
        Connection cn = clsConexion.conectar();
        String sql = "SELECT cv.idCabeceraVenta, c.nombre AS Cliente, cv.valorPagar, cv.fechaVenta "
                + "FROM tb_cabecera_venta cv "
                + "JOIN tb_cliente c ON cv.idCliente = c.identidad;";

        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rellenarTabla(rs);
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error en actualizar tabla categoria" + ex);
        }

    }
    
    
    public void cargaTablaFech() {
        Connection cn = clsConexion.conectar();
        String sql = "SELECT cv.idCabeceraVenta, c.nombre AS Cliente, cv.valorPagar, cv.fechaVenta\n"
                   + "FROM tb_cabecera_venta cv\n"
                   + "JOIN tb_cliente c ON cv.idCliente = c.identidad\n"
                   + "WHERE cv.fechaVenta BETWEEN ? AND ?;";

        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setDate(1, fechaInicio_sql); // Ejemplo: "2025-05-01"
            ps.setDate(2, fechaFinal_sql);    // Ejemplo: "2025-05-18"

            ResultSet rs = ps.executeQuery();

            rellenarTabla(rs); // tu método que llena la tabla
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cargar tabla con rango de fechas: " + ex);
        }
    }

    private void rellenarTabla(ResultSet rs) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tablas.getModel();
        model.setRowCount(0);
        while (rs.next()) {
            Object fila[] = new Object[4];
            for (int i = 0; i < 4; i++) 
                fila[i] = rs.getObject(i + 1);
            
            model.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        tablas = new javax.swing.JTable();
        btnDetalles = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jdcFechaFinal = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Filtrar = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.GridBagLayout());

        tablas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N Factura", "Cliente", "Valor pagar", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tablas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablas);
        if (tablas.getColumnModel().getColumnCount() > 0) {
            tablas.getColumnModel().getColumn(0).setResizable(false);
            tablas.getColumnModel().getColumn(0).setPreferredWidth(250);
            tablas.getColumnModel().getColumn(1).setResizable(false);
            tablas.getColumnModel().getColumn(1).setPreferredWidth(250);
            tablas.getColumnModel().getColumn(2).setResizable(false);
            tablas.getColumnModel().getColumn(2).setPreferredWidth(250);
            tablas.getColumnModel().getColumn(3).setResizable(false);
            tablas.getColumnModel().getColumn(3).setPreferredWidth(250);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 583;
        gridBagConstraints.ipady = 458;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 18, 0);
        add(jScrollPane1, gridBagConstraints);

        btnDetalles.setBackground(new java.awt.Color(55, 116, 209));
        btnDetalles.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalles.setText("Mostrar detalles");
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 45;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(btnDetalles, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Historial ventas");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 0);
        add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(jdcFechaInicio, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 85;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(jdcFechaFinal, gridBagConstraints);

        jLabel2.setText("Fecha Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(52, 12, 0, 0);
        add(jLabel2, gridBagConstraints);

        jLabel3.setText("Fecha Final");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(jLabel3, gridBagConstraints);

        Filtrar.setBackground(new java.awt.Color(55, 116, 209));
        Filtrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Filtrar.setForeground(new java.awt.Color(255, 255, 255));
        Filtrar.setText("Filtrar por fecha");
        Filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiltrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 0);
        add(Filtrar, gridBagConstraints);

        btnReport.setBackground(new java.awt.Color(55, 116, 209));
        btnReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReport.setForeground(new java.awt.Color(255, 255, 255));
        btnReport.setText("Generar Reporte");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 0, 0);
        add(btnReport, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private frm_Historial histo;
    
    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        
        
        if (id==0) {
              JOptionPane.showMessageDialog(null, "No hay registro seleccionado, seleccione uno");
        } else {
            if (histo == null || !histo.isVisible()) {
            histo = new frm_Historial(id); //Se declara el objeto
            
            histo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "La ventana ya está abierta, ciérrela antes de abrirla nuevamente.");
        }
        
        }
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void tablasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasMousePressed
        int seleccion = tablas.rowAtPoint(evt.getPoint());
        
        id = Integer.parseInt(tablas.getValueAt(seleccion, 0).toString());

    }//GEN-LAST:event_tablasMousePressed

    java.sql.Date fechaInicio_sql,fechaFinal_sql;
    
    private void FiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiltrarActionPerformed
        Date FechIn, FechFin;
        if (jdcFechaFinal.getDate().equals(null) || jdcFechaInicio.getDate().equals(null)) {
            JOptionPane.showMessageDialog(null, "Ingrese la Fecha Inicial y Final");
        } else {

            FechIn = jdcFechaInicio.getDate();
            long fechaIn = FechIn.getTime();
            fechaInicio_sql = new java.sql.Date(fechaIn);
            System.out.println("" + fechaInicio_sql);

            FechFin = jdcFechaFinal.getDate();
            long fechaFin = FechFin.getTime();
            fechaFinal_sql = new java.sql.Date(fechaFin);
            System.out.println("" + fechaFinal_sql);

            cargaTablaFech();
        }
        
        
    }//GEN-LAST:event_FiltrarActionPerformed

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed

        if (jdcFechaFinal.getDate().equals(null) || jdcFechaInicio.getDate().equals(null)) 
            System.out.println("Ingrese un rango de fecha");
        else {
            try {
                Connection cn = clsConexion.conectar();

                JasperReport reporte = null;
                String path = "src\\Report\\ReportVenta.jasper";
                reporte = (JasperReport) JRLoader.loadObjectFromFile(path);

                // Suponiendo que ya tienes los valores como java.sql.Date
                Map<String, Object> parametros = new HashMap<>();
                parametros.put("fechaInicio_sql", fechaInicio_sql);  // ya definidos antes
                parametros.put("fechaFinal_sql", fechaFinal_sql);    // ya definidos antes

                JasperPrint jprint = JasperFillManager.fillReport(path, parametros, cn);

                JasperViewer view = new JasperViewer(jprint, false);
                view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                view.setVisible(true);
            } catch (JRException ex) {
                Logger.getLogger(jPanelHistorial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnReportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Filtrar;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JButton btnReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdcFechaFinal;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JTable tablas;
    // End of variables declaration//GEN-END:variables
}
