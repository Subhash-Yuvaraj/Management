package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
	public String validate(String a_id) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement st=con.prepareStatement("select owner_id from occupied where Apartment_id=?");
			st.setInt(1, Integer.parseInt(a_id));
			ResultSet rt=st.executeQuery();
			if(!rt.next())
				return "Apartment Doesn't exist";
			if(rt.getString(1)==null)
				return "Apartment not occupied";
			PreparedStatement pt = con.prepareStatement("select parking_status from Parking_lot where Apartment_id = ?");
			pt.setInt(1, Integer.parseInt(a_id));
			ResultSet rs=pt.executeQuery();
			rs.next();
			if(rs.getString(1).equals("1"))
				return "Already occupied";
			PreparedStatement ps = con.prepareStatement("update  Parking_lot set parking_status=1 where Apartment_id = ?");
			ps.setInt(1, Integer.parseInt(a_id));
			ps.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
}
