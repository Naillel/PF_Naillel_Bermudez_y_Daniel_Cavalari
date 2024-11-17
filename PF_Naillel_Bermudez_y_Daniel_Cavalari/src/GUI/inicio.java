package GUI;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class inicio extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    inicio frame = new inicio();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //Hola
        });
    }

    /**
     * 
     */
    public inicio() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 453);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(319, 83, 70, 70);
        lblNewLabel.setIcon(new ImageIcon("Img\\klipartz.com (1).png"));
        contentPane.add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(10, 11, 659, 47);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("SISTEMA GESTOR DE PARQUEO UCR");
        lblNewLabel_1.setBounds(127, 11, 366, 26);
        lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setBounds(495, 0, 100, 47);
        lblNewLabel_5.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\Escudo-UCR-2__4_-removebg-preview.png"));
        panel.add(lblNewLabel_5);

        JLabel lblNewLabel_2 = new JLabel("Inicio de sesión");
        lblNewLabel_2.setForeground(new Color(0, 255, 0));
        lblNewLabel_2.setBounds(301, 156, 88, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Usuario");
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(237, 171, 46, 14);
        contentPane.add(lblNewLabel_3);

        textField = new JTextField();
        textField.setBounds(237, 193, 178, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_4 = new JLabel("Contraseña");
        lblNewLabel_4.setForeground(new Color(255, 255, 255));
        lblNewLabel_4.setBounds(237, 232, 70, 14);
        contentPane.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(237, 257, 178, 20);
        contentPane.add(textField_1);

        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\pngwing.com (1).png"));
        btnNewButton.setBounds(326, 296, 89, 23);
        contentPane.add(btnNewButton);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = textField.getText();
                String contrasena = textField_1.getText();
        
                
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese usuario y contraseña.");
                    return;
                }
        
                try (Connection conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true",
                        "root", 
                        "552280");
                    CallableStatement llamada = conexion.prepareCall("{CALL verificar_usuario(?, ?, ?)}")) {
        
                   
                    llamada.setString(1, usuario);
                    llamada.setString(2, contrasena);
                    llamada.registerOutParameter(3, java.sql.Types.BOOLEAN);
        
                    
                    llamada.execute();
        
                    
                    boolean esValido = llamada.getBoolean(3);
        
                   
                    if (esValido) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                        dispose(); 
                        Menu entrar = new Menu();
                        entrar.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                    }
        
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error de conexión: " + ex.getMessage());
                }
            }
        });
        

        JLabel lblNewLabel_6 = new JLabel("");
        lblNewLabel_6.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\luxa.org-opacity-changed-klipartz.com (2).png"));
        lblNewLabel_6.setBounds(392, -257, 421, 683);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_6_1 = new JLabel("");
        lblNewLabel_6_1.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\luxa.org-opacity-changed-klipartz.com (2).png"));
        lblNewLabel_6_1.setBounds(-140, -82, 421, 1000);
        contentPane.add(lblNewLabel_6_1);
    }
}

