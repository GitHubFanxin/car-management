package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Driver;

@Repository
public class DriverDAOImpl extends BaseHibernateDAO<Driver> implements
		DriverDAO {

	@Override
	public Long createDriver(Driver driver) {
		return (Long) save(driver);
	}

	@Override
	public void updateDriver(Driver driver) {
		this.update(driver);
	}

	@Override
	public void deleteDriver(Driver driver) {
		this.delete(driver);
	}

	@Override
	public List<Driver> findDriversByPage(int offset, int pageSize,
			String condition) {
		String hql;
		if (condition == "" || condition == null) {
			hql = "from Driver";
			return findByPage(hql, offset, pageSize);
		} else {
			hql = "from Driver where realname like ?";
			return findByPage(hql, offset, pageSize, "%" + condition + "%");
		}
	}

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l;
		if (condition == null || condition == "") {
			hql = "select count(*) from Driver";
			l = find(hql);
		} else {
			hql = "select count(*) from Driver where realname like ?";
			l = find(hql, "%" + condition + "%");
		}
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

	@Override
	public Driver getDriverByDriverId(long id) {
		String hql = "from Driver where driverId=?";
		List<Driver> drivers = this.find(hql, id);
		if (!drivers.isEmpty()) {
			return drivers.get(0);
		}
		return null;
	}

	@Override
	public Driver getDriverByUserId(long id) {
		String hql = "from Driver where userId=?";
		List<Driver> drivers = this.find(hql, id);
		if (!drivers.isEmpty()) {
			return drivers.get(0);
		}
		return null;
	}

	@Override
	public void deleteDriverByUserId(long id) {
		SQLQuery query = this.getSessionFactory().getCurrentSession()
				.createSQLQuery("delete from t_driver where user_id=?");
		query.setParameter(0, id);
		query.executeUpdate();
	}

}
