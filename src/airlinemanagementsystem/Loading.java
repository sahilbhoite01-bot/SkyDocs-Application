package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    private int s;
    private Thread th;
    private String username;

    public static void main(String[] args) {
        new Loading("").setVisible(true);
    }

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i <= 100; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 101;
                    setVisible(false);
                    new Home().setVisible(true);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Constructor accepting username parameter
    public Loading(String username) {
        this(); // Call default constructor
        this.username = username;
        System.out.println("Welcome " + username);
    }

    // ✅ Default constructor
    public Loading() {
        th = new Thread(this);

        setBounds(600, 300, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 204, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitle = new JLabel("Airline Management System");
        lblTitle.setForeground(new Color(72, 209, 204));
        lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
        lblTitle.setBounds(50, 46, 500, 35);
        contentPane.add(lblTitle);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Tahoma", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(130, 135, 300, 25);
        contentPane.add(progressBar);

        JLabel lblWait = new JLabel("Please Wait....");
        lblWait.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 20));
        lblWait.setForeground(new Color(160, 82, 45));
        lblWait.setBounds(200, 165, 150, 20);
        contentPane.add(lblWait);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(10, 10, 580, 380);
        contentPane.add(panel);

        setUndecorated(true);
        setUploading();
    }
}
