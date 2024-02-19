package niyonkurru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Rawmaterials {
	
    private int rmID;
    private String rType;
    private String rAmount;
    private String storedDate;
    private String unstoreDate;
    private String supID;
    
    public Rawmaterials() {
    }
    
    public Rawmaterials(int rmID, String rType, String rAmount, String storedDate, String unstoreDate, String supID) {
		super();
		this.rmID = rmID;
		this.rType = rType;
		this.rAmount = rAmount;
		this.storedDate = storedDate;
		this.unstoreDate = unstoreDate;
		this.supID = supID;
	}

    public int getRmID() {
		return rmID;
	}

	public void setRmID(int rmID) {
		this.rmID = rmID;
	}

	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	public String getrAmount() {
		return rAmount;
	}

	public void setrAmount(String rAmount) {
		this.rAmount = rAmount;
	}

	public String getStoredDate() {
		return storedDate;
	}

	public void setStoredDate(String storedDate) {
		this.storedDate = storedDate;
	}

	public String getUnstoreDate() {
		return unstoreDate;
	}

	public void setUnstoreDate(String unstoreDate) {
		this.unstoreDate = unstoreDate;
	}

	public String getSupID() {
		return supID;
	}

	public void setSupID(String supID) {
		this.supID = supID;
	}
	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO raw_material (Rtype, Ramount, stored_date, unstore_date, SupID	) VALUES (?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.rType);
	        preparedStatement.setString(2, this.rAmount);
	        preparedStatement.setString(3, this.storedDate);
	        preparedStatement.setString(4, this.unstoreDate);
	        preparedStatement.setString(5,this.supID);
	        
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

	        String sql = "SELECT * FROM raw_material";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputRmID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE raw_material SET  Rtype=?, Ramount=?, stored_date=?, unstore_date=?, SupID=? WHERE RmID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement pst = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	pst.setString(1, this.getrType());
	    	pst.setString(2, this.getrAmount());
	    	pst.setString(3, this.getStoredDate()); // Assuming there is a column named 'id' for the WHERE clause
	    	pst.setString(4, this.getUnstoreDate());
	    	pst.setString(5, this.getSupID());
	    	pst.setInt (6, inputRmID );
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
	    String sql = "DELETE FROM raw_material WHERE RmID = ?";

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
