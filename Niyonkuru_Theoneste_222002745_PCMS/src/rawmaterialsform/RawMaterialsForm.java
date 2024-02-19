package rawmaterialsform;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import niyonkurru.Employee;
import niyonkurru.Finance;
import niyonkurru.Rawmaterials;

public class RawMaterialsForm implements ActionListener {
    JFrame frame;
    JLabel rmIDLabel = new JLabel("Raw Material ID");
    JLabel rTypeLabel = new JLabel("Raw Material Type");
    JLabel rAmountLabel = new JLabel("Raw Material Amount");
    JLabel storedDateLabel = new JLabel("Stored Date");
    JLabel unstoreDateLabel = new JLabel("Unstore Date");
    JLabel supIDLabel = new JLabel("Supplier ID");

    JTextField rmIDTextField = new JTextField();
    JTextField rTypeTextField = new JTextField();
    JTextField rAmountTextField = new JTextField();
    JTextField storedDateTextField = new JTextField();
    JTextField unstoreDateTextField = new JTextField();
    JTextField supIDTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public RawMaterialsForm() {
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
        frame.setTitle("Raw Materials Form");
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

        rmIDLabel.setBounds(labelX, startY, labelWidth, 30);
        rTypeLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        rAmountLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        storedDateLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        unstoreDateLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        supIDLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
         
        supIDTextField.setBackground(Color.yellow);
        rmIDTextField.setBackground(Color.yellow);
        rTypeTextField.setBackground(Color.yellow);
        rAmountTextField.setBackground(Color.yellow);
        storedDateTextField.setBackground(Color.yellow);
        unstoreDateTextField.setBackground(Color.yellow);
        
        rmIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        rTypeTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        rAmountTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        storedDateTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        unstoreDateTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        supIDTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 380, 90, 30);
        viewButton.setBounds(labelX + 100, 380, 90, 30);
        updateButton.setBounds(labelX + 200, 380, 90, 30);
        deleteButton.setBounds(labelX + 300, 380, 90, 30);
        table.setBounds(400, 10, 900, 400);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        rmIDLabel.setFont(font);
        rTypeLabel.setFont(font);
        rAmountLabel.setFont(font);
        storedDateLabel.setFont(font);
        unstoreDateLabel.setFont(font);
        supIDLabel.setFont(font);

        rmIDTextField.setFont(font);
        rTypeTextField.setFont(font);
        rAmountTextField.setFont(font);
        storedDateTextField.setFont(font);
        unstoreDateTextField.setFont(font);
        supIDTextField.setFont(font);
        
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
        frame.add(rmIDLabel);
        frame.add(rTypeLabel);
        frame.add(rAmountLabel);
        frame.add(storedDateLabel);
        frame.add(unstoreDateLabel);
        frame.add(supIDLabel);

        frame.add(rmIDTextField);
        frame.add(rTypeTextField);
        frame.add(rAmountTextField);
        frame.add(storedDateTextField);
        frame.add(unstoreDateTextField);
        frame.add(supIDTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	Rawmaterials rm=new Rawmaterials();
        if (e.getSource() == insertButton) {
       
       rm.setrType(rTypeTextField.getText());
       rm.setrAmount(rAmountTextField.getText());
       rm.setStoredDate(storedDateTextField.getText());
       rm.setUnstoreDate(unstoreDateTextField.getText());
       rm.setSupID(supIDTextField.getText());
       rm.insertData();
       
        } else if (e.getSource() == viewButton) {
        	model.setColumnCount(0);
        	model.setRowCount(0);
        	model.addColumn("rmID");
        	model.addColumn("rType");
        	model.addColumn("rAmount");
        	model.addColumn("storedDate");
        	model.addColumn("unstoreDate");
        	model.addColumn("supID");
       
            ResultSet resultSet = Rawmaterials.viewData();
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
        	int id=Integer.parseInt(rmIDTextField.getText());
        	rm.setrType(rTypeTextField.getText());
        	rm.setrAmount(rAmountTextField.getText());
        	rm.setStoredDate(storedDateTextField.getText());
        	rm.setUnstoreDate(unstoreDateTextField.getText());
        	rm.setSupID(supIDTextField.getText());
        	rm.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(rmIDTextField.getText());
        	rm.delete(id);}
        	
        }
    

	public static void main(String[] args) {
        RawMaterialsForm form = new RawMaterialsForm();
    }
}
