package productform;


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
import niyonkurru.Finance;
import niyonkurru.Product;

public class ProductForm implements ActionListener {
    JFrame frame;
    JLabel proIDLabel = new JLabel("Product ID");
    JLabel rmIDLabel = new JLabel("Raw Material ID");
    JLabel pnameLabel = new JLabel("Product Name");
    JLabel amountLabel = new JLabel("Amount");
    JLabel priceLabel = new JLabel("Price");
    JLabel mnfDateLabel = new JLabel("Manufacturing Date");
    JLabel expDateLabel = new JLabel("Expiry Date");

    JTextField proIDTextField = new JTextField();
    JTextField rmIDTextField = new JTextField();
    JTextField pnameTextField = new JTextField();
    JTextField amountTextField = new JTextField();
    JTextField priceTextField = new JTextField();
    JTextField mnfDateTextField = new JTextField();
    JTextField expDateTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public ProductForm() {
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
        frame.setTitle("Product Form");
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

        proIDLabel.setBounds(labelX, startY, labelWidth, 30);
        rmIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        pnameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        amountLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        priceLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        mnfDateLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        expDateLabel.setBounds(labelX, startY + 6 * spacingY, labelWidth, 30);

        proIDTextField.setBackground(Color.yellow);
        rmIDTextField.setBackground(Color.yellow);
        pnameTextField.setBackground(Color.yellow);
        amountTextField.setBackground(Color.yellow);
        priceTextField.setBackground(Color.yellow);
        mnfDateTextField.setBackground(Color.yellow);
        expDateTextField.setBackground(Color.yellow);
        
        proIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        rmIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        pnameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        amountTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        priceTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        mnfDateTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);
        expDateTextField.setBounds(textFieldX, startY + 6 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 450, 90, 30);
        viewButton.setBounds(labelX + 100, 450, 90, 30);
        updateButton.setBounds(labelX + 200, 450, 90, 30);
        deleteButton.setBounds(labelX + 300, 450, 90, 30);
        table.setBounds(400, 10, 900, 470);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        proIDLabel.setFont(font);
        rmIDLabel.setFont(font);
        pnameLabel.setFont(font);
        amountLabel.setFont(font);
        priceLabel.setFont(font);
        mnfDateLabel.setFont(font);
        expDateLabel.setFont(font);

        proIDTextField.setFont(font);
        rmIDTextField.setFont(font);
        pnameTextField.setFont(font);
        amountTextField.setFont(font);
        priceTextField.setFont(font);
        mnfDateTextField.setFont(font);
        expDateTextField.setFont(font);

        insertButton.setBackground(Color.MAGENTA);
        viewButton.setBackground(Color.MAGENTA);
        updateButton.setBackground(Color.MAGENTA);
        deleteButton.setBackground(Color.MAGENTA);
        
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(proIDLabel);
        frame.add(rmIDLabel);
        frame.add(pnameLabel);
        frame.add(amountLabel);
        frame.add(priceLabel);
        frame.add(mnfDateLabel);
        frame.add(expDateLabel);

        frame.add(proIDTextField);
        frame.add(rmIDTextField);
        frame.add(pnameTextField);
        frame.add(amountTextField);
        frame.add(priceTextField);
        frame.add(mnfDateTextField);
        frame.add(expDateTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	Product pro=new Product();
        if (e.getSource() == insertButton) {
       pro.setRmID(rmIDTextField.getText());
       pro.setPname(pnameTextField.getText());
       pro.setAmount(amountTextField.getText());
       pro.setPrice(priceTextField.getText());
       pro.setMnfDate(mnfDateTextField.getText());
       pro.setExpDate(expDateTextField.getText());
       pro.insertData();
       
        } else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("proID");
        	model.addColumn("rmID");
        	model.addColumn("pname");
        	model.addColumn("amount");
        	model.addColumn("price");
        	model.addColumn("mnfDate");
        	model.addColumn("expDate");

            ResultSet resultSet = Product.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6), resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
            }else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(proIDTextField.getText());
        	pro.setRmID(rmIDTextField.getText());
        	pro.setPname(pnameTextField.getText());
        	pro.setAmount(amountTextField.getText());
        	pro.setPrice(priceTextField.getText());
        	pro.setMnfDate(mnfDateTextField.getText());
        	pro.setExpDate(expDateTextField.getText());
        	pro.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(proIDTextField.getText());
        	pro.delete(id);}
        	
        }
    
    public static void main(String[] args) {
        ProductForm form = new ProductForm();
    }
}
