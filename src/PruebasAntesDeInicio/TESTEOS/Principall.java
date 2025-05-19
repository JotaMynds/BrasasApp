package PruebasAntesDeInicio.TESTEOS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principall extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principall frame = new Principall();
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
	public Principall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FUTBOLERO");
		lblNewLabel.setBounds(175, 26, 232, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("AÑADIR FUTBOLERO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Formulario_Insertar V1 = new Formulario_Insertar();
				V1.setVisible(true);
			}
		});
		btnNewButton.setBounds(68, 78, 288, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLEER = new JButton("LEER FUTBOLERO");
		btnLEER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario_Leer V2 = new Formulario_Leer();
				V2.setVisible(true);
			}
		});
		btnLEER.setBounds(68, 124, 288, 23);
		contentPane.add(btnLEER);
	}

}
