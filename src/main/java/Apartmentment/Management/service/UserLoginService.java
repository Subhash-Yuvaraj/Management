package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import Apartmentment.Management.userViews.ApartmentLogin;
@Service
public class UserLoginService {
	public List<ApartmentLogin> retrive(String a_id){
			List<ApartmentLogin> l=new ArrayList<ApartmentLogin>();
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
				PreparedStatement pt = con.prepareStatement("select id,password from login where id = ?");
				pt.setInt(1, Integer.parseInt(a_id));
				ResultSet rs=pt.executeQuery();
				while(rs.next()) {
					ApartmentLogin ap=new ApartmentLogin();
					ap.setId(rs.getString(1));
					ap.setPassword(rs.getString(2));
					l.add(ap);
				}
			}
			catch(Exception e) {
				
			}
			return l;
	}
}
