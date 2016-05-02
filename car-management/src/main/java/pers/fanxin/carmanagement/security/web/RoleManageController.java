package pers.fanxin.carmanagement.security.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.service.RoleService;

@Controller
public class RoleManageController {
	
	@Autowired
	private RoleService roleService;
	
	@RequiresRoles("admin")
	@RequestMapping("role_manage")
	public String roleManage(){
		return "role_manage";
	}
	
	@RequestMapping("rolelist")
	@ResponseBody
	public Object roleList(HttpServletRequest request,int limit,int offset,String search){
		List<Role> roles = roleService.findRoleByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for(Role role:roles){
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("roleId", role.getRoleId());
			result.put("roleName", role.getRoleName());
			result.put("description", role.getDescription());
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(roleService.findCount(search));
		return page;
	}
}
