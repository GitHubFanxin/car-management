package pers.fanxin.carmanagement.security.test;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import pers.fanxin.carmanagement.security.dao.PermissionDAO;
import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.dao.UserDAO;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.utils.UserHelper;

public class UserDAOTest {
	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resource/spring-*.xml");
	PermissionDAO permissionDao = (PermissionDAO) context.getBean("permissionDAOImpl");
	RoleDAO roleDao = (RoleDAO) context.getBean("roleDAOImpl");
	UserDAO userDao = (UserDAO) context.getBean("userDAOImpl");
	TestUtils testUtils = new TestUtils();
	@Before
	public void setUp() throws Exception {
	}

//	@Test
	public void createUserTest() {
		User user = testUtils.getUserCase();
		user.setRole(new HashSet<Role>(roleDao.findAll(Role.class)));
		userDao.createUser(user);
	}
	
	@Test
	public void findTest(){
		User user = userDao.findByName("fanxin");
		System.out.println(UserHelper.getUserRole(user));
	}

}
