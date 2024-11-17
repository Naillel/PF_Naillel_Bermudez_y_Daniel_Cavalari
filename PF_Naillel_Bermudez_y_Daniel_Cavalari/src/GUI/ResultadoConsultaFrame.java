package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ResultadoConsultaFrame extends JFrame {

    public ResultadoConsultaFrame(ResultSet resultSet) {
        setTitle("Resultados de la Consulta");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());

        try {
            
            DefaultTableModel tableModel = new DefaultTableModel();
            JTable table = new JTable(tableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table.setDefaultEditor(Object.class, null); 
            JScrollPane scrollPane = new JScrollPane(table);
            getContentPane().add(scrollPane, BorderLayout.CENTER);

            
            JButton botonSalida = new JButton("");
            try {
                botonSalida.setIcon(new ImageIcon("C:\\Users\\naill\\Downloads\\turn-left_11044994__1_-removebg-preview.png"));
            } catch (Exception e) {
                System.err.println("No se pudo cargar el icono del botón: " + e.getMessage());
            }
            botonSalida.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); 
                }
            });
            getContentPane().add(botonSalida, BorderLayout.SOUTH);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnName(columnIndex));
            }

           
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    rowData[columnIndex - 1] = resultSet.getObject(columnIndex);
                }
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(this, 
                "Error al cargar los datos: " + e.getMessage(),
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
}
