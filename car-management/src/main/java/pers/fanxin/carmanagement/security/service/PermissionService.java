package pers.fanxin.carmanagement.security.service;

import pers.fanxin.carmanagement.security.entity.Permission;

public interface PermissionService {
	/**
	 * 
	 * @Description: 创建权限
	 * @param permission
	 * @param description
	 * @return   
	 * Long  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public Long creatPermission(String permission, String description);
	/**
	 * 
	 * @Description: 删除权限
	 * @param id   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void deletePermission(Long id);
	/**
	 * 
	 * @Description: 更新权限
	 * @param permission   
	 * void  
	 * @throws
	 * @author fanxin
	 * @date 2016年4月21日
	 */
	public void updatePermission(Permission permission);
	
}
