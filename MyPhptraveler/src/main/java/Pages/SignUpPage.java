package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import BasePack.TestBase;

public class SignUpPage extends TestBase{

	public SignUpPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  AccountPage aPage;
    public Actions action;
	
	@FindBy(xpath="//div/ul/li[@id=\"li_myaccount\"]/a[@class=\"dropdown-toggle go-text-right\"]")
	WebElement MyAccountBtn;
	@FindBy(css="nav.navbar.navbar-default:nth-child(4) div.container div.collapse.navbar-collapse ul.nav.navbar-nav.navbar-right.hidden-sm.go-left:nth-child(2) ul.nav.navbar-nav.navbar-side.navbar-right.sidebar.go-left.user_menu li.open:nth-child(1) ul.dropdown-menu li:nth-child(2) > a.go-text-right")
	WebElement signUplink;
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstname;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastname;
	@FindBy(xpath="//input[@placeholder='Mobile Number']")
	WebElement mobNo;
	@FindBy(xpath="//input[@placeholder='Email']")
	WebElement email;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	@FindBy(xpath="//input[@placeholder='Confirm Password']")
	WebElement confirmPass;
	@FindBy(xpath="//button[@type=\"submit\" and @class=\"signupbtn btn_full btn btn-action btn-block btn-lg\"]")
	WebElement signUPButton;
	
	
	//Action methods
	
	
	public boolean check_SignUpButton_Visibility()
	{
		
		boolean status=signUPButton.isDisplayed();
		
		return status;	
		
	}
	
	public void signUp(String firstName, String lastName,String MobNo,String Email,String pass,String confirmpass) throws InterruptedException
	{
		
		action.moveToElement(MyAccountBtn).click().build().perform();
		signUplink.click();
		Thread.sleep(2000);
		firstname.sendKeys(firstName);
		lastname.sendKeys(lastName);
		mobNo.sendKeys(MobNo);
		email.sendKeys(Email);
		password.sendKeys(pass);
		confirmPass.sendKeys(confirmpass);
		signUPButton.click();
			
	}
	
	public boolean validate_SignUp_Status()
	{
		
		boolean usernameStatus=driver.findElement(By.xpath("//h3[contains(text(),"+firstname+")]")).isDisplayed();
		
		return usernameStatus;
		
	}
	
	
	public String validateTitle()
	{
		
		String title=driver.getTitle();
		
		return title;
		
	}
	
	
	
	
	
	
	
	
	

}
