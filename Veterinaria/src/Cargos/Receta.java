package Cargos;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Menu.MenuPrincipal_Veterinario;

public class Receta extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtIDVeterinaria;
    private JLabel lblNewLabel;
    private JLabel lblReceta;
    private JLabel lblNewLabel_1;
    private JTextArea txtDescripcion;
    private JButton btnNewButton;
    private JButton btnRegresar;

    // Mapa público y estático para compartir con la clase Venta
    public static Map<String, String> recetasGuardadas = new HashMap<>();

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Receta frame = new Receta();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Receta() {
        setTitle("Receta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblReceta = new JLabel("RECETA");
        lblReceta.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblReceta.setBounds(182, 11, 107, 14);
        contentPane.add(lblReceta);

        lblNewLabel = new JLabel("Código Receta");
        lblNewLabel.setBounds(10, 55, 107, 14);
        contentPane.add(lblNewLabel);

        txtIDVeterinaria = new JTextField();
        txtIDVeterinaria.setBounds(127, 52, 86, 20);
        contentPane.add(txtIDVeterinaria);
        txtIDVeterinaria.setColumns(10);

        lblNewLabel_1 = new JLabel("Descripción:");
        lblNewLabel_1.setBounds(10, 83, 107, 14);
        contentPane.add(lblNewLabel_1);

        txtDescripcion = new JTextArea();
        txtDescripcion.setBounds(127, 83, 242, 95);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        contentPane.add(txtDescripcion);

        btnNewButton = new JButton("Recetar");
        btnNewButton.setBounds(103, 206, 91, 23);
        btnNewButton.addActionListener(this);
        contentPane.add(btnNewButton);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(234, 206, 91, 23);
        btnRegresar.addActionListener(this);
        contentPane.add(btnRegresar);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNewButton) {
            do_btnNewButton_actionPerformed(e);
        } else if (e.getSource() == btnRegresar) {
            do_btnRegresar_actionPerformed(e);
        }
    }

    protected void do_btnNewButton_actionPerformed(ActionEvent e) {
        String codigo = txtIDVeterinaria.getText().trim();
        String descripcion = txtDescripcion.getText().trim();

        if (codigo.isEmpty() || descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Guarda en el mapa estático
        recetasGuardadas.put(codigo, descripcion);

        JOptionPane.showMessageDialog(this, "Receta guardada correctamente.\nAhora puede continuar con la venta con asistente.");
        this.dispose();
        MenuPrincipal_Veterinario mpVeterinario = new MenuPrincipal_Veterinario();
        mpVeterinario.setVisible(true);
    }

    protected void do_btnRegresar_actionPerformed(ActionEvent e) {
        this.dispose();
        MenuPrincipal_Veterinario mpVeterinario = new MenuPrincipal_Veterinario();
        mpVeterinario.setVisible(true);
    }
}