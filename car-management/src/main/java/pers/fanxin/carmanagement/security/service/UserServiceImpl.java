package pers.fanxin.carmanagement.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.fanxin.carmanagement.module.dao.DriverDAO;
import pers.fanxin.carmanagement.module.entity.Driver;
import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.utils.EncryptHelper;
import pers.fanxin.carmanagement.security.utils.UserHelper;
import pers.fanxin.carmanagement.security.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private DriverDAO driverDAO;

	@Override
	public Long createUser(User user) {
		EncryptHelper.encryptPassword(user);
		return userDAO.createUser(user);
	}

	@Override
	public Long  createUser(String username, String realname, String workNum, 
			String payNum, String email, String password, String roleId) {
		User user = new User();
		user.setUsername(username);
		user.setRealname(realname);
		user.setWorkNum(workNum);
		user.setPayNum(payNum);
		user.setEmail(email);
		user.setPassword(password);
		String[] roleIds = roleId.split(",");
		Set<Role> roles = new HashSet<Role>();
		for(String id : roleIds){
			Role role = roleDAO.getRoleById(Long.parseLong(id));
			roles.add(role);
		}
		user.setRole(roles);
		return createUser(user);
	}

	@Override
	public User findUserByName(String username) {
		return userDAO.findByName(username);
	}

	@Override
	public void updateUser(UserVO userVO) {
		User user = userDAO.getUserById(userVO.getUserId());
		String formerRoleString = UserHelper.getUserRole(user);
		user.setUsername(userVO.getUsername());
		user.setRealname(userVO.getRealname());
		user.setWorkNum(userVO.getWorkNum());
		user.setDepartment(userVO.getDepartment());
		user.setPhone(userVO.getPhone());
		user.setPayNum(userVO.getPayNum());
		user.setEmail(userVO.getEmail());
		
		String RoleString = userVO.getRoles();
		String[] roleNames = RoleString.split(",");
		
		Set<Role> roles = new HashSet<Role>();
		for(String roleName : roleNames){
			Role role = roleDAO.getRoleByName(roleName);
			roles.add(role);
		}
		user.setRole(roles);
		userDAO.updateUser(user);
		if(!RoleString.contains("driver")){
			unbindDriver(user);
		}
		if(RoleString.contains("driver") && (!formerRoleString.contains("driver"))){
			bindDriver(user);
		}
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

	@Override
	public void deleteUser(long id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User findUserById(Long id) {
		return userDAO.getUserById(id);
	}

	@Override
	public Long createUser(UserVO userVO) {
		User user = new User();
		user.setUsername(userVO.getUsername());
		user.setRealname(userVO.getRealname());
		user.setWorkNum(userVO.getWorkNum());
		user.setDepartment(userVO.getDepartment());
		user.setPhone(userVO.getPhone());
		user.setPayNum(userVO.getPayNum());
		user.setEmail(userVO.getEmail());
		user.setPassword(userVO.getPassword());
		String roleString = userVO.getRoles();
		String[] roleNames = roleString.split(",");
		String formerRoleString = UserHelper.getUserRole(user);
		Set<Role> roles = new HashSet<Role>();
		for(String roleName : roleNames){
			Role role = roleDAO.getRoleByName(roleName);
			roles.add(role);
		}
		user.setRole(roles);
		Long id = createUser(user);
		if(roleString.contains("driver")&& (!formerRoleString.contains("driver"))){
			bindDriver(user);//绑定用户到driver
		}
		return id;
	}
	
	private void bindDriver(User user){
		Driver driver = new Driver();
		driver.setRealname(user.getRealname());
		driver.setUserId(user.getUserId());
		driver.setWorkNum(user.getWorkNum());
		driverDAO.createDriver(driver);
	}
	
	private void unbindDriver(User user){
		driverDAO.deleteDriverByUserId(user.getUserId());
	}
}
