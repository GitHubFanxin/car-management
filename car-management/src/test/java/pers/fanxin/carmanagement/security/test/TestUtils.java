package pers.fanxin.carmanagement.security.test;

import java.util.HashSet;
import java.util.Set;

import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;

public class TestUtils {
	public Permission getPermissionCase(String permission, String description,Boolean available){
		Permission p = new Permission();
		p.setPermission(permission);
		p.setDescription(description);
		p.setAvailable(available);
		return p;
	}
	public Set<Permission> getPermissionsCase(){
		Set<Permission> permissions = new HashSet<Permission>();
		permissions.add(getPermissionCase("user:add","添加",true));
		permissions.add(getPermissionCase("user:delete","删除",false));
		permissions.add(getPermissionCase("user:view","查看",false));
		permissions.add(getPermissionCase("user:update","更新",false));
		return permissions;
	}
	
	public Role getRoleCase(String rolename, String description){
		Role r = new Role();
		r.setRoleName(rolename+"test");
		r.setDescription(description+"test");
		return r;
	}
	public User getUserCase(){
		User user = new User();
		user.setUsername("testuser");
		user.setPassword("123");
		user.setRealname("测试用户");
		return user;
	}
}
