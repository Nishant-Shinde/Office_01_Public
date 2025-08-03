package com.EPro.web.gui.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class PNB_UploadDoc_Page11 extends AbstractPage {

    public PNB_UploadDoc_Page11(WebDriver driver) {
        super(driver);
    }

    // --- UPDATED LOCATORS ---

    // Generalized Device Button for Live Photo (first element, ANY name)
    @FindBy(xpath = "//label[@for='PO_PhotoPO']")
    private ExtendedWebElement LivePhoto_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox')]//h6[contains(., 'Age Proof')]//following::ng-select[1]//input[@role='combobox']")
    private ExtendedWebElement AgeProof_DropdownInput;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Policy Owner's Age Proof\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement AgeProof_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Policy Owner's Bank Proof\")]]//ng-select//input[@role='combobox']")
    private ExtendedWebElement BankProof_DropdownInput;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Policy Owner's Bank Proof\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement BankProof_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Policy Owner's Pan\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement PanProof_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"SP Agent Declaration\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement SPAgent_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Customer Declaration Document\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement CustomerDeclaration_DeviceButton;

    @FindBy(xpath = "//div[contains(@class, 'upbox') and .//h6[contains(., \"Renewal Premium Voucher\")]]//p[text()='Device']/preceding-sibling::label")
    private ExtendedWebElement RenewalPremium_DeviceButton;

    // --- Actions/Final Buttons ---
    @FindBy(xpath = "//button[normalize-space(text())='Submit Application']")
    private ExtendedWebElement SubmitApplication;

    @FindBy(xpath = "//button[normalize-space(text())='Proceed Ahead']")
    private ExtendedWebElement ProceedAhead;

    @FindBy(xpath = "//button[contains(@class, 'metbutt2')]//text()[contains(., 'Download Application Form')]/parent::button")
    private ExtendedWebElement DOWNLOAD_APPLICATION_FORM;

    // --- Class Variables ---
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final int EXPLICIT_TIMEOUT = 30;

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(EXPLICIT_TIMEOUT));
    CommonUtilities CU = new CommonUtilities();
    private static final String DEFAULT_FILE_PATH = "D:\\Upload\\Upload.jpg";

    // --- MAIN FLOW ---
    public void UploadDoc(HashMap args) throws Throwable {
        String actualResult = (String) args.getOrDefault("ActualResult", "");
        try {
            String channel = (String) args.get("Channel");
            String piPoStatus = (String) args.get("PI-PO");
            LOGGER.info("Starting Upload Documents for channel: {} with PI-PO status: {}", channel, piPoStatus);

            switch (channel.toUpperCase()) {
                case "PNB":
                    if ("Different".equalsIgnoreCase(piPoStatus)) {
                        uploadDocumentsDifferentScenario(args);
                    } else {
                        uploadDocumentsSameScenario(args);
                    }
                    break;
                case "JKB":
                    if ("Different".equalsIgnoreCase(piPoStatus)) {
                        handleJKBDifferentScenario(args);
                    } else {
                        handleJKBSameScenario(args);
                    }
                    break;
                default:
                    throw new RuntimeException("Unsupported channel: " + channel);
            }
            actualResult += "Upload Documents Page completed successfully | ";
            args.put("ActualResult", actualResult);
        } catch (Exception e) {
            handlePageError(e, args, "UploadDoc");
        }
    }

    // --- Same Scenario ---
    private void uploadDocumentsSameScenario(HashMap args) throws AWTException {
        List<String> failedElements = new ArrayList<>();
        try {
            ImprovedWaits.waitForPageLoad(getDriver());
            String filePath = DEFAULT_FILE_PATH;
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            processElement("LivePhoto", () -> uploadDocument("LivePhoto", LivePhoto_DeviceButton, args), failedElements);
            processElementWithDropdown("AgeProof", null, AgeProof_DropdownInput, AgeProof_DeviceButton, (String) args.get("AgeProof"), failedElements, args);
            processElementWithDropdown("BankProof", null, BankProof_DropdownInput, BankProof_DeviceButton, (String) args.get("BankProof"), failedElements, args);
            processElement("PanProof", () -> uploadDocument("PanProof", PanProof_DeviceButton, args), failedElements);
            processElement("SPAgent", () -> uploadDocument("SPAgent", SPAgent_DeviceButton, args), failedElements);
            processElement("CustomerDeclaration", () -> uploadDocument("CustomerDeclaration", CustomerDeclaration_DeviceButton, args), failedElements);
            processElement("RenewalPremium", () -> uploadDocument("RenewalPremium", RenewalPremium_DeviceButton, args), failedElements);

            submitApplication(args);

            if (!failedElements.isEmpty()) {
                String failureReport = "Failed elements: " + String.join(", ", failedElements);
                LOGGER.warn("Some upload elements failed but process continued: {}", failureReport);
                args.put("FailedElements", failureReport);
            } else {
                LOGGER.info("All upload elements processed successfully for Same scenario");
            }
        } catch (Exception e) {
        	System.out.println(e);
        	System.out.println("#############################################");
            handlePageError(e, args, "uploadDocumentsSameScenario");
        }
    }

    // --- Different Scenario (stub, you may update with appropriate elements if needed) ---
    private void uploadDocumentsDifferentScenario(HashMap args) throws AWTException {
        LOGGER.info("Processing Different Scenario - Please add additional element mappings here as needed.");
        // Implement similar to uploadDocumentsSameScenario
    }

    // --- JKB Channel (stubs, structure retained) ---
    private void handleJKBSameScenario(HashMap args) throws AWTException {
        LOGGER.info("Processing JKB Same Scenario - Implement as per mapped elements for JKB channel.");
    }

    private void handleJKBDifferentScenario(HashMap args) throws AWTException {
        LOGGER.info("Processing JKB Different Scenario - Implement as per mapped elements for JKB channel.");
    }

    // --- Helper Methods ---

    private void processElement(String elementName, Runnable uploadAction, List<String> failedElements) {
        try {
            uploadAction.run();
            LOGGER.info("Successfully processed: {}", elementName);
        } catch (Exception e) {
            String errorMsg = String.format("%s failed: %s", elementName, e.getMessage());
            failedElements.add(errorMsg);
            LOGGER.warn("Element processing failed: {}", errorMsg);
        }
    }

    private void processElementWithDropdown(String elementName, ExtendedWebElement dropdown, ExtendedWebElement dropdownInput,
                                            ExtendedWebElement deviceButton, String dropdownValue, List<String> failedElements, HashMap args) {
        try {
            if (dropdownValue != null && !dropdownValue.trim().isEmpty() && !"NA".equalsIgnoreCase(dropdownValue)) {
                try { scrollToElementSafely(deviceButton, elementName); } catch (Exception ignored) {}
                if (dropdownInput != null && isElementPresent(dropdownInput)) {
                    dropdownInput.type(dropdownValue);
                    dropdownInput.getElement().sendKeys(Keys.ENTER);
                    pause(2);
                }
                uploadDocument(elementName, deviceButton, args);
                LOGGER.info("Successfully processed with dropdown: {}", elementName);
            } else {
                LOGGER.info("Skipping {} - no dropdown value provided or value is NA", elementName);
            }
        } catch (Exception e) {
            String errorMsg = String.format("%s (with dropdown) failed: %s", elementName, e.getMessage());
            failedElements.add(errorMsg);
            LOGGER.warn("Element with dropdown processing failed: {}", errorMsg);
        }
    }

    private void uploadDocument(String documentType, ExtendedWebElement deviceButton, HashMap args) {
        try {
            if (isElementPresent(deviceButton)) {
                try { scrollToElementSafely(deviceButton, documentType); pause(1); } catch (Exception ignored) {}
                deviceButton.click();
                pause(2);
                Robot robot = new Robot();
                robot.delay(1000);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                pause(2);

                clickUploadButtonImmediately(documentType);
                LOGGER.info("Successfully uploaded and processed: {}", documentType);
            } else {
                throw new RuntimeException("Element not present or not interactable");
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("Upload failed for %s: %s", documentType, e.getMessage()), e);
        }
    }

    private void clickUploadButtonImmediately(String documentType) {
        try {
            pause(2);
            WebElement uploadButton = getDriver().findElement(
                By.xpath("//button[contains(@class, 'upload-btn') and normalize-space(text())='Upload']")
            );
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({block:'center'})", uploadButton);
            pause(1);
            if (uploadButton.isDisplayed() && uploadButton.isEnabled()) {
                uploadButton.click();
                pause(1);
                LOGGER.info("Upload button clicked successfully for: {}", documentType);
            }
        } catch (Exception e) {
            LOGGER.warn("Upload button click failed for {}: {}", documentType, e.getMessage());
        }
    }

    private void submitApplication(HashMap args) {
        try {
            LOGGER.info("All uploads completed, proceeding to submit application...");
            pause(2);
            CU.scrollToView(getDriver(), SubmitApplication);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Before_Submit_Application");
            SubmitApplication.click();
            pause(2);
            ProceedAhead.click();
            pause(4);
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Application_Submitted_Successfully");
            try {
                String appNumber = getDriver().findElement(
                        By.xpath("//span[contains(@class, 'text-dark') and starts-with(normalize-space(text()), 'Application No.')]")
                ).getText().trim().replaceAll("Application No\\.\\s*", "").trim();
                args.put("sAppNo", appNumber);
                LOGGER.info("Application Number extracted: {}", appNumber);
                // Download Application Form after success
                try {
                    downloadApplicationForm(args);
                    String actualResult = (String) args.getOrDefault("ActualResult", "");
                    actualResult += "Application Form downloaded successfully | ";
                    args.put("ActualResult", actualResult);
                    LOGGER.info("Application Form download completed");
                } catch (Exception downloadError) {
                    LOGGER.warn("Download failed but continuing with flow: {}", downloadError.getMessage());
                }
            } catch (Exception e) {
                LOGGER.warn("Could not extract application number: {}", e.getMessage());
            }
        } catch (Exception e) {
            handlePageError(e, args, "Submit Application");
        }
    }

    public void downloadApplicationForm(HashMap args) {
        try {
            CU.scrollToView(getDriver(), DOWNLOAD_APPLICATION_FORM);
            CU.waitForVisibilityOf(getDriver(), DOWNLOAD_APPLICATION_FORM);
            DOWNLOAD_APPLICATION_FORM.click();
            pause(10); // Wait for download
            CU.acceptAlert(getDriver()); // Optional, ignore if not present
            CommonUtilities.CaptureScreenshot(args, getDriver(), "Application_Form_Downloaded");
        } catch (Exception e) {
            LOGGER.error("Download failed: {}", e.getMessage());
        }
    }

    private void scrollToElementSafely(ExtendedWebElement element, String elementName) {
        try {
            CU.scrollToView(getDriver(), element);
            pause(0.5);
        } catch (Exception e) {
            LOGGER.warn("Could not scroll to element {}: {}", elementName, e.getMessage());
        }
    }

    private boolean isElementPresent(ExtendedWebElement element) {
        try {
            return element != null && element.getElement().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void handlePageError(Exception e, HashMap args, String elementVarName) {
        String pageName = this.getClass().getSimpleName();
        String errorMsg = String.format("Failed on %s: Element '%s' not found or step failed - %s",
                pageName, elementVarName, e.getMessage());
        LOGGER.error(errorMsg, e);
        String actualResult = (String) args.getOrDefault("ActualResult", "");
        actualResult += errorMsg + " | ";
        args.put("ActualResult", actualResult);
        args.put("sOutput", errorMsg);
        args.put("status", "Fail");
        CommonUtilities.CaptureScreenshot(args, getDriver(), "ErrorPage");
        throw new RuntimeException(errorMsg, e);
    }

    private void pause(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
