package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Apartmentment.Management.userViews.Bills;

@Service
public class ViewBillsService {
	public List<Bills> retrive(String user) throws SQLException{
		
		List<Bills> ans=new ArrayList<Bills>();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		PreparedStatement pt = con.prepareStatement("select subscription_id,bill_arrived_date,bill_paid_date,total_cost,mode_of_payment,ref_id from Subscription_log where Apartment_id = ?");
		pt.setInt(1, Integer.parseInt(user));
		ResultSet rs=pt.executeQuery();
		while(rs.next()) {
			Bills bill=new Bills();
			bill.setId(rs.getInt(1));
			bill.setAr_date(rs.getString(2));
			bill.setPa_date(rs.getString(3));
			bill.setCost(rs.getDouble(4));
			bill.setMode(rs.getString(5));
			bill.setRef_id(rs.getInt(6));
			
			ans.add(bill);
		}
		return ans;
	}
	public List<Bills> unpaidretrive() throws SQLException{
		
		List<Bills> ans=new ArrayList<Bills>();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		PreparedStatement pt = con.prepareStatement("select subscription_id,bill_arrived_date,total_cost,Apartment_id from Subscription_log where bill_paid_date is null");
		ResultSet rs=pt.executeQuery();
		while(rs.next()) {
			Bills bill=new Bills();
			bill.setId(rs.getInt(1));
			bill.setAr_date(rs.getString(2));
			bill.setCost(rs.getDouble(3));
			bill.setAp_id(rs.getInt(4));
			ans.add(bill);
		}
		return ans;
	}
	public String addBill(String ap_id,String total_cost) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement ps= con.prepareStatement("select owner_id from Apartment where Apartment_id=?");
			ps.setInt(1, Integer.parseInt(ap_id));
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
				return "Apartment doesn't exist";
			if(Double.parseDouble(total_cost)<0)
				return "Invalid cost";
			PreparedStatement pt = con.prepareStatement("insert into Subscription_log(bill_arrived_date,total_cost,Apartment_id) values(?,?,?)");
			 java.util.Date now = new java.util.Date();
			 java.sql.Date sqlDate = new java.sql.Date(now.getTime());
			 pt.setDate(1, sqlDate);
			 pt.setDouble(2, Double.parseDouble(total_cost));
			 pt.setInt(3, Integer.parseInt(ap_id));
			 pt.executeUpdate();
		}
		catch(Exception e){
			return String.valueOf(e);
		}
		return "success";
	}
	public String payBill(String b_id,String mode,String ref_id) {
		try {
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			
			PreparedStatement ps= con.prepareStatement("select total_cost from Subscription_log where subscription_id=?");
			ps.setInt(1, Integer.parseInt(b_id));
			ResultSet rs=ps.executeQuery();
			if(!rs.next())
				return "Bill doesn't exist";
			if(!(mode.equalsIgnoreCase("online") || mode.equalsIgnoreCase("offline")))
				return "Invalid mode of payment";
			if(mode.equalsIgnoreCase("online") && ref_id.equals(""))
				return "Enter reference id for online payment";
			if(!ref_id.equals("")) {
			PreparedStatement pt = con.prepareStatement("update Subscription_log set bill_paid_date=?,mode_of_payment=?,ref_id=?");
			 java.util.Date now = new java.util.Date();
			 java.sql.Date sqlDate = new java.sql.Date(now.getTime());
			 pt.setDate(1, sqlDate);
			 pt.setString(2, mode);
			 pt.setInt(3, Integer.parseInt(ref_id));
			 pt.executeUpdate();
			}
			else {
				PreparedStatement pt = con.prepareStatement("update Subscription_log set bill_paid_date=?,mode_of_payment=?");
				 java.util.Date now = new java.util.Date();
				 java.sql.Date sqlDate = new java.sql.Date(now.getTime());
				 pt.setDate(1, sqlDate);
				 pt.setString(2, mode);
				 pt.executeUpdate();
			}
			 con.close();
		}
		catch(Exception e){
			return String.valueOf(e);
		}
		finally {
			
		}
		
		return "success";
	}
}
