import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import conexion.ConexionDB;
import dao.PacienteDAO;
import dao.TurnoDAO;
import dao.OrdenMedicaDAO;

import modelo.Paciente;
import modelo.Persona;
import modelo.Turno;
import modelo.OrdenMedica;
import modelo.ObraSocial;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        PacienteDAO pacienteDAO = new PacienteDAO();
        TurnoDAO turnoDAO = new TurnoDAO();
        OrdenMedicaDAO ordenDAO = new OrdenMedicaDAO();

        try {
            ConexionDB.conectar();
        } catch (Exception e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        do {
            System.out.println("\n===== SISTEMA DE GESTIÓN DE SALUD =====");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Registrar turno");
            System.out.println("3. Registrar orden médica");
            System.out.println("4. Crear obra social");
            System.out.println("5. Mostrar información de paciente");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        Paciente paciente = new Paciente(
                                "Romina",
                                "Caceres",
                                "11111111",
                                "3834765643",
                                "romi_caceres@gmail.com",
                                "0111111"
                        );

                        paciente.mostrarInformacion();

                        pacienteDAO.guardar(
                                paciente.getNombre(),
                                paciente.getApellido(),
                                paciente.getDni()
                        );
                        break;

                    case 2:
                        Turno turno = new Turno(
                                1,
                                LocalDate.now(),
                                LocalTime.of(10, 0),
                                "pendiente"
                        );

                        turnoDAO.guardar(turno);
                        break;

                    case 3:
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
                        break;

                    case 4:
                        ObraSocial obraSocial = new ObraSocial(
                                1,
                                "OSDE",
                                "001"
                        );

                        obraSocial.mostrarInformacion();
                        break;

                    case 5:
                        Persona persona = new Paciente(
                                "Agustina",
                                "Bize",
                                "123456789",
                                "3834000000",
                                "agustina@gmail.com",
                                "AF001"
                        );

                        persona.mostrarInformacion();
                        break;

                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número válido.");
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }

        } while (opcion != 6);

        scanner.close();
    }
}