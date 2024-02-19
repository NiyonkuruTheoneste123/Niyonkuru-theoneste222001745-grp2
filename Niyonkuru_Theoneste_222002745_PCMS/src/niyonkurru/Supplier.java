package niyonkurru;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Supplier {
	
    private int supID;
    private String fname;
    private String lname;
    private String province;
    private String district;
    private String sector;
    private String phone;
    private String email;
    private String amountPaid;
    
    public Supplier() {
    	
    }
	public Supplier(int supID, String fname, String lname, String province, String district, String sector,
			String phone, String email, String amountPaid) {
		
		this.supID = supID;
		this.fname = fname;
		this.lname = lname;
		this.province = province;
		this.district = district;
		this.sector = sector;
		this.phone = phone;
		this.email = email;
		this.amountPaid = amountPaid;
	}

	public int getSupID() {
		return supID;
	}

	public void setSupID(int supID) {
		this.supID = supID;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	    String sql = "INSERT INTO supplier (fname, Lname, Province, District, sector, phone, email,  amount_paid	) VALUES (?,?,?,?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	    	// Set the values for the prepared statement
	       preparedStatement.setString(1, this.fname);
	        preparedStatement.setString(2, this.lname);
	        preparedStatement.setString(3, this.province);
	        preparedStatement.setString(4, this.district);
	        preparedStatement.setString(5,this.sector);
	        preparedStatement.setString(6,this.phone);
	        preparedStatement.setString(7,this.email);
	        preparedStatement.setString(8,this.amountPaid);
	        
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

        String sql = "SELECT * FROM supplier";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void update(int inputsupID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE supplier SET fname=?, Lname=?, Province=?, District=?, sector=?, phone=?, email=?,  amount_paid=? WHERE SupID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	preparedStatement.setString(1, this.getFname());
	    	preparedStatement.setString(2, this.getLname());
	    	preparedStatement.setString(3, this.getProvince()); // Assuming there is a column named 'id' for the WHERE clause
	    	preparedStatement.setString(4, this.getDistrict());
	    	preparedStatement.setString(5, this.getSector());
	    	preparedStatement.setString(6, this.getPhone());
	    	preparedStatement.setString(7, this.getEmail());
	    	preparedStatement.setString(8, this.getAmountPaid());
	    	
	    	preparedStatement.setInt(9, inputsupID);
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
	public void delete(int inputid) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to delete data
	    String sql = "DELETE FROM supplier WHERE SupID = ?";

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
	            JOptionPane.showMessageDialog(null, "NO data inserted.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	}
