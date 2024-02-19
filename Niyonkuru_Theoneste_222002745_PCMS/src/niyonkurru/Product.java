package niyonkurru;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

public class Product {
	
    private int proID;
    private String rmID;
    private String pname;
    private String amount;
    private String price;
    private String mnfDate;
    private String expDate;
    
    public Product() {
	}
	public Product(int proID, String rmID, String pname, String amount, String price, String mnfDate, String expDate) {
	
		this.proID = proID;
		this.rmID = rmID;
		this.pname = pname;
		this.amount = amount;
		this.price = price;
		this.mnfDate = mnfDate;
		this.expDate = expDate;
	}

	public int getProID() {
		return proID;
	}

	public void setProID(int proID) {
		this.proID = proID;
	}

	public String getRmID() {
		return rmID;
	}

	public void setRmID(String rmID) {
		this.rmID = rmID;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMnfDate() {
		return mnfDate;
	}

	public void setMnfDate(String mnfDate) {
		this.mnfDate = mnfDate;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO product ( RmID, Pname ,Amount, Price, Mnfdate, Expdate) VALUES (?,?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement PRD = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	    	PRD.setString(1,this.rmID);
	    	PRD.setString(2,this.pname);
	    	PRD.setString(3,this.amount);
	    	PRD.setString(4,this.price);
	    	PRD.setString(5,this.mnfDate);
	    	PRD.setString(6,this.expDate);
	        
	        // Execute the query
	        int rowsAffected = PRD.executeUpdate();

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

	        String sql = "SELECT * FROM product";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	public void update(int inputProID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE product SET RmID=?, Pname=? ,Amount=?, Price=?, Mnfdate=?, Expdate=? WHERE ProID=?";

	    try (
	        // Establish the co
	        Connection cnct = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement PRD = cnct.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	        PRD.setString(1, this.getRmID());
	    	PRD.setString(2, this.getPname());
	    	PRD.setString(3, this.getAmount()); // Assuming there is a column named 'id' for the WHERE clause
	    	PRD.setString(4, this.getPrice());
	    	PRD.setString(5, this.getMnfDate());
	    	PRD.setString(6, this.getExpDate());
	    	
	    	PRD.setInt(7, inputProID);
	        // Execute the update
	        int rowsAffected = PRD.executeUpdate();

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
	    String sql = "DELETE FROM product WHERE ProID = ?";

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