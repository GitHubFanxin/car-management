package pers.fanxin.carmanagement.security.service;

import org.springframework.beans.factory.annotation.Autowired;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.entity.Permission;

public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDAO permissionDAO;
	
	@Override
	public Long creatPermission(String permission, String description) {
		Permission perm = new Permission();
		perm.setPermission(permission);
		perm.setDescription(description);
		return permissionDAO.createPermission(perm);
	}

	@Override
	public void deletePermission(Long id) {
		permissionDAO.deletePermission(id);
	}

	@Override
	public void updatePermission(Permission permission) {
		permissionDAO.updatePermission(permission);
	}

}
