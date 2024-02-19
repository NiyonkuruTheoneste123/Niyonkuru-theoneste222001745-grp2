package niyonkurru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Finance {
    private int finID;
    private String branchName;
    private String assetValue;
    private String salaryAmount;
    private String amountPerYear;
    private String empID;
    
    public Finance() {
    	
    }
	public Finance(int finID, String branchName,String assetValue,String salaryAmount,String amountPerYear,String empID) {
		this.finID = finID;
		this.branchName = branchName;
		this.assetValue = assetValue;
		this.salaryAmount = salaryAmount;
		this.amountPerYear = amountPerYear;
		this.empID = empID;
	}

	public int getFinID() {
		return finID;
	}

	public void setFinID(int finID) {
		this.finID = finID;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAssetValue() {
		return assetValue;
	}

	public void setAssetValue(String assetValue) {
		this.assetValue = assetValue;
	}

	public String getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(String salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getAmountPerYear() {
		return amountPerYear;
	}

	public void setAmountPerYear(String amountPerYear) {
		this.amountPerYear = amountPerYear;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}
	
	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO finance ( branch_name,asset_value,salary_amount,amount_per_year,EmpID) VALUES (?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.branchName);
	        preparedStatement.setString(2, this.assetValue);
	        preparedStatement.setString(3, this.salaryAmount);
	        preparedStatement.setString(4, this.amountPerYear);
	        preparedStatement.setString(5,this.empID);
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	    if (rowsAffected > 0) {
	        	System.out.println("Data insert  successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); }
	    
	}

	public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM finance";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void update(int inputfinID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE finance SET  branch_name=?, asset_value=?, salary_amount=?, amount_per_year=?, EmpID=? WHERE FinID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pst = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	pst.setString(1, this.getBranchName());
	    	pst.setString(2, this.getAssetValue());
	    	pst.setString(3, this.getSalaryAmount()); // Assuming there is a column named 'id' for the WHERE clause
	    	pst.setString(4, this.getAmountPerYear());
	    	pst.setString(5, this.getEmpID());
	    	pst.setInt (6, inputfinID );
	        // Execute the update
	        int rowsAffected = pst.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }   
	}
	public void delete(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM finance WHERE FinID = ?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pl = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        pl.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause
             
	        // Execute the delete
	        int rowsAffected = pl.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	}


 

