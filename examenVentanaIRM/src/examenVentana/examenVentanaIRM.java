package examenVentana;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class examenVentanaIRM extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					examenVentanaIRM frame = new examenVentanaIRM();
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
	public examenVentanaIRM() {
		setTitle("examen Iosu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLugaresQueHas = new JLabel("Lugares que has visitado");
		lblLugaresQueHas.setBounds(12, 12, 224, 15);
		contentPane.add(lblLugaresQueHas);
		
		JCheckBox chckbxNewCheckBoxR = new JCheckBox("Roma");
		chckbxNewCheckBoxR.setBounds(22, 35, 129, 23);
		contentPane.add(chckbxNewCheckBoxR);
		
		JCheckBox chckbxNewCheckBoxP = new JCheckBox("Paris");
		chckbxNewCheckBoxP.setBounds(22, 71, 129, 23);
		contentPane.add(chckbxNewCheckBoxP);
		
		JCheckBox chckbxNewCheckBoxL = new JCheckBox("Londres");
		chckbxNewCheckBoxL.setBounds(22, 110, 129, 23);
		contentPane.add(chckbxNewCheckBoxL);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Has visitado los siguinetes lugares:");
				if(chckbxNewCheckBoxR.isSelected()){
					System.out.println("Roma");
				}
				if(chckbxNewCheckBoxP.isSelected()){
					System.out.println("Paris");
				}
				if(chckbxNewCheckBoxL.isSelected()){
					System.out.println("Londres");
				}
			}
		});
		btnNewButton.setBounds(34, 169, 117, 25);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("cancelar, deseleccioando las opciones");
				if(chckbxNewCheckBoxR.isSelected()){
					chckbxNewCheckBoxR.setSelected(false);
				}
				if(chckbxNewCheckBoxP.isSelected()){
					chckbxNewCheckBoxP.setSelected(false);
				}
				if(chckbxNewCheckBoxL.isSelected()){
					chckbxNewCheckBoxL.setSelected(false);
				}				
			}
		});
		btnCancel.setBounds(211, 169, 117, 25);
		contentPane.add(btnCancel);
	}
}
