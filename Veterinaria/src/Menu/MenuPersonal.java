package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPersonal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSeleccioneSuCargo;
	private JButton btnAsistente;
	private JButton btnVeterinario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPersonal frame = new MenuPersonal();
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
	public MenuPersonal() {
		setTitle("Menú Personal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			lblSeleccioneSuCargo = new JLabel("Seleccione su cargo:");
			lblSeleccioneSuCargo.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblSeleccioneSuCargo.setBounds(117, 31, 242, 14);
			contentPane.add(lblSeleccioneSuCargo);
		}
		{
			btnAsistente = new JButton("Asistente");
			btnAsistente.addActionListener(this);
			btnAsistente.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnAsistente.setBounds(62, 86, 124, 47);
			contentPane.add(btnAsistente);
		}
		{
			btnVeterinario = new JButton("Veterinario");
			btnVeterinario.addActionListener(this);
			btnVeterinario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnVeterinario.setBounds(235, 86, 124, 47);
			contentPane.add(btnVeterinario);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAsistente) {
			do_btnAsistente_actionPerformed(e);
		}
		if (e.getSource() == btnVeterinario) {
			do_btnVeterinario_actionPerformed(e);
		}
	}
	protected void do_btnVeterinario_actionPerformed(ActionEvent e) {
		this.dispose();
		MenuPrincipal_Veterinario mpveterianrio = new MenuPrincipal_Veterinario();
		mpveterianrio.setVisible(true);
	}
	protected void do_btnAsistente_actionPerformed(ActionEvent e) {
		this.dispose();
		MenuPrincipal_Asistente mpasistente = new MenuPrincipal_Asistente();
		mpasistente.setVisible(true);
	}
}
