package dao;

import conexion.ConexionDB;
import modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PersonaDAO {

    public int guardar(Persona persona) {

        String sql = "INSERT INTO persona(nombre, apellido, dni, rol) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getDni());
            ps.setString(4, persona.getRol());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                int idGenerado = rs.getInt(1);
                persona.setIdPersona(idGenerado);

                System.out.println("Persona guardada ✔ ID: " + idGenerado);
                return idGenerado;
            }

        } catch (Exception e) {
            System.out.println("Error al guardar persona: " + e.getMessage());
        }

        return -1;
    }
}