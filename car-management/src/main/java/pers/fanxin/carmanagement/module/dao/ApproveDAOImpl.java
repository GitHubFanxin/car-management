package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import pers.fanxin.carmanagement.common.hibernate.BaseHibernateDAO;
import pers.fanxin.carmanagement.module.entity.Approve;
@Repository
public class ApproveDAOImpl extends BaseHibernateDAO<Approve>
	implements ApproveDAO{

	@Override
	public Long createApprove(Approve approve) {
		return (Long)save(approve);
	}

	@Override
	public void updateApprove(Approve approve) {
		this.update(approve);
	}

	@Override
	public void deleteApprove(Approve approve) {
		this.delete(approve);
	}

	@Override
	public List<Approve> findApproveByPage(int offset, int pageSize,
			String condition) {
		String hql;
		if(condition==""||condition==null){
			hql = "from "+Approve.class.getSimpleName();
			return findByPage(hql, offset, pageSize);
		}else{
			hql = "from "+Approve.class.getSimpleName()+" where approverName like ? or driverName like ?";
			return findByPage(hql, offset, pageSize, "%"+condition+"%","%"+condition+"%");
		}
	}

	@Override
	public Approve getApproveById(long id) {
		String hql = "from "+Approve.class.getSimpleName()+" where approveId=?";
		List<Approve> approves = this.find(hql, id);
		if(!approves.isEmpty()){
			return approves.get(0);
		}
		return null;
	}

	@Override
	public long findCount(String condition) {
		String hql;
		List<?> l ;
		if(condition==null||condition==""){
			hql = "select count(*) from "+Approve.class.getSimpleName();
			l = find(hql);
		}else{
			hql = "select count(*) from "+Approve.class.getSimpleName()+" where approverName like ? or driverName like ?";
			l = find(hql,"%"+condition+"%", "%"+condition+"%");
		}
		if(l!=null&&l.size()==1){
			return (Long)l.get(0);
		}
		return 0;
	}

}
