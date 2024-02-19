package propertiesform;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import niyonkurru.Employee;
import niyonkurru.Property;

public class PropertiesForm implements ActionListener {
    JFrame frame;
    JLabel propIDLabel = new JLabel("Property ID");
    JLabel empIDLabel = new JLabel("Employee ID");
    JLabel pnameLabel = new JLabel("Property Name");
    JLabel provinceLabel = new JLabel("Province");
    JLabel districtLabel = new JLabel("District");
    JLabel sectorLabel = new JLabel("Sector");

    JTextField propIDTextField = new JTextField();
    JTextField empIDTextField = new JTextField();
    JTextField pnameTextField = new JTextField();
    JTextField provinceTextField = new JTextField();
    JTextField districtTextField = new JTextField();
    JTextField sectorTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public PropertiesForm() {
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
        frame.setTitle("Properties Form");
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

        propIDLabel.setBounds(labelX, startY, labelWidth, 30);
        empIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        pnameLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        provinceLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        districtLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        sectorLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        
        propIDTextField.setBackground(Color.yellow);
        empIDTextField.setBackground(Color.yellow);
        pnameTextField.setBackground(Color.yellow);
        provinceTextField.setBackground(Color.yellow);
        districtTextField.setBackground(Color.yellow);
        sectorTextField.setBackground(Color.yellow);

        propIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        empIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        pnameTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        provinceTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        districtTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        sectorTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 400, 90, 30);
        viewButton.setBounds(labelX + 100, 400, 90, 30);
        updateButton.setBounds(labelX + 200, 400, 90, 30);
        deleteButton.setBounds(labelX + 300, 400, 90, 30);
        table.setBounds(400, 10, 900, 420);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        propIDLabel.setFont(font);
        empIDLabel.setFont(font);
        pnameLabel.setFont(font);
        provinceLabel.setFont(font);
        districtLabel.setFont(font);
        sectorLabel.setFont(font);

        propIDTextField.setFont(font);
        empIDTextField.setFont(font);
        pnameTextField.setFont(font);
        provinceTextField.setFont(font);
        districtTextField.setFont(font);
        sectorTextField.setFont(font);

        insertButton.setBackground(Color.MAGENTA);
        viewButton.setBackground(Color.MAGENTA);
        updateButton.setBackground(Color.MAGENTA);
        deleteButton.setBackground(Color.MAGENTA);
        
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        insertButton.setFont(buttonFont);
        viewButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
    }

    private void addComponentsToFrame() {
        frame.add(propIDLabel);
        frame.add(empIDLabel);
        frame.add(pnameLabel);
        frame.add(provinceLabel);
        frame.add(districtLabel);
        frame.add(sectorLabel);

        frame.add(propIDTextField);
        frame.add(empIDTextField);
        frame.add(pnameTextField);
        frame.add(provinceTextField);
        frame.add(districtTextField);
        frame.add(sectorTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Property prp=new Property();
        if (e.getSource() == insertButton) {
        	prp.setEmpID(empIDTextField.getText());
        	prp.setPname(pnameTextField.getText());
        	prp.setProvince(provinceTextField.getText());
        	prp.setDistrict(districtTextField.getText());
        	prp.setSector(sectorTextField.getText());
        	prp.insertData();
        
        }else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("prop");
        	model.addColumn("empID");
        	model.addColumn("pname");
        	model.addColumn("province");
        	model.addColumn("district");
        	model.addColumn("sector");
        	
            ResultSet resultSet = Property.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4), resultSet.getString(5),
                                resultSet.getString(6)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }}
            }else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(propIDTextField.getText());
            prp.setEmpID(empIDTextField.getText());
        	prp.setPname(pnameTextField.getText());
        	prp.setProvince(provinceTextField.getText());
        	prp.setDistrict(districtTextField.getText());
        	prp.setSector(sectorTextField.getText());
        	prp.update(id);
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(propIDTextField.getText());
        	prp.delete(id);}

    }
    
    public static void main(String[] args) {
        PropertiesForm form = new PropertiesForm();
    }
}
