package modelo;

public class Administrador extends Persona {

    public Administrador(String nombre, String apellido, String dni) {
        super(nombre, apellido, dni, "ADMINISTRADOR");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("===== ADMINISTRADOR =====");
        System.out.println("ID Persona: " + getIdPersona());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("DNI: " + getDni());
        System.out.println("Rol: " + getRol());
    }
}
