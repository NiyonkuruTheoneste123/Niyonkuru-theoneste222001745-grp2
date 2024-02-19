package Employee.forms;


import java.awt.Color;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import niyonkurru.Employee;



public class EmployeeForm implements ActionListener {
    JFrame frame;
    JLabel empIDLabel = new JLabel("Employee ID");
    JLabel fnameLabel = new JLabel("First Name");
    JLabel lnameLabel = new JLabel("Last Name");
    JLabel dobLabel = new JLabel("Date of Birth");
    JLabel emailLabel = new JLabel("Email");
    JLabel contactLabel = new JLabel("Contact");
    JLabel departmentLabel = new JLabel("Department");
    JLabel salaryLabel = new JLabel("Salary");
    JLabel contractLabel = new JLabel("Contract");

    JTextField empIDTextField = new JTextField();
    JTextField fnameTextField = new JTextField();
    JTextField lnameTextField = new JTextField();
    JTextField dobTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField contactTextField = new JTextField();
    JTextField departmentTextField = new JTextField();
    JTextField salaryTextField = new JTextField();
    JTextField contractTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public EmployeeForm() {
        createForm();
        addActionListeners();
        setLocationAndSize();
        setFontForAll();
        addComponentsToFrame();
    }

    private void addActionListeners() {
        insertButton.addActionListener(this);
        viewButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    private void createForm() {
        frame = new JFrame();
        frame.setTitle("Employee Form");
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
        
       
        empIDLabel.setBounds(labelX, startY, labelWidth, 30);
        fnameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        lnameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        dobLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        emailLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        contactLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        departmentLabel.setBounds(labelX, startY + 6 * spacingY, labelWidth, 30);
        salaryLabel.setBounds(labelX, startY + 7 * spacingY, labelWidth, 30);
        contractLabel.setBounds(labelX, startY + 8 * spacingY, labelWidth, 30);

        empIDTextField.setBackground(Color.yellow);
        fnameTextField.setBackground(Color.yellow);
        lnameTextField.setBackground(Color.yellow);
        dobTextField.setBackground(Color.yellow);
        emailTextField.setBackground(Color.yellow);
        contactTextField.setBackground(Color.yellow);
        departmentTextField.setBackground(Color.yellow);
        salaryTextField.setBackground(Color.yellow);
        contractTextField.setBackground(Color.yellow);
        
        empIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        fnameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        lnameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        dobTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        emailTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        contactTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);
        departmentTextField.setBounds(textFieldX, startY + 6 * spacingY, textFieldWidth, 30);
        salaryTextField.setBounds(textFieldX, startY + 7 * spacingY, textFieldWidth, 30);
        contractTextField.setBounds(textFieldX, startY + 8 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 550, 90, 30);
        viewButton.setBounds(labelX + 100, 550, 90, 30);
        updateButton.setBounds(labelX + 300, 550, 90, 30);
        deleteButton.setBounds(labelX + 200, 550, 90, 30);
        table.setBounds(400, 10, 900, 570);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        empIDLabel.setFont(font);
        fnameLabel.setFont(font);
        lnameLabel.setFont(font);
        dobLabel.setFont(font);
        emailLabel.setFont(font);
        contactLabel.setFont(font);
        departmentLabel.setFont(font);
        salaryLabel.setFont(font);
        contractLabel.setFont(font);

        empIDTextField.setFont(font);
        fnameTextField.setFont(font);
        lnameTextField.setFont(font);
        dobTextField.setFont(font);
        emailTextField.setFont(font);
        contactTextField.setFont(font);
        departmentTextField.setFont(font);
        salaryTextField.setFont(font);
        contractTextField.setFont(font);

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
        frame.add(empIDLabel);
        frame.add(fnameLabel);
        frame.add(lnameLabel);
        frame.add(dobLabel);
        frame.add(emailLabel);
        frame.add(contactLabel);
        frame.add(departmentLabel);
        frame.add(salaryLabel);
        frame.add(contractLabel);

        frame.add(empIDTextField);
        frame.add(fnameTextField);
        frame.add(lnameTextField);
        frame.add(dobTextField);
        frame.add(emailTextField);
        frame.add(contactTextField);
        frame.add(departmentTextField);
        frame.add(salaryTextField);
        frame.add(contractTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Employee emp=new Employee();
        if (e.getSource() == insertButton) {
        	   
				emp.setFname(fnameTextField.getText());
    			emp.setLname(lnameTextField.getText());
    			emp.setDob(dobTextField.getText());
    			emp.setEmail(emailTextField.getText());
    			emp.setContact(contactTextField.getText());
    			emp.setDepartment(departmentTextField.getText());
    			emp.setSalary(salaryTextField.getText());
    			emp.setContract(contractTextField.getText());
    			emp.insertData();
        
        }  else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("empID");
        	model.addColumn("fname");
        	model.addColumn("lname");
        	model.addColumn("dob");
        	model.addColumn("email");
        	model.addColumn("contact");
        	model.addColumn("department");
        	model.addColumn("salary");
        	model.addColumn("contract");

            ResultSet resultSet = Employee.viewData();
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
        	int id=Integer.parseInt(empIDTextField.getText());
        	emp.setFname(fnameTextField.getText());
        	emp.setLname(lnameTextField.getText());
        	emp.setDob(dobTextField.getText());
        	emp.setEmail(emailTextField.getText());
        	emp.setContact(contactTextField.getText());
        	emp.setDepartment(departmentTextField.getText());
        	emp.setSalary(salaryTextField.getText());
        	emp.setContract(contractTextField.getText());
        	emp.update(id);
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(empIDTextField.getText());
			emp.delete(id);}

    }
    

    public static void main(String[] args) {
        EmployeeForm ef = new EmployeeForm();
        System.out.println(ef);
    }
}
