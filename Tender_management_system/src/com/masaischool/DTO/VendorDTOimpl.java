package com.masaischool.DTO;

public class VendorDTOimpl implements VendorDTO{

	private String Vendor_id;
	private String Vendor_Name;
	private String Tendor_Alocated;
	private String Tender_id;
	private String password;
	
	public VendorDTOimpl(String vendor_id, String vendor_Name, String tendor_Alocated, String tender_id,String password) {
		super();
		Vendor_id = vendor_id;
		Vendor_Name = vendor_Name;
		Tendor_Alocated = tendor_Alocated;
		Tender_id = tender_id;
		password = password;
	}
	
	
	@Override
	public String getVendor_id() {
		return Vendor_id;
	}
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public void setVendor_id(String vendor_id) {
		Vendor_id = vendor_id;
	}
	@Override
	public String getVendor_Name() {
		return Vendor_Name;
	}
	@Override
	public void setVendor_Name(String vendor_Name) {
		Vendor_Name = vendor_Name;
	}
	@Override
	public String getTendor_Alocated() {
		return Tendor_Alocated;
	}
	@Override
	public void setTendor_Alocated(String tendor_Alocated) {
		Tendor_Alocated = tendor_Alocated;
	}
	@Override
	public String getTender_id() {
		return Tender_id;
	}
	@Override
	public void setTender_id(String tender_id) {
		Tender_id = tender_id;
	}


	@Override
	public String toString() {
		return "Vendor_id : " + Vendor_id + ", Vendor_Name : " + Vendor_Name + ", Tendor_Alocated : "
				+ Tendor_Alocated + ", Tender_id : " + Tender_id + "\n";
	}



	
	
	
	
	
}
