package pers.fanxin.carmanagement.security.service;

import java.util.List;

import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.vo.UserVO;

public interface UserService {
	/**
	 * 
	 * @Description: 创建用户
	 * @param user
	 * @return Long
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
	 * @return Long
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	Long createUser(String username, String realname, String workNum,
			String payNum, String email, String password, String roleId);

	Long createUser(UserVO userVO);

	/**
	 * 
	 * @Description: 根据用户名查找用户
	 * @param username
	 * @return User
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	User findUserByName(String username);

	User findUserById(Long id);

	/**
	 * 
	 * @Description: 更新用户
	 * @param user
	 *            void
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	void updateUser(UserVO userVO);

	List<User> getAllUsers();

	List<User> findUserByPage(int offset, int pageSize, String condition);

	long findCount(String condition);

	void deleteUser(long id);
}
