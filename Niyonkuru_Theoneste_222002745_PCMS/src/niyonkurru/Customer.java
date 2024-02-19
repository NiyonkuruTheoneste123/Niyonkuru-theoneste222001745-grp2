package niyonkurru;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Customer {
    private int custID;
    private String proID;
    private String cFname;
    private String cLname;
    private String cEmail;
    private String cPhone;
    private String amountPaid;
   
    
    
	public Customer() {
		
	}

	public Customer(int custID, String proID, String cFname, String cLname, String cEmail, String cPhone,
			String amountPaid) {
		super();
		this.custID = custID;
		this.proID = proID;
		this.cFname = cFname;
		this.cLname = cLname;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.amountPaid = amountPaid;
	}

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getcFname() {
		return cFname;
	}

	public void setcFname(String cFname) {
		this.cFname = cFname;
	}

	public String getcLname() {
		return cLname;
	}

	public void setcLname(String cLname) {
		this.cLname = cLname;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
    
	
	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO customer (ProID, CFname, CLname, CEmail, Cphone, Amountpaid	) VALUES (?,?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	     // Set the values for the prepared statement
	       preparedStatement.setString(1, this.proID);
	        preparedStatement.setString(2, this.cFname);
	        preparedStatement.setString(3, this.cLname);
	        preparedStatement.setString(4, this.cEmail);
	        preparedStatement.setString(5,this.cPhone);
	        preparedStatement.setString(6,this.amountPaid);
	       
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

        String sql = "SELECT * FROM customer";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void update(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE customer SET ProID=?, CFname=?, CLname=?, CEmail=?, Cphone=?, Amountpaid=? WHERE CustID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	    ) {
	    	
	        // Set the new values for the update
	    	preparedStatement.setString(1, this.getProID());
	    	preparedStatement.setString(2, this.getcFname());
	    	preparedStatement.setString(3, this.getcLname()); // Assuming there is a column named 'id' for the WHERE clause
	    	preparedStatement.setString(4, this.getcEmail());
	    	preparedStatement.setString(5, this.getcPhone());
	    	preparedStatement.setString(6, this.getAmountPaid());
	    	
	    	preparedStatement.setInt(7, inputid);
	        // Execute the update
	        int rowsAffected = preparedStatement.executeUpdate();

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
	public void Delete(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM customer WHERE CustID = ?";

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

	

    // Constructor, getters, setters, etc.
}
