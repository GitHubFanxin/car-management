package pers.fanxin.carmanagement.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.utils.EncryptHelper;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Long createUser(User user) {
		return userDAO.createUser(user);
	}

	@Override
	public Long createUser(String username, String email, String password,
			String roleId) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		String[] roleIds = roleId.split(",");
		Set<Role> roles = new HashSet<Role>();
		for(String id : roleIds){
			Role role = roleDAO.getRoleById(Long.parseLong(id));
			roles.add(role);
		}
		user.setRole(roles);
		EncryptHelper.encryptPassword(user);
		return createUser(user);
	}

	@Override
	public User findUserByName(String username) {
		return userDAO.findByName(username);
	}

	@Override
	public void updateUser(User user) {
		this.updateUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll(User.class);
	}

	@Override
	public List<User> findUserByPage(int offset, int pageSize, String condition) {
		return userDAO.findUserByPage(offset, pageSize, condition);
	}

	@Override
	public long findCount(String condition) {
		return userDAO.findCount(condition);
	}
	

	
}
