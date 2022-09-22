package Apartmentment.Management.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import Apartmentment.Management.userViews.Contacts;

import Apartmentment.Management.service.ApartmentService;
import Apartmentment.Management.service.ContactService;
import Apartmentment.Management.service.GoodsService;
import Apartmentment.Management.service.ParkingLotService;
import Apartmentment.Management.service.ResidentService;
import Apartmentment.Management.service.UserLoginService;
import Apartmentment.Management.service.ViewBillsService;
import Apartmentment.Management.service.VisitorCheckInService;
import Apartmentment.Management.service.VisitorCheckOutService;
@Controller
@SessionAttributes("name")
public class AdminPanelController {
	@Autowired
	ApartmentService service;
	@Autowired
	VisitorCheckOutService visitorCheckout;
	@Autowired
	VisitorCheckInService checkInService;
	@Autowired
	ResidentService r_service;
	@Autowired
	UserLoginService u_service;
	@Autowired
	ViewBillsService b_service;
	@Autowired
	ParkingLotService p_service;
	@Autowired
	ContactService c_service;
	@Autowired
	GoodsService g_service;
	@RequestMapping(value="/addApartments",method=RequestMethod.GET)
	public String apartment(ModelMap m) {
		return "addApartments";
	}
	@RequestMapping(value="/addApartments",method=RequestMethod.POST)
	public String apartmentInsertion(ModelMap m,@RequestParam String a_id,@RequestParam String b_id,@RequestParam String cost,@RequestParam String floor_no) {
		String correct = "success";
		try {
			correct = service.validate(a_id,b_id,cost,floor_no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "addApartments";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/addResidents",method=RequestMethod.GET)
	public String resident(ModelMap m) {
		return "addResidents";
	}
	@RequestMapping(value="/addResidents",method=RequestMethod.POST)
	public String residentInsertion(ModelMap m,@RequestParam String name,@RequestParam String gender,@RequestParam String age,@RequestParam String blood_group,@RequestParam String ap_id) {
		String correct = "success";
		try {
			correct = r_service.existing(name,gender,age,blood_group,ap_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "addResidents";
		}
		return "adminDashboard";
	}
	
	@RequestMapping(value="/buyNewApartment",method=RequestMethod.GET)
	public String owner(ModelMap m) {
		return "buyNewApartment";
	}
	@RequestMapping(value="/buyNewApartment",method=RequestMethod.POST)
	public String getOwner(ModelMap m,@RequestParam String name,@RequestParam String gender,@RequestParam String age,@RequestParam String blood_group,@RequestParam String ap_id,@RequestParam String pass) throws SQLException {
		String correct = "";
		correct = r_service.validate(name,gender,age,blood_group,ap_id,pass);	
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "buyNewApartment";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/showLogin",method=RequestMethod.GET)
	public String LoginDetails(ModelMap m) {
		
		return "showLogin";
	}
	@RequestMapping(value="/showLogin",method=RequestMethod.POST)
	public String displayLoginDetails(ModelMap m,String a_id) {
		
		return "showLogin";
	}
	@RequestMapping(value="/getLoginAp",method=RequestMethod.GET)
	public String getLoginDetails(ModelMap m) {
		
		return "getLoginAp";
	}
	@RequestMapping(value="/getLoginAp",method=RequestMethod.POST)
	public String showLoginDetails(ModelMap m,@RequestParam String a_id) {
  	m.put("Login",u_service.retrive(a_id));
		return "showLogin";
		
	}
	
	@RequestMapping(value="/visitorCheckOut",method=RequestMethod.GET)
	public String getvisitorCheckout(ModelMap m) {
		return "visitorCheckOut";
	}
	@RequestMapping(value="/visitorCheckOut",method=RequestMethod.POST)
	public String visitorCheckout(ModelMap m,@RequestParam String a_id) {
		String correct="";
		correct =visitorCheckout.validate(a_id);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "visitorCheckOut";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/deleteResident",method=RequestMethod.GET)
	public String deleteResident(ModelMap m) {
		return "deleteResident";
	}
	@RequestMapping(value="/deleteResident",method=RequestMethod.POST)
	public String deleteResident(ModelMap m,@RequestParam String r_id) {
		String correct="";
		correct =r_service.deleteResident(r_id);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "deleteResident";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/occupyParking",method=RequestMethod.GET)
	public String occupy(ModelMap m) {
		return "occupyParking";
	}
	@RequestMapping(value="/occupyParking",method=RequestMethod.POST)
	public String occupy(ModelMap m,@RequestParam String a_id) {
		String correct="";
		correct =p_service.validate(a_id);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "occupyParking";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/addContact",method=RequestMethod.GET)
	public String addContacts(ModelMap m) {
		return "addContact";
	}
	@RequestMapping(value="/addContact",method=RequestMethod.POST)
	public String addContacts(ModelMap m,@RequestParam String r_id,@RequestParam String p_no) {
		String correct="";
		correct =c_service.validate(r_id,p_no);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "addContact";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/viewContact",method=RequestMethod.GET)
	public String showContacts(ModelMap m) {
		return "viewContact";
	}
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String showContacts(ModelMap m,@RequestParam int r_id) {
		m.put("Contacts", c_service.display(r_id));
		return "viewContact";
	}
	@RequestMapping(value="/addSubscriptions",method=RequestMethod.GET)
	public String addSubscription(ModelMap m) {
		return "addSubscriptions";
	}
	@RequestMapping(value="/addSubscriptions",method=RequestMethod.POST)
	public String addSubscription(ModelMap m,@RequestParam String cost,@RequestParam String ap_id) {
		String correct="";
		correct =b_service.addBill(ap_id,cost);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "addSubscriptions";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/updateStocks",method=RequestMethod.GET)
	public String update(ModelMap m) {
		m.put("Goods", g_service.show());
		return "updateStocks";
	}
	@RequestMapping(value="/updateStocks",method=RequestMethod.POST)
	public String update(ModelMap m,@RequestParam String car,@RequestParam String beet,@RequestParam String milk,@RequestParam String tomato) {
		String correct="";
		m.put("Goods", g_service.show());
		correct =g_service.update(car,beet,milk,tomato);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "redirect:updateStocks";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/paySubscriptions",method=RequestMethod.GET)
	public String paySubscription(ModelMap m) {
		return "paySubscriptions";
	}
	@RequestMapping(value="/paySubscriptions",method=RequestMethod.POST)
	public String paySubscription(ModelMap m,@RequestParam String bill_id,@RequestParam String mode,@RequestParam String ref_id) {
		String correct="";
		correct =b_service.payBill(bill_id,mode,ref_id);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "paySubscriptions";
		}
		return "adminDashboard";
	}
	@RequestMapping(value="/viewUnpaidBills",method=RequestMethod.GET)
	public String viewUnpaidBill(ModelMap m) throws SQLException {
		m.put("Bills", b_service.unpaidretrive());
		return "viewUnpaidBills";
	}
	@RequestMapping(value="/viewUnpaidGrocery",method=RequestMethod.GET)
	public String undelivered(ModelMap m) throws SQLException {
		m.put("Bills", g_service.not_delivered());
		return "viewUnpaidGrocery";
	}
	@RequestMapping(value="/viewPaidGrocery",method=RequestMethod.GET)
	public String delivered(ModelMap m) throws SQLException {
		m.put("Bills", g_service.delivered());
		return "viewPaidGrocery";
	}
	@RequestMapping(value="/deliver",method=RequestMethod.GET)
	public String deliver(ModelMap m,@RequestParam int id) throws SQLException {
		g_service.deliver(id);
		return "redirect:viewUnpaidGrocery";
	}
	@RequestMapping(value="/viewResidents",method=RequestMethod.GET)
	public String viewResidents(ModelMap m) throws SQLException {
		m.put("Residents", r_service.viewAll());
		return "viewResidents";
	}
	@RequestMapping(value="/visitorCheckIn",method=RequestMethod.GET)
	public String getvisitorCheckIn(ModelMap m) {
		return "visitorCheckIn";
	}
	@RequestMapping(value="/visitorCheckIn",method=RequestMethod.POST)
	public String visitorCheckIn(ModelMap m,@RequestParam String vis_name,@RequestParam String phone,@RequestParam String r_id) throws SQLException {
		String correct="";
		correct =checkInService.validate(vis_name,phone,r_id);
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "visitorCheckIn";
		}
		return "adminDashboard";
	}
}
