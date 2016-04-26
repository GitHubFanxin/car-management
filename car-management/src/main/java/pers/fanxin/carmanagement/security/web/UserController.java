package pers.fanxin.carmanagement.security.web;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.service.UserService;

//@Controller
//@SessionAttributes("user")
public class UserController {
//	private UserService userService;
//	
//	@Autowired
//	public UserController(UserService userServiceImpl) {
//		this.userService = userServiceImpl;
//	}
//	
//	 @RequestMapping("/hello1")
//	    public String hello1() {
//	        SecurityUtils.getSubject().checkRole("admin");
//	        return "success";
//	    }
//
//	    @RequiresRoles("admin")
//	    @RequestMapping("/hello2")
//	    public String hello2() {
//	        return "success";
//	    }
}
