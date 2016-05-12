package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.module.entity.Car;

public interface CarDAO extends BaseDAO<Car>{
	public Long createCar(Car car);
	public void updateCar(Car car);
	public void deleteCar(Car car);
	public List<Car> findCarsByPage(int offset, int pageSize, String condition);
	public long findCount(String condition);
	public Car getCarById(long id);
}
