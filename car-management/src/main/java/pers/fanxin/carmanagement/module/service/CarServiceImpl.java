package pers.fanxin.carmanagement.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.CarDAO;
import pers.fanxin.carmanagement.module.entity.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDAO carDAO;

	@Override
	public Long createCar(Car car) {
		return carDAO.createCar(car);
	}

	@Override
	public void updateCar(Car car) {
		carDAO.updateCar(car);
	}

	@Override
	public void deleteCar(Car car) {
		carDAO.deleteCar(car);
	}

	@Override
	public List<Car> findCarsByPage(int offset, int pageSize, String condition) {
		return carDAO.findCarsByPage(offset, pageSize, condition);
	}

	@Override
	public Car getCarById(long id) {
		return carDAO.getCarById(id);
	}

	@Override
	public long findCount(String condition) {
		return carDAO.findCount(condition);
	}

}
