package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

import dao.TurnoDAO;
import modelo.Turno;

public class ConsultarTurnosForm extends JFrame {

    private JTable tablaTurnos;
    private TurnoDAO turnoDAO = new TurnoDAO();

    public ConsultarTurnosForm() {
        setTitle("Consultar Turnos");
        setSize(650, 400);
        setLocationRelativeTo(null);

        String[] columnas = {"ID Turno", "ID Paciente", "Fecha", "Hora", "Estado"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        tablaTurnos = new JTable(modeloTabla);

        JScrollPane scroll = new JScrollPane(tablaTurnos);

        JButton btnActualizar = new JButton("Actualizar");
        JButton btnCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnActualizar);
        panelBotones.add(btnCerrar);

        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnActualizar.addActionListener(e -> cargarTurnos());
        btnCerrar.addActionListener(e -> dispose());

        cargarTurnos();
    }

    private void cargarTurnos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaTurnos.getModel();
        modeloTabla.setRowCount(0);

        List<Turno> turnos = turnoDAO.listarTurnos();

        for (Turno turno : turnos) {
            Object[] fila = {
                    turno.getIdTurno(),
                    turno.getIdPaciente(),
                    turno.getFecha(),
                    turno.getHora(),
                    turno.getEstado()
            };

            modeloTabla.addRow(fila);
        }
    }
}