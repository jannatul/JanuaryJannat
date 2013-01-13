package org.maven_2;

import org.testng.annotations.Test;

@Test
public class Test_1 extends Base2 {
  public void f(){
		  commonSetup();
		  newIe(myurl);
		  pull_data1();
		  lastMethod();
		  
		  
		  commonSetup();
		  newFirefox(myurl);
		  pull_data1();
		  lastMethod();
		  
		  commonSetup();
		  newSafari(myurl);
		  pull_data1();
		  lastMethod();
		  
		  commonSetup();
		  newChrome(myurl);
		  pull_data1();
		  lastMethod();
		  
		  
	  }
 
}
