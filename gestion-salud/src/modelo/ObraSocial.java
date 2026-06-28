package modelo;

public class ObraSocial {

    private int idObraSocial;
    private String nombre;
    private String codigo;
    private String email;
    private String telefono;

    public ObraSocial(String nombre, String codigo, String telefono, String email) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.email = email;
        this.telefono = telefono;
    }

    public void mostrarInformacion() {
        System.out.println("===== OBRA SOCIAL =====");
        System.out.println("ID: " + idObraSocial);
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public void setIdObraSocial(int idObraSocial) {
        this.idObraSocial = idObraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}