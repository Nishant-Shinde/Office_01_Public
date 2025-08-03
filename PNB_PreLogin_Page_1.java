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
 
public class PNB_PreLogin_Page_1 extends AbstractPage {
 
    public PNB_PreLogin_Page_1(WebDriver driver) {
        super(driver);
    }
 
    // --- Element Locators ---
    @FindBy(xpath = "//div[@id='toast-container']//div[contains(@class, 'toast-message') and @role='alert']")
    private ExtendedWebElement errorMessageToast;
 
    @FindBy(xpath = "(//div[@class='input-group']/input)[1]")
    private ExtendedWebElement userid;
 
    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement password;
 
    @FindBy(xpath = "//*[text()=' Continue ']")
    private ExtendedWebElement loginbtn;
 
    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30; // Define timeout constant
    private WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();
 
    // --- Main Method ---
    public void PreLogin(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", "");  // FIXED
        String pageName = this.getClass().getSimpleName();
        try {
            // Step 1: Wait for page to load completely
            ImprovedWaits.waitForPageLoad(getDriver());
            // Step 2: Perform login
            performLogin(args);
            // Step 3: Handle OTP
            handleOTPEntry(args);
            // Step 4: Final validation
            actualResult += "Pre-Login page flow completed successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            handlePageError(e, args, "PreLogin main flow");
        }
    }
 
    // --- Login Method ---
    private void performLogin(HashMap args) {
        try {
            // Wait for login elements to be ready
            ImprovedWaits.smartWait(getDriver(), userid, 10);
            // Validate inputs - FIXED CASTING
            String userIdValue = (String) args.get("User_ID");
            String passwordValue = (String) args.get("Password");
            if (userIdValue == null || userIdValue.trim().isEmpty()) {
                throw new RuntimeException("User ID is empty or null");
            }
            if (passwordValue == null || passwordValue.trim().isEmpty()) {
                throw new RuntimeException("Password is empty or null");
            }
            // Clear and enter credentials
            userid.getElement().clear();
            userid.type(userIdValue);
            password.getElement().clear();
            password.type(passwordValue);
            // Capture screenshot before login
            CommonUtilities.CaptureScreenshot(args, getDriver(), "LoginScreen_BeforeSubmit");
            // Click login button
            ImprovedWaits.smartWait(getDriver(), loginbtn, 5);
            loginbtn.click();
            // Check for error toast immediately after login
            checkForErrorToast(args);
            String actualResult = (String) args.getOrDefault("ActualResult", "");  // FIXED
            actualResult += "Login action initiated successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            handlePageError(e, args, "Login credentials entry");
        }
    }
 
    // --- Error Toast Handling ---
    private void checkForErrorToast(HashMap args) {
        try {
            // Wait briefly for error toast to appear
            new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(errorMessageToast.getElement()));
            String errorMessageText = errorMessageToast.getText();
            String errorMsg = String.format("Login failed - Error toast displayed: '%s'", errorMessageText);
            LOGGER.error(errorMsg);
            // Capture screenshot of error
            CommonUtilities.CaptureScreenshot(args, getDriver(), "LoginError_Toast");
            // Update results - FIXED CASTING
            String actualResult = (String) args.getOrDefault("ActualResult", "");
            actualResult += errorMsg + " | ";
            args.put("ActualResult", actualResult);
            args.put("sOutput", errorMsg);
            args.put("status", "Fail");
            throw new RuntimeException(errorMsg);
        } catch (org.openqa.selenium.TimeoutException e) {
            LOGGER.info("No error toast detected - login appears successful");
        }
    }
 
    // --- OTP Handling ---
    private void handleOTPEntry(HashMap args) {
        try {
            // Wait for OTP page to load
            ImprovedWaits.waitForPageLoad(getDriver());
            pause(2); // Small pause to ensure OTP fields are rendered
            // Get OTP from data - FIXED CASTING
            String otp = (String) args.getOrDefault("OTP", "123456");
            // Validate OTP format
            if (otp == null || otp.trim().isEmpty()) {
                throw new RuntimeException("OTP is empty or null");
            }
            // Remove any spaces or special characters, keep only digits
            otp = otp.replaceAll("[^0-9]", "");
            if (otp.length() != 6) {
                throw new RuntimeException("OTP must be exactly 6 digits. Provided: " + otp);
            }
            // Enter OTP digits
            for (int i = 0; i < otp.length(); i++) {
                By otpInputLocator = By.xpath(String.format("//input[@id='otp-input-%d']", i));
                // Wait for each OTP input field
                wait.until(ExpectedConditions.visibilityOfElementLocated(otpInputLocator));
                ExtendedWebElement input = findExtendedWebElement(otpInputLocator);
                // Clear field and enter digit
                input.getElement().clear();
                input.type(String.valueOf(otp.charAt(i)));
                // Small pause between digits
                pause(0.5);
            }
            // Capture screenshot after OTP entry
            CommonUtilities.CaptureScreenshot(args, getDriver(), "OTP_Entered");
            // Wait for OTP verification
            ImprovedWaits.waitForPageLoad(getDriver());
            LOGGER.info("OTP entered successfully: " + otp);
            String actualResult = (String) args.getOrDefault("ActualResult", "");  // FIXED
            actualResult += "OTP entered successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            handlePageError(e, args, "OTP entry");
        }
    }
 
    // --- Error Handler ---
    private void handlePageError(Exception e, HashMap args, String elementName) {
        String pageName = this.getClass().getSimpleName();
        String errorMsg = String.format("Failed on %s: %s - %s", pageName, elementName, e.getMessage());
        LOGGER.error(errorMsg, e);
        System.err.println(errorMsg);
        // Update results - FIXED CASTING
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
    private WebDriverWait getWait() {
        return wait;
    }
    // Add pause method if not available in AbstractPage
    private void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}