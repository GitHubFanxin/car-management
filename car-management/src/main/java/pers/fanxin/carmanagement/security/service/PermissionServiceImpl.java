package pers.fanxin.carmanagement.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.entity.Permission;

@Service
public class PermissionServiceImpl implements PermissionService {

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

	@Override
	public List<Permission> getAllPermission() {
		return permissionDAO.findAll(Permission.class);
	}


}
