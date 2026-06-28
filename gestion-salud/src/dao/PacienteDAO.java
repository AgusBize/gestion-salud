package dao;

import conexion.ConexionDB;
import modelo.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PacienteDAO {

    private PersonaDAO personaDAO = new PersonaDAO();

    public void guardar(Paciente paciente) {

        // 1. Primero guardamos los datos comunes en persona
        int idPersona = personaDAO.guardar(paciente);

        if (idPersona == -1) {
            System.out.println("No se pudo guardar el paciente porque falló el registro de persona.");
            return;
        }

        paciente.setIdPersona(idPersona);

        // 2. Luego guardamos los datos específicos del paciente
        String sql = "INSERT INTO paciente(id_persona, telefono, email, numero_afiliado, id_obra_social) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, paciente.getIdPersona());
            ps.setString(2, paciente.getTelefono());
            ps.setString(3, paciente.getEmail());
            ps.setString(4, paciente.getNumeroAfiliado());
            ps.setInt(5, 1); // Por ahora usamos OSDE como obra social de prueba

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
            }

            System.out.println("Paciente guardado ✔");

        } catch (Exception e) {
            System.out.println("Error al guardar paciente: " + e.getMessage());
        }
    }

    public Paciente buscarPorDni(String dni) {

        String sql = """
                    SELECT
                        pa.id_paciente,
                        pe.id_persona,
                        pe.nombre,
                        pe.apellido,
                        pe.dni,
                        pa.telefono,
                        pa.email,
                        pa.numero_afiliado
                    FROM persona pe
                    JOIN paciente pa ON pe.id_persona = pa.id_persona
                    WHERE pe.dni = ?
                """;

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("numero_afiliado"));

                paciente.setIdPersona(rs.getInt("id_persona"));
                paciente.setIdPaciente(rs.getInt("id_paciente"));

                return paciente;
            }

        } catch (Exception e) {
            System.out.println("Error al buscar paciente: " + e.getMessage());
        }

        return null;
    }

}