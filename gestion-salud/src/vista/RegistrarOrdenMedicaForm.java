package vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

import dao.OrdenMedicaDAO;
import modelo.OrdenMedica;
import util.Validaciones;

public class RegistrarOrdenMedicaForm extends JFrame {

    private JTextField txtIdPaciente;
    private JTextField txtIdObraSocial;
    private JTextField txtIdTurno;
    private JTextField txtFecha;
    private JTextField txtDiagnostico;
    private JTextField txtPractica;
    private JTextField txtEstado;
    private JTextField txtObservaciones;

    private OrdenMedicaDAO ordenDAO = new OrdenMedicaDAO();

    public RegistrarOrdenMedicaForm() {

        setTitle("Registrar Orden Médica");
        setSize(500, 450);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        txtIdPaciente = new JTextField();
        txtIdObraSocial = new JTextField();
        txtIdTurno = new JTextField();
        txtFecha = new JTextField();
        txtDiagnostico = new JTextField();
        txtPractica = new JTextField();
        txtEstado = new JTextField("PENDIENTE");
        txtObservaciones = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCerrar = new JButton("Cerrar");

        panel.add(new JLabel("ID Paciente"));
        panel.add(txtIdPaciente);

        panel.add(new JLabel("ID Obra Social"));
        panel.add(txtIdObraSocial);

        panel.add(new JLabel("ID Turno"));
        panel.add(txtIdTurno);

        panel.add(new JLabel("Fecha (AAAA-MM-DD)"));
        panel.add(txtFecha);

        panel.add(new JLabel("Diagnóstico"));
        panel.add(txtDiagnostico);

        panel.add(new JLabel("Práctica"));
        panel.add(txtPractica);

        panel.add(new JLabel("Estado"));
        panel.add(txtEstado);

        panel.add(new JLabel("Observaciones"));
        panel.add(txtObservaciones);

        panel.add(btnGuardar);
        panel.add(btnCerrar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarOrden());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void guardarOrden() {

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

        if (Validaciones.estaVacio(txtIdObraSocial.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID de la obra social.");
            txtIdObraSocial.requestFocus();
            return;
        }

        if (!Validaciones.esNumero(txtIdObraSocial.getText())) {
            JOptionPane.showMessageDialog(this, "El ID de la obra social debe ser numérico.");
            txtIdObraSocial.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtIdTurno.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el ID del turno.");
            txtIdTurno.requestFocus();
            return;
        }

        if (!Validaciones.esNumero(txtIdTurno.getText())) {
            JOptionPane.showMessageDialog(this, "El ID del turno debe ser numérico.");
            txtIdTurno.requestFocus();
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

        if (Validaciones.estaVacio(txtDiagnostico.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el diagnóstico.");
            txtDiagnostico.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtPractica.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la práctica.");
            txtPractica.requestFocus();
            return;
        }

        try {

            OrdenMedica orden = new OrdenMedica(
                    Integer.parseInt(txtIdPaciente.getText()),
                    Integer.parseInt(txtIdObraSocial.getText()),
                    Integer.parseInt(txtIdTurno.getText()),
                    LocalDate.parse(txtFecha.getText()),
                    txtDiagnostico.getText(),
                    txtPractica.getText(),
                    txtEstado.getText(),
                    txtObservaciones.getText());

            ordenDAO.guardar(orden);

            JOptionPane.showMessageDialog(
                    this,
                    "Orden médica registrada correctamente.");

            limpiarCampos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage());

        }

    }

    private void limpiarCampos() {

        txtIdPaciente.setText("");
        txtIdObraSocial.setText("");
        txtIdTurno.setText("");
        txtFecha.setText("");
        txtDiagnostico.setText("");
        txtPractica.setText("");
        txtEstado.setText("PENDIENTE");
        txtObservaciones.setText("");

    }

}