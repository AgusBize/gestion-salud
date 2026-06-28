package dao;

import conexion.ConexionDB;
import modelo.Turno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class TurnoDAO {

    public void guardar(Turno turno) {

        String sql = """
                INSERT INTO turno
                (id_paciente, fecha, hora, estado)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, turno.getIdPaciente());
            ps.setDate(2, java.sql.Date.valueOf(turno.getFecha()));
            ps.setTime(3, java.sql.Time.valueOf(turno.getHora()));
            ps.setString(4, turno.getEstado());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                turno.setIdTurno(rs.getInt(1));
            }

            System.out.println("Turno guardado ✔");

        } catch (Exception e) {
            System.out.println("Error al guardar turno: " + e.getMessage());
        }
    }

    public List<Turno> listarTurnos() {

        List<Turno> turnos = new ArrayList<>();

        String sql = """
                SELECT
                    id_turno,
                    id_paciente,
                    fecha,
                    hora,
                    estado
                FROM turno
                ORDER BY fecha, hora
                """;

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Turno turno = new Turno(
                        rs.getInt("id_paciente"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime(),
                        rs.getString("estado"));

                turno.setIdTurno(rs.getInt("id_turno"));

                turnos.add(turno);
            }

        } catch (Exception e) {
            System.out.println("Error al listar turnos: " + e.getMessage());
        }

        return turnos;
    }
}