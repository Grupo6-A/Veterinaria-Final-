package Boleta;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.Map;
import Menu.MenuPrincipal_Cliente;
import Registro_Cliente.Registro_Cliente;
import Registro_Cliente.RegistroCliente;
import Mascota.Datos_Mascotas;
import Cita.Cita;

public class Boleta extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtIDUsuario;
    private JTextArea txtBoleta;
    private JButton btnBuscar, btnRegresar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Boleta frame = new Boleta();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Boleta() {
        setTitle("Boleta Detallada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblIDUsuario = new JLabel("ID Usuario:");
        lblIDUsuario.setBounds(10, 10, 100, 25);
        contentPane.add(lblIDUsuario);

        txtIDUsuario = new JTextField();
        txtIDUsuario.setBounds(120, 10, 150, 25);
        contentPane.add(txtIDUsuario);

        btnBuscar = new JButton("Buscar Boleta");
        btnBuscar.setBounds(300, 10, 150, 25);
        btnBuscar.addActionListener(this);
        contentPane.add(btnBuscar);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(470, 10, 130, 25);
        btnRegresar.addActionListener(this);
        contentPane.add(btnRegresar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 610, 400);
        contentPane.add(scrollPane);

        txtBoleta = new JTextArea();
        txtBoleta.setEditable(false);
        scrollPane.setViewportView(txtBoleta);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBuscar) {
            buscarBoleta();
        } else if (e.getSource() == btnRegresar) {
            this.dispose();
            new MenuPrincipal_Cliente().setVisible(true);
        }
    }

    private void buscarBoleta() {
        String idUsuarioStr = txtIDUsuario.getText().trim();

        int idUsuario;
        try {
            idUsuario = Integer.parseInt(idUsuarioStr);
        } catch (NumberFormatException ex) {
            txtBoleta.setText("⚠️ ID de usuario inválido. Debe ser un número.");
            return;
        }

        RegistroCliente cliente = Registro_Cliente.mapaClientes.get(idUsuario);
        Map<String, String> mascota = Datos_Mascotas.datosMascotas.get(idUsuarioStr);
        Map<String, String> cita = Cita.citas.get(idUsuarioStr);

        if (cliente == null && mascota == null && cita == null) {
            txtBoleta.setText("No se encontraron datos para el ID de usuario ingresado.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== BOLETA DE SERVICIO VETERINARIO ===\n\n");

        if (cliente != null) {
            sb.append("--- Datos del Cliente ---\n");
            sb.append("ID Usuario: ").append(cliente.getIdusuario()).append("\n");
            sb.append("Nombre: ").append(cliente.getNombre()).append(" ").append(cliente.getApellido()).append("\n");
            sb.append("DNI: ").append(cliente.getDni()).append("\n");
            sb.append("Correo: ").append(cliente.getCorreo()).append("\n");
            sb.append("Teléfono: ").append(cliente.getTelefono()).append("\n\n");
        }

        if (mascota != null) {
            sb.append("--- Datos de la Mascota ---\n");
            sb.append("Nombre: ").append(mascota.get("Nombre")).append("\n");
            sb.append("Raza: ").append(mascota.get("Raza")).append("\n");
            sb.append("Sexo: ").append(mascota.get("Sexo")).append("\n");
            sb.append("Edad: ").append(mascota.get("Edad")).append("\n");
            sb.append("DNI del Dueño: ").append(mascota.get("DNIDueño")).append("\n\n");
        }

        if (cita != null) {
            sb.append("--- Datos de la Cita ---\n");
            sb.append("ID Cita: ").append(cita.get("IDCita")).append("\n");
            sb.append("Fecha: ").append(cita.get("Fecha")).append("\n");
            sb.append("Hora: ").append(cita.get("Hora")).append("\n");
            sb.append("Tipo: ").append(cita.get("Tipo")).append("\n");
            sb.append("Observaciones: ").append(cita.get("Observaciones")).append("\n");
        }

        txtBoleta.setText(sb.toString());
    }
}

