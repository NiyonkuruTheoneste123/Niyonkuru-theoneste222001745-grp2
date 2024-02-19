package niyonkurru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Property {
	
    private int propID;
    private String empID;
    private String pname;
    private String province;
    private String district;
    private String sector;
    
    public Property() { 
    	
    }
    public Property(int propID, String empID, String pname, String province, String district, String sector) {
		super();
		this.propID = propID;
		this.empID = empID;
		this.pname = pname;
		this.province = province;
		this.district = district;
		this.sector = sector;
	}
    
	public int getPropID() {
		return propID;
	}

	public void setPropID(int propID) {
		this.propID = propID;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
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

	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO property ( EmpID, Pname, Province, District, Sector	) VALUES (?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement preparedStatement = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	       preparedStatement.setString(1, this.empID);
	        preparedStatement.setString(2, this.pname);
	        preparedStatement.setString(3, this.province);
	        preparedStatement.setString(4, this.district);
	        preparedStatement.setString(5,this.sector);
	        
	        // Execute the query
	        int rowsAffected = preparedStatement.executeUpdate();

	        // Check the result
	    if (rowsAffected > 0) {
	        	System.out.println("Data insert  successfully!");
	            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to insert data.");
	            JOptionPane.showMessageDialog(null, "NO data inserted.!","After insert", JOptionPane.ERROR_MESSAGE);

	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); }
	    
	}

	public static ResultSet viewData() {
        String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM property";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void update(int inputPropID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE  property SET  EmpID=?, Pname=?, Province=?, District=?, Sector=? WHERE PropID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	preparedStatement.setString(1, this.getEmpID());
	    	preparedStatement.setString(2, this.getPname());
	    	preparedStatement.setString(3, this.getProvince()); // Assuming there is a column named 'id' for the WHERE clause
	    	preparedStatement.setString(4, this.getDistrict());
	    	preparedStatement.setString(5, this.getSector());
	    	
	    	preparedStatement.setInt(6, inputPropID);
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
	    String sql = "DELETE FROM  property WHERE PropID = ?";

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
