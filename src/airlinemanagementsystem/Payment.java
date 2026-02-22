package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Payment extends JFrame implements ActionListener {

    JButton payButton, backButton;

    public Payment() {
        setTitle("Payment");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel heading = new JLabel("For Ticket Make payment");
        heading.setBounds(150, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Payment Image
        ImageIcon paymentIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/paytm.jpeg"));
        Image img = paymentIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel paymentImage = new JLabel(new ImageIcon(img));
        paymentImage.setBounds(100, 80, 400, 300);
        add(paymentImage);

        // Pay Button
        payButton = new JButton("Pay Now");
        payButton.setBounds(150, 400, 120, 40);
        payButton.setBackground(Color.BLACK);
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        add(payButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(300, 400, 120, 40);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        add(backButton);

        setSize(600, 500);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == payButton) {
            // Open Paytm Page
            new Paytm();
            setVisible(false);
        } else if (ae.getSource() == backButton) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
