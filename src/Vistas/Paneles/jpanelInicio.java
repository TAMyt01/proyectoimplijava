/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas.Paneles;


import java.sql.*;
import Conexion.clsConexion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author JManu
 */
public class jpanelInicio extends javax.swing.JPanel {

    /**
     * Creates new form jpanelInicio
     */
    private List<Object[]> filas = new ArrayList<>();

    public jpanelInicio() {
        initComponents();

        ObtenerPrimeroCincoProductos();
    }

    private void generarGrafica() {
        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        for (Object[] fila : filas) {
            if (fila[0] != null && fila[2] != null) {
                try {
                    int cantidad = Integer.parseInt(fila[2].toString());
                    String producto = fila[0].toString();
                    datos.setValue(cantidad, "Cantidad venta", producto);
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir la cantidad: " + e.getMessage());
                }
            }
        }

        JFreeChart grafico_vent = ChartFactory.createBarChart3D(
                "Los productos más vendidos",
                "Productos",
                "Cantidad",
                datos, PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        // BLOQUE PARA MOSTRAR ETIQUETAS COMPLETAS
        CategoryPlot plot = grafico_vent.getCategoryPlot();

        CategoryAxis xAxis = plot.getDomainAxis();
        xAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90); // texto vertical
        xAxis.setTickLabelFont(new Font("SansSerif", Font.BOLD, 15)); // fuente más pequeña
        
        NumberAxis yAxis = (NumberAxis) plot.getRangeAxis();
        yAxis.setTickUnit(new NumberTickUnit(1)); // Mostrar enteros solamente
        yAxis.setTickLabelFont(new Font("SansSerif", Font.BOLD, 15));
        yAxis.setLowerBound(0); // Evita valores negativos


        plot.setInsets(new RectangleInsets(10, 10, 10, 10));
        //FIN DEL BLOQUE

        ChartPanel panel = new ChartPanel(grafico_vent);
        panel.setMouseWheelEnabled(false);
        panel.setPreferredSize(new Dimension(810, 460));

        graf.setLayout(new BorderLayout());
        graf.removeAll();
        graf.add(panel, BorderLayout.CENTER);
        graf.revalidate();
        graf.repaint();
    }

    private void ObtenerPrimeroCincoProductos() {
        Connection cn = clsConexion.conectar();
        ResultSet rs;
        final String SQL = "SELECT p.nombre AS Producto, dv.idProducto, \n"
                + "       SUM(dv.cantidad) AS total_vendido, \n"
                + "       SUM(dv.totalPagar) AS Ventas_Lempiras\n"
                + "FROM tb_detalle_venta dv\n"
                + "JOIN tb_producto p ON dv.idProducto = p.ID_Producto\n"
                + "GROUP BY dv.idProducto, p.nombre\n"
                + "ORDER BY total_vendido DESC\n"
                + "LIMIT 5;";
        try {
            PreparedStatement consulta = cn.prepareStatement(SQL);
            rs = consulta.executeQuery();
            filas.clear(); // limpiar por si hay datos anteriores
            while (rs.next()) {
                Object[] fila = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                filas.add(fila);
            }
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al consultar productos: " + ex);
        }

        generarGrafica();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graf = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        graf.setEnabled(false);

        javax.swing.GroupLayout grafLayout = new javax.swing.GroupLayout(graf);
        graf.setLayout(grafLayout);
        grafLayout.setHorizontalGroup(
            grafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
        );
        grafLayout.setVerticalGroup(
            grafLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 648, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graf;
    // End of variables declaration//GEN-END:variables
}
