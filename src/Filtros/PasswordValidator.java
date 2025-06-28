package filtros;

import java.util.regex.Pattern;

public class PasswordValidator {

   // Regex para validar contraseña según requisitos
    private static final String PASSWORD_PATTERN =
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!_\\*-])[^\s'\";\\\\-]{8,16}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean validarPassword(String password) {
        if (password == null) return false;
        return pattern.matcher(password).matches();
    }
}
