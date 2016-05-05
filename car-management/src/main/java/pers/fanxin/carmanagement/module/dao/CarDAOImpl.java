package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Car;

public class CarDAOImpl extends BaseHibernateDAO<Car> 
	implements CarDAO{

	@Override
	public Long createCar(Car car) {
		return (Long)save(car); 
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
		if(condition==""||condition==null){
			hql = "from "+Car.class.getSimpleName();
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from "+Car.class.getSimpleName()+" where carName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%");
		}
	}

	@Override
	public Car getCarById(long id) {
		String hql = "from "+Car.class.getSimpleName()+" where carId=?";
		List<Car> cars = this.find(hql, id);
		if(!cars.isEmpty()){
			return cars.get(0);
		}
		return null;
	}

}
