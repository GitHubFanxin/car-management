package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.module.vo.CurrentRouteVO;

public interface DriverService {
	public Long createDriver(Driver driver);

	public void updateDriver(Driver driver);

	public void deleteDriver(Driver driver);

	public List<Driver> findDriversByPage(int offset, int pageSize,
			String condition);

	public long findCount(String condition);

	public Driver getDriverByDriverId(long id);

	public Driver getDriverByUserId(long id);

	/**
	 * 当前司机开始（接受）任务
	 * 
	 * void
	 */
	public void driveAccept(long routeLogId);

	/**
	 * 当前司机标注完成任务 void
	 */
	public void driveEnd(double cost);

	/**
	 * 获得当前用户（司机）的所有新任务
	 * 
	 * @param offset
	 * @param pageSize
	 * @return List<RouteLog>
	 */
	public List<RouteLog> findNewTask(int offset, int pageSize);

	/**
	 * 获得当前用户（司机）的所有新任务数量
	 * 
	 * @return long
	 */
	public long findNewTaskCount();

	/**
	 * 获得当前用户（司机）的所有任务
	 * 
	 * @param offset
	 * @param pageSize
	 * @return List<RouteLog>
	 */
	public List<RouteLog> findTask(int offset, int pageSize);

	/**
	 * 获得当前用户（司机）的所有任务数量
	 * 
	 * @return long
	 */
	public long findTaskCount();
}
