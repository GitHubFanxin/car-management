package pers.fanxin.carmanagement.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.entity.Role;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDAO roleDAO;
	
	@Override
	public Long createRole(String rolename, String description) {
		Role role = new Role();
		role.setRoleName(rolename);
		role.setDescription(description);
		return roleDAO.createRole(role);
	}

	@Override
	public void deleteRole(Long id) {
		roleDAO.deleteRole(id);
	}

	@Override
	public void updateRole(Role role) {
		roleDAO.updateRole(role);
	}

	@Override
	public List<Role> findRoleByPage(int offset, int pageSize, String condition) {
		return roleDAO.findRoleByPage(offset, pageSize, condition);
	}

	@Override
	public long findCount(String condition) {
		return roleDAO.findCount(condition);
	}

}
