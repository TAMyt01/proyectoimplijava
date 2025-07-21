package Formatos;

import javax.swing.text.*;
import java.util.regex.Pattern;
import java.awt.Toolkit;

public class formato_Password extends DocumentFilter {

    private static final String PERMITIDOS = "A-Za-z0-9@#$%^&+=!_\\*\\-.()[]{}|^~,:;?<>,'\"/";
    private static final int MAX_LONGITUD = 16;

    private final Pattern pattern = Pattern.compile("^[" + PERMITIDOS + "]{0," + MAX_LONGITUD + "}$");

    private boolean esValido(String texto) {
        return pattern.matcher(texto).matches();
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) return;
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, string);
        if (esValido(sb.toString())) {
            super.insertString(fb, offset, string, attr);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.replace(offset, offset + length, text == null ? "" : text);
        if (esValido(sb.toString())) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }
}
