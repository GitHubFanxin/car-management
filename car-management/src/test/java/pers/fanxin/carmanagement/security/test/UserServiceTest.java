/**  
 * @Title: UserServiceTest.java
 * @Package pers.fanxin.carmanagement.security.service
 * @Description: TODO
 * @author fanxin
 * @date 2016年4月20日
 */
package pers.fanxin.carmanagement.security.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import pers.fanxin.carmanagement.security.dao.RoleDAO;
import pers.fanxin.carmanagement.security.entity.Permission;
import pers.fanxin.carmanagement.security.entity.Role;
import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.service.RoleService;
import pers.fanxin.carmanagement.security.service.UserService;
import pers.fanxin.carmanagement.security.utils.EncryptHelper;
import pers.fanxin.carmanagement.security.utils.UserHelper;

/**
 * ClassName: UserServiceTest 
 * @Description: TODO
 * @author fanxin
 * @date 2016年4月20日
 */
public class UserServiceTest {
	ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resource/test-*.xml");
	UserService userService=(UserService) context.getBean("userServiceImpl");
	RoleDAO roleDao = (RoleDAO) context.getBean("roleDAOImpl");
	TestUtils testUtils = new TestUtils();
	org.apache.shiro.mgt.SecurityManager securityManager = (org.apache.shiro.mgt.SecurityManager)context.getBean("securityManager");
	private SessionFactory sessionFactory; 
	private Session session; 

	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void createUserTest(){
//		User user = testUtils.getUserCase();
//		user.setRole(new HashSet<Role>(roleDao.findAll(Role.class)));
//		userService.createUser(user);
//		userService.createUser("fanxin", "fanxin@qq.com", "12345", "1,3");
//		userService.createUser("fanxin2", "fanxin@qq.com", "12345", "1,3");
//		User user = userService.findUserByName("fanxin");
//		Hibernate.initialize(user);
//		System.out.println(UserHelper.getUserRole(user));
//		Assert.assertEquals(user.getPassword(), EncryptHelper.encryptPassword("12345", user.getCredentialSalt()));
		User user = new User();
		user.setUsername("admin");
		user.setRealname("管理员");
		user.setWorkNum("0");
		user.setPayNum("0");
		user.setEmail(null);
		user.setPassword("admin");
		user.setRole(new HashSet<Role>(roleDao.findAll(Role.class)));
		userService.createUser(user);
	}
	
//	@Test
	public void loginTest(){
//		userService.createUser("164823558", "f@qq.com", "122123qqFX", "1");
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("164823558","122123qqFX");
		subject.login(token);
	}
	
//	public void tearDown() throws Exception { 
//		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory); 
//		Session s = holder.getSession(); 
//		s.flush(); 
//		TransactionSynchronizationManager.unbindResource(sessionFactory); 
//		SessionFactoryUtils..closeSessionIfNecessary(s, sessionFactory); 
//		} 
}
