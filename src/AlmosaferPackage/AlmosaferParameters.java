package AlmosaferPackage;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AlmosaferParameters {
	// can not create webelement here
	WebDriver driver = new ChromeDriver();
	Random rand = new Random();
	String Almosafer = "https://global.almosafer.com/en";
	String ExpectedLanguage = "en";
	String ExpectedCurrency = "SAR";
	String ExpectedMobailNumber = "+966554400000";
	boolean ExpectedQitafLogoDisplay =true;
	String ExpectedHotelTabSelected="false";
	LocalDate Date = LocalDate.now();
	int Today= Date.getDayOfMonth(); // returns the no. of day 
	//int Tomorrow= Date.plusDays(1).getDayOfMonth(); //add one day for today's date // can't compare int with string in the assert
	String Tomorrow=Integer.toString(Date.plusDays(1).getDayOfMonth());// convert int to string to use in assert
	String AfterTomorrow=Integer.toString(Date.plusDays(2).getDayOfMonth());
	String [] URLs = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	int RandomURLsIndex = rand.nextInt(URLs.length);
	String ExpectedEnglishLanguage="en";
	String ExpectedArabicLanguage="ar";
	String [] EnglishCities = {"Dubai","Jeddah","Riyadh"};
	int RandomEnglishCity=rand.nextInt(EnglishCities.length);
	String [] ArabicCities = {"دبي","جدة"};
	int RandomArabisCity=rand.nextInt(ArabicCities.length);
	boolean ExcpectedResult=true;
	

public void ConfigrationToAccess() {
	driver.get(Almosafer);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	WebElement FirstButton=driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
	FirstButton.click();

}
}