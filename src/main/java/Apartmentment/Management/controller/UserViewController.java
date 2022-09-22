package Apartmentment.Management.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Apartmentment.Management.service.GoodsService;
import Apartmentment.Management.service.ViewBillsService;
import Apartmentment.Management.service.ViewVisitorsService;

@Controller
@SessionAttributes("name")
public class UserViewController {
	@Autowired
	ViewBillsService billService;
	@Autowired
	ViewVisitorsService visitorService;
	@Autowired
	GoodsService g_service;
	@RequestMapping(value="/viewBills", method = RequestMethod.GET)
	public String showBills(ModelMap m) throws SQLException{
		String name=(String)m.get("name");
		m.put("Bills", billService.retrive(name));
		return "viewBills";	
	}
	@RequestMapping(value="/viewVisitors", method = RequestMethod.GET)
	public String showVisitors(ModelMap m) throws Exception{
		String name=(String)m.get("name");
		m.put("Visitors", visitorService.retrive(name));
		return "viewVisitors";	
	}
	@RequestMapping(value="/orderGrocery",method=RequestMethod.GET)
	public String addBill(ModelMap m) {
		m.put("Goods", g_service.show());
		return "orderGrocery";
	}
	@RequestMapping(value="/orderGrocery",method=RequestMethod.POST)
	public String addBill(ModelMap m,@RequestParam String car,@RequestParam String beet,@RequestParam String milk,@RequestParam String tomato) {
		String correct="";
		m.put("Goods", g_service.show());
		correct =g_service.order(car,beet,milk,tomato,Integer.parseInt((String)m.get("name")));
		if(!correct.equals("success")) {
			m.put("message", correct);
			return "orderGrocery";
		}
		return "welcome";
	}
	@RequestMapping(value="/viewAllOrders", method = RequestMethod.GET)
	public String viewAll(ModelMap m) throws Exception{
		m.put("Bills", g_service.viewAll(Integer.parseInt((String)m.get("name"))));
		return "viewAllOrders";	
	}
}
