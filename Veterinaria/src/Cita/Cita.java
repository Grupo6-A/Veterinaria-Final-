package Cita;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Menu.MenuPrincipal_Cliente;

public class Cita extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblDni, lblFecha, lblHora, lblId, lblObservaciones, lblCita;
	private JTextField txtIDCita, txtObservaciones;
	private JButton btnGuardar, btnNewButton;
	private JComboBox<String> CombUrgencia, CombFecha, CombHora;

	// Mapa estático para guardar citas por ID de usuario
	public static Map<String, Map<String, String>> citas = new HashMap<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Cita frame = new Cita();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Cita() {
		setTitle("Cita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCita = new JLabel("CITA");
		lblCita.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCita.setBounds(168, 11, 63, 20);
		contentPane.add(lblCita);

		lblId = new JLabel("ID Cita:");
		lblId.setBounds(33, 54, 150, 20);
		contentPane.add(lblId);

		txtIDCita = new JTextField();
		txtIDCita.setBounds(193, 54, 150, 20);
		contentPane.add(txtIDCita);

		lblFecha = new JLabel("Fecha (YYYY-MM-DD):");
		lblFecha.setBounds(33, 85, 150, 20);
		contentPane.add(lblFecha);

		lblHora = new JLabel("Hora (HH:MM):");
		lblHora.setBounds(33, 127, 150, 20);
		contentPane.add(lblHora);

		lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setBounds(33, 174, 150, 20);
		contentPane.add(lblObservaciones);

		txtObservaciones = new JTextField();
		txtObservaciones.setBounds(193, 174, 150, 20);
		contentPane.add(txtObservaciones);

		lblDni = new JLabel("Urgencias:");
		lblDni.setBounds(33, 218, 150, 20);
		contentPane.add(lblDni);

		CombUrgencia = new JComboBox<>();
		CombUrgencia.setModel(new DefaultComboBoxModel<>(new String[] {"Normal", "Emergencia"}));
		CombUrgencia.setBounds(193, 218, 150, 20);
		contentPane.add(CombUrgencia);

		CombFecha = new JComboBox<>();
		CombFecha.setBounds(193, 85, 150, 22);
		contentPane.add(CombFecha);

		CombHora = new JComboBox<>();
		CombHora.setBounds(193, 126, 150, 22);
		contentPane.add(CombHora);

		btnGuardar = new JButton("Guardar Cita");
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(117, 259, 150, 30);
		contentPane.add(btnGuardar);

		btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(140, 300, 91, 23);
		contentPane.add(btnNewButton);

		CombUrgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarFechaYHora();
			}
		});

		actualizarFechaYHora();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			do_btnGuardar_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}

	protected void do_btnGuardar_actionPerformed(ActionEvent e) {
		String idCita = txtIDCita.getText().trim();
		String fecha = (String) CombFecha.getSelectedItem();
		String hora = (String) CombHora.getSelectedItem();
		String observaciones = txtObservaciones.getText().trim();
		String tipo = (String) CombUrgencia.getSelectedItem();

		if (idCita.isEmpty() || fecha == null || hora == null || observaciones.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String idUsuario = JOptionPane.showInputDialog(this, "Ingrese su ID de Usuario para asociar esta cita:");
		if (idUsuario == null || idUsuario.trim().isEmpty()) {
			JOptionPane.showMessageDialog(this, "ID de usuario requerido.");
			return;
		}

		Map<String, String> datos = new HashMap<>();
		datos.put("IDCita", idCita);
		datos.put("Fecha", fecha);
		datos.put("Hora", hora);
		datos.put("Observaciones", observaciones);
		datos.put("Tipo", tipo);

		citas.put(idUsuario.trim(), datos);

		JOptionPane.showMessageDialog(this, "✅ Cita registrada con éxito para el usuario " + idUsuario);
	}

	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		this.dispose();
		MenuPrincipal_Cliente mprincipal = new MenuPrincipal_Cliente();
		mprincipal.setVisible(true);
	}

	protected void actualizarFechaYHora() {
		CombFecha.removeAllItems();
		CombHora.removeAllItems();

		String tipo = (String) CombUrgencia.getSelectedItem();

		if (tipo.equals("Normal")) {
			LocalDate hoy = LocalDate.now();
			for (int i = 1; i <= 5; i++) {
				CombFecha.addItem(hoy.plusDays(i).toString());
			}

			String[] horas = {"09:00", "10:00", "11:00", "12:00", "15:00", "16:00"};
			for (String h : horas) {
				CombHora.addItem(h);
			}
		} else if (tipo.equals("Emergencia")) {
			LocalDate hoy = LocalDate.now();
			CombFecha.addItem(hoy.toString());

			LocalTime ahora = LocalTime.now();
			String horaActual = ahora.getHour() + ":" + (ahora.getMinute() < 10 ? "0" : "") + ahora.getMinute();
			CombHora.addItem(horaActual);
		}
	}
}

