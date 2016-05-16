package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.module.vo.CurrentRouteVO;

public interface RouteLogService {
	public Long createRouteLog(RouteLog routeLog);
	public void updateRouteLog(RouteLog routeLog);
	public void deleteRouteLog(RouteLog routeLog);
	public RouteLog getRouteLogById(long id);
	public List<RouteLog> findRouteLogsByPage(int offset, int pageSize, String condition);
	public CurrentRouteVO findPassengerCurrentRoute();
	public CurrentRouteVO findDriverCurrentRoute();

}
