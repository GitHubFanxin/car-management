package pers.fanxin.carmanagement.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.ApproveDAO;
import pers.fanxin.carmanagement.module.entity.Approve;
@Service
public class ApproveServiceImpl implements ApproveService{
	
	@Autowired
	private ApproveDAO approveDAO;
	
	@Override
	public Long createApprove(Approve approve) {
		return approveDAO.createApprove(approve);
	}

	@Override
	public void updateApprove(Approve approve) {
		approveDAO.updateApprove(approve);
	}

	@Override
	public void deleteApprove(Approve approve) {
		approveDAO.deleteApprove(approve);
	}

	@Override
	public List<Approve> findApproveByPage(int offset, int pageSize,
			String condition) {
		return approveDAO.findApproveByPage(offset, pageSize, condition);
	}

	@Override
	public Approve getApproveById(long id) {
		return approveDAO.getApproveById(id);
	}

}
