package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.utils.CommonUtilities;
import com.web.utils.ImprovedWaits;
import com.web.utils.UIReportUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PNB_BasePlan_Page_6 extends AbstractPage {

	public PNB_BasePlan_Page_6(WebDriver driver) {
		super(driver);
	}

	// --- GEM Product Specific Elements ---

	// GEM TEXT
	@FindBy(xpath = "//*[text()=' PNB MetLife Goal Ensuring Multiplier ']")
	private ExtendedWebElement GEMtext;

	// Element 1: Premium (Input)
	@FindBy(xpath = "//label[text()='Premium']/following-sibling::app-input-number//input[@type='text']")
	private ExtendedWebElement Premium_Input;

	// Element 2: Frequency (Select)
	@FindBy(xpath = "//label[text()='Frequency']/following-sibling::app-input-mode//select[contains(@class,'form-select')]")
	private ExtendedWebElement Frequency_Dropdown;

	// Element 3: Plan (Select)
	@FindBy(xpath = "//label[contains(text(),'Plan')]/following-sibling::div//select[contains(@class,'form-select')]")
	private ExtendedWebElement Plan_Dropdown;

	// Element 4: Cover Term (ng-select)
	@FindBy(xpath = "//label[text()='Cover Term']/following-sibling::div//ng-select[@aria-label='--Select--']")
	private ExtendedWebElement CoverTerm_Dropdown;

	@FindBy(xpath = "//label[text()='Cover Term']/following-sibling::div//input[@role='combobox']")
	private ExtendedWebElement CoverTerm_Input;

	// Element 5: Payment Term (ng-select)
	@FindBy(xpath = "//label[text()='Payment Term']/following-sibling::div//ng-select[@aria-label='--Select--']")
	private ExtendedWebElement PaymentTerm_Dropdown;

	@FindBy(xpath = "//label[text()='Payment Term']/following-sibling::div//input[@role='combobox']")
	private ExtendedWebElement PaymentTerm_Input;

	// Element 6: Multiple (Input)
	@FindBy(xpath = "//label[text()='Multiple']/following-sibling::app-input-number//input[@type='text']")
	private ExtendedWebElement Multiple_Input;

	// Element 7: Smart Withdrawal Facility Flag (Buttons)
	@FindBy(xpath = "//label[contains(text(),'Smart Withdrawal Facility Flag')]/following-sibling::div//button[contains(text(),'Yes')]")
	private ExtendedWebElement SmartWithdrawal_Yes_Button;

	@FindBy(xpath = "//label[contains(text(),'Smart Withdrawal Facility Flag')]/following-sibling::div//button[contains(text(),'No')]")
	private ExtendedWebElement SmartWithdrawal_No_Button;

	// Element 8: Smart Withdrawal Percentage (Select - Conditional)
	@FindBy(xpath = "//label[contains(text(),'Smart Withdrawal Percentage')]/following-sibling::div//select[contains(@class,'form-select')]")
	private ExtendedWebElement SmartWithdrawalPercentage_Dropdown;

	// Element 9: Smart Withdrawal Frequency (Select - Conditional)
	@FindBy(xpath = "//label[contains(text(),'Smart Withdrawal Frequency')]/following-sibling::div//select[contains(@class,'form-select')]")
	private ExtendedWebElement SmartWithdrawalFrequency_Dropdown;

	// Element 10: Smart Withdrawal Start Year (Input - Conditional)
	@FindBy(xpath = "//label[contains(text(),'Smart Withdrawal Start Year')]/following-sibling::app-input-number//input[@placeholder='Withdrawal Start Year']")
	private ExtendedWebElement SmartWithdrawalStartYear_Input;

	// Joint Life conditional elements (add these @FindBy annotations to your class)
	@FindBy(xpath = "//label[contains(text(),'Joint Life Gender')]/following-sibling::div//select[contains(@class,'form-select')]")
	private ExtendedWebElement JointLifeGender_Dropdown;

	@FindBy(xpath = "//label[contains(text(),'Joint Life DOB')]/following-sibling::app-input-dob//input[@placeholder='DD MMM YYYY']")
	private ExtendedWebElement JointLifeDOB_Input;

	// Element 1 - Need more HTML to create precise XPath, using generic approach
	@FindBy(xpath = "//input[@type='text' and contains(@class,'form-control')]")
	private ExtendedWebElement JointLifeStartYear_Input; // Adjust this XPath when you provide Element 1 HTML

	// --- Strategy Toggle Elements (NEW) ---
	@FindBy(xpath = "//div[contains(@class,'strategy') and contains(.,'Life - Stage Strategy')]//label[@class='switch float-start']")
	private ExtendedWebElement LifeStageStrategy_Toggle;

	@FindBy(xpath = "//div[contains(@class,'strategy') and contains(.,'Systematic Transfer Strategy')]//label[@class='switch float-start']")
	private ExtendedWebElement SystematicTransferStrategy_Toggle;

	// --- Common Elements (Preserved from Previous Versions) ---
	@FindBy(xpath = "//*[text()=' Validation Successful ']")
	private ExtendedWebElement Validation;

	@FindBy(xpath = "//*[text()=' Resend Email ']")
	private ExtendedWebElement ResendEmail;

	@FindBy(xpath = "//*[@src='./assets/images/congratulation.png']")
	private ExtendedWebElement CongratulationsIMAGE;

	@FindBy(xpath = "//button[contains(@class, 'metactivebutt')]//span[text()='Download Illustration']")
	private ExtendedWebElement DOWNLOADILLUSTRATIONSUTABILTYANALYSIS;

	@FindBy(xpath = "//button[contains(@class, 'metactivebutt')]//span[text()=' Suitability Analysis']")
	private ExtendedWebElement SUTABILTY_ANALYSIS;

	@FindBy(xpath = "//button[contains(text(),'Save') and contains(text(),'Proceed')]")
	private ExtendedWebElement Saveandproceed;

	@FindBy(xpath = "(//button[contains(text(),' Proceed ')])[2]")
	private ExtendedWebElement Proceed;

	@FindBy(xpath = "//button[contains(text(),'Proceed Ahead')]")
	private ExtendedWebElement ProceedAhead;

	@FindBy(xpath = "//button[contains(text(),'ok')]")
	private ExtendedWebElement OkButton;

	@FindBy(xpath = "//*[text()='Recalculate']")
	private ExtendedWebElement Recalculate_BTN;

	@FindBy(xpath = "//*[text()=' Recalculate ']")
	private ExtendedWebElement Recalculate_BTN_2;

	@FindBy(xpath = "//*[text()=' Save & Proceed ']")
	private ExtendedWebElement Save_BTN;

	// Rider Elements
	@FindBy(xpath = "//*[text()='Attach Rider(s)']")
	private ExtendedWebElement Riders_Text;

	@FindBy(xpath = "//*[@class='fa-solid metplancart fa-trash cart-danger']")
	private ExtendedWebElement ADB_delete;

	@FindBy(xpath = "//i[contains(@class, 'fa-plus') and contains(@class, 'cart-primary')]")
	private ExtendedWebElement SI_Rider_1;

	@FindBy(xpath = "(//*[@class='form-control metinputtext ng-star-inserted'])[1]")
	private ExtendedWebElement ADB_Rider;

	@FindBy(xpath = "//*[text()=' PNB MetLife Accidental Death Benefit Rider Plus ']")
	private ExtendedWebElement ADB_RidersText;

	@FindBy(xpath = "(//*[@class='fa-solid metplancart fa-plus cart-primary'])[2]")
	private ExtendedWebElement SI_Rider_plussign;

	@FindBy(xpath = "(//*[@class='fa-solid metplancart fa-plus cart-primary'])")
	private ExtendedWebElement SI_Rider_plussign_one;

	@FindBy(xpath = "(//*[@class='form-control metinputtext ng-star-inserted'])[2]")
	private ExtendedWebElement SI_Rider;

	@FindBy(xpath = "//*[text()=' Recalculate ']")
	private ExtendedWebElement Rider_Recalculate_BTN;

	// Quote Summary Elements
	@FindBy(xpath = "//*[text()='Quote Summary']")
	private ExtendedWebElement Quote_Summary;

	@FindBy(xpath = "//*[text()=' Get Quote ']")
	private ExtendedWebElement Get_Quote_BTN;

	@FindBy(xpath = "//*[text()=' Validate ']")
	private ExtendedWebElement Validate;

	@FindBy(xpath = "//button[@class='offcanvasbutt' and contains(., 'Continue')]")
	private ExtendedWebElement Continue;

	// E Insurance Account Elements
	@FindBy(xpath = "//label[@for='accountType' and contains(normalize-space(.), 'Yes')]")
	private ExtendedWebElement EInsuranceAccount_Yes;

	@FindBy(xpath = "//*[@formcontrolname='insuranceAccountNumber']")
	private ExtendedWebElement EInsuranceAccountNumber;

	@FindBy(xpath = "//*[text()='CAMSRep']")
	private ExtendedWebElement CAMSRep_BTN;

	@FindBy(xpath = "(//*[text()='Karvy'])[1]")
	private ExtendedWebElement Karvy_BTN;

	@FindBy(xpath = "//*[text()='NDML']")
	private ExtendedWebElement NDML_BTN;

	@FindBy(xpath = "//*[text()='CIRL']")
	private ExtendedWebElement CIRL_BTN;
	
    //NEW
    
    @FindBy(xpath = "//*[@class='slider']")
    private ExtendedWebElement slider;
    
    @FindBy(xpath = "//*[text()=' Continue ']")
    private ExtendedWebElement Continue_BTN;
    
    @FindBy(xpath = "//*[text()='Save & Proceed ']")
    private ExtendedWebElement EinsuaranceSaveandproceed;  
	

	// --- Class Variables ---
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final int EXPLICIT_TIMEOUT = 30;
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
	CommonUtilities CU = new CommonUtilities();

	// --- Main Method ---
	public void Base_Plan(HashMap args) throws Throwable {
		String actualResult = (String) args.getOrDefault("ActualResult", "");

		try {
			PremiumPage(args);
			System.out.println("GEM Premium Page completed");
			Rider(args);
			handleStrategyToggles(args); // NEW: Handle strategy toggles
			if (((String) args.get("Choose_Fund")).equalsIgnoreCase("Yes")) {
				handleFundAllocation(args);
			}
			QuoteSummary(args);
			BIdownload(args);
			eInsuranceAC(args);

			actualResult += "GEM ILLUSTRATION & SUITABILITY ANALYSIS generated Successfully | ";
			args.put("ActualResult", actualResult);
			args.put("status", "Pass");
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage());
			actualResult += "Failed in GEM Base Plan Flow | ";
			actualResult += "*** " + e.getMessage() + " ***";
			args.put("ActualResult", actualResult);
			args.put("sOutput", e.toString());
			CU.takeScreenshot(args, getDriver(), "Error Page");

			if (((String) args.get("Test Case Type")).equalsIgnoreCase("Negative")) {
				args.put("status", "Pass");
			} else {
				args.put("status", "Fail");
			}
		}
	}

	// --- GEM PREMIUM PAGE METHOD ---
	public void PremiumPage(HashMap args) {
		try {
			// Wait for page to load (spinner to disappear)
			LOGGER.info("Starting GEM Premium Page configuration");
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
			wait.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'spinner-container')]")));
			System.out.println("GEM Page Loader disappeared");

			CU.scrollToView(driver, GEMtext);
			CU.scrollToView(driver, GEMtext);
			CU.scrollToView(driver, GEMtext);

			// 1. Premium Input
			handlePremium(args);

			// 3. Plan Selection
			handlePlan(args);

			// 5. Cover Term
			handleCoverTerm(args);

			// 6. Payment Term
			//handlePaymentTerm(args);

			// 2. Frequency Selection
			handleFrequency(args);

			// 4. Conditional Joint Life Elements (Only if Plan = "Wealth - Joint Life")
			handleConditionalJointLifeElements(args);

			// 7. Multiple Input
			
			handleMultiple(args);

			// 8. Smart Withdrawal Facility Flag (Key Decision Point)
			handleSmartWithdrawalFlag(args);

			// 9, 10, 11. Conditional Smart Withdrawal Elements (Only if Element 8 = Yes)
			//handleConditionalSmartWithdrawalElements(args);

			// Final Actions
			performFinalActions(args);

		} catch (Exception e) {
			System.out.println("##########Error Message Is " + e);
			handlePageError(e, args, "GEM PremiumPage");
		}
	}

	private void handlePremium(HashMap args) throws Exception {
		String premium = (String) args.get("Premium");
		LOGGER.info("Setting Premium: {}", premium);

		CU.waitForVisibilityOf(getDriver(), Premium_Input);

		Premium_Input.type(premium);
		LOGGER.info("Premium set to: {}", premium);
		pause(1);
	}

	private void handleFrequency(HashMap args) throws Exception {
		if (!((String) args.get("PaymentTerm")).equalsIgnoreCase("1")) {
		String frequency = (String) args.get("Frequency");
		LOGGER.info("Setting Frequency: {}", frequency);

		CU.waitForVisibilityOf(getDriver(), Frequency_Dropdown);
		Select select = new Select(Frequency_Dropdown.getElement());
		select.selectByVisibleText(frequency);
		LOGGER.info("Selected Frequency: {}", frequency);
		}
		pause(1);
	}

	private void handlePlan(HashMap args) throws Exception {
		String plan = (String) args.get("Plan");
		LOGGER.info("Setting Plan: {}", plan);

		CU.waitForVisibilityOf(getDriver(), Plan_Dropdown);
		Select select = new Select(Plan_Dropdown.getElement());
		select.selectByVisibleText(plan);
		LOGGER.info("Selected Plan: {}", plan);
		pause(2); // Extra pause to let conditional elements load
	}

	private void handleCoverTerm(HashMap args) throws Exception {
		String coverTerm = (String) args.get("CoverTerm");
		LOGGER.info("Setting Cover Term: {}", coverTerm);

		// CU.scrollToView(getDriver(), CoverTerm_Dropdown);
		CU.waitForVisibilityOf(getDriver(), CoverTerm_Dropdown);
		CoverTerm_Dropdown.click();
		pause(1);

		CU.waitForVisibilityOf(getDriver(), CoverTerm_Input);
		CoverTerm_Input.type(coverTerm);
		CoverTerm_Input.getElement().sendKeys(Keys.ENTER);
		LOGGER.info("Selected Cover Term: {} years", coverTerm);
		pause(1);
	}

	private void handlePaymentTerm(HashMap args) throws Exception {
		String paymentTerm = (String) args.get("PaymentTerm");
		LOGGER.info("Setting Payment Term: {}", paymentTerm);

		// CU.scrollToView(getDriver(), PaymentTerm_Dropdown);
		CU.waitForVisibilityOf(getDriver(), PaymentTerm_Dropdown);
		PaymentTerm_Dropdown.click();
		pause(1);

		CU.waitForVisibilityOf(getDriver(), PaymentTerm_Input);
		PaymentTerm_Input.type(paymentTerm);
		PaymentTerm_Input.getElement().sendKeys(Keys.ENTER);
		LOGGER.info("Selected Payment Term: {} years", paymentTerm);
		pause(1);
	}

	private void handleMultiple(HashMap args) throws Exception {
		String multiple = (String) args.get("Multiple");
		LOGGER.info("Setting Multiple: {}", multiple);

		CU.waitForVisibilityOf(getDriver(), Multiple_Input);

		Multiple_Input.type(multiple);
		LOGGER.info("Multiple set to: {}", multiple);
		pause(1);
	}

	private void handleSmartWithdrawalFlag(HashMap args) throws Exception {
		String smartWithdrawalFlag = (String) args.get("SmartWithdrawalFlag");
		LOGGER.info("Setting Smart Withdrawal Facility Flag: {}", smartWithdrawalFlag);

		if ("Yes".equalsIgnoreCase(smartWithdrawalFlag)) {
			CU.waitForVisibilityOf(getDriver(), SmartWithdrawal_Yes_Button);
			SmartWithdrawal_Yes_Button.click();
			LOGGER.info("Selected Smart Withdrawal Facility: Yes");
		} else {
			CU.waitForVisibilityOf(getDriver(), SmartWithdrawal_No_Button);
			SmartWithdrawal_No_Button.click();
			LOGGER.info("Selected Smart Withdrawal Facility: No");
		}
		pause(2); // Wait for conditional elements to appear/disappear
	}

	private void handleConditionalSmartWithdrawalElements(HashMap args) throws Exception {
		String smartWithdrawalFlag = (String) args.get("SmartWithdrawalFlag");

		// Only process elements 8, 9, 10 if Smart Withdrawal Flag = "Yes"
		if ("Yes".equalsIgnoreCase(smartWithdrawalFlag)) {
			LOGGER.info("Processing conditional Smart Withdrawal elements (Elements 8, 9, 10)");

			// Element 8: Smart Withdrawal Percentage
			String withdrawalPercentage = (String) args.get("SmartWithdrawalPercentage");
			LOGGER.info("Setting Smart Withdrawal Percentage: {}", withdrawalPercentage);
			CU.waitForVisibilityOf(getDriver(), SmartWithdrawalPercentage_Dropdown);
			Select percentageSelect = new Select(SmartWithdrawalPercentage_Dropdown.getElement());
			percentageSelect.selectByVisibleText(withdrawalPercentage);
			pause(1);

			// Element 9: Smart Withdrawal Frequency
			String withdrawalFrequency = (String) args.get("SmartWithdrawalFrequency");
			LOGGER.info("Setting Smart Withdrawal Frequency: {}", withdrawalFrequency);
			CU.waitForVisibilityOf(getDriver(), SmartWithdrawalFrequency_Dropdown);
			Select frequencySelect = new Select(SmartWithdrawalFrequency_Dropdown.getElement());
			frequencySelect.selectByVisibleText(withdrawalFrequency);
			pause(1);

			// Element 10: Smart Withdrawal Start Year
			String withdrawalStartYear = (String) args.get("SmartWithdrawalStartYear");
			LOGGER.info("Setting Smart Withdrawal Start Year: {}", withdrawalStartYear);
			CU.waitForVisibilityOf(getDriver(), SmartWithdrawalStartYear_Input);
			SmartWithdrawalStartYear_Input.type(withdrawalStartYear);
			pause(1);

			LOGGER.info("All conditional Smart Withdrawal elements processed successfully");
		} else {
			LOGGER.info(
					"Skipping conditional Smart Withdrawal elements (Elements 8, 9, 10) - Smart Withdrawal Flag is No");
		}
	}

	// NEW METHOD: Handle Joint Life Elements Conditionally
	private void handleConditionalJointLifeElements(HashMap args) throws Exception {
		String plan = (String) args.get("Plan");

		// Only process Joint Life elements if Plan = "Wealth - Joint Life"
		if ("Wealth - Joint Life".equalsIgnoreCase(plan)) {
			LOGGER.info("Processing conditional Joint Life elements (Plan = Wealth - Joint Life)");

			// Element 1: Joint Life Start Year
			String jointLifeStartYear = (String) args.get("JointLifeStartYear");
			if (jointLifeStartYear != null && !jointLifeStartYear.trim().isEmpty()) {
				LOGGER.info("Setting Joint Life Start Year: {}", jointLifeStartYear);
				CU.waitForVisibilityOf(getDriver(), JointLifeStartYear_Input);
				JointLifeStartYear_Input.type(jointLifeStartYear);
				pause(1);
			}

			// Element 2: Joint Life Gender
			String jointLifeGender = (String) args.get("JointLifeGender");
			LOGGER.info("Setting Joint Life Gender: {}", jointLifeGender);
			CU.waitForVisibilityOf(getDriver(), JointLifeGender_Dropdown);
			Select genderSelect = new Select(JointLifeGender_Dropdown.getElement());
			genderSelect.selectByVisibleText(jointLifeGender);
			pause(1);

			// Element 3: Joint Life DOB
			String jointLifeDOB = (String) args.get("JointLifeDOB");
			LOGGER.info("Setting Joint Life DOB: {}", jointLifeDOB);
			CU.waitForVisibilityOf(getDriver(), JointLifeDOB_Input);
			JointLifeDOB_Input.type(jointLifeDOB);
			pause(1);

			LOGGER.info("All conditional Joint Life elements processed successfully");
		} else {
			LOGGER.info("Skipping conditional Joint Life elements - Plan is not 'Wealth - Joint Life' (Plan: {})",
					plan);
		}
	}

	private void performFinalActions(HashMap args) throws Exception {
		LOGGER.info("Performing final actions - Recalculate and Save");

		// Scroll to and capture before recalculation
		CU.scrollToView(getDriver(), Recalculate_BTN);
		CommonUtilities.CaptureScreenshot(args, getDriver(), "GEM_Premium_Before_Recalculate");

		// Recalculate
		CU.waitForVisibilityOf(getDriver(), Recalculate_BTN);
		Recalculate_BTN.click();
		LOGGER.info("Clicked Recalculate button");

		// Wait for calculation to complete
		pause(5);
		CU.waitForVisibilityOf(getDriver(), Save_BTN);

		// Capture after recalculation
		CU.scrollToView(getDriver(), Save_BTN);
		CommonUtilities.CaptureScreenshot(args, getDriver(), "GEM_Premium_After_Recalculate");

		// Save and proceed
		Save_BTN.click();
		LOGGER.info("Clicked Save & Proceed button");
		pause(3);
	}

	// --- NEW STRATEGY TOGGLES METHOD ---
	public void handleStrategyToggles(HashMap args) {
		try {
			LOGGER.info("Starting Strategy Toggles configuration");

			// Handle Life Stage Strategy Toggle
			String lifeStageStrategy = (String) args.get("Life_Stage_Strategy");
			if ("Yes".equalsIgnoreCase(lifeStageStrategy)) {
				LOGGER.info("Enabling Life - Stage Strategy toggle");
				CU.waitForVisibilityOf(getDriver(), LifeStageStrategy_Toggle);
				LifeStageStrategy_Toggle.click();
				LOGGER.info("Life - Stage Strategy toggle enabled");
				pause(1);
				pause(1);
				CommonUtilities.CaptureScreenshot(args, getDriver(), "LifeStageStrategy_Toggle");

				// Add results to args for reporting
				// args.put("SuccessfulFunds", String.join(", ", successfulFunds));
				// args.put("FailedFunds", String.join(", ", failedFunds));

				CU.waitForVisibilityOf(getDriver(), Recalculate_BTN_2);
				Recalculate_BTN_2.click();
				LOGGER.info("Clicked Recalculate button");

				CU.waitForVisibilityOf(getDriver(), Save_BTN);
				Save_BTN.click();
			} else {
				LOGGER.info("Life - Stage Strategy toggle not enabled (value: {})", lifeStageStrategy);
			}

			// Handle Systematic Transfer Strategy Toggle
			String systematicTransferStrategy = (String) args.get("Systematic_Transfer_Strategy");
			if ("Yes".equalsIgnoreCase(systematicTransferStrategy)) {
				LOGGER.info("Enabling Systematic Transfer Strategy toggle");
				CU.waitForVisibilityOf(getDriver(), SystematicTransferStrategy_Toggle);
				SystematicTransferStrategy_Toggle.click();
				LOGGER.info("Systematic Transfer Strategy toggle enabled");
				pause(1);
				pause(1);
				CommonUtilities.CaptureScreenshot(args, getDriver(), "SystematicTransferStrategy_Toggle");

				// Add results to args for reporting
				// args.put("SuccessfulFunds", String.join(", ", successfulFunds));
				// args.put("FailedFunds", String.join(", ", failedFunds));

				CU.waitForVisibilityOf(getDriver(), Recalculate_BTN_2);
				Recalculate_BTN_2.click();
				LOGGER.info("Clicked Recalculate button");

				CU.waitForVisibilityOf(getDriver(), Save_BTN);
				Save_BTN.click();
			} else {
				LOGGER.info("Systematic Transfer Strategy toggle not enabled (value: {})", systematicTransferStrategy);
			}

			LOGGER.info("Strategy Toggles configuration completed");

		} catch (Exception e) {
			LOGGER.error("Error in handleStrategyToggles: {}", e.getMessage());
			handlePageError(e, args, "handleStrategyToggles");
		}
	}

	// --- Error Handler ---
	private void handlePageError(Exception e, HashMap args, String elementName, String expectedValue,
			String actualValue) {
		String pageName = this.getClass().getSimpleName();
		String errorMsg = String.format("Failed on %s: Element: %s | Expected: %s | Actual: %s", pageName, elementName,
				expectedValue, actualValue);
		LOGGER.error(errorMsg, e);
		System.err.println(errorMsg);

		String actualResult = (String) args.getOrDefault("ActualResult", "");
		actualResult += errorMsg + " | ";
		args.put("ActualResult", actualResult);
		args.put("sOutput", errorMsg);
		args.put("status", "Fail");

		CommonUtilities.CaptureScreenshot(args, getDriver(), "ErrorPage");
		throw new RuntimeException(errorMsg, e);
	}

	private void handlePageError(Exception e, HashMap args, String context) {
		handlePageError(e, args, context, "N/A", "N/A");
	}

	// --- Rider Method ---
	public void Rider(HashMap args) {
		try {

			pause(5);
			System.out.println("Testing begins for rider");

			// ADB Rider
			if (((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("Yes")) {
				ADB_Rider.click();
				ADB_Rider.type((String) args.get("ADB_Rider_Amount"));

				CU.takeScreenshot(args, driver, "Rider page 1");
				// CU.scrollToView(driver, Riders_Text);

				Rider_Recalculate_BTN.click();
				CU.waitForVisibilityOf(driver, Save_BTN);
				CU.takeScreenshot(args, driver, "Rider page 2");

				Save_BTN.click();
				
			}

			if (((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("No")) {
				ADB_Rider.click();
				ADB_Rider.type("0");
				pause(1);
				ADB_delete.click();
				pause(3);
				CU.takeScreenshot(args, driver, "Rider page 1");
				// CU.scrollToView(driver, Riders_Text);
				//Rider_Recalculate_BTN.click();
				// Rider_Recalculate_BTN.click();
				CU.waitForVisibilityOf(driver, Save_BTN);
				// CU.takeScreenshot(args, driver, "Rider page 2");

				Save_BTN.click();

			}
//
//			// SI rider
//			if (((String) args.get("SI_Rider_Flagger")).equalsIgnoreCase("Yes")
//					&& ((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("Yes")) {
//				SI_Rider_plussign_one.click();
//				pause(1);
//				SI_Rider.type((String) args.get("SI_Rider_Amount"));
//				CU.scrollToView(getDriver(), ADB_RidersText);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider1");
//				CU.scrollToView(getDriver(), Riders_Text);
//				Rider_Recalculate_BTN.click();
//				CU.waitForVisibilityOf(getDriver(), Save_BTN);
//				CU.scrollToView(getDriver(), Riders_Text);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider2");
//				CU.scrollToView(getDriver(), Riders_Text);
//				Save_BTN.click();
//			}
//
//			if (((String) args.get("SI_Rider_Flagger")).equalsIgnoreCase("Yes")
//					&& ((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("No")) {
//				pause(1);
//				SI_Rider_plussign.click();
//				pause(1);
//				SI_Rider.type((String) args.get("SI_Rider_Amount"));
//				CU.scrollToView(getDriver(), ADB_RidersText);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider1");
//				CU.scrollToView(getDriver(), Riders_Text);
//				Rider_Recalculate_BTN.click();
//				CU.waitForVisibilityOf(getDriver(), Save_BTN);
//				CU.scrollToView(getDriver(), Riders_Text);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider2");
//				CU.scrollToView(getDriver(), Riders_Text);
//				pause(1);
//				Save_BTN.click();
//			}
//
//			if (((String) args.get("SI_Rider_Flagger")).equalsIgnoreCase("No")
//					&& ((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("Yes")) {
//				pause(1);
//				CU.scrollToView(getDriver(), ADB_RidersText);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider1");
//				CU.scrollToView(getDriver(), Riders_Text);
//				Rider_Recalculate_BTN.click();
//				CU.waitForVisibilityOf(getDriver(), Save_BTN);
//				CU.scrollToView(getDriver(), Riders_Text);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "Rider2");
//				CU.scrollToView(getDriver(), Riders_Text);
//				pause(1);
//				Save_BTN.click();
//			}
//
//			if (((String) args.get("SI_Rider_Flagger")).equalsIgnoreCase("No")
//					&& ((String) args.get("ADB_Rider_Flagger")).equalsIgnoreCase("No")) {
//				CU.scrollToView(getDriver(), Riders_Text);
//				CommonUtilities.CaptureScreenshot(args, getDriver(), "RiderDetails");
//				CU.scrollToView(getDriver(), Riders_Text);
//				CU.waitForVisibilityOf(getDriver(), Save_BTN);
//				pause(1);
//				Save_BTN.click();
//			}
//

		} catch (Exception e) {
			System.out.println("##########Error Message Is " + e);
			handlePageError(e, args, "Rider (outer catch)");
		}
	}

	// --- Fund Allocation Method ---

	private List<String> getFundColumnNames() {
		// FIXED: Added "ValueFund" to the list so it gets processed after reset
		return Arrays.asList("ValueFund", // ✅ ADDED: This was missing!
				"Nifty_500_Momentum_50_Index_Fund", "Bharat_Consumption_Fund", "Bharat_Manufacturing_Fund",
				"Bond_Opportunities_Fund", "Liquid_Fund", "Protector_II", "Balanced_Opportunities_Fund", "Balancer_II",
				"Multiplier_III", "Sustainable_Equity_Fund", "India_Opportunities_Fund", "CREST_(thematic fund)",
				"Flexi_Cap", "Mid_Cap_Fund", "Premier_Multi-cap_Fund", "Virtue_II", "Small_Cap_Fund");
	}

	private void processSingleFund(String displayName, String fundValue, HashMap args) throws Exception {
		// Create XPath for specific fund using our container-scope approach
		String xpath = "//div[contains(@class,'fund-border') and .//div[text()='" + displayName
				+ "']]//input[@maxlength='4']";

		try {
			// Wait for element to be present
			WebElement fundInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

			// Scroll to element for better visibility
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'})",
					fundInput);
			pause(1);

			// Wait for element to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(fundInput));

			// Clear existing value and type new value
			fundInput.clear();
			pause(0.5);
			fundInput.sendKeys(fundValue);
			pause(0.5);

			// Verify the value was entered correctly
			String enteredValue = fundInput.getAttribute("value");
			if (!fundValue.equals(enteredValue)) {
				LOGGER.warn("Value mismatch for {}: Expected={}, Actual={}", displayName, fundValue, enteredValue);
			}

			LOGGER.info("Successfully set {} to {}%", displayName, fundValue);

		} catch (Exception e) {
			throw new RuntimeException(
					"Failed to process fund: " + displayName + " with value: " + fundValue + " using XPath: " + xpath,
					e);
		}
	}

	public void handleFundAllocation(HashMap args) {
		if (((String) args.get("Choose_Fund")).equalsIgnoreCase("Yes")) {
			LOGGER.info("Starting Fund Allocation Process");
			List<String> successfulFunds = new ArrayList<>();
			List<String> failedFunds = new ArrayList<>();
			System.out.println("=== ALL FUND COLUMNS DEBUG ===");

			try {
				// Step 1: First reset Value Fund from default 100% to 0%
				resetValueFundToZero();

				// Step 2: Get all fund column names from Excel (now includes ValueFund)
				List<String> fundColumns = getFundColumnNames();
				for (String excelColumnName : fundColumns) {
					String fundValue = (String) args.get(excelColumnName);
					System.out.println("Column: [" + excelColumnName + "] | Value: [" + fundValue + "]");
					System.out.println("-------------------Check-------------------");
					System.out.println("-------------------Check-------------------");
				}

				// Step 3: Process each fund including Value Fund
				for (String excelColumnName : fundColumns) {
					try {
						String fundValue = (String) args.get(excelColumnName);

						// Add these print statements right after getting the value:
						if ("Premier Multi-cap Fund".equals(excelColumnName)) {
							System.out.println("=== PREMIER MULTI-CAP FUND DEBUG ===");
							System.out.println("Excel Column Name: " + excelColumnName);
							System.out.println("Fund Value from Excel: [" + fundValue + "]");
							System.out.println("Is null? " + (fundValue == null));
							System.out.println("Is empty? " + (fundValue != null && fundValue.trim().isEmpty()));
							System.out.println("=====================================");
							System.out.println("=====================================");
						}
						// Skip only if value is null or empty (allow 0 values)
						if (fundValue == null || fundValue.trim().isEmpty()) {
							LOGGER.info("Skipping fund {} - no value provided", excelColumnName);
							continue;
						}

						// Convert Excel column name to display name
						String displayName = convertExcelNameToDisplayName(excelColumnName);

						// Process the fund allocation
						processSingleFund(displayName, fundValue, args);
						successfulFunds.add(displayName + "=" + fundValue + "%");
						LOGGER.info("Successfully processed fund: {} with value: {}%", displayName, fundValue);

					} catch (Exception e) {
						String displayName = convertExcelNameToDisplayName(excelColumnName);
						failedFunds.add(displayName + " (Error: " + e.getMessage() + ")");
						LOGGER.error("Failed to process fund: {} - {}", displayName, e.getMessage());
						// Continue with next fund (Continue Processing approach)
					}
				}

				// Final results logging
				LOGGER.info("Fund Allocation Summary - Successful: {}, Failed: {}", successfulFunds.size(),
						failedFunds.size());

				if (!successfulFunds.isEmpty()) {
					LOGGER.info("Successfully processed funds: {}", String.join(", ", successfulFunds));
				}

				if (!failedFunds.isEmpty()) {
					LOGGER.warn("Failed to process funds: {}", String.join(", ", failedFunds));
				}

				// Take screenshot after fund allocation
				CommonUtilities.CaptureScreenshot(args, getDriver(), "Fund_Allocation_Completed");

				// Add results to args for reporting
				args.put("SuccessfulFunds", String.join(", ", successfulFunds));
				args.put("FailedFunds", String.join(", ", failedFunds));

				CU.waitForVisibilityOf(getDriver(), Recalculate_BTN_2);
				Recalculate_BTN_2.click();
				LOGGER.info("Clicked Recalculate button");

				
				
				CommonUtilities.CaptureScreenshot(args, getDriver(), "After Fund_Allocation_Completed");

				CU.waitForVisibilityOf(getDriver(), Save_BTN);
				Save_BTN.click();

			} catch (Exception e) {
				LOGGER.error("Critical error in fund allocation process: {}", e.getMessage());
				handlePageError(e, args, "handleFundAllocation");
			}
		}
	}

	private void resetValueFundToZero() throws Exception {
		try {
			LOGGER.info("Resetting Value Fund from default 100% to 0%");

//			// Find Value Fund input using the container-scope approach
//			//String xpath = "//div[contains(@class,'fund-border') and .//div[text()='Value Fund']]//input[@maxlength='4']";
//		//	WebElement valueFundInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
//
//			// Scroll to element
//			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'})",
//					valueFundInput);
//			pause(1);
//
//			// Alternative to .clear() since it throws error - use JavaScript
//			((JavascriptExecutor) getDriver()).executeScript("arguments[0].value = '';", valueFundInput);
//			pause(0.5);
//
//			// Set to 0
//			valueFundInput.sendKeys("0");
//			pause(0.5);

			LOGGER.info("Successfully reset Value Fund to 0%");

		} catch (Exception e) {
			LOGGER.error("Failed to reset Value Fund to 0%: {}", e.getMessage());
			throw new RuntimeException("Failed to reset Value Fund to 0%", e);
		}

	}

	private String convertExcelNameToDisplayName(String excelColumnName) {
		// Handle special cases first
		if ("ValueFund".equals(excelColumnName)) {
			return "Value Fund";
		}

		if ("Premier Multi-cap Fund".equals(excelColumnName)) {
			return "Premier Multi-cap Fund"; // Return as-is since it already has correct format
		}

		// Future-proof automatic conversion for other funds
		return excelColumnName.replace("_", " ") // Handle underscores
				// .replace("-", " ") // Handle hyphens
				.replace(".", " ") // Handle dots
				.replaceAll("\\s+", " ") // Multiple spaces to single space
				.replace("(", "(") // Keep parentheses as-is
				.replace(")", ")") // Keep parentheses as-is
				.trim(); // Clean up whitespace
	}

	// --- Quote Summary Method ---
	public void QuoteSummary(HashMap args) {
		try {
			try {
				CU.waitForVisibilityOf(getDriver(), Quote_Summary);
			} catch (Exception e) {
				handlePageError(e, args, "Quote_Summary", "Visible", "Not visible");
			}

			try {
				CommonUtilities.CaptureScreenshot(args, getDriver(), "Quote Summary Page3");
			} catch (Exception e) {
				handlePageError(e, args, "CaptureScreenshot", "Captured", "Not captured");
			}

			try {
				Get_Quote_BTN.click();
			} catch (Exception e) {
				handlePageError(e, args, "Get_Quote_BTN", "Clicked", "Not clicked");
			}

		} catch (Exception e) {
			System.out.println("##########Error Message Is " + e);
			handlePageError(e, args, "QuoteSummary (outer catch)");
		}
	}

	// --- BI Download Method ---
	public void BIdownload(HashMap args) {
		try {
			try {
				CU.scrollToView(getDriver(), CongratulationsIMAGE);
				CU.waitForVisibilityOf(getDriver(), CongratulationsIMAGE);
			} catch (Exception e) {
				handlePageError(e, args, "CongratulationsIMAGE", "Visible", "Not visible");
			}

			CU.scrollToView(getDriver(), ResendEmail);
			CU.scrollToView(getDriver(), ResendEmail);
			CU.scrollToView(getDriver(), ResendEmail);
			CU.scrollToView(getDriver(), ResendEmail);
			CU.scrollToView(getDriver(), ResendEmail);
			CU.scrollToView(getDriver(), ResendEmail);

			try {
				DOWNLOADILLUSTRATIONSUTABILTYANALYSIS.click();
				//pause(10);
			} catch (Exception e) {
				System.out.println("##########Error Message Is " + e);
				handlePageError(e, args, "DOWNLOADILLUSTRATIONSUTABILTYANALYSIS", "Clicked", "Not clicked");
			}

			try {
				SUTABILTY_ANALYSIS.click();
				//pause(10);
			} catch (Exception e) {
				handlePageError(e, args, "SUTABILTY_ANALYSIS", "Clicked", "Not clicked");
			}

			try {
				CU.acceptAlert(getDriver());
			} catch (Exception e) {
				handlePageError(e, args, "acceptAlert", "Accepted", "Not accepted");
			}

			pause(5);
			try {
				Saveandproceed.click();
			} catch (Exception e) {
				handlePageError(e, args, "Saveandproceed", "Clicked", "Not clicked");
			}

			pause(2);
			try {
				ProceedAhead.click();
			} catch (Exception e) {
				handlePageError(e, args, "ProceedAhead", "Clicked", "Not clicked");
			}

			try {

				WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));

				WebElement appNumContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(

						By.xpath("//div[contains(text(),'Your Application Number is')]/strong")

				));

				String appNumber = appNumContainer.getText().trim();

				args.put("sAppNo", appNumber);

				LOGGER.info("Application Number (Page 6) extracted and backed up: {}", appNumber);

				try {

					UIReportUtils.WriteToExcel(args);

				} catch (Throwable t) {

					LOGGER.error("Backup application number write failed at Page 6: {}", t.getMessage(), t);

				}

			} catch (Exception e) {

				LOGGER.error("Could not extract Application Number after ProceedAhead on Page 6: {}", e.getMessage(),
						e);

			}

			pause(5);
			try {
				Proceed.click();
			} catch (Exception e) {
				handlePageError(e, args, "OkButton", "Clicked", "Not clicked");
			}
			CU.takeScreenshot(args, getDriver(), "Application number");

			pause(2);
			try {
				Validate.click();
			} catch (Exception e) {
				handlePageError(e, args, "Validate", "Clicked", "Not clicked");
			}
			pause(1);
			slider.click();

			pause(2);
			try {
				Continue_BTN.click();
			} catch (Exception e) {
				handlePageError(e, args, "Continue", "Clicked", "Not clicked");
			}

			pause(10);
			try {
				Saveandproceed.click();
			} catch (Exception e) {
				handlePageError(e, args, "Saveandproceed (final)", "Clicked", "Not clicked");
			}

			pause(3);
		} catch (Exception e) {
			handlePageError(e, args, "BIdownload (outer catch)");
		}
	}

	// --- eInsurance AC Method ---
	public void eInsuranceAC(HashMap args) {
		try {
			if (((String) args.get("E-Insurance")).equalsIgnoreCase("Yes")) {
				try {
					EInsuranceAccount_Yes.click();
				} catch (Exception e) {
					System.out.println("##########Error Message Is " + e);
					handlePageError(e, args, "EInsuranceAccount_Yes", "Clicked", "Not clicked");
				}

				try {
					EInsuranceAccountNumber.type((String) args.get("E-Account_Number"));
				} catch (Exception e) {
					System.out.println("##########Error Message Is " + e);
					handlePageError(e, args, "EInsuranceAccountNumber", (String) args.get("E-Account_Number"),
							"Not set");
				}
			}

			if (((String) args.get("E-Insurance")).equalsIgnoreCase("No")) {
				try {
					String eia = (String) args.get("E-IA");
					if (eia.equalsIgnoreCase("CAMS")) {
						try {
							CAMSRep_BTN.click();
						} catch (Exception e) {
							handlePageError(e, args, "CAMSRep_BTN", "Clicked", "Not clicked");
						}
					}
					if (eia.equalsIgnoreCase("Karvy")) {
						try {
							Karvy_BTN.click();
						} catch (Exception e) {
							handlePageError(e, args, "Karvy_BTN", "Clicked", "Not clicked");
						}
					}
					if (eia.equalsIgnoreCase("NDML")) {
						try {
							NDML_BTN.click();
						} catch (Exception e) {
							handlePageError(e, args, "NDML_BTN", "Clicked", "Not clicked");
						}
					}
					if (eia.equalsIgnoreCase("CIRL")) {
						try {
							CIRL_BTN.click();
						} catch (Exception e) {
							handlePageError(e, args, "CIRL_BTN", "Clicked", "Not clicked");
						}
					}
				} catch (Exception e) {
					handlePageError(e, args, "E-IA Switch", (String) args.get("E-IA"), "Not clicked");
				}
			}

			try {
				EinsuaranceSaveandproceed.click();
			} catch (Exception e) {
				System.out.println("##########Error Message Is " + e);
				handlePageError(e, args, "EInsuranceProceedsave_BTN", "Clicked", "Not clicked");
			}

		} catch (Exception e) {
			System.out.println("##########Error Message Is " + e);
			handlePageError(e, args, "eInsuranceAC (outer catch)");
		}
	}

	// --- Utility Methods ---
	private void pause(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
