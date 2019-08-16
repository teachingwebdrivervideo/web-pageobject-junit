package vn.amabuy.pages;

import vn.amabuy.MyPageObject;

public class RegisterPage extends MyPageObject {

	private static final String ALERT_DANGER_TEXT = "//div[@class='alert alert-danger text-center']";
	private static final String CONFIRM_PASS_FIELD = "Nhập lại mật khẩu";
	private static final String PASSWORD_FIELD = "Mật khẩu";
	private static final String PHONE_FIELD = "Số điện thoại";
	private static final String EMAIL_ADDRESS_FIELD = "Địa chỉ Email";
	private static final String FULLNAME_FIELD = "Họ và tên";

	public void enterTextIntoFullName(String fullName) {
		element(Target.of(FULLNAME_FIELD)).type(fullName);
	}

	public void enterTextIntoEmail(String emailAddress) {
		element(Target.of(EMAIL_ADDRESS_FIELD)).type(emailAddress);
	}

	public void enterTextIntoPhone(String phoneNumber) {
		element(Target.of(PHONE_FIELD)).type(phoneNumber);
	}

	public void enterTextIntoPassword(String pwd) {
		element(Target.of(PASSWORD_FIELD)).type(pwd);
	}

	public void enterTextIntoConfirmPassword(String pwd) {
		element(Target.of(CONFIRM_PASS_FIELD)).type(pwd);
	}

	static class Target {
		private static final String TARGET = "//label[contains(text(),'%s')]/following-sibling::input";
		public static String of(String label) {
			return String.format(TARGET, label);
		}
	}

	public String getWarningErrMesg() {
		return $(ALERT_DANGER_TEXT).getText();
	}

	public void clickOnRegisterButton() {
		$("//button[text()='Đăng ký']").click();

	}

}
