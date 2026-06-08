package modelo;

public class ObraSocial {

    private int idObraSocial;
    private String nombre;
    private String codigo;

    public ObraSocial(int idObraSocial, String nombre, String codigo) {
        this.idObraSocial = idObraSocial;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public void mostrarInformacion() {
        System.out.println("Obra social: " + nombre);
        System.out.println("Código: " + codigo);
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }
}