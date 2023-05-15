package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.BidderDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface BidderDAO {

	public List<BidderDTO> viewAllBidsofaTender(String tend_id)throws SomethingWentWrongException,NoRecordFoundException;
	public List<BidderDTO> viewAllBidsOfaVendor(String vendorId)throws SomethingWentWrongException,NoRecordFoundException;
	
}
