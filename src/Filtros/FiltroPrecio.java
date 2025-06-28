/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Filtros;
import javax.swing.text.*;
import java.awt.Toolkit;

public class FiltroPrecio extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
            throws BadLocationException {
        String nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .insert(offset, string)
                .toString();

        if (esValido(nuevoTexto)) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
            throws BadLocationException {
        String nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .replace(offset, offset + length, text)
                .toString();

        if (esValido(nuevoTexto)) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length)
            throws BadLocationException {
        String nuevoTexto = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()))
                .delete(offset, offset + length)
                .toString();

        if (esValido(nuevoTexto)) {
            super.remove(fb, offset, length);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private boolean esValido(String texto) {
        if (texto.isEmpty()) {
            return true;
        }

        // Solo números con hasta 2 decimales positivos
        return texto.matches("^\\d{0,9}(\\.\\d{0,2})?$");
    }
}
