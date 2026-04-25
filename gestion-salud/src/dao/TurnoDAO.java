package dao;

import conexion.ConexionDB;
import java.sql.*;
import modelo.Turno;

public class TurnoDAO {

    public boolean existeTurno(int idPaciente, String fecha, String hora) {
        String sql = "SELECT * FROM turno WHERE fecha = ? AND hora = ?";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fecha);
            ps.setString(2, hora);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return true;
        }
    }

    public void guardar(Turno turno) {

        if (existeTurno(turno.getIdPaciente(), turno.getFecha().toString(), turno.getHora().toString())) {
            System.out.println("❌ Ya existe un turno en ese horario");
            return;
        }

        String sql = "INSERT INTO turno(id_paciente, fecha, hora, estado) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, turno.getIdPaciente());
            ps.setString(2, turno.getFecha().toString());
            ps.setString(3, turno.getHora().toString());
            ps.setString(4, turno.getEstado());

            ps.executeUpdate();
            System.out.println("Turno guardado ✔");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}