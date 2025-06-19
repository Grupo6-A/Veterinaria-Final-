package Menu;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Cargos.Venta; // Asegúrate de importar la clase Venta

import java.awt.event.*;

public class MenuPrincipal_Asistente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JButton btnNewButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MenuPrincipal_Asistente frame = new MenuPrincipal_Asistente();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public MenuPrincipal_Asistente() {
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 188);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		mntmNewMenuItem = new JMenuItem("Ventas");
		mntmNewMenuItem.addActionListener(this); // <- Agrega acción al menú Ventas
		mnNewMenu.add(mntmNewMenuItem);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(335, 93, 89, 23);
		contentPane.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnSalir_actionPerformed(e);
		} else if (e.getSource() == mntmNewMenuItem) {
			do_mntmVentas_actionPerformed(e);
		}
	}

	protected void do_btnSalir_actionPerformed(ActionEvent e) {
		this.dispose();
		Menu menu = new Menu();
		menu.setVisible(true);
	}

	protected void do_mntmVentas_actionPerformed(ActionEvent e) {
		this.dispose(); // Opcional: cierra el menú actual
		Venta ventanaVenta = new Venta();
		ventanaVenta.setVisible(true);
	}
}