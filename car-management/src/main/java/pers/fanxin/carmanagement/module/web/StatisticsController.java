package pers.fanxin.carmanagement.module.web;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.DateUtil;
import pers.fanxin.carmanagement.module.service.StatisticsService;

@Controller
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping("report/findfindLatestCost")
	@ResponseBody
	public Object findfindLatestCost(){
		return statisticsService.findLatestCost(7);
	}
	
	@RequestMapping("report/findBrief")
	@ResponseBody
	public Object findBrief(){
		Map<String,Object> result = new HashMap<String,Object>();
		DecimalFormat df = new DecimalFormat("#.00");  
		result.put("totalCost", df.format(statisticsService.findLatestTotleCost(30)));
		result.put("routeCount", statisticsService.findLatestCount(30));
		return result;
	}
}
