package pers.fanxin.carmanagement.security.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/index")
    public String hello1() {
        SecurityUtils.getSubject().checkRole("admin");
        return "index";
    }

    @RequiresRoles("admin")
    @RequestMapping("/hello2")
    public String hello2() {
        return "success";
    }
    
//    @RequestMapping("/logoutSuccess")
//    public String logout() {
//    	return "logoutSuccess";
//    }
}
