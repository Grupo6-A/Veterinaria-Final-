package Login;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Registro_Cliente.RegistroCliente;
import Registro_Cliente.Registro_Cliente;
import Menu.MenuPrincipal_Cliente;
import Menu.Menu_Cliente;

import java.awt.event.*;

public class Login_Cliente extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField txtNombre, txtContraseña, txtIDUsuario;
    private JButton btnNewButton;
    private JButton btnRegresar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login_Cliente frame = new Login_Cliente();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Login_Cliente() {
        setTitle("Login Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 257);
        setLocationRelativeTo(null); // Centrar ventana

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Inicio de Sesión");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(147, 30, 166, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setBounds(83, 103, 89, 14);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contraseña:");
        lblNewLabel_2.setBounds(83, 128, 89, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("ID Usuario:");
        lblNewLabel_3.setBounds(83, 78, 89, 14);
        contentPane.add(lblNewLabel_3);

        txtNombre = new JTextField();
        txtNombre.setBounds(182, 100, 116, 20);
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        txtContraseña = new JTextField();
        txtContraseña.setBounds(182, 125, 116, 20);
        contentPane.add(txtContraseña);
        txtContraseña.setColumns(10);

        txtIDUsuario = new JTextField();
        txtIDUsuario.setBounds(182, 75, 116, 20);
        contentPane.add(txtIDUsuario);
        txtIDUsuario.setColumns(10);

        btnNewButton = new JButton("Iniciar Sesión");
        btnNewButton.addActionListener(this);
        btnNewButton.setBounds(137, 153, 126, 23);
        contentPane.add(btnNewButton);
        
        btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(this);
        btnRegresar.setBounds(147, 184, 101, 23);
        contentPane.add(btnRegresar);
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == btnRegresar) {
    		do_btnRegresar_actionPerformed(e);
    	}
        if (e.getSource() == btnNewButton) {
            do_btnNewButton_actionPerformed(e);
        }
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        String nom = txtNombre.getText().trim();
        String contraseña = txtContraseña.getText().trim();
        int id;

        try {
            id = Integer.parseInt(txtIDUsuario.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID de usuario debe ser un número.");
            return;
        }

        RegistroCliente cliente = Registro_Cliente.mapaClientes.get(id);
        if (cliente != null && cliente.getNombre().equals(nom) && cliente.getContraseña().equals(contraseña)) {
            JOptionPane.showMessageDialog(this,
                "✅ Ingreso correctamente.\nBienvenido, " + cliente.getNombre() + "!",
                "Login exitoso",
                JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            MenuPrincipal_Cliente mpcliente = new MenuPrincipal_Cliente();
            mpcliente.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Datos incorrectos, intente nuevamente.");
        }
    }
	protected void do_btnRegresar_actionPerformed(ActionEvent e) {
		 this.dispose(); 
		    Menu_Cliente menu = new Menu_Cliente(); 
		    menu.setVisible(true); 
	}
}

