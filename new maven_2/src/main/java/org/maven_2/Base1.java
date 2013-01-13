package org.maven_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Base1 {
public WebDriver driver =null;
	
	String [][] dataHolder= new String [10][6];
	String myurl, link1,link2,link3,link4,link5;
	
	int numOfRows, numOfColumns;
	// 
  public void initialMethod(String fileLocation) {
	 
	  try {
		dataHolder=fileReader(fileLocation);
	} catch (IOException e) {
		
		e.printStackTrace();
	}
  }// end of initial Method
  
  public void lastMethod() {
	  driver.quit();
  }
  
  // Methods for using different types of browser. 
  public void newFirefox(String url){
	  System.out.println("CNN application is testing with Firefox NOW. ");
	  driver= new FirefoxDriver();
	  driver.navigate().to(url);
	  System.out.println("Firefox Browser Started.");
  }

  public void newSafari(String url){
	  System.out.println("CNN application is testing with Safari NOW. ");
	  driver = new SafariDriver();  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to(url);
	  System.out.println("Safari Browser Started.");
  }
  public void newIe(String url){
	  System.out.println("CNN application is testing with Internet Explorer NOW. ");
	  driver = new InternetExplorerDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to(url);
  }
  
  public void newChrome(String url){
	  System.out.println("CNN application is testing with Google Chrome NOW. ");
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win_23.0.1240.0\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to(url);
	  System.out.println("Google Chrome Browser Started.");
  }
  
  public void newhtmlUnit(String url){
	  System.out.println("CNN application is testing with Html Unit Driver NOW. ");
	  driver = new HtmlUnitDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.navigate().to(url);
	  System.out.println("HtmlUnit Browser Started.");
	  
  }
  
  public void sleep(int time){
	  //1000 ms =  1 sec.
	  try {
          Thread.sleep(time * 1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
  
  public void clickCss(String css){
	  try{
	  driver.findElement(By.cssSelector(css)).click();
	  }catch (StaleElementReferenceException ex){
		  driver.navigate().refresh();
		  sleep(2);
		  driver.findElement(By.cssSelector(css)).click();
	  }catch (Exception ex){
		  driver.navigate().refresh();
		  sleep(3);
		  driver.findElement(By.cssSelector(css)).click();
	  }
  }
  
  public void clickXpath(String xpath){
	  try{
	  driver.findElement(By.xpath(xpath)).click();
	  }catch (StaleElementReferenceException ex){
		  driver.navigate().refresh();
		  sleep(2);
		  driver.findElement(By.xpath(xpath)).click();
	  }catch (Exception ex){
		  driver.navigate().refresh();
		  sleep(3);
		  driver.findElement(By.xpath(xpath)).click();
	  }
  }
  
public String [][] fileReader(String file) throws IOException{
	String [][] dataList =null;
	  //Core java to find the file location and prepared to read the file
	  // and FileInputStream prepared for POI libraries(HSSFWorkbook....Cell)
	  File dataFile = new File(file);
	  FileInputStream fis = new FileInputStream(dataFile);
	  //POI's job to read the Excel file
	  HSSFWorkbook wb = new HSSFWorkbook(fis);
	  HSSFSheet sheet = wb.getSheetAt(0);
	  //determine number of rows and columns
	  numOfRows = sheet.getLastRowNum();
	  numOfColumns = sheet.getRow(0).getLastCellNum();
	  dataList = new String [numOfRows][numOfColumns];
	  //iterate through all the rows
	  for(int i=0; i<numOfRows; i++){
		  
		HSSFRow row = sheet.getRow(i);
		//iterate through all the cell
		 for(int j=0; j<numOfColumns; j++){
			 
	       HSSFCell cell = row.getCell(j);
	       //Extracting data and store to an array
	      String data = convertCellToString(cell);
	       dataList [i][j] = data;
	  
		 }
	  }
	return dataList;

  }

public String convertCellToString(HSSFCell cell){
	  Object data = null;
	  int dataType = cell.getCellType();
	  
	  switch(dataType){
	  
	  case HSSFCell.CELL_TYPE_NUMERIC:
	      data = cell.getNumericCellValue();
	      break;
	  
	  case HSSFCell.CELL_TYPE_STRING:
		  data = cell.getStringCellValue();
		  break;
		  
	  case HSSFCell.CELL_TYPE_BOOLEAN:
		  data = cell.getBooleanCellValue();
		  break;	 
		  
    default:
  	     System.out.println("This format is not supported..change your format and come back..if you are crazy one");
	  
	  }// end of switch
	  
	  return data.toString();
}// end of convertCellToString()

public void navigateBackTwoStep(){
	driver.navigate().back();
	driver.navigate().back();
	
}

}
