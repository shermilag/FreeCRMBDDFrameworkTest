package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class DealsStepDefinitions {
	
	WebDriver driver;
	
	 @Given("^user is already on Login Page$")
	 public void user_is_already_on_login_page(){
	 System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get("https://www.freecrm.com");
	 }
	
	@When("^title of login page is Free CRM$")
	 public void title_of_login_page_is_free_CRM(){
	 String title = driver.getTitle();
	 System.out.println(title);
	 Assert.assertEquals("Free CRM software in the cloud powers sales and customer service", title);
	 }
	
	@Then("^user enters username and password$")
	public void user_enter_username_and_password(DataTable credentials){
		List<List<String>> data = credentials.raw();
	 driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
	 driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
	 
	}
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() {
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
	
	@Then("^user is on home page$")
	public void user_is_on_home_page() {
		String title = driver.getTitle();
		System.out.println("Home page title::"+title);
		Assert.assertEquals("CRMPRO", title);
	}
	
	@Then("^user moves to new deals page$")
	public void user_moves_to_new_deals_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
	}
	
	@Then("^user enters new deals details$")
	public void user_enters_new_deals_details(DataTable dealdata) {
		List<List<String>> dealValues = dealdata.raw();
	    driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
	    driver.findElement(By.name("client_lookup")).sendKeys(dealValues.get(0).get(1));
	    driver.findElement(By.id("quantity")).sendKeys(dealValues.get(0).get(2));
	    driver.findElement(By.id("tags")).sendKeys(dealValues.get(0).get(3));
	}

	@Then("^close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
