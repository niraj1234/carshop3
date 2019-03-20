package org.niraj.junit1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JUnitAssertAllMethods {
	String str1 = new String ("abc");
    String str2 = new String ("abc1");
    String str3 = null;
    String str4 = "abc2";
    String str5 = "abc2";
    int val1 = 7;
    int val2 = 6;
    String[] expectedArray = {"one", "two", "three"};
    String[] resultArray =  {"one", "two", "three"};
    
    @Test
    public void testAssertions() {
    assertNotEquals(str1, str2);
    assertTrue (val1 > val2);
    assertFalse(val1 < val2);
    assertNotNull(str1);
    assertNull(str3);
    assertSame(str4,str5);
    assertNotSame(str1,str3);
    assertArrayEquals(expectedArray, resultArray);
 }

}
