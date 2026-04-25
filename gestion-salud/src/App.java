import dao.PacienteDAO;
import dao.TurnoDAO;
import conexion.ConexionDB;
import modelo.Turno;
import dao.OrdenMedicaDAO;
import modelo.OrdenMedica;
import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {

        // Probar conexión
        ConexionDB.conectar();

        // Guardar paciente
        PacienteDAO pacienteDAO = new PacienteDAO();
        pacienteDAO.guardar("Agustina", "Bize", "123456789");

        // Guardar turno
        TurnoDAO turnoDAO = new TurnoDAO();

        Turno turno = new Turno(
            1,
            LocalDate.now(),
            LocalTime.of(10, 0),
            "pendiente"
        );

        turnoDAO.guardar(turno);

        OrdenMedicaDAO ordenDAO = new OrdenMedicaDAO();

        OrdenMedica orden = new OrdenMedica(
            1,
            1,
            1,
            LocalDate.now(),
            "Control odontológico general",
            "Consulta odontológica",
            "PENDIENTE",
            "Orden generada desde prototipo Java"
        );

        ordenDAO.guardar(orden);




    }

    
}