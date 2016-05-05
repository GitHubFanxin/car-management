package pers.fanxin.carmanagement.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.ApplicationDAO;
import pers.fanxin.carmanagement.module.entity.Application;
@Service
public class ApplicationServiceImpl implements ApplicationService{
	@Autowired
	private ApplicationDAO applicationDAO;

	@Override
	public Long createApplication(Application application) {
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
		return applicationDAO.findApplicationsByPage(offset, pageSize, condition);
	}

}
