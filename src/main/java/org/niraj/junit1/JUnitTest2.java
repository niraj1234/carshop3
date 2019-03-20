package org.niraj.junit1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JUnitTest2 {

	String message = "Hi From JUnit";
	MessageUtil messUtil = new MessageUtil(message);

	@Test
	public void testPrintMessage(){

		message = "New Message";
		assertEquals(message , messUtil.printMessage());	
  }
}
