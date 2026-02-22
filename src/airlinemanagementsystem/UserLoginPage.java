package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserLoginPage extends JFrame implements ActionListener {

    JTextField usernameField, emailField, phoneField, regUsernameField;
    JPasswordField passwordField, regPasswordField;
    JButton loginButton, registerButton, switchToRegister, switchToLogin;
    JCheckBox showPasswordLogin, showPasswordRegister;
    JPanel loginPanel, registerPanel;
    JLabel background;

    public UserLoginPage() {
        setTitle("Airline Management System - User Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);

        // Background Image
        ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airline_bg.jpg"));
        background = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setBounds(0, 0, getWidth(), getHeight());
        add(background);

        loginPanel = createLoginPanel();
        registerPanel = createRegisterPanel();

        background.setLayout(null);
        background.add(loginPanel);
        background.add(registerPanel);
        registerPanel.setVisible(false);

        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                background.setBounds(0, 0, getWidth(), getHeight());
                centerPanels();
            }
        });

        centerPanels();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createLoginPanel() {
        JPanel panel = createStyledPanel();

        JLabel title = createTitleLabel("User Login");
        title.setBounds(200, 30, 250, 30);
        panel.add(title);

        usernameField = addLabeledField(panel, "Username:", 90);
        passwordField = addLabeledPasswordField(panel, "Password:", 140);

        showPasswordLogin = createShowPasswordCheckbox(passwordField);
        showPasswordLogin.setBounds(150, 175, 150, 25);
        panel.add(showPasswordLogin);

        loginButton = createStyledButton("Login", 100, 230);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        switchToRegister = createStyledButton("Register", 280, 230);
        switchToRegister.addActionListener(e -> togglePanel());
        panel.add(switchToRegister);

        return panel;
    }

    private JPanel createRegisterPanel() {
        JPanel panel = createStyledPanel();

        JLabel title = createTitleLabel("User Registration");
        title.setBounds(180, 20, 300, 30);
        panel.add(title);

        emailField = addLabeledField(panel, "Email:", 70);
        phoneField = addLabeledField(panel, "Phone:", 120);
        regUsernameField = addLabeledField(panel, "Username:", 170);
        regPasswordField = addLabeledPasswordField(panel, "Password:", 220);

        showPasswordRegister = createShowPasswordCheckbox(regPasswordField);
        showPasswordRegister.setBounds(150, 255, 150, 25);
        panel.add(showPasswordRegister);

        registerButton = createStyledButton("Register", 100, 310);
        registerButton.addActionListener(e -> registerUser());
        panel.add(registerButton);

        switchToLogin = createStyledButton("Back to Login", 280, 310);
        switchToLogin.addActionListener(e -> togglePanel());
        panel.add(switchToLogin);

        return panel;
    }

    private JPanel createStyledPanel() {
        JPanel panel = new JPanel(null);
        panel.setBackground(new Color(0, 0, 0, 180));
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 3),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        panel.setOpaque(true);
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 3),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        panel.setBackground(new Color(0, 0, 0, 180));
        panel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        panel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.WHITE, 3),
            BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        return panel;
    }

    private JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        return label;
    }

    private JTextField addLabeledField(JPanel panel, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(50, y, 120, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);

        JTextField field = new JTextField();
        field.setBounds(180, y, 250, 30);
        panel.add(field);
        return field;
    }

    private JPasswordField addLabeledPasswordField(JPanel panel, String labelText, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(50, y, 120, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(label);

        JPasswordField field = new JPasswordField();
        field.setBounds(180, y, 250, 30);
        panel.add(field);
        return field;
    }

    private JCheckBox createShowPasswordCheckbox(JPasswordField field) {
        JCheckBox checkBox = new JCheckBox("Show Password");
        checkBox.setBackground(new Color(0, 0, 0, 0));
        checkBox.setForeground(Color.WHITE);
        checkBox.addActionListener(e -> field.setEchoChar(checkBox.isSelected() ? '\0' : '•'));
        return checkBox;
    }

    private JButton createStyledButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 140, 40);
        button.setBackground(new Color(30, 144, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setFocusPainted(false);
        return button;
    }

    private void togglePanel() {
        loginPanel.setVisible(!loginPanel.isVisible());
        registerPanel.setVisible(!registerPanel.isVisible());
    }

    private void centerPanels() {
        int width = getWidth();
        int height = getHeight();
        int panelWidth = 500;  // Wider
        int panelHeight = 400; // Taller

        int x = (width - panelWidth) / 2;
        int y = (height - panelHeight) / 2 - 30;  // Center slightly higher

        loginPanel.setBounds(x, y, panelWidth, panelHeight);
        registerPanel.setBounds(x, y, panelWidth, panelHeight);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            authenticateUser();
        }
    }

    private void authenticateUser() {
        // Your DB connection logic
    }

    private void registerUser() {
        usernameField.setText(regUsernameField.getText());
        passwordField.setText(new String(regPasswordField.getPassword()));
        togglePanel();
    }

    public static void main(String[] args) {
        new UserLoginPage();
    }
}
