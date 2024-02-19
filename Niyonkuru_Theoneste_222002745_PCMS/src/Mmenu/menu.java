package Mmenu;

import javax.swing.*;

import Employee.forms.EmployeeForm;
import customerform.CustomerForm;
import financeform.FinanceForm;
import marketform.MarketForm;
import productform.ProductForm;
import propertiesform.PropertiesForm;
import rawmaterialsform.RawMaterialsForm;
import supplierform.SupplierForm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu homeMenu;
    private JMenuItem employeeItem;
    private JMenuItem financeItem;
    private JMenuItem productItem;
    private JMenuItem propertiesItem;
    private JMenuItem rawMaterialsItem;
    private JMenuItem supplierItem;
    private JMenuItem marketItem;
    private JMenuItem customerItem;

    private JMenuItem settingsItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public menu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(800, 600); // Adjusted size for better image display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();

        // Create home menu
        homeMenu = new JMenu("Home");

        // Create menu items
        employeeItem = new JMenuItem("Employee");
        employeeItem.addActionListener(this);
        financeItem = new JMenuItem("Finance");
        financeItem.addActionListener(this);
        productItem = new JMenuItem(" Product");
        productItem.addActionListener(this);
        propertiesItem = new JMenuItem("Properties");
        propertiesItem.addActionListener(this);
        rawMaterialsItem = new JMenuItem("RawMaterials");
        rawMaterialsItem.addActionListener(this);
        supplierItem = new JMenuItem("Supplier");
        supplierItem.addActionListener(this);
        marketItem = new JMenuItem("market");
        marketItem.addActionListener(this);
        customerItem = new JMenuItem("customer");
        customerItem.addActionListener(this);


        settingsItem = new JMenuItem("Settings");
        settingsItem.addActionListener(this);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        homeMenu.add(employeeItem);
        homeMenu.add(financeItem);
        homeMenu.add(productItem);
        homeMenu.add(propertiesItem);
        homeMenu.add(rawMaterialsItem);
        homeMenu.add(supplierItem);
        homeMenu.add(marketItem);
        homeMenu.add(customerItem);
        homeMenu.addSeparator();
        homeMenu.add(settingsItem);
        homeMenu.addSeparator();
        homeMenu.add(logoutItem);

        // Add home menu to menu bar
        menuBar.add(homeMenu);

        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("C:\\Users\\user1\\Desktop\\answers\\solo-tree-ow.jpg").getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        dashboardPanel.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("HELLO " + loggedInUser + " WELCOME TO PRODUCTION COMPANY DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel);

        setVisible(true);
    }

    public void actionPerformed1(ActionEvent e) {
        // Action handling code here
    }

    public static void main1(String[] args) {
        SwingUtilities.invokeLater(() -> new menu("User"));
    }

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == employeeItem) {
        JOptionPane.showMessageDialog(this, "Open Employee...");
        new EmployeeForm();
    } else if (e.getSource() == financeItem) {
        JOptionPane.showMessageDialog(this, "Open Finance...");
        new FinanceForm();
    } else if (e.getSource() == productItem) {
        JOptionPane.showMessageDialog(this, "Open Product...");
        new ProductForm();
    } else if (e.getSource() == propertiesItem) {
        JOptionPane.showMessageDialog(this, "Open Properties...");
        new PropertiesForm();
    } else if (e.getSource() == rawMaterialsItem) {
        JOptionPane.showMessageDialog(this, "Open RawMaterials...");
        new RawMaterialsForm();
        
    }else if (e.getSource() == supplierItem) {
            JOptionPane.showMessageDialog(this, "Open Supplier...");
            new SupplierForm();
    } else if (e.getSource() == marketItem) {
                JOptionPane.showMessageDialog(this, "Open Market...");
                new MarketForm();
    }else if (e.getSource() == customerItem) {
                    JOptionPane.showMessageDialog(this, "Open Customer...");
                    new CustomerForm();
        
    } else if (e.getSource() == settingsItem) {
        String newUsername = JOptionPane.showInputDialog(this, "Enter new username:");
        String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
        JOptionPane.showMessageDialog(this, "User registered successfully: " + newUsername);
    } else if (e.getSource() == logoutItem) {
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        }
    }
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new menu("User"));
}
}

