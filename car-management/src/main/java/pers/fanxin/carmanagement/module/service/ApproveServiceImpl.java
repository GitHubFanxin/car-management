package pers.fanxin.carmanagement.module.service;

import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.ApplicationDAO;
import pers.fanxin.carmanagement.module.dao.ApproveDAO;
import pers.fanxin.carmanagement.module.entity.Application;
import pers.fanxin.carmanagement.module.entity.Approve;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;
@Service
public class ApproveServiceImpl implements ApproveService{
	
	@Autowired
	private ApproveDAO approveDAO;
	@Autowired
	private ApplicationDAO applicationDAO;
	@Autowired
	private UserDAO userDAO;
	
	private User getCurrentUser(){
		String username = (String)SecurityUtils.getSubject().getPrincipal();
		return userDAO.findByName(username);
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

	@Override
	public long findCount(String condition) {
		return approveDAO.findCount(condition);
	}

	@Override
	public Long approve(long ApplicationId) {
		User currentUser = getCurrentUser();
		Application application = applicationDAO.getApplicationById(ApplicationId);
		if(application.getApprove()!=null){
			Approve approve = new Approve();
			approve.setApplication(application);
			approve.setApproveDate(new Date());
			approve.setApproverId(currentUser.getUserId());
			approve.setApproverName(currentUser.getRealname());
			application.setApprove(approve);
			application.setState("pass");
			applicationDAO.update(application);
			return approveDAO.createApprove(approve);
		}
		return null;
	}
}
