package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.Login_Cliente;
import Login.Login_Personal;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnCliente;
	private JLabel lblNewLabel;
	private JLabel lblO;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			btnNewButton = new JButton("Personal");
			btnNewButton.addActionListener(this);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton.setBounds(60, 101, 124, 42);
			contentPane.add(btnNewButton);
		}
		{
			btnCliente = new JButton("Cliente");
			btnCliente.addActionListener(this);
			btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCliente.setBounds(244, 101, 124, 42);
			contentPane.add(btnCliente);
		}
		{
			lblNewLabel = new JLabel("Usted es...");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(164, 49, 237, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblO = new JLabel("o");
			lblO.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblO.setBounds(207, 115, 45, 14);
			contentPane.add(lblO);
		}
	}

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCliente) {
			do_btnCliente_actionPerformed(e);
		}
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
	}
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		this.dispose();
		Login_Personal lpersonal = new Login_Personal();
		lpersonal.setVisible(true);
	}
	protected void do_btnCliente_actionPerformed(ActionEvent e) {
		this.dispose();
		Menu_Cliente mcliente = new Menu_Cliente();
		mcliente.setVisible(true);
	}
}
