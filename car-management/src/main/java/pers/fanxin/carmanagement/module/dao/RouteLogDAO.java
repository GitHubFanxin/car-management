package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.module.entity.RouteLog;

public interface RouteLogDAO extends BaseDAO<RouteLog>{
	public Long createRouteLog(RouteLog routeLog);
	public void updateRouteLog(RouteLog routeLog);
	public void deleteRouteLog(RouteLog routeLog);
	public RouteLog getRouteLogById(long id);
	public List<RouteLog> findRouteLogsByPage(int offset, int pageSize, String condition);
}
