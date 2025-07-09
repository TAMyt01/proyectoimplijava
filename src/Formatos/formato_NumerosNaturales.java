package Formatos;

import javax.swing.text.*;

public class formato_NumerosNaturales extends DocumentFilter {

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
        if (esValido(text)) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (esValido(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean esValido(String texto) {
        return texto.matches("\\d+"); // Solo números del 0 al 9
    }
}
