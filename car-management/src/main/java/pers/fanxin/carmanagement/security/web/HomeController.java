package pers.fanxin.carmanagement.security.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/index")
    public String hello1() {
        SecurityUtils.getSubject().checkRole("admin");
        return "index";
    }
	
	@RequestMapping("/home")
	public String home() {
        return "home";
    }    
}
