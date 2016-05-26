package pers.fanxin.carmanagement.module.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.RouteLogDAO;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.vo.AndroidData;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.utils.UserHelper;

@Service
public class AndroidServiceImpl implements AndroidService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ApplicationService applicationService;
	@Autowired
	private ApproveService approveService;
	@Autowired
	private CarService carService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private RouteLogService routeLogService;
	@Autowired
	private RouteLogDAO routeLogDAO;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public AndroidData callfunction(JSONObject inData) {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		User user = userDAO.findByName(username);
		String method = inData.getString("method");
		JSONObject params = inData.getJSONObject("params");

		AndroidData resultData = new AndroidData();
		Map<String, Object> result = new HashMap<String, Object>();

		switch (method) {
		case "login":
			resultData.setMsg("success");
			result.put("roles", UserHelper.getUserRole(user));
			resultData.setResult(result);
			break;
		case "getPassengerCurrentRoute":
			resultData.setMsg("success");
			resultData.setResult(routeLogService.findPassengerCurrentRoute());
			break;
		case "getDriverCurrentRoute":
			resultData.setMsg("success");
			resultData.setResult(routeLogService.findDriverCurrentRoute());
			break;
		case "getRouteHistoryList":
			resultData.setMsg("success");

			break;

		case "apply":
			String startpoint = params.getString("startpoint");
			String destination = params.getString("destination");
			boolean roundtrip = params.getBoolean("roundtrip");
			String remark = params.getString("remark");
			String date = params.getString("date");
			Application application = new Application();
			application.setStartpoint(startpoint);
			application.setDestination(destination);
			application.setRoundtrip(roundtrip);
			application.setRemark(remark);
			try {
				application.setStartDate(sdf.parse(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			applicationService.createApplication(application);
			resultData.setMsg("success");
			break;

		case "approve":
			long ApplicationId = params.getLong("applicationId");
			approveService.approve(ApplicationId);
			resultData.setMsg("success");
			break;
		}
		return resultData;
	}

}
