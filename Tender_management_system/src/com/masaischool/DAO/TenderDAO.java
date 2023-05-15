package com.masaischool.DAO;

import java.util.List;

import com.masaischool.DTO.TenderDTO;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public interface TenderDAO {

	public void addTender(TenderDTO tenddto)throws SomethingWentWrongException;
	public List<TenderDTO> ViewTenders()throws SomethingWentWrongException,NoRecordFoundException;
	public List<TenderDTO> ViewTenderByTenderId(String tend_id)throws SomethingWentWrongException,NoRecordFoundException;
	public void AssignTendertoVender(String TenderName,String vendor_id)throws SomethingWentWrongException;
	public boolean VerifyTenderName(String tendi_name) throws SomethingWentWrongException, NoRecordFoundException;
	public boolean VerifyVenderid(String Vendi_id) throws SomethingWentWrongException, NoRecordFoundException;
}
