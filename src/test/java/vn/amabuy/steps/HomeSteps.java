package vn.amabuy.steps;

import net.thucydides.core.annotations.Step;
import vn.amabuy.pages.HomePage;

public class HomeSteps {
	
	HomePage onHomepage;
	
	@Step
	public void visit_application() {
		onHomepage.open();
		
	}
	
	@Step
	public void click_on_login_link() {
		onHomepage.clickOnLoginLink();
	}
	
}
