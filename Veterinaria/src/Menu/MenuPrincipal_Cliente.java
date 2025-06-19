package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Boleta.Boleta;
import Cita.Cita;
import Mascota.Datos_Mascotas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal_Cliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenu mnNewMenu_1;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal_Cliente frame = new MenuPrincipal_Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal_Cliente() {
		setTitle("Menú Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		{
			menuBar = new JMenuBar();
			setJMenuBar(menuBar);
			{
				mnNewMenu_1 = new JMenu("Menú");
				menuBar.add(mnNewMenu_1);
				{
					mntmNewMenuItem = new JMenuItem("Registrar Mascota");
					mntmNewMenuItem.addActionListener(this);
					mnNewMenu_1.add(mntmNewMenuItem);
				}
				{
					mntmNewMenuItem_1 = new JMenuItem("Sacar CIta");
					mntmNewMenuItem_1.addActionListener(this);
					mnNewMenu_1.add(mntmNewMenuItem_1);
				}
				{
					mntmNewMenuItem_2 = new JMenuItem("Boleta");
					mntmNewMenuItem_2.addActionListener(this);
					mnNewMenu_1.add(mntmNewMenuItem_2);
				}
			}
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem_2) {
			do_mntmNewMenuItem_2_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem_1) {
			do_mntmNewMenuItem_1_actionPerformed(e);
		}
		if (e.getSource() == mntmNewMenuItem) {
			do_mntmNewMenuItem_actionPerformed(e);
		}
	}
	protected void do_mntmNewMenuItem_actionPerformed(ActionEvent e) {
		this.dispose();
		Datos_Mascotas dmascota = new Datos_Mascotas();
		dmascota.setVisible(true);
	}
	protected void do_mntmNewMenuItem_1_actionPerformed(ActionEvent e) {
		this.dispose();
		Cita cita = new Cita();
		cita.setVisible(true);
	}
	protected void do_mntmNewMenuItem_2_actionPerformed(ActionEvent e) {
		this.dispose();
		Boleta boleta = new Boleta();
		boleta.setVisible(true);
	}
}
