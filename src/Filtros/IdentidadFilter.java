/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filtros;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
/**
 *
 * @author JManu
 */
public class IdentidadFilter extends DocumentFilter{

  private final JTextField campo;

    public IdentidadFilter(JTextField campo) {
        this.campo = campo;
    }

    private String limpiar(String texto) {
        return texto.replaceAll("[^\\d]", "");
    }

    private String formatear(String raw) {
        StringBuilder formateado = new StringBuilder();
        for (int i = 0; i < raw.length(); i++) {
            formateado.append(raw.charAt(i));
            if (i == 3 || i == 7) {
                if (i != raw.length() - 1) {
                    formateado.append("-");
                }
            }
        }
        return formateado.toString();
    }

    private void actualizarBorde(Color color) {
        campo.setBorder(new LineBorder(color, 2));
    }

    // Nuevo método para validar que no sean todos los mismos dígitos
    private boolean todosDigitosIguales(String texto) {
        if (texto.isEmpty()) return false;
        char primero = texto.charAt(0);
        for (int i = 1; i < texto.length(); i++) {
            if (texto.charAt(i) != primero) {
                return false;
            }
        }
        return true;
    }

    private void actualizarTexto(FilterBypass fb, String textoSinGuiones, AttributeSet attrs) throws BadLocationException {
        if (textoSinGuiones.length() > 13) return;

        if (todosDigitosIguales(textoSinGuiones) && textoSinGuiones.length() == 13) {
            // Si todos son iguales y longitud es 13, mostrar borde rojo y no actualizar
            actualizarBorde(Color.RED);
            return;
        }

        String formateado = formatear(textoSinGuiones);
        fb.replace(0, fb.getDocument().getLength(), formateado, attrs);

        // Cambiar borde a verde solo si la longitud es 13 y pasa la validación
        if (textoSinGuiones.length() == 13) {
            actualizarBorde(Color.GREEN);
        } else {
            actualizarBorde(Color.RED);
        }
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null) {
            replace(fb, offset, 0, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        String contenido = doc.getText(0, doc.getLength());

        StringBuilder sb = new StringBuilder(contenido);
        sb.replace(offset, offset + length, text == null ? "" : text);
        String limpio = limpiar(sb.toString());

        actualizarTexto(fb, limpio, attrs);
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        Document doc = fb.getDocument();
        String contenido = doc.getText(0, doc.getLength());

        StringBuilder sb = new StringBuilder(contenido);
        sb.delete(offset, offset + length);
        String limpio = limpiar(sb.toString());

        actualizarTexto(fb, limpio, null);
    }
}
