package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;
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

public class PNB_NomineePage_Page7 extends AbstractPage {

    public PNB_NomineePage_Page7(WebDriver driver) {
        super(driver);
    } // FIXED: Added missing closing brace

    // --- ALL YOUR ORIGINAL @FindBy ELEMENTS (keeping exactly as declared) ---
    @FindBy(xpath = "//input[@aria-placeholder='select the number nominees to be added']")
    private ExtendedWebElement NumberOfNominee;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement NumberOfNominee_DropDownValue;

    @FindBy(xpath = "//input[@aria-placeholder='Please select the relationship of nominee with policy insured']")
    private ExtendedWebElement RelationOfNominee;

    @FindBy(xpath = "//ng-select[@formcontrolname='relationshipofNaminee']//input[contains(@role,'combobox')]")
    private ExtendedWebElement RelationOfNominee_DropDownValue;

    @FindBy(xpath = "//div[contains(@class,'ng-select-container')]//input[@aria-placeholder=\"Please select nominee's salutation\"]")
    private ExtendedWebElement NomineeSalutation;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement NomineeSalutation_DropDownValue;

    @FindBy(xpath = "//input[@placeholder='First Name' and @formcontrolname='firstName']")
    private ExtendedWebElement NomineeFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name' and @formcontrolname='lastName']")
    private ExtendedWebElement NomineeLastName;

    @FindBy(xpath = "//label[@for='inlineRadio1' and contains(text(),'Male')]")
    private ExtendedWebElement NomineeGender_Male;

    @FindBy(xpath = "//label[@for='inlineRadio2' and contains(text(),'Female')]")
    private ExtendedWebElement NomineeGender_Female;

    @FindBy(xpath = "//label[@for='inlineRadio3' and contains(text(),'Others')]")
    private ExtendedWebElement NomineeGender_Others;

    @FindBy(xpath = "//label[@for='maritalRadio1' and contains(text(),'Married')]")
    private ExtendedWebElement NomineeMaritalStatus_Married;

    @FindBy(xpath = "//label[@for='maritalRadio2' and contains(text(),'Unmarried')]")
    private ExtendedWebElement NomineeMaritalStatus_UnMarried;

    @FindBy(xpath = "//label[@for='maritalRadio3' and contains(text(),'Others')]")
    private ExtendedWebElement NomineeMaritalStatus_Others;

    @FindBy(xpath = "//div[contains(@class,'ng-select-container')]//input[@aria-placeholder=\"Please select nominee's residential status\"]")
    private ExtendedWebElement NomineeResdentialStatus;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement NomineeResdentialStatus_DropDownValue;

    @FindBy(xpath = "//input[@formcontrolname='nomineeMobileNo' and @placeholder=\"Please enter nominee's mobile number\"]")
    private ExtendedWebElement Nominee_Mobile;

    @FindBy(xpath = "//input[@formcontrolname='nomineeEmailId' and @placeholder=\"Please enter nominee's email id\"]")
    private ExtendedWebElement Nominee_Email;

    @FindBy(xpath = "//label[@for='accountType1' and contains(normalize-space(.), 'Current')]")
    private ExtendedWebElement Nominee_BankAccount;

    @FindBy(xpath = "//input[@formcontrolname='ifcsCode' and @placeholder='Please enter ifsc code']")
    private ExtendedWebElement Nominee_IFSCCode;

    @FindBy(xpath = "//*[text()='Save']")
    private ExtendedWebElement Nominee_Save;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed;

    @FindBy(xpath = "//p[contains(text(), 'No immediate family member present for nomination')]//input[@type='radio']")
    private ExtendedWebElement Noimmediatefamily;
    
    //
    
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private ExtendedWebElement OkButton;

    @FindBy(xpath = "//button[contains(text(),'Add Nominee')]")
    private ExtendedWebElement AddNominee;

    @FindBy(xpath = "//*[@formcontrolname='nomineeDob']")
    private ExtendedWebElement NomineeDOB;

    @FindBy(xpath = "//*[@formcontrolname='nomineeAccountNumber']")
    private ExtendedWebElement NomineeAccountNumber;

    @FindBy(xpath = "//*[@formcontrolname='nomineeAllocation']")
    private ExtendedWebElement NomineeAllocation;

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method ---
    public void Nominee_Page(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        
        try {
            NomineePage(args);
            actualResult += "Nominee Page Open Successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "Nominee_Page");
        }
    }

    // --- Error Handler ---
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

    // --- Nominee Page Method ---
    public void NomineePage(HashMap args) {
        try {
            // IMPROVED: Smart wait for page load
            ImprovedWaits.waitForPageLoad(getDriver());
            
            // Select NumberOfNominee from dropdown
            try {
                NumberOfNominee.click();
                NumberOfNominee_DropDownValue.format((String) args.get("NumberOfNominee")).click(); // FIXED: Type casting
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "NumberOfNominee");
            }

            int numberOfNominee = Integer.parseInt((String) args.get("NumberOfNominee")); // FIXED: Type casting
            
            for (int i = 1; i <= numberOfNominee; i++) {
                String suffix = (i == 1) ? "" : "_" + i;
                
                // Relation selection
                try {
                    RelationOfNominee.click();
                    RelationOfNominee_DropDownValue.type((String) args.get("RelationOfNominee" + suffix)); // FIXED: Type casting
                    pause(1);
                    RelationOfNominee_DropDownValue.getElement().sendKeys(Keys.ENTER);
                    pause(1);
                    Noimmediatefamily.click();
                    OkButton.click();
                    
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "RelationOfNominee" + suffix);
                }

                // Salutation
                try {
                    NomineeSalutation.click();
                    NomineeSalutation_DropDownValue.format((String) args.get("NomineeSalutation" + suffix)).click(); // FIXED: Type casting
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "NomineeSalutation" + suffix);
                }

                // First and last name - Using CommonUtilities random methods
                try { 
                    NomineeFirstName.type(CU.randomFirstName()); 
                } catch (Exception e) { 
                    handlePageError(e, args, "NomineeFirstName" + suffix); 
                }
                
                try { 
                    NomineeLastName.type(CU.randomFirstName()); 
                } catch (Exception e) { 
                    handlePageError(e, args, "NomineeLastName" + suffix); 
                }

                CU.scrollToView(getDriver(), NomineeGender_Male);

                // Gender
                try {
                    String nomineeGender = (String) args.get("NomineeGender" + suffix); // FIXED: Type casting
                    if (nomineeGender != null) {
                        if (nomineeGender.equalsIgnoreCase("Male")) {
                            NomineeGender_Male.click();
                        } else if (nomineeGender.equalsIgnoreCase("Female")) {
                            NomineeGender_Female.click();
                        } else if (nomineeGender.equalsIgnoreCase("Others")) {
                            NomineeGender_Others.click();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "NomineeGender" + suffix);
                }

                // DOB
                try {
                    NomineeDOB.click();
                    NomineeDOB.type((String) args.get("NomineeDOB" + suffix)); // FIXED: Type casting
                    NomineeDOB.getElement().sendKeys(Keys.ENTER);
                    CU.scrollToView(getDriver(), NomineeDOB);
                    pause(3);
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "NomineeDOB" + suffix);
                }

                // Marital Status
                try {
                    String nomineeMaritalStatus = (String) args.get("NomineeMaritalStatus" + suffix); // FIXED: Type casting
                    if (nomineeMaritalStatus != null) {
                        if (nomineeMaritalStatus.equalsIgnoreCase("Married")) {
                            NomineeMaritalStatus_Married.click();
                        } else if (nomineeMaritalStatus.equalsIgnoreCase("UnMarried")) {
                            NomineeMaritalStatus_UnMarried.click();
                        } else if (nomineeMaritalStatus.equalsIgnoreCase("Others")) {
                            NomineeMaritalStatus_Others.click();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "NomineeMaritalStatus" + suffix);
                }

                // Allocation (if more than one nominee)
                if (numberOfNominee > 1) {
                    try {
                        NomineeAllocation.click();
                        NomineeAllocation.type((String) args.get("NomineeAllocation" + suffix)); // FIXED: Type casting
                    } catch (Exception e) {
                        System.out.println("##########Error Message Is " + e);
                        handlePageError(e, args, "NomineeAllocation" + suffix);
                    }
                }

//                // Residential status
//                try {
//                    pause(2);
//                    CU.scrollToView(getDriver(), NomineeResdentialStatus);
//                    NomineeResdentialStatus.click();
//                    NomineeResdentialStatus_DropDownValue.format((String) args.get("NomineeResdentialStatus" + suffix)).click(); // FIXED: Type casting
//                } catch (Exception e) {
//                    System.out.println("##########Error Message Is " + e);
//                    handlePageError(e, args, "NomineeResdentialStatus" + suffix);
//                }

                CU.scrollToView(getDriver(), Nominee_Mobile);

                // Mobile
                try { 
                    Nominee_Mobile.type((String) args.get("Nominee_Mobile" + suffix)); // FIXED: Type casting
                } catch (Exception e) { 
                    handlePageError(e, args, "Nominee_Mobile" + suffix); 
                }

                CU.scrollToView(getDriver(), Nominee_Email);

                // Email
                try {
                    Nominee_Email.type((String) args.get("Nominee_EmailID" + suffix)); // FIXED: Type casting
                    Nominee_Email.getElement().sendKeys(Keys.ENTER);
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "Nominee_Email" + suffix);
                }

                // Account number
                try { 
                    NomineeAccountNumber.type((String) args.get("NomineeAccount_Number" + suffix)); // FIXED: Type casting
                } catch (Exception e) { 
                    handlePageError(e, args, "NomineeAccountNumber" + suffix); 
                }

                CU.scrollToView(getDriver(), Nominee_BankAccount);

                // Account type (no suffix, as it's common)
                try {
                    if (((String) args.get("NomineeAccountType")).equalsIgnoreCase("Current")) { // FIXED: Type casting
                        Nominee_BankAccount.click();
                    }
                } catch (Exception e) {
                    System.out.println("##########Error Message Is " + e);
                    handlePageError(e, args, "Nominee_BankAccount");
                }

                // IFSC code
                try { 
                    Nominee_IFSCCode.type((String) args.get("NomineeIFSC_Code" + suffix)); // FIXED: Type casting
                } catch (Exception e) { 
                    handlePageError(e, args, "Nominee_IFSCCode" + suffix); 
                }

                // For all but the last nominee, click AddNominee to add next nominee
                if (i < numberOfNominee) {
                    CU.scrollToView(getDriver(), AddNominee);
                    try { 
                        AddNominee.click(); 
                    } catch (Exception e) { 
                        handlePageError(e, args, "AddNominee"); 
                    }
                }
            }

            // After last nominee, click Save and Save & Proceed
            pause(1);
            CU.scrollToView(getDriver(), Nominee_IFSCCode);
            pause(1);
            
            try {
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Nominee Page1");
                Nominee_Save.click();
            } catch (Exception e) { 
                handlePageError(e, args, "Nominee_Save"); 
            }
            
            CU.scrollToView(getDriver(), SaveAndProceed);
            
            try {
                CommonUtilities.CaptureScreenshot(args, getDriver(), "Nominee Page2");
                SaveAndProceed.click();
            } catch (Exception e) { 
                handlePageError(e, args, "SaveAndProceed"); 
            }
            
        } catch (NumberFormatException e) {
            System.out.println("##########Error Message Is " + e);
            handlePageError(e, args, "NumberOfNominee (invalid number)");
        } catch (Exception e) {
            System.out.println("##########Error Message Is " + e);
            handlePageError(e, args, "NomineePage");
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
