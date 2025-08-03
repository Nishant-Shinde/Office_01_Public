package com.EPro.web.gui.pages;
 
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
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
 
public class PNB_customeronboarding_Page_2 extends AbstractPage {
 
    public PNB_customeronboarding_Page_2(WebDriver driver) {
        super(driver);
    }
 
    // --- Element Locators ---
    @FindBy(xpath = "//*[text()='Welcome to']")
    private ExtendedWebElement WelocometoEproText;
 
    @FindBy(xpath = "//*[text()=' Onboard New Customer ']")
    private ExtendedWebElement OnboardNewCustomer;
 
    @FindBy(xpath = "//span[@class='slider']")
    private ExtendedWebElement checkbox;
 
    @FindBy(xpath = "//*[text()=' Proceed ']")
    private ExtendedWebElement proceedtext;
 
    @FindBy(xpath = "//*[text()=' Proceed ']")
    private ExtendedWebElement proceedbtn;
 
    @FindBy(xpath = "//*[text()='Select Customer Category']")
    private ExtendedWebElement selectcustomercategorytext;
 
    @FindBy(xpath = "(//label[text()=' %s '])[last()]")
    private ExtendedWebElement selectCustomerCategory;
 
    @FindBy(xpath = "//*[text()=' New Customer ']")
    private ExtendedWebElement NewCustomer;
 
    @FindBy(xpath = "//*[text()=' Existing Customer ']")
    private ExtendedWebElement ExistingCustomer;
 
    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // Define timeout constant
    private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();
 
    // --- Main Method ---
    public void CustomerOnboarding(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", "");
        try {
            // Step 1: Click onboard customer
            ClickOnboardCustomer(args);
            // Step 2: Select customer category (if needed)
            if (needsCustomerCategorySelection(args)) {
                SelectCustomercategory(args);
            }
            // Step 3: Final result
            actualResult += "Customer onboarding and Select journey page opened successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            handlePageError(e, args, "CustomerOnboarding main flow");
        }
    }
 
    // --- Click Onboard Customer Method ---
    public void ClickOnboardCustomer(HashMap args) {
        try {
            // Wait for page to load and welcome text to appear
            ImprovedWaits.waitForPageLoad(getDriver());
            // Check if welcome text is present (optional validation)
           
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'spinner-container')]")));
            
            // Scroll to and click onboard new customer
            CU.scrollToView(getDriver(), OnboardNewCustomer);
            pause(1);
            ImprovedWaits.smartWait(getDriver(), OnboardNewCustomer, 10);
            OnboardNewCustomer.click();
 
            // Wait for and click checkbox
            ImprovedWaits.smartWait(getDriver(), checkbox, 10);
            checkbox.click();
            pause(1); // Small pause to ensure checkbox registers
 
            // Wait for proceed button and capture screenshot
            ImprovedWaits.smartWait(getDriver(), proceedtext, 10);
            //CommonUtilities.CaptureScreenshot(args, getDriver(), "CustomerOnboarding_BeforeProceed");
            // Click proceed button
            proceedbtn.click();
            // Wait for next page to load
            ImprovedWaits.waitForPageLoad(getDriver());
            String actualResult = (String) args.getOrDefault("ActualResult", "");
            actualResult += "Customer onboarding initiated successfully | ";
            args.put("ActualResult", actualResult);
 
        } catch (Exception e) {
            System.out.println("Error in ClickOnboardCustomer: " + e.getMessage());
            handlePageError(e, args, "ClickOnboardCustomer flow");
        }
    }
 
    // --- Select Customer Category Method ---
    public void SelectCustomercategory(HashMap args) {
        try {
            // Wait for customer category selection page
            ImprovedWaits.waitForPageLoad(getDriver());
            ImprovedWaits.smartWait(getDriver(), selectcustomercategorytext, 10);
            // Get customer category from data
            String customerCategory = (String) args.get("Customer_category");
            // Validate customer category input
            if (customerCategory == null || customerCategory.trim().isEmpty()) {
                throw new RuntimeException("Customer category is empty or null");
            }
            // Format and click customer category
            selectCustomerCategory.format(customerCategory);
            if (customerCategory.equalsIgnoreCase("New Customer")) {
                CommonUtilities.CaptureScreenshot(args, getDriver(), "NewCustomer_Selected");
                NewCustomer.click();
            } else if (customerCategory.equalsIgnoreCase("Existing Customer")) {
                CommonUtilities.CaptureScreenshot(args, getDriver(), "ExistingCustomer_Selected");
                ExistingCustomer.click();
            } else {
                throw new RuntimeException("Invalid customer category: " + customerCategory);
            }
            // Wait for selection to register
            ImprovedWaits.waitForPageLoad(getDriver());
            String actualResult = (String) args.getOrDefault("ActualResult", "");
            actualResult += "Customer category '" + customerCategory + "' selected successfully | ";
            args.put("ActualResult", actualResult);
 
        } catch (Exception e) {
            System.out.println("Error in SelectCustomercategory: " + e.getMessage());
            handlePageError(e, args, "SelectCustomercategory flow");
        }
    }
 
    // --- Helper Methods ---
    private boolean needsCustomerCategorySelection(HashMap args) {
        String customerCategory = (String) args.get("Customer_category");
        return customerCategory != null && !customerCategory.trim().isEmpty() 
&& !customerCategory.equalsIgnoreCase("NA");
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