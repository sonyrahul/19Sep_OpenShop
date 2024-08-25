package testCases;

import org.testng.annotations.Test;

import test.java.pageObjects.HomePage;
import test.java.testBase.BaseClass;

public class TC_004_Search extends BaseClass{

	@Test(groups= {"Edge"})
	public void test1()
	{
		System.out.println("First browser");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
	}
	
	@Test(groups= {"Chrome"})
	public void test2()
	{
		System.out.println("Second browser");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();

	}
}