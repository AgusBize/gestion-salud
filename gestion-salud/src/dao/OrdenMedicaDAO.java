package dao;

import conexion.ConexionDB;
import modelo.OrdenMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Types;

public class OrdenMedicaDAO {

    public boolean validarOrden(OrdenMedica orden) {
        if (orden.getDiagnostico() == null || orden.getDiagnostico().isEmpty()) {
            System.out.println("❌ El diagnóstico es obligatorio");
            return false;
        }

        if (orden.getPractica() == null || orden.getPractica().isEmpty()) {
            System.out.println("❌ La práctica es obligatoria");
            return false;
        }

        if (orden.getIdPaciente() <= 0) {
            System.out.println("❌ Paciente inválido");
            return false;
        }

        if (orden.getIdObraSocial() <= 0) {
            System.out.println("❌ Obra social inválida");
            return false;
        }

        return true;
    }

    public void guardar(OrdenMedica orden) {

        if (!validarOrden(orden)) {
            return;
        }

        String sql = "INSERT INTO orden_medica(id_paciente, id_obra_social, id_turno, fecha_emision, diagnostico, practica, estado, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, orden.getIdPaciente());
            ps.setInt(2, orden.getIdObraSocial());

            if (orden.getIdTurno() != null) {
                ps.setInt(3, orden.getIdTurno());
            } else {
                ps.setNull(3, Types.INTEGER);
            }

            ps.setString(4, orden.getFechaEmision().toString());
            ps.setString(5, orden.getDiagnostico());
            ps.setString(6, orden.getPractica());
            ps.setString(7, orden.getEstado());
            ps.setString(8, orden.getObservaciones());

            ps.executeUpdate();
            System.out.println("Orden médica guardada ✔");

        } catch (Exception e) {
            System.out.println("Error al guardar orden médica: " + e.getMessage());
        }
    }
}