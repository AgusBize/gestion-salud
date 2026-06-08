package modelo;

public class Paciente extends Persona {

    private String telefono;
    private String email;
    private String numeroAfiliado;

    public Paciente(
            String nombre,
            String apellido,
            String dni,
            String telefono,
            String email,
            String numeroAfiliado) {

        super(nombre, apellido, dni);
        this.telefono = telefono;
        this.email = email;
        this.numeroAfiliado = numeroAfiliado;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Paciente: " + nombre + " " + apellido);
        System.out.println("DNI: " + dni);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("Afiliado: " + numeroAfiliado);
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroAfiliado() {
        return numeroAfiliado;
    }
}