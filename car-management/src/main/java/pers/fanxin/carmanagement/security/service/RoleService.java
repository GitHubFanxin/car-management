package pers.fanxin.carmanagement.security.service;

import java.util.List;

import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.vo.RoleVO;

public interface RoleService {
	/**
	 * 
	 * @Description: 创建角色
	 * @param rolename
	 * @param description
	 * @return Long
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public Long createRole(String rolename, String description);

	public Long createRole(RoleVO roleVO);

	/**
	 * 
	 * @Description: 删除角色
	 * @param id
	 *            void
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void deleteRole(Long id);

	/**
	 * 
	 * @Description: 更新角色
	 * @param role
	 *            void
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void updateRole(RoleVO roleVO);

	public List<Role> findRoleByPage(int offset, int pageSize, String condition);

	public long findCount(String condition);

	public List<Role> getAllRoles();
	
	public Role findRoleById(long id);
}
