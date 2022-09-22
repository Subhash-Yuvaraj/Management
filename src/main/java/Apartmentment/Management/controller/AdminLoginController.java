package Apartmentment.Management.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import Apartmentment.Management.service.AdminLoginService;
@Controller
@SessionAttributes("name")
public class AdminLoginController {
	@Autowired
	AdminLoginService service;
	@RequestMapping(value="/adminLogin",method=RequestMethod.GET)
	public String loginMessage(ModelMap m) {
		return "adminLogin";
	}
	@RequestMapping(value="/adminDashboard",method=RequestMethod.GET)
	public String showDashboard(ModelMap m) {
		return "adminDashboard";
	}
	@RequestMapping(value="/adminLogin",method=RequestMethod.POST)
	public String afterLogin(ModelMap m,@RequestParam(required=false) String name,@RequestParam(required=false) String password) {
		boolean correct = false;
		try {
			correct = service.validate(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!correct) {
			m.put("message", "Invalid userId/Password");
			return "adminLogin";
		}
				
		m.put("name",name);
		m.put("password", password);
		return "adminDashboard";
	}
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request,
//			HttpServletResponse response) {
//		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext()
//				.getAuthentication();
//		if (auth != null) {
//			new SecurityContextLogoutHandler().logout(request, response, auth);
//		}
//		return "redirect:/";
//	}
}
