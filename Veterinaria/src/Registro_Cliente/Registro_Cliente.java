package Registro_Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import Menu.Menu_Cliente;

public class Registro_Cliente extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField txtIDUsuario, txtNombre, txtApellido, txtDNI, txtCorreo, txtTelefono, txtContraseña;
    private JButton btnCrear, btnRegresar;

    // Mapa público y estático para guardar los clientes
    public static HashMap<Integer, RegistroCliente> mapaClientes = new HashMap<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Registro_Cliente frame = new Registro_Cliente();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Registro_Cliente() {
        setTitle("Registro Cliente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(130, 20, 200, 20);
        contentPane.add(lblTitulo);

        JLabel lblID = new JLabel("ID Usuario:");
        lblID.setBounds(50, 60, 100, 20);
        contentPane.add(lblID);
        txtIDUsuario = new JTextField();
        txtIDUsuario.setBounds(160, 60, 137, 20);
        contentPane.add(txtIDUsuario);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 90, 100, 20);
        contentPane.add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(160, 90, 137, 20);
        contentPane.add(txtNombre);

        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setBounds(50, 120, 100, 20);
        contentPane.add(lblApellido);
        txtApellido = new JTextField();
        txtApellido.setBounds(160, 120, 137, 20);
        contentPane.add(txtApellido);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(50, 150, 100, 20);
        contentPane.add(lblDNI);
        txtDNI = new JTextField();
        txtDNI.setBounds(160, 150, 137, 20);
        contentPane.add(txtDNI);

        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setBounds(50, 180, 100, 20);
        contentPane.add(lblCorreo);
        txtCorreo = new JTextField();
        txtCorreo.setBounds(160, 180, 137, 20);
        contentPane.add(txtCorreo);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(50, 210, 100, 20);
        contentPane.add(lblTelefono);
        txtTelefono = new JTextField();
        txtTelefono.setBounds(160, 210, 137, 20);
        contentPane.add(txtTelefono);

        JLabel lblContra = new JLabel("Contraseña:");
        lblContra.setBounds(50, 240, 100, 20);
        contentPane.add(lblContra);
        txtContraseña = new JTextField();
        txtContraseña.setBounds(160, 240, 137, 20);
        contentPane.add(txtContraseña);

        btnCrear = new JButton("Crear");
        btnCrear.setBounds(90, 280, 100, 30);
        btnCrear.addActionListener(this);
        contentPane.add(btnCrear);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(230, 280, 100, 30);
        btnRegresar.addActionListener(this);
        contentPane.add(btnRegresar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCrear) {
            do_btnCrear_actionPerformed(e);
        } else if (e.getSource() == btnRegresar) {
            do_btnRegresar_actionPerformed(e);
        }
    }

    protected void do_btnCrear_actionPerformed(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtIDUsuario.getText().trim());
            int dni = Integer.parseInt(txtDNI.getText().trim());
            int tel = Integer.parseInt(txtTelefono.getText().trim());

            RegistroCliente nuevo = new RegistroCliente(
                id,
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                dni,
                txtCorreo.getText().trim(),
                tel,
                txtContraseña.getText().trim()
            );

            // Guardar cliente en el mapa
            mapaClientes.put(id, nuevo);

            JOptionPane.showMessageDialog(this, "Cliente registrado correctamente.");

            // Limpia los campos después de registrar
            limpiarCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Verifica que todos los campos estén bien llenados.");
        }
    }

    protected void do_btnRegresar_actionPerformed(ActionEvent e) {
        this.dispose();
        Menu_Cliente menu = new Menu_Cliente();
        menu.setVisible(true);
    }

    private void limpiarCampos() {
        txtIDUsuario.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDNI.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtContraseña.setText("");
    }
}