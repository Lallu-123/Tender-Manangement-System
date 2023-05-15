package com.masaischool.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masaischool.DAO.TenderDAO;
import com.masaischool.DAO.TenderDAOimpl;
import com.masaischool.DAO.VendorDAO;
import com.masaischool.DAO.VendorDAOimpl;
import com.masaischool.DTO.TenderDTO;
import com.masaischool.DTO.TenderDTOimpl;
import com.masaischool.DTO.VendorDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class TenderUI {

	static void CreateTender(Scanner sc) {
		
		System.out.print("Enter Tender id ");
		String tend_id = sc.next();
		System.out.print("Enter Tender Name ");
		String tend_name = sc.next();
		
		TenderDTO ted = new TenderDTOimpl(tend_id,tend_name);
		
		TenderDAO tedy = new TenderDAOimpl();
		try {
			tedy.addTender(ted);
			System.out.println("Tender added successfully");
		} catch (SomethingWentWrongException e) {
			System.out.println(e);
		}
	}
	
	static void ViewTenders() {
		
		List<TenderDTO> list = new ArrayList<>();
		TenderDAO ven = new TenderDAOimpl();
		try {
			list = ven.ViewTenders();
			System.out.println(list);
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
	
	static void ViewtenderByid(Scanner sc) {
		
		System.out.println("Enter Tender_id which you want to view");
		String tend_id = sc.next();
		
		TenderDAO ten = new TenderDAOimpl();
		List<TenderDTO> list = new ArrayList<>(); 
		try {
			try {
				list = ten.ViewTenderByTenderId(tend_id);
				System.out.println(list);
			} catch (NoRecordFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	static void AssignTenditoVendi(Scanner sc) throws SomethingWentWrongException {
		TenderDAO ten = new TenderDAOimpl();
		System.out.println("Enter tender name which you want to assign");
		String tendi_name = sc.next();
		System.out.println("Enter vender_id of vender whom you want to assign the tender");
		String ven_id = sc.next();
		int count = 0;
		
		try {
			if(ten.VerifyTenderName(tendi_name)) {
				count++;
			}else {
				System.out.println("This tender name doesn't exists");
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("This tender name doesn't exists");
		}
		
		try {
			if(ten.VerifyVenderid(ven_id)) {
				count++;
			}
			else {
				System.out.println("This vender_id doesn't exists");
			}
		} catch (SomethingWentWrongException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (NoRecordFoundException e) {
			System.out.println("This vender_id doesn't exists");
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
		if(count == 2) {
			
			ten.AssignTendertoVender(tendi_name, ven_id);
		    System.out.println("Tender Assigned Successfully");
		}
		
	}
	
}
