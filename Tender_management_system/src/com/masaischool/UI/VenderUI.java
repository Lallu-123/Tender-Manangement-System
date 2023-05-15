package com.masaischool.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.BidderDAO;
import com.masaischool.DAO.BidderDAOimpl;
import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.DTO.BidderDTO;
import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class VenderUI {

	static void ViewVendors() {
		
		List<VendorDTO> list = new ArrayList<>();
		VendorDAO ven = new VendorDAOimpl();
		try {
			list = ven.ViewVendors();
			System.out.println(list);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
static void ViewAllBidsofaTender(Scanner sc) {
	    List<BidderDTO> list = new ArrayList<>();
		System.out.println("Enter Tender_id whose bids will be displayed");
		String tender_id = sc.next();
		BidderDAO ven = new BidderDAOimpl();
        try {
        	list = ven.viewAllBidsofaTender(tender_id);
        	System.out.println(list);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

static void UpdateAccDetails(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
	VendorDAO ven = new VendorDAOimpl();
	System.out.println("Enter vender id whose credentials you want to update");
	String ven_id = sc.next();
	
	if(ven.VerifyVendercredentialsforUpdate(ven_id)) {
		System.out.println("Enter new vender name");
		String name = sc.next();
		System.out.println("Enter new vender password");
		String password = sc.next();
		
		try {
			ven.updatecredentials(name, password, ven_id);
		    System.out.println("Updated successfully");
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			System.out.println("Cannot update details");
			e.printStackTrace();
		}
	}else {
		System.out.println("Wrong vender id");
	}

}


static void viewbidhistory(Scanner sc) throws SomethingWentWrongException, NoRecordFoundException {
	BidderDAO ven = new BidderDAOimpl();
	System.out.println("Enter Vendor_id whose bids you want to view");
	String ven_id = sc.next();
	List<BidderDTO> list = new ArrayList<>();
	list = ven.viewAllBidsOfaVendor(ven_id);
	System.out.println(list);
}


}
