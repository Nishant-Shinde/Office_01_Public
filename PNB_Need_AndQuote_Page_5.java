

package com.EPro.web.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;
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

public class PNB_Need_AndQuote_Page_5 extends AbstractPage {

    public PNB_Need_AndQuote_Page_5(WebDriver driver) {
        super(driver);
    }

    // --- ALL YOUR ORIGINAL @FindBy ELEMENTS ---
    @FindBy(xpath = "//label[normalize-space(text())='Please select current Life Stage']")
    private ExtendedWebElement Life_StageText;

    @FindBy(xpath = "//*[text()='Single']")
    private ExtendedWebElement single;

    @FindBy(xpath = "//*[text()='Married']")
    private ExtendedWebElement married;

    @FindBy(xpath = "//*[text()='Young Parent']")
    private ExtendedWebElement young_parent;

    @FindBy(xpath = "//*[text()='Older Parent']")
    private ExtendedWebElement olderparent;

    @FindBy(xpath = "//*[text()='Nearing Retirement']")
    private ExtendedWebElement Nearing_Retirement;

    @FindBy(xpath = "//label[normalize-space(text())=\"Customer's Financial Goals\"]")
    private ExtendedWebElement Financials_Text;
    
    @FindBy(xpath = "//label[@for='needs']")
    private ExtendedWebElement Financials_Text_2;
    
    @FindBy(xpath = "//*[text()=' Life Protection ']")
    private ExtendedWebElement Life_Protection_BTN;

    @FindBy(xpath = "//*[text()=' Health Protection ']")
    private ExtendedWebElement Health_protection_BTN;

    @FindBy(xpath = "//*[text()=' Create Corpus For Retirement ']")
    private ExtendedWebElement Retirement_BTN;

    @FindBy(xpath = "//*[text()=' Income From My Corpus ']")
    private ExtendedWebElement Income_BTN;

    @FindBy(xpath = "//*[text()=' Child Education ']")
    private ExtendedWebElement Child_Edu_BTN;

    @FindBy(xpath = "//*[text()=' Create Corpus ']")
    private ExtendedWebElement Create_Corpus_BTN;

    @FindBy(xpath = "//*[text()=' Passive Income ']")
    private ExtendedWebElement Passive_Income_BTN;

    @FindBy(xpath = "//label[normalize-space()='Please select Risk Profile']")
    private ExtendedWebElement Risk_ProfileText;

    @FindBy(xpath = "//*[text()='Conservative']")
    private ExtendedWebElement Conservative;

    @FindBy(xpath = "//*[text()='Balanced']")
    private ExtendedWebElement Balance;

    @FindBy(xpath = "//*[text()='Aggressive']")
    private ExtendedWebElement Aggressive;

    @FindBy(xpath = "//*[text()=' Save & Proceed ']")
    private ExtendedWebElement SaveProceed_BTN;

    @FindBy(xpath = "//*[@placeholder='Search plans']")
    private ExtendedWebElement Search_Plan;

    @FindBy(xpath = "//*[text()=' Add to cart ']")
    private ExtendedWebElement Addtocart;

    @FindBy(xpath = "//*[@class='cursor-pointer mb-2 metplanfinalise ng-star-inserted']")
    private ExtendedWebElement Plan_Selection;

    @FindBy(xpath = "//*[text()=' Shortlisted Plans (Select one to proceed) ']")
    private ExtendedWebElement Shortlisted_PlanText;

    @FindBy(xpath = "//*[text()=' Save & Proceed ']")
    private ExtendedWebElement PlanSelection_SaveBTN;

    @FindBy(xpath = "//*[text()='MSIB Plan']")
    private ExtendedWebElement scroll;

    @FindBy(xpath = "//div[@role='status' and contains(@class, 'spinner-border')]")
    private ExtendedWebElement Loader;

    @FindBy(xpath = "//*[text()=' Shortlisted Plans (Select one to proceed) ']")
    private ExtendedWebElement scroll1;
    
    @FindBy(xpath = "//label[normalize-space(text())='No']")
    private ExtendedWebElement No;
    
  //button[normalize-space(text())='Continue without Backdate']
    
    @FindBy(xpath = "//button[normalize-space(text())='Continue without Backdate']")
    private ExtendedWebElement ContinueWithoutBackDate;
  

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    CommonUtilities CU = new CommonUtilities();

    // --- Main Method ---
    public void Life_Risk(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        
        try {
            Life_stage(args);
            Financial_Goals(args);
            Risk_Profile(args);
            Plan_Selection(args);
            
            actualResult += "Plan Selection Process completed Successfully | ";
            args.put("ActualResult", actualResult);
            
        } catch (Exception e) {
            handlePageError(e, args, "Life_Risk");
        }
    }

    // --- Life Stage Method ---
    public void Life_stage(HashMap args) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            // IMPROVED: Better loader wait
            try {
                wait.until(ExpectedConditions.invisibilityOf(Loader.getElement()));
            } catch (Exception e) {
                // If loader not found, continue - it might not be present
            }
            ImprovedWaits.waitForPageLoad(getDriver());
            
            try {
                if (((String) args.get("Life_Stage")).equalsIgnoreCase("Single")) { // FIXED: Type casting
                    // Do nothing, Single is default
                }
                
                if (((String) args.get("Life_Stage")).equalsIgnoreCase("Married")) { // FIXED: Type casting
                    married.click();
                }
                
                if (((String) args.get("Life_Stage")).equalsIgnoreCase("Young_Parent")) { // FIXED: Type casting
                    young_parent.click();
                }
                
                if (((String) args.get("Life_Stage")).equalsIgnoreCase("Old_Parent")) { // FIXED: Type casting
                    olderparent.click();
                }
                
                if (((String) args.get("Life_Stage")).equalsIgnoreCase("Nearing_Retirement")) { // FIXED: Type casting
                    Nearing_Retirement.click();
                }
                
            } catch (Exception e) {
                System.out.println("##########Error Message Is "+e);
                handlePageError(e, args, "Life_Stage_Selection");
            }
            
            try {
            	pause(2);
            	CU.scrollToView(getDriver(), Financials_Text);
            	CU.scrollToView(getDriver(), Financials_Text);
            	CU.scrollToView(getDriver(), Financials_Text);
            	CU.scrollToView(getDriver(), Financials_Text);
            	CU.scrollToView(getDriver(), Financials_Text);
			} catch (Exception e) {
				try {
					CU.scrollToView(getDriver(), Financials_Text_2);
				} catch (Exception e2) {
					System.out.println("Both xpath are not working");
					handlePageError(e2, args, "Life_stage");
				}				
			}
            
        } catch (Exception e) {
            handlePageError(e, args, "Life_stage");
        }
    }

    // --- Financial Goals Method ---
    public void Financial_Goals(HashMap args) {
        try {
            
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            
            try { 
                wait.until(ExpectedConditions.visibilityOf(Financials_Text.getElement())); 
            } catch (Exception e) { 
               try {
            	   wait.until(ExpectedConditions.visibilityOf(Financials_Text_2.getElement())); 
			} catch (Exception e2) {
				handlePageError(e, args, "Financials_Text"); 
			}
               
            }
            
            try {
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Life_Protection")) { // FIXED: Type casting
                    // Do nothing, Life Protection is default
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Health_Protection")) { // FIXED: Type casting
                    Health_protection_BTN.click();
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Create_corpus_Retirement")) { // FIXED: Type casting
                    Retirement_BTN.click();
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Income")) { // FIXED: Type casting
                    Income_BTN.click();
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Child_Education")) { // FIXED: Type casting
                    Child_Edu_BTN.click();
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Create_Corpus")) { // FIXED: Type casting
                    Create_Corpus_BTN.click();
                }
                
                if (((String) args.get("Financial_Goals")).equalsIgnoreCase("Passive_Income")) { // FIXED: Type casting
                    Passive_Income_BTN.click();
                }
                
            } catch (Exception e) {
                System.out.println("##########Error Message Is "+e);
                handlePageError(e, args, "Financial_Goals_Selection");
            }
            
            CU.scrollToView(getDriver(), Life_Protection_BTN);
            System.out.println("Check Point 2 | Page 5");
            
        } catch (Exception e) {
            handlePageError(e, args, "Financial_Goals");
        }
    }

    // --- Risk Profile Method ---
    public void Risk_Profile(HashMap args) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            
            try {
                pause(2);
            } catch (Exception e) { 
                handlePageError(e, args, "Risk_ProfileText"); 
            }
            
            try {
                pause(1);
                if (((String) args.get("Risk_Profile")).equalsIgnoreCase("Conservative")) { // FIXED: Type casting
                    Conservative.click();
                }
                
                if (((String) args.get("Risk_Profile")).equalsIgnoreCase("Balanced")) { // FIXED: Type casting
                    Balance.click();
                }
                
                if (((String) args.get("Risk_Profile")).equalsIgnoreCase("Aggressive")) { // FIXED: Type casting
                    Aggressive.click();
                }
                
            } catch (Exception e) {
                System.out.println("##########Error Message Is "+e);
                handlePageError(e, args, "Risk_Profile_Selection");
            }
            
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Risk_Profile");
            
            // IMPROVED: Smart wait before clicking
            ImprovedWaits.smartWait(getDriver(), SaveProceed_BTN, 10);
            SaveProceed_BTN.click();
            pause(5);
            System.out.println("Check Point 3 | Page 5");
            
        } catch (Exception e) {
            handlePageError(e, args, "Risk_Profile");
        }
    }

    // --- Plan Selection Method ---
    public void Plan_Selection(HashMap args) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
            
            try { 
                wait.until(ExpectedConditions.visibilityOf(Search_Plan.getElement())); 
            } catch (Exception e) { 
                handlePageError(e, args, "Search_Plan"); 
            }
            
            Search_Plan.type((String) args.get("ProductName")); // FIXED: Type casting
            pause(1);
            
            try { 
                Addtocart.click(); 
            } catch (Exception e) { 
                handlePageError(e, args, "Addtocart"); 
            }
            
            CU.scrollToView(getDriver(), PlanSelection_SaveBTN);
            pause(1);
            
            try { 
                Plan_Selection.click(); 
            } catch (Exception e) { 
                handlePageError(e, args, "Plan_Selection"); 
            }
            
            pause(1);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Plan Selection");
            CU.scrollToView(getDriver(), PlanSelection_SaveBTN);
            
            // IMPROVED: Smart wait before final click
            ImprovedWaits.smartWait(getDriver(), PlanSelection_SaveBTN, 10);
            try { 
                PlanSelection_SaveBTN.click(); 
                pause(1);
                //ContinueWithoutBackDate.click();
            } catch (Exception e) { 
                handlePageError(e, args, "PlanSelection_SaveBTN"); 
            }
            
        } catch (Exception e) {
            System.out.println("##########Error Message Is "+e);
            handlePageError(e, args, "Plan_Selection");
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

    // --- Utility Methods ---
    private void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
