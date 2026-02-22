package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewCustomers extends JFrame {

    private JPanel contentPane;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ViewCustomers frame = new ViewCustomers();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public ViewCustomers() {
        setTitle("View Profile");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(580, 220, 900, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        getContentPane().setBackground(Color.WHITE);

        // ✅ Table to display customer details
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // ✅ Disable cell editing
            }
        };
        table.setBounds(0, 40, 900, 350);
        contentPane.add(table);

        // ✅ Load customer data from the database
        try {
            Conn conn = new Conn(); // Make sure Conn.java is correctly set up
            String query = "SELECT name, nationality, phone, address, aadhar, gender FROM passenger";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs)); // ✅ Display data in table
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ✅ Back Button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(390, 400, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(e -> setVisible(false)); // ✅ Close only this window
        contentPane.add(btnBack);

        // ✅ Table Headers
        String[] headers = {"Name", "Nationality", "Phone", "Address", "Aadhar", "Gender"};
        int xPos = 10;
        for (String header : headers) {
            JLabel label = new JLabel(header);
            label.setBounds(xPos, 15, 90, 14);
            contentPane.add(label);
            xPos += 140;
        }
    }
}
