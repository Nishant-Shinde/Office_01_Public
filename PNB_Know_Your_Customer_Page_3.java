package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.utils.CommonUtilities;
import com.web.utils.ImprovedWaits;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class PNB_Know_Your_Customer_Page_3 extends AbstractPage {

    public PNB_Know_Your_Customer_Page_3(WebDriver driver) {
        super(driver);
    }

    // --- Element Locators ---
    @FindBy(xpath = "//*[text()='Customer is buying the Policy for?']")
    private ExtendedWebElement pleseselectpolicycovertype;

    @FindBy(xpath = "(//button[text()=' %s'])[last()]")
    private ExtendedWebElement Select_Covertype;

    @FindBy(xpath = "//*[text()=' Individual']")
    private ExtendedWebElement individual;

    @FindBy(xpath = "//*[text()='Married Women Property']")
    private ExtendedWebElement marriedwomen;

    @FindBy(xpath = "(//button[text()=' %s'])[last()]")
    private ExtendedWebElement Policy_Buy_for;

    @FindBy(xpath = "(//button[text()=' Family Member'])[last()]")
    private ExtendedWebElement FamilyMember;

    @FindBy(xpath = "//ng-select[@formcontrolname='customerResidentialStatuspo']")
    private ExtendedWebElement customerResidentialStatusField;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_RESIDENTIAL;

    @FindBy(xpath = "//ng-select[contains(@formcontrolname,'customernationalityPO')]")
    private ExtendedWebElement customerNationalityField;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_Nationality;

    @FindBy(xpath = "//*[@formcontrolname='customerEmailID']")
    private ExtendedWebElement CustomerEmailID;

    @FindBy(xpath = "//*[@formcontrolname='customerMobileno']")
    private ExtendedWebElement CustomerMobileNo;

    @FindBy(xpath = "//span[@class='slider']")
    private ExtendedWebElement checkbox;

    @FindBy(xpath = "//*[text()=' Keep Digital Copy ']")
    private ExtendedWebElement KeepDigitalCopybtn;

    @FindBy(xpath = "//*[text()='Quickly Fill Information from Aadhaar']")
    private ExtendedWebElement AdharCardInfoBtn;

    @FindBy(xpath = "//*[text()='Enter Your Aadhaar Number or Virtual ID (VID) to complete authentication ']")
    private ExtendedWebElement Authenticationtext;

    @FindBy(xpath = "(//label[text()='%s'])[last()]")
    private ExtendedWebElement select_authentication;

    @FindBy(xpath = "//label[text()='Virtual ID']")
    private ExtendedWebElement VirtualID_Radio;

    @FindBy(xpath = "//label[text()='Aadhaar']")
    private ExtendedWebElement AdharCard_Radio;

    @FindBy(xpath = "//*[@formcontrolname='aadhaarno']")
    private ExtendedWebElement AdharCard_Type;

    @FindBy(xpath = "//*[@formcontrolname='selectConsentLang']")
    private ExtendedWebElement selectConsentLang;

    @FindBy(xpath = "(//option[text()='%s'])[last()]")
    private ExtendedWebElement dropdown_Language;

    @FindBy(xpath = "//input[@type='checkbox' and @formcontrolname='ischecked']")
    private ExtendedWebElement ischecked;

    @FindBy(xpath = "//*[text()='Generate Code']")
    private ExtendedWebElement Generate_OTP_Btn;

    @FindBy(xpath = "//*[text()='Verify Code']")
    private ExtendedWebElement Verify_OTP;

    @FindBy(xpath = "//*[@class='editinput ng-star-inserted']")
    private ExtendedWebElement Ageedit_Checkbox;

    @FindBy(xpath = "//*[text()=' Yes ']")
    private ExtendedWebElement Yesbutton;

    @FindBy(xpath = "//*[@formcontrolname='customerDOB']")
    private ExtendedWebElement CustomerDOB;

    @FindBy(xpath = "//td[@role='gridcell']/span[text()='%s']")
    private ExtendedWebElement targetYearElement;

    @FindBy(xpath = "//td[@role='gridcell']/span[text()='%s']")
    private ExtendedWebElement targetMonthElement;

    @FindBy(xpath = "//td[@role='gridcell']/span[@class='ng-star-inserted'][text()='%s']")
    private ExtendedWebElement targetDayElement;

    @FindBy(xpath = "//*[text()='Pancard']")
    private ExtendedWebElement PancardBTN;

    @FindBy(xpath = "//*[text()=' eKYC Verfied ']")
    private ExtendedWebElement EKYCText;

    @FindBy(xpath = "//*[@formcontrolname='autheniticatePAN']")
    private ExtendedWebElement Pancardtype;

    @FindBy(xpath = "//*[text()=' Save & Proceed']")
    private ExtendedWebElement SaveProceedBtn;

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // Define timeout constant
    private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method ---
    public void Knowyourcustomer(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", "");
        
        try {
            // Execute KYC process
            KnowYourCustomer(args);
            
            actualResult += "Know Your Customer Page flow completed successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "Knowyourcustomer main flow");
        }
    }

    // --- KYC Process Method ---
    public void KnowYourCustomer(HashMap args) {
        try {
            // Step 1: Handle cover type and policy selection
            handleCoverTypeAndPolicy(args);
            
            // Step 2: Handle contact information
            handleContactInformation(args);
            
            // Step 3: Handle Aadhaar authentication
            handleAadhaarAuthentication(args);
            
            // Step 4: Complete the process
            completeKYCProcess(args);
            
        } catch (Exception e) {
            handlePageError(e, args, "KnowYourCustomer main flow");
        }
    }

    // --- Handle Cover Type and Policy Selection ---
    private void handleCoverTypeAndPolicy(HashMap args) {
        try {
            // Wait for page to load
            ImprovedWaits.waitForPageLoad(getDriver());
            
            // Cover Type Selection
            String coverType = (String) args.get("Cover_Type");
            if (coverType != null && !coverType.trim().isEmpty() && !coverType.equalsIgnoreCase("NA")) {
                try {
                    Select_Covertype.format(coverType);
                    
                    if (coverType.equalsIgnoreCase("Individual")) {
                        individual.click();
                    } else if (coverType.equalsIgnoreCase("Married Women's Property Act")) {
                        marriedwomen.click();
                    }
                } catch (Exception e) {
                    LOGGER.warn("Cover type selection failed: " + coverType);
                }
            }
            
            // Policy Buy For Selection
            String policyBuyFor = (String) args.get("Policy_Buy_for");
            if (policyBuyFor != null && !policyBuyFor.trim().isEmpty() && !policyBuyFor.equalsIgnoreCase("NA")) {
                try {
                    Policy_Buy_for.format(policyBuyFor);
                    
                    if (policyBuyFor.equalsIgnoreCase("Family Member")) {
                        FamilyMember.click();
                    }
                } catch (Exception e) {
                    LOGGER.warn("Policy buy for selection failed: " + policyBuyFor);
                }
            }
            
//            // Residential Status Selection
//            String residentialStatus = (String) args.get("Residential_Status");
//            if (residentialStatus != null && !residentialStatus.trim().isEmpty() && !residentialStatus.equalsIgnoreCase("NA")) {
//                try {
//                    ImprovedWaits.smartWait(getDriver(), customerResidentialStatusField, 5);
//                    customerResidentialStatusField.click();
//                    dropdown_RESIDENTIAL.format(residentialStatus).click();
//                } catch (Exception e) {
//                    LOGGER.warn("Residential status selection failed: " + residentialStatus);
//                }
//            }
//            
//            // Nationality Selection
//            String nationality = (String) args.get("Customer_Nationality");
//            if (nationality != null && !nationality.trim().isEmpty() && !nationality.equalsIgnoreCase("NA")) {
//                try {
//                    ImprovedWaits.smartWait(getDriver(), customerNationalityField, 5);
//                    customerNationalityField.click();
//                    dropdown_Nationality.format(nationality).click();
//                } catch (Exception e) {
//                    LOGGER.warn("Nationality selection failed: " + nationality);
//                }
//            }
            
        } catch (Exception e) {
            handlePageError(e, args, "Cover type and policy selection");
        }
    }

    // --- Handle Contact Information ---
    private void handleContactInformation(HashMap args) {
        try {
            // Email ID
            String emailID = (String) args.get("Customer_EmailID");
            if (emailID != null && !emailID.trim().isEmpty()) {
                ImprovedWaits.smartWait(getDriver(), CustomerEmailID, 5);
                CustomerEmailID.getElement().clear();
                CustomerEmailID.type(emailID);
                CustomerEmailID.getElement().sendKeys(Keys.ENTER);
            }
            
            // Mobile Number
            String mobileNo = (String) args.get("Customer_MobileNo");
            if (mobileNo != null && !mobileNo.trim().isEmpty()) {
                ImprovedWaits.smartWait(getDriver(), CustomerMobileNo, 5);
                CustomerMobileNo.getElement().clear();
                CustomerMobileNo.type(mobileNo);
                CustomerMobileNo.getElement().sendKeys(Keys.ENTER);
            }
            
            // Capture screenshot after contact info
            CommonUtilities.CaptureScreenshot(args, getDriver(), "ContactInformation");
            
        } catch (Exception e) {
            handlePageError(e, args, "Contact information entry");
        }
    }

    // --- Handle Aadhaar Authentication ---
    private void handleAadhaarAuthentication(HashMap args) {
        try {
            // Scroll to Family Member section
            CU.scrollToView(getDriver(), FamilyMember);
            
            // Click Aadhaar Card Info Button
            ImprovedWaits.smartWait(getDriver(), AdharCardInfoBtn, 10);
            AdharCardInfoBtn.click();
            
            // Wait for authentication text
            ImprovedWaits.smartWait(getDriver(), Authenticationtext, 10);
            
            // Select authentication type
            String authenticationType = (String) args.get("Authentication");
            if (authenticationType != null && !authenticationType.trim().isEmpty()) {
                select_authentication.format(authenticationType);
                
                if (authenticationType.equalsIgnoreCase("Aadhaar")) {
                    pause(3);
                    AdharCard_Radio.click();
                    
                    // Enter Aadhaar number based on gender
                    String gender = (String) args.get("Gender");
                    if (gender != null) {
                        String aadhaarNumber = getAadhaarNumberByGender(gender);
                        AdharCard_Type.type(aadhaarNumber);
                    }
                    
                } else if (authenticationType.equalsIgnoreCase("Virtual ID")) {
                    VirtualID_Radio.click();
                }
            }
            
            // Scroll to and click consent checkbox
            CU.scrollToView(getDriver(), ischecked);
            pause(2);
            ischecked.click();
            
            // Generate OTP
            Generate_OTP_Btn.click();
            pause(3);
            
            // Handle OTP entry
            handleOTPEntry(args);
            
            // Verify OTP
            Verify_OTP.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "Aadhaar authentication");
        }
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

    // --- Complete KYC Process ---
    private void completeKYCProcess(HashMap args) {
        try {
            // Age edit checkbox
            Ageedit_Checkbox.click();
            pause(1);
            
            // Yes button
            Yesbutton.click();
            
            // Date of Birth
            String dob = (String) args.get("DOB");
            if (dob != null && !dob.trim().isEmpty()) {
                CustomerDOB.click();
                CustomerDOB.type(dob);
                CustomerDOB.getElement().sendKeys(Keys.ENTER);
            }
            
            // Scroll to eKYC section
            CU.scrollToView(getDriver(), EKYCText);
            
            // Enter PAN card
            String pancard = (String) args.get("Pancard");
            if (pancard != null && !pancard.trim().isEmpty()) {
                Pancardtype.type(pancard);
            }
            
            // Final screenshot
            CommonUtilities.CaptureScreenshot(args, getDriver(), "KYC_Completed");
            
            // Save and proceed
            SaveProceedBtn.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "KYC completion");
        }
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

    // --- Error Handler ---
    private void handlePageError(Exception e, HashMap args, String elementName) {
        String pageName = this.getClass().getSimpleName();
        String errorMsg = String.format("Failed on %s: %s - %s", pageName, elementName, e.getMessage());
        
        LOGGER.error(errorMsg, e);
        System.err.println(errorMsg);
        
        // Update results with proper casting
        String actualResult = (String) args.getOrDefault("ActualResult", "");
        actualResult += errorMsg + " | ";
        args.put("ActualResult", actualResult);
        args.put("sOutput", errorMsg);
        args.put("status", "Fail");
        
        // Capture error screenshot
        CommonUtilities.CaptureScreenshot(args, getDriver(), "ErrorPage_" + elementName);
        
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