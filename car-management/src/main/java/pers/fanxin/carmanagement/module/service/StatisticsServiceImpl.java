package pers.fanxin.carmanagement.module.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.common.utils.DateUtil;
import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.RouteLog;

@Service
public class StatisticsServiceImpl implements StatisticsService{
	@Autowired
	private RouteLogDAO routeLogDAO;

	@Override
	public List<RouteLog> findRouteLogBetweenDate(String start, String end) {
		return routeLogDAO.findRouteLogBetweenDate(DateUtil.strToDate(start), DateUtil.strToDate(end));
	}

	@Override
	public long findCountBetweenDate(String start, String end) {
		return routeLogDAO.findCountBetweenDate(DateUtil.strToDate(start), DateUtil.strToDate(end));
	}

	@Override
	public double findCostBetweenDate(String start, String end) {
		return routeLogDAO.findCostBetweenDate(DateUtil.strToDate(start), DateUtil.strToDate(end));
	}

	@Override
	public Object findLatestCost(int num) {
		Date curDate = DateUtil.getCurDate();
		Date tmpDate = DateUtil.getPerDate(curDate, num);
		List<Double> costs = new ArrayList<Double>();
		List<String> date = new ArrayList<String>();
		for(int i=0;i<num;i++){
			costs.add(routeLogDAO.findCostByDate(tmpDate));
			date.add(DateUtil.dateToString(tmpDate));
			tmpDate=DateUtil.getLaterDate(tmpDate, 1);
		}
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("costs", costs);
		result.put("date", date);
		return result;
	}

	@Override
	public double findLatestTotleCost(int num) {
		Date curDate = DateUtil.getCurDate();
		return routeLogDAO.findCostBetweenDate(DateUtil.getPerDate(curDate, num), curDate);
	}

	@Override
	public long findLatestCount(int num) {
		Date curDate = DateUtil.getCurDate();
		return routeLogDAO.findCountBetweenDate(DateUtil.getPerDate(curDate, num), curDate);
	}
	
	
}
