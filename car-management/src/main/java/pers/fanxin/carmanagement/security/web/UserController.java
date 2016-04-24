package pers.fanxin.carmanagement.security.web;

import java.util.HashSet;
import java.util.Set;

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

@Controller
@SessionAttributes("user")
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userServiceImpl) {
		this.userService = userServiceImpl;
	}
	
	@RequestMapping(value="/adduser",method=RequestMethod.GET)
	public String submitAddUser(){
//		//userService.addUser(user);
//		User user = new User();
//		Role r = new Role();
//		Permission p = new Permission();
//		Permission p2 = new Permission();
//		p.setDescription("功能模块1");
//		p.setPermission("user:add");
//		p.setAvailable(Boolean.TRUE);
//		p2.setDescription("功能模块2");
//		p2.setPermission("user:add");
//		p2.setAvailable(Boolean.FALSE);
//		r.setRoleName("role1");
//		r.setDsc("这是角色1");
//		Set sp = new HashSet<Permission>();
//		sp.add(p);
//		sp.add(p2);
//		r.setPrivileges(sp);
//		user.setUsername("鑫");
//		user.setRole(new HashSet<Role>());
//		user.getRole().add(r);
////		userService.addUser(user);
		return "0";
	}
}
