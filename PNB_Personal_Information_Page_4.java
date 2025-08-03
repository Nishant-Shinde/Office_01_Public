package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.utils.CommonUtilities;
import com.web.utils.ImprovedWaits;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PNB_Personal_Information_Page_4 extends AbstractPage {

    public PNB_Personal_Information_Page_4(WebDriver driver) {
        super(driver);
    }

    // --- ALL YOUR ORIGINAL @FindBy ELEMENTS (keeping exactly as you declared them) ---
    @FindBy(xpath = "//*[text()='Document Waiver Status ']")
    private ExtendedWebElement PersonalInformationtext;

    @FindBy(xpath = "(//button[text()=' %s'])[last()]")
    private ExtendedWebElement Select_Covertype;

    @FindBy(xpath = "//*[text()=' Individual']")
    private ExtendedWebElement individual;

    @FindBy(xpath = "//*[@formcontrolname='customerSalutation']")
    private ExtendedWebElement CustomerSalutation_Field;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_salutation;

    @FindBy(xpath = "//ng-select[@formcontrolname='fatherSalutation' and @placeholder='Select Option']//div[contains(@class,'ng-select-container')]")
    private ExtendedWebElement FatherSalutation_Field;

    @FindBy(xpath = "//div[contains(@class,'ng-dropdown-panel')]//div[contains(@class,'ng-option') and not(contains(@class,'ng-option-disabled'))]//span[contains(@class,'ng-option-label') and normalize-space(text())='%s']")
    private ExtendedWebElement FatherSalutation_Field_Value;

    @FindBy(xpath = "(//*[@formcontrolname='firstName'])[2]")
    private ExtendedWebElement Father_Firtst_Name;

    @FindBy(xpath = "(//*[@formcontrolname='lastName'])[2]")
    private ExtendedWebElement Father_Last_Name;

    @FindBy(xpath = "(//*[@formcontrolname='alternateMobileNo'])")
    private ExtendedWebElement Alternate_Mobile_no;

    @FindBy(xpath = "(//*[@formcontrolname='firstName'])[3]")
    private ExtendedWebElement Mother_Firtst_Name;

    @FindBy(xpath = "(//*[@formcontrolname='lastName'])[3]")
    private ExtendedWebElement Mother_Last_Name;

    @FindBy(xpath = "(//button[@type='button'])")
    private ExtendedWebElement edit_btn;

    @FindBy(xpath = "//label[text()='Married']")
    private ExtendedWebElement Married_BTN;

    @FindBy(xpath = "//label[text()='Unmarried']")
    private ExtendedWebElement UnMarried_BTN;

    @FindBy(xpath = "//*[@formcontrolname='addressLine1']")
    private ExtendedWebElement Add_Line1;

    @FindBy(xpath = "//*[@formcontrolname='addressLine2']")
    private ExtendedWebElement Add_Line2;

    @FindBy(xpath = "//*[@formcontrolname='addressLine3']")
    private ExtendedWebElement Add_Line3;

    @FindBy(xpath = "//*[@formcontrolname='pincode']")
    private ExtendedWebElement Pincode;

    @FindBy(xpath = "//*[@formcontrolname='city']")
    private ExtendedWebElement City;

    @FindBy(xpath = "//*[@formcontrolname='district']")
    private ExtendedWebElement district;

    @FindBy(xpath = "//*[@formcontrolname='state']")
    private ExtendedWebElement state;

    @FindBy(xpath = "(//*[@formcontrolname='gramPanchayat'])[1]")
    private ExtendedWebElement Grampanchayat;

    // COMMUNICATION
    @FindBy(xpath = "//label[text()='Communication']")
    private ExtendedWebElement Communication_BTN;

    @FindBy(xpath = "(//*[@formcontrolname='addressLine1'])[2]")
    private ExtendedWebElement Comm_ADD1;

    @FindBy(xpath = "(//*[@formcontrolname='addressLine2'])[2]")
    private ExtendedWebElement Comm_ADD2;

    @FindBy(xpath = "(//*[@formcontrolname='addressLine3'])[2]")
    private ExtendedWebElement Comm_ADD3;

    @FindBy(xpath = "(//*[@formcontrolname='pincode'])[2]")
    private ExtendedWebElement Comm_Pincode;

    @FindBy(xpath = "(//*[@formcontrolname='city'])[2]")
    private ExtendedWebElement Comm_City;

    @FindBy(xpath = "(//*[@formcontrolname='district'])[2]")
    private ExtendedWebElement Comm_district;

    @FindBy(xpath = "(//*[@formcontrolname='state'])[2]")
    private ExtendedWebElement Comm_State;

    @FindBy(xpath = "(//*[@formcontrolname='gramPanchayat'])[2]")
    private ExtendedWebElement Comm_Grampanchayat;

    // Permanent Address
    @FindBy(xpath = "//label[text()='Permanent']")
    private ExtendedWebElement Permanent_BTN;

    @FindBy(xpath = "//label[text()='Both']")
    private ExtendedWebElement Both_BTN;

    @FindBy(xpath = "//button[text()=' Save & Proceed ']")
    private ExtendedWebElement Save_Proceed_BTN;

    // scroll
    @FindBy(xpath = "//*[text()='Female']")
    private ExtendedWebElement FemaleText;

    // CustomerProfile
    @FindBy(xpath = "//ng-select[(@formcontrolname='educationalQualification')]")
    private ExtendedWebElement customereducationalField;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_education;

    @FindBy(xpath = "//ng-select[(@formcontrolname='occupation')]")
    private ExtendedWebElement customerOccupationField;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_occupation;

    @FindBy(xpath = "//ng-select[(@formcontrolname='jobProfile')]")
    private ExtendedWebElement Jobprofile;

    @FindBy(xpath = "//input[@aria-placeholder=\"Customer Job Profile\"]")
    private ExtendedWebElement Jobprofile_Type;

    @FindBy(xpath = "(//label[contains(text(), 'Yes')]) [1]")
    private ExtendedWebElement EngagementInMentioned_Industries;

    @FindBy(xpath = "//ng-select[@formcontrolname='natureOfBusiness']")
    private ExtendedWebElement NatureOfBusiness;

    @FindBy(xpath = "//div[contains(@class,'ng-dropdown-panel')]//div[contains(@class,'ng-option') and normalize-space(.)='%s']")
    private ExtendedWebElement NatureOfBusiness_Values;

    @FindBy(xpath = "//ng-select[@formcontrolname='jobProfile']//div[contains(@class,'ng-select-container')]")
    private ExtendedWebElement JobProfile;

    @FindBy(xpath = "//ng-select[@formcontrolname='jobProfile']//input[contains(@role,'combobox')]")
    private ExtendedWebElement JobProfile_Input;

    @FindBy(xpath = "//*[(@formcontrolname='annualIncome')]")
    private ExtendedWebElement AnnualIncome;

    @FindBy(xpath = "//*[(@formcontrolname='natureOfBusiness')]")
    private ExtendedWebElement natureOfBuisness_Field;

    @FindBy(xpath = "(//label[text()='Yes'])[1]")
    private ExtendedWebElement Buisness_Yes;

    @FindBy(xpath = "(//label[text()='No'])[1]")
    private ExtendedWebElement Buisness_No;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_buisness;

    @FindBy(xpath = "(//label[text()='Yes'])[2]")
    private ExtendedWebElement PNB_Yes;

    @FindBy(xpath = "(//label[text()='No'])")
    private ExtendedWebElement PNB_No;

    @FindBy(xpath = "//*[@placeholder='Please enter Customer Work Place']")
    private ExtendedWebElement CustomerWoekspace;

    //Bank Details
    @FindBy(xpath = "//*[@name='accountNumber']")
    private ExtendedWebElement Account_Number;

    @FindBy(xpath = "//*[@name='confirmaccountNumber']")
    private ExtendedWebElement Confirm_Acc_Number;

    @FindBy(xpath = "//label[text()=' Savings']")
    private ExtendedWebElement Saving_BTN;

    @FindBy(xpath = "//label[text()=' Current']")
    private ExtendedWebElement Current_BTN;

    @FindBy(xpath = "//*[@name='ifscCode']")
    private ExtendedWebElement IFSC_code;

    @FindBy(xpath = "//*[text()='Validate']")
    private ExtendedWebElement Validate_BTN;

    @FindBy(xpath = "//*[text()='Yes']")
    private ExtendedWebElement TC_Yes;

    @FindBy(xpath = "//*[text()='No']")
    private ExtendedWebElement TC_No;

    @FindBy(xpath = "//*[text()='Ok']")
    private ExtendedWebElement Ok_BTN;

    //Save Button
    @FindBy(xpath = "//button[normalize-space(text())='Save & Proceed']")
    private ExtendedWebElement Save_btnn_BankDetail;

    @FindBy(xpath = "//*[text()=' Save & Proceed ']")
    private ExtendedWebElement Save_btn_Customer_Profile;

    //Existing policy
    @FindBy(xpath = "//*[text()=' Please declare whether the customer has any active (in-force) policies? ']")
    private ExtendedWebElement Existing_insurance_pagetext;

    @FindBy(xpath = "//*[text()=' Yes']")
    private ExtendedWebElement Existing_Insurance_Yes;

    @FindBy(xpath = "//*[text()=' No']")
    private ExtendedWebElement Existing_Insurance_No;

    @FindBy(xpath = "//*[text()=' Save & Proceed ']")
    private ExtendedWebElement Save_btn_Existing_Insurance;

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method (keeping your original structure) ---
    public void CustomerOnboarding(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        
        try {
            PersonalInformation(args);
            Customer_Profile(args);
            Bank_Details(args);
            Existing_Insurance(args);
            
            actualResult += "PersonalInformation| Customer_Profile |Bank_Details |Existing_Insurance| Page Open Successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "CustomerOnboarding");
        }
    }

    // --- Your Original Methods (keeping exactly as you had them) ---
    public void PersonalInformation(HashMap args) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            
            try { 
                wait.until(ExpectedConditions.visibilityOf(PersonalInformationtext.getElement())); 
            } catch (Exception e) { 
                handlePageError(e, args, "PersonalInformationtext"); 
            }

            try { 
                Father_Firtst_Name.type(CU.randomFirstName()); 
            } catch (Exception e) { 
                handlePageError(e, args, "Father_Firtst_Name"); 
            }
            
            try { 
                Father_Last_Name.type(CU.randomLastName()); 
            } catch (Exception e) { 
                handlePageError(e, args, "Father_Last_Name"); 
            }
            
            try { 
                Mother_Firtst_Name.type(CU.randomFirstName()); 
            } catch (Exception e) { 
                handlePageError(e, args, "Mother_Firtst_Name"); 
            }
            
            try { 
                Mother_Last_Name.type(CU.randomLastName()); 
            } catch (Exception e) { 
                handlePageError(e, args, "Mother_Last_Name"); 
            }
            
            CommonUtilities.CaptureScreenshot(args, getDriver(), "page3");

            try {
                if (((String) args.get("Edit_Btn")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    edit_btn.click();
                    Add_Line1.type("A16");
                    Add_Line2.type("Colony");
                    Pincode.type("400104");
                    state.type("Maharashtra");
                    Grampanchayat.type("Grampanchayat");
                    CommonUtilities.CaptureScreenshot(args, getDriver(), "Address2");
                }
            } catch (Exception e) {
                handlePageError(e, args, "edit_btn");
            }

            if (((String) args.get("Above_Add")).equalsIgnoreCase("Communication")) { // FIXED: Type casting
                try { Communication_BTN.click(); } catch (Exception e) { handlePageError(e, args, "Communication_BTN"); }
                try { Comm_ADD1.type("Satara"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD1"); }
                try { Comm_ADD2.type("A16"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD2"); }
                try { Comm_ADD3.type("Mumbai"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD3"); }
                try { Comm_Pincode.type("400104"); } catch (Exception e) { handlePageError(e, args, "Comm_Pincode"); }
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Add_4");
                try { Comm_Grampanchayat.type("Grampanchayat"); } catch (Exception e) { handlePageError(e, args, "Comm_Grampanchayat"); }
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Add_5");
            }

            if (((String) args.get("Above_Add")).equalsIgnoreCase("Permanent")) { // FIXED: Type casting
                try { Permanent_BTN.click(); } catch (Exception e) { handlePageError(e, args, "Permanent_BTN"); }
                try { Comm_ADD1.type("Satara"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD1"); }
                try { Comm_ADD2.type("A16"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD2"); }
                try { Comm_ADD3.type("Mumbai"); } catch (Exception e) { handlePageError(e, args, "Comm_ADD3"); }
                try { Comm_Pincode.type("400104"); } catch (Exception e) { handlePageError(e, args, "Comm_Pincode"); }
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Add");
                try { Comm_Grampanchayat.type("Grampanchayat"); } catch (Exception e) { handlePageError(e, args, "Comm_Grampanchayat"); }
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Address2");
            }

            try { 
                Save_Proceed_BTN.click(); 
            } catch (Exception e) { 
                handlePageError(e, args, "Save_Proceed_BTN"); 
            }
            
        } catch (Exception e) {
            handlePageError(e, args, "PersonalInformation");
        }
    }

    public void Customer_Profile(HashMap args) {
        try {
            customereducationalField.click();
            dropdown_education.format((String) args.get("Education")).click(); // FIXED: Type casting

            customerOccupationField.click();
			dropdown_occupation.format((String) args.get("Occupation")).click(); // FIXED: Type casting

			String occupation = (String) args.get("Occupation");
			String jobProfile = (String) args.get("Job_Profile");

// Occupations that require job profile input
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

            AnnualIncome.type((String) args.get("Annual_Income")); // FIXED: Type casting

            try {
                if (((String) args.get("PNB_Staff_Yes_No")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    PNB_Yes.click();
                }
                if (((String) args.get("Business_Yes_No")).equalsIgnoreCase("No")) { // FIXED: Type casting
                    PNB_No.click();
                }
            } catch(Exception e) {}

            CustomerWoekspace.type((String) args.get("Workspace")); // FIXED: Type casting
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Customer_Profile_2");
            pause(1);
            Save_btn_Customer_Profile.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "Customer_Profile");
        }
    }

    public void Bank_Details(HashMap args) {
        try {
            Account_Number.type((String) args.get("Account_Number")); // FIXED: Type casting
            Confirm_Acc_Number.type((String) args.get("Account_Number")); // FIXED: Type casting
            
            try {
                if (((String) args.get("Bank_Acc_Type")).equalsIgnoreCase("Savings")) { // FIXED: Type casting
                    pause(1);
                    Saving_BTN.click();
                }
                if (((String) args.get("Bank_Acc_Type")).equalsIgnoreCase("Current")) { // FIXED: Type casting
                    Current_BTN.click();
                }
            } catch(Exception e) {}

            IFSC_code.type((String) args.get("IFSC_Code")); // FIXED: Type casting
            pause(3);
            
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(Validate_BTN.getElement()));
            pause(1);
            Validate_BTN.click();
            
            try {
                if (((String) args.get("T&C")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    TC_Yes.click();
                }
                if (((String) args.get("T&C")).equalsIgnoreCase("No")) { // FIXED: Type casting
                    TC_No.click();
                }
            } catch(Exception e) {}

            Ok_BTN.click();
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Bank Detail_2");
            Save_btnn_BankDetail.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "Bank_Details");
        }
    }

    public void Existing_Insurance(HashMap args) {
        try {
            if (((String) args.get("Existing_Insurance")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                Existing_Insurance_Yes.click();
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Existing insurance");
            }

            if (((String) args.get("Existing_Insurance")).equalsIgnoreCase("No")) { // FIXED: Type casting
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Existing insurance");
                Save_btnn_BankDetail.click();
            }
            
        } catch (Exception e) {
            handlePageError(e, args, "Existing_Insurance");
        }
    }

    // --- Your Original selectFatherSalutation Method ---
    public void selectFatherSalutation(String visibleText) {
        FatherSalutation_Field.click();
        
        final String FatherSalutation_Field_XPath =
            "//div[contains(@class,'ng-dropdown-panel')]//div[contains(@class,'ng-option') and not(contains(@class,'ng-option-disabled'))]" +
            "//span[contains(@class,'ng-option-label') and normalize-space(text())='%s']";
        
        String optionXpath = String.format(FatherSalutation_Field_XPath, visibleText);
        int maxScrolls = 20;
        boolean found = false;
        
        for (int i = 0; i < maxScrolls; i++) {
            List<WebElement> options = getDriver().findElements(By.xpath(optionXpath));
            if (!options.isEmpty()) {
                options.get(0).click();
                found = true;
                break;
            }
            
            List<WebElement> panels = getDriver().findElements(By.xpath("//div[contains(@class,'ng-dropdown-panel')]"));
            if (!panels.isEmpty()) {
                panels.get(0).sendKeys(Keys.ARROW_DOWN);
            }
            
            try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        
        if (!found) {
            throw new RuntimeException("Option '" + visibleText + "' not found in Father Salutation dropdown.");
        }
    }

    // --- Your Original Error Handler ---
    private void handlePageError(Exception e, HashMap args, String elementVarName) {
        String pageName = this.getClass().getSimpleName();
        String errorMsg = String.format("Failed on %s: Element '%s' not found", pageName, elementVarName);
        
        LOGGER.error(errorMsg, e);
        System.err.println(errorMsg);
        
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        actualResult += errorMsg + " | ";
        args.put("ActualResult", actualResult);
        args.put("sOutput", errorMsg);
        args.put("status", "Fail");
        
        CommonUtilities.CaptureScreenshot(args, getDriver(), "ErrorPage");
        throw new RuntimeException(errorMsg, e);
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
