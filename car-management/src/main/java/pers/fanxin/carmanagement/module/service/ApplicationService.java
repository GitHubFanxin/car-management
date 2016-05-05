package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.Application;

public interface ApplicationService {
	public Long createApplication(Application application);
	public void updateApplication(Application application);
	public void deleteApplication(Application application);
	public Application getApplicationById(long id);
	public List<Application> findApplicationsByPage(int offset, int pageSize, String condition);
}
