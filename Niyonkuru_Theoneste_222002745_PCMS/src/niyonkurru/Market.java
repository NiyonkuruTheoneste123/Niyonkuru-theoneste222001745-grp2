package niyonkurru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;

public class Market {
	
    private int markID;
    private String empID;
    private String proID;
    private String mProvince;
    private String mDistrict;
    private String mSector;
    private String supplyDate;
   
    public Market(int markID, String empID, String proID, String mProvince, String mDistrict, String mSector,
    		String supplyDate) {
		
		this.markID = markID;
		this.empID = empID;
		this.proID = proID;
		this.mProvince = mProvince;
		this.mDistrict = mDistrict;
		this.mSector = mSector;
		this.supplyDate = supplyDate;
	}

    
public Market() {
		// TODO Auto-generated constructor stub
	}


public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getProID() {
		return proID;
	}

	public void setProID(String proID) {
		this.proID = proID;
	}

	public String getmProvince() {
		return mProvince;
	}

	public void setmProvince(String mProvince) {
		this.mProvince = mProvince;
	}

	public String getmDistrict() {
		return mDistrict;
	}

	public void setmDistrict(String mDistrict) {
		this.mDistrict = mDistrict;
	}

	public String getmSector() {
		return mSector;
	}

	public void setmSector(String mSector) {
		this.mSector = mSector;
	}

	public String getSupplyDate() {
		return supplyDate;
	}

	public void setSupplyDate(String supplyDate) {
		this.supplyDate = supplyDate;
	}

	public void makeconnection() {
	}
	public void insertData() {
		// JDBC URL, username, and password of MySQL server
	    String host = "jdbc:mysql://localhost/niyonkuru_theoneste_productioncompanymanagementsystem";
	    String user = "root";
	    String password = "";

	    // SQL query to insert data
	    String sql = "INSERT INTO market (EmpID, ProID, Mprovince ,Mdistrict, Msector, supplydate) VALUES (?,?,?,?,?,?)";
	    try (
	        // Establish the connection
	        Connection con = DriverManager.getConnection(host, user, password);

	        // Create a prepared statement
	    		   PreparedStatement mrk = con.prepareStatement(sql);
	    	    ) {
	        // Set the values for the prepared statement
	    	mrk.setString(1,this.empID);
	    	mrk.setString(2,this.proID);
	    	mrk.setString(3,this.mProvince);
	    	mrk.setString(4,this.mDistrict);
	    	mrk.setString(5,this.mSector);
	    	mrk.setString(6,this.supplyDate);
	        
	        
	        // Execute the query
	        int rowsAffected = mrk.executeUpdate();

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

        String sql = "SELECT * FROM  market";

        try {
            Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	public void update(int inputmarkID) {
		// JDBC URL, username, and password of MySQL server
	    String url = "jdbc:mysql://localhost/productioncompdatabase";
	    String user = "root";
	    String password = "";

	    // SQL query to update data
	    String sql = "UPDATE market SET  EmpID=?, ProID=?, Mprovince=? ,Mdistrict=?, Msector=?, supplydate=? WHERE MarkID=?";

	    try (
	        // Establish the co
	        Connection con = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement mrk = con.prepareStatement(sql);
	    ) {
	        // Set the new values for the update
	    	mrk.setString(1, this.getEmpID());
	    	mrk.setString(2, this.getProID());
	    	mrk.setString(3, this.getmProvince()); // Assuming there is a column named 'id' for the WHERE clause
	    	mrk.setString(4, this.getmDistrict());
	    	mrk.setString(5, this.getmSector());
	    	mrk.setString(5, this.getSupplyDate());
	    	mrk.setInt (6, inputmarkID );
	        // Execute the update
	        int rowsAffected = mrk.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "no data to be updated.!","After insert",JOptionPane.INFORMATION_MESSAGE);
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
	    String sql = "DELETE FROM market WHERE MarkID = ?";

	    try (
	        // Establish the 
	        Connection co = DriverManager.getConnection(url, user, password);

	        // Create a prepared statement
	        PreparedStatement mrk = co.prepareStatement(sql);
	    ) {
	        // Set the value for the WHERE clause
	        mrk.setInt(1, inputid); // Assuming there is a column named 'id' for the WHERE clause
             
	        // Execute the delete
	        int rowsAffected = mrk.executeUpdate();

	        // Check the result
	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data. No matching record found.");
	            JOptionPane.showMessageDialog(null, "please insert value first.!","After insert",JOptionPane.INFORMATION_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	}


