package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.security.entity.Role;

public interface RoleDAO extends BaseDAO<Role>{

	/**
	 * 
	 * @Description: 创建角色
	 * @param role
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	public Long createRole(Role role);
	/**
	 * 
	 * @Description: 根据id删除角色
	 * @param role   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	public void deleteRole(Long id);
	/**
	 * 
	 * @Description: 删除角色
	 * @param role   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void deleteRole(Role role);
	/**
	 * 
	 * @Description: 更新角色
	 * @param role   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	public void updateRole(Role  role);
	/**
	 * 
	 * @Description: 获取角色
	 * @param id
	 * @return   
	 * Role  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	public Role getRoleById(Long id);
	
	public Role getRoleByName(String roleName);
	
	public List<Role> findRoleByPage(int offset, int pageSize, String condition);
	
	long findCount(String condition);

}
