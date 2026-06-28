package dao;

import conexion.ConexionDB;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UsuarioDAO {

    public void guardar(Usuario usuario) {

        String sql = "INSERT INTO usuario(id_persona, username, password, activo) VALUES (?, ?, ?, ?)";

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, usuario.getIdPersona());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setBoolean(4, usuario.isActivo());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt(1));
            }

            System.out.println("Usuario guardado ✔");

        } catch (Exception e) {
            System.out.println("Error al guardar usuario: " + e.getMessage());
        }
    }

    public Usuario login(String username, String password) {

        String sql = """
                SELECT
                    u.id_usuario,
                    u.id_persona,
                    u.username,
                    u.password,
                    u.activo,
                    p.rol
                FROM usuario u
                JOIN persona p ON u.id_persona = p.id_persona
                WHERE u.username = ?
                  AND u.password = ?
                  AND u.activo = true
                """;

        try (Connection con = ConexionDB.conectar();
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_persona"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("activo"));

                usuario.setIdUsuario(rs.getInt("id_usuario"));

                System.out.println("Login correcto. Rol: " + rs.getString("rol"));

                return usuario;
            }

        } catch (Exception e) {
            System.out.println("Error en login: " + e.getMessage());
        }

        return null;
    }
}