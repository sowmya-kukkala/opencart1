package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") private WebElement msgHeading; // Account Page Heading
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") private WebElement lnkLogout;
	
	public boolean isMyAccountPageExists() // MyAccount page heading display status
	{
		try 
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception ex) 
		{
			return (false);
		}
	}
	
	public void clickLogout() 
	{
		lnkLogout.click();
	}
	
	

}
