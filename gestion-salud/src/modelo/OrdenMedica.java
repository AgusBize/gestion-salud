package modelo;

import java.time.LocalDate;

public class OrdenMedica {

    private int idOrden;
    private int idPaciente;
    private int idObraSocial;
    private Integer idTurno;
    private LocalDate fechaEmision;
    private String diagnostico;
    private String practica;
    private String estado;
    private String observaciones;

    public OrdenMedica(
            int idPaciente,
            int idObraSocial,
            Integer idTurno,
            LocalDate fechaEmision,
            String diagnostico,
            String practica,
            String estado,
            String observaciones) {

        this.idPaciente = idPaciente;
        this.idObraSocial = idObraSocial;
        this.idTurno = idTurno;
        this.fechaEmision = fechaEmision;
        this.diagnostico = diagnostico;
        this.practica = practica;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    public void mostrarInformacion() {
        System.out.println("===== ORDEN MÉDICA =====");
        System.out.println("ID Orden: " + idOrden);
        System.out.println("ID Paciente: " + idPaciente);
        System.out.println("ID Obra Social: " + idObraSocial);
        System.out.println("ID Turno: " + idTurno);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Práctica: " + practica);
        System.out.println("Estado: " + estado);
        System.out.println("Observaciones: " + observaciones);
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getIdObraSocial() {
        return idObraSocial;
    }

    public Integer getIdTurno() {
        return idTurno;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getPractica() {
        return practica;
    }

    public String getEstado() {
        return estado;
    }

    public String getObservaciones() {
        return observaciones;
    }
}