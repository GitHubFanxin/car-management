package pers.fanxin.carmanagement.security.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.service.PermissionService;
import pers.fanxin.carmanagement.security.service.RoleService;
import pers.fanxin.carmanagement.security.vo.RoleVO;
import pers.fanxin.carmanagement.security.vo.UserVO;

@Controller
@RequestMapping("/basedata")
@RequiresRoles("admin")
public class RoleManageController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private PermissionService permissionService;

	@RequiresRoles("admin")
	@RequestMapping("/role")
	public String roleManage() {
		SecurityUtils.getSubject().checkRole("admin");
		return "role_manage";
	}

	@RequestMapping("/role/list")
	@ResponseBody
	public Object roleList(HttpServletRequest request, int limit, int offset,
			String search) {
		SecurityUtils.getSubject().checkRole("admin");
		List<Role> roles = roleService.findRoleByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for (Role role : roles) {
			Map<String, Object> result = new HashMap<String, Object>();
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

	@RequestMapping("/role/add")
	@ResponseBody
	public Object roleAdd(@RequestBody RoleVO roleVO) {
		if (roleService.createRole(roleVO) > 0) {
			return "{'state':true}";
		}
		return "{'state':false,'errMsg':'添加角色失败'}";
	}

	@RequestMapping("/role/edit")
	@ResponseBody
	public Object roleEdit(@RequestBody RoleVO roleVO) {
		roleService.updateRole(roleVO);
		return "{'state':true}";
	}

	@RequestMapping("/role/delete")
	@ResponseBody
	public Object roleDelete(@RequestBody Role role) {
		roleService.deleteRole(role.getRoleId());
		return "{'state':true}";
	}
	
	@RequestMapping("/role/permissiontree")
	@ResponseBody
	public Object permissionTree(@RequestBody RoleVO roleVO) {
		Set<Permission> curPermissions;
		if (roleVO.getRoleId() > 0) {
			curPermissions = roleService.findRoleById(roleVO.getRoleId()).getPermissions();
		}else{
			curPermissions = new HashSet<Permission>();
		}
		List<Permission> allPermissions = permissionService.getAllPermission();
		List<Object> nodes = new ArrayList<Object>();
		List<Object> tree = new ArrayList<Object>();
		Map<String, Object> root = new HashMap<String, Object>();
		Map<String, Boolean> checked = new HashMap<String, Boolean>();
		checked.put("checked", true);
		for(Permission permission : allPermissions){
			Map<String, Object> node = new HashMap<String, Object>();
			node.put("permission", permission.getPermission());
			node.put("text", permission.getDescription());
			if (curPermissions.contains(permission)) {
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
