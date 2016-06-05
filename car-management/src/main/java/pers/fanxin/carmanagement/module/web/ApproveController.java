package pers.fanxin.carmanagement.module.web;

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
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.common.utils.Page;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.entity.Approve;
import pers.fanxin.carmanagement.module.service.ApplicationService;
import pers.fanxin.carmanagement.module.service.ApproveService;
import pers.fanxin.carmanagement.module.vo.ApplicationVO;
import pers.fanxin.carmanagement.module.vo.PassMsgVO;

@Controller
//@RequestMapping("/manage")
public class ApproveController {
	@Autowired
	private ApproveService approveService;
	@Autowired
	private ApplicationService applicationService;

	@RequestMapping("/approve/list")
	@ResponseBody
	public Object approveList(HttpServletRequest request, int limit,
			int offset, String search) {
		SecurityUtils.getSubject().checkRole("approver");
		List<Approve> approve = approveService.findApproveByPage(offset, limit,
				search);

		List<Object> results = new ArrayList<Object>();
		Page page = new Page();
		page.setRows(results);
		page.setTotal(approveService.findCount(search));
		return page;
	}

	// @RequestMapping("/approve/pass")
	// @ResponseBody
	// public Object pass(@RequestBody ArrayList<ApplicationVO> applications){
	// SecurityUtils.getSubject().checkRole("approver");
	// for(ApplicationVO application : applications){
	// approveService.approve(application.getApplicationId());
	// }
	// return "{'state':success'}";
	// }

	@RequestMapping("/approve/pass")
	@ResponseBody
	public Object pass(@RequestBody PassMsgVO msg) {
		SecurityUtils.getSubject().checkRole("approver");
		approveService.approve(msg.getApplicationId(), msg.getCarId(),
				msg.getDriverId());
		return "{'state':success'}";
	}

	@RequestMapping("/approve/unapproved-list")
	@ResponseBody
	public Object unapprovedApplication(HttpServletRequest request, int limit,
			int offset, String search) {
		List<Application> applications = applicationService
				.applicationsUnapproved(offset, limit, search);
		List<Object> results = new ArrayList<Object>();
		for (Application application : applications) {
			// Map<String,Object> result = new HashMap<String,Object>();
			// result.put("applicationId", application.getApplicantId());
			// result.put("destination", application.getDestination());
			// result.put("startpoint", application.getStartpoint());
			// result.put("roundtrip", application.getRouteLog());
			// result.put("applyDate", application.getApplyDate());
			// result.put("applicantName", application.getApplicantName());
			// result.put("state", application.getState());
			ApplicationVO result = new ApplicationVO(application);
			results.add(result);
		}
		Page page = new Page();
		page.setRows(results);
		page.setTotal(applicationService.findCount(search));
		return page;
	}
}
