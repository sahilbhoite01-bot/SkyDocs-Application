package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {

    private JLabel backgroundImage;
    private JLabel heading;
    private JMenuBar menubar;
    private Dimension screenSize;
    private String username = "john_doe"; // Example username (replace with actual value)

    public Home() {
        setLayout(null);

        // Get screen size dynamically
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Load background image
        ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/new plane.jpg"));
        Image scaledImage = originalImage.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedImageIcon = new ImageIcon(scaledImage);

        backgroundImage = new JLabel(resizedImageIcon);
        backgroundImage.setBounds(0, 0, screenWidth, screenHeight);
        add(backgroundImage);

        // Centered heading
        heading = new JLabel("Your Journey Begins Here");
        heading.setFont(new Font("Georgia", Font.BOLD, 50));
        heading.setForeground(Color.WHITE);
        heading.setHorizontalAlignment(SwingConstants.CENTER);

        int headingWidth = 1000;
        int headingHeight = 80;
        int headingX = (screenWidth - headingWidth) / 2;
        int headingY = 100;

        heading.setBounds(headingX, headingY, headingWidth, headingHeight);
        addShadowEffect(heading);
        backgroundImage.add(heading);

        // Menu bar
        menubar = new JMenuBar();
        menubar.setBackground(new Color(45, 50, 105));
        menubar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setJMenuBar(menubar);

        addStyledMenu("Details");
        addStyledMenu("Ticket");
        addProfileMenu(); // ✅ Profile Menu
        addLogoutMenu();  // ✅ Logout Menu
        addUserLoginMenu(); // ✅ New UserLogin Menu

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void addStyledMenu(String title) {
        JMenu menu = new JMenu(title);
        menu.setFont(new Font("SansSerif", Font.BOLD, 18));
        menu.setForeground(Color.WHITE);
        menu.setBackground(new Color(0, 33, 80));
        menu.setOpaque(true);
        menu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        if (title.equals("Details")) {
            addMenuItem(menu, "Flight Details");
            addMenuItem(menu, "Add Customer Details");
            addMenuItem(menu, "Book Flight");
            addMenuItem(menu, "Journey Details");
            addMenuItem(menu, "Cancel Ticket");
        } else if (title.equals("Ticket")) {
            addMenuItem(menu, "Boarding Pass");
        }

        menubar.add(menu);
    }

    private void addProfileMenu() {
        JMenu profileMenu = new JMenu("Profile");
        profileMenu.setFont(new Font("SansSerif", Font.BOLD, 18));
        profileMenu.setForeground(Color.WHITE);
        profileMenu.setBackground(new Color(0, 33, 80));
        profileMenu.setOpaque(true);
        profileMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        addMenuItem(profileMenu, "View Profile");
        addMenuItem(profileMenu, "Edit Profile");
        addMenuItem(profileMenu, "Payments");

        menubar.add(profileMenu);
    }

    private void addLogoutMenu() {
        JMenu logoutMenu = new JMenu("Logout");
        logoutMenu.setFont(new Font("SansSerif", Font.BOLD, 18));
        logoutMenu.setForeground(Color.white);
        logoutMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JMenuItem logoutItem = new JMenuItem("Logout & Exit");
        logoutItem.setFont(new Font("SansSerif", Font.PLAIN, 16));
        logoutItem.setBackground(new Color(255, 220, 220));
        logoutItem.setOpaque(true);
        logoutItem.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        logoutItem.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to logout and exit?",
                    "Confirm Logout",
                    JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        menubar.add(Box.createHorizontalGlue());
        menubar.add(logoutMenu);
        logoutMenu.add(logoutItem);
    }

    // ✅ New UserLogin Menu
    private void addUserLoginMenu() {
        JMenu userLoginMenu = new JMenu("UserLogin");
        userLoginMenu.setFont(new Font("SansSerif", Font.BOLD, 18));
        userLoginMenu.setForeground(Color.WHITE);
        userLoginMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JMenuItem userLoginItem = new JMenuItem("User Login");
        userLoginItem.setFont(new Font("SansSerif", Font.PLAIN, 16));
        userLoginItem.setBackground(new Color(230, 230, 230));
        userLoginItem.setOpaque(true);
        userLoginItem.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        userLoginItem.addActionListener(e -> {
//            JOptionPane.showMessageDialog(this, "Opening User Login...");
            // Add your UserLogin logic here
            new UserLogin().setVisible(true);
        });

        userLoginMenu.add(userLoginItem);
        menubar.add(userLoginMenu);
    }

    private void addMenuItem(JMenu menu, String itemText) {
        JMenuItem item = new JMenuItem(itemText);
        item.setFont(new Font("SansSerif", Font.PLAIN, 16));
        item.setOpaque(true);
        item.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        item.setBackground(new Color(230, 230, 230));

        item.addActionListener(this);

        menu.add(item);
    }

    private void addShadowEffect(JLabel label) {
        label.setForeground(Color.WHITE);
        label.setOpaque(false);

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(label.getBounds());

        JLabel shadowLabel = new JLabel(label.getText());
        shadowLabel.setBounds(3, 3, label.getWidth(), label.getHeight());
        shadowLabel.setFont(label.getFont());
        shadowLabel.setForeground(Color.BLACK);
        shadowLabel.setHorizontalAlignment(label.getHorizontalAlignment());

        layeredPane.add(shadowLabel, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label, JLayeredPane.PALETTE_LAYER);

        backgroundImage.add(layeredPane);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();

        try {
            switch (text) {
                case "Add Customer Details":
                    new AddCustomer().setVisible(true);
                    break;
                case "Flight Details":
                    new FlightInfo().setVisible(true);
                    break;
                case "Book Flight":
                    new BookFlight().setVisible(true);
                    break;
                case "Journey Details":
                    new JourneyDetails().setVisible(true);
                    break;
                case "Cancel Ticket":
                    new Cancel().setVisible(true);
                    break;
                case "Boarding Pass":
                    new BoardingPass().setVisible(true);
                    break;
                case "View Profile":
                    new ViewCustomers().setVisible(true);
                    break;
                case "Edit Profile":
                    new UpdateCustomer(this.username).setVisible(true);
                    break;
                case "Payments":
                    new Payment().setVisible(true);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
