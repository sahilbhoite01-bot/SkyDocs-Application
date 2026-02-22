package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
    JRadioButton rbmale, rbfemale;
    
    public AddCustomer() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220, 280, 70, 25);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300, 280, 70, 25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450, 80, 280, 400);
        add(lblimage);
        
        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
        
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}


//
//
//
//package airlinemanagementsystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//
//public class UpdateCustomer extends JFrame implements ActionListener {
//
//    JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
//    JRadioButton rbmale, rbfemale;
//    JButton update, back;
//    String aadhar;
//
//    public UpdateCustomer(String aadhar) {
//        this.aadhar = aadhar;
//        
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel heading = new JLabel("EDIT CUSTOMER DETAILS");
//        heading.setBounds(220, 20, 500, 35);
//        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
//        heading.setForeground(Color.BLUE);
//        add(heading);
//
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(60, 80, 150, 25);
//        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblname);
//
//        tfname = new JTextField();
//        tfname.setBounds(220, 80, 150, 25);
//        add(tfname);
//
//        JLabel lblnationality = new JLabel("Nationality");
//        lblnationality.setBounds(60, 130, 150, 25);
//        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblnationality);
//
//        tfnationality = new JTextField();
//        tfnationality.setBounds(220, 130, 150, 25);
//        add(tfnationality);
//
//        JLabel lblaadhar = new JLabel("Aadhar Number");
//        lblaadhar.setBounds(60, 180, 150, 25);
//        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblaadhar);
//
//        tfaadhar = new JTextField();
//        tfaadhar.setBounds(220, 180, 150, 25);
//        tfaadhar.setEditable(false);
//        add(tfaadhar);
//
//        JLabel lbladdress = new JLabel("Address");
//        lbladdress.setBounds(60, 230, 150, 25);
//        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lbladdress);
//
//        tfaddress = new JTextField();
//        tfaddress.setBounds(220, 230, 150, 25);
//        add(tfaddress);
//
//        JLabel lblgender = new JLabel("Gender");
//        lblgender.setBounds(60, 280, 150, 25);
//        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblgender);
//
//        ButtonGroup gendergroup = new ButtonGroup();
//
//        rbmale = new JRadioButton("Male");
//        rbmale.setBounds(220, 280, 70, 25);
//        rbmale.setBackground(Color.WHITE);
//        add(rbmale);
//
//        rbfemale = new JRadioButton("Female");
//        rbfemale.setBounds(300, 280, 70, 25);
//        rbfemale.setBackground(Color.WHITE);
//        add(rbfemale);
//
//        gendergroup.add(rbmale);
//        gendergroup.add(rbfemale);
//
//        JLabel lblphone = new JLabel("Phone");
//        lblphone.setBounds(60, 330, 150, 25);
//        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblphone);
//
//        tfphone = new JTextField();
//        tfphone.setBounds(220, 330, 150, 25);
//        add(tfphone);
//
//        // ✅ Load Existing Data
//        try {
//            Conn c = new Conn();
//            String query = "SELECT * FROM passenger WHERE aadhar = ?";
//            PreparedStatement pst = c.c.prepareStatement(query);
//            pst.setString(1, aadhar);
//            ResultSet rs = pst.executeQuery();
//
//            if (rs.next()) {
//                tfname.setText(rs.getString("name"));
//                tfnationality.setText(rs.getString("nationality"));
//                tfaadhar.setText(rs.getString("aadhar"));
//                tfaddress.setText(rs.getString("address"));
//                tfphone.setText(rs.getString("phone"));
//                
//                String gender = rs.getString("gender");
//                if (gender != null) {
//                    if (gender.equals("Male")) {
//                        rbmale.setSelected(true);
//                    } else {
//                        rbfemale.setSelected(true);
//                    }
//                }
//            }
//            rs.close();
//            pst.close();
//            c.c.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Failed to load customer data");
//        }
//
//        // ✅ Update Button
//        update = new JButton("UPDATE");
//        update.setBackground(Color.BLACK);
//        update.setForeground(Color.WHITE);
//        update.setBounds(115, 450, 150, 30);
//        update.addActionListener(this);
//        add(update);
//
//        // ✅ Back Button
//        back = new JButton("BACK");
//        back.setBackground(Color.BLACK);
//        back.setForeground(Color.WHITE);
//        back.setBounds(300, 450, 150, 30);
//        back.addActionListener(this);
//        add(back);
//
//        // ✅ Image
//        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
//        JLabel lblimage = new JLabel(image);
//        lblimage.setBounds(450, 80, 280, 400);
//        add(lblimage);
//
//        setSize(900, 600);
//        setLocation(300, 150);
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == update) {
//            String name = tfname.getText();
//            String nationality = tfnationality.getText();
//            String address = tfaddress.getText();
//            String phone = tfphone.getText();
//
//            String gender = null;
//            if (rbmale.isSelected()) {
//                gender = "Male";
//            } else if (rbfemale.isSelected()) {
//                gender = "Female";
//            }
//
//            if (name.isEmpty() || nationality.isEmpty() || address.isEmpty() || phone.isEmpty() || gender == null) {
//                JOptionPane.showMessageDialog(null, "All fields are required");
//                return;
//            }
//
//            // ✅ Update Data in Database
//            try {
//                Conn conn = new Conn();
//                String query = "UPDATE passenger SET name = ?, nationality = ?, address = ?, phone = ?, gender = ? WHERE aadhar = ?";
//                PreparedStatement pst = conn.c.prepareStatement(query);
//                pst.setString(1, name);
//                pst.setString(2, nationality);
//                pst.setString(3, address);
//                pst.setString(4, phone);
//                pst.setString(5, gender);
//                pst.setString(6, aadhar);
//
//                int rowsUpdated = pst.executeUpdate();
//                pst.close();
//                conn.c.close();
//
//                if (rowsUpdated > 0) {
//                    JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
//                    setVisible(false);
//                } else {
//                    JOptionPane.showMessageDialog(null, "Failed to Update Customer Details");
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(null, "Error updating data");
//            }
//
//        } else if (ae.getSource() == back) {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new UpdateCustomer("123456789012");
//    }
//}
