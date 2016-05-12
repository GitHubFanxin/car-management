package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.Application;

public interface ApplicationService {
	public Long createApplication(Application application);
	public void updateApplication(Application application);
	public void deleteApplication(Application application);
	public Application getApplicationById(long id);
	public List<Application> findApplicationsByPage(int offset, int pageSize, String condition);
	public List<Application> findApplicationsByUserId(int offset, int pageSize, String condition, long userId);

	/**
	 * 
	 * @param offset
	 * @param pageSize
	 * @param condition 目的地/出发地/状态
	 * @return   
	 * List<Application>
	 */
	public List<Application> findCurrentUserHistory(int offset, int pageSize, String condition);
	
	public List<Application> applicationsUnapproved(int offset, int pageSize, String condition);
	
	public long findCount(String condition);
	public long findCountByUserId(String condition,long userId);
	public long findUnapprovedCount(String condition);
}
