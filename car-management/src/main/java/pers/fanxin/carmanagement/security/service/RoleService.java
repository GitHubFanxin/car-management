package pers.fanxin.carmanagement.security.service;

import pers.fanxin.carmanagement.security.entity.Role;

public interface RoleService {
	/**
	 * 
	 * @Description: 创建角色
	 * @param rolename
	 * @param description
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public Long createRole(String rolename, String description);
	/**
	 * 
	 * @Description: 删除角色
	 * @param id   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void deleteRole(Long id);
	/**
	 * 
	 * @Description: 更新角色
	 * @param role   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void updateRole(Role role);

}
