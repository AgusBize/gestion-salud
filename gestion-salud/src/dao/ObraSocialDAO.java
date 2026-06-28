package dao;

import conexion.ConexionDB;
import modelo.ObraSocial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ObraSocialDAO {

    public void guardar(ObraSocial obraSocial) {

        String sql = "INSERT INTO obra_social(nombre, codigo) VALUES (?, ?)";

        try (Connection con = ConexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, obraSocial.getNombre());
            ps.setString(2, obraSocial.getCodigo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                obraSocial.setIdObraSocial(rs.getInt(1));
            }

            System.out.println("Obra social guardada ✔");

        } catch (Exception e) {
            System.out.println("Error al guardar obra social: " + e.getMessage());
        }
    }
}