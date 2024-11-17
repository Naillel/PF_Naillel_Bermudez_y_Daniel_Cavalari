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

public class AdminEstacionamiento extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField TextIngresarPlaca;
    private JTextField TextEliminar;
    private JTextField TextConsultar;
    private JTextField TextActualizar;
    private JTextField TextIngresarCedula;
    private JComboBox comboBox;
    private Connection connection;

    
    public AdminEstacionamiento() {
       

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

        TextIngresarPlaca = new JTextField();
        TextIngresarPlaca.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarPlaca.setBounds(10, 36, 239, 20);
        IngresarPanel.add(TextIngresarPlaca);
        TextIngresarPlaca.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Ingrese la placa del vehiculo a estacionar");
        lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 11, 303, 14);
        IngresarPanel.add(lblNewLabel_2);

        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Zona de parqueo 1", "Zona de parqueo 2", "Zona de parqueo 3"}));
        comboBox.setFont(new Font("Arial Black", Font.PLAIN, 12));
        comboBox.setBounds(10, 92, 239, 22);
        IngresarPanel.add(comboBox);

        JLabel lblNewLabel_2_1 = new JLabel("Ingrese la cedula del funcionario a estacionar");
        lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblNewLabel_2_1.setBounds(322, 12, 303, 14);
        IngresarPanel.add(lblNewLabel_2_1);

        TextIngresarCedula = new JTextField();
        TextIngresarCedula.setFont(new Font("Arial", Font.PLAIN, 12));
        TextIngresarCedula.setColumns(10);
        TextIngresarCedula.setBounds(322, 36, 239, 20);
        IngresarPanel.add(TextIngresarCedula);
        
        JButton BotonIngresar = new JButton("");
        BotonIngresar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\7785391 (1).png"));
        BotonIngresar.setBounds(601, 135, 53, 48);
        IngresarPanel.add(BotonIngresar);

        JPanel ConsultarPanel = new JPanel();
        ConsultarPanel.setVisible(false);
        ConsultarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(ConsultarPanel);
        ConsultarPanel.setLayout(null);

        JLabel lblIngreseElFuncionario = new JLabel("Consultar estacionamiento:");
        lblIngreseElFuncionario.setBounds(10, 11, 572, 29);
        lblIngreseElFuncionario.setForeground(Color.BLACK);
        lblIngreseElFuncionario.setFont(new Font("Arial Black", Font.PLAIN, 20));
        ConsultarPanel.add(lblIngreseElFuncionario);

        JButton BotonConsultar = new JButton("");
        BotonConsultar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\icone-loupe-vert (1).png"));
        BotonConsultar.setBounds(565, 130, 89, 53);
        ConsultarPanel.add(BotonConsultar);

        JPanel ActualizarPanel = new JPanel();
        ActualizarPanel.setVisible(false);
        ActualizarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(ActualizarPanel);
        ActualizarPanel.setLayout(null);

        JLabel labelNuevaCedula = new JLabel("Nueva Cédula:");
        labelNuevaCedula.setFont(new Font("Arial Black", Font.PLAIN, 14));
        labelNuevaCedula.setBounds(400, 11, 536, 29); 
        labelNuevaCedula.setForeground(Color.BLACK);
        ActualizarPanel.add(labelNuevaCedula);

        
        JTextField TextNuevaCedula = new JTextField();
        TextNuevaCedula.setFont(new Font("Arial", Font.PLAIN, 14));
        TextNuevaCedula.setBounds(400, 51, 239, 20);
        ActualizarPanel.add(TextNuevaCedula);


        JLabel lblIngreseLaCedula = new JLabel("Ingrese el ID del estacionamiento a actualizar:");
        lblIngreseLaCedula.setBounds(10, 11, 536, 29);
        lblIngreseLaCedula.setForeground(Color.BLACK);
        lblIngreseLaCedula.setFont(new Font("Arial Black", Font.PLAIN, 14));
        ActualizarPanel.add(lblIngreseLaCedula);

        TextActualizar = new JTextField();
        TextActualizar.setFont(new Font("Arial", Font.PLAIN, 14));
        TextActualizar.setBounds(10, 51, 239, 20);
        ActualizarPanel.add(TextActualizar);
        TextActualizar.setColumns(10);

        JLabel lblPlaca = new JLabel("Nueva placa del vehículo:");
        lblPlaca.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblPlaca.setBounds(10, 81, 239, 20);
        ActualizarPanel.add(lblPlaca);

        JTextField TextNuevaPlaca = new JTextField();
        TextNuevaPlaca.setFont(new Font("Arial", Font.PLAIN, 14));
        TextNuevaPlaca.setBounds(10, 102, 239, 20);
        ActualizarPanel.add(TextNuevaPlaca);

        JLabel lblZona = new JLabel("Seleccione nueva zona de parqueo:");
        lblZona.setFont(new Font("Arial Black", Font.PLAIN, 12));
        lblZona.setBounds(400, 81, 239, 20);
        ActualizarPanel.add(lblZona);

        JComboBox<String> ComboZonaActualizar = new JComboBox<>();
        ComboZonaActualizar.setModel(new DefaultComboBoxModel<>(new String[] {
            "Seleccione...", "Zona de parqueo 1", "Zona de parqueo 2", "Zona de parqueo 3"
        }));
        ComboZonaActualizar.setFont(new Font("Arial Black", Font.PLAIN, 12));
        ComboZonaActualizar.setBounds(400, 102, 239, 22);
        ActualizarPanel.add(ComboZonaActualizar);

        JButton BotonActualizar = new JButton("");
        BotonActualizar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\2091540 (1).png"));
        BotonActualizar.setBounds(565, 130, 89, 53);
        ActualizarPanel.add(BotonActualizar);  

        JPanel EliminarPanel = new JPanel();
        EliminarPanel.setVisible(false);
        EliminarPanel.setBounds(10, 143, 664, 194);
        contentPane.add(EliminarPanel);
        EliminarPanel.setLayout(null);

        JLabel lblNewLabel_4 = new JLabel("Ingrese el id del estacionamiento a Eliminar:");
        lblNewLabel_4.setBounds(10, 11, 536, 29);
        lblNewLabel_4.setForeground(Color.BLACK);
        lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 16));
        EliminarPanel.add(lblNewLabel_4);

        TextEliminar = new JTextField();
        TextEliminar.setFont(new Font("Arial", Font.PLAIN, 14));
        TextEliminar.setColumns(10);
        TextEliminar.setBounds(10, 51, 405, 20);
        EliminarPanel.add(TextEliminar);

        JButton BotonEliminar = new JButton("");
        BotonEliminar.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\uninstall_9498859 (1).png"));
        BotonEliminar.setBounds(565, 130, 89, 53);
        EliminarPanel.add(BotonEliminar);

        JPanel PanelOpciones = new JPanel();
        PanelOpciones.setBounds(10, 11, 664, 111);
        contentPane.add(PanelOpciones);
        PanelOpciones.setLayout(null);

        JComboBox<String> ComboOpciones = new JComboBox<String>();
        ComboOpciones.setModel(new DefaultComboBoxModel(new String[] {"Seleccione...", "Ingresar estacionamiento", "Consultar estacionamiento", "Actualizar estacionamiento", "Eliminar estacionamiento"}));
        ComboOpciones.setFont(new Font("Arial Black", Font.PLAIN, 15));
        ComboOpciones.setBounds(10, 61, 353, 32);
        PanelOpciones.add(ComboOpciones);

        JLabel lblNewLabel = new JLabel("Seleccione la acción que desea realizar:");
        lblNewLabel.setBounds(10, 11, 507, 39);
        PanelOpciones.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
        lblNewLabel.setForeground(new Color(0, 0, 0));

        JButton btnNewButton = new JButton("");
        btnNewButton.setIcon(new ImageIcon("PF_Naillel_Bermudez_y_Daniel_Cavalari\\Img\\turn-left_11044994__1_-removebg-preview.png"));
        btnNewButton.setBounds(10, 348, 51, 54);
        contentPane.add(btnNewButton);

       
        btnNewButton.addActionListener(new ActionListener() {
        	
        	
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Menu m = new Menu();
                m.setVisible(true);
                
        	}
        });

        ComboOpciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = ComboOpciones.getSelectedItem().toString();

                IngresarPanel.setVisible(false);
                ConsultarPanel.setVisible(false);
                ActualizarPanel.setVisible(false);
                EliminarPanel.setVisible(false);

                switch (opcionSeleccionada) {
                    case "Ingresar estacionamiento":
                        IngresarPanel.setVisible(true);
                        break;
                    case "Consultar estacionamiento":
                        ConsultarPanel.setVisible(true);
                        break;
                    case "Actualizar estacionamiento":
                        ActualizarPanel.setVisible(true);
                        break;
                    case "Eliminar estacionamiento":
                        EliminarPanel.setVisible(true);
                        break;
                    default:
                        break;
                }
            }
        });

        
        BotonIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Connection conexion = null;
            	CallableStatement empaquetar = null;

            	String cedula = TextIngresarCedula.getText();
            	String placa = TextIngresarPlaca.getText();
            	String zona = (String) comboBox.getSelectedItem();

            	if (cedula.isEmpty() || placa.isEmpty() || zona.isEmpty()) {
            	    JOptionPane.showMessageDialog(null, "Los campos de cédula, placa y zona son obligatorios.");
            	    return;
            	}

            	try {
            	    
            	    conexion = DriverManager.getConnection(
            	        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true", 
            	        "root", 
            	        "552280"
            	    );
            	    conexion.setAutoCommit(true);

            	   
            	    String procedimiento = "{CALL insertar_estacionamiento(?, ?, ?)}";
            	    empaquetar = conexion.prepareCall(procedimiento);

            	   
            	    empaquetar.setString(1, cedula);
            	    empaquetar.setString(2, placa);
            	    empaquetar.setString(3, zona);

            	    
            	    int exito = empaquetar.executeUpdate();
            	    if (exito > 0) {
            	        JOptionPane.showMessageDialog(null, "El estacionamiento ha sido ingresado con éxito.");
            	        
            	        
            	        TextIngresarCedula.setText("");
            	        TextIngresarPlaca.setText("");
            	        comboBox.setSelectedIndex(0); 
            	    } else {
            	        JOptionPane.showMessageDialog(null, "No se pudo ingresar el estacionamiento.");
            	    }

            	} catch (SQLException e1) {
            	    e1.printStackTrace();
            	    JOptionPane.showMessageDialog(null, "Error al ingresar estacionamiento: " + e1.getMessage());
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

                    String procedimiento = "{CALL ver_todos_los_estacionamientos()}";
                    empaquetar = conexion.prepareCall(procedimiento);
                    rs = empaquetar.executeQuery();

                   
                    if (rs.isBeforeFirst()) { 
                        ResultadoConsultaFrame resultadoFrame = new ResultadoConsultaFrame(rs);
                        resultadoFrame.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros en estacionamiento.");
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al consultar estacionamientos: " + e1.getMessage());
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
       
        BotonActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                CallableStatement stmt = null;
        
                String idEstacionamiento = TextActualizar.getText();
                String nuevaPlaca = TextNuevaPlaca.getText();
                String nuevaZona = (String) ComboZonaActualizar.getSelectedItem();
                String nuevaCedula = TextNuevaCedula.getText(); 
        
                
                if (idEstacionamiento.isEmpty() || nuevaPlaca.isEmpty() || nuevaCedula.isEmpty() || "Seleccione...".equals(nuevaZona)) {
                    JOptionPane.showMessageDialog(null, "Debe completar todos los campos para actualizar.");
                    return;
                }
        
                try {
                    conexion = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/parqueo_funcionarios?verifyServerCertificate=false&useSSL=true",
                        "root",
                        "552280"
                    );
        
                    
                    stmt = conexion.prepareCall("{call actualizar_estacionamiento(?, ?, ?, ?)}");
                    stmt.setInt(1, Integer.parseInt(idEstacionamiento)); 
                    stmt.setString(2, nuevaCedula); 
                    stmt.setString(3, nuevaPlaca); 
                    stmt.setString(4, nuevaZona); 
        
                    int rowsAffected = stmt.executeUpdate();
        
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Estacionamiento actualizado correctamente.");
                        TextActualizar.setText("");
                        TextNuevaPlaca.setText("");
                        TextNuevaCedula.setText(""); 
                        ComboZonaActualizar.setSelectedIndex(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al actualizar el estacionamiento.");
                    }
        
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e1.getMessage());
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "ID de estacionamiento inválido.");
                } finally {
                    try {
                        if (stmt != null) stmt.close();
                        if (conexion != null) conexion.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        


        
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

                    String procedimiento = "{CALL eliminar_estacionamiento(?)}";
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
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminEstacionamiento frame = new AdminEstacionamiento();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
