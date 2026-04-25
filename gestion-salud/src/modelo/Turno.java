package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {

    private int idTurno;
    private int idPaciente;
    private LocalDate fecha;
    private LocalTime hora;
    private String estado;

    public Turno(int idPaciente, LocalDate fecha, LocalTime hora, String estado) {
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
    }

    public int getIdPaciente() { return idPaciente; }
    public LocalDate getFecha() { return fecha; }
    public LocalTime getHora() { return hora; }
    public String getEstado() { return estado; }
}