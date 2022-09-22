package Apartmentment.Management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Apartmentment.Management.userViews.Goods;
import Apartmentment.Management.userViews.GoodsBill;

@Service
public class GoodsService {
	
	public List<Goods> show(){
		List<Goods> l=new ArrayList<Goods>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement p=con.prepareStatement("select * from  goods");
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				Goods g=new Goods();
				g.setId(rs.getInt(1));
				g.setName(rs.getString(2));
				g.setPrice(rs.getDouble(3));
				g.setQuantity(rs.getInt(4));
				l.add(g);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}
	
	public List<GoodsBill> not_delivered(){
		List<GoodsBill> l=new ArrayList<GoodsBill>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement p=con.prepareStatement("select * from  goods_bill where delivered=?");
			p.setInt(1, 0);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				GoodsBill g=new GoodsBill();
				g.setId(rs.getInt(1));
				g.setBill_date(rs.getString(2));
				g.setAp_id(rs.getInt(3));
				g.setCost(rs.getDouble(4));
				g.setStatus(rs.getInt(5));
				l.add(g);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}
	public List<GoodsBill> delivered(){
		List<GoodsBill> l=new ArrayList<GoodsBill>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement p=con.prepareStatement("select * from  goods_bill where delivered=?");
			p.setInt(1, 1);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				GoodsBill g=new GoodsBill();
				g.setId(rs.getInt(1));
				g.setBill_date(rs.getString(2));
				g.setAp_id(rs.getInt(3));
				g.setCost(rs.getDouble(4));
				l.add(g);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}
	public List<GoodsBill> viewAll(int ap_id){
		List<GoodsBill> l=new ArrayList<GoodsBill>();
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement p=con.prepareStatement("select bill_id,bill_date,cost,delivered from  goods_bill where Apartment_id=?");
			p.setInt(1, ap_id);
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				GoodsBill g=new GoodsBill();
				g.setId(rs.getInt(1));
				g.setBill_date(rs.getString(2));
				g.setCost(rs.getDouble(3));
				g.setStatus(rs.getInt(4));
				l.add(g);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return l;
	}
	public void deliver(int id){
		
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			PreparedStatement p=con.prepareStatement("update goods_bill set delivered=? where bill_id=?");
			p.setInt(1, 1);
			p.setInt(2, id);
			p.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return ;
	}
	public String update(String car,String beet,String milk,String tomato) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			if(car.equals("") && beet.equals("") && milk.equals("") && tomato.equals(""))
				return "success";
			
			if(car.equals(""))
				car="0";
			if(beet.equals(""))
				beet="0";
			if(milk.equals(""))
				milk="0";
			if(tomato.equals(""))
				tomato="0";
			List<Integer> id=new ArrayList<Integer>();
			List<Integer> q=new ArrayList<Integer>();
			PreparedStatement p=con.prepareStatement("select item_id,quantity from goods");
			String[] val= {car,beet,milk,tomato};
			ResultSet rs=p.executeQuery();
			int j=0;
			while(rs.next()) {
				id.add(rs.getInt(1));
				q.add(rs.getInt(2));
				if(Integer.parseInt(val[j++])<0)
					return "Invalid entry";
			}
			for(int i=0;i<4;i++) {
				int x=id.get(i);
				int y=q.get(i);
				p=con.prepareStatement("update goods set quantity=? where item_id=?");
				p.setInt(1, y+Integer.parseInt(val[i]));
				p.setInt(2, x);
				p.executeUpdate();
			}
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
	public String order(String car,String beet,String milk,String tomato,int ap_id) {
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Apartment_Management","subhash","subhashdb");
			if(car.equals("") && beet.equals("") && milk.equals("") && tomato.equals(""))
				return "success";
			
			if(car.equals(""))
				car="0";
			if(beet.equals(""))
				beet="0";
			if(milk.equals(""))
				milk="0";
			if(tomato.equals(""))
				tomato="0";
			List<Integer> id=new ArrayList<Integer>();
			List<Integer> q=new ArrayList<Integer>();
			List<Integer> pr=new ArrayList<Integer>();
			PreparedStatement p=con.prepareStatement("select item_id,quantity,price from goods");
			String[] val= {car,beet,milk,tomato};
			ResultSet rs=p.executeQuery();
			int j=0;
			while(rs.next()) {
				id.add(rs.getInt(1));
				q.add(rs.getInt(2));
				pr.add(rs.getInt(3));
				if(Integer.parseInt(val[j])<0 || Integer.parseInt(val[j])>q.get(j++))
					return "Stock not available";
			}
			double ans=0;
			for(int i=0;i<4;i++) {
				int x=id.get(i);
				int y=q.get(i);
				ans+=pr.get(i)*Integer.parseInt(val[i]);
				p=con.prepareStatement("update goods set quantity=? where item_id=?");
				p.setInt(1, y-Integer.parseInt(val[i]));
				p.setInt(2, x);
				p.executeUpdate();
				
			}
			p=con.prepareStatement("insert into goods_bill(bill_date,Apartment_id,cost,delivered) values(?,?,?,?)");
			p.setTimestamp(1, new java.sql.Timestamp(new java.util.Date().getTime()));
			p.setInt(2, ap_id);
			p.setDouble(3,ans);
			p.setInt(4, 0);
			p.executeUpdate();
		}
		catch(Exception e) {
			return String.valueOf(e);
		}
		return "success";
	}
}
