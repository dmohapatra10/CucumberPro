package Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePack.TestBase;

public class AccountPage extends TestBase{
	
	//Web Elements
	
	public AccountPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//body[@onload='startTime()']/nav[@class='navbar navbar-default']/div[@class='container']/div[@id='collapse']/ul[@class='nav navbar-nav navbar-right hidden-sm go-left']/ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']/li[1]/a[1]")
    WebElement AccountDropdown;
	@FindBy(xpath="//a[@href='#bookings']")
	WebElement bookings;
	
	@FindBy(xpath="//a[@href=\"#profile\"]")
	WebElement profileIcon;
	
	@FindBy(xpath="//a[@href=\"#wishlist\"]")
	WebElement wishListIcon;
	
	@FindBy(xpath="//a[@href=\"#newsletter\"]")
	WebElement newsletterIcon;
	
	
	
	
	//Actions
	
	public boolean validate_AccountDropDownInsteadOfLogin()
	{
		
		boolean status =AccountDropdown.isDisplayed();
		
		return status;
		
	}
	
	public boolean check_signIn_ButtonNot_Showing_AfterSignUo()
	{
		boolean status=true;
		
		List<WebElement>li=new ArrayList<WebElement>();
		li=driver.findElements(By.tagName("a"));
		for(WebElement wb:li)
		{
			if(wb.getText().contains("Login"))
			{
				status=false;
			}		
			
		}
		
		return status;	
	}
	
	public boolean check_BookingsIcon_displayed()
	{
		
		boolean status=bookings.isDisplayed();
		
		return status;
	}
	
	public boolean check_ProfileIcon_displayed()
	{
		
		boolean status=profileIcon.isDisplayed();
		
		return status;
	}
	public boolean check_wishListIcon_displayed()
	{
		
		boolean status=wishListIcon.isDisplayed();
		
		return status;
	}
	
	public boolean check_newsLetterIcon_displayed()
	{
		
		boolean status=newsletterIcon.isDisplayed();
		
		return status;
	}

	
}
