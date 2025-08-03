package com.EPro.web.gui.pages;
 
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
 
public class PNB_Medical_Page9 extends AbstractPage {
 
    public PNB_Medical_Page9(WebDriver driver) {
        super(driver);
    } // FIXED: Added missing closing brace
 
    // FIXED: Moved ALL @FindBy elements outside constructor - keeping all your original elements
    @FindBy(xpath = "//*[@id='customerHeightSelect']")
    private ExtendedWebElement CustomerHeight;
 
    @FindBy(xpath = "(//*[text()='%s'])[last()]")
    private ExtendedWebElement CustomerHeight_Values;
 
    @FindBy(xpath = "//*[@placeholder='-weight-']")
    private ExtendedWebElement CustomerWeight;
 
    @FindBy(xpath = "//input[@aria-placeholder=\"-weight-\"]")
    private ExtendedWebElement CustomerWeight_Type;
 
    @FindBy(xpath = "//input[@aria-placeholder=\"customer's height\"]")
    private ExtendedWebElement CustomerHeight_Type;
 
    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@class, 'ng-option')]//span[text()='%s']")
    private ExtendedWebElement CustomerWeight_Values;
 
    @FindBy(xpath = "//ng-dropdown-panel//div[contains(@class, 'ng-dropdown-panel-items') and contains(@class, 'scroll-host')]")
    public ExtendedWebElement dropdownScrollHost;
 
    @FindBy(xpath = "//label[contains(normalize-space(.), 'Has there been weight loss or weight gain')]")
    private ExtendedWebElement CustomerWeight_Increase;
 
    @FindBy(xpath = "//button[contains(normalize-space(.), 'Save & Proceed')]")
    private ExtendedWebElement SaveAndProceed;
 
    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // FIXED: Added missing timeout
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();
 
    // --- Main Method ---
    public void Medical(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", ""); // FIXED: Type casting
        try {
            Questionnaire(args);
            actualResult += "Medical Questionnaire completed successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            actualResult += "Failed in Medical Flow | ";
            actualResult += "*** " + e.getMessage() + " ***";
            args.put("ActualResult", actualResult);
            args.put("sOutput", e.toString());
            CU.takeScreenshot(args, getDriver(), "Error Page");
            if (((String) args.get("Test Case Type")).equalsIgnoreCase("Negative")) { // FIXED: Type casting
                args.put("status", "Pass");
            } else {
                args.put("status", "Fail");
            }
        }
    } // FIXED: Added missing closing brace
 
    // --- Questionnaire Method ---
    public void Questionnaire(HashMap args) {
        try {
            // IMPROVED: Smart wait for page load
            ImprovedWaits.waitForPageLoad(getDriver());
            // Customer Height
            try {
                CustomerHeight.click();
                CustomerHeight_Type.type((String) args.get("CustomerHeight")); // FIXED: Type casting
                CustomerHeight_Type.getElement().sendKeys(Keys.ENTER);
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "CustomerHeight");
            }
 
            // Customer Weight
            try {
                CustomerWeight.click();
                CustomerWeight_Type.type((String) args.get("CustomerWeight")); // FIXED: Type casting
                CustomerWeight_Type.getElement().sendKeys(Keys.ENTER);
                pause(1);
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "CustomerWeight");
            }
 
            // Scroll and screenshot
            try {
                CU.scrollToView(getDriver(), SaveAndProceed);
                pause(1);
                CU.scrollToView(getDriver(), SaveAndProceed);
                CommonUtilities.CaptureScreenshot(args, getDriver(), "MedicalQuestionnaire_1");
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "ScrollAndScreenshot");
            }
 
            // Save and Proceed
            try {
                // IMPROVED: Smart wait before clicking
                ImprovedWaits.smartWait(getDriver(), SaveAndProceed, 10);
                SaveAndProceed.click();
            } catch (Exception e) {
                System.out.println("##########Error Message Is " + e);
                handlePageError(e, args, "SaveAndProceed");
            }
 
        } catch (Exception e) {
            System.out.println("##########Error Message Is " + e);
            System.out.println("Check Above Line For Error");
            handlePageError(e, args, "Questionnaire (outer catch)");
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
 
    // --- Utility Methods ---
    private void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}