package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import test.java.pageObjects.AccountRegistrationPage;
import test.java.pageObjects.HomePage;
import test.java.testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added)
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("Clicked on My account link");
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String email = faker.internet().safeEmailAddress();
		String email_1 = firstName+lastName+"123@example.com";
		String phoneno = faker.phoneNumber().cellPhone();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(firstName.toUpperCase());

		regpage.setLastName(lastName.toUpperCase());

		//regpage.setEmail(email);// randomly generated the email
		regpage.setEmail(email_1);
		
		regpage.setTelephone(phoneno);

		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		System.out.println(email_1);
		System.out.println(password);
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");		
	}
}