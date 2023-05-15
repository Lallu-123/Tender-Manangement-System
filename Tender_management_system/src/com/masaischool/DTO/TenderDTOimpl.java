package com.masaischool.DTO;

public class TenderDTOimpl implements TenderDTO{

	private String Tender_id;
	private String Tender_Name;
	
	public TenderDTOimpl(String tender_id, String tender_Name) {
		super();
		Tender_id = tender_id;
		Tender_Name = tender_Name;
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
	public String getTender_Name() {
		return Tender_Name;
	}
	@Override
	public void setTender_Name(String tender_Name) {
		Tender_Name = tender_Name;
	}
	
	@Override
	public String toString() {
		return "Tender_id : " + Tender_id + ", Tender_Name : " + Tender_Name + "\n";
	}
	
	
	
}
