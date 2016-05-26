package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.security.entity.Role;

public interface RoleDAO extends BaseDAO<Role> {

	/**
	 * 
	 * @Description: 创建角色
	 * @param role
	 * @return Long
	 * @throws
	 */
	public Long createRole(Role role);

	/**
	 * 
	 * @Description: 根据id删除角色
	 * @param role
	 *            void
	 * @throws
	 */
	public void deleteRole(Long id);

	/**
	 * 
	 * @Description: 删除角色
	 * @param role
	 *            void
	 * @throws
	 */
	public void deleteRole(Role role);

	/**
	 * 
	 * @Description: 更新角色
	 * @param role
	 *            void
	 * @throws
	 */
	public void updateRole(Role role);

	/**
	 * 
	 * @Description: 获取角色
	 * @param id
	 * @return Role
	 * @throws
	 */
	public Role getRoleById(Long id);

	public Role getRoleByName(String roleName);

	public List<Role> findRoleByPage(int offset, int pageSize, String condition);

	long findCount(String condition);

}
