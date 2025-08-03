package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.utils.CommonUtilities;
import com.web.utils.ImprovedWaits;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PNB_PiPODifferent_KnowYourCustomer extends AbstractPage {

	public PNB_PiPODifferent_KnowYourCustomer(WebDriver driver) {
		super(driver);
	}

	// --- ALL @FindBy ELEMENTS ---
	// Initial Selection
	@FindBy(xpath = "//button[normalize-space(text())='Family Member']")
	private ExtendedWebElement FamilyMember;
	@FindBy(xpath = "//button[normalize-space(text())='Continue with Family Member']")
	private ExtendedWebElement ContinueWithFamilyMember;

	// PO Basic Info
	@FindBy(xpath = "//label[normalize-space(text())='How is the Policy Owner related to the Policy Insured?']/following::ng-select[1]")
	private ExtendedWebElement PO_Relation;
	@FindBy(xpath = "(//*[text()='%s'])[last()]")
	private ExtendedWebElement PO_Relation_DropDownValue;
	@FindBy(xpath = "//label[normalize-space(text())=\"Policy Owner's Residential Status\"]/following::ng-select[1]")
	private ExtendedWebElement PO_ResidentialStatus;
	@FindBy(xpath = "//label[normalize-space(text())=\"Policy Owner's Email ID\"]/following::input[@formcontrolname='POEmailid'][1]")
	private ExtendedWebElement PO_Email;
	@FindBy(xpath = "//input[@formcontrolname='POmobileno']")
	private ExtendedWebElement PO_Number;

	// PO KYC
	@FindBy(xpath = "//button[normalize-space(text())=\"Quickly fill Policy owner's information from Aadhar\"]")
	private ExtendedWebElement QuickFill_Button;
	@FindBy(xpath = "//input[@formcontrolname='aadhaarno']")
	private ExtendedWebElement PO_Aadhar;
	@FindBy(xpath = "//input[@type='checkbox' and @formcontrolname='ischecked']")
	private ExtendedWebElement ischecked;
	@FindBy(xpath = "//*[text()='Generate Code']")
	private ExtendedWebElement Generate_OTP_Btn;
	@FindBy(xpath = "//*[text()='Verify Code']")
	private ExtendedWebElement Verify_OTP;
	@FindBy(xpath = "//input[@formcontrolname='autheniticatePAN']")
	private ExtendedWebElement Pan;
	@FindBy(xpath = "//button[normalize-space(text())='Save & Proceed']")
	private ExtendedWebElement SaveProceed;

	// PO Family Details
	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[2]")
	private ExtendedWebElement Father_Firtst_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[2]")
	private ExtendedWebElement Father_Last_Name;
	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[3]")
	private ExtendedWebElement Mother_First_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[3]")
	private ExtendedWebElement Mother_Last_Name;
	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[4]")
	private ExtendedWebElement Spouse_First_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[4]")
	private ExtendedWebElement Spouse_Last_Name;

	// PO Profile
	@FindBy(xpath = "//ng-select[@formcontrolname='educationalQualification']")
	private ExtendedWebElement customereducationalField;

	@FindBy(xpath = "(//span[text()='%s'])[last()]")
	private ExtendedWebElement dropdown_education;

	@FindBy(xpath = "//ng-select[@formcontrolname='occupation']")
	private ExtendedWebElement customerOccupationField;

	@FindBy(xpath = "(//span[text()='%s'])[last()]")
	private ExtendedWebElement dropdown_occupation;

	@FindBy(xpath = "//ng-select[@formcontrolname='jobProfile']")
	private ExtendedWebElement Jobprofile;

	@FindBy(xpath = "//ng-select[@formcontrolname='jobProfile']//input[@role='combobox']")
	private ExtendedWebElement Jobprofile_Type;

	@FindBy(xpath = "//input[@formcontrolname='annualIncome']")
	private ExtendedWebElement AnnualIncome;

	@FindBy(xpath = "//label[@for='inhouseEmployee1']")
	private ExtendedWebElement PNB_Yes;

	@FindBy(xpath = "//label[@for='inhouseEmployee2']")
	private ExtendedWebElement PNB_No;

	@FindBy(xpath = "//input[@formcontrolname='workplace']")
	private ExtendedWebElement CustomerWorkspace;

	@FindBy(xpath = "//*[text()=' Save & Proceed ']")
	private ExtendedWebElement Save_btn_Customer_Profile;

	// PO Bank Details
	@FindBy(xpath = "//input[@name='accountNumber']")
	private ExtendedWebElement PO_accountNumber;
	@FindBy(xpath = "//input[@name='confirmaccountNumber']")
	private ExtendedWebElement PO_ConfirmaccountNumber;
	@FindBy(xpath = "//label[text()=' Savings']")
	private ExtendedWebElement Saving_BTN;
	@FindBy(xpath = "//label[text()=' Current']")
	private ExtendedWebElement Current_BTN;
	@FindBy(xpath = "//input[@name='ifscCode']")
	private ExtendedWebElement PO_IfscCode;
	@FindBy(xpath = "//*[text()='Validate']")
	private ExtendedWebElement Validate_BTN;
	@FindBy(xpath = "//*[text()='Yes']")
	private ExtendedWebElement TC_Yes;
	@FindBy(xpath = "//*[text()='No']")
	private ExtendedWebElement TC_No;
	@FindBy(xpath = "//*[text()='Ok']")
	private ExtendedWebElement Ok_BTN;
	@FindBy(xpath = "//button[normalize-space(text())='Save & Proceed']")
	private ExtendedWebElement Save_btnn_BankDetail;

	// Final Proceed Button
	@FindBy(xpath = "//button[normalize-space(text())='Proceed Ahead with PI Information']")
	private ExtendedWebElement ProceedAhead_PIInfo;

	// --- PI (Policy Insured) Details ---
	@FindBy(xpath = "//ng-select[@formcontrolname='customerResidentialStatuspo']")
	private ExtendedWebElement PI_ResidentialStatus;
	@FindBy(xpath = "//ng-select[@formcontrolname='customernationalityPO']")
	private ExtendedWebElement PI_Citizenship;
	@FindBy(xpath = "//input[@formcontrolname='customerEmailID']")
	private ExtendedWebElement PI_EmailID;
	@FindBy(xpath = "//input[@formcontrolname='customerMobileno']")
	private ExtendedWebElement PI_MobileNo;
	@FindBy(xpath = "//*[@class='slider']")
	private ExtendedWebElement PI_AadhaarSlider;

	@FindBy(xpath = "//label[contains(text(), 'Policy Insured has Aadhar?')]")
	private ExtendedWebElement PI_Aadhaartext;

	@FindBy(xpath = "//input[@formcontrolname='aadhaarno']")
	private ExtendedWebElement PI_AadhaarNumber;
	@FindBy(xpath = "//input[@formcontrolname='ischecked' and @id='ischecked']")
	private ExtendedWebElement PI_AadhaarCheckbox;
	@FindBy(xpath = "//button[normalize-space(text())='Generate Code']")
	private ExtendedWebElement PI_GenerateCodeBtn;
	@FindBy(xpath = "//button[normalize-space(text())='Verify Code']")
	private ExtendedWebElement PI_VerifyCodeBtn;
	@FindBy(xpath = "//input[@formcontrolname='autheniticatePAN']")
	private ExtendedWebElement PI_Pan;

	// PI Self & Family Details (NEW - ADDED AS REQUESTED)
	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[1]")
	private ExtendedWebElement PI_First_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[1]")
	private ExtendedWebElement PI_Last_Name;

	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[2]")
	private ExtendedWebElement PI_Father_First_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[2]")
	private ExtendedWebElement PI_Father_Last_Name;

	@FindBy(xpath = "(//*[@formcontrolname='firstName'])[3]")
	private ExtendedWebElement PI_Mother_First_Name;
	@FindBy(xpath = "(//*[@formcontrolname='lastName'])[3]")
	private ExtendedWebElement PI_Mother_Last_Name;

	@FindBy(xpath = "//*[@formcontrolname='customerDob']")
	private ExtendedWebElement CustomerDOB;

	@FindBy(xpath = "//button[contains(., 'Save & Proceed')]")
	private ExtendedWebElement PI_SaveAndProceedBtn;

	// --- Class Variables ---
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	private static final int EXPLICIT_TIMEOUT = 30;
	private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
	private CommonUtilities CU = new CommonUtilities();

	// --- Main Method ---
	public void PNB_pipoDifferent_KnowYourCustomer(HashMap<String, String> args) throws Throwable {
		String actualResult = args.getOrDefault("ActualResult", "");

		try {
			executeFullPageFlow(args);
			actualResult += "PI-PO Different Know Your Customer Page completed successfully | ";
			args.put("ActualResult", actualResult);

		} catch (Exception e) {
			handlePageError(e, args, "Main_PiPoDifferent_Flow");
		}
	}

	// --- Main Execution Flow ---
	private void executeFullPageFlow(HashMap<String, String> args) {
		LOGGER.info("Starting PI-PO Different flow...");

		// Steps 1-3: PO Basic Info & KYC
		fillInitialInfoAndPerformKYC(args);

		// Steps 4-6: PO's Personal, Profile, and Bank Details
		fillPolicyOwnerExtendedDetails(args);

		// Step 7: Transition to PI Section
		proceedToPolicyInsuredSection(args);

		// Step 8: Fill PI Details
		fillPolicyInsuredDetails(args);

		LOGGER.info("PI-PO Different flow completed successfully.");
	}

	private void fillInitialInfoAndPerformKYC(HashMap<String, String> args) {
		LOGGER.info("Step 1 & 2: Filling PO Basic Info...");
		ImprovedWaits.waitForPageLoad(getDriver());
		FamilyMember.click();
		pause(1);
		ContinueWithFamilyMember.click();
		pause(2);
//
//		PO_Relation.click();
//		PO_Relation_DropDownValue.format(args.get("PO_Relation")).click();
//
//		PO_ResidentialStatus.click();
//		PO_Relation_DropDownValue.format(args.get("PO_ResidentialStatus")).click();

		CU.scrollToView(getDriver(), PO_Email);
		PO_Email.type(args.get("PO_Email"));
		PO_Email.getElement().sendKeys(Keys.ENTER);
		PO_Number.type(args.get("PO_Number"));

		LOGGER.info("Step 3: Performing PO KYC...");
		QuickFill_Button.click();
		pause(5);

		CU.scrollToView(getDriver(), PO_Aadhar);
		pause(1);
		PO_Aadhar.type(args.get("PO_Aadhar"));
		ischecked.click();
		Generate_OTP_Btn.click();

		String otp = "123456"; // Default
		if ("Female".equalsIgnoreCase(args.get("PO_Gender")))
			otp = "222222";
		if ("Male".equalsIgnoreCase(args.get("PO_Gender")))
			otp = "333333";

		for (int i = 0; i < otp.length(); i++) {
			findExtendedWebElement(By.xpath(String.format("//input[@id='otp-input-%d']", i)))
					.type(String.valueOf(otp.charAt(i)));
		}

		pause(3);
		Verify_OTP.click();
		pause(2);

		Pan.type(args.get("PO_Pan"));
		SaveProceed.click();
		pause(2);
	}

	private void fillPolicyOwnerExtendedDetails(HashMap<String, String> args) {
		LOGGER.info("Step 4: Filling PO Family Details...");
		ImprovedWaits.waitForPageLoad(getDriver());
		CU.scrollToView(getDriver(), Father_Firtst_Name);
		pause(1);
		Father_Firtst_Name.type(CU.randomFirstName());
		Father_Last_Name.type(CU.randomLastName());
		Mother_First_Name.type(CU.randomFirstName());
		Mother_Last_Name.type(CU.randomFirstName());

		try {
			Spouse_First_Name.type(CU.randomFirstName());
			Spouse_Last_Name.type(CU.randomLastName());
		} catch (Exception e) {
			System.out.println("Spouse section was not avaiable");
		}

		CU.scrollToView(getDriver(), SaveProceed);
		pause(1);
		SaveProceed.click();
		pause(2);

		LOGGER.info("Step 5: Filling PO Profile...");
		ImprovedWaits.waitForPageLoad(getDriver());
		pause(1);
		customereducationalField.click();
		dropdown_education.format(args.get("PO_Education")).click();
		
		customerOccupationField.click();
		dropdown_occupation.format((String) args.get("Occupation")).click(); // FIXED: Type casting

		String occupation = (String) args.get("Occupation");
		String jobProfile = (String) args.get("Job_Profile");

//Occupations that require job profile input
		Set<String> occupationsWithJobProfile = new HashSet<>(
				Arrays.asList("Service - Government Sector", "Service - Private Sector", "Service - Public Sector",
						"Service - Others", "Retired", "Professional", "Self Employed", "Not Categorised"));

		if (occupationsWithJobProfile.contains(occupation)) {
			Jobprofile.click();
			Jobprofile_Type.type(jobProfile);
			Jobprofile_Type.getElement().sendKeys(Keys.ENTER);
		} else if (occupation.equalsIgnoreCase("Student")) {
			// Handle Student case if needed
		} else if (occupation.equalsIgnoreCase("Housewife")) {
			// Handle Housewife case if needed
		} else if (occupation.equalsIgnoreCase("Business")) {
			// Handle Business case if needed
		} else {
			// Handle unknown or uncategorized occupation
		}
		
		
//		customerOccupationField.click();
//		String poOccupation = args.get("PO_Occupation");
//		dropdown_occupation.format(poOccupation).click();
//		if (poOccupation != null || poOccupation.contains("Service - Private Sector")
//				|| poOccupation.contains("Service - Public Sector")) {
//			Jobprofile.click();
//			Jobprofile_Type.type(args.get("PO_Job_Profile"));
//			Jobprofile_Type.getElement().sendKeys(Keys.ENTER);
//		}
		AnnualIncome.type(args.get("PO_AnnualIncome"));
		CU.scrollToView(getDriver(), PNB_Yes);
		pause(1);
		if ("Yes".equalsIgnoreCase(args.get("PO_PNB_Staff_Yes_No")))
			PNB_Yes.click();
		else
			PNB_No.click();
		pause(1);
		CustomerWorkspace.type(args.get("PO_Workspace"));
		CommonUtilities.CaptureScreenshot(args, getDriver(), "PO_EducationDetails");
		pause(1);
		Save_btn_Customer_Profile.click();
		pause(2);

		LOGGER.info("Step 6: Filling PO Bank Details...");
		ImprovedWaits.waitForPageLoad(getDriver());
		pause(1);
		PO_accountNumber.type(args.get("PO_accountNumber"));
		PO_ConfirmaccountNumber.type(args.get("PO_accountNumber"));
		if ("Savings".equalsIgnoreCase(args.get("PO_BankAccountType")))
			Saving_BTN.click();
		else if ("Current".equalsIgnoreCase(args.get("PO_BankAccountType")))
			Current_BTN.click();
		PO_IfscCode.type(args.get("PO_IfscCode"));
		pause(2);
		Validate_BTN.click();
		pause(2);
		if ("Yes".equalsIgnoreCase(args.get("T&C")))
			TC_Yes.click();
		else
			TC_No.click();
		pause(2);
		Ok_BTN.click();
		pause(1);
		Save_btnn_BankDetail.click();
		pause(2);
	}

	private void proceedToPolicyInsuredSection(HashMap<String, String> args) {
		LOGGER.info("Step 7: Proceeding to PI Information...");
		ImprovedWaits.waitForPageLoad(getDriver());
		if (ProceedAhead_PIInfo.isElementPresent(1)) {
			ImprovedWaits.smartWait(getDriver(), ProceedAhead_PIInfo, 10);
			ProceedAhead_PIInfo.click();
		}
	}
///////////////Code flow is proper till above

	// --- Step 8: Fill Policy Insured (PI) Details ---
	private void fillPolicyInsuredDetails(HashMap<String, String> args) {
		LOGGER.info("Step 8: Filling PI (Policy Insured) Details...");
		ImprovedWaits.waitForPageLoad(getDriver());

		// Fill static PI contact information

		if ("Resident Indian".equalsIgnoreCase(args.get("Residential_Status"))) {
			System.out.println("Skipping Click");
		} else {
			PI_ResidentialStatus.click();
			PO_Relation_DropDownValue.format(args.get("Residential_Status")).click();
			PI_Citizenship.click();
			PO_Relation_DropDownValue.format(args.get("Customer_Nationality")).click();
		}

		PI_EmailID.type(args.get("Customer_EmailID"));
		PI_EmailID.getElement().sendKeys(Keys.ENTER);
		pause(1);
		PI_MobileNo.type(args.get("Customer_MobileNo"));

		// Data-driven Aadhaar KYC for PI
		if ("Yes".equalsIgnoreCase(args.get("PI_Aadhaar_Yes_No"))) {
			LOGGER.info("PI Aadhaar KYC is 'Yes'. Starting KYC process...");
			CU.scrollToView(getDriver(), PI_Aadhaartext);
			PI_AadhaarSlider.click();
			CU.scrollToView(getDriver(), PI_AadhaarNumber);
			pause(1);
			pause(1);
			
			
			 // Enter Aadhaar number based on gender
            String gender = (String) args.get("Gender");
            if (gender != null) {
                String aadhaarNumber = getAadhaarNumberByGender(gender);
                PI_AadhaarNumber.type(aadhaarNumber);
            }
			
			
		
			PI_AadhaarCheckbox.click();
			PI_GenerateCodeBtn.click();
			pause(3);
			
			
			 // Handle OTP entry
            handleOTPEntry(args);

			pause(3);
			PI_VerifyCodeBtn.click();
			pause(2);
			PI_Pan.type(args.get("Pancard"));
			CU.scrollToView(getDriver(), PI_SaveAndProceedBtn);
			CommonUtilities.CaptureScreenshot(args, getDriver(), "PI_Details_Filled");
			PI_SaveAndProceedBtn.click();
			pause(1);

		} else {
			LOGGER.info("PI Aadhaar KYC is 'No'. Skipping KYC process.");
		}
		CommonUtilities.CaptureScreenshot(args, getDriver(), "PI_Details_Filled");
		CU.scrollToView(getDriver(), PI_SaveAndProceedBtn);
		pause(1);
		PI_SaveAndProceedBtn.click();
		pause(2);

		if ("No".equalsIgnoreCase(args.get("PI_Aadhaar_Yes_No"))) {
			pause(5);
			PI_First_Name.type(CU.randomFirstName());
			PI_Last_Name.type(CU.randomFirstName());

			String dob = (String) args.get("DOB");
			if (dob != null && !dob.trim().isEmpty()) {
				CustomerDOB.click();
				CustomerDOB.type(dob);
				CustomerDOB.getElement().sendKeys(Keys.ENTER);
			}
		}

		// NEW: PI Family Details (ADDED AS REQUESTED)
		LOGGER.info("Filling PI Family Details...");

		CU.scrollToView(getDriver(), PI_Father_First_Name);
		PI_Father_First_Name.type(CU.randomFirstName());
		PI_Father_Last_Name.type(CU.randomLastName());

		// Scroll after Father Last Name as requested
		CU.scrollToView(getDriver(), PI_Mother_First_Name);
		pause(1);

		PI_Mother_First_Name.type(CU.randomFirstName());
		PI_Mother_Last_Name.type(CU.randomFirstName());
		pause(1);
		// Screenshot after completing family details
		CommonUtilities.CaptureScreenshot(args, getDriver(), "PI_Family_Details_Completed");
		// Final save and proceed for the entire page
		CU.scrollToView(getDriver(), PI_SaveAndProceedBtn);
		pause(1);
		PI_SaveAndProceedBtn.click();
		pause(2); // Wait for the next page to start loading

		// PI Details
		LOGGER.info("Step 5: Filling PI Profile...");
		ImprovedWaits.waitForPageLoad(getDriver());
		pause(1);
		customereducationalField.click();
		dropdown_education.format(args.get("Education")).click();
		
		customerOccupationField.click();
		dropdown_occupation.format((String) args.get("Occupation")).click(); // FIXED: Type casting

		String occupation = (String) args.get("Occupation");
		String jobProfile = (String) args.get("Job_Profile");

//Occupations that require job profile input
		Set<String> occupationsWithJobProfile = new HashSet<>(
				Arrays.asList("Service - Government Sector", "Service - Private Sector", "Service - Public Sector",
						"Service - Others", "Retired", "Professional", "Self Employed", "Not Categorised"));

		if (occupationsWithJobProfile.contains(occupation)) {
			Jobprofile.click();
			Jobprofile_Type.type(jobProfile);
			Jobprofile_Type.getElement().sendKeys(Keys.ENTER);
		} else if (occupation.equalsIgnoreCase("Student")) {
			// Handle Student case if needed
		} else if (occupation.equalsIgnoreCase("Housewife")) {
			// Handle Housewife case if needed
		} else if (occupation.equalsIgnoreCase("Business")) {
			// Handle Business case if needed
		} else {
			// Handle unknown or uncategorized occupation
		}
		AnnualIncome.type(args.get("Annual_Income"));
		CU.scrollToView(getDriver(), PNB_Yes);
		pause(1);
		if ("Yes".equalsIgnoreCase(args.get("PNB_Staff_Yes_No")))
			PNB_Yes.click();
		else
			PNB_No.click();
		pause(1);
		CustomerWorkspace.type(args.get("Workspace"));
		CommonUtilities.CaptureScreenshot(args, getDriver(), "PI_EducationDetails");
		pause(1);
		Save_btn_Customer_Profile.click();
		pause(2);
		SaveProceed.click();
		pause(1);

//        LOGGER.info("Step 6: Filling PI Bank Details...");
//        ImprovedWaits.waitForPageLoad(getDriver());
//        pause(1);
//        PO_accountNumber.type(args.get("Account_Number"));
//        PO_ConfirmaccountNumber.type(args.get("Account_Number"));
//        if ("Savings".equalsIgnoreCase(args.get("Bank_Acc_Type"))) Saving_BTN.click();
//        else if ("Current".equalsIgnoreCase(args.get("Bank_Acc_Type"))) Current_BTN.click();
//        PO_IfscCode.type(args.get("IFSC_Code"));
//        pause(2);
//        Validate_BTN.click();
//        pause(2);
//        if ("Yes".equalsIgnoreCase(args.get("T&C"))) TC_Yes.click();
//        else TC_No.click();
//        pause(2);
//        Ok_BTN.click();
//        pause(1);
//        Save_btnn_BankDetail.click();
//        pause(2);
	}

	// --- Error Handler ---
	private void handlePageError(Exception e, HashMap<String, String> args, String actionName) {
		String pageName = this.getClass().getSimpleName();
		String errorMsg = String.format("Failed on %s: Action '%s' failed. Error: %s", pageName, actionName,
				e.getMessage());
		LOGGER.error(errorMsg, e);

		String actualResult = args.getOrDefault("ActualResult", "");
		actualResult += errorMsg + " | ";
		args.put("ActualResult", actualResult);
		args.put("sOutput", errorMsg);
		args.put("status", "Fail");

		CommonUtilities.CaptureScreenshot(args, getDriver(), "ErrorPage_" + actionName);
		throw new RuntimeException(errorMsg, e);
	}
	
	 // --- Helper Methods ---
    private String getAadhaarNumberByGender(String gender) {
        if (gender != null) {
            if (gender.equalsIgnoreCase("Female")) {
                return "222222222222";
            } else if (gender.equalsIgnoreCase("Male")) {
                return "333333333333";
            }
        }
        return "200000000000"; // Default
    }
    
    // --- Handle OTP Entry ---
    private void handleOTPEntry(HashMap args) {
        try {
            String gender = (String) args.get("Gender");
            String otpToUse = getOTPByGender(gender);
            
            // Enter OTP digits
            for (int i = 0; i < otpToUse.length(); i++) {
                ExtendedWebElement input = findExtendedWebElement(
                    By.xpath(String.format("//input[@id='otp-input-%d']", i))
                );
                input.type(String.valueOf(otpToUse.charAt(i)));
                pause(0.5);
            }
            
            LOGGER.info("OTP entered successfully for gender: " + gender);
            
        } catch (Exception e) {
            handlePageError(e, args, "OTP entry");
        }
    }

    private String getOTPByGender(String gender) {
        if (gender != null) {
            if (gender.equalsIgnoreCase("Female")) {
                return "222222";
            } else if (gender.equalsIgnoreCase("Male")) {
                return "333333";
            }
        }
        return "123456"; // Default
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
