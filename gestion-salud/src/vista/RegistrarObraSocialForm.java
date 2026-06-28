package vista;

import javax.swing.*;
import java.awt.*;

import dao.ObraSocialDAO;
import modelo.ObraSocial;
import util.Validaciones;

public class RegistrarObraSocialForm extends JFrame {

    private JTextField txtNombre;
    private JTextField txtCodigo;
    private JTextField txtEmail;
    private JTextField txtTelefono;

    private ObraSocialDAO obraSocialDAO = new ObraSocialDAO();

    public RegistrarObraSocialForm() {
        setTitle("Registrar Obra Social");
        setSize(450, 320);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        txtNombre = new JTextField();
        txtCodigo = new JTextField();
        txtEmail = new JTextField();
        txtTelefono = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCerrar = new JButton("Cerrar");

        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        panel.add(new JLabel("Código:"));
        panel.add(txtCodigo);

        panel.add(new JLabel("Email:"));
        panel.add(txtEmail);

        panel.add(new JLabel("Teléfono:"));
        panel.add(txtTelefono);

        panel.add(btnGuardar);
        panel.add(btnCerrar);

        add(panel);

        btnGuardar.addActionListener(e -> guardarObraSocial());
        btnCerrar.addActionListener(e -> dispose());
    }

    private void guardarObraSocial() {

        if (Validaciones.estaVacio(txtNombre.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar la obra social.");
            txtNombre.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtCodigo.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el código de la obra social.");
            txtCodigo.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el email.");
            txtEmail.requestFocus();
            return;
        }

        if (!Validaciones.esEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un email válido.");
            txtEmail.requestFocus();
            return;
        }

        if (Validaciones.estaVacio(txtTelefono.getText())) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el teléfono.");
            txtTelefono.requestFocus();
            return;
        }

        try {
            ObraSocial obraSocial = new ObraSocial(
                    txtNombre.getText(),
                    txtCodigo.getText(),
                    txtEmail.getText(),
                    txtTelefono.getText()
            );

            obraSocialDAO.guardar(obraSocial);

            JOptionPane.showMessageDialog(
                    this,
                    "Obra social registrada correctamente.\nID: " + obraSocial.getIdObraSocial()
            );

            limpiarCampos();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error al registrar obra social: " + e.getMessage()
            );
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtCodigo.setText("");
        txtEmail.setText("");
        txtTelefono.setText("");
    }
}