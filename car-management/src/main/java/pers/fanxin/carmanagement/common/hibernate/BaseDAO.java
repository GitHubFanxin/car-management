package pers.fanxin.carmanagement.common.hibernate;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {
	/**
	 * @Description:根据id加载实体
	 * @param clazz
	 * @param id
	 * @return
	 * T
	 */
	T get(Class<T> entityClazz, Serializable id);
	/**
	 * @Description:保存实体
	 * @param entity
	 * @return
	 * Serializable
	 */
	Serializable save(T entity);
	/**
	 * @Description:删除实体
	 * @param entity
	 */
	 void delete(T entity);
	/**
	 * @Description: 更新实体
	 * @param entity
	 * @return: void
	 * @throws:
	 * @author: fanxin
	 * @date: 2016年3月16日
	 */
	void update(T entity);
	/**
	 * 
	 * @Description: 带占位的hql查询
	 * @param hql
	 * @param param
	 * @return
	 * @return: List<T>
	 * @throws:
	 * @author: fanxin
	 * @date: 2016年3月16日
	 */
	List<T> find(String hql, Object... param);
	/**
	 * 
	 * @Description: 查找所有实体
	 * @param entityClazz
	 * @return
	 * @return: List<T>
	 * @throws:
	 * @author: fanxin
	 * @date: 2016年3月16日
	 */
	List<T> findAll(Class<T> entityClazz);
	List<T> find(String hql);
}