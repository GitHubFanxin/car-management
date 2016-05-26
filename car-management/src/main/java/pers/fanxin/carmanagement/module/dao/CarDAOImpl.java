package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Car;

@Repository
public class CarDAOImpl extends BaseHibernateDAO<Car> implements CarDAO {

	@Override
	public Long createCar(Car car) {
		return (Long) save(car);
	}

	@Override
	public void updateCar(Car car) {
		this.update(car);
	}

	@Override
	public void deleteCar(Car car) {
		this.delete(car);
	}

	@Override
	public List<Car> findCarsByPage(int offset, int pageSize, String condition) {
		String hql;
		if (condition == "" || condition == null) {
			hql = "from Car order by carNum";
			return findByPage(hql, offset, pageSize);
		} else {
			hql = "from Car where carName like ? or carNum like ? order by carNum";
			return findByPage(hql, offset, pageSize, "%" + condition + "%", "%"
					+ condition + "%");
		}
	}

	@Override
	public Car getCarById(long id) {
		String hql = "from Car where carId=?";
		List<Car> cars = this.find(hql, id);
		if (!cars.isEmpty()) {
			return cars.get(0);
		}
		return null;
	}

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l;
		if (condition == null || condition == "") {
			hql = "select count(*) from Car";
			l = find(hql);
		} else {
			hql = "select count(*) from Car where carName like ? or carNum like ?";
			l = find(hql, "%" + condition + "%", "%" + condition + "%");
		}
		if (l != null && l.size() == 1) {
			return (Long) l.get(0);
		}
		return 0;
	}

}
