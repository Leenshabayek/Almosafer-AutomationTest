package AlmosaferPackage;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dev.failsafe.Timeout;

public class AlmosaferTestCases extends AlmosaferParameters  {
	
	@BeforeTest
	public void Before_test() throws InterruptedException {
		ConfigrationToAccess(); // function in AlmosaferParameters
	}
	
	@Test(priority=1)
	public void CheckTheDefualtLanguage() {
		String ActualLanguage=	driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);
	}
	
	@Test(priority=2)
	public void CheckTheDefualtCurrency() {
		String ActualCurrency= driver.findElement(By.cssSelector(".sc-dRFtgE.fPnvOO")).getText();
		Assert.assertEquals(ActualCurrency, ExpectedCurrency);
	}
	
	@Test(priority=3)
	public void CheckTheMobileNumber() {
		String ActualMobileNumber= driver.findElement(By.tagName("strong")).getText();
		Assert.assertEquals(ActualMobileNumber, ExpectedMobailNumber);
	}
	

	@Test(priority=4)
	public void CheckQitafLogo() {
		WebElement TheFooter = driver.findElement(By.tagName("footer"));
		WebElement TheDiv = TheFooter.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs"));
		WebElement QitafLogo = TheDiv.findElement(By.tagName("svg"));
		boolean ActualQitafLogoDisplay =QitafLogo.isDisplayed();
		Assert.assertEquals(ActualQitafLogoDisplay, ExpectedQitafLogoDisplay);
	}
	
	@Test(priority=5)
	public void CheckHotelTabNotSelected() {
		WebElement HotelTab=driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualHotelTabSelected= HotelTab.getDomAttribute("aria-selected");
		Assert.assertEquals(ActualHotelTabSelected, ExpectedHotelTabSelected);
	}
	
	@Test(priority=6)
	public void CheckDepartureDate() {
	List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
	String ActualDepartureDate=Dates.get(0).getText();
	Assert.assertEquals(ActualDepartureDate, Tomorrow);
}
	
	@Test(priority=7)
	public void CheckReturnDate() {
		List<WebElement> Dates = driver.findElements(By.cssSelector(".sc-fvLVrH.hNjEjT"));
		String ActualReturnDate=Dates.get(1).getText();
		Assert.assertEquals(ActualReturnDate, AfterTomorrow);
	}
	
	@Test(priority=8)
	public void RandomChangeLanguage() {
		driver.get(URLs[RandomURLsIndex]);
		WebElement HeaderLanguage= driver.findElement(By.xpath("//a[@data-testid='Header__LanguageSwitch']"));// we use xpath cause class not the same when website is arabic or english 
		if(HeaderLanguage.getText().equals("العربية")) {
			String ActualEnglishLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ExpectedEnglishLanguage, ActualEnglishLanguage);
	}
		
	else {
		String ActualArabicLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ExpectedArabicLanguage, ActualArabicLanguage);
	}
		
		//another solution
//		if (driver.getCurrentUrl().contains("en")) {
//			String ActualEnglishLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
//			Assert.assertEquals(ExpectedEnglishLanguage, ActualEnglishLanguage);
//		}
//		else {
//			String ActualArabicLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
//			Assert.assertEquals(ExpectedArabicLanguage, ActualArabicLanguage);
//		}
//	}
	}
	@Test(priority=9)
	public void SwitcToHotelTab() throws InterruptedException {
		WebElement HeaderLanguage= driver.findElement(By.xpath("//a[@data-testid='Header__LanguageSwitch']"));// we use xpath cause class not the same when website is arabic or english 

		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		HotelTab.click();
		
		WebElement SearchCityInput=driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
		if(HeaderLanguage.getText().equals("العربية")) {
			String ActualEnglishLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
			Assert.assertEquals(ExpectedEnglishLanguage, ActualEnglishLanguage);
			SearchCityInput.sendKeys(EnglishCities[RandomURLsIndex]);
			WebElement ListOfCities=driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
			ListOfCities.findElements(By.tagName("li")).get(1).click();
		}
		
	else {
		String ActualArabicLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ExpectedArabicLanguage, ActualArabicLanguage);
		SearchCityInput.sendKeys(ArabicCities[RandomArabisCity]);
		WebElement ListOfCities=driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		ListOfCities.findElements(By.tagName("li")).get(1).click();
		}
		WebElement NumberOfVisitors=driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		Select mySelector=new Select(NumberOfVisitors);
		int RandomIndex= rand.nextInt(2);//theres 2 option
		mySelector.selectByIndex(RandomIndex);
		
		WebElement SearchButton = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
		SearchButton.click();
		Thread.sleep(15000); 	// until the page finish uploading	
	
		WebElement Results = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		System.out.println(Results.getText());
		boolean ActualResult=Results.getText().contains("stays")||Results.getText().contains("مكان");
		Assert.assertEquals(ActualResult, ExcpectedResult);
		
		
	}
	
	
	
}
