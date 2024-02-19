package supplierform;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import niyonkurru.Employee;
import niyonkurru.Supplier;

public class SupplierForm implements ActionListener {
    JFrame frame;
    JLabel supIDLabel = new JLabel("Supplier ID");
    JLabel fnameLabel = new JLabel("First Name");
    JLabel lnameLabel = new JLabel("Last Name");
    JLabel provinceLabel = new JLabel("Province");
    JLabel districtLabel = new JLabel("District");
    JLabel sectorLabel = new JLabel("Sector");
    JLabel phoneLabel = new JLabel("Phone");
    JLabel emailLabel = new JLabel("Email");
    JLabel amountPaidLabel = new JLabel("Amount Paid");

    JTextField supIDTextField = new JTextField();
    JTextField fnameTextField = new JTextField();
    JTextField lnameTextField = new JTextField();
    JTextField provinceTextField = new JTextField();
    JTextField districtTextField = new JTextField();
    JTextField sectorTextField = new JTextField();
    JTextField phoneTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField amountPaidTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public SupplierForm() {
        createForm();
        addActionListeners();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Supplier Form");
        frame.setBounds(0, 0, width / 2, height / 2);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.cyan);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }

    private void setLocationAndSize() {
        int labelX = 10, labelWidth = 150;
        int textFieldX = 160, textFieldWidth = 200;
        int startY = 10, spacingY = 60;

        supIDLabel.setBounds(labelX, startY, labelWidth, 30);
        fnameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        lnameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        provinceLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        districtLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        sectorLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        phoneLabel.setBounds(labelX, startY + 6 * spacingY, labelWidth, 30);
        emailLabel.setBounds(labelX, startY + 7 * spacingY, labelWidth, 30);
        amountPaidLabel.setBounds(labelX, startY + 8 * spacingY, labelWidth, 30);
        
        supIDTextField.setBackground(Color.yellow);
        lnameTextField.setBackground(Color.yellow);
        fnameTextField.setBackground(Color.yellow);
        provinceTextField.setBackground(Color.yellow);
        districtTextField.setBackground(Color.yellow);
        sectorTextField.setBackground(Color.yellow);
        phoneTextField.setBackground(Color.yellow);
        emailTextField.setBackground(Color.yellow);
        amountPaidTextField.setBackground(Color.yellow);
        
        supIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        fnameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        lnameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        provinceTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        districtTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        sectorTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);
        phoneTextField.setBounds(textFieldX, startY + 6 * spacingY, textFieldWidth, 30);
        emailTextField.setBounds(textFieldX, startY + 7 * spacingY, textFieldWidth, 30);
        amountPaidTextField.setBounds(textFieldX, startY + 8 * spacingY, textFieldWidth, 30);

        insertButton.setBackground(Color.MAGENTA);
        viewButton.setBackground(Color.MAGENTA);
        deleteButton.setBackground(Color.MAGENTA);
        updateButton.setBackground(Color.MAGENTA);
        
        insertButton.setBounds(labelX, 550, 90, 30);
        viewButton.setBounds(labelX + 100, 550, 90, 30);
        updateButton.setBounds(labelX + 200, 550, 90, 30);
        deleteButton.setBounds(labelX + 300, 550, 90, 30);
        table.setBounds(400, 10, 900, 570);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        supIDLabel.setFont(font);
        fnameLabel.setFont(font);
        lnameLabel.setFont(font);
        provinceLabel.setFont(font);
        districtLabel.setFont(font);
        sectorLabel.setFont(font);
        phoneLabel.setFont(font);
        emailLabel.setFont(font);
        amountPaidLabel.setFont(font);

        supIDTextField.setFont(font);
        fnameTextField.setFont(font);
        lnameTextField.setFont(font);
        provinceTextField.setFont(font);
        districtTextField.setFont(font);
        sectorTextField.setFont(font);
        phoneTextField.setFont(font);
        emailTextField.setFont(font);
        amountPaidTextField.setFont(font);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(supIDLabel);
        frame.add(fnameLabel);
        frame.add(lnameLabel);
        frame.add(provinceLabel);
        frame.add(districtLabel);
        frame.add(sectorLabel);
        frame.add(phoneLabel);
        frame.add(emailLabel);
        frame.add(amountPaidLabel);

        frame.add(supIDTextField);
        frame.add(fnameTextField);
        frame.add(lnameTextField);
        frame.add(provinceTextField);
        frame.add(districtTextField);
        frame.add(sectorTextField);
        frame.add(phoneTextField);
        frame.add(emailTextField);
        frame.add(amountPaidTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	Supplier sup=new Supplier();
        if (e.getSource() == insertButton) {
				sup.setFname(fnameTextField.getText());
				sup.setLname(lnameTextField.getText());
				sup.setProvince(provinceTextField.getText());
				sup.setDistrict(districtTextField.getText());
				sup.setSector(sectorTextField.getText());
				sup.setPhone(phoneTextField.getText());
				sup.setEmail(emailTextField.getText());
				sup.setAmountPaid(amountPaidTextField.getText());
				sup.insertData();
        
        }else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("supID");
        	model.addColumn("fname");
        	model.addColumn("lname");
        	model.addColumn("province");
        	model.addColumn("district");
        	model.addColumn("sector");
        	model.addColumn("phone");
        	model.addColumn("email");
        	model.addColumn("amount");
        	

            ResultSet resultSet = Supplier.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9) });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
            }else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(supIDTextField.getText());
        	sup.setFname(fnameTextField.getText());
        	sup.setLname(lnameTextField.getText());
        	sup.setProvince(provinceTextField.getText());
        	sup.setDistrict(districtTextField.getText());
        	sup.setSector(sectorTextField.getText());
        	sup.setPhone(phoneTextField.getText());
        	sup.setEmail(emailTextField.getText());
        	sup.setAmountPaid(amountPaidTextField.getText());
        	sup.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(supIDTextField.getText());
        	sup.delete(id);}

    }
    

    public static void main(String[] args) {
        SupplierForm form = new SupplierForm();
    }
}
