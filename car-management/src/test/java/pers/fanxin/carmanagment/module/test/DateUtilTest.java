package pers.fanxin.carmanagment.module.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import pers.fanxin.carmanagement.common.utils.DateUtil;

public class DateUtilTest {
	
	@Test
	public void test(){
		Date d = new Date();
		Date d2 = DateUtil.getPerDate(d, 30);
		Assert.assertEquals(true, true);
	}
}
