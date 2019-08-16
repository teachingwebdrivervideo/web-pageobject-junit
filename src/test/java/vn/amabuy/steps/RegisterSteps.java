package vn.amabuy.steps;

import static org.assertj.core.api.Assertions.assertThat;

import net.thucydides.core.annotations.Step;
import vn.amabuy.models.Account;
import vn.amabuy.pages.RegisterPage;

public class RegisterSteps {

	RegisterPage onRegisterPage;
	
	@Step
	public void register_new_account_with(Account account) {
		
		enter_full_name(account.getFullName());
		enter_email_address(account.getEmail());
		enter_phone_number(account.getPhone());
		enter_password(account.getPassword());
		enter_confirm_password(account.getRePassword());
		click_on_register_button();

	}

	@Step 
	public void click_on_register_button() {
		onRegisterPage.clickOnRegisterButton();
	}

	@Step
	public void enter_confirm_password(String confirmPwd) {
		onRegisterPage.enterTextIntoConfirmPassword(confirmPwd);
	}

	@Step
	private void enter_password(String pwd) {
		onRegisterPage.enterTextIntoPassword(pwd);
	}

	@Step
	public void enter_phone_number(String phone) {
		onRegisterPage.enterTextIntoPhone(phone);
	}

	@Step
	public void enter_email_address(String email) {
		onRegisterPage.enterTextIntoEmail(email);

	}

	@Step
	public void enter_full_name(String fullName) {
		onRegisterPage.enterTextIntoFullName(fullName);
	}

	@Step
	public void should_see_warning_error_message_correct(String expectedErrMsg) {
		String actualErrMsg = onRegisterPage.getWarningErrMesg();

		assertThat(expectedErrMsg).isEqualTo(actualErrMsg);
		
	}

}
