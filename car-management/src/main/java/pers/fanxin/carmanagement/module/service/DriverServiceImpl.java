package pers.fanxin.carmanagement.module.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.DriverDAO;
import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDAO driverDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RouteLogDAO routeLogDAO;

	@Override
	public Long createDriver(Driver driver) {
		return driverDAO.createDriver(driver);
	}

	@Override
	public void updateDriver(Driver driver) {
		driverDAO.updateDriver(driver);
	}

	@Override
	public void deleteDriver(Driver driver) {
		driverDAO.deleteDriver(driver);
	}

	@Override
	public List<Driver> findDriversByPage(int offset, int pageSize,
			String condition) {
		return driverDAO.findDriversByPage(offset, pageSize, condition);
	}

	@Override
	public long findCount(String condition) {
		return driverDAO.findCount(condition);
	}

	@Override
	public Driver getDriverByDriverId(long id) {
		return driverDAO.getDriverByDriverId(id);
	}

	@Override
	public Driver getDriverByUserId(long id) {
		return driverDAO.getDriverByUserId(id);
	}

	@Override
	public void driveAccept(long routeLogId) {
		Driver driver = driverDAO.getDriverByUserId(getCurrentUser()
				.getUserId());

		if (routeLogDAO.findDriverCurrentRoute(driver.getUserId()) == null) {
			RouteLog routeLog = routeLogDAO.getRouteLogById(routeLogId);
			routeLog.setState("inprogress");
			driver.setState("working");
			driverDAO.update(driver);
		}
	}

	@Override
	public void driveEnd(double cost) {
		Driver driver = driverDAO.getDriverByUserId(getCurrentUser()
				.getUserId());
		RouteLog routeLog = routeLogDAO.findDriverCurrentRoute(driver
				.getUserId());
		routeLog.setState("completed");
		routeLog.setCost(cost);
		routeLog.setEndDate(new Date());
		routeLogDAO.update(routeLog);
		driver.setState("free");
		driverDAO.update(driver);
	}

	private User getCurrentUser() {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return userDAO.findByName(username);
	}

	@Override
	public List<RouteLog> findNewTask(int offset, int pageSize) {
		User driver = getCurrentUser();
		return routeLogDAO.findNewRouteLogByDriverId(driver.getUserId(),
				offset, pageSize);
	}

	@Override
	public long findNewTaskCount() {
		User driver = getCurrentUser();
		return routeLogDAO.findNewCountByDriverId(driver.getUserId());
	}

	@Override
	public List<RouteLog> findTask(int offset, int pageSize) {
		User driver = getCurrentUser();
		return routeLogDAO.findRouteLogByDriverId(driver.getUserId(), offset,
				pageSize);
	}

	@Override
	public long findTaskCount() {
		User driver = getCurrentUser();
		return routeLogDAO.findCountByDriverId(driver.getUserId());
	}
}
