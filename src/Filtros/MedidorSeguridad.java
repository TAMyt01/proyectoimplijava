package filtros;

public class MedidorSeguridad {

    public static int calcularNivel(String password) {
        int nivel = 0;

        if (password.length() >= 8) nivel++;
        if (password.matches(".*[a-z].*")) nivel++;
        if (password.matches(".*[A-Z].*")) nivel++;
        if (password.matches(".*\\d.*")) nivel++;
        if (password.matches(".*[@#$%^&+=!_\\*-].*")) nivel++;

        return nivel;
    }

    public static String obtenerEtiqueta(int nivel) {
        return switch (nivel) {
            case 0, 1 -> "Muy débil";
            case 2 -> "Débil";
            case 3 -> "Media";
            case 4 -> "Fuerte";
            case 5 -> "Muy fuerte";
            default -> "";
        };
    }
}
