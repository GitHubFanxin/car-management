package pers.fanxin.carmanagement.security.service;

import pers.fanxin.carmanagement.security.entity.User;

public interface UserService {
	/**
	 * 
	 * @Description: 创建用户
	 * @param user
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	Long createUser(User user);
	/**
	 * 
	 * @Description: 创建用户
	 * @param username
	 * @param email
	 * @param password
	 * @param roleId
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	Long createUser(String username, String email, String password, String roleId);
	/**
	 * 
	 * @Description: 根据用户名查找用户
	 * @param username
	 * @return   
	 * User  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	User findUserByName(String username);
	/**
	 * 
	 * @Description: 更新用户
	 * @param user   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	void updateUser(User user);
}
