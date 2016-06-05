package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.security.entity.Permission;

@Repository
public class PermissionDAOImpl extends BaseHibernateDAO<Permission> implements
		PermissionDAO {

	@Override
	public Long createPermission(Permission permission) {
		return (Long) this.save(permission);
	}

	@Override
	public void deletePermission(Long id) {
		Permission permission = this.getPermissionById(id);
		this.delete(permission);
	}

	@Override
	public void updatePermission(Permission permission) {
		this.update(permission);
	}

	@Override
	public Permission getPermissionById(Long id) {
		String hql = "from " + Permission.class.getSimpleName()
				+ " where permissionId=?";
		List<Permission> permissions = this.find(hql, id);
		if (!permissions.isEmpty()) {
			return permissions.get(0);
		}
		return null;
	}

	@Override
	public List<Permission> getAllPermissions() {
		return this.findAll(Permission.class);
	}

	@Override
	public Permission findPermissionByName(String permission) {
		String hql = "from Permission where permission=?";
		List<Permission> permissions = this.find(hql, permission);
		if (!permissions.isEmpty()) {
			return permissions.get(0);
		}
		return null;
	}

}
