package pers.fanxin.carmanagement.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.vo.RoleVO;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private PermissionDAO permissionDAO;

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
	public void updateRole(RoleVO roleVO) {
		Role role = roleDAO.getRoleById(roleVO.getRoleId());
		role.setDescription(roleVO.getDescription());
		role.setRoleId(roleVO.getRoleId());
		role.setRoleName(roleVO.getRoleName());
		String permissionString = roleVO.getPermissions();
		String[] permissionNames = permissionString.split(",");
	
		Set<Permission> permissions = new HashSet<Permission>();
		for(String  permissionName : permissionNames){
			Permission permission = permissionDAO.findPermissionByName(permissionName);
			permissions.add(permission);
		}
		if(!permissions.isEmpty()){
			role.setPermissions(permissions);
		}
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

	@Override
	public Long createRole(RoleVO roleVO) {
		Role role = new Role();
		role.setDescription(roleVO.getDescription());
		role.setRoleId(roleVO.getRoleId());
		role.setRoleName(roleVO.getRoleName());
		String permissionString = roleVO.getPermissions();
		String[] permissionNames = permissionString.split(",");
	
		Set<Permission> permissions = new HashSet<Permission>();
		for(String  permissionName : permissionNames){
			Permission permission = permissionDAO.findPermissionByName(permissionName);
			permissions.add(permission);
		}
		if(!permissions.isEmpty()){
			role.setPermissions(permissions);
		}
		return roleDAO.createRole(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleDAO.findAll(Role.class);
	}

	@Override
	public Role findRoleById(long id) {
		return roleDAO.getRoleById(id);
	}

}
