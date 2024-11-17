package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdminFuncionarios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField TextIngresarCedula;
    private JTextField TextIngresarNombre1;
    private JTextField TextIngresarNombre2;
    private JTextField TextIngresarApellido1;
    private JTextField TextIngresarApellido2;
    private JTextField TextEliminar;
    private JTextField TextActualizar;
    private JTextField TextActualizarNombre1;
private JTextField TextActualizarApellido2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminFuncionarios frame = new AdminFuncionarios();
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
    public AdminFuncionarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 452);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 0, 64));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
      
        JPanel IngresarPanel = new JPanel();
        IngresarPanel.setVisible(false);
        IngresarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(IngresarPanel);
        IngresarPanel.setLayout(null);
        
        TextIngresarApellido1 = new JTextField();
        TextIngresarApellido1.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarApellido1.setColumns(10);
        TextIngresarApellido1.setBounds(353, 36, 239, 20);
        IngresarPanel.add(TextIngresarApellido1);
        
        JLabel lblNewLabel_2_1_3 = new JLabel("Ingrese el primer nombre del funcionario: ");
        lblNewLabel_2_1_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2_1_3.setBounds(353, 67, 290, 14);
        IngresarPanel.add(lblNewLabel_2_1_3);
        
        TextIngresarNombre1 = new JTextField();
        TextIngresarNombre1.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarNombre1.setColumns(10);
        TextIngresarNombre1.setBounds(10, 92, 239, 20);
        IngresarPanel.add(TextIngresarNombre1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Ingrese el primer nombre del funcionario: ");
        lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2_1.setBounds(10, 67, 290, 14);
        IngresarPanel.add(lblNewLabel_2_1);
        
        TextIngresarApellido2 = new JTextField();
        TextIngresarApellido2.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarApellido2.setColumns(10);
        TextIngresarApellido2.setBounds(353, 92, 239, 20);
        IngresarPanel.add(TextIngresarApellido2);
        
        TextIngresarCedula = new JTextField();
        TextIngresarCedula.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarCedula.setBounds(10, 36, 239, 20);
        IngresarPanel.add(TextIngresarCedula);
        TextIngresarCedula.setColumns(10);
        
        TextIngresarNombre2 = new JTextField();
        TextIngresarNombre2.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarNombre2.setColumns(10);
        TextIngresarNombre2.setBounds(10, 147, 239, 20);
        IngresarPanel.add(TextIngresarNombre2);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Ingrese el segundo nombre del funcionario (Si posee): ");
        lblNewLabel_2_1_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2_1_1.setBounds(10, 122, 386, 14);
        IngresarPanel.add(lblNewLabel_2_1_1);
        
        JLabel lblNewLabel_2 = new JLabel("Ingrese la cedula del funcionario: ");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 11, 303, 14);
        IngresarPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Ingrese el primer apellido del funcionario: ");
        lblNewLabel_2_1_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2_1_2.setBounds(353, 11, 290, 14);
        IngresarPanel.add(lblNewLabel_2_1_2);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Connection conexion = null;
                CallableStatement empaquetar = null;

                
                String cedula = TextIngresarCedula.getText();
                String nombre1 = TextIngresarNombre1.getText();
                String nombre2 = TextIngresarNombre2.getText();
                String apellido1 = TextIngresarApellido1.getText();
                String apellido2 = TextIngresarApellido2.getText();

                
                if (cedula.isEmpty() || nombre1.isEmpty() || apellido1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos de cédula, primer nombre y primer apellido son obligatorios.");
                    return;
                }

                try {
                   
                    conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true", 
                        "root", 
                        "552280"
                    );
                    conexion.setAutoCommit(true);

                    
                    String procedimiento = "{CALL insertar_funcionario(?, ?, ?, ?, ?)}";
                    empaquetar = conexion.prepareCall(procedimiento);

                  
                    empaquetar.setString(1, cedula);
                    empaquetar.setString(2, nombre1);
                    empaquetar.setString(3, nombre2);
                    empaquetar.setString(4, apellido1);
                    empaquetar.setString(5, apellido2);

                   
                    int exito = empaquetar.executeUpdate();
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "El funcionario ha sido ingresado con éxito.");
                        
                        
                        TextIngresarCedula.setText("");
                        TextIngresarNombre1.setText("");
                        TextIngresarNombre2.setText("");
                        TextIngresarApellido1.setText("");
                        TextIngresarApellido2.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo ingresar el funcionario.");
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al ingresar funcionario: " + e1.getMessage());
                } finally {
                   
                    try {
                        if (empaquetar != null) empaquetar.close();
                        if (conexion != null) conexion.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }); 

        btnNewButton_1.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\7785391 (1).png"));
        btnNewButton_1.setBounds(575, 137, 68, 46);
        IngresarPanel.add(btnNewButton_1);
        
        
        JPanel ConsultarPanel = new JPanel();
        ConsultarPanel.setVisible(false);
        ConsultarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(ConsultarPanel);
        ConsultarPanel.setLayout(null);
        
        JLabel lblIngreseElFuncionario = new JLabel("Consultar funcionarios:");
        lblIngreseElFuncionario.setBounds(10, 11, 572, 29);
        lblIngreseElFuncionario.setForeground(Color.BLACK);
        lblIngreseElFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 20));
        ConsultarPanel.add(lblIngreseElFuncionario);
        
        JButton BotonConsultar = new JButton("");
        BotonConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                CallableStatement empaquetar = null;
                ResultSet rs = null;
        
                try {
                    conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true",
                        "root",
                        "552280"
                    );
        
                    
                    String procedimiento = "{CALL ver_funcionarios()}";
                    empaquetar = conexion.prepareCall(procedimiento);
                    rs = empaquetar.executeQuery();
        
                    
                    if (rs != null && rs.next()) {
                        rs.beforeFirst(); 
                        ResultadoConsultaFrame resultadoFrame = new ResultadoConsultaFrame(rs);
                        resultadoFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "Funcionario no encontrado.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al consultar funcionario: " + e1.getMessage());
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (empaquetar != null) empaquetar.close();
                        if (conexion != null) conexion.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        

        BotonConsultar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\icone-loupe-vert (1).png"));
        BotonConsultar.setBounds(565, 130, 89, 53);
        ConsultarPanel.add(BotonConsultar);
        
   
        JPanel ActualizarPanel = new JPanel();
        ActualizarPanel.setVisible(false);
        ActualizarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(ActualizarPanel);
        ActualizarPanel.setLayout(null);
        
        JLabel lblIngreseLaCedula = new JLabel("Ingrese la cedula del funcionario a actualizar:");
        lblIngreseLaCedula.setBounds(10, 11, 536, 29);
        lblIngreseLaCedula.setForeground(Color.BLACK);
        lblIngreseLaCedula.setFont(new Font("Arial Black", Font.PLAIN, 20));
        ActualizarPanel.add(lblIngreseLaCedula);
        
        TextActualizar = new JTextField();
        TextActualizar.setFont(new Font("Arial", Font.PLAIN, 14));
        TextActualizar.setBounds(10, 51, 405, 20);
        ActualizarPanel.add(TextActualizar);
        TextActualizar.setColumns(10);
        
        JButton BotonActualizar = new JButton("");
        
JTextField TextActualizarNombre1 = new JTextField();
TextActualizarNombre1.setFont(new Font("Arial", Font.PLAIN, 14));
TextActualizarNombre1.setBounds(10, 90, 239, 20);
ActualizarPanel.add(TextActualizarNombre1);

JTextField TextActualizarNombre2 = new JTextField();
TextActualizarNombre2.setFont(new Font("Arial", Font.PLAIN, 14));
TextActualizarNombre2.setBounds(260, 90, 239, 20);
ActualizarPanel.add(TextActualizarNombre2);

JTextField TextActualizarApellido1 = new JTextField();
TextActualizarApellido1.setFont(new Font("Arial", Font.PLAIN, 14));
TextActualizarApellido1.setBounds(10, 130, 239, 20);
ActualizarPanel.add(TextActualizarApellido1);

JTextField TextActualizarApellido2 = new JTextField();
TextActualizarApellido2.setFont(new Font("Arial", Font.PLAIN, 14));
TextActualizarApellido2.setBounds(260, 130, 239, 20);
ActualizarPanel.add(TextActualizarApellido2);


JLabel lblNombre1 = new JLabel("Primer Nombre:");
lblNombre1.setFont(new Font("Arial Black", Font.PLAIN, 12));
lblNombre1.setBounds(10, 70, 150, 20);
ActualizarPanel.add(lblNombre1);

JLabel lblNombre2 = new JLabel("Segundo Nombre:");
lblNombre2.setFont(new Font("Arial Black", Font.PLAIN, 12));
lblNombre2.setBounds(260, 70, 150, 20);
ActualizarPanel.add(lblNombre2);

JLabel lblApellido1 = new JLabel("Primer Apellido:");
lblApellido1.setFont(new Font("Arial Black", Font.PLAIN, 12));
lblApellido1.setBounds(10, 110, 150, 20);
ActualizarPanel.add(lblApellido1);

JLabel lblApellido2 = new JLabel("Segundo Apellido:");
lblApellido2.setFont(new Font("Arial Black", Font.PLAIN, 12));
lblApellido2.setBounds(260, 110, 150, 20);
ActualizarPanel.add(lblApellido2);


BotonActualizar.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Connection conexion = null;
        CallableStatement empaquetar = null;
        String cedula = TextActualizar.getText();
        
        String nombre1 = TextActualizarNombre1.getText();
        String nombre2 = TextActualizarNombre2.getText();
        String apellido1 = TextActualizarApellido1.getText();
        String apellido2 = TextActualizarApellido2.getText();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cédula para actualizar.");
            return;
        }

        try {
            conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true",
                "root", 
                "552280"
            );

            String procedimiento = "{CALL actualizar_funcionario(?, ?, ?, ?, ?)}";
            empaquetar = conexion.prepareCall(procedimiento);

            empaquetar.setString(1, cedula);
            empaquetar.setString(2, nombre1);
            empaquetar.setString(3, nombre2);
            empaquetar.setString(4, apellido1);
            empaquetar.setString(5, apellido2);

            int exito = empaquetar.executeUpdate();
            if (exito > 0) {
                JOptionPane.showMessageDialog(null, "El funcionario ha sido actualizado con éxito.");
                
                
                TextActualizar.setText("");
                TextActualizarNombre1.setText("");
                TextActualizarNombre2.setText("");
                TextActualizarApellido1.setText("");
                TextActualizarApellido2.setText("");
                
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el funcionario.");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar funcionario: " + e1.getMessage());
        } finally {
            try {
                if (empaquetar != null) empaquetar.close();
                if (conexion != null) conexion.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
});


        BotonActualizar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\2091540 (1).png"));
        BotonActualizar.setBounds(565, 130, 89, 53);
        ActualizarPanel.add(BotonActualizar);
        
       
        JPanel EliminarPanel = new JPanel();
        EliminarPanel.setVisible(false);
        EliminarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(EliminarPanel);
        EliminarPanel.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("Ingrese la cedula del funcionario a Eliminar:");
        lblNewLabel_4.setBounds(10, 11, 536, 29);
        lblNewLabel_4.setForeground(Color.BLACK);
        lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 20));
        EliminarPanel.add(lblNewLabel_4);
        
        TextEliminar = new JTextField();
        TextEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        TextEliminar.setColumns(10);
        TextEliminar.setBounds(10, 51, 405, 20);
        EliminarPanel.add(TextEliminar);
        
        JButton BotonEliminar = new JButton("");
        BotonEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                CallableStatement empaquetar = null;
                String cedula = TextEliminar.getText();

                if (cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar la cédula para eliminar.");
                    return;
                }

                try {
                    conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true",
                        "root", 
                        "552280"
                    );

                    String procedimiento = "{CALL eliminar_funcionario(?)}";
                    empaquetar = conexion.prepareCall(procedimiento);
                    empaquetar.setString(1, cedula);

                    int exito = empaquetar.executeUpdate();
                    if (exito > 0) {
                        JOptionPane.showMessageDialog(null, "El funcionario ha sido eliminado con éxito.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el funcionario.");
                    }

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al eliminar funcionario: " + e1.getMessage());
                } finally {
                    try {
                        if (empaquetar != null) empaquetar.close();
                        if (conexion != null) conexion.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        BotonEliminar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\uninstall_9498859 (1).png"));
        BotonEliminar.setBounds(565, 130, 89, 53);
        EliminarPanel.add(BotonEliminar);
        
        
        JPanel PanelOpciones = new JPanel();
        PanelOpciones.setBounds(10, 11, 664, 111);
        contentPane.add(PanelOpciones);
        PanelOpciones.setLayout(null);
        
        JComboBox<String> ComboOpciones = new JComboBox<String>();
        ComboOpciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Ingresar funcionario", "Consultar funcionario", "Actualizar funcionario", "Eliminar funcionario"}));
        ComboOpciones.setFont(new Font("Arial Black", Font.PLAIN, 15));
        ComboOpciones.setBounds(10, 61, 353, 32);
        PanelOpciones.add(ComboOpciones);
        
        JLabel lblNewLabel = new JLabel("Seleccione la acción que desea realizar:");
        lblNewLabel.setBounds(10, 11, 507, 39);
        PanelOpciones.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(0, 0, 0));
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	
        	
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Menu m = new Menu();
                m.setVisible(true);
                
        	}
        });
        
        btnNewButton.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\turn-left_11044994__1_-removebg-preview.png"));
        btnNewButton.setBounds(10, 348, 56, 54);
        contentPane.add(btnNewButton);
        
        
        ComboOpciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = ComboOpciones.getSelectedItem().toString();
                
                
                IngresarPanel.setVisible(false);
                ConsultarPanel.setVisible(false);
                ActualizarPanel.setVisible(false);
                EliminarPanel.setVisible(false);
                
                
                switch (opcionSeleccionada) {
                    case "Ingresar funcionario":
                        IngresarPanel.setVisible(true);
                        break;
                    case "Consultar funcionario":
                        ConsultarPanel.setVisible(true);
                        break;
                    case "Actualizar funcionario":
                        ActualizarPanel.setVisible(true);
                        break;
                    case "Eliminar funcionario":
                        EliminarPanel.setVisible(true);
                        break;
                    default:
                        
                        break;
                }
            }
        });
    }
}
