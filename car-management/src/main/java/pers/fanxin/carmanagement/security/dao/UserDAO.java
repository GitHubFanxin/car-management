package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.security.entity.User;

public interface UserDAO extends BaseDAO<User>{
	/**
	 * 
	 * @Description: 创建用户
	 * @param user
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	Long createUser(User user);
	
	/**
	 * 
	 * @Description: 根据id删除用户
	 * @param id   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	void deleteUser(Long id);
	
	/**
	 * 
	 * @Description: 删除角色
	 * @param user   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	void deleteUser(User user);
	
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
	/**
	 * 
	 * @Description: 根据用户名获得用户
	 * @param username
	 * @return   
	 * User  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	User findByName(String username);
	/**
	 * 
	 * @Description: 根据id获得用户
	 * @param id
	 * @return   
	 * User  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	User getUserById(Long id);
	
	List<User> findUserByPage(int offset, int pageSize, String condition);
	
	long findCount(String condition);
}
