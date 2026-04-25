package dao;

import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class PacienteDAO {
    public void guardar(String nombre, String apellido, String dni) {
        String sql = "INSERT INTO paciente(nombre, apellido, dni) VALUES (?, ?, ?)";

        try (Connection con =  ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, dni);

            ps.executeUpdate();
            System.out.println("Paciente guardado ✔");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
