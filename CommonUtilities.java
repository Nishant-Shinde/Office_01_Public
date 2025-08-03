package com.web.utils;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension; 
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class CommonUtilities {
	
	// REMOVED ALL STATIC PATH VARIABLES. These are now managed via the args HashMap.
	// private static String folderPath;
	// private static String testcaseFolder;
	// private static String todaydate;
	// private static String executionDate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	/**
	 * Creates a folder with today's date for reports and screenshots.
	 * Stores the created path in the 'reportPath' key of the args HashMap.
	 * This path is unique for the current day, not necessarily per test run.
	 * Subsequent test case folders will be created inside this.
	 *
	 * @param args HashMap containing test execution parameters, updated with 'reportPath'.
	 */
	public void FolderCreate(HashMap<String, String> args) {
		String currentTodayDate; 

		Date currDate = new Date();											
		SimpleDateFormat oDF = new SimpleDateFormat("dd-MMM-yyyy");			
		currentTodayDate = oDF.format(currDate);									
		args.put("todayDateForFolder", currentTodayDate);

		String projectPath = System.getProperty("user.dir");				
		String sFullScreenShotPath = projectPath + File.separator + "Screenshots_Reports" + File.separator
					+ currentTodayDate;		
		
		try {
			File reportDir = new File(sFullScreenShotPath);
			if (!reportDir.exists()) {
				reportDir.mkdirs(); 
				LOGGER.info("Base Report Folder Created: {}", sFullScreenShotPath);
			} else {
				LOGGER.info("Base Report Folder Already Exists: {}", sFullScreenShotPath);
			}
			
			args.put("reportPath", sFullScreenShotPath);
			System.out.println("Base Report Folder Path: " + sFullScreenShotPath);

		} catch (Exception e) {
			LOGGER.error("Error creating base report folder: {}", e.getMessage(), e);
			args.put("sOutput", "Error creating base report folder: " + e.getMessage());
		}
	}
	
	/**
	 * Creates a unique folder for each test case within the daily report folder.
	 * The folder name includes TestCaseID and a timestamp to ensure uniqueness in case
	 * the same TestCaseID is run multiple times on the same day.
	 * Stores the created path in the 'tcFolderPath' key of the args HashMap.
	 *
	 * @param args HashMap containing test execution parameters, must have 'TestCaseID' and 'reportPath'.
	 */
	public void TCFolderCreate(HashMap<String, String> args) { 	
		try {
			args.putIfAbsent("screenNum", "0");			
			args.putIfAbsent("actualResult", "");
			args.putIfAbsent("status", "");				

			Date currDate = new Date();														
			SimpleDateFormat oDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");				
			String currentExecutionDate = oDF.format(currDate);											
			args.put("executionDate", currentExecutionDate);										
			
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH_mm_ss_SSS"); // Added milliseconds for more uniqueness
			String currentTime = timeFormat.format(currDate);

			String baseReportPath = args.get("reportPath");
			if (baseReportPath == null || baseReportPath.isEmpty()) {
				LOGGER.error("Base report path is not set in args. Cannot create test case folder.");
				throw new IllegalStateException("Base report path (reportPath) not found in args.");
			}

			String testCaseID = args.get("TestCaseID");
			if (testCaseID == null || testCaseID.isEmpty()) {
				testCaseID = "UNKNOWN_TC_" + RandomStringUtils.randomAlphanumeric(5);
				LOGGER.warn("TestCaseID not found in args. Using fallback: {}", testCaseID);
			}
			
			String folderName = testCaseID ;
			//String folderName = testCaseID + "_" + currentTime;
			String currentTcFolderPath = baseReportPath + File.separator + folderName + File.separator + "BI Compare";	

			File tcFolder = new File(currentTcFolderPath);
			if (tcFolder.exists()) {
				try {
					FileUtils.cleanDirectory(tcFolder); 
					LOGGER.info("Cleaned existing Test Case Folder: {}", currentTcFolderPath);
				} catch (IOException e) {
					LOGGER.warn("Could not clean existing Test Case Folder {}: {}", currentTcFolderPath, e.getMessage());
				}
			} else {
				tcFolder.mkdirs();		
				LOGGER.info("Test Case Folder Created: {}", currentTcFolderPath);
			}
			System.out.println("TC Folder Created: " + currentTcFolderPath);	
			args.put("tcFolderPath", currentTcFolderPath);	

		} catch (Exception e) {
			LOGGER.error("Error creating test case folder for TestCaseID {}: {}", args.get("TestCaseID"), e.getMessage(), e);
			e.printStackTrace();
			args.put("sOutput", "Error creating test case folder: " + e.getMessage());
			args.put("status", "Fail");
		}
	}
	
	/**
	 * Takes a screenshot using Selenium's TakesScreenshot and saves it to the
	 * test case specific folder.
	 * The path is retrieved from the args HashMap, ensuring isolation.
	 *
	 * @param args HashMap containing test execution parameters, must have 'screenNum' and 'tcFolderPath'.
	 * @param driver The WebDriver instance for the current test.
	 * @param pageName A descriptive name for the screenshot.
	 * @throws IOException If there's an error writing the screenshot file.
	 */
	public void takeScreenshot(HashMap<String, String> args, WebDriver driver, String pageName)
			throws IOException {

		String scrPath = "";
		int iScreenNum;
		String testcaseFolderForScreenshot = args.get("tcFolderPath"); 
		if (testcaseFolderForScreenshot == null || testcaseFolderForScreenshot.isEmpty()) {
			LOGGER.error("tcFolderPath is not set in args. Cannot take screenshot.");
			throw new IllegalStateException("Test Case Folder Path (tcFolderPath) not found in args. Screenshot cannot be saved.");
		}

		iScreenNum = Integer.parseInt(args.getOrDefault("screenNum", "0")) + 1;	
		args.put("screenNum", String.valueOf(iScreenNum));					
		String padded = String.format("%05d", iScreenNum);			
		LOGGER.info("Inside takeScreenshot. Screenshot number: {}", iScreenNum);

		scrPath = testcaseFolderForScreenshot + File.separator + padded + "-" + pageName + ".jpg";
		
		LOGGER.info("Screenshot path: {}", scrPath);
		args.put("screenPath", testcaseFolderForScreenshot);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(scrPath));
		LOGGER.info("Screenshot taken and saved at: {}", scrPath);
	}

	/**
	 * Takes a full-page screenshot using AShot and saves it to the test case specific folder.
	 * This is a static method as it was in your original code, but it's *critical* that
	 * it also retrieves the path from the args HashMap to ensure isolation.
	 *
	 * @param args HashMap containing test execution parameters, must have 'screenNum' and 'tcFolderPath'.
	 * @param driver The WebDriver instance for the current test.
	 * @param pageName A descriptive name for the screenshot.
	 */
	public static void CaptureScreenshot(HashMap<String, String> args, WebDriver driver, String pageName) {
		try {
			int iScreenNum;
			String scrPath = "";
			String testcaseFolderForScreenshot = args.get("tcFolderPath"); 
			if (testcaseFolderForScreenshot == null || testcaseFolderForScreenshot.isEmpty()) {
				LOGGER.error("tcFolderPath is not set in args. Cannot take static screenshot.");
				throw new IllegalStateException("Test Case Folder Path (tcFolderPath) not found in args. Static screenshot cannot be saved.");
			}
			
			iScreenNum = Integer.parseInt(args.getOrDefault("screenNum", "0")) + 1;	
			args.put("screenNum", String.valueOf(iScreenNum));						
			String padded = String.format("%05d", iScreenNum);			
			scrPath = testcaseFolderForScreenshot + File.separator + padded + pageName + ".jpg";
			
			LOGGER.info("About to take AShot screenshot: {}", scrPath);
			
			ru.yandex.qatools.ashot.Screenshot fpScreenshot = new AShot()
					.shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);

			ImageIO.write(fpScreenshot.getImage(), "PNG", new File(scrPath));
			LOGGER.info("AShot Screenshot taken and saved at: {}", scrPath);
			
			args.put("screenPath", testcaseFolderForScreenshot);
	
		} catch (Exception e) {
			LOGGER.error("Error taking AShot screenshot for page {}: {}", pageName, e.getMessage(), e);
			System.err.println("Error in CaptureScreenshot: " + e.getMessage());
		}
	}
	
	public String getDOB(String dobYear)
	{
		
		int age = Integer.parseInt(dobYear);
		int dobDay = 10;

		LocalDate now1 = LocalDate.now();
		LocalDate dateofbirth = now1.minusYears(age)
				.minusDays(dobDay);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(dateofbirth.format(formatter));
		return dateofbirth.format(formatter);
		
	}
	
	
	public String getMobNo() {
		Random Mob = new Random();
		char[]digits = new char[10];
		digits[0]= (char) (8+'0');
		for(int i =1; i<digits.length;i++)
		{
			digits[i]=(char)(Mob.nextInt(10)+'0');
			
		}
		
		long MobNum = Long.parseLong(new String(digits));
		
		return String.valueOf(MobNum);
	}
	
	public String getEmail()
	{
		String Name =RandomStringUtils.randomAlphabetic(5).toLowerCase();
		
		String Email = Name+"@gmail.com";
		
		return Email;
	}
	
	public String randomFirstName()
	{
		String[] FIRST_NAMES = { "Harsha", "Rahul", "Sachin", "Saurav", "Chris", "Virat", "Michael", "Mahendra", "David", "Rohit" };	   

		 Random rand=new Random();
			
		 // Randomly pick a first name
	     String firstName = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
	     String Name = firstName;
	     return Name;
	}
	
	public String randomLastName()
	{
		String[] LAST_NAMES = { "Gowda", "Sharma", "Verma", "Kohli", "Singh", "Miller", "Davis", "Garcia", "Rodriguez", "Martinez"};

		 Random rand=new Random();
			
		 // Randomly pick a last name
			String lastName = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
			String Name = lastName ;
			return Name;
	}
	
	public void scrollToView(WebDriver driver,ExtendedWebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		js.executeScript("arguments[0].scrollIntoView();", element.getElement());
	}
	
	
	
	public void waitAndClick(ExtendedWebElement element) throws Exception {
		
		for (int i = 0; i < 50; i++)
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(2000);
			}
	}
	
	// New Code Below
	
	// Random Name Generation Methods
	public String getRandomFirstName() {
	    String[] firstNames = {"Amit", "Priya", "Rahul", "Sunita", "Vikash", "Kavita", "Suresh", "Meera", "Ravi", "Anjali"};
	    return firstNames[new Random().nextInt(firstNames.length)];
	}
	 
	public String getRandomMiddleName() {
	    String[] middleNames = {"Kumar", "Singh", "Devi", "Lal", "Prasad", "Bai", "Chand", "Kumari", "Das", "Raj"};
	    return middleNames[new Random().nextInt(middleNames.length)];
	}
	 
	public String getRandomLastName() {
	    String[] lastNames = {"Sharma", "Verma", "Gupta", "Singh", "Kumar", "Patel", "Shah", "Jain", "Agarwal", "Yadav"};
	    return lastNames[new Random().nextInt(lastNames.length)];
	}
	 
	public String getRandomFatherName() {
	    String[] fatherNames = {"Ramesh Sharma", "Mohan Verma", "Sunil Gupta", "Rajesh Singh", "Vijay Kumar", "Ashok Patel", "Deepak Shah", "Vinod Jain", "Prakash Agarwal", "Santosh Yadav"};
	    return fatherNames[new Random().nextInt(fatherNames.length)];
	}
	 
	public String getRandomMotherName() {
	    String[] motherNames = {"Sunita Sharma", "Kavita Verma", "Meera Gupta", "Rekha Singh", "Usha Kumar", "Geeta Patel", "Mala Shah", "Sita Jain", "Radha Agarwal", "Savita Yadav"};
	    return motherNames[new Random().nextInt(motherNames.length)];
	}
	 
	public String getRandomSpouseName() {
	    String[] spouseNames = {"Priya Sharma", "Anjali Verma", "Pooja Gupta", "Neha Singh", "Ritu Kumar", "Seema Patel", "Nisha Shah", "Anita Jain", "Deepika Agarwal", "Swati Yadav"};
	    return spouseNames[new Random().nextInt(spouseNames.length)];
	}
	 
	// Random Address Generation Methods
	public String getRandomAddress1() {
	    String[] addresses = {"123 MG Road", "456 Park Street", "789 Brigade Road", "321 Commercial Street", "654 Residency Road", "987 Church Street", "111 Koramangala", "222 Indiranagar", "333 Jayanagar", "444 Whitefield"};
	    return addresses[new Random().nextInt(addresses.length)];
	}
	 
	public String getRandomAddress2() {
	    String[] addresses2 = {"Near Metro Station", "Opp. Shopping Mall", "Behind Temple", "Next to Hospital", "Near School", "Opp. Bank", "Behind Market", "Next to Park", "Near Bus Stand", "Opp. Post Office"};
	    return addresses2[new Random().nextInt(addresses2.length)];
	}
	 
	public String getRandomCity() {
	    String[] cities = {"Mumbai", "Delhi", "Bangalore", "Chennai", "Kolkata", "Hyderabad", "Pune", "Ahmedabad", "Jaipur", "Lucknow"};
	    return cities[new Random().nextInt(cities.length)];
	}
	 
	public String getRandomState() {
	    String[] states = {"Maharashtra", "Delhi", "Karnataka", "Tamil Nadu", "West Bengal", "Telangana", "Gujarat", "Rajasthan", "Uttar Pradesh", "Madhya Pradesh"};
	    return states[new Random().nextInt(states.length)];
	}
	 
	public String getRandomPincode() {
	    return String.format("%06d", new Random().nextInt(999999));
	}
	 
	public String getRandomCountry() {
	    return "India"; // Most common for your use case
	}
	 
	public String getRandomBankName() {
	    String[] bankNames = {"ICICI Bank", "HDFC Bank", "State Bank of India", "Axis Bank", "PNB Bank", "Bank of Baroda", "Kotak Bank", "Yes Bank", "IDBI Bank", "Union Bank"};
	    return bankNames[new Random().nextInt(bankNames.length)];
	}
	
	// New Code Above
	
	
	
	
	
	
	public void waitForVisibilityOf(WebDriver driver,ExtendedWebElement element)
	{
		int maxWaitSeconds = 180;
		int intervalSeconds = 5;
		int retries = maxWaitSeconds / intervalSeconds;
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(intervalSeconds));
		
		for(int i = 0; i < retries ; i++)
		{
			try {
				wait.until(ExpectedConditions.visibilityOf(element.getElement()));	
				return;
			}catch (TimeoutException e) {
				
				 // Continue retrying
			}
			catch (Exception e) {
				
				 throw new RuntimeException("Error while waiting for visibility of element: " + element.getName(), e);
			}
		}
		
		throw new TimeoutException("Element '" + element.getName() + "' was not visible after " + maxWaitSeconds + " seconds.");
	}
	
	
		
	public void waitForVisibilityWithRetry(WebDriver driver, ExtendedWebElement element) {
	int maxWaitSeconds = 180;
	 int intervalSeconds = 5;
	 int retries = maxWaitSeconds / intervalSeconds;
	
	for (int i = 0; i < retries; i++) {
		try {
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(intervalSeconds));
	wait.until(ExpectedConditions.visibilityOf(element.getElement()));
	
	return;
	} catch (TimeoutException e) {
	} catch (Exception e) {
	
	 throw new RuntimeException("Error while waiting for visibility of element: " + element.getName(), e);
	}
	}
	
	throw new TimeoutException("Element '" + element.getName() + "' was not visible after " + maxWaitSeconds + " seconds.");
	}
	

	
	public void acceptAlert(WebDriver driver)
	{
		try {
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String todayDate() {
		Date currDate = new Date();
		SimpleDateFormat oDF = new SimpleDateFormat("dd/MM/yyyy");
		return oDF.format(currDate);
		
	}
}