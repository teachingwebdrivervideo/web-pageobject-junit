package vn.amabuy.pages;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.WebElementFacade;
import vn.amabuy.MyPageObject;

public class AlertPage extends MyPageObject {

	@FindBy(xpath = "//button[@onclick='myAlertFunction()']")
	WebElementFacade showAlertButton;

	public void click_show_alert() {
		showAlertButton.click();
		waitABit(5000); // pause to check by manually
	}

	@FindBy(xpath = "//button[@onclick='myConfirmFunction()']")
	WebElementFacade showConfirmButton;

	public void click_show_Confirm() {
		showConfirmButton.click();
		waitABit(5000); // pause to check by manually
	}

	@FindBy(xpath = "//button[@onclick='myPromptFunction()']")
	WebElementFacade showPopupButton;

	public void click_show_Popup() {
		showPopupButton.click();
		waitABit(5000); // pause to check by manually
	}

	public void accept_popup() {
		getAlert().accept();
		waitABit(5000); // pause to check by manually
	}

	public void cancel_popup() {
		getAlert().dismiss();
		waitABit(5000); // pause to check by manually
	}

	public void answer_popup(String answer) {
		getAlert().sendKeys(answer);
		waitABit(5000); // pause to check by manually
	}

	public void wait_For_Alert() {
		new WebDriverWait(getDriver(), 60).ignoring(NoAlertPresentException.class)
				.until(ExpectedConditions.alertIsPresent());
	}
}