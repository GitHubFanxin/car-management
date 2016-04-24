package pers.fanxin.carmanagement.security.service;

import pers.fanxin.carmanagement.security.entity.Role;

public class RoleServiceImpl implements RoleService{

	@Override
	public Long createRole(String rolename, String description) {
		Role role = new Role();
		role.setRoleName(rolename);
		role.setDescription(description);
		return null;
	}

	@Override
	public void deleteRole(Long id) {
		this.deleteRole(id);
	}

	@Override
	public void updateRole(Role role) {
		this.updateRole(role);
	}

}
