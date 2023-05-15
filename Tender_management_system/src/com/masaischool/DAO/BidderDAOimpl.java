package com.masaischool.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masaischool.DTO.BidderDTO;
import com.masaischool.DTO.BidderDTOimpl;
import com.masaischool.Exception.NoRecordFoundException;
import com.masaischool.Exception.SomethingWentWrongException;

public class BidderDAOimpl implements BidderDAO{

	
private boolean isResultsetEmpty(ResultSet rs)throws SQLException{
		
		return !rs.isBeforeFirst() && rs.getRow() == 0?true:false;
}	
	
	@Override
	public List<BidderDTO> viewAllBidsofaTender(String tend_id)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<BidderDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM BIDDER WHERE Tender_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			ps.setString(1, tend_id);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("for this tender id");
			}
			
			while(rs.next()) {
				
				list.add(new BidderDTOimpl(rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5)));
				
			}
			
			
			
		}catch(SQLException e) {
			System.out.println(e);
			e.printStackTrace();
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
	public List<BidderDTO> viewAllBidsOfaVendor(String vendorId)
			throws SomethingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		List<BidderDTO> list = new ArrayList<>();
		
		try {
			connection = DBUtils.ConnectToDatabse();
			
			String SELECT_QUERY = "SELECT * FROM Bidder WHERE Vender_id = ?";
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
			
			ResultSet rs = ps.executeQuery();
			
			if(isResultsetEmpty(rs)) {
				throw new NoRecordFoundException("No Record Found");
			}
			
			while(rs.next()) {
				
				list.add(new BidderDTOimpl(rs.getString("Vender_id"),rs.getString("Tender_id"),rs.getInt("Bid_amount"),rs.getString("Status")));
				
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

}
