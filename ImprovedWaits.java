package com.web.utils;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
 
public class ImprovedWaits {
    // Wait for page to completely load
    public static void waitForPageLoad(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            System.out.println("Page load timeout - proceeding anyway");
        }
    }
    // Smart element wait with fallback
    public static void smartWait(WebDriver driver, ExtendedWebElement element, int maxWaitSeconds) {
        try {
            // Try standard wait first
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Math.min(maxWaitSeconds, 10)));
            wait.until(ExpectedConditions.elementToBeClickable(element.getElement()));
        } catch (TimeoutException e) {
            // Fallback to page load wait + short pause
            System.out.println("Element not immediately available, trying page load wait: " + element.toString());
            waitForPageLoad(driver);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
