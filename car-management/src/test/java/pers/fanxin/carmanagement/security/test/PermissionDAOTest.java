package pers.fanxin.carmanagement.security.test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.entity.Permission;

public class PermissionDAOTest {
	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resource/*.xml");
	PermissionDAO permissionDAO;

	@Before
	public void setUp() throws Exception {
		permissionDAO = (PermissionDAO)context.getBean("permissionDAOImpl");
	}

//	@Test
	public void creatPermissionTest() {
		Permission p = new Permission();
		p.setPermission("user:add");
		p.setDescription("添加用户");
		p.setAvailable(Boolean.TRUE);
		Long id = permissionDAO.createPermission(p);
		System.out.println( id.toString());
	}
	@Test
	public void getAllPermissionTest(){
		List<Permission> permissions = permissionDAO.getAllPermissions();
		Assert.assertEquals(2, permissions.size());
	}
	
	public Long creatPermissionTest1() {
		Permission p = new Permission();
		p.setPermission("user:add");
		p.setDescription("添加用户");
		p.setAvailable(Boolean.TRUE);
		Long id = permissionDAO.createPermission(p);
		System.out.println( id.toString());
		return id;
	}
//	@Test
	public void getPermissionTest(){
		Permission p = permissionDAO.getPermissionById(new Long(1));
		Assert.assertEquals(new Long(1), p.getPermissionId());
	}
	
//	@Test
	public void deletPermissionTest1(){
		Long id = this.creatPermissionTest1();
		permissionDAO.deletePermission(id);
	}
}
