package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.pageObjects.HomePage;
import test.java.pageObjects.SearchPage;
import test.java.testBase.BaseClass;

@Test
public class TC_004_SearchProductTest extends BaseClass {

	public void test_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}
