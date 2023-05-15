package com.masaischool.DTO;

public class BidderDTOimpl implements BidderDTO{

//	Bid_id int UNIQUE AUTO_INCREMENT,
//	  Vender_id varchar(15) NOT NULL,
//	  Tender_id varchar(15) NOT NULL,
//	  Bid_amount int(11) DEFAULT NULL,
//	  Status varchar(10) DEFAULT NULL,
	
//	private int Bid_id;
	private String Vender_id;
	private String Tender_id;
	private int Bid_amount;
	private String Status;
	
	
	public BidderDTOimpl(String vender_id, String tender_id, int bid_amount, String status) {
		super();
//		Bid_id = bid_id;
		Vender_id = vender_id;
		Tender_id = tender_id;
		Bid_amount = bid_amount;
		Status = status;
	}

//@Override
//	public int getBid_id() {
//		return Bid_id;
//	}
//
//@Override
//	public void setBid_id(int bid_id) {
//		Bid_id = bid_id;
//	}

@Override
	public String getVender_id() {
		return Vender_id;
	}

@Override
	public void setVender_id(String vender_id) {
		Vender_id = vender_id;
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
	public int getBid_amount() {
		return Bid_amount;
	}

@Override
	public void setBid_amount(int bid_amount) {
		Bid_amount = bid_amount;
	}

@Override
	public String getStatus() {
		return Status;
	}

@Override
	public void setStatus(String status) {
		Status = status;
	}

@Override
public String toString() {
	return " Vender_id : " + Vender_id + ", Tender_id : " + Tender_id + ", Bid_amount : "
			+ Bid_amount + ", Status : " + Status + "\n";
}



	
	
	
}
