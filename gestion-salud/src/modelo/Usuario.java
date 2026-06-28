package modelo;

public class Usuario {

    private int idUsuario;
    private int idPersona;
    private String username;
    private String password;
    private boolean activo;

    public Usuario(int idPersona, String username, String password, boolean activo) {
        this.idPersona = idPersona;
        this.username = username;
        this.password = password;
        this.activo = activo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    // En un sistema real esta contraseña debería almacenarse con hash (BCrypt, Argon2, etc.)
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void mostrarInformacion() {
        System.out.println("===== USUARIO =====");
        System.out.println("ID Usuario: " + idUsuario);
        System.out.println("ID Persona: " + idPersona);
        System.out.println("Usuario: " + username);
        System.out.println("Activo: " + (activo ? "Sí" : "No"));
    }
}