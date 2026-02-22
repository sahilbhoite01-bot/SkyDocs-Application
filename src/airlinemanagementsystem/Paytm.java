package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paytm extends JFrame implements ActionListener {

    JButton backButton;

    public Paytm() {
        setTitle("Pay via Paytm");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel heading = new JLabel("Payment ? $2 : Bad Luck");
        heading.setBounds(150, 20, 300, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 24));
        heading.setForeground(Color.BLUE);
        add(heading);

        // QR Code Image
        ImageIcon qrIcon = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/Qr.png.png"));
        Image qrImage = qrIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel qrLabel = new JLabel(new ImageIcon(qrImage));
        qrLabel.setBounds(150, 80, 300, 300);
        add(qrLabel);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(230, 400, 120, 40);
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
        if (ae.getSource() == backButton) {
            setVisible(false);
            new Payment(); // Go back to Payment page
        }
    }

    public static void main(String[] args) {
        new Paytm();
    }
}
