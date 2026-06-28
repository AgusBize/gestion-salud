package vista;

import javax.swing.*;
import java.awt.*;

import dao.PacienteDAO;
import modelo.Paciente;
import util.Validaciones;

public class RegistrarPacienteForm extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtDni;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtAfiliado;

    private PacienteDAO pacienteDAO = new PacienteDAO();

    public RegistrarPacienteForm() {
        setTitle("Registrar Paciente");
        setSize(450, 420);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        txtNombre = new JTextField();
        txtApellido = new JTextField();
        txtDni = new JTextField();
        txtTelefono = new JTextField();
        txtEmail = new JTextField();
        txtAfiliado = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCerrar = new JButton("Cerrar");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido:"));
        panel.add(txtApellido);

        panel.add(new JLabel("DNI:"));
        panel.add(txtDni);

        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);

        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        panel.add(new JLabel("N° Afiliado:"));
        panel.add(txtAfiliado);

        panel.add(btnGuardar);
        panel.add(btnCerrar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarPaciente());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void guardarPaciente() {

        if (Validaciones.estaVacio(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre.");
            txtNombre.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtApellido.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el apellido.");
            txtApellido.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtDni.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el DNI.");
            txtDni.requestFocus();
            return;
        }

        if (!Validaciones.esNumero(txtDni.getText())) {
            JOptionPane.showMessageDialog(this, "El DNI debe contener solo números.");
            txtDni.requestFocus();
            return;
        }

        if (!Validaciones.esEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un email válido.");
            txtEmail.requestFocus();
            return;
        }

         if (Validaciones.estaVacio(txtAfiliado.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el Numero de Afiliado.");
            txtDni.requestFocus();
            return;
        }

        try {

            Paciente paciente = new Paciente(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtDni.getText(),
                    txtTelefono.getText(),
                    txtEmail.getText(),
                    txtAfiliado.getText());

            pacienteDAO.guardar(paciente);

            JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");

            limpiarCampos();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, e.getMessage());

        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtAfiliado.setText("");
    }
}