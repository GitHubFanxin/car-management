package pers.fanxin.carmanagement.module.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.module.vo.CurrentRouteVO;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;
@Service
public class RouteLogServiceImpl implements RouteLogService{

	@Autowired
	private RouteLogDAO routeLogDAO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Long createRouteLog(RouteLog routeLog) {
		return routeLogDAO.createRouteLog(routeLog);
	}

	@Override
	public void updateRouteLog(RouteLog routeLog) {
		routeLogDAO.updateRouteLog(routeLog);
	}

	@Override
	public void deleteRouteLog(RouteLog routeLog) {
		routeLogDAO.deleteRouteLog(routeLog);
	}

	@Override
	public RouteLog getRouteLogById(long id) {
		return routeLogDAO.getRouteLogById(id);
	}

	@Override
	public List<RouteLog> findRouteLogsByPage(int offset, int pageSize,
			String condition) {
		return routeLogDAO.findRouteLogsByPage(offset, pageSize, condition);
	}

	private User getCurrentUser(){
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		return userDAO.findByName(username);
	}
	
	@Override
	public CurrentRouteVO findPassengerCurrentRoute() {
		CurrentRouteVO currentRoute = new CurrentRouteVO();
		User passenger = getCurrentUser();
		RouteLog routelog = routeLogDAO.findPassengerCurrentRoute(passenger.getUserId());
		User driverUser = userDAO.getUserById(routelog.getPassengerId());
		currentRoute.setRouteId(routelog.getLogId());
		currentRoute.setPassengerName(passenger.getRealname());
		currentRoute.setRoundtrip(routelog.isRoundtrip());
		currentRoute.setPassengerPhone(passenger.getPhone());
		currentRoute.setDriverName(driverUser.getRealname());
		currentRoute.setDriverPhone(driverUser.getPhone());
		currentRoute.setDestination(routelog.getDestination());
		currentRoute.setStartpoint(routelog.getStartpoint());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		if(routelog.getStartDate()!=null)
			currentRoute.setDate(sdf.format(routelog.getStartDate()));
		return currentRoute;
	}

	@Override
	public CurrentRouteVO findDriverCurrentRoute() {
		CurrentRouteVO currentRoute = new CurrentRouteVO();
		User driverUser =  getCurrentUser();
		RouteLog routelog = routeLogDAO.findDriverCurrentRoute(driverUser.getUserId());
		if(routelog!=null){
			User passenger = userDAO.getUserById(routelog.getPassengerId());
			currentRoute.setRouteId(routelog.getLogId());
			currentRoute.setPassengerName(passenger.getRealname());
			currentRoute.setRoundtrip(routelog.isRoundtrip());
			currentRoute.setPassengerPhone(passenger.getPhone());
			currentRoute.setDriverName(driverUser.getRealname());
			currentRoute.setDriverPhone(driverUser.getPhone());
			currentRoute.setDestination(routelog.getDestination());
			currentRoute.setStartpoint(routelog.getStartpoint());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			if(routelog.getStartDate()!=null)
				currentRoute.setDate(sdf.format(routelog.getStartDate()));
			return currentRoute;
		}
		return null;
	}

	@Override
	public List<RouteLog> findCurrentDriverRouteLog(int offset,
			int pageSize) {
		User driverUser =  getCurrentUser();
		return routeLogDAO.findRouteLogByDriverId(driverUser.getUserId(), offset, pageSize);
	}

	@Override
	public long findCurrentDriverRouteLogCount() {
		User driverUser =  getCurrentUser();
		return routeLogDAO.findCountByDriverId(driverUser.getUserId());
	}

	@Override
	public List<RouteLog> findCurrentPassengerRouteLog(int offset,
			int pageSize) {
		User passengerUser =  getCurrentUser();
		return routeLogDAO.findRouteLogByPassengerId(passengerUser.getUserId(), offset, pageSize);
	}

	@Override
	public long findCurrentPassengerRouteLogCount() {
		User passengerUser =  getCurrentUser();
		return routeLogDAO.findCountByPassengerId(passengerUser.getUserId());
	}
}
