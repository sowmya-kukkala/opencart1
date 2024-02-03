package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	WebDriver driver;
	
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (name="firstname") private WebElement txtFirstname;
	
	@FindBy (id="input-lastname") private WebElement txtLastname;
	
	@FindBy (name= "email") private WebElement txtEmail;
	
	@FindBy (id= "input-telephone") private WebElement txtTelephone;
	
	@FindBy (xpath="//input[@id='input-password']") private WebElement txtPassword;
	
	@FindBy (xpath="//input[@id='input-confirm']") private WebElement txtConfirmPassword;
	
	@FindBy (xpath="//input[@name='agree']") private WebElement chkPolicy;
	
	@FindBy(xpath="//input[@value='Continue']") private WebElement btnContinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") private WebElement msgConfirmation;
	
	public void setFirstName(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String tel) 
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd) 
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) 
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy() 
	{
		chkPolicy.click();
	}
	
	public void clickContinue() 
	{
		// sol1
		btnContinue.click();
		
		// sol2
//		btnContinue.submit();
		
		// sol3
//		Actions act = new Actions(driver);
//		act.moveToElement(btnContinue).click().perform();
		
		// sol4
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", btnContinue);
		
		// sol5
//		btnContinue.sendKeys(Keys.RETURN);
		
		// sol6
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
	}
	
	public String getConfirmationMsg() 
	{
		try 
		{
			return(msgConfirmation.getText());
		}
		catch(Exception e) 
		{
			return (e.getMessage());
		}
	}
	

}
