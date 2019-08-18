package vn.amabuy.features.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import vn.amabuy.annotation.CapabilityOption;
import vn.amabuy.steps.AlertSteps;

@RunWith(SerenityRunner.class)
@WithTags({ @WithTag("alert") })
@CapabilityOption
public class WhenCheckMyAnnotation {

	@Managed
	WebDriver driver;

	@Steps
	AlertSteps alertSteps;

	@Test
	@WithTag("annotation")
	public void answer_popup() {
		alertSteps.open_web();
		alertSteps.show_popup();
		alertSteps.answer("Hashing van");
		alertSteps.accept();
	}
}