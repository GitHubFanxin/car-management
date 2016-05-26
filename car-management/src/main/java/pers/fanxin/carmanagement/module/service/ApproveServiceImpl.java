package pers.fanxin.carmanagement.module.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.ApplicationDAO;
import pers.fanxin.carmanagement.module.dao.ApproveDAO;
import pers.fanxin.carmanagement.module.dao.CarDAO;
import pers.fanxin.carmanagement.module.dao.DriverDAO;
import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.entity.Approve;
import pers.fanxin.carmanagement.module.entity.Car;
import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;

@Service
public class ApproveServiceImpl implements ApproveService {

	@Autowired
	private ApproveDAO approveDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RouteLogDAO routeLogDAO;
	@Autowired
	private CarDAO carDAO;
	@Autowired
	private RoleDAO roleDAO;
	@Autowired
	private DriverDAO driverDAO;

	private User getCurrentUser() {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return userDAO.findByName(username);
	}

	@Override
	public void updateApprove(Approve approve) {
		approveDAO.updateApprove(approve);
	}

	@Override
	public void deleteApprove(Approve approve) {
		approveDAO.deleteApprove(approve);
	}

	@Override
	public List<Approve> findApproveByPage(int offset, int pageSize,
			String condition) {
		return approveDAO.findApproveByPage(offset, pageSize, condition);
	}

	@Override
	public Approve getApproveById(long id) {
		return approveDAO.getApproveById(id);
	}

	@Override
	public long findCount(String condition) {
		return approveDAO.findCount(condition);
	}

	@Override
	public Long approve(long ApplicationId) {
		User currentUser = getCurrentUser();
		Application application = applicationDAO
				.getApplicationById(ApplicationId);
		if (application.getApprove() != null) {
			Approve approve = new Approve();
			approve.setApplication(application);
			approve.setApproveDate(new Date());
			approve.setApproverId(currentUser.getUserId());
			approve.setApproverName(currentUser.getRealname());
			application.setApprove(approve);
			application.setState("pass");
			applicationDAO.update(application);
			return approveDAO.createApprove(approve);
		}
		return null;
	}

	@Override
	public Long approve(long ApplicationId, long carId, long driverId) {
		User currentUser = getCurrentUser();
		Application application = applicationDAO
				.getApplicationById(ApplicationId);
		if (application.getApprove() == null) {// 等于null，没有对应的审核表，即未审核
			// 设置审核表信息
			Approve approve = new Approve();
			approve.setApplication(application);
			approve.setApproveDate(new Date());
			approve.setApproverId(currentUser.getUserId());
			approve.setApproverName(currentUser.getRealname());
			// 新建行程日志
			RouteLog routeLog = new RouteLog();
			routeLog.setApplication(application);
			Car car = carDAO.getCarById(carId);
			car.setState("wait");// 状态改为使用中
			routeLog.setCar(car);
			Driver driver = driverDAO.getDriverByDriverId(driverId);
			routeLog.setDriverId(driver.getUserId());
			routeLog.setDriverName(driver.getRealname());
			routeLog.setPassengerId(application.getApplicantId());
			routeLog.setPassengerName(application.getApplicantName());
			routeLog.setStartpoint(application.getStartpoint());
			routeLog.setDestination(application.getDestination());
			routeLog.setRoundtrip(application.isRoundtrip());
			routeLog.setStartDate(application.getStartDate());

			application.setApprove(approve);
			application.setRouteLog(routeLog);
			application.setState("pass");
			routeLogDAO.createRouteLog(routeLog);
			applicationDAO.update(application);
			return approveDAO.createApprove(approve);
		}
		return null;
	}

	@Override
	public List<User> findDrivers() {
		Role role = roleDAO.getRoleByName("driver");
		List<User> users = new ArrayList<User>();
		role.getUser().addAll(users);
		return users;
	}

}
