package org.niraj.junit1;

import junit.framework.Assert;
import junit.framework.TestCase;

public class JavaTest extends TestCase{

	protected int value1, value2 ;
	
	protected void setUp(){
		System.out.println("Set Up method is called ====>");
		value1 = 3;
		value2 = 3;
	}
	protected void tearDown(){
		System.out.println("Tear Down method is called ====>");
	}
	
	public void testAdd(){
		double result = value1 + value2;
		Assert.assertTrue(result == 6);
	}

	
}
