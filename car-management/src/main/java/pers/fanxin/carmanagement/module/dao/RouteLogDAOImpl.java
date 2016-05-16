package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.RouteLog;
@Repository
public class RouteLogDAOImpl extends BaseHibernateDAO<RouteLog>
	implements RouteLogDAO{

	@Override
	public Long createRouteLog(RouteLog routeLog) {
		return (Long)save(routeLog);
	}

	@Override
	public void updateRouteLog(RouteLog routeLog) {
		this.update(routeLog);
	}

	@Override
	public void deleteRouteLog(RouteLog routeLog) {
		this.delete(routeLog);
	}

	@Override
	public RouteLog getRouteLogById(long id) {
		String hql = "from "+RouteLog.class.getSimpleName()+" where logId=?";
		List<RouteLog> routeLogs = this.find(hql, id);
		if(!routeLogs.isEmpty()){
			return routeLogs.get(0);
		}
		return null;
	}

	@Override
	public List<RouteLog> findRouteLogsByPage(int offset, int pageSize,
			String condition) {
		String hql;
		if(condition==""||condition==null){
			hql = "from "+RouteLog.class.getSimpleName();
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from "+RouteLog.class.getSimpleName()+" where driverName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%");
		}
	}

	@Override
	public List<RouteLog> findRouteLogByDriverId(long id, int offset, int pageSize) {
		String hql = "from RouteLog r where driverId=? and r.state='wait'";
		return findByPage(hql, offset, pageSize,id);
	}

	@Override
	public long findCountByDriverId(long id) {
		String hql = "select count(*) from Approve where driverId=?";
		List<?> l = find(hql,id);
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}

	@Override
	public List<RouteLog> findNewRouteLogByDriverId(long id, int offset,
			int pageSize) {
		String hql = "from RouteLog r where driverId=? and r.state='wait'";
		return findByPage(hql, offset, pageSize,id);
	}

	@Override
	public long findNewCountByDriverId(long id) {
		String hql = "select count(*) from RouteLog r where driverId=? and r.state='wait'";
		List<?> l = find(hql,id);
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;

	}

	@Override
	public RouteLog findPassengerCurrentRoute(long userId) {
		String hql = "from RouteLog where passengerId=? and state='inprogress'";
		List<RouteLog> routeLogs = this.find(hql, userId);
		if(!routeLogs.isEmpty()){
			return routeLogs.get(0);
		}
		return null;
	}

	@Override
	public RouteLog findDriverCurrentRoute(long userId) {
		String hql = "from RouteLog where driverId=? and state='inprogress'";
		List<RouteLog> routeLogs = this.find(hql, userId);
		if(!routeLogs.isEmpty()){
			return routeLogs.get(0);
		}
		return null;
	}

	
}
