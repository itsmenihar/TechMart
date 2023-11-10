package opencart.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import opencart.TestComponents.BaseTest;
import opencart.pageobjects.MyAccountPage;
import opencart.pageobjects.RegistrationPage;

public class RegistrationTest extends BaseTest {

	String successMsg = "Your Account Has Been Created!";
	String errorFeedbackPassword = "Password must be between 4 and 20 characters!";
	String toolTipMsg = "Please include an '@' in the email address";
	String errorFeedbackFirstname = "First Name must be between 1 and 32 characters!";
	String errorFeedbackLastname = "Last Name must be between 1 and 32 characters!";

//Registration valid data
	@Test(dataProvider = "getData")
	public void registrationWithValidData(HashMap<String, String> input) {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		MyAccountPage myAccountPage = registrationPage.registrationToApp(input.get("firstname"), input.get("lastname"),
				input.get("email"), input.get("password"));
		String msg = myAccountPage.getSuccessMsg();
		Assert.assertEquals(msg, successMsg);
	}

	@Test
	public void registrationWithInvalidPassword() {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		registrationPage.registrationToApp("alok", "behera", "alokbehera@gmail.com", "a#3");
		String e_FeedBackPassword = registrationPage.getErrorFeedbackPassword();
		Assert.assertEquals(e_FeedBackPassword, errorFeedbackPassword);

	}

	@Test
	public void registrationWithInvalidEmail() {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		registrationPage.registrationToApp("bikash", "sahu", "bikashsahugmail.com", "bikashsahu#123");
		String validationEmailTooltipMsg = registrationPage.getValidationMsgToolTip();
		Assert.assertTrue(validationEmailTooltipMsg.contains(toolTipMsg));

	}

	@Test
	public void registrationWithInvalidlongPassword() {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		registrationPage.registrationToApp("chakra", "naik", "chakranaik@gmail.com", "chakranaik#123456789123");
		String eFeedbackPassword = registrationPage.getErrorFeedbackPassword();
		Assert.assertEquals(eFeedbackPassword, errorFeedbackPassword);

	}

	@Test
	public void registrationWithoutFirstName() {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		registrationPage.registrationToApp("", "jhon", "admin@gmail.com", "admin#123");
		String errorFeedbackFirstname = registrationPage.getErrorFeedbackFirstName();
		Assert.assertEquals(errorFeedbackFirstname, errorFeedbackFirstname);
	}

	@Test
	public void registrationWithoutLastName() {
		RegistrationPage registrationPage = landingPage.getToRegistrationPage();
		registrationPage.registrationToApp("watson", "", "admin@gmail.com", "admin#123");
		String errorFeedbackLastname = registrationPage.getErrorFeedbackLastName();
		Assert.assertEquals(errorFeedbackLastname, errorFeedbackLastname);
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//opencart//data//Registration.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
