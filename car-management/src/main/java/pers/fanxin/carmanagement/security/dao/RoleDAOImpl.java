package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.security.entity.Role;

@Repository
public class RoleDAOImpl extends BaseHibernateDAO<Role> implements RoleDAO{

	@Override
	public Long createRole(Role role) {
		return (Long)this.save(role);
	}

	@Override
	public void deleteRole(Long id) {
//		Role role = getRoleById(id);
//		this.delete(role);
		SQLQuery query = this.getSessionFactory().getCurrentSession().createSQLQuery("delete from role_permission where role_permission.role_id=?");
		query.setParameter(0, id);
		query.executeUpdate();
		query = this.getSessionFactory().getCurrentSession().createSQLQuery("delete from t_role where role_id=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@Override
	public void updateRole(Role role) {
		this.update(role);
	}

	@Override
	public Role getRoleById(Long id) {
		String hql = "from "+Role.class.getSimpleName()+" where roleId=?";
		List<Role> roles = this.find(hql, id);
		if(!roles.isEmpty()){
			return roles.get(0);
		}
		return null;
	}

	@Override
	public void deleteRole(Role role) {
		this.deleteRole(role.getRoleId());
	}
}
