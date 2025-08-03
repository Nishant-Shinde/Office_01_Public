//Main OG

package com.EPro.test.execution;

import org.openqa.selenium.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import com.EPro.web.gui.pages.PNB_Agent_And_Payment_Page10;
import com.EPro.web.gui.pages.PNB_BasePlan_Page_6;
import com.EPro.web.gui.pages.PNB_Know_Your_Customer_Page_3;
import com.EPro.web.gui.pages.PNB_LifeStylePage_Page8;
import com.EPro.web.gui.pages.PNB_Medical_Page9;
import com.EPro.web.gui.pages.PNB_Need_AndQuote_Page_5;
import com.EPro.web.gui.pages.PNB_NomineePage_Page7;
import com.EPro.web.gui.pages.PNB_Personal_Information_Page_4;
import com.EPro.web.gui.pages.PNB_PiPODifferent_KnowYourCustomer;
import com.EPro.web.gui.pages.PNB_PreLogin_Page_1;
import com.EPro.web.gui.pages.PNB_UploadDoc_Page11;
import com.EPro.web.gui.pages.PNB_customeronboarding_Page_2;
import com.web.utils.CommonUtilities;
import com.web.utils.UIReportUtils;
import com.web.utils.ImprovedWaits;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import com.zebrunner.carina.utils.R;

public class PNB_EPro_Metlife_Flow implements IAbstractTest, IAbstractDataProvider {

    // --- Constants ---
    private static final Logger LOGGER = LoggerFactory.getLogger(PNB_EPro_Metlife_Flow.class);
    private static final int MAX_RETRY_ATTEMPTS = 2;
    private static final int PAGE_TIMEOUT_SECONDS = 60;
    
    // --- Utility Classes ---
    CommonUtilities CU = new CommonUtilities();

    // --- Page Flow Configuration ---
    private static final List<String> MANDATORY_PAGES = Arrays.asList(
        "PreLogin", "CustomerOnboarding", "KnowYourCustomer", "PersonalInformation"
    );

    private static final List<String> OPTIONAL_PAGES = Arrays.asList(
        "NeedAndQuote", "BasePlan", "Nominee", "Lifestyle", "Medical", "AgentPayment", "UploadDoc"
    );

    @MethodOwner(owner = "QK")
    @Test(testName = "TC_01", dataProvider = "DataProvider", groups = { "TC_01" }, priority = 2)
    @XlsDataSourceParameters(path = "data_source/Gem_Data_2.xlsx", sheet = "Container", dsUid = "TestCaseID", executeColumn = "Executor", executeValue = "Yes")
    public void TestRunner(HashMap args) throws Throwable {
        
        // Initialize test execution
        initializeTestExecution(args);
        
        WebDriver driver = null;
        String overallActualResult = (String) args.getOrDefault("ActualResult", "");
        
        try {
            // Setup environment
            setupTestEnvironment(args);
            
            // Initialize driver
            driver = initializeWebDriver(args);
            
            // Execute page flow
            executePageFlow(args, driver);
            
            // Finalize test execution
            finalizeTestExecution(args, overallActualResult);
            
        } catch (Throwable e) {
            handleTestExecutionError(e, args, overallActualResult);
        } finally {
            // Cleanup resources
            cleanupResources(driver, args);
        }
    }

    // --- Test Initialization ---
    private void initializeTestExecution(HashMap args) throws Throwable {
        try {
            LOGGER.info("=== Starting Test Execution for TestCaseID: {} ===", args.get("TestCaseID"));
            
            // Setup folders and reporting - FIXED: Wrapped in try-catch
            try {
                CU.FolderCreate(args);
                CU.TCFolderCreate(args);
                UIReportUtils.CreateWorkbook(args);
            } catch (Throwable e) {
                LOGGER.error("Error in folder/workbook creation: {}", e.getMessage(), e);
                throw new RuntimeException("Failed to initialize test environment", e);
            }
            
            // Initialize execution parameters
            args.put("sOutput", "");
            args.put("retryCount", "0");
            args.put("pagesExecuted", "");
            args.put("pagesFailed", "");
            
            // Log execution details
            LOGGER.info("Test Case Folder Path: {}", args.get("tcFolderPath"));
            LOGGER.info("Test Case Excel Report Path: {}", args.get("excelReportFilePath"));
            
        } catch (Throwable e) {
            LOGGER.error("Error during test initialization: {}", e.getMessage(), e);
            throw new RuntimeException("Test initialization failed", e);
        }
    }

    // --- Test Environment Setup ---
    private void setupTestEnvironment(HashMap args) throws Throwable {
        try {
            String downloadPath = (String) args.get("tcFolderPath");
            args.put("ExecelFilePath", args.get("excelReportFilePath"));
            
            LOGGER.info("Download path configured: {}", downloadPath);
            
        } catch (Exception e) {
            LOGGER.error("Error setting up test environment: {}", e.getMessage(), e);
            throw new RuntimeException("Environment setup failed", e);
        }
    }

    // --- WebDriver Initialization ---
    private WebDriver initializeWebDriver(HashMap args) throws Throwable {
        try {
            String downloadPath = (String) args.get("tcFolderPath");
            
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--test-type");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("--window-size=500,500");
            
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("credentials_enable_service", false);
            prefs.put("download.default_directory", downloadPath);
            prefs.put("download.prompt_for_download", false);
            prefs.put("plugins.always_open_pdf_externally", true);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            
            chromeOptions.setExperimentalOption("prefs", prefs);
            
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            
            WebDriver driver = getDriver("chrome", capabilities);
            driver.manage().window().setSize(new Dimension(500, 715));
            
            LOGGER.info("WebDriver initialized successfully");
            return driver;
            
        } catch (Exception e) {
            LOGGER.error("Error initializing WebDriver: {}", e.getMessage(), e);
            throw new RuntimeException("WebDriver initialization failed", e);
        }
    }

    // --- Main Page Flow Execution ---
    private void executePageFlow(HashMap args, WebDriver driver) throws Throwable {
        try {
            // Navigate to application
            driver.get(R.CONFIG.get("url"));
            ImprovedWaits.waitForPageLoad(driver);
            
            // Execute mandatory pages
            executeMandatoryPages(args, driver);
            
            // Execute optional pages (if mandatory pages succeeded)
            if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
                executeOptionalPages(args, driver);
            }
            
        } catch (Throwable e) {
            LOGGER.error("Error in page flow execution: {}", e.getMessage(), e);
            throw new RuntimeException("Page flow execution failed", e);
        }
    }

    // --- Mandatory Pages Execution ---
    private void executeMandatoryPages(HashMap args, WebDriver driver) throws Throwable {
        // Page 1: Pre-Login
        executePageWithRetry("PreLogin", () -> {
            try {
                PNB_PreLogin_Page_1 preLogin = new PNB_PreLogin_Page_1(driver);
                preLogin.PreLogin(args);
            } catch (Throwable e) {
                throw new RuntimeException("PreLogin page failed", e);
            }
        }, args);

        
        
        // Page 2: Customer Onboarding
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("CustomerOnboarding", () -> {
                try {
                    PNB_customeronboarding_Page_2 onboarding = new PNB_customeronboarding_Page_2(driver);
                    onboarding.CustomerOnboarding(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Customer onboarding page failed", e);
                }
            }, args);
        }

        // Page 3: Know Your Customer (with PI-PO logic)
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executeKnowYourCustomerPage(args, driver);
        }
        	
        // Page 4: Personal Information (commented for different) // Below commented code is old
//        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
//            executePageWithRetry("PersonalInformation", () -> {
//                try {
//                    PNB_Personal_Information_Page_4 personalInfo = new PNB_Personal_Information_Page_4(driver);
//                    personalInfo.CustomerOnboarding(args);
//                } catch (Throwable e) {
//                    throw new RuntimeException("Personal information page failed", e);
//                }
//            }, args);
//        }
        
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            String piPo = (String) args.get("PI-PO");
            if (!"Different".equalsIgnoreCase(piPo)) {
                executePageWithRetry("PersonalInformation", () -> {
                    try {
                        PNB_Personal_Information_Page_4 personalInfo = new PNB_Personal_Information_Page_4(driver);
                        personalInfo.CustomerOnboarding(args);
                    } catch (Throwable e) {
                        throw new RuntimeException("Personal information page failed", e);
                    }
                }, args);
            }
        }
        
        
    }

    // --- Optional Pages Execution ---
    private void executeOptionalPages(HashMap args, WebDriver driver) throws Throwable {
        // Page 5: Need and Quote
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("NeedAndQuote", () -> {
                try {
                    PNB_Need_AndQuote_Page_5 quotePage = new PNB_Need_AndQuote_Page_5(driver);
                    quotePage.Life_Risk(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Need and quote page failed", e);
                }
            }, args);
        }

        // Page 6: Base Plan
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("BasePlan", () -> {
                try {
                    PNB_BasePlan_Page_6 basePlanPage = new PNB_BasePlan_Page_6(driver);
                    basePlanPage.Base_Plan(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Base plan page failed", e);
                }
            }, args);
        }
//
//        // Page 7: Nominee temporarily commented for different
//        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
//            executePageWithRetry("Nominee", () -> {
//                try {
//                    PNB_NomineePage_Page7 nomineePage = new PNB_NomineePage_Page7(driver);
//                    nomineePage.Nominee_Page(args);
//                } catch (Throwable e) {
//                    throw new RuntimeException("Nominee page failed", e);
//                }
//            }, args);
//        }
        
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            String piPo = (String) args.get("PI-PO");
            if (!"Different".equalsIgnoreCase(piPo)) {
                executePageWithRetry("Nominee", () -> {
                    try {
                        PNB_NomineePage_Page7 nomineePage = new PNB_NomineePage_Page7(driver);
                        nomineePage.Nominee_Page(args);
                    } catch (Throwable e) {
                        throw new RuntimeException("Nominee page failed", e);
                    }
                }, args);
            }
        }
        
//
//        // Page 8: Lifestyle
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("Lifestyle", () -> {
                try {
                    PNB_LifeStylePage_Page8 lifestylePage = new PNB_LifeStylePage_Page8(driver);
                    lifestylePage.LifeStyle_Page(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Lifestyle page failed", e);
                }
            }, args);
        }
//
        // Page 9: Medical
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("Medical", () -> {
                try {
                    PNB_Medical_Page9 medical = new PNB_Medical_Page9(driver);
                    medical.Questionnaire(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Medical page failed", e);
                }
            }, args);
        }
//
        // Page 10: Agent and Payment
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("AgentPayment", () -> {
                try {
                    PNB_Agent_And_Payment_Page10 agentPayment = new PNB_Agent_And_Payment_Page10(driver);
                    agentPayment.Agent(args);
                    agentPayment.PaymentInfo(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Agent payment page failed", e);
                }
            }, args);
        }

//        // Page 11: Upload Documents
        if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
            executePageWithRetry("UploadDoc", () -> {
                try {
                    PNB_UploadDoc_Page11 uploadDoc = new PNB_UploadDoc_Page11(driver);
                    uploadDoc.UploadDoc(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Upload document page failed", e);
                }
            }, args);
        }
    }

    // --- Know Your Customer Page with PI-PO Logic ---
    private void executeKnowYourCustomerPage(HashMap args, WebDriver driver) throws Throwable {
        String piPo = (String) args.get("PI-PO");
        
        if ("Different".equalsIgnoreCase(piPo)) {
            executePageWithRetry("PiPoDifferentKnowYourCustomer", () -> {
                try {
                    PNB_PiPODifferent_KnowYourCustomer obj = new PNB_PiPODifferent_KnowYourCustomer(driver);
                    obj.PNB_pipoDifferent_KnowYourCustomer(args);
                } catch (Throwable e) {
                    throw new RuntimeException("PI-PO different know your customer page failed", e);
                }
            }, args);
        } else {
            executePageWithRetry("KnowYourCustomer", () -> {
                try {
                    PNB_Know_Your_Customer_Page_3 knowCustomer = new PNB_Know_Your_Customer_Page_3(driver);
                    knowCustomer.Knowyourcustomer(args);
                } catch (Throwable e) {
                    throw new RuntimeException("Know your customer page failed", e);
                }
            }, args);
        }
    }

    // --- Page Execution with Retry Logic ---
    private void executePageWithRetry(String pageName, Runnable pageExecution, HashMap args) throws Throwable {
        int retryCount = 0;
        boolean pageSuccess = false;
        
        while (retryCount <= MAX_RETRY_ATTEMPTS && !pageSuccess) {
            try {
                LOGGER.info("Executing page: {} (Attempt: {})", pageName, retryCount + 1);
                
                // Execute the page
                pageExecution.run();
                
                // Check if page execution was successful
                if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
                    pageSuccess = true;
                    String pagesExecuted = (String) args.getOrDefault("pagesExecuted", "");
                    pagesExecuted += pageName + " | ";
                    args.put("pagesExecuted", pagesExecuted);
                    
                    LOGGER.info("Page {} executed successfully", pageName);
                } else {
                    throw new RuntimeException("Page execution failed with status: Fail");
                }
                
            } catch (Exception e) {
                retryCount++;
                LOGGER.warn("Page {} failed on attempt {}: {}", pageName, retryCount, e.getMessage());
                
                if (retryCount <= MAX_RETRY_ATTEMPTS) {
                    // Wait before retry
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                    }
                    
                    // Reset status for retry
                    args.put("status", "");
                    
                    // Take screenshot before retry
                    try {
                        CommonUtilities.CaptureScreenshot(args, getDriver(), pageName + "_Retry_" + retryCount);
                    } catch (Exception screenshotError) {
                        LOGGER.warn("Failed to capture retry screenshot: {}", screenshotError.getMessage());
                    }
                    
                } else {
                    // Max retries reached, mark as failed
                    String pagesFailed = (String) args.getOrDefault("pagesFailed", "");
                    pagesFailed += pageName + " | ";
                    args.put("pagesFailed", pagesFailed);
                    
                    LOGGER.error("Page {} failed after {} attempts", pageName, MAX_RETRY_ATTEMPTS + 1);
                    
                    // Handle mandatory vs optional page failures
                    if (MANDATORY_PAGES.contains(pageName)) {
                        // Mandatory page failed - stop execution
                        args.put("status", "Fail");
                        String actualResult = (String) args.getOrDefault("ActualResult", "");
                        actualResult += String.format("MANDATORY PAGE FAILED: %s | ", pageName);
                        args.put("ActualResult", actualResult);
                        throw new RuntimeException("Mandatory page failed: " + pageName);
                    } else {
                        // Optional page failed - continue with warning
                        LOGGER.warn("Optional page {} failed - continuing with next page", pageName);
                        String actualResult = (String) args.getOrDefault("ActualResult", "");
                        actualResult += String.format("Optional page %s failed but continued | ", pageName);
                        args.put("ActualResult", actualResult);
                    }
                }
            }
        }
    }

    // --- Finalize Test Execution ---
    private void finalizeTestExecution(HashMap args, String overallActualResult) throws Throwable {
        try {
            // Set final status
            if (!"Fail".equalsIgnoreCase((String) args.get("status"))) {
                args.put("status", "Pass");
                overallActualResult = (String) args.getOrDefault("ActualResult", "");
                if (!overallActualResult.contains("Entire flow completed successfully")) {
                    overallActualResult += " | Entire flow completed successfully.";
                    args.put("ActualResult", overallActualResult);
                }
            }
            
            // Log execution summary
            LOGGER.info("=== Test Execution Summary ===");
            LOGGER.info("TestCaseID: {}", args.get("TestCaseID"));
            LOGGER.info("Final Status: {}", args.get("status"));
            LOGGER.info("Pages Executed: {}", args.getOrDefault("pagesExecuted", "None"));
            LOGGER.info("Pages Failed: {}", args.getOrDefault("pagesFailed", "None"));
            
            // Write final report - FIXED: Wrapped in try-catch
            try {
                UIReportUtils.WriteToExcel(args);
            } catch (Throwable e) {
                LOGGER.error("Error writing final report: {}", e.getMessage(), e);
                throw new RuntimeException("Failed to write final report", e);
            }
            
        } catch (Throwable e) {
            LOGGER.error("Error finalizing test execution: {}", e.getMessage(), e);
            throw e;
        }
    }

    // --- Error Handling ---
    private void handleTestExecutionError(Throwable e, HashMap args, String overallActualResult) throws Throwable {
        try {
            // Enhanced error handling
            String pageName = extractPageNameFromException(e);
            String errorMsg = e.getMessage();
            if (errorMsg == null || errorMsg.isEmpty()) {
                errorMsg = e.toString();
            }
            
            String detailedError = String.format("Failed on %s: %s", pageName, errorMsg);
            LOGGER.error("TestRunner Exception for TestCaseID {}: {}", args.get("TestCaseID"), detailedError, e);
            
            // Update results
            overallActualResult = (String) args.getOrDefault("ActualResult", "");
            if (!overallActualResult.contains(detailedError)) {
                overallActualResult += " | " + detailedError;
            }
            
            args.put("ActualResult", overallActualResult);
            args.put("sOutput", detailedError);
            args.put("status", "Fail");
            
            // Write report immediately - FIXED: Wrapped in try-catch
            try {
                UIReportUtils.WriteToExcel(args);
            } catch (Throwable t) {
                LOGGER.error("Error writing report after failure: {}", t.getMessage(), t);
            }
            
            // Rethrow for TestNG failure recognition
            throw new RuntimeException(detailedError, e);
            
        } catch (Throwable handlingError) {
            LOGGER.error("Error in error handling: {}", handlingError.getMessage(), handlingError);
            throw handlingError;
        }
    }

    // --- Resource Cleanup ---
    private void cleanupResources(WebDriver driver, HashMap args) {
        try {
            // Take final screenshot
            if (driver != null) {
                try {
                    CommonUtilities.CaptureScreenshot(args, driver, "Final_State");
                } catch (Exception e) {
                    LOGGER.warn("Failed to capture final screenshot: {}", e.getMessage());
                }
            }
            
            // Quit driver
            if (driver != null) {
                driver.quit();
                LOGGER.info("WebDriver quit successfully");
            }
            
        } catch (Exception e) {
            LOGGER.error("Error during resource cleanup: {}", e.getMessage(), e);
        }
    }

    // --- Helper Methods ---
    private String extractPageNameFromException(Throwable e) {
        String pageName = "UnknownPage";
        if (e.getStackTrace().length > 0) {
            pageName = e.getStackTrace()[0].getClassName();
            if (pageName.contains(".")) {
                pageName = pageName.substring(pageName.lastIndexOf(".") + 1);
            }
        }
        return pageName;
    }
}
