/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

package Utilidades;

import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;

/**
 * Clase de utilidades generales para formularios, filtros y gestión de ventanas.
 */
public class clsCRUD {

    /**
     * Aplica un filtro dinámico a una tabla en función del texto ingresado,
     * el campo de filtro seleccionado y el estado (si aplica).
     */
    public static void aplicarFiltro(JTable tabla, JTextField campoBuscar, JComboBox<String> comboFiltro, JComboBox<String> comboEstado) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(sorter);

        String texto = campoBuscar.getText().trim();
        String filtroSeleccionado = comboFiltro.getSelectedItem().toString();
        String estadoSeleccionado = comboEstado.getSelectedItem().toString();

        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        if (!texto.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + texto, obtenerIndiceColumna(tabla, filtroSeleccionado)));
        }

        if (!estadoSeleccionado.equals("Todos")) {
            filtros.add(RowFilter.regexFilter("(?i)" + estadoSeleccionado, obtenerIndiceColumna(tabla, "estado")));
        }

        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }

    /**
     * Busca el índice de una columna por su nombre.
     */
    public static int obtenerIndiceColumna(JTable tabla, String nombreColumna) {
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            if (tabla.getColumnName(i).equalsIgnoreCase(nombreColumna)) {
                return i;
            }
        }
        return -1; // No encontrada
    }

    /**
     * Abre una ventana evitando duplicados. Si ya está visible, la lleva al frente.
     */
    public static void abrirVentanaUnica(JFrame ventana, JFrame contenedor) {
        if (ventana == null || !ventana.isVisible()) {
            ventana = contenedor;
            ventana.setVisible(true);
        } else {
            ventana.toFront();
        }
    }

    /**
     * Centra internamente un JInternalFrame en un JDesktopPane.
     */
    public static void centrarFormulario(JDesktopPane escritorio, JInternalFrame formulario) {
        int x = (escritorio.getWidth() / 2) - (formulario.getWidth() / 2);
        int y = (escritorio.getHeight() / 2) - (formulario.getHeight() / 2);
        formulario.setLocation(x, y);
    }

    /**
     * Limpia todos los campos de texto dentro de un JPanel o contenedor.
     */
    public static void limpiarCampos(Container contenedor) {
        for (Component c : contenedor.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JPasswordField) {
                ((JPasswordField) c).setText("");
            } else if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            } else if (c instanceof Container) {
                limpiarCampos((Container) c);
            }
        }
    }
    public static void abrirVentanaModal(JFrame parent, JDialog dialog) {
        if (dialog == null || !dialog.isVisible()) {
            dialog.setLocationRelativeTo(parent);     // Centrar respecto al contenedor
            dialog.setModal(true);                    // Bloquear interacción externa
            dialog.setVisible(true);                  // Mostrar el diálogo
        } else {
            dialog.toFront();                         // Traer al frente si ya estaba visible
        }
    }
}

/**
 *
 * @author kenne
 */
public class ctrlTabla {
    
}
