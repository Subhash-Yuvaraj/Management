package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
@Service
public class VisitorCheckInService {
	
	public String validate(String name,String phone,String a_id) throws SQLException {
		if(phone.length()<10 || phone.length()>12)
			return "Invalid Phone Number";
		for(int i=0;i<phone.length();i++) {
			if(phone.charAt(i)<'0' || phone.charAt(i)>'9')
				return "Invalid Phone Number";
		}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		PreparedStatement ps=con.prepareStatement("select status from occupied where Apartment_id=?");
		ps.setInt(1, Integer.parseInt(a_id));
		ResultSet rs=ps.executeQuery();
		if(!rs.next())
			return "Apartment Doesn't exist";
		if(rs.getInt(1)==0)
			return "No residents in the apartment";
		PreparedStatement pst=con.prepareStatement("select max(entry_id) from visitor1");
		ResultSet rt=pst.executeQuery();
		rt.next();
		int e_id=rt.getInt(1);
		PreparedStatement pt=con.prepareStatement("insert into visitor1(entry_id,vis_name,mobile,in_time) values(?,?,?,?)");
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

		pt.setInt(1,e_id+1);
		pt.setString(2, name);
		pt.setString(3, phone);
		pt.setTimestamp(4,date);
		pt.executeUpdate();
		PreparedStatement p1=con.prepareStatement("insert into visitor2 values(?,?)");
		p1.setInt(1, e_id+1);
		p1.setInt(2, Integer.parseInt(a_id));
		p1.executeUpdate();
		return "success";
		
	}
}
