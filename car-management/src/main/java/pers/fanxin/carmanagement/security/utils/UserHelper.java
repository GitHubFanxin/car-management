package pers.fanxin.carmanagement.security.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;

public class UserHelper {
	/**
	 * 获得用户角色
	 * 
	 * @param user
	 * @return String
	 */
	public static String getUserRole(User user) {
		StringBuffer roles = new StringBuffer();
		Iterator<Role> iterator = user.getRole().iterator();
		while (iterator.hasNext()) {
			roles.append(iterator.next().getRoleName());
			if (iterator.hasNext())
				roles.append(", ");
		}
		return roles.toString();
	}

	public static Set<String> getUserRoleSet(User user) {
		Set<String> roles = new HashSet<String>();
		Iterator<Role> iterator = user.getRole().iterator();
		while (iterator.hasNext()) {
			roles.add(iterator.next().getRoleName());
		}
		return roles;
	}

	/**
	 * 获得角色的权限
	 * 
	 * @param role
	 * @return String
	 */
	public static String getRolePermissions(Role role) {
		StringBuffer permissions = new StringBuffer();
		Iterator<Permission> iterator = role.getPermissions().iterator();
		while (iterator.hasNext()) {
			permissions.append(iterator.next().getPermission());
			if (iterator.hasNext())
				permissions.append(",");
		}
		return permissions.toString();
	}

	/**
	 * 获得用户的所有权限
	 * 
	 * @param user
	 * @return String
	 */
	public static String getUserPermission(User user) {
		StringBuffer permissions = new StringBuffer();
		Iterator<Role> roleIterator = user.getRole().iterator();
		while (roleIterator.hasNext()) {
			Iterator<Permission> permissionIterator = roleIterator.next()
					.getPermissions().iterator();
			while (permissionIterator.hasNext()) {
				permissions.append(permissionIterator.next().getPermission());
				if (roleIterator.hasNext() || permissionIterator.hasNext())
					permissions.append(",");
			}
		}
		return permissions.toString();
	}

	public static Set<String> getUserPermissionsSet(User user) {
		Set<String> permissions = new HashSet<String>();
		Iterator<Role> roleIterator = user.getRole().iterator();
		while (roleIterator.hasNext()) {
			Iterator<Permission> permissionIterator = roleIterator.next()
					.getPermissions().iterator();
			while (permissionIterator.hasNext()) {
				Permission permission = permissionIterator.next();
				if (permission.getAvailable()) {
					permissions.add(permission.getPermission());
				}
			}
		}
		return permissions;
	}
}
