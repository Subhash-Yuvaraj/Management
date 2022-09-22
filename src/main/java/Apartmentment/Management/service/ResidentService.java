package Apartmentment.Management.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;
import Apartmentment.Management.userViews.Residents;
@Service
public class ResidentService {
	public String validate(String name,String gender,String age,String blood_group,String ap_id,String pass) {
		try {
			if(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f"))
				return "Invalid gender";
			if(Integer.parseInt(age)<1)
				return "Invalid age";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","root","");
			PreparedStatement pt= con.prepareStatement("select owner_id from Apartment where Apartment_id=?");
			pt.setInt(1, Integer.parseInt(ap_id));
			ResultSet rs=pt.executeQuery();
			if(!rs.next())
				return "Apartment doesn't exist";
			String v=null;
			while(rs.next())
					v=rs.getString("owner_id");
			if(v!=null)
				return "Apartment already occupied";
			PreparedStatement stmt= con.prepareStatement("insert into Residents(name,gender,age,blood_group,Apartment_id) values(?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setInt(3, Integer.parseInt(age));
			stmt.setString(4, blood_group);
			stmt.setInt(5,Integer.parseInt(ap_id));
			
			stmt.executeUpdate();
			PreparedStatement ps= con.prepareStatement("select Resident_id from Residents where Apartment_id=?");
			ps.setInt(1, Integer.parseInt(ap_id));
			ResultSet rt=ps.executeQuery();
			rt.next();
			int o_id=rt.getInt(1);
			PreparedStatement p = con.prepareStatement("update Apartment set owner_id = ? where Apartment_id = ?");
			p.setInt(1,o_id);
			p.setInt(2,Integer.parseInt(ap_id));
			p.executeUpdate();
			PreparedStatement pst = con.prepareStatement("update occupied set owner_id = ?,status = ? where Apartment_id = ?");
			pst.setInt(1, o_id);
			pst.setInt(2, 1);
			pst.setInt(3,Integer.parseInt(ap_id));
			pst.executeUpdate();
			String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
			          +"jklmnopqrstuvwxyz!@#$%&";
					Random rnd = new Random();
					StringBuilder sb = new StringBuilder(8);
					for (int i = 0; i < 8; i++)
						sb.append(chars.charAt(rnd.nextInt(chars.length())));
			
			PreparedStatement st = con.prepareStatement("insert into login values(?,?)");
			MessageDigest m = null;
			try {
				m = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	m.reset();
	    	m.update(pass.getBytes());
	    	byte[] digest = m.digest();
	    	BigInteger bigInt = new BigInteger(1,digest);
	    	String hashtext = bigInt.toString(16);
	    	while(hashtext.length() < 32 ){
	    	  hashtext = "0"+hashtext;
	    	}
			st.setString(1,ap_id);
			st.setString(2,hashtext);
			st.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
	public String existing(String name,String gender,String age,String blood_group,String ap_id) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","root","");
			PreparedStatement pt= con.prepareStatement("select owner_id from Apartment where Apartment_id=?");
			pt.setInt(1, Integer.parseInt(ap_id));
			ResultSet rs=pt.executeQuery();
			if(!rs.next())
				return "Apartment doesn't exist";
			if(!gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f"))
				return "Invalid gender";
			if(Integer.parseInt(age)<1)
				return "Invalid age";
			PreparedStatement stmt= con.prepareStatement("insert into Residents(name,gender,age,blood_group,Apartment_id) values(?,?,?,?,?)");
			stmt.setString(1, name);
			stmt.setString(2, gender);
			stmt.setInt(3, Integer.parseInt(age));
			stmt.setString(4, blood_group);
			stmt.setInt(5,Integer.parseInt(ap_id));
			
			stmt.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
	public String deleteResident(String r_id) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","root","");
			
			PreparedStatement pt=con.prepareStatement("select Apartment_id from Residents where Resident_id=?");
			pt.setInt(1, Integer.parseInt(r_id));
			ResultSet rs=pt.executeQuery();
			if(!rs.next()) {
				return "Resident Doesn't exist";
			}
			int ap_id=rs.getInt(1);
			PreparedStatement ps=con.prepareStatement("select Apartment_id from Apartment where owner_id=?");
			ps.setInt(1, Integer.parseInt(r_id));
			ResultSet rt=ps.executeQuery();
			if(rt.next()) {
				rt.next();
				PreparedStatement pr=con.prepareStatement("select Resident_id from Residents where Apartment_id=? and Resident_id!=? order by age desc limit 1");
				pr.setInt(1, ap_id);
				pr.setInt(2, Integer.parseInt(r_id));
				ResultSet res=pr.executeQuery();
				
				if(res.next()) {
					int new_id=res.getInt(1);
					PreparedStatement p1=con.prepareStatement("update Apartment set owner_id=? where Apartment_id=?");
					p1.setInt(1, new_id);
					p1.setInt(2, ap_id);
					p1.executeUpdate();
					PreparedStatement p2=con.prepareStatement("update occupied set owner_id=? where Apartment_id=?");
					p2.setInt(1, new_id);
					p2.setInt(2, ap_id);
					p2.executeUpdate();
					
				}
				else {
					PreparedStatement p1=con.prepareStatement("update Apartment set owner_id=null where Apartment_id=?");
					p1.setInt(1, ap_id);
					p1.executeUpdate();
					PreparedStatement p2=con.prepareStatement("update occupied set owner_id=null, status=? where Apartment_id=?");
					p2.setInt(1, 0);
					p2.setInt(2, ap_id);
					p2.executeUpdate();
					PreparedStatement p3=con.prepareStatement("delete from login where id=?");
					p3.setString(1, String.valueOf(ap_id));
					p3.executeUpdate();
					PreparedStatement p4=con.prepareStatement("update Parking_lot set parking_status=? where Apartment_id=?");
					p4.setInt(1, 0);
					p4.setInt(2, ap_id);
					p4.executeUpdate();
				}
				
			}
			PreparedStatement p3=con.prepareStatement("delete from Residents where Resident_id=?");
			p3.setInt(1, Integer.parseInt(r_id));
			p3.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
	public List<Residents> viewAll(){
		List<Residents> l=new ArrayList<Residents>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement pt=con.prepareStatement("select * from Residents order by Apartment_id");
			ResultSet rs=pt.executeQuery();
			while(rs.next()) {
				Residents r=new Residents(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(1));
				l.add(r);
			}
		}
		catch(Exception e) {
			
		}
		return l;
	}
}
