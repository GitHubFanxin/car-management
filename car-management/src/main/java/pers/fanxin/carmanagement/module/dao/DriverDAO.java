package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.module.entity.Driver;

public interface DriverDAO extends BaseDAO<Driver>{
	public Long createDriver(Driver driver);
	public void updateDriver(Driver driver);
	public void deleteDriver(Driver driver);
	public List<Driver> findDriversByPage(int offset, int pageSize, String condition);
	public long findCount(String condition);
	/**
	 * 通过driverId获得driver对象
	 * @param id
	 * @return   
	 * Driver
	 */
	public Driver getDriverByDriverId(long id);
/**
 * 通过userId获得driver对象
 * @param id
 * @return   
 * Driver
 */
	public Driver getDriverByUserId(long id);
	public void deleteDriverByUserId(long id);
}
