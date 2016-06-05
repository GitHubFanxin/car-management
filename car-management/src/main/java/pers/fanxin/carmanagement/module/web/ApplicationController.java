package pers.fanxin.carmanagement.module.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.service.ApplicationService;
import pers.fanxin.carmanagement.module.service.CarService;
import pers.fanxin.carmanagement.module.vo.ApplicationVO;

@Controller
public class ApplicationController {

	@Autowired
	private ApplicationService applicationService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/application-form", method = RequestMethod.POST)
	public Object carAdd(String startpoint, String destination,
			boolean roundtrip, String remark, String date) {
		Application application = new Application();
		application.setStartpoint(startpoint);
		application.setDestination(destination);
		application.setRoundtrip(roundtrip);
		application.setRemark(remark);
		try {
			application.setStartDate(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (applicationService.createApplication(application) > 0) {
			return "redirect:myapplication";
		}
		return "application";
	}

	@RequestMapping("/myapplication/list")
	@ResponseBody
	public Object applicationListHistory(HttpServletRequest request, int limit,
			int offset, String search) {
		List<Application> applications = applicationService
				.findCurrentUserHistory(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for (Application application : applications) {
			// Map<String,Object> result = new HashMap<String,Object>();
			// result.put("applicationId", application.getApplicantId());
			// result.put("destination", application.getDestination());
			// result.put("startpoint", application.getStartpoint());
			// result.put("roundtrip", application.getRouteLog());
			// result.put("applyDate", sdf.format(application.getApplyDate()));
			// result.put("state", application.getState());
			ApplicationVO result = new ApplicationVO(application);
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(applicationService.findCount(search));
		return page;
	}

	@RequestMapping("/myapplication/delete")
	@ResponseBody
	public Object carDelete(@RequestBody Application application) {
		applicationService.deleteApplication(application);
		return "{'state':true}";
	}
}
