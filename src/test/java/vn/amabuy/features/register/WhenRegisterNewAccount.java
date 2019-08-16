package vn.amabuy.features.register;

import org.jetbrains.annotations.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.UseTestDataFrom;
import vn.amabuy.models.Account;
import vn.amabuy.steps.HomeSteps;
import vn.amabuy.steps.LoginSteps;
import vn.amabuy.steps.RegisterSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "testdata/accounts/user-info.csv")
public class WhenRegisterNewAccount {

	@Nullable
	private String fullName;

	@Nullable
	private String email;

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Managed
	WebDriver driver;

	@Steps
	HomeSteps jacob;

	@Steps
	LoginSteps loginSteps;

	@Steps
	RegisterSteps registerSteps;

	String errMsg = "Mật khẩu xác nhận không chính xác";

	@Test
	@WithTag("register")
	public void a_register_new_account_with_incorrect_password() {

		Account infor = Account.named(fullName)
				.withEmail(email)
				.withPhone("0984303104")
				.withPassword("teaching webdriver online")
				.withConfirmPassword("learning online")
				.build();

		jacob.visit_application();
		jacob.click_on_login_link();

		loginSteps.click_on_register_link();

		registerSteps.register_new_account_with(infor);
		registerSteps.should_see_warning_error_message_correct(errMsg);

	}

}
