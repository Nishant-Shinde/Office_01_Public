package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.web.utils.CommonUtilities;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class class_pnb extends AbstractPage{


protected class_pnb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
//xpath
private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(EXPLICIT_TIMEOUT));

CommonUtilities CU = new CommonUtilities();

public void CustomerOnboarding(HashMap<String, String> args) throws Throwable, InterruptedException {
	
	String actualResult = "";
	try {
	   
		//functions
		
		
		
		
		
		
		actualResult += "Login Page Open Successfully | ";
		args.put("ActualResult", actualResult);
	}catch(Exception e)
	{
		e.printStackTrace();
		LOGGER.error(e.getMessage());
		actualResult += "Failed in Login Flow | ";
		actualResult += "*** " + e.getMessage() + " ***";
		args.put("ActualResult", actualResult);
		args.put("sOutput", e.toString());
		CU.takeScreenshot(args, driver, "Error Page");

		if (args.get("Test Case Type").equalsIgnoreCase("Negative")) {
			args.put("status", "Pass");
		} else {
			args.put("status", "Fail");
		}
	}
	
}
////method




}
