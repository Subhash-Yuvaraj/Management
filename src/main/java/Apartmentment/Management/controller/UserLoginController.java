package Apartmentment.Management.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ResponseBody;
import Apartmentment.Management.service.LoginService;

@Controller


@SessionAttributes("name")
public class UserLoginController {
//	@Autowired
//	LoginService service;
//	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
//	public String loginMessage(ModelMap m) {
//		return "userlogin";
//	}
//	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
//	public String afterLogin(ModelMap m,@RequestParam(required=false) String name,@RequestParam(required=false) String password) throws SQLException {
//		boolean correct=service.validate(name, password);
//		if(!correct) {
//			m.put("message", "Invalid userId/Password");
//			return "userlogin";
//		}	
//		m.put("name",name);
//		m.put("password", password);
//		return "welcome";
//	}
	@Autowired
	LoginService service;
	@RequestMapping(value="/userlogin",method=RequestMethod.GET)
	public String loginMessage(ModelMap m) {
		return "userlogin";
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String showWelcome(ModelMap m) {
		return "welcome";
	}
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
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
			return "userlogin";
		}
				
		m.put("name",name);
		m.put("password", password);
		return "welcome";
	}
}
