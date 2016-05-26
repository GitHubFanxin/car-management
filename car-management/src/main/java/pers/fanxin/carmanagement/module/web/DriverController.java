package pers.fanxin.carmanagement.module.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.module.entity.RouteLog;
import pers.fanxin.carmanagement.module.service.DriverService;
import pers.fanxin.carmanagement.module.service.RouteLogService;
import pers.fanxin.carmanagement.module.vo.RouteLogVO;

@Controller
public class DriverController {

	@Autowired
	private DriverService driverService;
	@Autowired
	private RouteLogService routeLogService;

	@RequestMapping("/manage/driver")
	String carPage() {
		SecurityUtils.getSubject().checkRole("approver");
		return "driver_manage";
	}

	@RequestMapping("/driver/newtask")
	String taskPage() {
		SecurityUtils.getSubject().checkRole("driver");
		return "myNewTask";
	}

	@RequestMapping("/driver/task-history")
	String taskHistory() {
		SecurityUtils.getSubject().checkRole("driver");
		return "myTaskHistory";
	}

	@RequestMapping("/driver/currentTask")
	String currentTaskPage() {
		SecurityUtils.getSubject().checkRole("driver");
		return "currentTask";
	}

	@RequestMapping("/manage/driver/list")
	@ResponseBody
	public Object driverList(HttpServletRequest request, int limit, int offset,
			String search) {
		List<Driver> drivers = driverService.findDriversByPage(offset, limit,
				search);
		List<Object> results = new ArrayList<Object>();
		for (Driver driver : drivers) {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("driverId", driver.getDriverId());
			result.put("realname", driver.getRealname());
			result.put("state", driver.getState());
			result.put("workNum", driver.getWorkNum());
			result.put("userId", driver.getUserId());
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(driverService.findCount(search));
		return page;
	}

	@RequestMapping("/driver/task-history/list")
	@ResponseBody
	public Object taskHistoryList(HttpServletRequest request, int limit,
			int offset, String search) {
		List<RouteLog> routes = driverService.findTask(offset, limit);
		List<Object> results = new ArrayList<Object>();
		for (RouteLog route : routes) {
			results.add(new RouteLogVO(route));
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(driverService.findTaskCount());
		return page;
	}

	/**
	 * 获得新任务
	 * 
	 * @param request
	 * @param limit
	 * @param offset
	 * @param search
	 * @return Object
	 */
	@RequestMapping("/driver/newtask/list")
	@ResponseBody
	public Object newTaskList(HttpServletRequest request, int limit,
			int offset, String search) {
		List<RouteLog> routes = driverService.findNewTask(offset, limit);
		List<Object> results = new ArrayList<Object>();
		for (RouteLog route : routes) {
			results.add(new RouteLogVO(route));
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(driverService.findNewTaskCount());
		return page;
	}

	/**
	 * 获得新任务数量
	 * 
	 * @param request
	 * @return Object
	 */
	@RequestMapping("/driver/taskcount")
	@ResponseBody
	public Object newTaskCount(HttpServletRequest request) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("taskCount", driverService.findNewTaskCount());
		return result;
	}

	/**
	 * 接受行程id对应任务
	 * 
	 * @param logId
	 * @return Object
	 */
	@RequestMapping("/driver/accept")
	@ResponseBody
	public Object acceptTask(long logId) {
		driverService.driveAccept(logId);
		return "{}";
	}

	/**
	 * 获得当前任务
	 * 
	 * @return Object
	 */
	@RequestMapping("/driver/currentRoute")
	@ResponseBody
	public Object currentTask() {
		return routeLogService.findDriverCurrentRoute();
	}

	/**
	 * 任务完成
	 * 
	 * @return Object
	 */
	@RequestMapping("/driver/completeTask")
	@ResponseBody
	public Object completeTask(double cost) {
		driverService.driveEnd(cost);
		return "{}";
	}
}
