package conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionDB {
     private static final String URL = "jdbc:mysql://localhost:3306/gestion_salud";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // dejalo vacío si no pusiste password

    public static Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado a MySQL 🚀");
            return con;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
    
}
