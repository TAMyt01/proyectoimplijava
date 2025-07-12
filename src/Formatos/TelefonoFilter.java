
package Formatos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;

public class TelefonoFilter extends DocumentFilter{
    
    private final JTextField campo;

    public TelefonoFilter(JTextField campo) {
        this.campo = campo;
    }

    // Quitar todo lo que no sea número
    private String limpiar(String texto) {
        return texto.replaceAll("[^\\d]", "");
    }

    // Formatear como XXXX-XXXX
    private String formatear(String limpio) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < limpio.length(); i++) {
            sb.append(limpio.charAt(i));
            if (i == 3 && limpio.length() > 4) {
                sb.append("-");
            }
        }
        return sb.toString();
    }

    // Cambiar el borde del campo
    private void actualizarBorde(String limpio) {
        if (limpio.length() == 8) {
            campo.setBorder(new LineBorder(Color.GREEN, 2));
        } else {
            campo.setBorder(new LineBorder(Color.RED, 2));
        }
    }

    private void actualizarTexto(FilterBypass fb, String textoSinGuiones, AttributeSet attrs) throws BadLocationException {
        if (textoSinGuiones.length() > 8) return;

        String formateado = formatear(textoSinGuiones);
        fb.replace(0, fb.getDocument().getLength(), formateado, attrs);
        actualizarBorde(textoSinGuiones);
    }

    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null) {
            replace(fb, offset, 0, string, attr);
        }
    }

   
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        Document doc = fb.getDocument();
        String contenido = doc.getText(0, doc.getLength());

        StringBuilder sb = new StringBuilder(contenido);
        sb.replace(offset, offset + length, text == null ? "" : text);
        String limpio = limpiar(sb.toString());

        actualizarTexto(fb, limpio, attrs);
    }

  
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        Document doc = fb.getDocument();
        String contenido = doc.getText(0, doc.getLength());

        StringBuilder sb = new StringBuilder(contenido);
        sb.delete(offset, offset + length);
        String limpio = limpiar(sb.toString());

        actualizarTexto(fb, limpio, null);
    }
}
