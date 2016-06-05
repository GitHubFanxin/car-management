package pers.fanxin.carmanagement.security.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.service.RoleService;
import pers.fanxin.carmanagement.security.service.UserService;
import pers.fanxin.carmanagement.security.utils.UserHelper;
import pers.fanxin.carmanagement.security.vo.UserVO;

@Controller
public class UserManageController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;


	@RequestMapping("/user/list")
	@ResponseBody
	public Object userList(HttpServletRequest request, int limit, int offset,
			String search) {
		List<User> users = userService.findUserByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for (User user : users) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("userId", user.getUserId());
			result.put("workNum", user.getWorkNum());
			result.put("payNum", user.getPayNum());
			result.put("realname", user.getRealname());
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

	@RequestMapping("/user/add")
	@ResponseBody
	public Object userAdd(HttpServletRequest request, @RequestBody UserVO userVO) {
		userService.createUser(userVO);
		return "fail";
	}

	@RequestMapping("/user/edit")
	@ResponseBody
	public Object roleEdit(@RequestBody UserVO userVO) {
		userService.updateUser(userVO);
		return "{'state':true}";
	}

	@RequestMapping("/user/delete")
	@ResponseBody
	public Object roleDelete(@RequestBody UserVO userVO) {
		userService.deleteUser(userVO.getUserId());
		return "{'state':true}";
	}

	@RequestMapping("/user/roletree")
	@ResponseBody
	public Object roleTree(@RequestBody UserVO userVO) {
		Set<Role> curRoles;
		if (userVO.getUserId() > 0) {
			curRoles = userService.findUserById(userVO.getUserId()).getRole();
		} else {
			curRoles = new HashSet<Role>();
		}
		List<Role> allRoles = roleService.getAllRoles();
		List<Object> nodes = new ArrayList<Object>();
		List<Object> tree = new ArrayList<Object>();
		Map<String, Object> root = new HashMap<String, Object>();
		Map<String, Boolean> checked = new HashMap<String, Boolean>();
		checked.put("checked", true);
		for (Role role : allRoles) {
			Map<String, Object> node = new HashMap<String, Object>();
			node.put("roleName", role.getRoleName());
			node.put("text", role.getDescription());
			if (curRoles.contains(role)) {
				node.put("state", checked);
			}
			nodes.add(node);
		}
		root.put("text", "权限树");
		root.put("nodes", nodes);
		tree.add(root);
		return tree;
	}
}
