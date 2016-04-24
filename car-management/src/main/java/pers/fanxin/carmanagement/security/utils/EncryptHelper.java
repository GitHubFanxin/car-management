package pers.fanxin.carmanagement.security.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import pers.fanxin.carmanagement.security.entity.User;

public class EncryptHelper {
	private static RandomNumberGenerator numberGenerator = new SecureRandomNumberGenerator();
	private final static int hashIterations = 2;
	
	/**
	 * 自动对用户添加salt，并对用户密码进行MD5散列
	 * @param user   
	 * void
	 */
	public static void encryptPassword(User user){
		user.setSalt(numberGenerator.nextBytes().toHex());
		user.setPassword(encryptPassword(user.getPassword(),user.getCredentialSalt()));
	}

	/**
	 * 对输入password使用输入的salt进行MD5散列
	 * @param password
	 * @param salt
	 * @return   
	 * String
	 */
	public static String encryptPassword(String password, String salt){
		String newPassword = new SimpleHash(
				"md5",
				password,
				salt,
				hashIterations).toHex();
		return newPassword;
	}
}
