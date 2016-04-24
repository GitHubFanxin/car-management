package pers.fanxin.carmanagement.security.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import pers.fanxin.carmanagement.security.entity.User;
import pers.fanxin.carmanagement.security.service.UserService;
import pers.fanxin.carmanagement.security.utils.UserHelper;

@Component
public class UserRealm extends AuthorizingRealm{

	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalls) {
		String username = (String)principalls.getPrimaryPrincipal();
		User user = userService.findUserByName(username);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(UserHelper.getUserRoleSet(user));
		authorizationInfo.setStringPermissions(UserHelper.getUserPermissionsSet(user));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		User user = userService.findUserByName(username);
		if(user==null){
			throw new UnknownAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
			user.getUsername(),
			user.getPassword(),
			ByteSource.Util.bytes(user.getCredentialSalt()),
			getName()
		);
		return authenticationInfo;
	}

}
