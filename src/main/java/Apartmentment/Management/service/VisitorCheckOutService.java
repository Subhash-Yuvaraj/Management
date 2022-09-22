package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

@Service
public class VisitorCheckOutService {
	public String validate(String a_id) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement pt = con.prepareStatement("select out_time from visitor1 where entry_id=?");
			pt.setInt(1, Integer.parseInt(a_id));
			ResultSet rs=pt.executeQuery();
			if(!rs.next())
				return "Invalid input";
			if(rs.getString(1)!=null)
				return "Already checked out";
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			PreparedStatement ps=con.prepareStatement("update visitor1 set out_time=? where entry_id=?");
			ps.setTimestamp(1,date);
			ps.setInt(2, Integer.parseInt(a_id));
			ps.executeUpdate();
		}
		catch(Exception e) {
			return "Invalid input";
		}
		return "success";
	}
	static public java.sql.Date getCurrentDatetime() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
}
