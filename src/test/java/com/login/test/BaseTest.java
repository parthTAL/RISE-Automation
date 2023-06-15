package com.login.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.Utilities.*;

import io.appium.java_client.*;

public class BaseTest extends AllElements{

	WebDriver driver = null;
	AppiumDriver mdriver = null;
	
	
	
	Report r = null;
	
String baseURL = "htpps://www.facebook.com";
String PATH = System.getProperty("user.dir");
	

	
	
	@BeforeClass
	public void setup() {
		
		
		r = new Report();
		System.setProperty("webdriver.chrome.driver", PATH+"/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
		
	
	@AfterClass
	public void cleanup() {
		
		driver.quit();
		r.flush();
		
	}
	
	
	
	//WEB ACTIONS
	
	public void web_click(String element) {
		
		driver.findElement(By.xpath(element)).click();
		
	}

	public void web_enter(String element, String data) {
		
		 driver.findElement(By.xpath(element)).sendKeys(data);
		
	}

	public void web_maximize_window() {
		
		driver.manage().window().maximize();
		
		
	}

	public void web_goToURL(String baseURL) {
		
		
		driver.get("https://www.facebook.com/");
		
	}
	
	public void web_verify(String target, String actual, String expected) throws IOException {
		
		String target2 = target.replace(' ', '_');
		
		
		String target3 = take_screenshot(target2);
		
		
		try {
			
			
			Assert.assertEquals(actual, expected);
			r.log_pass(target, target3);
			
			
		} catch (AssertionError e) {
			
			
			r.log_fail(target +" : "+ e.toString(), target3);
		}
		
		
	}
	
	
	
	public String take_screenshot(String filename) throws IOException {
		
		String filename2 = filename + ".png";
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	      FileUtils.copyFile(screenshotFile, new File(filename2));
	      
	      return filename2;
	      
	      
	      
	}
	
	
	//MOBILE ACTIONS
	
	
	
}
