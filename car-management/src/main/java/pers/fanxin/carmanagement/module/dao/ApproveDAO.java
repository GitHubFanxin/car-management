package pers.fanxin.carmanagement.module.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.module.entity.Approve;

public interface ApproveDAO extends BaseDAO<Approve>{
	public Long createApprove(Approve approve);
	public void updateApprove(Approve approve);
	public void deleteApprove(Approve approve);
	public List<Approve> findApproveByPage(int offset, int pageSize, String condition);
	public long findCount(String condition);
	public Approve getApproveById(long id);
	
}
