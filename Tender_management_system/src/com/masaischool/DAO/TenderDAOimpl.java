package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.TenderDTO;
import com.masaischool.DTO.TenderDTOimpl;
import com.masaischool.DTO.VendorDTO;
import com.masaischool.DTO.VendorDTOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;



public class TenderDAOimpl implements TenderDAO{

	@Override
	public void addTender(TenderDTO tenddto) throws SomethingWentWrongException {
		// 
	  Connection connection = null;
	  
	  try {
		  
		  connection = DBUtils.ConnectToDatabse();
		  
		  String INSERT_QUERY = "INSERT INTO TENDER VALUES(?,?)";
		  
		  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
		  
		  ps.setString(1, tenddto.getTender_id());
		  ps.setString(2, tenddto.getTender_Name());
		  
		  ps.executeUpdate();
		  
	  }catch(SQLException e) {
		  System.out.println(e);
	  }finally {
		  try {
			DBUtils.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
		
	}
	
private boolean isResultsetEmpty(ResultSet rs)throws SQLException{
		
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
		
	}
	

	@Override
	public List<TenderDTO> ViewTenders() throws SomethingWentWrongException, NoRecordFoundException {
		// View all Tenders
		
		Connection connection = null;
		List<TenderDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM TENDER";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found");
			}
			
			while(rs.next()) {
				
				list.add(new TenderDTOimpl(rs.getString("Tender_id"),rs.getString("Tender_Name")));
				
			}
			
			
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public List<TenderDTO> ViewTenderByTenderId(String tend_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<TenderDTO> list = new ArrayList<>(); 
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String INSERT_QUERY = "SELECT * FROM TENDER WHERE Tender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			  
			  ps.setString(1, tend_id);
			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("No Record Found");
				}
				
				while(rs.next()) {
					list.add(new TenderDTOimpl(rs.getString("Tender_id"),rs.getString("Tender_Name")));
				}
			  
		  }catch(SQLException e) {
			  System.out.println(e);
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		return list;
		
	}

	@Override
	public void AssignTendertoVender(String TenderName, String vendor_id) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		  
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
//			  INSERT INTO table_name (column1, column2, column3,...) VALUES (value1, value2, value3,...);
			  String UPDATE_QUERY = "UPDATE VENDER SET Tender_Allocated = ? WHERE Vender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(UPDATE_QUERY);
			  
			  ps.setString(1, TenderName);
			  ps.setString(2, vendor_id);
			  
			  ps.executeUpdate();
			  
		  }catch(SQLException e) {
//			  System.out.println(e);
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		  }
		
	}

	@Override
	public boolean VerifyTenderName(String tendi_name) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<TenderDTO> list = new ArrayList<>();
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String VERIFY_QUERY = "SELECT * FROM TENDER WHERE Tender_Name = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(VERIFY_QUERY);
			  
			  ps.setString(1, tendi_name);
			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("with this tender name");
				}
				
				while(rs.next()) {
					
					list.add(new TenderDTOimpl(rs.getString("Tender_id"),rs.getString("Tender_Name")));
					
				}
			  
//			  ps.executeUpdate();
			  System.out.println("Welcome Vendor");
			  return true;
		  }catch(SQLException e) {
			  System.out.println("Wrong Credentials");
//			  System.out.println(e);
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		  }
		return false;

	}

	@Override
	public boolean VerifyVenderid(String Vendi_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<VendorDTO> list = new ArrayList<>();
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String VERIFY_QUERY = "SELECT * FROM VENDER WHERE Vender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(VERIFY_QUERY);
			  
			  ps.setString(1, Vendi_id);
			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("with this Vendor id");
				}
				
				while(rs.next()) {
					
					list.add(new VendorDTOimpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
					
				}
			  
//			  ps.executeUpdate();
			  System.out.println("Welcome Vendor");
			  return true;
		  }catch(SQLException e) {
			  System.out.println("Wrong Credentials");
			  System.out.println(e);
		  }finally {
			  try {
				DBUtils.closeConnection(connection);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		return false;

	}
		

	

}
