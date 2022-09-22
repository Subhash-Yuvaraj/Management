package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import Apartmentment.Management.userViews.Contacts;

@Service
public class ContactService {
	public String validate(String r_id,String phone) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement st=con.prepareStatement("select name from Residents where Resident_id=?");
			st.setInt(1, Integer.parseInt(r_id));
			ResultSet rs=st.executeQuery();
			if(!rs.next())
				return "Resident Doesn't Exist";
			if(phone.length()<10 || phone.length()>12)
				return "Invalid phone number";
			for(int i=0;i<phone.length();i++) {
				if(!Character.isDigit(phone.charAt(i)))
					return "Invalid phone number";
			}
			PreparedStatement stt=con.prepareStatement("select * from Contact where Resident_id=? and contact_number=?");
			
			stt.setInt(1, Integer.parseInt(r_id));
			stt.setString(2, phone);
			ResultSet rt=stt.executeQuery();
			if(rt.next())
				return "Already added";
			PreparedStatement ps = con.prepareStatement("insert into Contact values(?,?)");
			ps.setInt(1, Integer.parseInt(r_id));
			ps.setString(2, phone);
			ps.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
	public List<Contacts> display(int r_id) {
		List<Contacts> c=new ArrayList<Contacts>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement st=con.prepareStatement("select Resident_id,contact_number from Contact where Resident_id=?"); 
			st.setInt(1, r_id);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Contacts cn=new Contacts();
				cn.setR_id(1);
				cn.setPhone(rs.getString(2));
				c.add(cn);
			}
		}
		catch(Exception e) {
			
		}
		return c;
	}
}
