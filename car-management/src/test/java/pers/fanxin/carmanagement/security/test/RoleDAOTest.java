package pers.fanxin.carmanagement.security.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;

public class RoleDAOTest {
	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resource/test-*.xml");
	RoleDAO roleDao = (RoleDAO) context.getBean("roleDAOImpl");
	PermissionDAO permissionDao = (PermissionDAO) context.getBean("permissionDAOImpl");
	TestUtils testCase = new TestUtils();
	@Before
	public void setUp() throws Exception {
		
	}

//	@Test
	public void createRoleTest() {
//		Role r = testCase.getRoleCase("admin23", "user:add");
//		Set<Permission> permissions = testCase.getPermissionsCase();
//		Iterator iterator = permissions.iterator();
//		while(iterator.hasNext()){
//			permissionDao.createPermission((Permission)iterator.next());
//		}
//		r.setPermissions(permissions);
		Role r = new Role();
		r.setRoleName("admin");
		r.setDescription("系统管理员");
		Permission p = permissionDao.getPermissionById(new Long(1));
		Set<Permission> permissions = new HashSet<Permission>();
		permissions.add(p);
		r.setPermissions(permissions);
		roleDao.createRole(r);
	}
	
//	@Test
	public void updateTest1() {
		Role r = new Role();
		r.setRoleId(new Long(16));
		r.setRoleName("update12");
		r.setDescription("update12");
		roleDao.updateRole(r);
	}
	
//	@Test
	public void createRole() {
		Role r = testCase.getRoleCase("admin1", "管理员1");
		Set<Permission> permissions = new HashSet<Permission>();
		permissions.addAll(permissionDao.getAllPermissions());
		r.setPermissions(permissions);
		roleDao.createRole(r);
	}

//	@Test
	public void deleteRoleTest(){
		roleDao.deleteRole(new Long(2));
	}
//	@Test
	public void updateTest(){
		Role role = roleDao.getRoleById(new Long(1));
		Set<Permission> permissions = new HashSet<Permission>();
		permissions.addAll(permissionDao.getAllPermissions());
		role.setPermissions(permissions);
		roleDao.updateRole(role);
	}
	
	@Test
	public void getRoleTest(){
		Role roles = roleDao.getRoleByName("admin");
		Assert.assertEquals("admin", roles.getRoleName());
	}
}
