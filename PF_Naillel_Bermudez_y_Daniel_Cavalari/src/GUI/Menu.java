package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 698, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Parqueo UCR Menú");
		lblNewLabel.setBounds(10, 11, 237, 26);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\naill\\Documents\\PF_Naillel_Bermudezy_Daniel_Cavalari\\PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\Escudo-UCR-2__4_-removebg-preview.png"));
		lblNewLabel_6.setBounds(569, 0, 82, 46);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFuncionarios m = new AdminFuncionarios();
				m.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 64));
		btnNewButton.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\depositphotos_251916955-stock-illustration-user-glyph-color-icon__2_-removebg-preview.png"));
		btnNewButton.setBounds(545, 101, 94, 94);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\icone-fleche-gauche-verte (1) (1).png"));
		lblNewLabel_1.setBounds(496, 115, 53, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Administrar funcionarios");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(416, 76, 245, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(-74, -54, 395, 751);
		contentPane.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\luxa.org-opacity-changed-klipartz.com (2).png"));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminEstacionamiento m = new AdminEstacionamiento();
				m.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\depositphotos_20012645-stock-illustration-car-parking-sign-vector-illustration__2_-removebg-preview.png"));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(0, 0, 64));
		btnNewButton_1.setBounds(536, 243, 103, 103);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Administrar estacionamiento");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(375, 218, 309, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\icone-fleche-gauche-verte (1) (1).png"));
		lblNewLabel_1_1.setBounds(476, 278, 53, 38);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\klipartz.com (3) (1).png"));
		lblNewLabel_5.setBounds(188, -39, 496, 619);
		contentPane.add(lblNewLabel_5);
	}
}
