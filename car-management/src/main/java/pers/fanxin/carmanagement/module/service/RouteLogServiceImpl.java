package pers.fanxin.carmanagement.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.RouteLog;
@Service
public class RouteLogServiceImpl implements RouteLogService{

	@Autowired
	private RouteLogDAO routeLogDAO;
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

}
