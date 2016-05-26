package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.module.entity.Application;

public interface ApplicationDAO extends BaseDAO<Application> {
	public Long createApplication(Application application);

	public void updateApplication(Application application);

	public void deleteApplication(Application application);

	public Application getApplicationById(long id);

	public List<Application> findApplicationsByPage(int offset, int pageSize,
			String condition);

	public List<Application> findApplicationsByUserId(int offset, int pageSize,
			String condition, long userId);

	public List<Application> findApplicationsByUserName(int offset,
			int pageSize, String condition, String username);

	public long findCount(String condition);

	public long findCountByUserId(String condition, long userId);

	public long findCountByUsername(String condition, String username);

	public List<Application> applicationsUnapproved(int offset, int pageSize,
			String condition);

	public long findUnapprovedCount(String condition);
}
