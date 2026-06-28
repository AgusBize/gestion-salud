package vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.TurnoDAO;
import modelo.Turno;
import util.Validaciones;

public class RegistrarTurnoForm extends JFrame {

    private JTextField txtIdPaciente;
    private JTextField txtFecha;
    private JTextField txtHora;

    private TurnoDAO turnoDAO = new TurnoDAO();

    public RegistrarTurnoForm() {
        setTitle("Registrar Turno");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        txtIdPaciente = new JTextField();
        txtFecha = new JTextField();
        txtHora = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCerrar = new JButton("Cerrar");

        panel.add(new JLabel("ID Paciente:"));
        panel.add(txtIdPaciente);

        panel.add(new JLabel("Fecha (AAAA-MM-DD):"));
        panel.add(txtFecha);

        panel.add(new JLabel("Hora (HH:MM):"));
        panel.add(txtHora);

        panel.add(btnGuardar);
        panel.add(btnCerrar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarTurno());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void guardarTurno() {
        if (Validaciones.estaVacio(txtIdPaciente.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID del paciente.");
            txtIdPaciente.requestFocus();
            return;
        }

        if (!Validaciones.esNumero(txtIdPaciente.getText())) {
            JOptionPane.showMessageDialog(this, "El ID del paciente debe ser numérico.");
            txtIdPaciente.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtFecha.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la fecha.");
            txtFecha.requestFocus();
            return;
        }

        if (!Validaciones.esFecha(txtFecha.getText())) {
            JOptionPane.showMessageDialog(this, "La fecha debe tener formato AAAA-MM-DD.");
            txtFecha.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtHora.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la hora.");
            txtHora.requestFocus();
            return;
        }

        if (!Validaciones.esHora(txtHora.getText())) {
            JOptionPane.showMessageDialog(this, "La hora debe tener formato HH:MM.");
            txtHora.requestFocus();
            return;
        }

        try {
            int idPaciente = Integer.parseInt(txtIdPaciente.getText());
            LocalDate fecha = LocalDate.parse(txtFecha.getText());
            LocalTime hora = LocalTime.parse(txtHora.getText());

            Turno turno = new Turno(
                    idPaciente,
                    fecha,
                    hora,
                    "PENDIENTE");

            turnoDAO.guardar(turno);

            JOptionPane.showMessageDialog(
                    this,
                    "Turno registrado correctamente.\nID Turno: " + turno.getIdTurno());

            limpiarCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El ID del paciente debe ser numérico.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar turno: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtIdPaciente.setText("");
        txtFecha.setText("");
        txtHora.setText("");
    }
}
