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

	@Override
	public List<Role> findRoleByPage(int offset, int pageSize, String condition) {
		String hql;
		if(condition==null||condition==""){
			hql = "from "+Role.class.getSimpleName();
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from "+Role.class.getSimpleName()+" where roleName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%");
		}
	}

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l ;
		if(condition==null||condition==""){
			hql = "select count(*) from "+Role.class.getSimpleName();
			l = find(hql);
		}else{
			hql = "select count(*) from "+Role.class.getSimpleName()+" where roleName like ?";
			l = find(hql,"%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}
}
