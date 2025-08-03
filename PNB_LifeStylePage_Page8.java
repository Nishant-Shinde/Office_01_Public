package com.EPro.web.gui.pages;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.web.utils.CommonUtilities;
import com.web.utils.ImprovedWaits;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class PNB_LifeStylePage_Page8 extends AbstractPage {

    public PNB_LifeStylePage_Page8(WebDriver driver) {
        super(driver);
    } // FIXED: Added missing closing brace

    // FIXED: Moved ALL @FindBy elements outside constructor - keeping all your original elements
    @FindBy(xpath = "//label[@for='familyHistory-0' and contains(normalize-space(.), 'Yes')]")
    private ExtendedWebElement FamilyMemberSuffering_Yes;

    @FindBy(xpath = "//label[@for='familyHistory-1' and contains(normalize-space(.), 'No')]")
    private ExtendedWebElement FamilyMemberSuffering_No;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement RelationWith_PI_Values;

    @FindBy(xpath = "//ng-select[@formcontrolname='relationshipWithPI']//input[@role='combobox']")
    private ExtendedWebElement RelationWith_PI;

    @FindBy(xpath = "//label[@for='presentCondition-0' and contains(normalize-space(.), 'Alive')]")
    private ExtendedWebElement PresentCondtion_Alive;

    @FindBy(xpath = "//label[@for='presentCondition-1' and contains(normalize-space(.), 'Deceased')]")
    private ExtendedWebElement PresentCondtion_Deceased;

    @FindBy(xpath = "//ng-select[@formcontrolname='disorderOrDiseaseDetail']")
    private ExtendedWebElement disorderDropdown;

    @FindBy(xpath = "//input[@formcontrolname='ageAtDiagnosisOrDeath']")
    private ExtendedWebElement AgeAtDiagnosisOrDeath;

    @FindBy(xpath = "//ng-select[@formcontrolname='disorderOrDiseaseDetail']//input[@role='combobox']")
    private ExtendedWebElement DiseaseDetail;

    @FindBy(xpath = "//input[@formcontrolname='additionalRemarks']")
    private ExtendedWebElement Remarks;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Add Member')]")
    private ExtendedWebElement AddMember;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed;

    @FindBy(xpath = "//input[@aria-placeholder=\"-weight-\"]")
    private ExtendedWebElement CustomerWeight_Type;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed_2;

    @FindBy(xpath = "//div[contains(@class, 'question-box')]//label[contains(normalize-space(.), \"In the last five years has Mr. FirstName\")]")
    private ExtendedWebElement TakenAnyIntoxication;

    @FindBy(xpath = "//div[contains(@class, 'question-box')]//label[contains(normalize-space(.), 'Has Mr. FirstName') and contains(normalize-space(.), 'nicotine or Tobacco Products')]")
    private ExtendedWebElement ConsumedTobaccoProducts;

    @FindBy(xpath = "//label[normalize-space(.)='Beedi']")
    private ExtendedWebElement Beedi;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many sticks of Beedi')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyStickBeedi;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Beedi')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongBeedi;

    @FindBy(xpath = "//label[normalize-space(.)='Cigarette']")
    private ExtendedWebElement Cigarette;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many cigarettes')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyCigarette;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'cigarettes')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongCigarette;

    @FindBy(xpath = "//label[normalize-space(.)='Gutkha']")
    private ExtendedWebElement Gutkha;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many times a day') and contains(., 'Gutkha')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyGutkha;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Gutkha')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongGutkha;

    @FindBy(xpath = "//label[normalize-space(.)='Cigar']")
    private ExtendedWebElement Cigar;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many cigars')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyCigar;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'cigars')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongCigar;

    @FindBy(xpath = "//label[normalize-space(.)='Pipe']")
    private ExtendedWebElement Pipe;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many times a day') and contains(., 'pipe')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyPipe;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'pipe')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongPipe;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Has Mr. FirstName') and contains(., 'consumed Alcohol')]")
    private ExtendedWebElement ConsumedAlcohol;

    @FindBy(xpath = "//label[normalize-space(.)='Beer']")
    private ExtendedWebElement Beer;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many pints of Beer')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyBeer;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Beer')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongBeer;

    @FindBy(xpath = "//label[normalize-space(.)='Wine']")
    private ExtendedWebElement Wine;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many ml of Wine')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyWine;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Wine')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongWine;

    @FindBy(xpath = "//label[normalize-space(.)='Liquor']")
    private ExtendedWebElement Liquor;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many ml of Liquor')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyLiquor;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Liquor')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongLiquor;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Has Mr. FirstName') and contains(., 'Narcotics or Drugs')]")
    private ExtendedWebElement ConsumedDrugs;

    @FindBy(xpath = "//label[normalize-space(.)='Marijuana']")
    private ExtendedWebElement Marijuana;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many gm of Marijuana')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyMarijuana;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Marijuana')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongMarijuana;

    @FindBy(xpath = "//label[normalize-space(.)='Cocaine']")
    private ExtendedWebElement Cocaine;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many gm of Cocaine')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyCocaine;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Cocaine')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongCocaine;

    @FindBy(xpath = "//label[normalize-space(.)='Addictive Drugs']")
    private ExtendedWebElement AddictiveDrugs;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'How many gm of Addictive Drugs')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowManyAddictiveDrugs;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Since how long has Mr. FirstName') and contains(., 'Addictive Drugs')]/following-sibling::input[@type='tel']")
    private ExtendedWebElement HowLongAddictiveDrugs;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Is your occupation associated with Hazards')]")
    private ExtendedWebElement OccupationAssociated_WithHazards;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Is Mr. FirstName LastName (PO) employed')]")
    private ExtendedWebElement EmployedInTheArmed;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Is Mr. FirstName LastName (PO) expected to fly')]")
    private ExtendedWebElement ExceptedToFly;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Does Mr. FirstName LastName (PO) engage in Adventure Sports')]")
    private ExtendedWebElement AdventureSports;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Are you (PO) Mr. FirstName LastName Third Party Payer')]")
    private ExtendedWebElement PoliticallyExposed;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Are you (PO) Mr. FirstName LastName, Third Party Payer an organization')]")
    private ExtendedWebElement TrustCharityNGO;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Does Mr. FirstName LastName (PO) have any criminal case')]")
    private ExtendedWebElement CriminalCase;

    @FindBy(xpath = "//*[@id='customerHeightSelect']")
    private ExtendedWebElement CustomerHeight;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement CustomerHeight_Values;

    @FindBy(xpath = "//*[@placeholder='-weight-']")
    private ExtendedWebElement CustomerWeight;

    @FindBy(xpath = "(//span[text()='%s'])[last()]")
    private ExtendedWebElement CustomerWeight_Values;

    @FindBy(xpath = "//label[contains(normalize-space(.), 'Has there been weight loss or weight gain')]")
    private ExtendedWebElement CustomerWeight_Increase;

    // Agent elements
    @FindBy(xpath = "//ng-select[@formcontrolname='agentCode' and @placeholder='Please select agent code']")
    private ExtendedWebElement AgentCode;

    @FindBy(xpath = "//ng-select[@formcontrolname='agentCode']//*[normalize-space(text())='Kumar Kaushal 99105043']")
    private ExtendedWebElement AgentCode_Value;

    @FindBy(xpath = "//input[@placeholder='Please choose bank employee' or @aria-placeholder='Please choose bank employee']")
    private ExtendedWebElement BankEmployee;

    @FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted' and normalize-space(text())='null,1111111']")
    private ExtendedWebElement BankEmployee_Value;

    @FindBy(xpath = "//input[@aria-placeholder='Please select specified person code']")
    private ExtendedWebElement SpecifiedPersonCode;

    @FindBy(xpath = "//*[normalize-space(text())='DUTTA Santu,38000092']")
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

    // Payment Info elements
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

    @FindBy(xpath = "//input[@aria-placeholder='Please select the First Premium Payment']")
    private ExtendedWebElement FirstPremiumPayment_Type;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement FirstPremiumPayment_Type_Value;

    @FindBy(xpath = "//input[@aria-placeholder='Please select Renewable Payment Options']")
    private ExtendedWebElement RenewablePayment_Type;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement RenewablePayment_Type_Value;

    @FindBy(xpath = "//button[normalize-space(text())='OK']")
    private ExtendedWebElement OK_Button;

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed_3;

    // Upload elements
    @FindBy(xpath = "(//input[@role='combobox' and @aria-placeholder=\"Please select the customer's \"])[1]")
    private ExtendedWebElement AgeProof;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement AgeProof_Value;

    @FindBy(xpath = "(//input[@role='combobox' and @aria-placeholder=\"Please select the customer's \"])[2]")
    private ExtendedWebElement BankProof;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement BankProof_Value;

    @FindBy(xpath = "(//input[@role='combobox' and @aria-placeholder=\"Please select the customer's \"])[3]")
    private ExtendedWebElement PanProof;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement PanProof_Value;

    @FindBy(xpath = "(//input[@role='combobox' and @aria-placeholder=\"Please select the customer's \"])[4]")
    private ExtendedWebElement IncomeProof;

    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement IncomeProof_Value;

    @FindBy(xpath = "//label[@for='pi_photo']")
    private ExtendedWebElement ProfileUplod;

    @FindBy(xpath = "//label[@for='age_proof']")
    private ExtendedWebElement age_proof_doc;

    @FindBy(xpath = "//label[@for='bank_proof']")
    private ExtendedWebElement bank_proof_doc;

    @FindBy(xpath = "//label[@for='pi_pan']")
    private ExtendedWebElement pi_pan_doc;

    @FindBy(xpath = "//label[@for='income_proof']")
    private ExtendedWebElement income_proof_doc;

    @FindBy(xpath = "(//button[normalize-space(text())='Upload'])[1]")
    private ExtendedWebElement PIProof_Upload;

    @FindBy(xpath = "(//button[normalize-space(text())='Upload'])[2]")
    private ExtendedWebElement AgeProof_Upload;

    @FindBy(xpath = "(//button[normalize-space(text())='Upload'])[3]")
    private ExtendedWebElement BankProof_Upload;

    @FindBy(xpath = "(//button[normalize-space(text())='Upload'])[4]")
    private ExtendedWebElement PanProof_Upload;

    @FindBy(xpath = "(//button[normalize-space(text())='Upload'])[5]")
    private ExtendedWebElement IncomeProof_Upload;

    @FindBy(xpath = "//button[normalize-space(text())='Submit Application']")
    private ExtendedWebElement SubmitApplication;

    @FindBy(xpath = "//button[normalize-space(text())='Proceed Ahead']")
    private ExtendedWebElement ProceedAhead;

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method ---
    public void LifeStyle_Page(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        
        try {
            LifeStyle(args);
            actualResult += "LifeStyle Page completed successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "LifeStyle_Page");
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

    // --- LifeStyle Method ---
    public void LifeStyle(HashMap args) {
        System.out.println("Inside Lifestyle");
        
        try {
            // IMPROVED: Smart wait for page load
            ImprovedWaits.waitForPageLoad(getDriver());
            
            // Family Member Suffering
            try {
                if (((String) args.get("FamilyMemberSuffering")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    FamilyMemberSuffering_Yes.click();
                    RelationWith_PI.click();
                    RelationWith_PI_Values.format((String) args.get("RelationWithPI")).click(); // FIXED: Type casting

                    if (((String) args.get("PresentCondtion")).equalsIgnoreCase("Alive")) { // FIXED: Type casting
                        PresentCondtion_Alive.click();
                    } else {
                        PresentCondtion_Deceased.click();
                    }

                    try {
                        String disorderValues = (String) args.get("DisorderDropdownValues"); // FIXED: Type casting
                        if (disorderValues != null && !disorderValues.trim().isEmpty()) {
                            String[] values = disorderValues.split("\\s*,\\s*"); // comma-separated
                            for (String val : values) {
                                disorderDropdown.click(); // open dropdown
                                Thread.sleep(1000); // brief pause (or WebDriverWait preferred)
                                String optionXpath = String.format("//ng-select[@formcontrolname='disorderOrDiseaseDetail']//div[contains(@class,'ng-option')][contains(.,'%s')]", val);
                                WebElement optionElement = getDriver().findElement(By.xpath(optionXpath));
                                if (optionElement.isDisplayed()) {
                                    optionElement.click();
                                    Thread.sleep(500); // ensure selection registers
                                } else {
                                    LOGGER.warn("Dropdown option not found: " + val);
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("##########Error Message Is " + e);
                        handlePageError(e, args, "DisorderDropdownValues Selection");
                    }

                    AgeAtDiagnosisOrDeath.type((String) args.get("DiganosisAge")); // FIXED: Type casting
                    Remarks.type((String) args.get("Remarks")); // FIXED: Type casting
                } else {
                    FamilyMemberSuffering_No.click();
                    //CommonUtilities.CaptureScreenshot(args, getDriver(), "FamilyMemberSuffering");
                }
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "FamilyMemberSuffering/Relation/Condition");
            }

            CU.scrollToView(getDriver(), FamilyMemberSuffering_Yes);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "FamilySufferings");
            
            // Save and Proceed after Family Member Suffering
            try {
                SaveAndProceed.click();
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "SaveAndProceed (FamilyMemberSuffering)");
            }

            // Taken Any Intoxication
            try {
                if (((String) args.get("TakenAnyIntoxication")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    TakenAnyIntoxication.click();
                }
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "TakenAnyIntoxication");
            }

            // Consumed Tobacco Products
            try {
                if (((String) args.get("Consumed_TobaccoProducts")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    CU.scrollToView(getDriver(), ConsumedTobaccoProducts);
                    ConsumedTobaccoProducts.click();
                    
                    // Tobacco Product Types
                    try {
                        if (((String) args.get("Beedi")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                            Beedi.click();
                            HowManyStickBeedi.type((String) args.get("HowManyStickBeedi")); // FIXED: Type casting
                            HowLongBeedi.type((String) args.get("HowLongBeedi")); // FIXED: Type casting
                        }

                        if (((String) args.get("Cigarette")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                            Cigarette.click();
                            HowManyCigarette.type((String) args.get("HowManyCigarette")); // FIXED: Type casting
                            CU.scrollToView(getDriver(), HowLongCigarette);
                            HowLongCigarette.type((String) args.get("HowLongCigarette")); // FIXED: Type casting
                        }

                        if (((String) args.get("Gutkha")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                            Gutkha.click();
                            HowManyGutkha.type((String) args.get("HowManyGutkha")); // FIXED: Type casting
                            HowLongGutkha.type((String) args.get("HowLongGutkha")); // FIXED: Type casting
                        }

                        if (((String) args.get("Cigar")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                            Cigar.click();
                            HowManyCigar.type((String) args.get("HowManyCigar")); // FIXED: Type casting
                            HowLongCigar.type((String) args.get("HowLongCigar")); // FIXED: Type casting
                        }

                        if (((String) args.get("Pipe")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                            Pipe.click();
                            CU.scrollToView(getDriver(), HowManyPipe);
                            HowManyPipe.type((String) args.get("HowManyPipe")); // FIXED: Type casting
                            HowLongPipe.type((String) args.get("HowLongPipe")); // FIXED: Type casting
                        }
                    } catch (Exception e) {
                        handlePageError(e, args, "Tobacco Details");
                    }
                }
            } catch (Exception e) {
                handlePageError(e, args, "ConsumedTobaccoProducts");
            }

            // Consumed Alcohol
            try {
                if (((String) args.get("ConsumedAlcohol")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    ConsumedAlcohol.click();
                    
                    if (((String) args.get("Beer")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        Beer.click();
                        HowManyBeer.type((String) args.get("HowManyBeer")); // FIXED: Type casting
                        CU.scrollToView(getDriver(), HowLongBeer);
                        HowLongBeer.type((String) args.get("HowLongBeer")); // FIXED: Type casting
                    }

                    if (((String) args.get("Wine")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        Wine.click();
                        HowManyWine.type((String) args.get("HowManyWine")); // FIXED: Type casting
                        HowLongWine.type((String) args.get("HowLongWine")); // FIXED: Type casting
                    }

                    if (((String) args.get("Liquor")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        Liquor.click();
                        HowManyLiquor.type((String) args.get("HowManyLiquor")); // FIXED: Type casting
                        CU.scrollToView(getDriver(), HowLongLiquor);
                        HowLongLiquor.type((String) args.get("HowLongLiquor")); // FIXED: Type casting
                    }
                }
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "ConsumedAlcohol");
            }

            // Consumed Drugs
            try {
                if (((String) args.get("ConsumedDrugs")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    ConsumedDrugs.click();
                    
                    if (((String) args.get("Marijuana")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        Marijuana.click();
                        HowManyMarijuana.type((String) args.get("HowManyMarijuana")); // FIXED: Type casting
                        CU.scrollToView(getDriver(), HowManyMarijuana);
                        HowLongMarijuana.type((String) args.get("HowLongMarijuana")); // FIXED: Type casting
                    }

                    if (((String) args.get("Cocaine")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        Cocaine.click();
                        HowManyCocaine.type((String) args.get("HowManyCocaine")); // FIXED: Type casting
                        HowLongCocaine.type((String) args.get("HowLongCocaine")); // FIXED: Type casting
                    }

                    if (((String) args.get("AddictiveDrugs")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                        AddictiveDrugs.click();
                        HowManyAddictiveDrugs.type((String) args.get("HowManyAddictiveDrugs")); // FIXED: Type casting
                        HowLongAddictiveDrugs.type((String) args.get("HowLongAddictiveDrugs")); // FIXED: Type casting
                    }
                }
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "ConsumedDrugs");
            }

            // Other Lifestyle Questions
            try {
                if (((String) args.get("OccupationAssociated_WithHazards")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    OccupationAssociated_WithHazards.click();
                    CU.scrollToView(getDriver(), OccupationAssociated_WithHazards);
                }

                if (((String) args.get("EmployedInTheArmed")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    EmployedInTheArmed.click();
                }

                if (((String) args.get("ExceptedToFly")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    CU.scrollToView(getDriver(), ExceptedToFly);
                    ExceptedToFly.click();
                }

                if (((String) args.get("AdventureSports")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    AdventureSports.click();
                }

                if (((String) args.get("PoliticallyExposed")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    PoliticallyExposed.click();
                }

                if (((String) args.get("TrustCharityNGO")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    TrustCharityNGO.click();
                }

                if (((String) args.get("CriminalCase")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                    CU.scrollToView(getDriver(), CriminalCase);
                    CriminalCase.click();
                }
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "OtherLifestyleQuestions");
            }

            // Final Save and Proceed
            pause(1);
            try {
                CU.scrollToView(getDriver(), SaveAndProceed);
                pause(1);
                CommonUtilities.CaptureScreenshot(args, getDriver(), "LifeStyle");
                CU.scrollToView(getDriver(), SaveAndProceed);
                SaveAndProceed.click();
                System.out.println("Worked");
            } catch (Exception e) {
                handlePageError(e, args, "SaveAndProceed (final)");
            }

        } catch (Exception e) {
            handlePageError(e, args, "LifeStyle (outer catch)");
        }
    }

    // --- Medical Method ---
    public void Medical(HashMap args) {
        try {
            CustomerHeight.click();
            CustomerHeight_Values.format((String) args.get("CustomerHeight")).click(); // FIXED: Type casting
            CustomerHeight_Values.getElement().sendKeys(Keys.ENTER);
            
            // Weight
            CustomerWeight.click();
            CustomerWeight_Type.type((String) args.get("CustomerWeight")); // FIXED: Type casting
            CustomerWeight_Type.getElement().sendKeys(Keys.ENTER);
            pause(2);
            
            CU.scrollToView(getDriver(), SaveAndProceed);
            pause(1);
            CU.scrollToView(getDriver(), SaveAndProceed);
            SaveAndProceed.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "Medical");
        }
    }

    // --- Agent Method ---
    public void Agent(HashMap args) {
        try {
            AgentCode.click();
            AgentCode_Value.click();
            BankEmployee.click();
            BankEmployee_Value.click();
            SpecifiedPersonCode.click();
            SpecifiedPersonCode_Value.click();

            if (((String) args.get("PolicyForAgent")).equalsIgnoreCase("Yes")) { // FIXED: Type casting
                PolicyFor_Agent.click();
            } else {
                PolicyFor_Agent_No.click();
            }

            CU.scrollToView(getDriver(), SaveAndProceed_2);
            SaveAndProceed.click();
            pause(10);

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
            SaveAndProceed.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "Agent");
        }
    }

    // --- Payment Info Method ---
    public void PaymentInfo(HashMap args) {
        try {
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
            SaveAndProceed.click();
            FirstPremiumPayment_Type.click();
            SaveAndProceed_2.click();
            RenewablePayment_Type.click();
            OK_Button.click();
            SaveAndProceed_2.click();
            SaveAndProceed_3.click();
            SaveAndProceed_3.click();
            
        } catch (Exception e) {
            handlePageError(e, args, "PaymentInfo");
        }
    }

    // --- Upload Documents Method - KEPT Robot class as per your requirement ---
    public void UploadDoc(HashMap args) throws AWTException {
        try {
            ProfileUplod.click();
            pause(2);
            
            String filePath = "D:\\ePro_MAS_Project\\Epro\\Screenshots_Reports\\25-Jun-2025_\\TC01_00_18_28\\BI Compare\\00001LoginScreen.jpg";
            
            // Copy the file path to clipboard
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            
            // Create Robot instance to simulate keyboard events
            Robot robot = new Robot();
            robot.delay(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            pause(1);

            CU.scrollToView(getDriver(), AgeProof);
            AgeProof.click();
            pause(4);
            age_proof_doc.click();
            
            Robot robot1 = new Robot();
            robot1.delay(1000);
            robot1.keyPress(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_V);
            robot1.keyRelease(KeyEvent.VK_CONTROL);
            robot1.keyPress(KeyEvent.VK_ENTER);
            robot1.keyRelease(KeyEvent.VK_ENTER);

            CU.scrollToView(getDriver(), BankProof);
            BankProof.click();
            pause(4);
            bank_proof_doc.click();
            
            Robot robot2 = new Robot();
            robot2.delay(1000);
            robot2.keyPress(KeyEvent.VK_CONTROL);
            robot2.keyPress(KeyEvent.VK_V);
            robot2.keyRelease(KeyEvent.VK_V);
            robot2.keyRelease(KeyEvent.VK_CONTROL);
            robot2.keyPress(KeyEvent.VK_ENTER);
            robot2.keyRelease(KeyEvent.VK_ENTER);

            PanProof.click();
            pause(4);
            pi_pan_doc.click();
            
            Robot robot3 = new Robot();
            robot3.delay(1000);
            robot3.keyPress(KeyEvent.VK_CONTROL);
            robot3.keyPress(KeyEvent.VK_V);
            robot3.keyRelease(KeyEvent.VK_V);
            robot3.keyRelease(KeyEvent.VK_CONTROL);
            robot3.keyPress(KeyEvent.VK_ENTER);
            robot3.keyRelease(KeyEvent.VK_ENTER);

            CU.scrollToView(getDriver(), PanProof);
            IncomeProof.click();
            pause(4);
            income_proof_doc.click();
            
            Robot robot4 = new Robot();
            robot4.delay(1000);
            robot4.keyPress(KeyEvent.VK_CONTROL);
            robot4.keyPress(KeyEvent.VK_V);
            robot4.keyRelease(KeyEvent.VK_V);
            robot4.keyRelease(KeyEvent.VK_CONTROL);
            robot4.keyPress(KeyEvent.VK_ENTER);
            robot4.keyRelease(KeyEvent.VK_ENTER);

            CU.scrollToView(getDriver(), PIProof_Upload);
            PIProof_Upload.click();
            pause(1);
            PIProof_Upload.click();
            CU.scrollToView(getDriver(), PIProof_Upload);
            PIProof_Upload.click();
            pause(1);
            CU.scrollToView(getDriver(), PIProof_Upload);
            PIProof_Upload.click();
            pause(1);
            PIProof_Upload.click();
            pause(1);
            System.out.println("Wait");
            pause(1);
            
            SubmitApplication.click();
            pause(1);
            ProceedAhead.click();
            pause(1);
            
            String appNumber = getDriver().findElement(By.xpath("//span[contains(@class, 'text-dark') and starts-with(normalize-space(text()), 'Application No.')]")).getText().trim();
            String appNumberValue = appNumber.replaceAll("Application No\\.\\s*", "").trim();
            args.put("sAppNo", appNumberValue);
            
            pause(2);
            
        } catch (Exception e) {
            handlePageError(e, args, "UploadDoc");
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
