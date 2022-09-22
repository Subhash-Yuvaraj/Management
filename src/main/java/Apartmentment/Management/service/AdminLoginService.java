package Apartmentment.Management.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;
@Service
public class AdminLoginService {
	public boolean validate(String name,String password) throws SQLException {
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	m.reset();
    	m.update(password.getBytes());
    	byte[] digest = m.digest();
    	BigInteger bigInt = new BigInteger(1,digest);
    	String hashtext = bigInt.toString(16);
    	while(hashtext.length() < 32 ){
    	  hashtext = "0"+hashtext;
    	}
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
		PreparedStatement stmt=con.prepareStatement("select id,password from admin_login where id=? and password=?");
		stmt.setString(1, name);
		stmt.setString(2, hashtext);
		ResultSet rs=stmt.executeQuery();
		return rs.next();
	}
}
