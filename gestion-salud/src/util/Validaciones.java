package util;

public class Validaciones {

    public static boolean estaVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean esNumero(String texto) {
        return texto.matches("\\d+");
    }

    public static boolean esEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean esFecha(String fecha) {
        return fecha.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public static boolean esHora(String hora) {
        return hora.matches("\\d{2}:\\d{2}");
    }
}