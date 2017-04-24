package com.bboss.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bboss.model.Auth;
import com.bboss.service.AuthService;
import com.bboss.service.RoleService;
import com.bboss.util.JsonUtil;


@Controller
public class IndexAction{

	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		return "login";
	}	
	
	
}
