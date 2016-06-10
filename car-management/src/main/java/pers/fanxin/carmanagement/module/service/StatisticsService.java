package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.RouteLog;

public interface StatisticsService {
	public List<RouteLog> findRouteLogBetweenDate(String start, String end);
	
	public long findCountBetweenDate(String start, String end);
	
	public double findCostBetweenDate(String start, String end);
	
	public Object findLatestCost(int num);
	
	public double findLatestTotleCost(int num);
	
	public long findLatestCount(int num);
}
