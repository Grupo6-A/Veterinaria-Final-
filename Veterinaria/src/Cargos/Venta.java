package Cargos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Menu.MenuPrincipal_Asistente;

public class Venta extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JTextField txtIDUsuario;
    private JTextField txtCodReceta;
    private JTextField txtIDAsistente;
    private JScrollPane scrollPane;
    private JTextArea txtS;
    private JButton btnImprimir;
    private JButton btnRegresar;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Venta frame = new Venta();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Venta() {
        setTitle("Venta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 447, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("VENTA");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewLabel.setBounds(163, 25, 95, 14);
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("ID Usuario:");
        lblNewLabel_1.setBounds(21, 70, 88, 14);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("ID Asistente:");
        lblNewLabel_2.setBounds(220, 70, 88, 14);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Cod. Receta:");
        lblNewLabel_3.setBounds(21, 95, 88, 14);
        contentPane.add(lblNewLabel_3);

        txtIDUsuario = new JTextField("100");
        txtIDUsuario.setEditable(false);
        txtIDUsuario.setBounds(99, 67, 86, 20);
        contentPane.add(txtIDUsuario);

        txtCodReceta = new JTextField();
        txtCodReceta.setBounds(99, 95, 86, 20);
        contentPane.add(txtCodReceta);

        txtIDAsistente = new JTextField("AS01");
        txtIDAsistente.setEditable(false);
        txtIDAsistente.setBounds(308, 67, 86, 20);
        contentPane.add(txtIDAsistente);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 130, 413, 122);
        contentPane.add(scrollPane);

        txtS = new JTextArea();
        scrollPane.setViewportView(txtS);

        btnImprimir = new JButton("Imprimir");
        btnImprimir.setBounds(217, 95, 91, 23);
        btnImprimir.addActionListener(this);
        contentPane.add(btnImprimir);

        btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(318, 94, 91, 23);
        btnRegresar.addActionListener(this);
        contentPane.add(btnRegresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnImprimir) {
            do_btnImprimir_actionPerformed(e);
        }
        if (e.getSource() == btnRegresar) {
            do_btnRegresar_actionPerformed(e);
        }
    }

    protected void do_btnImprimir_actionPerformed(ActionEvent e) {
        String codigo = txtCodReceta.getText().trim();
        String descripcion = Receta.recetasGuardadas.get(codigo);

        if (descripcion == null) {
            descripcion = "No se encontró una receta para el código ingresado.";
        }

        String resumen = "=== DETALLE DE LA RECETA ===\n"
                + "ID Usuario: " + txtIDUsuario.getText() + "\n"
                + "ID Asistente: " + txtIDAsistente.getText() + "\n"
                + "Código de Receta: " + codigo + "\n"
                + "Descripción:\n" + descripcion + "\n\n"
                + "✔ Se imprimirá su copia de receta\n"
                + "✔ Se entregarán los medicamentos";

        txtS.setText(resumen);
    }

    protected void do_btnRegresar_actionPerformed(ActionEvent e) {
        this.dispose();
        MenuPrincipal_Asistente mpAsistente = new MenuPrincipal_Asistente();
        mpAsistente.setVisible(true);
    }
}