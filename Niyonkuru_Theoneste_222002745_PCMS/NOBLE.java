package niyonkurru;

import java.math.BigDecimal;

public class Supplier {
	
    private int supID;
    private String fname;
    private String lname;
    private String province;
    private String district;
    private String sector;
    private String phone;
    private String email;
    private BigDecimal amountPaid;
    
	public Supplier(int supID, String fname, String lname, String province, String district, String sector,
			String phone, String email, BigDecimal amountPaid) {
		super();
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

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	
}
