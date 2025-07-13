/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;



import javax.swing.*;
import javax.swing.table.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

/**
 * Clase de utilidades generales para formularios, filtros y gestión de ventanas.
 */
public class ctrl_Tabla {

    /**
     * Aplica un filtro dinámico a una tabla en función del texto ingresado,
     * el campo de filtro seleccionado y el estado (si aplica).
     * @param tabla
     * @param campoBuscar
     * @param comboFiltro
     */
    
    
    
    public static void aplicarFiltro(JTable tabla, JTextField campoBuscar, JComboBox<String> comboFiltro) {
        aplicarFiltro(tabla, campoBuscar, comboFiltro, null);
    }

    public static void aplicarFiltro(JTable tabla, JTextField campoBuscar, JComboBox<String> comboFiltro, JComboBox<String> comboEstado) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(sorter);

        String texto = campoBuscar.getText().trim();
        String filtroSeleccionado = comboFiltro.getSelectedItem().toString();
        String estadoSeleccionado = comboEstado != null ? comboEstado.getSelectedItem().toString() : "";

        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        if (!texto.isEmpty()) {
            filtros.add(RowFilter.regexFilter("(?i)" + texto, obtenerIndiceColumna(tabla, filtroSeleccionado)));
        }

        if (comboEstado != null && !estadoSeleccionado.equals("Todos")) {
            filtros.add(RowFilter.regexFilter("(?i)" + estadoSeleccionado, obtenerIndiceColumna(tabla, "estado")));
        }

        sorter.setRowFilter(RowFilter.andFilter(filtros));
    }


    /**
     * Busca el índice de una columna por su nombre.
     * @param tabla
     * @param nombreColumna
     * @return 
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
     * Abre una ventana evitando duplicados.Si ya está visible, la lleva al frente.
     * @param ventana
     * @param contenedor
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
     * @param escritorio
     * @param formulario
     */
    public static void centrarFormulario(JDesktopPane escritorio, JInternalFrame formulario) {
        int x = (escritorio.getWidth() / 2) - (formulario.getWidth() / 2);
        int y = (escritorio.getHeight() / 2) - (formulario.getHeight() / 2);
        formulario.setLocation(x, y);
    }

    /**
     * Limpia todos los campos de texto dentro de un JPanel o contenedor.
     * @param contenedor
     */
    public static void limpiarCampos(Container contenedor) {
        for (Component c : contenedor.getComponents()) {
            if (c instanceof JTextField jTextField) {
                jTextField.setText("");
            } else if (c instanceof JPasswordField jPasswordField) {
                jPasswordField.setText("");
            } else if (c instanceof JComboBox) {
                ((JComboBox<?>) c).setSelectedIndex(0);
            } else if (c instanceof Container container) {
                limpiarCampos(container);
            }
        }
    }
    public static void abrirVentanaModal(JFrame parent, JDialog dialog) {
        if (dialog == null) {
            throw new IllegalArgumentException("El diálogo no puede ser null");
        }

        if (!dialog.isVisible()) {
            dialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL); // Asegura bloqueo total
            dialog.setLocationRelativeTo(parent); // Centrar respecto al padre
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cierra sin dejar residuos
            dialog.setVisible(true); // Mostrar y bloquear
        } else {
            dialog.toFront(); // Si ya está visible, traer al frente
        }
    }

}

/**
 *
 * @author kenne
 */
/*<<<<<<<< HEAD:src/Controladores/ctrlTabla.java
public class ctrlTabla {
    
}
========
>>>>>>>> e59aa079cf2045f86d9fb2b5f7752d515b16faf4:src/Controladores/ctrl_Tabla.java*/
