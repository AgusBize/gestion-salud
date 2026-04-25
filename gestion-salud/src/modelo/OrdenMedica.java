package modelo;

import java.time.LocalDate;

public class OrdenMedica {

    private int idPaciente;
    private int idObraSocial;
    private Integer idTurno;
    private LocalDate fechaEmision;
    private String diagnostico;
    private String practica;
    private String estado;
    private String observaciones;

    public OrdenMedica(int idPaciente, int idObraSocial, Integer idTurno, LocalDate fechaEmision,
                       String diagnostico, String practica, String estado, String observaciones) {
        this.idPaciente = idPaciente;
        this.idObraSocial = idObraSocial;
        this.idTurno = idTurno;
        this.fechaEmision = fechaEmision;
        this.diagnostico = diagnostico;
        this.practica = practica;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public int getIdPaciente() { return idPaciente; }
    public int getIdObraSocial() { return idObraSocial; }
    public Integer getIdTurno() { return idTurno; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public String getDiagnostico() { return diagnostico; }
    public String getPractica() { return practica; }
    public String getEstado() { return estado; }
    public String getObservaciones() { return observaciones; }
}