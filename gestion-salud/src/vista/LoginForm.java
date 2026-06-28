package vista;
import javax.swing.*;
import java.awt.*;

import dao.UsuarioDAO;
import modelo.Usuario;

public class LoginForm extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public LoginForm() {
        setTitle("Inicio de sesión");
        setSize(360, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        JButton btnIngresar = new JButton("Ingresar");
        JButton btnSalir = new JButton("Salir");

        panel.add(new JLabel("Usuario:"));
        panel.add(txtUsuario);

        panel.add(new JLabel("Contraseña:"));
        panel.add(txtPassword);

        panel.add(btnIngresar);
        panel.add(btnSalir);

        add(panel);

        btnIngresar.addActionListener(e -> iniciarSesion());
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void iniciarSesion() {
        String username = txtUsuario.getText();
        String password = new String(txtPassword.getPassword());

        Usuario usuario = usuarioDAO.login(username, password);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Acceso permitido");

            AppDesktop app = new AppDesktop();
            app.setVisible(true);

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm login = new LoginForm();
            login.setVisible(true);
        });
    }
}