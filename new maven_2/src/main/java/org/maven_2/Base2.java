package org.maven_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Base2 extends Base1{
  
	public void commonSetup(){
		  initialMethod( "C:\\Users\\jannatul\\Desktop\\file.xls");
		  myurl = dataHolder[1][2];
		  System.out.println("url is : "+myurl);
	  }// end of commonSetup.
	 
	public void pull_data1(){
	 link1 = dataHolder[2][2]; // us
	  clickCss(link1);
	  sleep(2);
	  List<WebElement> list=driver.findElement(By.cssSelector(".cnn_bulletbin")).findElements(By.cssSelector("li"));
	  System.out.println(convertWebelementToString(list));
	  for(int i=1;i<list.size();i++){
	  clickCss(".cnn_bulletbin li:nth-child("+i+")");//  sandy 
	  sleep(2);
	  driver.navigate().back();
	  sleep(2);
	  } // end of for 
	  
	  
	  
	  link2  = dataHolder[3][2]; // world
	  clickCss(link2);
	  sleep(2);
	  clickXpath(".//*[@id='cnn_mtt1rgtarea']/ul/li[7]/a");
	  sleep(3);
	  driver.navigate().back();
	  
	  link3 = dataHolder[4][2];// politics
	  clickCss(link3);
	  sleep(2);
	  link4 = dataHolder[5][2]; // tech
	  clickCss(link4);
	  sleep(2);
	  link5 = dataHolder[6][2];// justice
	  clickCss(link5);
	  sleep(2);
	  lastMethod();
	}// end of pull data. 
	
	public List<String> convertWebelementToString(List<WebElement> elements ){
		List<String> list = new ArrayList<String>();
		Iterator<WebElement> it =  elements.iterator();
		while(it.hasNext()){
		//	driver.findElement(By.cssSelector(".cnn_bulletbin")).findElements(By.cssSelector("li"));
			list.add(it.next().getText().trim());
			
		}
		
		
		return list;
	}
	
}
