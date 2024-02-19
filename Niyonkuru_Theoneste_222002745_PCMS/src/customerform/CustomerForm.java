package customerform;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import niyonkurru.Customer;


public class CustomerForm implements ActionListener {
    JFrame frame;
    JLabel custIDLabel = new JLabel("Customer ID");
    JLabel proIDLabel = new JLabel("Product ID");
    JLabel cFnameLabel = new JLabel("Customer Fname");
    JLabel cLnameLabel = new JLabel("Customer Lname");
    JLabel cEmailLabel = new JLabel("Customer Email");
    JLabel cPhoneLabel = new JLabel("Customer Phone");
    JLabel amountPaidLabel = new JLabel("Customer amountPaid");
    

    JTextField custIDTextField = new JTextField();
    JTextField proIDTextField = new JTextField();
    JTextField cFnameTextField = new JTextField();
    JTextField cLnameTextField = new JTextField();
    JTextField cEmailTextField = new JTextField();
    JTextField cPhoneTextField = new JTextField();
    JTextField amountPaidTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton deleteButton = new JButton("Delete");
    JButton updateButton = new JButton("Update");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public CustomerForm() {
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
        frame.setTitle("Customer Form");
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

        custIDLabel.setBounds(labelX, startY, labelWidth, 30);
        proIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        cFnameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        cLnameLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        cEmailLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        cPhoneLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        amountPaidLabel.setBounds(labelX, startY + 6 * spacingY, labelWidth, 30);
        
        custIDTextField.setBackground(Color.yellow);
        proIDTextField.setBackground(Color.yellow);
        cFnameTextField.setBackground(Color.yellow);
        cLnameTextField.setBackground(Color.yellow);
        cEmailTextField.setBackground(Color.yellow);
        cPhoneTextField.setBackground(Color.yellow);
        amountPaidTextField.setBackground(Color.yellow);
        
        
        custIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        proIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        cFnameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        cLnameTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        cEmailTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        cPhoneTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);
        amountPaidTextField.setBounds(textFieldX, startY + 6 * spacingY, textFieldWidth, 30);
        
        
        insertButton.setBounds(labelX, 420, 90, 30);
        viewButton.setBounds(labelX + 100, 420, 90, 30);
        deleteButton.setBounds(labelX + 200, 420, 90, 30);
        updateButton.setBounds(labelX + 300, 420, 90, 30);
        table.setBounds(400, 10, 800, 390);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        custIDLabel.setFont(font);
        proIDLabel.setFont(font);
        cFnameLabel.setFont(font);
        cLnameLabel.setFont(font);
        cEmailLabel.setFont(font);
        cPhoneLabel.setFont(font);
        amountPaidLabel.setFont(font);
        
        custIDTextField.setFont(font);
        proIDTextField.setFont(font);
        cFnameTextField.setFont(font);
        cLnameTextField.setFont(font);
        cEmailTextField.setFont(font);
        cPhoneTextField.setFont(font);
        amountPaidTextField.setFont(font);

        insertButton.setBackground(Color.MAGENTA);
        viewButton.setBackground(Color.MAGENTA);
        updateButton.setBackground(Color.MAGENTA);
        deleteButton.setBackground(Color.MAGENTA);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(custIDLabel);
        frame.add(proIDLabel);
        frame.add(cFnameLabel);
        frame.add(cLnameLabel);
        frame.add(cEmailLabel);
        frame.add(cPhoneLabel);
        frame.add(amountPaidLabel);
        

        frame.add(custIDTextField);
        frame.add(proIDTextField);
        frame.add(cFnameTextField);
        frame.add(cLnameTextField);
        frame.add(cEmailTextField);
        frame.add(cPhoneTextField);
        frame.add(amountPaidTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Customer cst=new Customer();
        if (e.getSource() == insertButton) {
        	cst.setProID(proIDTextField.getText());
        	cst.setcFname(cFnameTextField.getText());
        	cst.setcLname(cLnameTextField.getText());
        	cst.setcEmail(cEmailTextField.getText());
        	cst.setcPhone(cPhoneTextField.getText());
        	cst.setAmountPaid(amountPaidTextField.getText());
        	cst.insertData();
       
        } else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("custID");
        	model.addColumn("proID");
        	model.addColumn("cFname");
        	model.addColumn("cLname");
        	model.addColumn("cEmail");
        	model.addColumn("cPhone");
        	model.addColumn("amountPaid");

            ResultSet resultSet = Customer.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)
                      });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
            }else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(custIDTextField.getText());
        	cst.setProID(proIDTextField.getText());
        	cst.setcFname(cFnameTextField.getText());
        	cst.setcLname(cLnameTextField.getText());
        	cst.setcEmail(cEmailTextField.getText());
        	cst.setcPhone(cPhoneTextField.getText());
        	cst.setAmountPaid(amountPaidTextField.getText());
        	cst.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(custIDTextField.getText());
			cst.Delete(id);}
        	
        }
    

    public static void main(String[] args) {
        CustomerForm form = new CustomerForm();
    }
}
