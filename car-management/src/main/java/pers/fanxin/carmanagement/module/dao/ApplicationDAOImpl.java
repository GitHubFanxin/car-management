package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Application;
@Repository
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

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l;
		if(condition==""||condition==null){
			hql = "select count(*) from Application";
			l = find(hql);
		}else{
			hql = "select count(*) from Application where applicantName like ?";
			l = find(hql,"%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}

	@Override
	public List<Application> findApplicationsByUserId(int offset, int pageSize,
			String condition, long userId) {
		String hql;
		if(condition==""||condition==null){
			hql = "from Application where applicantId = ?";
			return findByPage(hql, offset, pageSize, userId);
		}else{
			hql = "from Application where applicantId = ? and (destination like ? or startpoint like ?)";
			return findByPage(hql, offset, pageSize,userId, "%"+condition+"%", "%"+condition+"%");
		}
	}

	@Override
	public long findCountByUserId(String condition,long userId) {
		String hql;
		List<?> l;
		if(condition==""||condition==null){
			hql = "select count(*) from Application where applicantId = ?";
			l = find(hql,userId);
		}else{
			hql = "select count(*) from Application where applicantId = ? and (destination like ? or startpoint like ?)";
			l = find(hql,userId,"%"+condition+"%","%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}

	@Override
	public List<Application> findApplicationsByUserName(int offset,
			int pageSize, String condition, String username) {
		String hql;
		if(condition==""||condition==null){
			hql = "from Application where applicantName = ?";
			return findByPage(hql, offset, pageSize, username);
		}else{
			hql = "from Application "
					+" where applicantName = ? and (destination like ? or startpoint like ?)";
			return findByPage(hql, offset, pageSize, username,"%"+condition+"%","%"+condition+"%");
		}
	}

	@Override
	public long findCountByUsername(String condition, String username) {
		String hql;
		List<?> l;
		if(condition==""||condition==null){
			hql = "select count(*) from Application where applicantName = ?";
			l = find(hql,username);
		}else{
			hql = "select count(*) from Application where applicantName = ? and (destination like ? or startpoint like ?)";
			l = find(hql,username,"%"+condition+"%","%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}

	@Override
	public List<Application> applicationsUnapproved(int offset, int pageSize,
			String condition) {
		String hql;
		if(condition==""||condition==null){
			hql = "from Application where state = 'unapproved'";
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from Application "
					+" where state = 'unapproved' and applicantName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%");
		}
	}

	@Override
	public long findUnapprovedCount(String condition) {
		String hql;
		List<?> l;
		if(condition==""||condition==null){
			hql = "select count(*) from Application where state = 'unapproved'";
			l = find(hql);
		}else{
			hql = "select count(*) from Application where state = 'unapproved' and  (applicantName like ?)";
			l = find(hql,"%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}
}
