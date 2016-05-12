package pers.fanxin.carmanagement.module.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.ApplicationDAO;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;

@Service
public class ApplicationServiceImpl implements ApplicationService {
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private UserDAO userDAO;

	private User getCurrentUser() {
		String username = (String) SecurityUtils.getSubject().getPrincipal();
		return userDAO.findByName(username);
	}

	@Override
	public Long createApplication(Application application) {
		User currentUser = getCurrentUser();
		application.setApplicantName(currentUser.getRealname());
		application.setApplicantId(currentUser.getUserId());
		application.setApplyDate(new Date());
		return applicationDAO.createApplication(application);
	}

	@Override
	public void updateApplication(Application application) {
		applicationDAO.updateApplication(application);
	}

	@Override
	public void deleteApplication(Application application) {
		applicationDAO.deleteApplication(application);
	}

	@Override
	public Application getApplicationById(long id) {
		return applicationDAO.getApplicationById(id);
	}

	@Override
	public List<Application> findApplicationsByPage(int offset, int pageSize,
			String condition) {
		return applicationDAO.findApplicationsByPage(offset, pageSize,
				condition);
	}

	@Override
	public long findCount(String condition) {
		return applicationDAO.findCount(condition);
	}

	@Override
	public List<Application> findApplicationsByUserId(int offset, int pageSize,
			String condition, long userId) {
		return applicationDAO.findApplicationsByUserId(offset, pageSize,
				condition, userId);
	}

	@Override
	public long findCountByUserId(String condition, long userId) {
		return applicationDAO.findCountByUserId(condition, userId);
	}

	@Override
	public List<Application> findCurrentUserHistory(int offset, int pageSize,
			String condition) {
		return applicationDAO.findApplicationsByUserId(offset, pageSize,
				condition, getCurrentUser().getUserId());
	}

	@Override
	public List<Application> applicationsUnapproved(int offset, int pageSize,
			String condition) {
		return applicationDAO.applicationsUnapproved(offset, pageSize,
				condition);
	}

	@Override
	public long findUnapprovedCount(String condition) {
		return applicationDAO.findUnapprovedCount(condition);
	}

}
