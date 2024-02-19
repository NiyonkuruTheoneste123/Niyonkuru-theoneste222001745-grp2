package financeform;

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


import niyonkurru.Finance;

public class FinanceForm implements ActionListener {
    JFrame frame;
    JLabel finIDLabel = new JLabel("Finance ID");
    JLabel branchNameLabel = new JLabel("Branch Name");
    JLabel assetValueLabel = new JLabel("Asset Value");
    JLabel salaryAmountLabel = new JLabel("Salary Amount");
    JLabel amountPerYearLabel = new JLabel("Amount Per Year");
    JLabel empIDLabel = new JLabel("Employee ID");

    JTextField finIDTextField = new JTextField();
    JTextField branchNameTextField = new JTextField();
    JTextField assetValueTextField = new JTextField();
    JTextField salaryAmountTextField = new JTextField();
    JTextField amountPerYearTextField = new JTextField();
    JTextField empIDTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton deleteButton = new JButton("Delete");
    JButton updateButton = new JButton("Update");

    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public FinanceForm() {
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
        frame.setTitle("Finance Form");
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

        finIDLabel.setBounds(labelX, startY, labelWidth, 30);
        branchNameLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        assetValueLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        salaryAmountLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        amountPerYearLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        empIDLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);

        finIDTextField.setBackground(Color.yellow);
        branchNameTextField.setBackground(Color.yellow);
        empIDTextField.setBackground(Color.yellow);
        assetValueTextField.setBackground(Color.yellow);
        salaryAmountTextField.setBackground(Color.yellow);
        amountPerYearTextField.setBackground(Color.yellow);
        
        
        
        finIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        branchNameTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        assetValueTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        salaryAmountTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        amountPerYearTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        empIDTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 370, 90, 30);
        viewButton.setBounds(labelX + 100, 370, 90, 30);
        deleteButton.setBounds(labelX + 200, 370, 90, 30);
        updateButton.setBounds(labelX + 300, 370, 90, 30);
        table.setBounds(400, 10, 800, 390);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        finIDLabel.setFont(font);
        branchNameLabel.setFont(font);
        assetValueLabel.setFont(font);
        salaryAmountLabel.setFont(font);
        amountPerYearLabel.setFont(font);
        empIDLabel.setFont(font);

        finIDTextField.setFont(font);
        branchNameTextField.setFont(font);
        assetValueTextField.setFont(font);
        salaryAmountTextField.setFont(font);
        amountPerYearTextField.setFont(font);
        empIDTextField.setFont(font);

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
        frame.add(finIDLabel);
        frame.add(branchNameLabel);
        frame.add(assetValueLabel);
        frame.add(salaryAmountLabel);
        frame.add(amountPerYearLabel);
        frame.add(empIDLabel);

        frame.add(finIDTextField);
        frame.add(branchNameTextField);
        frame.add(assetValueTextField);
        frame.add(salaryAmountTextField);
        frame.add(amountPerYearTextField);
        frame.add(empIDTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(deleteButton);
        frame.add(updateButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Finance fin=new Finance();
        if (e.getSource() == insertButton) {
       fin.setBranchName(branchNameTextField.getText());
       fin.setAssetValue(assetValueTextField.getText());
       fin.setSalaryAmount(salaryAmountTextField.getText());
       fin.setAmountPerYear(amountPerYearTextField.getText());
       fin.setEmpID(empIDTextField.getText());
       fin.insertData();
       
        } else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("finID");
        	model.addColumn("branchName");
        	model.addColumn("assetValue");
        	model.addColumn("salaryAmount");
        	model.addColumn("amountPerYear");
        	model.addColumn("empID");

            ResultSet resultSet = Finance.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),resultSet.getString(6)
                      });
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
            }else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(finIDTextField.getText());
        	fin.setBranchName(branchNameTextField.getText());
        	fin.setAssetValue(assetValueTextField.getText());
        	fin.setSalaryAmount(salaryAmountTextField.getText());
        	fin.setAmountPerYear(amountPerYearTextField.getText());
        	fin.setEmpID(empIDTextField.getText());
            fin.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(finIDTextField.getText());
			fin.delete(id);}
        	
        }
    

    public static void main(String[] args) {
        FinanceForm form = new FinanceForm();
    }
}
