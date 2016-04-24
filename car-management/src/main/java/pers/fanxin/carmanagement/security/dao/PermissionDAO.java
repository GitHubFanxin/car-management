package pers.fanxin.carmanagement.security.dao;

import java.util.List;

import pers.fanxin.carmanagement.common.hibernate.BaseDAO;
import pers.fanxin.carmanagement.security.entity.Permission;

public interface PermissionDAO extends BaseDAO<Permission>{
	/**
	 * 
	 * @Description: 创建权限
	 * @param permission
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	Long createPermission(Permission permission);
	/**
	 * 
	 * @Description: 删除权限
	 * @param permission   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	void deletePermission(Long id);
	/**
	 * 
	 * @Description: 更新权限
	 * @param permission   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	void updatePermission(Permission permission);
	/**
	 * 
	 * @Description: 获取权限
	 * @param id
	 * @return   
	 * Permission  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	Permission getPermissionById(Long id);
	/**
	 * 
	 * @Description: 获取全部权限
	 * @return   
	 * List<Permission>  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月20日
	 */
	List<Permission> getAllPermissions();
}
