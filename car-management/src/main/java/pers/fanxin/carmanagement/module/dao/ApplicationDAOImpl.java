package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Application;

public class ApplicationDAOImpl extends BaseHibernateDAO<Application> 
	implements ApplicationDAO{

	@Override
	public Long createApplication(Application application) {
		return (Long)save(application);
	}

	@Override
	public void updateApplication(Application application) {
		this.update(application);
	}

	@Override
	public void deleteApplication(Application application) {
		this.delete(application);
	}

	@Override
	public Application getApplicationById(long id) {
		String hql = "from "+Application.class.getSimpleName()+" where applicationId=?";
		List<Application> applications = this.find(hql, id);
		if(!applications.isEmpty()){
			return applications.get(0);
		}
		return null;
	}

	@Override
	public List<Application> findApplicationsByPage(int offset, int pageSize,
			String condition) {
		String hql;
		if(condition==""||condition==null){
			hql = "from "+Application.class.getSimpleName();
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from "+Application.class.getSimpleName()+" where applicantName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%");
		}
	}
}
