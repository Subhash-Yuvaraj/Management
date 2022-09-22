package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Apartmentment.Management.userViews.Visitors;
@Service
public class ViewVisitorsService {
	public List<Visitors> retrive(String user) throws Exception{
		List<Visitors> ans=new ArrayList<Visitors>();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		PreparedStatement pt= con.prepareStatement("select entry_id,vis_name,mobile,in_time,out_time from visitor1 natural join visitor2 where visitor2.Apartment_id=?");
		try {
			pt.setInt(1,Integer.parseInt(user));
			ResultSet rs=pt.executeQuery();
			
			while(rs.next()) {
				Visitors v=new Visitors();
				v.setV_id(rs.getInt(1));
				v.setName(rs.getString(2));
				v.setPhone(rs.getString(3));
				v.setIn_time(rs.getString(4));
				v.setOut_time(rs.getString(5));
				ans.add(v);
			}
		}
		catch(Exception e){
			
		}
		return ans;
	}
}
