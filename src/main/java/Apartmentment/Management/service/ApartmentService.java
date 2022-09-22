package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
@Service
public class ApartmentService {
	public String validate(String a_id,String b_id,String cost,String floor_no) throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		try {
			PreparedStatement p=con.prepareStatement("select * from Apartment where Apartment_id=?");
			p.setInt(1, Integer.parseInt(a_id));
			ResultSet rs=p.executeQuery();
			if(rs.next())
				return "Apartment Already exists";
			PreparedStatement ps=con.prepareStatement("select no_of_floors from Blocks where Block_id=?");
			ps.setInt(1, Integer.parseInt(b_id));
			ResultSet r=ps.executeQuery();
			if(!r.next())
				return "Invalid Block Number";
			int nf=r.getInt(1);
			if(Integer.parseInt(floor_no)<0 || Integer.parseInt(floor_no)>=nf)
				return "Invalid floor number";
			PreparedStatement pt=con.prepareStatement("select count(*) from Apartment where Block_id=? and floor_number=?");
			pt.setInt(1, Integer.parseInt(b_id));
			pt.setInt(2, Integer.parseInt(floor_no));
			ResultSet rt=pt.executeQuery();
			rt.next();
			int c=rt.getInt(1);
			PreparedStatement pst=con.prepareStatement("select no_of_apartments_in_each_floor from Blocks where Block_id=?");
			pst.setInt(1,Integer.parseInt(b_id));
			ResultSet rst=pst.executeQuery();
			rst.next();
			int cap=rst.getInt(1);
			if(cap==c)
				return "The floor is already occupied";
			if(Double.parseDouble(cost)<3000000)
				return "Invalid cost";
			PreparedStatement stmt=con.prepareStatement("insert into Apartment(Apartment_id,floor_number,price,Block_id) values(?,?,?,?)");
			stmt.setInt(1,Integer.parseInt(a_id));
			stmt.setInt(2,Integer.parseInt(floor_no));
			stmt.setDouble(3,Double.parseDouble(cost));
			stmt.setInt(4,Integer.parseInt(b_id));
			stmt.executeUpdate();
			PreparedStatement st = con.prepareStatement("insert into occupied(Apartment_id,status) values(?,?)");
			st.setInt(1,Integer.parseInt(a_id));
			st.setInt(2, 0);
			st.executeUpdate();
			PreparedStatement sm = con.prepareStatement("insert into Parking_lot(parking_status,Apartment_id) values(?,?)");
			sm.setInt(1,0);
			sm.setInt(2, Integer.parseInt(a_id));
			sm.executeUpdate();
		}
		catch(Exception e) {
			return "invalid input";
		}
		return "success";
	}
}
