package modelo;

public class Paciente extends Persona {

    private int idPaciente;
    private String telefono;
    private String email;
    private String numeroAfiliado;

    public Paciente(String nombre, String apellido, String dni,
                    String telefono, String email, String numeroAfiliado) {

        super(nombre, apellido, dni, "PACIENTE");

        this.telefono = telefono;
        this.email = email;
        this.numeroAfiliado = numeroAfiliado;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("===== PACIENTE =====");
        System.out.println("ID Persona: " + getIdPersona());
        System.out.println("ID Paciente: " + idPaciente);
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("DNI: " + getDni());
        System.out.println("Teléfono: " + telefono);
        System.out.println("Email: " + email);
        System.out.println("N° Afiliado: " + numeroAfiliado);
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumeroAfiliado(String numeroAfiliado) {
        this.numeroAfiliado = numeroAfiliado;
    }
}