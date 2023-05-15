package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.VendorDTO;
import com.masaischool.DTO.VendorDTOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;


public class VendorDAOimpl implements VendorDAO{

	private boolean isResultsetEmpty(ResultSet rs)throws SQLException{
		
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
		
	}
	
	@Override
	public List<VendorDTO> ViewVendors() throws SomethingWentWrongException, NoRecordFoundException {
		// View all vendors
		
		Connection connection = null;
		List<VendorDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM VENDER";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found");
			}
			
			while(rs.next()) {
				
				list.add(new VendorDTOimpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				
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
	public List<VendorDTO> ViewAllBidsofaTender(String Tender_id)
			throws SomethingWentWrongException, NoRecordFoundException {
		Connection connection = null;
		List<VendorDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT Vender_id,Vender_Name FROM VENDER V INNER JOIN TENDER T ON V.Tender_id = T.Tender_id AND T.Tender_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, Tender_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found");
			}
			
			while(rs.next()) {
				
				list.add(new VendorDTOimpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
				
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
	public boolean VerifyVendercredentials(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<VendorDTO> list = new ArrayList<>();
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String VERIFY_QUERY = "SELECT * FROM VENDER WHERE Vender_Name = ? AND Vender_password = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(VERIFY_QUERY);
			  
			  ps.setString(1, username);
			  ps.setString(2, password);
			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("No Record Found");
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

	@Override
	public void updatecredentials(String Name, String password,String ven_id) throws SomethingWentWrongException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		  
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String INSERT_QUERY = "UPDATE VENDER SET Vender_Name = ?,Vender_password = ? WHERE Vender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(INSERT_QUERY);
			  
			  ps.setString(1, Name);
			  ps.setString(2, password);
			  ps.setString(3, ven_id);
			  
			  ps.executeUpdate();
//			  System.out.println("Updated Sucessfully D");
		  }catch(SQLException e) {
			  System.out.println("Not updated D");
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
	
	@Override
	public boolean VerifyVendercredentialsforUpdate(String vd_id) throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<VendorDTO> list = new ArrayList<>();
		  try {
			  
			  connection = DBUtils.ConnectToDatabse();
			  
			  String VERIFY_QUERY = "SELECT * FROM VENDER WHERE Vender_id = ?";
			  
			  PreparedStatement ps = connection.prepareStatement(VERIFY_QUERY);
			  
			  ps.setString(1, vd_id);

			  
			  ResultSet rs = ps.executeQuery();
				
				if(isResultsetEmpty(rs)) {
					throw new NoRecordFoundException("for this vendor id");
//					System.out.println("No Record Found for this vender id");
				}
				
				while(rs.next()) {
					
					list.add(new VendorDTOimpl(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
					
				}
			  
//			  ps.executeUpdate();
//			  System.out.println("Welcome Vendor");
			  return true;
		  }catch(SQLException e) {
			  System.out.println("No Record Found for this vender_id");
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
