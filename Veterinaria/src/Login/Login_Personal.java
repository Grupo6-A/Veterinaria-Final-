package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Menu.MenuPersonal;
import Menu.MenuPrincipal_Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login_Personal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblContrasea;
	private JTextField txtNombre;
	private JTextField txtContraseña;
	private JLabel lblNewLabel_1;
	private JLabel lblIdPersonal;
	private JTextField txtIDPersonal;
	private JButton btnNewButton;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Personal frame = new Login_Personal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Login_Personal() {
		setTitle("Login Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 441, 239);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBounds(83, 103, 73, 14);
			contentPane.add(lblNewLabel);
		}
		{
			lblContrasea = new JLabel("Contraseña:");
			lblContrasea.setBounds(83, 128, 90, 14);
			contentPane.add(lblContrasea);
		}
		{
			txtNombre = new JTextField();
			txtNombre.setBounds(183, 100, 116, 20);
			contentPane.add(txtNombre);
			txtNombre.setColumns(10);
		}
		{
			txtContraseña = new JTextField();
			txtContraseña.setColumns(10);
			txtContraseña.setBounds(183, 125, 116, 20);
			contentPane.add(txtContraseña);
		}
		{
			lblNewLabel_1 = new JLabel("Inicio de Sesión");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_1.setBounds(133, 28, 166, 14);
			contentPane.add(lblNewLabel_1);
		}
		{
			lblIdPersonal = new JLabel("ID Personal:");
			lblIdPersonal.setBounds(83, 78, 90, 14);
			contentPane.add(lblIdPersonal);
		}
		{
			txtIDPersonal = new JTextField();
			txtIDPersonal.setColumns(10);
			txtIDPersonal.setBounds(183, 75, 116, 20);
			contentPane.add(txtIDPersonal);
		}
		{
			btnNewButton = new JButton("Iniciar Sesión");
			btnNewButton.addActionListener(this);
			btnNewButton.setBounds(144, 156, 110, 23);
			contentPane.add(btnNewButton);
		}
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			do_btnNewButton_actionPerformed(e);
		}
		
	}
	Array_Personal_Cliente apc =  new Array_Personal_Cliente();
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		String nom = txtNombre.getText().trim();
		String contraseña =  txtContraseña.getText().trim();
		int id;
		try {
	        id = Integer.parseInt(txtIDPersonal.getText());
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "ID de usuario debe ser un número.");
	        return;
	    }
		boolean encontrado=false;
		
		for(int i = 0; i<apc.TamañoPersonal();i++) {
			if(apc.ObtenerPersonal(i).getIdpersonal()==id&&apc.ObtenerPersonal(i).getNombre().equals(nom)
					&&apc.ObtenerPersonal(i).getContraseña().equals(contraseña)) {
				encontrado = true;
			break;
			}
		}
	
	if (encontrado) {
        this.dispose();
        MenuPersonal mp = new MenuPersonal();
        mp.setVisible(true);
        
    } else {
        JOptionPane.showMessageDialog(this, "Datos incorrectos, intente nuevamente.");
    }
	}
}
