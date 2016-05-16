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
	
	/** 过得对应用户（司机）的所有行程
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public List<RouteLog> findRouteLogByDriverId(long id,int offset, int pageSize);
	/** 过得对应用户（司机）的所有行程数量
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public long findCountByDriverId(long id);
	/** 过得对应用户（司机）的所有新行程
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public List<RouteLog> findNewRouteLogByDriverId(long id,int offset, int pageSize);
	/** 过得对应用户（司机）的所有新行程表数量
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public long findNewCountByDriverId(long id);
	
	public RouteLog findPassengerCurrentRoute(long userId);
	
	public RouteLog findDriverCurrentRoute(long userId);
	
	/** 过得对应用户（乘客）的所有行程
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public List<RouteLog> findRouteLogByPassengerId(long id,int offset, int pageSize);
	/** 过得对应用户（乘客）的所有行程数量
	 * @param id 用户id，userid
	 * @return   
	 * Approve
	 */
	public long findCountByPassengerId(long id);
}
