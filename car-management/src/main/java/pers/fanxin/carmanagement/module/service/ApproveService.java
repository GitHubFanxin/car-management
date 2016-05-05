package pers.fanxin.carmanagement.module.service;

import java.util.List;

import pers.fanxin.carmanagement.module.entity.Approve;

public interface ApproveService {
	public Long createApprove(Approve approve);
	public void updateApprove(Approve approve);
	public void deleteApprove(Approve approve);
	public List<Approve> findApproveByPage(int offset, int pageSize, String condition);
	public Approve getApproveById(long id);
}
