package vista;
import javax.swing.*;
import java.awt.*;

import dao.PacienteDAO;
import modelo.Paciente;

public class BuscarPacienteForm extends JFrame {

    private JTextField txtDni;

    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblTelefono;
    private JLabel lblEmail;
    private JLabel lblAfiliado;

    private PacienteDAO pacienteDAO = new PacienteDAO();

    public BuscarPacienteForm() {

        setTitle("Buscar Paciente");
        setSize(450, 350);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        txtDni = new JTextField();

        lblNombre = new JLabel("-");
        lblApellido = new JLabel("-");
        lblTelefono = new JLabel("-");
        lblEmail = new JLabel("-");
        lblAfiliado = new JLabel("-");

        JButton btnBuscar = new JButton("Buscar");
        JButton btnCerrar = new JButton("Cerrar");

        panel.add(new JLabel("DNI"));
        panel.add(txtDni);

        panel.add(new JLabel("Nombre"));
        panel.add(lblNombre);

        panel.add(new JLabel("Apellido"));
        panel.add(lblApellido);

        panel.add(new JLabel("Teléfono"));
        panel.add(lblTelefono);

        panel.add(new JLabel("Email"));
        panel.add(lblEmail);

        panel.add(new JLabel("N° Afiliado"));
        panel.add(lblAfiliado);

        panel.add(btnBuscar);
        panel.add(btnCerrar);

        add(panel);

        btnBuscar.addActionListener(e -> buscarPaciente());

        btnCerrar.addActionListener(e -> dispose());

    }

    private void buscarPaciente(){

        Paciente paciente = pacienteDAO.buscarPorDni(txtDni.getText());

        if(paciente != null){

            lblNombre.setText(paciente.getNombre());
            lblApellido.setText(paciente.getApellido());
            lblTelefono.setText(paciente.getTelefono());
            lblEmail.setText(paciente.getEmail());
            lblAfiliado.setText(paciente.getNumeroAfiliado());

        }else{

            JOptionPane.showMessageDialog(this,"Paciente no encontrado");

            lblNombre.setText("-");
            lblApellido.setText("-");
            lblTelefono.setText("-");
            lblEmail.setText("-");
            lblAfiliado.setText("-");

        }

    }

}