package modelo;

public abstract class Persona {

    protected int idPersona;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String rol;

    public Persona(String nombre, String apellido, String dni, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.rol = rol;
    }

    public abstract void mostrarInformacion();

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}