package vn.amabuy;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.google.common.base.Predicate;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;

public class MyPageObject extends PageObject {

	public void waitForAWhile(int time) {
		waitABit(time);

	}

	public void swicthToIframe(String nameOrId) {
		getDriver().switchTo().frame(nameOrId);
	}

	protected MyPageObject() {
		super();

	}

	protected MyPageObject(final WebDriver driver, Predicate<? super PageObject> callback) {
		super(driver, callback);

	}

	public MyPageObject(final WebDriver driver, final int ajaxTimeout) {
		super(driver, ajaxTimeout);
	}

	public MyPageObject(final WebDriver driver) {
		super(driver);
	}

	public MyPageObject(final WebDriver driver, final EnvironmentVariables environmentVariables) {
		super(driver, environmentVariables);
	}

	public void highlightElement(WebElementFacade webElement) {

		for (int i = 0; i < 10; i++) {
			evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement,
					"color: red; border: 2px solid red;");
			evaluateJavascript("arguments[0].setAttribute('style', arguments[1]);", webElement, "");
		}
	}

	public void jSClickOn(WebElementFacade webElement) {

		evaluateJavascript("arguments[0].click()", webElement);
	}

	public void scrollTo(WebElementFacade webElement) {

		evaluateJavascript("arguments[0].scrollIntoView(true);", webElement);
	}

	public void cutTextFrom(WebElementFacade webElement, String value) {

		withAction().moveToElement(webElement).click().keyDown(webElement, Keys.SHIFT).sendKeys(webElement, value)
				.keyUp(webElement, Keys.SHIFT).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.keyDown(Keys.CONTROL).sendKeys("x").keyUp(Keys.CONTROL).build().perform();

		waitABit(3000);

	}

	public void pasteTextInto(WebElementFacade webElement) {

		withAction().moveToElement(webElement).click().keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)
				.contextClick().build().perform();
	}

	public void openContentMenu(WebElementFacade webElement, String value) {

		withAction().moveToElement(webElement).click().sendKeys(webElement, value).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).contextClick().build().perform();

		waitABit(3000);

	}

	public void pressItemOnContentMenu(int indexItem) {
		Robot robot;
		try {
			robot = new Robot();
			robot.setAutoDelay(500);
			for (int i = 1; i <= indexItem; i++) {
				robot.keyPress(KeyEvent.VK_DOWN);
			}
			robot.keyPress(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public void selectElementToPaste(WebElementFacade webElement) {

		withAction().moveToElement(webElement).click().contextClick().build().perform();
	}

	/**
	 * This method will set any parameter string to the system's clipboard.
	 */
	private static void setClipboardData(String pathFile) {
		// StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(pathFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFile(String fileLocation) {
		try {
			// Setting clip board with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

}
