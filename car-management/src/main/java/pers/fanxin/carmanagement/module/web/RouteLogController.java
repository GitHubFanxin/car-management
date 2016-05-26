package pers.fanxin.carmanagement.module.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.module.service.RouteLogService;
import pers.fanxin.carmanagement.module.vo.ApplicationVO;
import pers.fanxin.carmanagement.module.vo.RouteLogVO;

@Controller
public class RouteLogController {
	@Autowired
	private RouteLogService routeLogService;

	@RequestMapping("/usecar/history")
	String applicationPage() {
		return "myUseHistory";
	}

	@RequestMapping("/usecar/history/list")
	@ResponseBody
	public Object applicationListHistory(HttpServletRequest request, int limit,
			int offset, String search) {
		List<RouteLog> routeLogs = routeLogService
				.findCurrentPassengerRouteLog(offset, limit);
		List<Object> results = new ArrayList<Object>();
		for (RouteLog routeLog : routeLogs) {
			results.add(new RouteLogVO(routeLog));
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(routeLogService.findCurrentPassengerRouteLogCount());
		return page;
	}

	@RequestMapping("/usecar/currentRoute")
	@ResponseBody
	public Object currentRoute() {
		return routeLogService.findPassengerCurrentRoute();
	}
}
