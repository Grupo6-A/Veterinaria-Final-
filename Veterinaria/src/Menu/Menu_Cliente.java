package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login_Cliente;
import Registro_Cliente.Registro_Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Cliente extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMenCliente;
	private JButton btnRegistrate;
	private JButton btnIniciaSesin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Cliente frame = new Menu_Cliente();
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
	public Menu_Cliente() {
		setTitle("Menú Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblMenCliente = new JLabel("Inicie Sesión o Registrese:");
			lblMenCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblMenCliente.setBounds(105, 43, 242, 14);
			contentPane.add(lblMenCliente);
		}
		{
			btnRegistrate = new JButton("Registrate");
			btnRegistrate.addActionListener(this);
			btnRegistrate.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnRegistrate.setBounds(241, 107, 124, 47);
			contentPane.add(btnRegistrate);
		}
		{
			btnIniciaSesin = new JButton("Inicia Sesión");
			btnIniciaSesin.addActionListener(this);
			btnIniciaSesin.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnIniciaSesin.setBounds(58, 107, 124, 47);
			contentPane.add(btnIniciaSesin);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciaSesin) {
			do_btnIniciaSesin_actionPerformed(e);
		}
		if (e.getSource() == btnRegistrate) {
			do_btnRegistrate_actionPerformed(e);
		}
	}
	protected void do_btnRegistrate_actionPerformed(ActionEvent e) {
		this.dispose();
		Registro_Cliente rcliente = new Registro_Cliente();
		rcliente.setVisible(true);
	}
	protected void do_btnIniciaSesin_actionPerformed(ActionEvent e) {
		this.dispose();
		Login_Cliente lcliente = new Login_Cliente();
		lcliente.setVisible(true);
	}
}
