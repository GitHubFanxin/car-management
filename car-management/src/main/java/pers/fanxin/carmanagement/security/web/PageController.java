package pers.fanxin.carmanagement.security.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

	@RequestMapping("/home")
	public String home() {
        return "home";
    } 
	@RequestMapping("/track")
	public String track() {
		SecurityUtils.getSubject().checkPermission("visit:track");
        return "track";
    } 
	@RequestMapping("/user-manage")
	public String usermanage(){
		SecurityUtils.getSubject().checkPermission("visit:user");
		return "user_manage";
	}
	@RequestMapping("/role-manage")
	public String rolemanage(){
		return "role_manage";
	}
	@RequestMapping("/approve")
	public String approve(){
		return "approve";
	}
	@RequestMapping(value = "/application-form", method = RequestMethod.GET)
	public String applicationform(){
		return "application_form";
	}
	@RequestMapping("/myapplication")
	public String application(){
		return "application";
	}
	@RequestMapping("/car-manage")
	public String carmanage(){
		return "car_manage";
	}
	@RequestMapping("/driver-manage")
	public String drivermanage(){
		return "driver_manage";
	}
	@RequestMapping("/mynewtask")
	public String mynewtask(){
		return "myNewTask";
	}
	@RequestMapping("/mytaskhistory")
	public String mytaskhistory(){
		return "myTaskHistory";
	}
	@RequestMapping("/myUseHistory")
	public String myUseHistory(){
		return "myUseHistory";
	}
}
