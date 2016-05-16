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

@Controller
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private RouteLogService routeLogService;
	
	@RequestMapping("/driver")
	String carPage(){
		SecurityUtils.getSubject().checkRole("driver");
		return "driver_manage";
	}
	
	@RequestMapping("/driver/mytask")
	String taskPage(){
		SecurityUtils.getSubject().checkRole("driver");
		return "myTask";
	}
	
	@RequestMapping("/driver/currentTask")
	String currentTaskPage(){
		SecurityUtils.getSubject().checkRole("driver");
		return "currentTask";
	}
	
	@RequestMapping("/driver/list")
	@ResponseBody
	public Object driverList(HttpServletRequest request, int limit, int offset, String search){
		List<Driver> drivers = driverService.findDriversByPage(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for(Driver driver:drivers){
			Map<String,Object> result = new HashMap<String,Object>();
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
	
	@RequestMapping("/driver/task")
	@ResponseBody
	public Object newTask(HttpServletRequest request, int limit, int offset, String search){
		List<RouteLog> routes = driverService.findNewTask(offset, limit);
		List<Object> results = new ArrayList<Object>();
		for(RouteLog route:routes){
			Map<String,Object> result = new HashMap<String,Object>();
			result.put("logId", route.getLogId());
			result.put("passengerName", route.getPassengerName());
			result.put("startpoint", route.getStartpoint());
			result.put("destination", route.getDestination());
			result.put("startDate", route.getStartDate());
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(driverService.findNewTaskCount());
		return page;
	}
	
	@RequestMapping("/driver/taskcount")
	@ResponseBody
	public Object newTaskCount(HttpServletRequest request){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("taskCount", driverService.findNewTaskCount());
		return result;
	}
	
	@RequestMapping("/driver/accept")
	@ResponseBody
	public Object acceptTask(long logId){
		driverService.driveAccept(logId);
		return "{}";
	}
	
	@RequestMapping("/driver/currentRoute")
	@ResponseBody
	public Object currentTask(){
		return routeLogService.findDriverCurrentRoute();
	}
	
	@RequestMapping("/driver/completeTask")
	@ResponseBody
	public Object completeTask(){
		driverService.driveEnd(200.0);
		return "{}";
	}
}
