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

public class PNB_Agent_And_Payment_Page10 extends AbstractPage {

    public PNB_Agent_And_Payment_Page10(WebDriver driver) {
        super(driver);
    } // FIXED: Added missing closing brace

    // FIXED: Moved ALL @FindBy elements outside constructor - keeping all your original elements
    // --- Agent Section ---
    @FindBy(xpath = "//ng-select[@formcontrolname='agentCode' and @placeholder='Please select agent code']")
    private ExtendedWebElement AgentCode;

    @FindBy(xpath = "//ng-select[@formcontrolname='agentCode']//*[normalize-space(text())='Test Nitin Seth 99005567']")
    private ExtendedWebElement AgentCode_Value;

    @FindBy(xpath = "//input[@placeholder='Please choose bank employee' or @aria-placeholder='Please choose bank employee']")
    private ExtendedWebElement BankEmployee;

    @FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted' and normalize-space(text())='MBGB,M4321']")
    private ExtendedWebElement BankEmployee_Value;

    @FindBy(xpath = "//input[@aria-placeholder='Please select specified person code']")
    private ExtendedWebElement SpecifiedPersonCode;

    @FindBy(xpath = "CHANDRA PRAKASH WADH,30000519,9833139389 dsouza.denzil-adolpus@pnbmetlife.com")
    private ExtendedWebElement SpecifiedPersonCode_Value;

    @FindBy(xpath = "//label[@for='addressRadio1' and normalize-space(.)='Yes']")
    private ExtendedWebElement PolicyFor_Agent;

    @FindBy(xpath = "//label[@for='addressRadio2' and normalize-space(.)='No']")
    private ExtendedWebElement PolicyFor_Agent_No;

    @FindBy(xpath = "//label[@for='addressRadio1' and contains(normalize-space(),'Online')]")
    private ExtendedWebElement SPDeclaration_Online;

    @FindBy(xpath = "//label[@for='addressRadio2' and contains(normalize-space(),'Offline')]")
    private ExtendedWebElement SPDeclaration_Offline;

    @FindBy(xpath = "//label[@for='addressRadio3' and contains(normalize-space(),'Online')]")
    private ExtendedWebElement Customer_Online;

    @FindBy(xpath = "//label[@for='addressRadio4' and contains(normalize-space(),'Offline')]")
    private ExtendedWebElement Customer_Offline;

    // --- Payment Info Section ---
    @FindBy(xpath = "//button[normalize-space(text())='Policy Owner']")
    private ExtendedWebElement PolicyOwner;

    @FindBy(xpath = "//button[normalize-space(text())='3rd Party Payment']")
    private ExtendedWebElement ThirdParty;

    @FindBy(xpath = "//label[@for='inlineRadio1' and normalize-space()='Male']")
    private ExtendedWebElement ThirdParty_Gender_M;

    @FindBy(xpath = "//label[@for='inlineRadio2' and normalize-space()='Female']")
    private ExtendedWebElement ThirdParty_Gender_F;

    @FindBy(xpath = "//label[@for='inlineRadio3' and normalize-space()='Others']")
    private ExtendedWebElement ThirdParty_Gender_O;

    @FindBy(xpath = "//ng-select[@placeholder='Select Option' and @formcontrolname='customerSalutation']")
    private ExtendedWebElement ThirdParty_Salutation;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement ThirdParty_Salutation_DropDownValue;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    private ExtendedWebElement ThirdParty_FName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private ExtendedWebElement ThirdParty_LName;

    @FindBy(xpath = "//ng-select[@placeholder='Select Option' and @formcontrolname='RelationshipWithPolicyinsured']")
    private ExtendedWebElement RelationshipWithPolicyinsured;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement RelationshipWithPolicyinsured_DropDownValue;

    @FindBy(xpath = "//ng-select[@placeholder='Select Option' and @formcontrolname='RelationshipWithPolicyOwner']")
    private ExtendedWebElement RelationshipWithPolicyOwner;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement RelationshipWithPolicyOwner_DropDownValue;

    @FindBy(xpath = "//input[@formcontrolname='dateofBirth']")
    private ExtendedWebElement ThirdParty_DOB;

    @FindBy(xpath = "//ng-select[@placeholder='Please select residential status' and @formcontrolname='residentialStatus']")
    private ExtendedWebElement ThirdParty_ResidentialStatus;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement ThirdParty_ResidentialStatus_DropDownValue;

    @FindBy(xpath = "//ng-select[@placeholder='Please select occupation' and @formcontrolname='occupation']")
    private ExtendedWebElement ThirdParty_Occupation;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement ThirdParty_Occupation_DropDownValue;

    @FindBy(xpath = "//input[@placeholder='Enter Annual income' and @formcontrolname='anualIncome']")
    private ExtendedWebElement ThirdParty_AnnualIncome;

    @FindBy(xpath = "//input[@placeholder='Enter Mobile number' and @formcontrolname='mobileNumber']")
    private ExtendedWebElement ThirdParty_MobileNumber;

    @FindBy(xpath = "//input[@placeholder='Please Enter Email id' and @formcontrolname='Emailid']")
    private ExtendedWebElement ThirdParty_EmailId;

    @FindBy(xpath = "//ng-select[@placeholder='Please select Reason for 3rd Party Payment' and @formcontrolname='realtionreason']")
    private ExtendedWebElement ThirdParty_Reason;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement ThirdParty_Reason_DropDownValue;

    @FindBy(xpath = "//input[@type='checkbox' and @formcontrolname='addressToggle']")
    private ExtendedWebElement addressToggle;

    @FindBy(xpath = "//*[@formcontrolname='payemntMode']")
    private ExtendedWebElement FirstPremiumPayment;

    @FindBy(xpath = "//input[@aria-placeholder='Please select the First Premium Payment']")
    private ExtendedWebElement FirstPremiumPayment_Type;

    @FindBy(xpath = "//*[text()='Local Branch']")
    private ExtendedWebElement LocalBranch_Button;

    @FindBy(xpath = "//*[text()='Outstation Branch']")
    private ExtendedWebElement OutstationBranch_Button;

    @FindBy(xpath = "//input[@formcontrolname='IfseCode' and @placeholder='Please Enter IFSC code'] ")
    private ExtendedWebElement IFSC;

    @FindBy(xpath = "//input[@formcontrolname='AccountNumber' and @placeholder='Please Enter Acount Number']")
    private ExtendedWebElement AccountNumber;

    @FindBy(xpath = "//input[@formcontrolname='ChequeNo' and @placeholder='Please Enter cheque no']")
    private ExtendedWebElement ChequeNumber;

    @FindBy(xpath = "//input[@formcontrolname='ChequeDate' and @placeholder='Please Eneter cheque Date']")
    private ExtendedWebElement ChequeDate;

    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@class, 'ng-option')]//span[text()='%s']")
    private ExtendedWebElement FirstPremiumPayment_Type_Value;

    @FindBy(xpath = "//*[@placeholder='Please select Renewable Payment Options']")
    private ExtendedWebElement RenewablePayment;

    @FindBy(xpath = "//input[@aria-placeholder='Please select Renewable Payment Options']")
    private ExtendedWebElement RenewablePayment_TYPE;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement RenewablePayment_Type_Value;

    @FindBy(xpath = "//button[normalize-space(text())='OK']")
    private ExtendedWebElement OK_Button;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed_3;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed_2;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed;
    
    @FindBy(xpath = "//*[text()='Ok']")
    private ExtendedWebElement Ok_btn;  

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method ---
    public void AgentPayment(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        
        try {
            Agent(args);
            PaymentInfo(args);
            actualResult += "Agent and Payment Information completed successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "AgentPayment");
        }
    } // FIXED: Added missing closing brace

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

    // --- Agent Method ---
    public void Agent(HashMap args) {
        try {
            // IMPROVED: Smart wait for page load
            ImprovedWaits.waitForPageLoad(getDriver());
            
            wait.until(ExpectedConditions.visibilityOf(AgentCode.getElement()));
            AgentCode.click();
            AgentCode_Value.click();
            
            BankEmployee.click();
            BankEmployee_Value.click();
            
            SpecifiedPersonCode.click();
//            SpecifiedPersonCode_Value.click();

            if (((String) args.get("PolicyForAgent")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                PolicyFor_Agent.click();
            } else {
                PolicyFor_Agent_No.click();
            }

            CommonUtilities.CaptureScreenshot(args, getDriver(), "AgentDetails_1");
            CU.scrollToView(getDriver(), SaveAndProceed_2);
            SaveAndProceed.click();
            
            wait.until(ExpectedConditions.visibilityOf(Customer_Offline.getElement()));
            CU.scrollToView(getDriver(), Customer_Offline);
            pause(2);

            if (((String) args.get("SP_Declaration")).equalsIgnoreCase("Offline")) { // FIXED: Type casting
                SPDeclaration_Offline.click();
            } else {
                SPDeclaration_Online.click();
            }

            if (((String) args.get("Customer_Declaration")).equalsIgnoreCase("Offline")) { // FIXED: Type casting
                Customer_Offline.click();
            } else {
                Customer_Online.click();
            }

            pause(1);
            CU.scrollToView(getDriver(), SaveAndProceed_2);
            pause(1);
            CU.scrollToView(getDriver(), SaveAndProceed_2);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "AgentDetails_2");
            SaveAndProceed.click();
            
        } catch (Exception e) {
            System.out.println("##########Error Message Is " + e);
            handlePageError(e, args, "Agent");
        }
    } // FIXED: Added missing closing brace

    // --- Payment Info Method ---
    public void PaymentInfo(HashMap args) {
        try { //Add Pause here
        	pause(3);
            if (((String) args.get("Payer_PolicyOwner")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                PolicyOwner.click();
            }

            if (((String) args.get("Payer_ThirdParty")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                ThirdParty.click();
                
                if (((String) args.get("Payer_ThirdParty_Gender")).equalsIgnoreCase("Male")) { // FIXED: Type casting
                    ThirdParty_Gender_M.click();
                }

                if (((String) args.get("Payer_ThirdParty_Gender")).equalsIgnoreCase("Female")) { // FIXED: Type casting
                    ThirdParty_Gender_F.click();
                }

                if (((String) args.get("Payer_ThirdParty_Gender")).equalsIgnoreCase("Others")) { // FIXED: Type casting
                    ThirdParty_Gender_O.click();
                }

                ThirdParty_Salutation.click();
                ThirdParty_Salutation_DropDownValue.format((String) args.get("ThirdParty_Salutation")).click(); // FIXED: Type casting

                RelationshipWithPolicyinsured.click();
                RelationshipWithPolicyinsured_DropDownValue.format((String) args.get("RelationshipWithPolicyinsured")).click(); // FIXED: Type casting

                RelationshipWithPolicyOwner.click();
                RelationshipWithPolicyOwner_DropDownValue.format((String) args.get("RelationshipWithPolicyOwner")).click(); // FIXED: Type casting

                ThirdParty_DOB.click();
                ThirdParty_DOB.type((String) args.get("NomineeDOB")); // FIXED: Type casting
                ThirdParty_DOB.getElement().sendKeys(Keys.ENTER);

                ThirdParty_ResidentialStatus.click();
                ThirdParty_ResidentialStatus_DropDownValue.format((String) args.get("ThirdParty_ResidentialStatus")).click(); // FIXED: Type casting

                ThirdParty_Occupation.click();
                ThirdParty_Occupation_DropDownValue.format((String) args.get("ThirdParty_Occupation")).click(); // FIXED: Type casting

                ThirdParty_AnnualIncome.type((String) args.get("ThirdParty_AnnualIncome")); // FIXED: Type casting
                ThirdParty_MobileNumber.type((String) args.get("ThirdParty_MobileNumber")); // FIXED: Type casting
                ThirdParty_EmailId.type((String) args.get("ThirdParty_EmailId")); // FIXED: Type casting

                ThirdParty_Reason.click();
                ThirdParty_Reason_DropDownValue.format((String) args.get("ThirdParty_Reason")).click(); // FIXED: Type casting

                if (((String) args.get("addressToggle")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    addressToggle.click();
                }
            }

            CU.scrollToView(getDriver(), SaveAndProceed_2);
            pause(1);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "PaymentInfo_1");
            SaveAndProceed.click();
            
            FirstPremiumPayment.click();
            FirstPremiumPayment_Type.type((String) args.get("FirstPremiumPayment_Type")); // FIXED: Type casting
            FirstPremiumPayment_Type.getElement().sendKeys(Keys.ENTER);
            pause(2);

            if (((String) args.get("FirstPremiumPayment_Type")).equalsIgnoreCase("Cheque Payment")) { // FIXED: Type casting
                LocalBranch_Button.click();
                
                IFSC.click();
                IFSC.type((String) args.get("IFSC")); // FIXED: Type casting
                IFSC.getElement().sendKeys(Keys.ENTER);
                pause(2);
                
                AccountNumber.click();
                AccountNumber.type((String) args.get("AccountNumber")); // FIXED: Type casting
                
                ChequeNumber.click();
                ChequeNumber.type((String) args.get("ChequeNumber")); // FIXED: Type casting
                
                ChequeDate.click();
                ChequeDate.type((String) args.get("ChequeDate")); // FIXED: Type casting
                ChequeDate.getElement().sendKeys(Keys.ENTER);
            }

            CommonUtilities.CaptureScreenshot(args, getDriver(), "PaymentInfo_2");
            SaveAndProceed_2.click();
            
            RenewablePayment.click();
            RenewablePayment_TYPE.type((String) args.get("RenewablePayment_Type")); // FIXED: Type casting
            RenewablePayment_TYPE.getElement().sendKeys(Keys.ENTER);
            pause(0.5);

            OK_Button.click();
            pause(0.5);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "PaymentInfo_3");
            SaveAndProceed_2.click();
            
            CU.scrollToView(getDriver(), SaveAndProceed_2);
            pause(0.5);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "PaymentInfo_4");
            SaveAndProceed_3.click();
            pause(0.5);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "PaymentInfo51");
            SaveAndProceed_3.click();
            pause(0.5);
            Ok_btn.click();
            
        } catch (Exception e) {
            System.out.println("##########Error Message Is " + e);
            handlePageError(e, args, "PaymentInfo");
        }
    } // FIXED: Added missing closing brace

    // --- Utility Methods ---
    private void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
