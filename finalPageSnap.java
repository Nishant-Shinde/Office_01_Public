package com.web.utils;

import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;


import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;




public class finalPageSnap extends AbstractPage {

	public finalPageSnap(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//mat-toolbar[contains(@class,'mat-toolbar pnbToolMat')]")
	private  ExtendedWebElement HeaderFloater;
	
	@FindBy(xpath = "//*[contains(text(),'PROCEED')]")
	private  ExtendedWebElement ProceedFloater;
	
	@FindBy(xpath = "//div[contains(@class,'mat-progress-bar-buffer mat-progress-bar-element')]")
	private  ExtendedWebElement bufferbar2;
	
	@FindBy(xpath = "//div[contains(@class,'mat-progress-bar-primary mat-progress-bar-fill mat-progress-bar-element')]")
	private  ExtendedWebElement bufferbar3;
	
	@FindBy(xpath = "//div[contains(@class,'mat-progress-bar-secondary mat-progress-bar-fill mat-progress-bar-element')]")
	private  ExtendedWebElement bufferbar4;

	@FindBy(xpath = "//*[contains(@class,'mat-progress-bar-background mat-progress-bar-element')]")
	private  ExtendedWebElement bufferbar;
	
	@FindBy(xpath = "//div[contains(@class,'btn_bakgrnd ng-star-inserted')]")
	private  ExtendedWebElement BlankFloater;
 
	public JavascriptExecutor js = (JavascriptExecutor) driver;

	public void hideFloater() {
 
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].style.display='none'", HeaderFloater.getElement());
		js.executeScript("arguments[0].style.display='none'", bufferbar.getElement());
		js.executeScript("arguments[0].style.display='none'", bufferbar2.getElement());
		js.executeScript("arguments[0].style.display='none'", bufferbar3.getElement());
		js.executeScript("arguments[0].style.display='none'", bufferbar4.getElement());
		js.executeScript("arguments[0].style.display='none'", ProceedFloater.getElement());
		js.executeScript("arguments[0].style.display='none'", BlankFloater.getElement());
 
	}
 
	public  void showFloater() {
		js.executeScript("arguments[0].style.display=''", HeaderFloater.getElement());
		js.executeScript("arguments[0].style.display=''", bufferbar.getElement());
		js.executeScript("arguments[0].style.display=''", bufferbar2.getElement());
		js.executeScript("arguments[0].style.display=''", bufferbar3.getElement());
		js.executeScript("arguments[0].style.display=''", bufferbar4.getElement());
		js.executeScript("arguments[0].style.display=''", ProceedFloater.getElement());
		js.executeScript("arguments[0].style.display=''", BlankFloater.getElement());
	}

	public void CaptureScreenshot_New(HashMap<String, String> args, WebDriver oDriver, String pageName) {
			try {
				int iScreenNum;
				iScreenNum = Integer.parseInt(args.get("screenNum")) + 1;
				args.put("screenNum", iScreenNum + "");
				// add 3 leading zeros in this number
				String padded = String.format("%05d", iScreenNum);
				String sPath = "";
				sPath = args.get("screenPath") +"\\" +args.get("Module")+"\\"+args.get("SubModule")+"\\"+ padded + pageName + ".jpg";
				finalPageSnap hide = new finalPageSnap(oDriver);
				hide.hideFloater();
				Thread.sleep(2000);
				Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
						.takeScreenshot(oDriver);
				ImageIO.write(fpScreenshot.getImage(), "JPG", new File(sPath));
				finalPageSnap show = new finalPageSnap(oDriver);
				show.showFloater();
				Thread.sleep(2000);
				
			} catch (Exception e) {
			}

	}
}
