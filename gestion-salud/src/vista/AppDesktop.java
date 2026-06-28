package vista;

import javax.swing.*;

import java.awt.*;

public class AppDesktop extends JFrame {

    public AppDesktop() {

        setTitle("Sistema de Gestión de Salud");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel superior
        JPanel panelSuperior = new JPanel(new BorderLayout());

        JLabel titulo = new JLabel(
                "Sistema de Gestión de Órdenes Médicas y Turnos",
                SwingConstants.CENTER);

        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));

        panelSuperior.add(titulo, BorderLayout.CENTER);
        panelSuperior.add(btnSalir, BorderLayout.EAST);

        // Pestañas
        JTabbedPane pestañas = new JTabbedPane();

        pestañas.addTab("Pacientes", crearPanelPacientes());
        pestañas.addTab("Turnos", crearPanelTurnos());
        pestañas.addTab("Órdenes Médicas", crearPanelOrdenes());
        pestañas.addTab("Obras Sociales", crearPanelObrasSociales());

        add(panelSuperior, BorderLayout.NORTH);
        add(pestañas, BorderLayout.CENTER);
    }

    private JPanel crearPanelPacientes() {

        JPanel panel = new JPanel(new GridLayout(2, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(80, 250, 80, 250));

        JButton btnRegistrar = new JButton("Registrar paciente");
        JButton btnBuscar = new JButton("Buscar paciente por DNI");

        btnRegistrar.addActionListener(e -> new RegistrarPacienteForm().setVisible(true));
        btnBuscar.addActionListener(e -> new BuscarPacienteForm().setVisible(true));

        panel.add(btnRegistrar);
        panel.add(btnBuscar);

        return panel;
    }

    private JPanel crearPanelTurnos() {

        JPanel panel = new JPanel(new GridLayout(2, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(100, 250, 100, 250));

        JButton btnRegistrar = new JButton("Registrar turno");
        JButton btnConsultar = new JButton("Consultar turnos");

        btnRegistrar.addActionListener(e -> new RegistrarTurnoForm().setVisible(true));
        btnConsultar.addActionListener(e -> new ConsultarTurnosForm().setVisible(true));

        panel.add(btnRegistrar);
        panel.add(btnConsultar);

        return panel;
    }

    private JPanel crearPanelOrdenes() {

        JPanel panel = new JPanel(new GridLayout(1, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(120, 250, 120, 250));

        JButton btnRegistrar = new JButton("Registrar orden médica");
        btnRegistrar.addActionListener(e -> new RegistrarOrdenMedicaForm().setVisible(true));

        panel.add(btnRegistrar);

        return panel;
    }

    private JPanel crearPanelObrasSociales() {

        JPanel panel = new JPanel(new GridLayout(1, 1, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(120, 250, 120, 250));

        JButton btnRegistrar = new JButton("Registrar obra social");
        btnRegistrar.addActionListener(e -> new RegistrarObraSocialForm().setVisible(true));

        panel.add(btnRegistrar);

        return panel;
    }
}