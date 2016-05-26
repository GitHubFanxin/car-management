package pers.fanxin.carmanagement.module.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pers.fanxin.carmanagement.module.service.AndroidService;
import pers.fanxin.carmanagement.module.vo.AndroidData;

@Controller
public class AndroidServiceController {

	@Autowired
	private AndroidService androidService;

	@RequestMapping("/androidService")
	@ResponseBody
	public AndroidData service(String json) {
		JSONObject jsonObject = new JSONObject(json);
		JSONObject userInfo = jsonObject.getJSONObject("userInfo");
		String username = userInfo.getString("username");
		String password = userInfo.getString("password");

		AndroidData result;
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		try {
			subject.login(token);
			result = androidService.callfunction(jsonObject);
		} catch (AuthenticationException e) {
			result = new AndroidData();
			result.setMsg(e.toString());
		}
		return result;
	}
}
