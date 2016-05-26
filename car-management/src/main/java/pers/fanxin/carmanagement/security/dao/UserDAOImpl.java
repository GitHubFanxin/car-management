package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.security.entity.User;

@Repository
public class UserDAOImpl extends BaseHibernateDAO<User> implements UserDAO {

	@Override
	public User findByName(String username) {
		List<User> users;
		users = this.find("from " + User.class.getSimpleName()
				+ " where username=?", username);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Long createUser(User user) {
		return (Long) save(user);
	}

	@Override
	public void deleteUser(Long id) {
		SQLQuery query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery("delete from user_role where user_id=?");
		query.setParameter(0, id);
		query.executeUpdate();
		query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery("delete from t_user where user_id=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

	@Override
	public void updateUser(User user) {
		this.update(user);
	}

	@Override
	public void deleteUser(User user) {
		this.deleteUser(user.getUserId());
	}

	@Override
	public User getUserById(Long id) {
		String hql = "from " + User.class.getSimpleName() + " where userId=?";
		List<User> users = this.find(hql, id);
		if (!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> findUserByPage(int offset, int pageSize, String condition) {
		String hql;
		if (condition == "" || condition == null) {
			hql = "from " + User.class.getSimpleName() + " order by workNum";
			return findByPage(hql, offset, pageSize);
		} else {
			hql = "from "
					+ User.class.getSimpleName()
					+ " where username like ? or realname like ? or department like ? or workNum like ? order by workNum";
			return findByPage(hql, offset, pageSize, "%" + condition + "%", "%"
					+ condition + "%", "%" + condition + "%", "%" + condition
					+ "%");
		}
	}

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l;
		if (condition == "" || condition == null) {
			hql = "select count(*) from " + User.class.getSimpleName();
			l = find(hql);
		} else {
			hql = "select count(*) from "
					+ User.class.getSimpleName()
					+ " where username like ? or realname like ? or department like ? or workNum like ? ";
			l = find(hql, "%" + condition + "%", "%" + condition + "%", "%"
					+ condition + "%", "%" + condition + "%");
		}
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}
}
