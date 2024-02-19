package marketform;


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

import financeform.FinanceForm;
import niyonkurru.Employee;
import niyonkurru.Finance;
import niyonkurru.Market;

public class MarketForm implements ActionListener {
    JFrame frame;
    JLabel markIDLabel = new JLabel("Market ID");
    JLabel empIDLabel = new JLabel("Employee ID");
    JLabel proIDLabel = new JLabel("Product ID");
    JLabel mProvinceLabel = new JLabel("Province");
    JLabel mDistrictLabel = new JLabel("District");
    JLabel mSectorLabel = new JLabel("Sector");
    JLabel supplyDateLabel = new JLabel("Supply Date");

    JTextField markIDTextField = new JTextField();
    JTextField empIDTextField = new JTextField();
    JTextField proIDTextField = new JTextField();
    JTextField mProvinceTextField = new JTextField();
    JTextField mDistrictTextField = new JTextField();
    JTextField mSectorTextField = new JTextField();
    JTextField supplyDateTextField = new JTextField();

    JButton insertButton = new JButton("Insert");
    JButton viewButton = new JButton("View");
    JButton updateButton = new JButton("Update");
    JButton deleteButton = new JButton("Delete");
    
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();

    public MarketForm() {
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
        frame.setTitle("Market Form");
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

        markIDLabel.setBounds(labelX, startY, labelWidth, 30);
        empIDLabel.setBounds(labelX, startY + spacingY, labelWidth, 30);
        proIDLabel.setBounds(labelX, startY + 2 * spacingY, labelWidth, 30);
        mProvinceLabel.setBounds(labelX, startY + 3 * spacingY, labelWidth, 30);
        mDistrictLabel.setBounds(labelX, startY + 4 * spacingY, labelWidth, 30);
        mSectorLabel.setBounds(labelX, startY + 5 * spacingY, labelWidth, 30);
        supplyDateLabel.setBounds(labelX, startY + 6 * spacingY, labelWidth, 30);

        proIDTextField.setBackground(Color.yellow);
        markIDTextField.setBackground(Color.yellow);
        empIDTextField.setBackground(Color.yellow);
        mProvinceTextField.setBackground(Color.yellow);
        mDistrictTextField.setBackground(Color.yellow);
        mSectorTextField.setBackground(Color.yellow);
        supplyDateTextField.setBackground(Color.yellow);
        
        
        markIDTextField.setBounds(textFieldX, startY, textFieldWidth, 30);
        empIDTextField.setBounds(textFieldX, startY + spacingY, textFieldWidth, 30);
        proIDTextField.setBounds(textFieldX, startY + 2 * spacingY, textFieldWidth, 30);
        mProvinceTextField.setBounds(textFieldX, startY + 3 * spacingY, textFieldWidth, 30);
        mDistrictTextField.setBounds(textFieldX, startY + 4 * spacingY, textFieldWidth, 30);
        mSectorTextField.setBounds(textFieldX, startY + 5 * spacingY, textFieldWidth, 30);
        supplyDateTextField.setBounds(textFieldX, startY + 6 * spacingY, textFieldWidth, 30);

        insertButton.setBounds(labelX, 450, 90, 30);
        viewButton.setBounds(labelX + 100, 450, 90, 30);
        updateButton.setBounds(labelX + 200, 450, 90, 30);
        deleteButton.setBounds(labelX + 300, 450, 90, 30);
        table.setBounds(400, 10, 900, 470);
    }

    private void setFontForAll() {
        Font font = new Font("Times New Roman", Font.BOLD, 14);

        markIDLabel.setFont(font);
        empIDLabel.setFont(font);
        proIDLabel.setFont(font);
        mProvinceLabel.setFont(font);
        mDistrictLabel.setFont(font);
        mSectorLabel.setFont(font);
        supplyDateLabel.setFont(font);

        markIDTextField.setFont(font);
        empIDTextField.setFont(font);
        proIDTextField.setFont(font);
        mProvinceTextField.setFont(font);
        mDistrictTextField.setFont(font);
        mSectorTextField.setFont(font);
        supplyDateTextField.setFont(font);

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
        frame.add(markIDLabel);
        frame.add(empIDLabel);
        frame.add(proIDLabel);
        frame.add(mProvinceLabel);
        frame.add(mDistrictLabel);
        frame.add(mSectorLabel);
        frame.add(supplyDateLabel);

        frame.add(markIDTextField);
        frame.add(empIDTextField);
        frame.add(proIDTextField);
        frame.add(mProvinceTextField);
        frame.add(mDistrictTextField);
        frame.add(mSectorTextField);
        frame.add(supplyDateTextField);

        frame.add(insertButton);
        frame.add(viewButton);
        frame.add(updateButton);
        frame.add(deleteButton);
        frame.add(table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Market mrk= new Market();
      if (e.getSource() == insertButton) {
       mrk.setEmpID(empIDTextField.getText());
       mrk.setProID(proIDTextField.getText());
       mrk.setmProvince(mProvinceTextField.getText());
       mrk.setmDistrict(mDistrictTextField.getText());
       mrk.setEmpID(mSectorTextField.getText());
       mrk.setEmpID(supplyDateTextField.getText());
       mrk.insertData();
       
        } 
      else if (e.getSource() == viewButton) {
      	model.setColumnCount(0);
      	model.setRowCount(0);
      	model.addColumn("markID");
      	model.addColumn("empID");
      	model.addColumn("proID");
      	model.addColumn("mProvince");
      	model.addColumn("mDistrict");
      	model.addColumn("mSector");
      	model.addColumn("supplyDate");
      	

          ResultSet resultSet = Market.viewData();
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
          }
     else if (e.getSource() == updateButton) {
        	int id=Integer.parseInt(markIDTextField.getText());
        	mrk.setEmpID(empIDTextField.getText());
        	mrk.setProID(proIDTextField.getText());
        	mrk.setmProvince(mProvinceTextField.getText());
        	mrk.setmDistrict(mDistrictTextField.getText());
        	mrk.setEmpID(mSectorTextField.getText());
        	mrk.setEmpID(supplyDateTextField.getText());
            mrk.update(id);
        	
        }else if (e.getSource() == deleteButton) {
        	int id=Integer.parseInt(markIDTextField.getText());
			mrk.delete(id);}
        	
        }
    public static void main(String[] args) {
    	MarketForm form = new MarketForm();
    }
}
