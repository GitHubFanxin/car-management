package pers.fanxin.carmanagement.security.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.service.UserService;
import pers.fanxin.carmanagement.security.utils.UserHelper;

@Controller
public class UserManageController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("userlist")
	@ResponseBody
	public Object userList(HttpServletRequest request,int limit,int offset,String search){
		List<User> users = userService.findUserByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for(User user:users){
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("id", user.getUserId());
			result.put("username", user.getUsername());
			result.put("email", user.getEmail());
			result.put("phone", user.getPhone());
			result.put("role", UserHelper.getUserRole(user));
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(userService.findCount(search));
		return page;
	}
	
	@RequestMapping("useradd")
	@ResponseBody
	public Object userAdd(HttpServletRequest request,@RequestBody User user){
		User users = user;
		return "fail";
	}
}
