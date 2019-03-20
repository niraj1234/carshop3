package org.niraj.junit1;


import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTest3 {
	
	  @Test
      public void testAdd() {
    	  int num= 5;
          String temp= null;
          String temp2 ="Niraj";
          String str= "Junit is working fine";

          assertEquals("Junit is working fine 2" , str);
          assertFalse(num > 6);
          assertNull(temp);
      
          
      }
      
}
